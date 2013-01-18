/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.OrganisationUnitList;
import gr.ekt.cerif.entities.base.OrganisationUnitView;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitPostalAddressRepository;
import gr.ekt.cerif.services.link.person.LinkPersonOrganisationUnitRepository;
import gr.ekt.cerif.services.link.project.LinkProjectOrganisationUnitRepository;
import gr.ekt.cerif.services.multilingual.OrganisationUnitNameRepository;
import gr.ekt.cerif.services.second.PostalAddressRepository;
import gr.ekt.cerif.services.second.SecondPersistenceService;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * 
 */
@Component
public class OrganisationUnitRepositoryImpl implements OrganisationUnitRepository {
	
	private static final Logger log = LoggerFactory.getLogger(OrganisationUnitRepositoryImpl.class);
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private OrganisationUnitCrudRepository organisationUnitCrudRepository;
	
	@Autowired
	private OrganisationUnitNameRepository organisationUnitNameRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private LinkPersonOrganisationUnitRepository linkPersonOrganisationUnitRepository;
	
	@Autowired
	private LinkProjectOrganisationUnitRepository linkProjectOrganisationUnitRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PostalAddressRepository postalAddressRepository;
	
	@Autowired
	private SecondPersistenceService secondService;
	
	@Autowired
	private LinkOrganisationUnitPostalAddressRepository linkOrganisationUnitPostalAddressRepository;
	
	@Transactional
	public OrganisationUnit save(OrganisationUnit organisation) {
		if (StringUtils.hasText(organisation.getUri())) {
			OrganisationUnit alreadyStored = findByUri(organisation.getUri());
			if (alreadyStored != null) {
				organisation.setId(alreadyStored.getId());
			}
		}
		return entityManager.merge(organisation);
	}

	@Transactional
	public OrganisationUnit updatePersonsByRole(Long organisationUnitId, List<Long> newPersonIds, String classUri) {
		if (newPersonIds != null && newPersonIds.size() > 0) {
			log.info("Updating organisation unit for organisation unit id " + organisationUnitId + " for " + newPersonIds + " persons and role " + classUri);
		} else {
			log.info("Updating organisation unit for organisation unit id " + organisationUnitId + " for NO persons and role " + classUri);
		}
		OrganisationUnit orgUnit = organisationUnitCrudRepository.findById(organisationUnitId);
		Class theClass = classRepository.findByUri(classUri);
		
		List<Person_OrganisationUnit> existingPersonList = linkPersonOrganisationUnitRepository.findByOrganisationUnitAndTheClass(orgUnit, theClass);
		ArrayList<Long> existingPersonIdList = new ArrayList<Long>();
		for (Person_OrganisationUnit po : existingPersonList) {
			log.info("Found existing person " + po.getPerson().getId());
			existingPersonIdList.add(po.getPerson().getId());
		}
		
		//save the new ones
		if (newPersonIds != null) {
			for (Long newPersonId  : newPersonIds) {
				if (!existingPersonIdList.contains(newPersonId)) {
					Person person = personRepository.findPersonById(newPersonId);
					Person_OrganisationUnit po = new Person_OrganisationUnit(person, orgUnit, theClass, new Date(), new Date(), (double) 0);
					linkPersonOrganisationUnitRepository.save(po);
				}
			}
		}
		
		//remove the old ones
		if (existingPersonIdList != null) {
			for (Long existingPersonId : existingPersonIdList) {
				if (newPersonIds == null || !newPersonIds.contains(existingPersonId)) {
					Person person = personRepository.findPersonById(existingPersonId);
					Person_OrganisationUnit po = linkPersonOrganisationUnitRepository.findByOrganisationUnitAndPerson(orgUnit, person);
					log.info("deleting person_organisation with id " + po.getId());
					linkPersonOrganisationUnitRepository.delete(po);
				}
			}
		}
		
		return orgUnit;
	}
	
	@Transactional
	public OrganisationUnit updateOrganisationUnitName (Long organisationUnitId, String name) {
		OrganisationUnit orgUnit = organisationUnitCrudRepository.findById(organisationUnitId);
		
		OrganisationUnitName orgUnitName = organisationUnitNameRepository.findByOrganisationUnit(orgUnit);
		if (orgUnitName != null) {
			orgUnitName.setName(name);
			orgUnitName = organisationUnitNameRepository.save(orgUnitName);
		} else {
			orgUnitName = new OrganisationUnitName();
			orgUnitName.setLanguage(Language.ENGLISH);
			orgUnitName.setName(name);
			orgUnitName.setTranslation(Translation.HUMAN);
			orgUnitName.setOrganisationUnit(orgUnit);
			organisationUnitNameRepository.save(orgUnitName);
		}
		
		return orgUnit;
	}
	
	@Transactional
	public OrganisationUnit updateProjectsByRelation(Long organisationUnitId, List<Long> newPartnerProjectIds, String classUri) {
		log.info("Updating organisation unit with id " + organisationUnitId + " for partner projects " + newPartnerProjectIds + " and relation " + classUri);
		OrganisationUnit organisationUnit = organisationUnitCrudRepository.findById(organisationUnitId);
		Class theClass = classRepository.findByUri(classUri);
		
		List<Project_OrganisationUnit> existingPartnerProjectList = linkProjectOrganisationUnitRepository.findByOrganisationUnitAndTheClass(organisationUnit, theClass);
		ArrayList<Long> existingPartnerProjectIdList = new ArrayList<Long>();
		for (Project_OrganisationUnit po : existingPartnerProjectList) {
			existingPartnerProjectIdList.add(po.getProject().getId());
		}
		
		//save the new ones
		if (newPartnerProjectIds != null) {
			for (Long newPartnerProjectId  : newPartnerProjectIds) {
				if (!existingPartnerProjectIdList.contains(newPartnerProjectId)) {
					Project project = projectRepository.findById(newPartnerProjectId);
					Project_OrganisationUnit po = new Project_OrganisationUnit(project, organisationUnit, theClass, new Date(), new Date(), (double) 0);
					linkProjectOrganisationUnitRepository.save(po);
				}
			}
		}
		
		//remove the old ones
		if (existingPartnerProjectIdList != null) {
			for (Long existingPartnerProjectId : existingPartnerProjectIdList) {
				if (newPartnerProjectIds == null || !newPartnerProjectIds.contains(existingPartnerProjectId)) {
					Project project = projectRepository.findById(existingPartnerProjectId);
					Project_OrganisationUnit po = linkProjectOrganisationUnitRepository.findByProjectAndOrganisationUnit(project, organisationUnit);
					linkProjectOrganisationUnitRepository.delete(po);
				}
			}
		}
		return organisationUnit;
	}
	
	@Transactional
	public OrganisationUnit updatePartnerProjects(Long organisationUnitId, List<Long> newPartnerProjectIds) {
		return updateProjectsByRelation(organisationUnitId, newPartnerProjectIds, "Partner");
	}
	
	@Transactional
	public OrganisationUnit updateCoordinatorProjects(Long organisationUnitId, List<Long> newCoordinatorProjectIds) {
		return updateProjectsByRelation(organisationUnitId, newCoordinatorProjectIds, "Coordinator");
	}
	
	@Transactional
	public OrganisationUnit updatePostalAddress(Long organisationUnitId, String address, String countryCode) {
		OrganisationUnit organisationUnit = organisationUnitCrudRepository.findById(organisationUnitId);
		PostalAddress orgUnitPostalAddress = postalAddressRepository.findByOrganisationUnit(organisationUnit);
		Class myClass = classRepository.findByUri("Partner");
		Country country = secondService.getCountryRepository().findByCode(countryCode);

		if (orgUnitPostalAddress == null) {
			orgUnitPostalAddress = new PostalAddress();
		}
		orgUnitPostalAddress.setAddressLine1(address);
		orgUnitPostalAddress.setCountry(country);
		orgUnitPostalAddress = (PostalAddress) postalAddressRepository.save(orgUnitPostalAddress);
		
		List<OrganisationUnit_PostalAddress> opas = linkOrganisationUnitPostalAddressRepository.findByOrganisationUnit(organisationUnit);
		
		OrganisationUnit_PostalAddress opa = new OrganisationUnit_PostalAddress();
		
		if (opas != null && opas.size() > 0) {
			opa = opas.get(0);
		} else {
			opa = new OrganisationUnit_PostalAddress();
		}
		
		opa.setOrganisationUnit(organisationUnit);
		opa.setPostalAddress(orgUnitPostalAddress);
		opa.setStartDate(new Date());
		opa.setEndDate(new Date());
		opa.setTheClass(myClass);
		opa = (OrganisationUnit_PostalAddress) linkOrganisationUnitPostalAddressRepository.save(opa);

		organisationUnit.setPostalAddresses(new HashSet<OrganisationUnit_PostalAddress>(Arrays.asList(opa)));
		
		log.info("Updated postal address for organisation unit with id " + organisationUnit.getId());
		return (OrganisationUnit) save(organisationUnit);
	}
	
	@Transactional
	public Iterable<OrganisationUnit> save(Iterable<OrganisationUnit> entities) {
		for (OrganisationUnit organisation : entities) {
			save(organisation);
		}
		return entities;
	}
	
	public OrganisationUnit findById(Long id) {
		return organisationUnitCrudRepository.findById(id);
	}
	
	public OrganisationUnit findByUri(String uri) {
		return organisationUnitCrudRepository.findByUri(uri);
	}

	public OrganisationUnit findByAcronym(String acronym) {
		return organisationUnitCrudRepository.findByAcronym(acronym);
	}
	
	public OrganisationUnit findByOrganisationUnitName(String organisationUnitName) {
		return organisationUnitCrudRepository.findByOrganisationUnitName(organisationUnitName);
	}
	
	public OrganisationUnit findByOrganisationUnitNameAndOrgUri(String organisationUnitName, String orgUri) {
		return organisationUnitCrudRepository.findByOrganisationUnitNameAndOrgUri(organisationUnitName, orgUri);
	}

	public OrganisationUnit findByOrganisationUnitNameAndCountryCode(String organisationUnitName, String countryCode) {
		return organisationUnitCrudRepository.findByOrganisationUnitNameAndCountryCode(organisationUnitName, countryCode);
	}

	public OrganisationUnitName findByOrganisationUnitName2(String organisationUnitName) {
		return organisationUnitCrudRepository.findByOrganisationUnitName2(organisationUnitName);
	}

	public OrganisationUnitName findOrganisationUnitNamesById(Long id) {
		return organisationUnitCrudRepository.findOrganisationUnitNamesById(id);
	}

	public List<OrganisationUnitView> findOrganisationUnitsByProjectId(Long Id) {
		return organisationUnitCrudRepository.findOrganisationUnitsByProjectId(Id);
	}

	public List<OrganisationUnitView> findOrganisationUnitsByProjectId(Long Id, String organisationStatus) {
		return organisationUnitCrudRepository.findOrganisationUnitsByProjectId(Id, organisationStatus);
	}

	public List<OrganisationUnitView> findAllOrgs() {
		return organisationUnitCrudRepository.findAllOrgs();
	}

	public List<OrganisationUnitView> findFavouriteOrgs(Long id) {
		return organisationUnitCrudRepository.findFavouriteOrgs(id);
	}

	public OrganisationUnitView findOrgById(Long id) {
		return organisationUnitCrudRepository.findOrgById(id);
	}

	public List<OrganisationUnitList> findByPersonId(Long Id) {
		return organisationUnitCrudRepository.findByPersonId(Id);
	}

	public List<OrganisationUnitList> findOrganisationUnitsByCountryCode(String code) {
		return organisationUnitCrudRepository.findOrganisationUnitsByCountryCode(code);
	}

	public List<OrganisationUnitList> findCountryCodesForOrganisationUnits() {
		return organisationUnitCrudRepository.findCountryCodesForOrganisationUnits();
	}

	public List<OrganisationUnitList> findRINCP() {
		return organisationUnitCrudRepository.findRINCP();
	}

	public List<OrganisationUnitList> findRIPolicyBody() {
		return organisationUnitCrudRepository.findRIPolicyBody();
	}

	public List<OrganisationUnitList> findOtherSource() {
		return organisationUnitCrudRepository.findOtherSource();
	}

	public List<OrganisationUnitList> findEuropeanCommission() {
		return organisationUnitCrudRepository.findEuropeanCommission();
	}

	public List<OrganisationUnitList> findAllSources() {
		return organisationUnitCrudRepository.findAllSources();
	}

	public List<Object[]> findAllOrgsForAjax(String term) {
		return organisationUnitCrudRepository.findAllOrgsForAjax(term);
	}

	public Object[] findOrgByIdForAjax(Long id) {
		return organisationUnitCrudRepository.findOrgByIdForAjax(id);
	}
	
	@Transactional
	public void delete(OrganisationUnit entity) {
		organisationUnitCrudRepository.delete(entity);
	}

	public Iterable<OrganisationUnit> findAll() {
		return organisationUnitCrudRepository.findAll();
	}

}

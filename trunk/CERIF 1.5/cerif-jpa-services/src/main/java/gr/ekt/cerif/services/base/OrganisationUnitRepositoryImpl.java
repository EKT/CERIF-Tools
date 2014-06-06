/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitClassRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitElectronicAddressRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitFacilityRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitPostalAddressRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitResultPublicationRepository;
import gr.ekt.cerif.services.link.person.LinkPersonOrganisationUnitRepository;
import gr.ekt.cerif.services.link.project.LinkProjectOrganisationUnitRepository;
import gr.ekt.cerif.services.multilingual.organisationunit.OrganisationUnitNameRepository;
import gr.ekt.cerif.services.second.ElectronicAddressRepository;
import gr.ekt.cerif.services.second.PostalAddressRepository;
import gr.ekt.cerif.services.second.SecondPersistenceService;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 */
@Component
public class OrganisationUnitRepositoryImpl implements OrganisationUnitRepository {
	
	private static final Logger log = LoggerFactory.getLogger(OrganisationUnitRepositoryImpl.class);
	
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
	private ElectronicAddressRepository electronicAddressRepository;
	
	@Autowired
	private SecondPersistenceService secondService;
	
	@Autowired
	private LinkOrganisationUnitPostalAddressRepository linkOrganisationUnitPostalAddressRepository;
	
	@Autowired
	private LinkOrganisationUnitElectronicAddressRepository linkOrganisationUnitElectronicAddressRepository;
	
	@Autowired
	private LinkOrganisationUnitResultPublicationRepository linkOrganisationUnitResultPublicationRepository;
	
	@Autowired
	private LinkOrganisationUnitClassRepository linkOrganisationUnitClassRepository;
	
	@Autowired
	private LinkOrganisationUnitFacilityRepository linkOrganisationUnitFacilityRepository;

	@Transactional
	public OrganisationUnit save(OrganisationUnit organisation) {
		return organisationUnitCrudRepository.save(organisation);
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

	
	@Transactional
	public void delete(OrganisationUnit entity) {
		List<OrganisationUnit_PostalAddress> oup = linkOrganisationUnitPostalAddressRepository.findByOrganisationUnit(entity);
		if (oup != null) linkOrganisationUnitPostalAddressRepository.delete(oup);
		entity.setOrganisationUnits_postalAddresses(null);
		
		List<PostalAddress> lpa = postalAddressRepository.findByOrganisationUnit(entity);
		if (lpa!=null) {
			if (!lpa.isEmpty()) {
				postalAddressRepository.delete(lpa.get(0));
			}
		}
		
		List<OrganisationUnit_ElectronicAddress> oue = linkOrganisationUnitElectronicAddressRepository.findByOrganisationUnit(entity);
		if (oue != null) linkOrganisationUnitElectronicAddressRepository.delete(oue);
		entity.setOrganisationUnits_electronicAddresses(null);
		
		List<ElectronicAddress> ea = electronicAddressRepository.findByOrganisationUnit(entity);
		if (ea != null) electronicAddressRepository.delete(ea);
		
		List<OrganisationUnitName> oun = organisationUnitNameRepository.findByOrganisationUnit(entity);
		if (oun != null) organisationUnitNameRepository.delete(oun);

		List<Person_OrganisationUnit> po = linkPersonOrganisationUnitRepository.findByOrganisationUnit(entity);
		if (po != null) linkPersonOrganisationUnitRepository.delete(po);
		entity.setPersons_organisationUnits(null);
		
		List<Project_OrganisationUnit> pro = linkProjectOrganisationUnitRepository.findByOrganisationUnit(entity);
		if (pro != null) linkProjectOrganisationUnitRepository.delete(pro);
		entity.setProjects(null);

		List<OrganisationUnit_ResultPublication> ourp = linkOrganisationUnitResultPublicationRepository.findByOrganisationUnit(entity);
		if (ourp != null) linkOrganisationUnitResultPublicationRepository.delete(ourp);
		entity.setOrganisationUnits_resultPublications(null);
		
		List<OrganisationUnit_Class> ouc = linkOrganisationUnitClassRepository.findByOrganisationUnit(entity);
		if (ouc != null) linkOrganisationUnitClassRepository.delete(ouc);
		entity.setClasses(null);

		List<OrganisationUnit_Facility> ouf = linkOrganisationUnitFacilityRepository.findByOrganisationUnit(entity);
		if (ouf != null) linkOrganisationUnitFacilityRepository.delete(ouf);
		
		entity = organisationUnitCrudRepository.save(entity);
		organisationUnitCrudRepository.delete(entity);
	}

	public Iterable<OrganisationUnit> findAll() {
		return organisationUnitCrudRepository.findAll();
	}
	
	
	public List<OrganisationUnit> findById(List<Long> ids) {
		return organisationUnitCrudRepository.findById(ids);
	}

	@Override
	public void delete(Iterable<OrganisationUnit> entities) {
		organisationUnitCrudRepository.delete(entities);		
	}

	@Override
	public Page<OrganisationUnit> findAll(Pageable page) {
		return organisationUnitCrudRepository.findAll(page);
	}

	@Override
	public OrganisationUnit findByUUID(String uuid) {
		return organisationUnitCrudRepository.findByUuid(uuid);
	}


}

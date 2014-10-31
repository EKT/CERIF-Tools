/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.ClassScheme_OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Equipment;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Event;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ExpertiseAndSkills;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Funding;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Indicator;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Measurement;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Medium;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Prize;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPatent;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Service;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.multilingual.OrganisationUnitKeyword;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitResearchActivity;
import gr.ekt.cerif.services.link.classscheme.LinkClassSchemeOrganisationUnitRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitClassRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitElectronicAddressRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitEquipmentRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitEventRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitExpertiseAndSkillsRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitFacilityRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitFundingRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitIndicatorRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitMeasurementRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitMediumRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitOrganisationUnitRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitPostalAddressRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitPrizeRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitResultPatentRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitResultProductRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitResultPublicationRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitServiceRepository;
import gr.ekt.cerif.services.link.person.LinkPersonOrganisationUnitRepository;
import gr.ekt.cerif.services.link.project.LinkProjectOrganisationUnitRepository;
import gr.ekt.cerif.services.multilingual.organisationunit.OrganisationUnitKeywordRepository;
import gr.ekt.cerif.services.multilingual.organisationunit.OrganisationUnitNameRepository;
import gr.ekt.cerif.services.multilingual.organisationunit.OrganisationUnitResearchActivityRepository;
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
	private OrganisationUnitKeywordRepository keywordRepository;
	
	@Autowired
	private OrganisationUnitResearchActivityRepository researchActivityRepository;
	
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
	private LinkOrganisationUnitResultPatentRepository linkOrganisationUnitResultPatentRepository;
	
	@Autowired
	private LinkOrganisationUnitClassRepository linkOrganisationUnitClassRepository;
	
	@Autowired
	private LinkOrganisationUnitFacilityRepository linkOrganisationUnitFacilityRepository;
	
	@Autowired
	private LinkOrganisationUnitFundingRepository linkOrganisationUnitFundingRepository;
	
	@Autowired
	private LinkOrganisationUnitEquipmentRepository linkOrganisationUnitEquipmentRepository;
	
	@Autowired
	private LinkOrganisationUnitEventRepository linkOrganisationUnitEventRepository;
	
	@Autowired
	private LinkOrganisationUnitIndicatorRepository linkOrganisationUnitIndicatorRepository;
	
	@Autowired
	private LinkOrganisationUnitMeasurementRepository linkOrganisationUnitMeasurementRepository;
	
	@Autowired
	private LinkOrganisationUnitMediumRepository linkOrganisationUnitMediumRepository;
	
	@Autowired
	private LinkOrganisationUnitOrganisationUnitRepository linkOrganisationUnitOrganisationUnitRepository;
	
	@Autowired
	private LinkOrganisationUnitPrizeRepository linkOrganisationUnitPrizeRepository;
	
	@Autowired
	private LinkOrganisationUnitExpertiseAndSkillsRepository linkOrganisationUnitExpertiseAndSkillsRepository;
	
	@Autowired
	private LinkOrganisationUnitResultProductRepository linkOrganisationUnitResultProductRepository;
	
	@Autowired
	private LinkOrganisationUnitServiceRepository linkOrganisationUnitServiceRepository;
	
	@Autowired
	private LinkClassSchemeOrganisationUnitRepository linkClassSchemeOrganisationUnitRepository;

	@Override
	@Transactional
	public OrganisationUnit save(OrganisationUnit organisation) {
		return organisationUnitCrudRepository.save(organisation);
	}

	@Override
	@Transactional
	public Iterable<OrganisationUnit> save(Iterable<OrganisationUnit> entities) {
		return organisationUnitCrudRepository.save(entities);
	}
	
	@Override
	public OrganisationUnit findById(Long id) {
		return organisationUnitCrudRepository.findById(id);
	}
	
	@Override
	public OrganisationUnit findByUri(String uri) {
		return organisationUnitCrudRepository.findByUri(uri);
	}

	@Override
	public OrganisationUnit findByAcronym(String acronym) {
		return organisationUnitCrudRepository.findByAcronym(acronym);
	}
	

	@Override
	@Transactional
	public void delete(OrganisationUnit entity) {
		List<OrganisationUnit_PostalAddress> oup = linkOrganisationUnitPostalAddressRepository.findByOrganisationUnit(entity);
		List<PostalAddress> lpa = postalAddressRepository.findByOrganisationUnit(entity);
		if (oup != null) linkOrganisationUnitPostalAddressRepository.delete(oup);
		entity.setOrganisationUnits_postalAddresses(null);		

		List<OrganisationUnit_ElectronicAddress> oue = linkOrganisationUnitElectronicAddressRepository.findByOrganisationUnit(entity);
		List<ElectronicAddress> ea = electronicAddressRepository.findByOrganisationUnit(entity);
		if (oue != null) linkOrganisationUnitElectronicAddressRepository.delete(oue);
		entity.setOrganisationUnits_electronicAddresses(null);	
		
		List<OrganisationUnitName> oun = organisationUnitNameRepository.findByOrganisationUnit(entity);
		if (oun != null) organisationUnitNameRepository.delete(oun);
		entity.setOrganisationUnitNames(null);

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
		entity.setOrganisationUnits_facilities(null);
		
		List<OrganisationUnit_Funding> oufun = linkOrganisationUnitFundingRepository.findByOrganisationUnit(entity);
		if (oufun != null) linkOrganisationUnitFundingRepository.delete(oufun);
		entity.setOrganisationUnits_fundings(null);
		
		List<OrganisationUnitKeyword> keys = keywordRepository.findByOrganisationUnit(entity);
		if (keys != null) keywordRepository.delete(keys);
		entity.setOrganisationUnitKeywords(null);
		
		List<OrganisationUnitResearchActivity> resAct = researchActivityRepository.findByOrganisationUnit(entity);
		if (resAct != null) researchActivityRepository.delete(resAct);
		entity.setOrganisationUnitResearchActivities(null);
		
		List<OrganisationUnit_Equipment> equip = linkOrganisationUnitEquipmentRepository.findByOrganisationUnit(entity);
		if (equip != null) linkOrganisationUnitEquipmentRepository.delete(equip);
		entity.setOrganisationUnits_equipments(null);
		
		List<OrganisationUnit_Event> events = linkOrganisationUnitEventRepository.findByOrganisationUnit(entity);
		if (events != null) linkOrganisationUnitEventRepository.delete(events);
		entity.setOrganisationUnits_events(null);
		
		List<OrganisationUnit_Indicator> indi = linkOrganisationUnitIndicatorRepository.findByOrganisationUnit(entity);
		if (indi != null) linkOrganisationUnitIndicatorRepository.delete(indi);
		entity.setOrganisationUnits_indicators(null);
		
		List<OrganisationUnit_Measurement> meas = linkOrganisationUnitMeasurementRepository.findByOrganisationUnit(entity);
		if (meas != null) linkOrganisationUnitMeasurementRepository.delete(meas);
		entity.setOrganisationUnits_measurements(null);
		
		List<OrganisationUnit_Medium> mediums = linkOrganisationUnitMediumRepository.findByOrganisationUnit(entity);
		if (mediums != null) linkOrganisationUnitMediumRepository.delete(mediums);
		entity.setOrganisationUnits_mediums(null);
		
		List<OrganisationUnit_OrganisationUnit> orgs1 = linkOrganisationUnitOrganisationUnitRepository.findByOrganisationUnit1(entity);
		if (orgs1 != null) linkOrganisationUnitOrganisationUnitRepository.delete(orgs1);
		entity.setOrganisationUnits_organisationUnits1(null);
		
		List<OrganisationUnit_OrganisationUnit> orgs2 = linkOrganisationUnitOrganisationUnitRepository.findByOrganisationUnit2(entity);
		if (orgs2 != null) linkOrganisationUnitOrganisationUnitRepository.delete(orgs2);
		entity.setOrganisationUnits_organisationUnits2(null);
		
		List<OrganisationUnit_Prize> priz = linkOrganisationUnitPrizeRepository.findByOrganisationUnit(entity);
		if (priz != null) linkOrganisationUnitPrizeRepository.delete(priz);
		entity.setOrganisationUnits_prizes(null);
		
		List<OrganisationUnit_ExpertiseAndSkills> exps = linkOrganisationUnitExpertiseAndSkillsRepository.findByOrganisationUnit(entity);
		if (exps != null) linkOrganisationUnitExpertiseAndSkillsRepository.delete(exps);
		entity.setOrganisationUnits_expertiseAndSkills(null);
		
		List<OrganisationUnit_ResultProduct> prods = linkOrganisationUnitResultProductRepository.findByOrganisationUnit(entity);
		if (prods != null) linkOrganisationUnitResultProductRepository.delete(prods);
		entity.setOrganisationUnits_resultProducts(null);
		
		List<OrganisationUnit_ResultPatent> pats = linkOrganisationUnitResultPatentRepository.findByOrganisationUnit(entity);
		if (pats != null) linkOrganisationUnitResultPatentRepository.delete(pats);
		entity.setOrganisationUnits_resultPatents(null);
		
		List<OrganisationUnit_Service> servs = linkOrganisationUnitServiceRepository.findByOrganisationUnit(entity);
		if (servs != null) linkOrganisationUnitServiceRepository.delete(servs);
		entity.setOrganisationUnits_services(null);
		
		List<ClassScheme_OrganisationUnit> classSche = linkClassSchemeOrganisationUnitRepository.findByOrganisationUnit(entity);
		if (classSche != null) linkClassSchemeOrganisationUnitRepository.delete(classSche);
		entity.setClassScheme_organisationUnits(null);
		
		entity = organisationUnitCrudRepository.save(entity);
		organisationUnitCrudRepository.delete(entity);
		
		if (lpa != null) postalAddressRepository.delete(lpa);
		if (ea != null) electronicAddressRepository.delete(ea);
	}

	@Override
	public Iterable<OrganisationUnit> findAll() {
		return organisationUnitCrudRepository.findAll();
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

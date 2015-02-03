package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.entities.link.Facility_Equipment;
import gr.ekt.cerif.entities.link.Facility_Event;
import gr.ekt.cerif.entities.link.Facility_Facility;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.link.Facility_Indicator;
import gr.ekt.cerif.entities.link.Facility_Measurement;
import gr.ekt.cerif.entities.link.Facility_Medium;
import gr.ekt.cerif.entities.link.Facility_PostalAddress;
import gr.ekt.cerif.entities.link.Facility_Service;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.entities.link.person.Person_Facility;
import gr.ekt.cerif.entities.link.project.Project_Facility;
import gr.ekt.cerif.entities.link.result.ResultPatent_Facility;
import gr.ekt.cerif.entities.link.result.ResultProduct_Facility;
import gr.ekt.cerif.entities.link.result.ResultPublication_Facility;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.multilingual.FacilityDescription;
import gr.ekt.cerif.features.multilingual.FacilityKeyword;
import gr.ekt.cerif.features.multilingual.FacilityName;
import gr.ekt.cerif.services.link.facility.LinkFacilityClassRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityEquipmentRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityEventRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityFacilityRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityFundingRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityIndicatorRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityMeasurementRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityMediumRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityPostalAddressRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityServiceRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitFacilityRepository;
import gr.ekt.cerif.services.link.person.LinkPersonFacilityRepository;
import gr.ekt.cerif.services.link.project.LinkProjectFacilityRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentFacilityRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductFacilityRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationFacilityRepository;
import gr.ekt.cerif.services.multilingual.facility.FacilityDescriptionRepository;
import gr.ekt.cerif.services.multilingual.facility.FacilityKeywordRepository;
import gr.ekt.cerif.services.multilingual.facility.FacilityNameRepository;
import gr.ekt.cerif.services.second.PostalAddressRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bonisv
 *
 */
@Component
public class FacilityRepositoryImpl implements FacilityRepository {
	
	private static final Logger log = LoggerFactory.getLogger(FacilityRepositoryImpl.class);

	@Autowired
	private FacilityCrudRepository facilityCrudRepository;
	
	@Autowired
	private LinkFacilityClassRepository linkFacilityClassRepository;
	
	@Autowired
	private LinkFacilityFundingRepository linkFacilityFundingRepository;
	
	@Autowired
	private LinkOrganisationUnitFacilityRepository linkOrganisationUnitFacilityRepository;
	
	@Autowired
	private LinkFacilityFacilityRepository linkFacilityFacilityRepository;
	
	@Autowired
	private FacilityNameRepository facilityNameRepository;
	
	@Autowired
	private FacilityKeywordRepository facilityKeywordRepository;	
	
	@Autowired
	private FacilityDescriptionRepository facilityDescriptionRepository;
	
	@Autowired
	private LinkProjectFacilityRepository linkProjectFacilityRepository;
	
	@Autowired
	private LinkPersonFacilityRepository linkPersonFacilityRepository;
	
	@Autowired
	private LinkResultPublicationFacilityRepository linkResultPublicationFacilityRepository;
	
	@Autowired
	private LinkResultProductFacilityRepository linkResultProductFacilityRepository;
	
	@Autowired
	private LinkResultPatentFacilityRepository linkResultPatentFacilityRepository;
	
	@Autowired
	private LinkFacilityServiceRepository linkFacilityServiceRepository;
	
	@Autowired
	private LinkFacilityEquipmentRepository linkFacilityEquipmentRepository;
	
	@Autowired
	private LinkFacilityPostalAddressRepository linkFacilityPostalAddressRepository;
	
	@Autowired
	private PostalAddressRepository postalAddressRepository;
	
	@Autowired
	private LinkFacilityMediumRepository linkFacilityMediumRepository;
	
	@Autowired
	private LinkFacilityIndicatorRepository linkFacilityIndicatorRepository;
	
	@Autowired
	private LinkFacilityMeasurementRepository linkFacilityMeasurementRepository;
	
	@Autowired
	private LinkFacilityEventRepository linkFacilityEventRepository;
	
	
	
	@Override
	public Facility findById(Long id) {
		return facilityCrudRepository.findById(id);
	}

	@Override
	public Facility findByAcronym(String acronym) {
		return facilityCrudRepository.findByAcronym(acronym);
	}

	@Override
	@Transactional
	public void delete(Facility entity) {
		List<FacilityName> facnam = facilityNameRepository.findByFacility(entity);
		if (facnam != null) facilityNameRepository.delete(facnam);
		entity.setFacilityNames(null);
		
		List<FacilityKeyword> fackey = facilityKeywordRepository.findByFacility(entity);
		if (fackey != null) facilityKeywordRepository.delete(fackey);
		entity.setFacilityKeywords(null);
		
		List<FacilityDescription> facdescr = facilityDescriptionRepository.findByFacility(entity);
		if (facdescr != null) facilityDescriptionRepository.delete(facdescr);
		entity.setFacilityDescriptions(null);
		
		List<Project_Facility> pfac = linkProjectFacilityRepository.findByFacility(entity);
		if (pfac != null) linkProjectFacilityRepository.delete(pfac);
		entity.setProjects_facilities(null);
		
		List<OrganisationUnit_Facility> ouf = linkOrganisationUnitFacilityRepository.findByFacility(entity);
		if (ouf != null) linkOrganisationUnitFacilityRepository.delete(ouf);
		entity.setOrganisationUnits_facilities(null);
		
		List<Person_Facility> perfac = linkPersonFacilityRepository.findByFacility(entity);
		if (perfac != null) linkPersonFacilityRepository.delete(perfac);
		entity.setPersons_facilities(null);
		
		List<ResultPublication_Facility> respublfac = linkResultPublicationFacilityRepository.findByFacility(entity);
		if (respublfac != null) linkResultPublicationFacilityRepository.delete(respublfac);
		entity.setResultPublications_facilities(null);
		
		List<ResultProduct_Facility> resproflfac = linkResultProductFacilityRepository.findByFacility(entity);
		if (resproflfac != null) linkResultProductFacilityRepository.delete(resproflfac);
		entity.setResultProducts_facilities(null);
		
		List<ResultPatent_Facility> respatflfac = linkResultPatentFacilityRepository.findByFacility(entity);
		if (respatflfac != null) linkResultPatentFacilityRepository.delete(respatflfac);
		entity.setResultPatents_facilities(null);
		
		List<Facility_Class> faccl = linkFacilityClassRepository.findByFacility(entity);
		if (faccl != null) linkFacilityClassRepository.delete(faccl);
		entity.setFacilities_classes(null);
		
		List<Facility_Funding> facfund = linkFacilityFundingRepository.findByFacility(entity);
		if (facfund != null) linkFacilityFundingRepository.delete(facfund);
		entity.setFacilities_fundings(null);
		
		List<Facility_Facility> facfac1 = linkFacilityFacilityRepository.findByFacility1(entity);
		if (facfac1 != null) linkFacilityFacilityRepository.delete(facfac1);
		entity.setFacilities_facilities1(null);
		
		List<Facility_Facility> facfac2 = linkFacilityFacilityRepository.findByFacility2(entity);
		if (facfac2 != null) linkFacilityFacilityRepository.delete(facfac2);
		entity.setFacilities_facilities2(null);
		
		List<Facility_Service> facsrv = linkFacilityServiceRepository.findByFacility(entity);
		if (facsrv != null) linkFacilityServiceRepository.delete(facsrv);
		entity.setFacilities_services(null);
		
		List<Facility_Equipment> facequip = linkFacilityEquipmentRepository.findByFacility(entity);
		if (facequip != null) linkFacilityEquipmentRepository.delete(facequip);
		entity.setFacilities_equipments(null);
		
		List<Facility_PostalAddress> facpaddr = linkFacilityPostalAddressRepository.findByFacility(entity);
		List<PostalAddress> lpa = postalAddressRepository.findByFacility(entity);
		if (facpaddr != null) linkFacilityPostalAddressRepository.delete(facpaddr);
		entity.setFacilities_postalAddresses(null);
		
		List<Facility_Medium> facmed = linkFacilityMediumRepository.findByFacility(entity);
		if (facmed != null) linkFacilityMediumRepository.delete(facmed);
		entity.setFacilities_mediums(null);
		
		List<Facility_Indicator> facind = linkFacilityIndicatorRepository.findByFacility(entity);
		if (facind != null) linkFacilityIndicatorRepository.delete(facind);
		entity.setFacilities_indicators(null);
		
		List<Facility_Measurement> facmeas = linkFacilityMeasurementRepository.findByFacility(entity);
		if (facmeas != null) linkFacilityMeasurementRepository.delete(facmeas);
		entity.setFacilities_measurements(null);
		
		List<Facility_Event> faceve = linkFacilityEventRepository.findByFacility(entity);
		if (faceve != null) linkFacilityEventRepository.delete(faceve);
		entity.setFacilities_events(null);
		
		entity = facilityCrudRepository.save(entity);
		facilityCrudRepository.delete(entity);
		
		if (lpa != null) postalAddressRepository.delete(lpa);
	}

	@Transactional
	public Iterable<Facility> save(Iterable<Facility> entities) {
		return facilityCrudRepository.save(entities);
	}

	@Transactional
	public Facility save(Facility entity) {
		return facilityCrudRepository.save(entity);
	}

	@Override
	public List<Facility> findAll() {
		return facilityCrudRepository.findAll();
	}

	@Override
	public void delete(Iterable<Facility> entities) {
		facilityCrudRepository.delete(entities);		
	}

	@Override
	public Page<Facility> findAll(Pageable page) {
		return facilityCrudRepository.findAll(page);
	}

	@Override
	public Facility findByUuid(String uuid) {
		return facilityCrudRepository.findByUuid(uuid);
	}

}

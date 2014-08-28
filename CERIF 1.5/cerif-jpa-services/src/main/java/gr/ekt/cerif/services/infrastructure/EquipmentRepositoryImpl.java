package gr.ekt.cerif.services.infrastructure;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Class;
import gr.ekt.cerif.entities.link.Equipment_Equipment;
import gr.ekt.cerif.entities.link.Equipment_Event;
import gr.ekt.cerif.entities.link.Equipment_Funding;
import gr.ekt.cerif.entities.link.Equipment_Indicator;
import gr.ekt.cerif.entities.link.Equipment_Measurement;
import gr.ekt.cerif.entities.link.Equipment_Medium;
import gr.ekt.cerif.entities.link.Equipment_PostalAddress;
import gr.ekt.cerif.entities.link.Equipment_Service;
import gr.ekt.cerif.entities.link.Facility_Equipment;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Equipment;
import gr.ekt.cerif.entities.link.person.Person_Equipment;
import gr.ekt.cerif.entities.link.project.Project_Equipment;
import gr.ekt.cerif.entities.link.result.ResultPatent_Equipment;
import gr.ekt.cerif.entities.link.result.ResultProduct_Equipment;
import gr.ekt.cerif.entities.link.result.ResultPublication_Equipment;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.multilingual.EquipmentDescription;
import gr.ekt.cerif.features.multilingual.EquipmentKeyword;
import gr.ekt.cerif.features.multilingual.EquipmentName;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentClassRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentEquipmentRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentEventRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentFundingRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentIndicatorRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentMeasurementRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentMediumRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentPostalAddressRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentServiceRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityEquipmentRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitEquipmentRepository;
import gr.ekt.cerif.services.link.person.LinkPersonEquipmentRepository;
import gr.ekt.cerif.services.link.project.LinkProjectEquipmentRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentEquipmentRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductEquipmentRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationEquipmentRepository;
import gr.ekt.cerif.services.multilingual.equipment.EquipmentDescriptionRepository;
import gr.ekt.cerif.services.multilingual.equipment.EquipmentKeywordRepository;
import gr.ekt.cerif.services.multilingual.equipment.EquipmentNameRepository;
import gr.ekt.cerif.services.second.PostalAddressRepository;

/**
 * @author bonisv
 *
 */
@Component
public class EquipmentRepositoryImpl implements EquipmentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(EquipmentRepositoryImpl.class);
	
	@Autowired
	private EquipmentCrudRepository equipmentCrudRepository;
	
	@Autowired
	private EquipmentNameRepository equipmentNameRepository;
	
	@Autowired
	private EquipmentKeywordRepository equipmentKeywordRepository;
	
	@Autowired
	private EquipmentDescriptionRepository equipmentDescriptionRepository;
	
	@Autowired
	private LinkProjectEquipmentRepository linkProjectEquipmentRepository;
	
	@Autowired
	private LinkPersonEquipmentRepository linkPersonEquipmentRepository;
	
	@Autowired
	private LinkResultPublicationEquipmentRepository linkResultPublicationEquipmentRepository;
	
	@Autowired
	private LinkEquipmentServiceRepository linkEquipmentServiceRepository;
	
	@Autowired
	private LinkEquipmentFundingRepository linkEquipmentFundingRepository;
	
	@Autowired
	private LinkEquipmentClassRepository linkEquipmentClassRepository;
	
	@Autowired
	private LinkOrganisationUnitEquipmentRepository linkOrganisationUnitEquipmentRepository;
	
	@Autowired
	private LinkEquipmentMediumRepository linkEquipmentMediumRepository;
	
	@Autowired
	private LinkEquipmentPostalAddressRepository linkEquipmentPostalAddressRepository;
	
	@Autowired
	private LinkEquipmentEquipmentRepository linkEquipmentEquipmentRepository;
	
	@Autowired
	private LinkFacilityEquipmentRepository linkFacilityEquipmentRepository;
	
	@Autowired
	private LinkEquipmentEventRepository linkEquipmentEventRepository;
	
	@Autowired
	private LinkResultPatentEquipmentRepository linkResultPatentEquipmentRepository;
	
	@Autowired
	private LinkResultProductEquipmentRepository linkResultProductEquipmentRepository;
	
	@Autowired
	private LinkEquipmentIndicatorRepository linkEquipmentIndicatorRepository;
	
	@Autowired
	private LinkEquipmentMeasurementRepository linkEquipmentMeasurementRepository;
	
	@Autowired
	private PostalAddressRepository postalAddressRepository;
	
	@Transactional	
	@Override
	public void delete(Equipment entity) {
		List<EquipmentName> eqnam = equipmentNameRepository.findByEquipment(entity);
		if (eqnam != null) equipmentNameRepository.delete(eqnam);
		entity.setEquipmentNames(null);
		
		List<EquipmentKeyword> eqkey = equipmentKeywordRepository.findByEquipment(entity);
		if (eqkey != null) equipmentKeywordRepository.delete(eqkey);
		entity.setEquipmentKeywords(null);
		
		List<EquipmentDescription> eqdescr = equipmentDescriptionRepository.findByEquipment(entity);
		if (eqdescr != null) equipmentDescriptionRepository.delete(eqdescr);
		entity.setEquipmentDescriptions(null);
		
		List<Project_Equipment> peq = linkProjectEquipmentRepository.findByEquipment(entity);
		if (peq != null) linkProjectEquipmentRepository.delete(peq);
		entity.setProjects_equipments(null);
		
		List<Person_Equipment> pequ = linkPersonEquipmentRepository.findByEquipment(entity);
		if (pequ != null) linkPersonEquipmentRepository.delete(pequ);
		entity.setPersons_equipments(null);
		
		List<ResultPublication_Equipment> respubleq = linkResultPublicationEquipmentRepository.findByEquipment(entity);
		if (respubleq != null) linkResultPublicationEquipmentRepository.delete(respubleq);
		entity.setResultPublications_equipments(null);
		
		List<Equipment_Service> eqserv = linkEquipmentServiceRepository.findByEquipment(entity);
		if (eqserv != null) linkEquipmentServiceRepository.delete(eqserv);
		entity.setEquipments_services(null);
		
		List<Equipment_Funding> eqfund = linkEquipmentFundingRepository.findByEquipment(entity);
		if (eqfund != null) linkEquipmentFundingRepository.delete(eqfund);
		entity.setEquipments_fundings(null);
		
		List<Equipment_Class> eqcl = linkEquipmentClassRepository.findByEquipment(entity);
		if (eqcl != null) linkEquipmentClassRepository.delete(eqcl);
		entity.setEquipments_classes(null);
		
		List<OrganisationUnit_Equipment> orgequip = linkOrganisationUnitEquipmentRepository.findByEquipment(entity);
		if (orgequip != null) linkOrganisationUnitEquipmentRepository.delete(orgequip);
		entity.setOrganisationUnits_equipments(null);
		
		List<Equipment_Medium> equipmed = linkEquipmentMediumRepository.findByEquipment(entity);
		if (equipmed != null) linkEquipmentMediumRepository.delete(equipmed);
		entity.setEquipments_mediums(null);
		
		List<Equipment_PostalAddress> equipaddr = linkEquipmentPostalAddressRepository.findByEquipment(entity);
		List<PostalAddress> lpa = postalAddressRepository.findByEquipment(entity);
		if (equipaddr != null) linkEquipmentPostalAddressRepository.delete(equipaddr);
		entity.setEquipments_postalAddresses(null);
		
		List<Equipment_Equipment> equipequip1 = linkEquipmentEquipmentRepository.findByEquipment1(entity);
		if (equipequip1 != null) linkEquipmentEquipmentRepository.delete(equipequip1);
		entity.setEquipments_equipments1(null);
		
		List<Equipment_Equipment> equipequip2 = linkEquipmentEquipmentRepository.findByEquipment2(entity);
		if (equipequip2 != null) linkEquipmentEquipmentRepository.delete(equipequip2);
		entity.setEquipments_equipments2(null);
		
		List<Facility_Equipment> facequip = linkFacilityEquipmentRepository.findByEquipment(entity);
		if (facequip != null) linkFacilityEquipmentRepository.delete(facequip);
		entity.setFacilities_equipments(null);
		
		List<Equipment_Event> equipev = linkEquipmentEventRepository.findByEquipment(entity);
		if (equipev != null) linkEquipmentEventRepository.delete(equipev);
		entity.setEquipments_events(null);
		
		List<ResultPatent_Equipment> respatequip = linkResultPatentEquipmentRepository.findByEquipment(entity);
		if (respatequip != null) linkResultPatentEquipmentRepository.delete(respatequip);
		entity.setResultPatents_equipments(null);
		
		List<ResultProduct_Equipment> resprodequip = linkResultProductEquipmentRepository.findByEquipment(entity);
		if (resprodequip != null) linkResultProductEquipmentRepository.delete(resprodequip);
		entity.setResultProducts_equipments(null);
		
		List<Equipment_Indicator> equipind = linkEquipmentIndicatorRepository.findByEquipment(entity);
		if (equipind != null) linkEquipmentIndicatorRepository.delete(equipind);
		entity.setEquipments_indicators(null);
		
		List<Equipment_Measurement> equipmeas = linkEquipmentMeasurementRepository.findByEquipment(entity);
		if (equipmeas != null) linkEquipmentMeasurementRepository.delete(equipmeas);
		entity.setEquipments_measurements(null);
		
		entity = equipmentCrudRepository.save(entity);
		equipmentCrudRepository.delete(entity);
		
		if (lpa != null) postalAddressRepository.delete(lpa);
	}

	@Override
	public void delete(Iterable<Equipment> entities) {
		equipmentCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Equipment> save(Iterable<Equipment> entities) {
		return equipmentCrudRepository.save(entities);
	}

	@Override
	public Equipment save(Equipment entity) {
		return equipmentCrudRepository.save(entity);
	}

	@Override
	public List<Equipment> findAll() {
		return equipmentCrudRepository.findAll();
	}

	@Override
	public Page<Equipment> findAll(Pageable page) {
		return equipmentCrudRepository.findAll(page);
	}

	@Override
	public Equipment findById(Long id) {
		return equipmentCrudRepository.findOne(id);
	}

	@Override
	public Equipment findByUUID(String uuid) {
		return equipmentCrudRepository.findByUuid(uuid);
	}

}

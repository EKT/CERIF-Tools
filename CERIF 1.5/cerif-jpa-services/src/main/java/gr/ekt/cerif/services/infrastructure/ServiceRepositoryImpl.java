package gr.ekt.cerif.services.infrastructure;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Equipment_Service;
import gr.ekt.cerif.entities.link.Facility_Service;
import gr.ekt.cerif.entities.link.Service_Class;
import gr.ekt.cerif.entities.link.Service_Event;
import gr.ekt.cerif.entities.link.Service_FederatedIdentifier;
import gr.ekt.cerif.entities.link.Service_Funding;
import gr.ekt.cerif.entities.link.Service_Indicator;
import gr.ekt.cerif.entities.link.Service_Measurement;
import gr.ekt.cerif.entities.link.Service_Medium;
import gr.ekt.cerif.entities.link.Service_PostalAddress;
import gr.ekt.cerif.entities.link.Service_Service;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Service;
import gr.ekt.cerif.entities.link.person.Person_Service;
import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.entities.link.result.ResultPatent_Service;
import gr.ekt.cerif.entities.link.result.ResultProduct_Service;
import gr.ekt.cerif.entities.link.result.ResultPublication_Service;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.multilingual.ServiceDescription;
import gr.ekt.cerif.features.multilingual.ServiceKeyword;
import gr.ekt.cerif.features.multilingual.ServiceName;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentServiceRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityServiceRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitServiceRepository;
import gr.ekt.cerif.services.link.person.LinkPersonServiceRepository;
import gr.ekt.cerif.services.link.project.LinkProjectServiceRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentServiceRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductServiceRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationServiceRepository;
import gr.ekt.cerif.services.link.service.LinkServiceClassRepository;
import gr.ekt.cerif.services.link.service.LinkServiceEventRepository;
import gr.ekt.cerif.services.link.service.LinkServiceFederatedIdentifierRepository;
import gr.ekt.cerif.services.link.service.LinkServiceFundingRepository;
import gr.ekt.cerif.services.link.service.LinkServiceIndicatorRepository;
import gr.ekt.cerif.services.link.service.LinkServiceMeasurementRepository;
import gr.ekt.cerif.services.link.service.LinkServiceMediumRepository;
import gr.ekt.cerif.services.link.service.LinkServicePostalAddressRepository;
import gr.ekt.cerif.services.link.service.LinkServiceServiceRepository;
import gr.ekt.cerif.services.multilingual.service.ServiceDescriptionRepository;
import gr.ekt.cerif.services.multilingual.service.ServiceKeywordRepository;
import gr.ekt.cerif.services.multilingual.service.ServiceNameRepository;
import gr.ekt.cerif.services.second.PostalAddressRepository;

/**
 * @author bonisv
 *
 */
@Component
public class ServiceRepositoryImpl implements ServiceRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ServiceRepositoryImpl.class);
	
	@Autowired
	private ServiceCrudRepository serviceCrudRepository;
	
	@Autowired
	private ServiceNameRepository serviceNameRepository;
	
	@Autowired
	private ServiceDescriptionRepository serviceDescriptionRepository;
	
	@Autowired
	private ServiceKeywordRepository serviceKeywordRepository;
	
	@Autowired
	private LinkServiceClassRepository linkServiceClassRepository;
	
	@Autowired
	private LinkOrganisationUnitServiceRepository linkOrganisationUnitServiceRepository;
	
	@Autowired
	private LinkPersonServiceRepository linkPersonServiceRepository;
	
	@Autowired
	private LinkProjectServiceRepository linkProjectServiceRepository;
	
	@Autowired
	private LinkServiceFundingRepository linkServiceFundingRepository;
	
	@Autowired
	private LinkServiceMediumRepository linkServiceMediumRepository;
	
	@Autowired
	private LinkServicePostalAddressRepository linkServicePostalAddressRepository;
	
	@Autowired
	private PostalAddressRepository postalAddressRepository;
	
	@Autowired
	private LinkServiceServiceRepository linkServiceServiceRepository;
	
	@Autowired
	private LinkFacilityServiceRepository linkFacilityServiceRepository;
	
	@Autowired
	private LinkEquipmentServiceRepository linkEquipmentServiceRepository;
	
	@Autowired
	private LinkServiceEventRepository linkServiceEventRepository;
	
	@Autowired
	private LinkResultPublicationServiceRepository linkResultPublicationServiceRepository;
	
	@Autowired
	private LinkResultPatentServiceRepository linkResultPatentServiceRepository;
	
	@Autowired
	private LinkResultProductServiceRepository linkResultProductServiceRepository;
	
	@Autowired
	private LinkServiceIndicatorRepository linkServiceIndicatorRepository;
	
	@Autowired
	private LinkServiceMeasurementRepository linkServiceMeasurementRepository;
	
	@Autowired
	private LinkServiceFederatedIdentifierRepository linkServiceFederatedIdentifierRepository;
	

	@Override
	@Transactional
	public void delete(Service entity) {
		List<ServiceName> servnam = serviceNameRepository.findByService(entity);
		if (servnam != null) serviceNameRepository.delete(servnam);
		entity.setServiceNames(null);
		
		List<ServiceDescription> servdescr = serviceDescriptionRepository.findByService(entity);
		if (servdescr != null) serviceDescriptionRepository.delete(servdescr);
		entity.setServiceDescriptions(null);
		
		List<ServiceKeyword> servkey = serviceKeywordRepository.findByService(entity);
		if (servkey != null) serviceKeywordRepository.delete(servkey);
		entity.setServiceKeywords(null);
		
		List<Service_Class> servcl = linkServiceClassRepository.findByService(entity);
		if (servcl != null) linkServiceClassRepository.delete(servcl);
		entity.setServices_classes(null);
		
		List<OrganisationUnit_Service> orgserv = linkOrganisationUnitServiceRepository.findByService(entity);
		if (orgserv != null) linkOrganisationUnitServiceRepository.delete(orgserv);
		entity.setOrganisationUnits_services(null);
		
		List<Person_Service> persserv = linkPersonServiceRepository.findByService(entity);
		if (persserv != null) linkPersonServiceRepository.delete(persserv);
		entity.setPersons_services(null);
		
		List<Project_Service> projsserv = linkProjectServiceRepository.findByService(entity);
		if (projsserv != null) linkProjectServiceRepository.delete(projsserv);
		entity.setProjects_services(null);
		
		List<Service_Funding> servfund = linkServiceFundingRepository.findByService(entity);
		if (servfund != null) linkServiceFundingRepository.delete(servfund);
		entity.setServices_fundings(null);
		
		List<Service_Medium> servmed = linkServiceMediumRepository.findByService(entity);
		if (servmed != null) linkServiceMediumRepository.delete(servmed);
		entity.setServices_mediums(null);
		
		List<Service_PostalAddress> servpaddr = linkServicePostalAddressRepository.findByService(entity);
		List<PostalAddress> lpa = postalAddressRepository.findByService(entity);
		if (servpaddr != null) linkServicePostalAddressRepository.delete(servpaddr);
		entity.setServices_postalAddresses(null);
		
		List<Service_Service> servserv1 = linkServiceServiceRepository.findByService1(entity);
		if (servserv1 != null) linkServiceServiceRepository.delete(servserv1);
		entity.setServices_services1(null);
		
		List<Service_Service> servserv2 = linkServiceServiceRepository.findByService2(entity);
		if (servserv2 != null) linkServiceServiceRepository.delete(servserv2);
		entity.setServices_services2(null);
		
		List<Facility_Service> facsrv = linkFacilityServiceRepository.findByService(entity);
		if (facsrv != null) linkFacilityServiceRepository.delete(facsrv);
		entity.setFacilities_services(null);
		
		List<Equipment_Service> eqserv = linkEquipmentServiceRepository.findByService(entity);
		if (eqserv != null) linkEquipmentServiceRepository.delete(eqserv);
		entity.setEquipments_services(null);
		
		List<Service_Event> servev = linkServiceEventRepository.findByService(entity);
		if (servev != null) linkServiceEventRepository.delete(servev);
		entity.setServices_events(null);
		
		List<ResultPublication_Service> respublserv = linkResultPublicationServiceRepository.findByService(entity);
		if (respublserv != null) linkResultPublicationServiceRepository.delete(respublserv);
		entity.setResultPublications_services(null);
		
		List<ResultPatent_Service> respatserv = linkResultPatentServiceRepository.findByService(entity);
		if (respatserv != null) linkResultPatentServiceRepository.delete(respatserv);
		entity.setResultPatents_services(null);
		
		List<ResultProduct_Service> resprodserv = linkResultProductServiceRepository.findByService(entity);
		if (resprodserv != null) linkResultProductServiceRepository.delete(resprodserv);
		entity.setResultProducts_services(null);
		
		List<Service_Indicator> servind = linkServiceIndicatorRepository.findByService(entity);
		if (servind != null) linkServiceIndicatorRepository.delete(servind);
		entity.setServices_indicators(null);
		
		List<Service_Measurement> servmeas = linkServiceMeasurementRepository.findByService(entity);
		if (servmeas != null) linkServiceMeasurementRepository.delete(servmeas);
		entity.setServices_measurements(null);
		
		List<Service_FederatedIdentifier> servfed = linkServiceFederatedIdentifierRepository.findByService(entity);
		if (servfed != null) linkServiceFederatedIdentifierRepository.delete(servfed);
		entity.setServices_federatedIdentifiers(null);
		
		entity = serviceCrudRepository.save(entity);
		serviceCrudRepository.delete(entity);
		
		if (lpa != null) postalAddressRepository.delete(lpa);
	}

	@Override
	public void delete(Iterable<Service> entities) {
		serviceCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Service> save(Iterable<Service> entities) {
		return serviceCrudRepository.save(entities);
	}

	@Override
	public Service save(Service entity) {
		return serviceCrudRepository.save(entity);
	}

	@Override
	public List<Service> findAll() {
		return serviceCrudRepository.findAll();
	}

	@Override
	public Page<Service> findAll(Pageable page) {
		return serviceCrudRepository.findAll(page);
	}

	@Override
	public Service findById(Long id) {
		return serviceCrudRepository.findById(id);
	}

	@Override
	public Service findByUUID(String uuid) {
		return serviceCrudRepository.findByUuid(uuid);
	}

}

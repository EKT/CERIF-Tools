/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gr.ekt.cerif.entities.link.Equipment_Measurement;
import gr.ekt.cerif.entities.link.Event_Measurement;
import gr.ekt.cerif.entities.link.Facility_Measurement;
import gr.ekt.cerif.entities.link.Funding_Measurement;
import gr.ekt.cerif.entities.link.Indicator_Measurement;
import gr.ekt.cerif.entities.link.Measurement_Class;
import gr.ekt.cerif.entities.link.Measurement_Measurement;
import gr.ekt.cerif.entities.link.Medium_Measurement;
import gr.ekt.cerif.entities.link.Service_Measurement;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Measurement;
import gr.ekt.cerif.entities.link.person.Person_Measurement;
import gr.ekt.cerif.entities.link.project.Project_Measurement;
import gr.ekt.cerif.entities.link.result.ResultPatent_Measurement;
import gr.ekt.cerif.entities.link.result.ResultProduct_Measurement;
import gr.ekt.cerif.entities.link.result.ResultPublication_Measurement;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.multilingual.MeasurementDescription;
import gr.ekt.cerif.features.multilingual.MeasurementKeyword;
import gr.ekt.cerif.features.multilingual.MeasurementName;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentMeasurementRepository;
import gr.ekt.cerif.services.link.event.LinkEventMeasurementRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityMeasurementRepository;
import gr.ekt.cerif.services.link.funding.LinkFundingMeasurementRepository;
import gr.ekt.cerif.services.link.indicator.LinkIndicatorMeasurementRepository;
import gr.ekt.cerif.services.link.measurement.LinkMeasurementClassRepository;
import gr.ekt.cerif.services.link.measurement.LinkMeasurementMeasurementRepository;
import gr.ekt.cerif.services.link.medium.LinkMediumMeasurementRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitMeasurementRepository;
import gr.ekt.cerif.services.link.person.LinkPersonMeasurementRepository;
import gr.ekt.cerif.services.link.project.LinkProjectMeasurementRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentMeasurementRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductMeasurementRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationMeasurementRepository;
import gr.ekt.cerif.services.link.service.LinkServiceMeasurementRepository;
import gr.ekt.cerif.services.multilingual.measurement.MeasurementDescriptionRepository;
import gr.ekt.cerif.services.multilingual.measurement.MeasurementKeywordRepository;
import gr.ekt.cerif.services.multilingual.measurement.MeasurementNameRepository;

/**
 * @author bonisv
 *
 */
@Component
public class MeasurementRepositoryImpl implements MeasurementRepository {
	
	private static final Logger log = LoggerFactory.getLogger(MeasurementRepositoryImpl.class);

	@Autowired
	private MeasurementCrudRepository measurementCrudRepository;
	
	@Autowired
	private LinkIndicatorMeasurementRepository linkIndicatorMeasurementRepository;
	
	@Autowired
	private MeasurementNameRepository measurementNameRepository;
	
	@Autowired
	private MeasurementKeywordRepository measurementKeywordRepository;
	
	@Autowired
	private MeasurementDescriptionRepository measurementDescriptionRepository;
	
	@Autowired
	private LinkMeasurementClassRepository linkMeasurementClassRepository;
	
	@Autowired
	private LinkResultPatentMeasurementRepository linkResultPatentMeasurementRepository;
	
	@Autowired
	private LinkResultProductMeasurementRepository linkResultProductMeasurementRepository;
	
	@Autowired
	private LinkResultPublicationMeasurementRepository linkResultPublicationMeasurementRepository;
	
	@Autowired
	private LinkFacilityMeasurementRepository linkFacilityMeasurementRepository;
	
	@Autowired
	private LinkServiceMeasurementRepository linkServiceMeasurementRepository;
	
	@Autowired
	private LinkEquipmentMeasurementRepository linkEquipmentMeasurementRepository;
	
	@Autowired
	private LinkMediumMeasurementRepository linkMediumMeasurementRepository;
	
	@Autowired
	private LinkPersonMeasurementRepository linkPersonMeasurementRepository;	
	
	@Autowired
	private LinkOrganisationUnitMeasurementRepository linkOrganisationUnitMeasurementRepository;
	
	@Autowired
	private LinkProjectMeasurementRepository linkProjectMeasurementRepository;
	
	@Autowired
	private LinkEventMeasurementRepository linkEventMeasurementRepository;
	
	@Autowired
	private LinkMeasurementMeasurementRepository linkMeasurementMeasurementRepository;
	
	@Autowired
	private LinkFundingMeasurementRepository linkFundingMeasurementRepository;
	
	

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.MeasurementRepository#delete(gr.ekt.cerif.entities.second.Measurement)
	 */
	@Override
	@Transactional
	public void delete(Measurement entity) {
		List<MeasurementName> measname = measurementNameRepository.findByMeasurement(entity);
		if (measname != null) measurementNameRepository.delete(measname);
		entity.setMeasurementNames(null);
		
		List<MeasurementKeyword> measkey = measurementKeywordRepository.findByMeasurement(entity);
		if (measkey != null) measurementKeywordRepository.delete(measkey);
		entity.setMeasurementKeywords(null);
		
		List<MeasurementDescription> measdescr = measurementDescriptionRepository.findByMeasurement(entity);
		if (measdescr != null) measurementDescriptionRepository.delete(measdescr);
		entity.setMeasurementDescriptions(null);
		
		List<Measurement_Class> meascl = linkMeasurementClassRepository.findByMeasurement(entity);
		if (meascl != null) linkMeasurementClassRepository.delete(meascl);
		entity.setMeasurements_classes(null);
		
		List<ResultPatent_Measurement> respatmeas = linkResultPatentMeasurementRepository.findByMeasurement(entity);
		if (respatmeas != null) linkResultPatentMeasurementRepository.delete(respatmeas);
		entity.setResultPatents_measurements(null);
		
		List<ResultProduct_Measurement> resprodmeas = linkResultProductMeasurementRepository.findByMeasurement(entity);
		if (resprodmeas != null) linkResultProductMeasurementRepository.delete(resprodmeas);
		entity.setResultProducts_measurements(null);
		
		List<ResultPublication_Measurement> respublmeas = linkResultPublicationMeasurementRepository.findByMeasurement(entity);
		if (respublmeas != null) linkResultPublicationMeasurementRepository.delete(respublmeas);
		entity.setResultPublications_measurements(null);
		
		List<Facility_Measurement> facmeas = linkFacilityMeasurementRepository.findByMeasurement(entity);
		if (facmeas != null) linkFacilityMeasurementRepository.delete(facmeas);
		entity.setFacilities_measurements(null);
		
		List<Service_Measurement> srvmeas = linkServiceMeasurementRepository.findByMeasurement(entity);
		if (srvmeas != null) linkServiceMeasurementRepository.delete(srvmeas);
		entity.setServices_measurements(null);
		
		List<Equipment_Measurement> equipmeas = linkEquipmentMeasurementRepository.findByMeasurement(entity);
		if (equipmeas != null) linkEquipmentMeasurementRepository.delete(equipmeas);
		entity.setEquipments_measurements(null);
		
		List<Medium_Measurement> medpmeas = linkMediumMeasurementRepository.findByMeasurement(entity);
		if (medpmeas != null) linkMediumMeasurementRepository.delete(medpmeas);
		entity.setMediums_measurements(null);
		
		List<Indicator_Measurement> indmeas = linkIndicatorMeasurementRepository.findByMeasurement(entity);
		if (indmeas != null) linkIndicatorMeasurementRepository.delete(indmeas);
		entity.setIndicators_measurements(null);
		
		List<Person_Measurement> pmeas = linkPersonMeasurementRepository.findByMeasurement(entity);
		if (pmeas != null) linkPersonMeasurementRepository.delete(pmeas);
		entity.setPersons_measurements(null);
		
		List<OrganisationUnit_Measurement> meas = linkOrganisationUnitMeasurementRepository.findByMeasurement(entity);
		if (meas != null) linkOrganisationUnitMeasurementRepository.delete(meas);
		entity.setOrganisationUnits_measurements(null);
		
		List<Project_Measurement> projmeas = linkProjectMeasurementRepository.findByMeasurement(entity);
		if (projmeas != null) linkProjectMeasurementRepository.delete(projmeas);
		entity.setProjects_measurements(null);
		
		List<Event_Measurement> evmeas = linkEventMeasurementRepository.findByMeasurement(entity);
		if (evmeas != null) linkEventMeasurementRepository.delete(evmeas);
		entity.setEvents_measurements(null);
		
		List<Measurement_Measurement> measmeas1 = linkMeasurementMeasurementRepository.findByMeasurement1(entity);
		if (measmeas1 != null) linkMeasurementMeasurementRepository.delete(measmeas1);
		entity.setMeasurements_measurements1(null);
		
		List<Measurement_Measurement> measmeas2 = linkMeasurementMeasurementRepository.findByMeasurement2(entity);
		if (measmeas2 != null) linkMeasurementMeasurementRepository.delete(measmeas2);
		entity.setMeasurements_measurements2(null);
		
		List<Funding_Measurement> fundMeas = linkFundingMeasurementRepository.findByMeasurement(entity);
		if (fundMeas != null) linkFundingMeasurementRepository.delete(fundMeas);
		entity.setFundings_measurement(null);
		
		entity = measurementCrudRepository.save(entity);
		measurementCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.MeasurementRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<Measurement> entities) {
		measurementCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.MeasurementRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<Measurement> save(Iterable<Measurement> entities) {
		return measurementCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.MeasurementRepository#save(gr.ekt.cerif.entities.second.Measurement)
	 */
	@Override
	public Measurement save(Measurement entity) {
		return measurementCrudRepository.save(entity);
	}

	@Override
	public List<Measurement> findAll() {
		return measurementCrudRepository.findAll();
	}

	@Override
	public Page<Measurement> findAll(Pageable page) {
		return measurementCrudRepository.findAll(page);
	}

	@Override
	public Measurement findByUuid(String uuid) {
		return measurementCrudRepository.findByUuid(uuid);
	}
	
	@Override
	public Measurement findById(Long id) {
		return measurementCrudRepository.findById(id);
	}

}

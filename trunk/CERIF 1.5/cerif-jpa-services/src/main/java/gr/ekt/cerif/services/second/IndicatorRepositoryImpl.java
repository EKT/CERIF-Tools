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

import gr.ekt.cerif.entities.link.Equipment_Indicator;
import gr.ekt.cerif.entities.link.Event_Indicator;
import gr.ekt.cerif.entities.link.Facility_Indicator;
import gr.ekt.cerif.entities.link.Funding_Indicator;
import gr.ekt.cerif.entities.link.Indicator_Class;
import gr.ekt.cerif.entities.link.Indicator_Indicator;
import gr.ekt.cerif.entities.link.Indicator_Measurement;
import gr.ekt.cerif.entities.link.Medium_Indicator;
import gr.ekt.cerif.entities.link.Service_Indicator;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Indicator;
import gr.ekt.cerif.entities.link.person.Person_Indicator;
import gr.ekt.cerif.entities.link.project.Project_Indicator;
import gr.ekt.cerif.entities.link.result.ResultPatent_Indicator;
import gr.ekt.cerif.entities.link.result.ResultProduct_Indicator;
import gr.ekt.cerif.entities.link.result.ResultPublication_Indicator;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.multilingual.IndicatorDescription;
import gr.ekt.cerif.features.multilingual.IndicatorKeyword;
import gr.ekt.cerif.features.multilingual.IndicatorName;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentIndicatorRepository;
import gr.ekt.cerif.services.link.event.LinkEventIndicatorRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityIndicatorRepository;
import gr.ekt.cerif.services.link.funding.LinkFundingIndicatorRepository;
import gr.ekt.cerif.services.link.indicator.LinkIndicatorClassRepository;
import gr.ekt.cerif.services.link.indicator.LinkIndicatorIndicatorRepository;
import gr.ekt.cerif.services.link.indicator.LinkIndicatorMeasurementRepository;
import gr.ekt.cerif.services.link.medium.LinkMediumIndicatorRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitIndicatorRepository;
import gr.ekt.cerif.services.link.person.LinkPersonIndicatorRepository;
import gr.ekt.cerif.services.link.project.LinkProjectIndicatorRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentIndicatorRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductIndicatorRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationIndicatorRepository;
import gr.ekt.cerif.services.link.service.LinkServiceIndicatorRepository;
import gr.ekt.cerif.services.multilingual.indicator.IndicatorDescriptionRepository;
import gr.ekt.cerif.services.multilingual.indicator.IndicatorKeywordRepository;
import gr.ekt.cerif.services.multilingual.indicator.IndicatorNameRepository;

/**
 * @author bonisv
 *
 */
@Component
public class IndicatorRepositoryImpl implements IndicatorRepository {

	private static final Logger log = LoggerFactory.getLogger(IndicatorRepositoryImpl.class);

	@Autowired
	private IndicatorCrudRepository indicatorCrudRepository;
	
	@Autowired
	private IndicatorNameRepository indicatorNameRepository;
	
	@Autowired
	private IndicatorKeywordRepository indicatorKeywordRepository;
	
	@Autowired
	private IndicatorDescriptionRepository indicatorDescriptionRepository;
	
	@Autowired
	private LinkResultPatentIndicatorRepository linkResultPatentIndicatorRepository;
	
	@Autowired
	private LinkResultProductIndicatorRepository linkResultProductIndicatorRepository;
	
	@Autowired
	private LinkResultPublicationIndicatorRepository linkResultPublicationIndicatorRepository;
	
	@Autowired
	private LinkServiceIndicatorRepository linkServiceIndicatorRepository;
	
	@Autowired
	private LinkEquipmentIndicatorRepository linkEquipmentIndicatorRepository;
	
	@Autowired
	private LinkMediumIndicatorRepository linkMediumIndicatorRepository;
	
	@Autowired
	private LinkIndicatorMeasurementRepository linkIndicatorMeasurementRepository;
	
	@Autowired
	private LinkIndicatorClassRepository linkIndicatorClassRepository;
	
	@Autowired
	private LinkPersonIndicatorRepository linkPersonIndicatorRepository;
	
	@Autowired
	private LinkOrganisationUnitIndicatorRepository linkOrganisationUnitIndicatorRepository;
	
	@Autowired
	private LinkProjectIndicatorRepository linkProjectIndicatorRepository;
	
	@Autowired
	private LinkFacilityIndicatorRepository linkFacilityIndicatorRepository;
	
	@Autowired
	private LinkEventIndicatorRepository linkEventIndicatorRepository;
	
	@Autowired
	private LinkIndicatorIndicatorRepository linkIndicatorIndicatorRepository;
	
	@Autowired
	private LinkFundingIndicatorRepository linkFundingIndicatorRepository;

	
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.IndicatorRepository#delete(gr.ekt.cerif.entities.second.Indicator)
	 */
	@Override
	@Transactional
	public void delete(Indicator entity) {
		List<IndicatorName> indname = indicatorNameRepository.findByIndicator(entity);
		if (indname != null) indicatorNameRepository.delete(indname);
		entity.setIndicatorNames(null);
		
		List<IndicatorKeyword> indkey = indicatorKeywordRepository.findByIndicator(entity);
		if (indkey != null) indicatorKeywordRepository.delete(indkey);
		entity.setIndicatorKeywords(null);
		
		List<IndicatorDescription> inddescr = indicatorDescriptionRepository.findByIndicator(entity);
		if (inddescr != null) indicatorDescriptionRepository.delete(inddescr);
		entity.setIndicatorDescriptions(null);
		
		List<ResultPatent_Indicator> respatind = linkResultPatentIndicatorRepository.findByIndicator(entity);
		if (respatind != null) linkResultPatentIndicatorRepository.delete(respatind);
		entity.setResultPatents_indicators(null);
		
		List<ResultProduct_Indicator> resprodind = linkResultProductIndicatorRepository.findByIndicator(entity);
		if (resprodind != null) linkResultProductIndicatorRepository.delete(resprodind);
		entity.setResultProducts_indicators(null);
		
		List<ResultPublication_Indicator> respublind = linkResultPublicationIndicatorRepository.findByIndicator(entity);
		if (respublind != null) linkResultPublicationIndicatorRepository.delete(respublind);
		entity.setResultPublications_indicators(null);
		
		List<Service_Indicator> srvrespubl = linkServiceIndicatorRepository.findByIndicator(entity);
		if (srvrespubl != null) linkServiceIndicatorRepository.delete(srvrespubl);
		entity.setServices_indicators(null);
		
		List<Equipment_Indicator> equipind = linkEquipmentIndicatorRepository.findByIndicator(entity);
		if (equipind != null) linkEquipmentIndicatorRepository.delete(equipind);
		entity.setEquipments_indicators(null);
		
		List<Medium_Indicator> medind = linkMediumIndicatorRepository.findByIndicator(entity);
		if (medind != null) linkMediumIndicatorRepository.delete(medind);
		entity.setMediums_indicators(null);
		
		List<Indicator_Measurement> indmeas = linkIndicatorMeasurementRepository.findByIndicator(entity);
		if (indmeas != null) linkIndicatorMeasurementRepository.delete(indmeas);
		entity.setIndicators_measurements(null);
		
		List<Indicator_Class> indcl = linkIndicatorClassRepository.findByIndicator(entity);
		if (indcl != null) linkIndicatorClassRepository.delete(indcl);
		entity.setIndicators_classes(null);
		
		List<Person_Indicator> pin = linkPersonIndicatorRepository.findByIndicator(entity);
		if (pin != null) linkPersonIndicatorRepository.delete(pin);
		entity.setPersons_indicators(null);
		
		List<OrganisationUnit_Indicator> indi = linkOrganisationUnitIndicatorRepository.findByIndicator(entity);
		if (indi != null) linkOrganisationUnitIndicatorRepository.delete(indi);
		entity.setOrganisationUnits_indicators(null);
		
		List<Project_Indicator> projind = linkProjectIndicatorRepository.findByIndicator(entity);
		if (projind != null) linkProjectIndicatorRepository.delete(projind);
		entity.setProjects_indicators(null);
		
		List<Facility_Indicator> facind = linkFacilityIndicatorRepository.findByIndicator(entity);
		if (facind != null) linkFacilityIndicatorRepository.delete(facind);
		entity.setFacilities_indicators(null);
		
		List<Event_Indicator> evind = linkEventIndicatorRepository.findByIndicator(entity);
		if (evind != null) linkEventIndicatorRepository.delete(evind);
		entity.setEvents_indicators(null);
		
		List<Indicator_Indicator> indind1 = linkIndicatorIndicatorRepository.findByIndicator1(entity);
		if (indind1 != null) linkIndicatorIndicatorRepository.delete(indind1);
		entity.setIndicators_indicators1(null);
		
		List<Indicator_Indicator> indind2 = linkIndicatorIndicatorRepository.findByIndicator2(entity);
		if (indind2 != null) linkIndicatorIndicatorRepository.delete(indind2);
		entity.setIndicators_indicators2(null);
		
		List<Funding_Indicator> fundind = linkFundingIndicatorRepository.findByIndicator(entity);
		if (fundind != null) linkFundingIndicatorRepository.delete(fundind);
		entity.setFundings_indicators(null);
		
		entity = indicatorCrudRepository.save(entity);
		indicatorCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.IndicatorRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<Indicator> entities) {
		indicatorCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.IndicatorRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<Indicator> save(Iterable<Indicator> entities) {
		return indicatorCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.IndicatorRepository#save(gr.ekt.cerif.entities.second.Indicator)
	 */
	@Override
	public Indicator save(Indicator entity) {
		return indicatorCrudRepository.save(entity);
	}

	@Override
	public List<Indicator> findAll() {
		return indicatorCrudRepository.findAll();
	}

	@Override
	public Page<Indicator> findAll(Pageable page) {
		return indicatorCrudRepository.findAll(page);
	}

	@Override
	public Indicator findByUuid(String uuid) {
		return indicatorCrudRepository.findByUuid(uuid);
	}

	@Override
	public Indicator findById(Long id) {
		return indicatorCrudRepository.findById(id);
	}

}

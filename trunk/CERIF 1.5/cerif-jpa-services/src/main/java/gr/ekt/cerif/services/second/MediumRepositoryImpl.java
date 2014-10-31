package gr.ekt.cerif.services.second;

import java.util.List;

import gr.ekt.cerif.entities.link.Citation_Medium;
import gr.ekt.cerif.entities.link.Equipment_Medium;
import gr.ekt.cerif.entities.link.Event_Medium;
import gr.ekt.cerif.entities.link.Facility_Medium;
import gr.ekt.cerif.entities.link.Medium_Class;
import gr.ekt.cerif.entities.link.Medium_Funding;
import gr.ekt.cerif.entities.link.Medium_Indicator;
import gr.ekt.cerif.entities.link.Medium_Measurement;
import gr.ekt.cerif.entities.link.Medium_Medium;
import gr.ekt.cerif.entities.link.Service_Medium;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Medium;
import gr.ekt.cerif.entities.link.person.Person_Medium;
import gr.ekt.cerif.entities.link.project.Project_Medium;
import gr.ekt.cerif.entities.link.result.ResultProduct_Medium;
import gr.ekt.cerif.entities.link.result.ResultPublication_Medium;
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.multilingual.MediumDescription;
import gr.ekt.cerif.features.multilingual.MediumKeyword;
import gr.ekt.cerif.features.multilingual.MediumTitle;
import gr.ekt.cerif.services.link.citation.LinkCitationMediumRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentMediumRepository;
import gr.ekt.cerif.services.link.event.LinkEventMediumRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityMediumRepository;
import gr.ekt.cerif.services.link.medium.LinkMediumClassRepository;
import gr.ekt.cerif.services.link.medium.LinkMediumFundingRepository;
import gr.ekt.cerif.services.link.medium.LinkMediumIndicatorRepository;
import gr.ekt.cerif.services.link.medium.LinkMediumMeasurementRepository;
import gr.ekt.cerif.services.link.medium.LinkMediumMediumRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitMediumRepository;
import gr.ekt.cerif.services.link.person.LinkPersonMediumRepository;
import gr.ekt.cerif.services.link.project.LinkProjectMediumRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductMediumRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationMediumRepository;
import gr.ekt.cerif.services.link.service.LinkServiceMediumRepository;
import gr.ekt.cerif.services.multilingual.medium.MediumDescriptionRepository;
import gr.ekt.cerif.services.multilingual.medium.MediumKeywordRepository;
import gr.ekt.cerif.services.multilingual.medium.MediumTitleRepository;

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
public class MediumRepositoryImpl implements MediumRepository {
	
	private static final Logger log = LoggerFactory.getLogger(MediumRepositoryImpl.class);

	@Autowired
	private MediumCrudRepository mediumCrudRepository;
	
	@Autowired
	private LinkMediumMeasurementRepository linkMediumMeasurementRepository;
	
	@Autowired
	private MediumTitleRepository mediumTitleRepository;
	
	@Autowired
	private MediumKeywordRepository mediumKeywordRepository;
	
	@Autowired
	private MediumDescriptionRepository mediumDescriptionRepository;
	
	@Autowired
	private LinkResultPublicationMediumRepository linkResultPublicationMediumRepository;
	
	@Autowired
	private LinkServiceMediumRepository linkServiceMediumRepository;
	
	@Autowired
	private LinkEquipmentMediumRepository linkEquipmentMediumRepository;
	
	@Autowired
	private LinkEventMediumRepository linkEventMediumRepository;
	
	@Autowired
	private LinkFacilityMediumRepository linkFacilityMediumRepository;
	
	@Autowired
	private LinkMediumFundingRepository linkMediumFundingRepository;
	
	@Autowired
	private LinkMediumIndicatorRepository linkMediumIndicatorRepository;
	
	@Autowired
	private LinkMediumMediumRepository linkMediumMediumRepository;
	
	@Autowired
	private LinkProjectMediumRepository linkProjectMediumRepository;
	
	@Autowired
	private LinkMediumClassRepository linkMediumClassRepository;
	
	@Autowired
	private LinkResultProductMediumRepository linkResultProductMediumRepository;
	
	@Autowired
	private LinkPersonMediumRepository linkPersonMediumRepository;
	
	@Autowired
	private LinkOrganisationUnitMediumRepository linkOrganisationUnitMediumRepository;
	
	@Autowired
	private LinkCitationMediumRepository linkCitationMediumRepository;
	
	

	@Override
	public Medium findByUri(String uri) {
		return mediumCrudRepository.findByUri(uri);
	}

	@Override
	@Transactional
	public void delete(Medium entity) {
		List<MediumTitle> medtitle = mediumTitleRepository.findByMedium(entity);
		if (medtitle != null) mediumTitleRepository.delete(medtitle);
		entity.setMediumTitles(null);
		
		List<MediumKeyword> medkey = mediumKeywordRepository.findByMedium(entity);
		if (medkey != null) mediumKeywordRepository.delete(medkey);
		entity.setMediumKeywords(null);
		
		List<MediumDescription> meddescr = mediumDescriptionRepository.findByMedium(entity);
		if (meddescr != null) mediumDescriptionRepository.delete(meddescr);
		entity.setMediumDescriptions(null);
		
		List<ResultPublication_Medium> rm = linkResultPublicationMediumRepository.findByMedium(entity);
		if (rm != null) linkResultPublicationMediumRepository.delete(rm);
		entity.setResultPublications_mediums(null);
		
		List<Service_Medium> srvmed = linkServiceMediumRepository.findByMedium(entity);
		if (srvmed != null) linkServiceMediumRepository.delete(srvmed);
		entity.setServices_mediums(null);
		
		List<Equipment_Medium> equipmed = linkEquipmentMediumRepository.findByMedium(entity);
		if (equipmed != null) linkEquipmentMediumRepository.delete(equipmed);
		entity.setEquipments_mediums(null);
		
		List<Event_Medium> evpmed = linkEventMediumRepository.findByMedium(entity);
		if (evpmed != null) linkEventMediumRepository.delete(evpmed);
		entity.setEvents_mediums(null);
		
		List<Facility_Medium> facmed = linkFacilityMediumRepository.findByMedium(entity);
		if (facmed != null) linkFacilityMediumRepository.delete(facmed);
		entity.setFacilities_mediums(null);
		
		List<Medium_Funding> medfund = linkMediumFundingRepository.findByMedium(entity);
		if (medfund != null) linkMediumFundingRepository.delete(medfund);
		entity.setMediums_fundings(null);
		
		List<Medium_Indicator> medind = linkMediumIndicatorRepository.findByMedium(entity);
		if (medind != null) linkMediumIndicatorRepository.delete(medind);
		entity.setMediums_indicators(null);		
		
		List<Medium_Measurement> medpmeas = linkMediumMeasurementRepository.findByMedium(entity);
		if (medpmeas != null) linkMediumMeasurementRepository.delete(medpmeas);
		entity.setMediums_measurements(null);
		
		List<Medium_Medium> medmed1 = linkMediumMediumRepository.findByMedium1(entity);
		if (medmed1 != null) linkMediumMediumRepository.delete(medmed1);
		entity.setMediums_mediums1(null);
		
		List<Medium_Medium> medmed2 = linkMediumMediumRepository.findByMedium2(entity);
		if (medmed2 != null) linkMediumMediumRepository.delete(medmed2);
		entity.setMediums_mediums2(null);
		
		List<Project_Medium> pmed = linkProjectMediumRepository.findByMedium(entity);
		if (pmed != null) linkProjectMediumRepository.delete(pmed);
		entity.setProjects_mediums(null);
		
		List<Medium_Class> medcl = linkMediumClassRepository.findByMedium(entity);
		if (medcl != null) linkMediumClassRepository.delete(medcl);
		entity.setMediums_classes(null);
		
		List<ResultProduct_Medium> resprodmed = linkResultProductMediumRepository.findByMedium(entity);
		if (resprodmed != null) linkResultProductMediumRepository.delete(resprodmed);
		entity.setResultProducts_mediums(null);
		
		List<Person_Medium> pm = linkPersonMediumRepository.findByMedium(entity);
		if (pm != null) linkPersonMediumRepository.delete(pm);
		entity.setPersons_mediums(null);
		
		List<OrganisationUnit_Medium> orgMed = linkOrganisationUnitMediumRepository.findByMedium(entity);
		if (orgMed != null) linkOrganisationUnitMediumRepository.delete(orgMed);
		entity.setOrganisationUnits_mediums(null);
		
		List<Citation_Medium> citmed = linkCitationMediumRepository.findByMedium(entity);
		if (citmed != null) linkCitationMediumRepository.delete(citmed);
		entity.setCitations_mediums(null);
		
		entity = mediumCrudRepository.save(entity);
		mediumCrudRepository.delete(entity);
	}
	
	@Transactional
	public void delete(Iterable<Medium> entityList) {
		mediumCrudRepository.delete(entityList);
	}

	@Override
	public Iterable<Medium> save(Iterable<Medium> entities) {
		return mediumCrudRepository.save(entities);
	}

	@Override
	public Medium save(Medium entity) {
		return mediumCrudRepository.save(entity);
	}

	@Override
	public Medium findById(Long id) {
		return mediumCrudRepository.findById(id);
	}

	@Override
	public Medium findMediumByProjectIdAndClassUUID(Long id, String uuid) {
		return mediumCrudRepository.findMediumByProjectIdAndClassUUID(id, uuid);
	}

	@Override
	public Medium findMediumByOrgIdAndClassUUID(Long id, String uuid) {
		return mediumCrudRepository.findMediumByOrgIdAndClassUUID(id, uuid);
	}

	@Override
	public Medium findMediumByPersonIdAndClassUUID(Long id, String uuid) {
		return mediumCrudRepository.findMediumByPersonIdAndClassUUID(id, uuid);
	}

	@Override
	public List<Medium> findAll() {
		return mediumCrudRepository.findAll();
	}

	@Override
	public Page<Medium> findAll(Pageable page) {
		return mediumCrudRepository.findAll(page);
	}

	@Override
	public Medium findByUuid(String uuid) {
		return mediumCrudRepository.findByUuid(uuid);
	}


}

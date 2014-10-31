package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.link.result.ResultPublication_Citation;
import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.link.result.ResultPublication_Equipment;
import gr.ekt.cerif.entities.link.result.ResultPublication_Event;
import gr.ekt.cerif.entities.link.result.ResultPublication_Facility;
import gr.ekt.cerif.entities.link.result.ResultPublication_Funding;
import gr.ekt.cerif.entities.link.result.ResultPublication_Indicator;
import gr.ekt.cerif.entities.link.result.ResultPublication_Measurement;
import gr.ekt.cerif.entities.link.result.ResultPublication_Medium;
import gr.ekt.cerif.entities.link.result.ResultPublication_Metrics;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPatent;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPublication;
import gr.ekt.cerif.entities.link.result.ResultPublication_Service;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;
import gr.ekt.cerif.features.multilingual.ResultPublicationBibliographicNote;
import gr.ekt.cerif.features.multilingual.ResultPublicationKeyword;
import gr.ekt.cerif.features.multilingual.ResultPublicationNameAbbreviation;
import gr.ekt.cerif.features.multilingual.ResultPublicationSubtitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationVersionInfo;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitResultPublicationRepository;
import gr.ekt.cerif.services.link.person.LinkPersonResultPublicationRepository;
import gr.ekt.cerif.services.link.project.LinkProjectResultPublicationRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationCitationRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationClassRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationEquipmentRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationEventRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationFacilityRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationFundingRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationIndicatorRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationMeasurementRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationMediumRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationMetricsRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationResultPatentRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationResultProductRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationResultPublicationRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationServiceRepository;
import gr.ekt.cerif.services.multilingual.resultpublication.ResultPublicationAbstractRepository;
import gr.ekt.cerif.services.multilingual.resultpublication.ResultPublicationBibliographicNoteRepository;
import gr.ekt.cerif.services.multilingual.resultpublication.ResultPublicationKeywordRepository;
import gr.ekt.cerif.services.multilingual.resultpublication.ResultPublicationNameAbbreviationRepository;
import gr.ekt.cerif.services.multilingual.resultpublication.ResultPublicationSubtitleRepository;
import gr.ekt.cerif.services.multilingual.resultpublication.ResultPublicationTitleRepository;
import gr.ekt.cerif.services.multilingual.resultpublication.ResultPublicationVersionInfoRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ResultPublicationRepositoryImpl implements ResultPublicationRepository {

	private static final Logger log = LoggerFactory.getLogger(ResultPublicationRepositoryImpl.class);
	
	@Autowired
	private ResultPublicationCrudRepository resultPublicationCrudRepository;
	
	@Autowired
	private ResultPublicationTitleRepository resultPublicationTitleRepository;
	
	@Autowired
	private ResultPublicationAbstractRepository resultPublicationAbstractRepository;
	
	@Autowired
	private LinkResultPublicationClassRepository linkResultPublicationClassRepository;
	
	@Autowired
	private LinkOrganisationUnitResultPublicationRepository linkOrganisationUnitResultPublicationRepository;
	
	@Autowired
	private LinkProjectResultPublicationRepository linkProjectResultPublicationRepository;
	
	@Autowired
	private LinkPersonResultPublicationRepository linkPersonResultPublicationRepository;
	
	@Autowired
	private LinkResultPublicationEventRepository linkResultPublicationEventRepository;
	
	@Autowired
	private LinkResultPublicationMediumRepository linkResultPublicationMediumRepository;
	
	@Autowired
	private ResultPublicationSubtitleRepository resultPublicationSubtitleRepository;
	
	@Autowired
	private ResultPublicationKeywordRepository resultPublicationKeywordRepository;
	
	@Autowired
	private ResultPublicationBibliographicNoteRepository resultPublicationBibliographicNoteRepository;
	
	@Autowired
	private ResultPublicationNameAbbreviationRepository resultPublicationNameAbbreviationRepository;
	
	@Autowired
	private ResultPublicationVersionInfoRepository resultPublicationVersionInfoRepository;
	
	@Autowired
	private LinkResultPublicationResultProductRepository linkResultPublicationResultProductRepository;
	
	@Autowired
	private LinkResultPublicationCitationRepository linkResultPublicationCitationRepository;
	
	@Autowired
	private LinkResultPublicationEquipmentRepository linkResultPublicationEquipmentRepository;
	
	@Autowired
	private LinkResultPublicationFacilityRepository linkResultPublicationFacilityRepository;
	
	@Autowired
	private LinkResultPublicationFundingRepository linkResultPublicationFundingRepository;
	
	@Autowired
	private LinkResultPublicationIndicatorRepository linkResultPublicationIndicatorRepository;
	
	@Autowired
	private LinkResultPublicationMeasurementRepository linkResultPublicationMeasurementRepository;
	
	@Autowired
	private LinkResultPublicationMetricsRepository linkResultPublicationMetricsRepository;
	
	@Autowired
	private LinkResultPublicationResultPatentRepository linkResultPublicationResultPatentRepository;
	
	@Autowired
	private LinkResultPublicationResultPublicationRepository linkResultPublicationResultPublicationRepository;
	
	@Autowired
	private LinkResultPublicationServiceRepository linkResultPublicationServiceRepository;
	
	
	@Override
	public ResultPublication findByUri(String uri) {
		return resultPublicationCrudRepository.findByUri(uri);
	}

	@Override
	public ResultPublication findById(Long id) {
		return resultPublicationCrudRepository.findById(id);
	}
	
	@Override
	@Transactional
	public void delete(ResultPublication entity) {
		
		List<ResultPublicationTitle> rt = resultPublicationTitleRepository.findByResultPublication(entity);
		if (rt != null) resultPublicationTitleRepository.delete(rt);
		entity.setResultPublicationTitles(null);
		
		List<ResultPublicationSubtitle> respublsubtitl = resultPublicationSubtitleRepository.findByResultPublication(entity);
		if (respublsubtitl != null) resultPublicationSubtitleRepository.delete(respublsubtitl);
		entity.setResultPublicationSubtitles(null);
		
		List<ResultPublicationAbstract> ra = resultPublicationAbstractRepository.findByResultPublication(entity);
		if (ra != null) resultPublicationAbstractRepository.delete(ra);
		entity.setResultPublicationAbstracts(null);
		
		List<ResultPublicationKeyword> respublkey = resultPublicationKeywordRepository.findByResultPublication(entity);
		if (respublkey != null) resultPublicationKeywordRepository.delete(respublkey);
		entity.setResultPublicationKeywords(null);
		
		List<ResultPublicationBibliographicNote> respublbiblnote = resultPublicationBibliographicNoteRepository.findByResultPublication(entity);
		if (respublbiblnote != null) resultPublicationBibliographicNoteRepository.delete(respublbiblnote);
		entity.setResultPublicationBibliographicNotes(null);
		
		List<ResultPublicationNameAbbreviation> respublnameabbr = resultPublicationNameAbbreviationRepository.findByResultPublication(entity);
		if (respublnameabbr != null) resultPublicationNameAbbreviationRepository.delete(respublnameabbr);
		entity.setResultPublicationNameAbbreviations(null);
		
		List<ResultPublicationVersionInfo> respublversinf = resultPublicationVersionInfoRepository.findByResultPublication(entity);
		if (respublversinf != null) resultPublicationVersionInfoRepository.delete(respublversinf);
		entity.setResultPublicationVersionInfos(null);
		
		List<ResultPublication_ResultProduct> respublresprod = linkResultPublicationResultProductRepository.findByResultPublication(entity);
		if (respublresprod != null) linkResultPublicationResultProductRepository.delete(respublresprod);
		entity.setResultPublications_resultProducts(null);

		List<ResultPublication_Class> rc =  linkResultPublicationClassRepository.findByResultPublication(entity);
		if (rc != null) linkResultPublicationClassRepository.delete(rc);
		entity.setResultPublications_classes(null);
		
		List<OrganisationUnit_ResultPublication> or = linkOrganisationUnitResultPublicationRepository.findByResultPublication(entity);
		if (or != null) linkOrganisationUnitResultPublicationRepository.delete(or);
		entity.setOrganisationUnits_resultPublications(null);
		
		List<Project_ResultPublication> pr = linkProjectResultPublicationRepository.findByResultPublication(entity);
		if (pr != null) linkProjectResultPublicationRepository.delete(pr);
		entity.setProjects_resultPublications(null);
		
		List<Person_ResultPublication> prp = linkPersonResultPublicationRepository.findByResultPublication(entity);
		if (prp != null) linkPersonResultPublicationRepository.delete(prp);
		entity.setPersons_resultPublications(null);

		List<ResultPublication_Event> re = linkResultPublicationEventRepository.findByResultPublication(entity);
		if (re != null) linkResultPublicationEventRepository.delete(re);
		entity.setResultPublications_events(null);
		
		List<ResultPublication_Medium> rm = linkResultPublicationMediumRepository.findByResultPublication(entity);
		if (rm != null) linkResultPublicationMediumRepository.delete(rm);
		entity.setResultPublications_mediums(null);
		
		List<ResultPublication_Citation> respublcite = linkResultPublicationCitationRepository.findByResultPublication(entity);
		if (respublcite != null) linkResultPublicationCitationRepository.delete(respublcite);
		entity.setResultPublications_citations(null);
		
		List<ResultPublication_Equipment> respubleq = linkResultPublicationEquipmentRepository.findByResultPublication(entity);
		if (respubleq != null) linkResultPublicationEquipmentRepository.delete(respubleq);
		entity.setResultPublications_equipments(null);
		
		List<ResultPublication_Facility> respublfac = linkResultPublicationFacilityRepository.findByResultPublication(entity);
		if (respublfac != null) linkResultPublicationFacilityRepository.delete(respublfac);
		entity.setResultPublications_facilities(null);
		
		List<ResultPublication_Funding> respublfund = linkResultPublicationFundingRepository.findByResultPublication(entity);
		if (respublfund != null) linkResultPublicationFundingRepository.delete(respublfund);
		entity.setResultPublications_fundings(null);
		
		List<ResultPublication_Indicator> respublind = linkResultPublicationIndicatorRepository.findByResultPublication(entity);
		if (respublind != null) linkResultPublicationIndicatorRepository.delete(respublind);
		entity.setResultPublications_indicators(null);
		
		List<ResultPublication_Measurement> respublmeas = linkResultPublicationMeasurementRepository.findByResultPublication(entity);
		if (respublmeas != null) linkResultPublicationMeasurementRepository.delete(respublmeas);
		entity.setResultPublications_measurements(null);
		
		List<ResultPublication_Metrics> respublmetr = linkResultPublicationMetricsRepository.findByResultPublication(entity);
		if (respublmetr != null) linkResultPublicationMetricsRepository.delete(respublmetr);
		entity.setResultPublications_metrics(null);

		List<ResultPublication_ResultPatent> respatrespubl = linkResultPublicationResultPatentRepository.findByResultPublication(entity);
		if (respatrespubl != null) linkResultPublicationResultPatentRepository.delete(respatrespubl);
		entity.setResultPublications_resultPatents(null);
		
		List<ResultPublication_ResultPublication> respublrespubl1 = linkResultPublicationResultPublicationRepository.findByResultPublication1(entity);
		if (respublrespubl1 != null) linkResultPublicationResultPublicationRepository.delete(respublrespubl1);
		entity.setResultPublications_resultPublications1(null);
		
		List<ResultPublication_ResultPublication> respublrespubl2 = linkResultPublicationResultPublicationRepository.findByResultPublication2(entity);
		if (respublrespubl2 != null) linkResultPublicationResultPublicationRepository.delete(respublrespubl2);
		entity.setResultPublications_resultPublications2(null);
		
		List<ResultPublication_Service> respublsrv = linkResultPublicationServiceRepository.findByResultPublication(entity);
		if (respublsrv != null) linkResultPublicationServiceRepository.delete(respublsrv);
		entity.setResultPublications_services(null);
		
		entity = resultPublicationCrudRepository.save(entity);
		resultPublicationCrudRepository.delete(entity);
	}

	@Transactional
	public Iterable<ResultPublication> save(Iterable<ResultPublication> entities) {
		return resultPublicationCrudRepository.save(entities);
	}

	@Transactional
	public ResultPublication save(ResultPublication entity) {
		return resultPublicationCrudRepository.save(entity);
	}

	@Override
	public void delete(Iterable<ResultPublication> entities) {
		resultPublicationCrudRepository.delete(entities);		
	}

	@Override
	public List<ResultPublication> findAll() {
		return resultPublicationCrudRepository.findAll();
	}

	@Override
	public Page<ResultPublication> findAll(Pageable page) {
		return resultPublicationCrudRepository.findAll(page);
	}

	@Override
	public ResultPublication findByUUID(String uuid) {
		return resultPublicationCrudRepository.findByUuid(uuid);
	}

}

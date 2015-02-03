package gr.ekt.cerif.services.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPatent;
import gr.ekt.cerif.entities.link.person.Person_ResultPatent;
import gr.ekt.cerif.entities.link.project.Project_ResultPatent;
import gr.ekt.cerif.entities.link.result.ResultPatent_Class;
import gr.ekt.cerif.entities.link.result.ResultPatent_Equipment;
import gr.ekt.cerif.entities.link.result.ResultPatent_Facility;
import gr.ekt.cerif.entities.link.result.ResultPatent_Funding;
import gr.ekt.cerif.entities.link.result.ResultPatent_Indicator;
import gr.ekt.cerif.entities.link.result.ResultPatent_Measurement;
import gr.ekt.cerif.entities.link.result.ResultPatent_Medium;
import gr.ekt.cerif.entities.link.result.ResultPatent_ResultPatent;
import gr.ekt.cerif.entities.link.result.ResultPatent_Service;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPatent;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.multilingual.ResultPatentAbstract;
import gr.ekt.cerif.features.multilingual.ResultPatentKeyword;
import gr.ekt.cerif.features.multilingual.ResultPatentTitle;
import gr.ekt.cerif.features.multilingual.ResultPatentVersionInfo;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitResultPatentRepository;
import gr.ekt.cerif.services.link.person.LinkPersonResultPatentRepository;
import gr.ekt.cerif.services.link.project.LinkProjectResultPatentRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentClassRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentEquipmentRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentFacilityRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentFundingRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentIndicatorRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentMeasurementRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentMediumRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentResultPatentRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentServiceRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationResultPatentRepository;
import gr.ekt.cerif.services.multilingual.resultpatent.ResultPatentAbstractRepository;
import gr.ekt.cerif.services.multilingual.resultpatent.ResultPatentKeywordRepository;
import gr.ekt.cerif.services.multilingual.resultpatent.ResultPatentTitleRepository;
import gr.ekt.cerif.services.multilingual.resultpatent.ResultPatentVersionInfoRepository;

/**
 * @author bonisv
 *
 */
@Component
public class ResultPatentRepositoryImpl implements ResultPatentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultPatentRepositoryImpl.class);

	@Autowired
	private ResultPatentCrudRepository resultPatentCrudRepository;
	
	@Autowired
	private ResultPatentTitleRepository resultPatentTitleRepository;
	
	@Autowired
	private ResultPatentAbstractRepository resultPatentAbstractRepository;
	
	@Autowired
	private ResultPatentKeywordRepository resultPatentKeywordRepository;
	
	@Autowired
	private ResultPatentVersionInfoRepository resultPatentVersionInfoRepository;
	
	@Autowired
	private LinkProjectResultPatentRepository linkProjectResultPatentRepository;
	
	@Autowired
	private LinkPersonResultPatentRepository linkPersonResultPatentRepository;
	
	@Autowired
	private LinkResultPatentClassRepository linkResultPatentClassRepository;
	
	@Autowired
	private LinkResultPatentFundingRepository linkResultPatentFundingRepository;
	
	@Autowired
	private LinkResultPatentIndicatorRepository linkResultPatentIndicatorRepository;
	
	@Autowired
	private LinkResultPatentMeasurementRepository linkResultPatentMeasurementRepository;
	
	@Autowired
	private LinkResultPatentResultPatentRepository linkResultPatentResultPatentRepository;
	
	@Autowired
	private LinkResultPublicationResultPatentRepository linkResultPublicationResultPatentRepository;
	
	@Autowired
	private LinkResultPatentServiceRepository linkResultPatentServiceRepository;
	
	@Autowired
	private LinkResultPatentEquipmentRepository linkResultPatentEquipmentRepository;
	
	@Autowired
	private LinkResultPatentFacilityRepository linkResultPatentFacilityRepository;
	
	@Autowired
	private LinkOrganisationUnitResultPatentRepository linkOrganisationUnitResultPatentRepository;
	
	@Autowired
	private LinkResultPatentMediumRepository linkResultPatentMediumRepository;
	
	
	@Override
	@Transactional
	public void delete(ResultPatent entity) {
		List<ResultPatentTitle> respattitl = resultPatentTitleRepository.findByResultPatent(entity);
		if (respattitl != null) resultPatentTitleRepository.delete(respattitl);
		entity.setResultPatentTitles(null);
		
		List<ResultPatentAbstract> respatabstr = resultPatentAbstractRepository.findByResultPatent(entity);
		if (respatabstr != null) resultPatentAbstractRepository.delete(respatabstr);
		entity.setResultPatentAbstracts(null);
		
		List<ResultPatentKeyword> respatkey = resultPatentKeywordRepository.findByResultPatent(entity);
		if (respatkey != null) resultPatentKeywordRepository.delete(respatkey);
		entity.setResultPatentKeywords(null);
		
		List<ResultPatentVersionInfo> respatversinf = resultPatentVersionInfoRepository.findByResultPatent(entity);
		if (respatversinf != null) resultPatentVersionInfoRepository.delete(respatversinf);
		entity.setResultPatentVersionInfos(null);
		
		List<Project_ResultPatent> prespat = linkProjectResultPatentRepository.findByResultPatent(entity);
		if (prespat != null) linkProjectResultPatentRepository.delete(prespat);
		entity.setProjects_resultPatents(null);
		
		List<Person_ResultPatent> rpat = linkPersonResultPatentRepository.findByResultPatent(entity);
		if (rpat != null) linkPersonResultPatentRepository.delete(rpat);
		entity.setPersons_resultPatents(null);
		
		List<ResultPatent_Class> respatcl = linkResultPatentClassRepository.findByResultPatent(entity);
		if (respatcl != null) linkResultPatentClassRepository.delete(respatcl);
		entity.setResultPatents_classes(null);
		
		List<ResultPatent_Funding> respatfund = linkResultPatentFundingRepository.findByResultPatent(entity);
		if (respatfund != null) linkResultPatentFundingRepository.delete(respatfund);
		entity.setResultPatents_fundings(null);
		
		List<ResultPatent_Indicator> respatind = linkResultPatentIndicatorRepository.findByResultPatent(entity);
		if (respatind != null) linkResultPatentIndicatorRepository.delete(respatind);
		entity.setResultPatents_indicators(null);
		
		List<ResultPatent_Measurement> respatmeas = linkResultPatentMeasurementRepository.findByResultPatent(entity);
		if (respatmeas != null) linkResultPatentMeasurementRepository.delete(respatmeas);
		entity.setResultPatents_measurements(null);
		
		List<ResultPatent_ResultPatent> respatrespat1 = linkResultPatentResultPatentRepository.findByResultPatent1(entity);
		if (respatrespat1 != null) linkResultPatentResultPatentRepository.delete(respatrespat1);
		entity.setResultPatents_resultPatents1(null);
		
		List<ResultPatent_ResultPatent> respatrespat2 = linkResultPatentResultPatentRepository.findByResultPatent2(entity);
		if (respatrespat2 != null) linkResultPatentResultPatentRepository.delete(respatrespat2);
		entity.setResultPatents_resultPatents2(null);
		
		List<ResultPublication_ResultPatent> respatrespubl = linkResultPublicationResultPatentRepository.findByResultPatent(entity);
		if (respatrespubl != null) linkResultPublicationResultPatentRepository.delete(respatrespubl);
		entity.setResultPublications_resultPatents(null);
		
		List<ResultPatent_Service> respatserv = linkResultPatentServiceRepository.findByResultPatent(entity);
		if (respatserv != null) linkResultPatentServiceRepository.delete(respatserv);
		entity.setResultPatents_services(null);
		
		List<ResultPatent_Equipment> respatequip = linkResultPatentEquipmentRepository.findByResultPatent(entity);
		if (respatequip != null) linkResultPatentEquipmentRepository.delete(respatequip);
		entity.setResultPatents_equipments(null);
		
		List<ResultPatent_Facility> respatflfac = linkResultPatentFacilityRepository.findByResultPatent(entity);
		if (respatflfac != null) linkResultPatentFacilityRepository.delete(respatflfac);
		entity.setResultPatents_facilities(null);
		
		List<OrganisationUnit_ResultPatent> pats = linkOrganisationUnitResultPatentRepository.findByResultPatent(entity);
		if (pats != null) linkOrganisationUnitResultPatentRepository.delete(pats);
		entity.setOrganisationUnits_resultPatents(null);
		
		List<ResultPatent_Medium> respatMed = linkResultPatentMediumRepository.findByResultPatent(entity);
		if (respatMed != null) linkResultPatentMediumRepository.delete(respatMed);
		entity.setResultPatents_mediums(null);
		
		entity = resultPatentCrudRepository.save(entity);
		resultPatentCrudRepository.delete(entity);
	}
	
	@Transactional
	public Iterable<ResultPatent> save(Iterable<ResultPatent> entities) {
		return resultPatentCrudRepository.save(entities);
	}

	@Transactional
	public ResultPatent save(ResultPatent entity) {
		return resultPatentCrudRepository.save(entity);
	}

	@Override
	public void delete(Iterable<ResultPatent> entities) {
		resultPatentCrudRepository.delete(entities);		
	}

	@Override
	public List<ResultPatent> findAll() {
		return resultPatentCrudRepository.findAll();
	}

	@Override
	public Page<ResultPatent> findAll(Pageable page) {
		return resultPatentCrudRepository.findAll(page);
	}

	@Override
	public ResultPatent findById(Long id) {
		return resultPatentCrudRepository.findById(id);
	}

	@Override
	public List<ResultPatent> findByUri(String uri) {
		return resultPatentCrudRepository.findByUri(uri);
	}

	@Override
	public ResultPatent findByUuid(String uuid) {
		return resultPatentCrudRepository.findByUuid(uuid);
	}
	

}

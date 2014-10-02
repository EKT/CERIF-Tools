/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.link.Equipment_Funding;
import gr.ekt.cerif.entities.link.Event_Funding;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.entities.link.Funding_Funding;
import gr.ekt.cerif.entities.link.Funding_Indicator;
import gr.ekt.cerif.entities.link.Funding_Measurement;
import gr.ekt.cerif.entities.link.Medium_Funding;
import gr.ekt.cerif.entities.link.Service_Funding;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Funding;
import gr.ekt.cerif.entities.link.person.Person_Funding;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.link.result.ResultPatent_Funding;
import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;
import gr.ekt.cerif.entities.link.result.ResultPublication_Funding;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.multilingual.FundingDescription;
import gr.ekt.cerif.features.multilingual.FundingKeyword;
import gr.ekt.cerif.features.multilingual.FundingName;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentFundingRepository;
import gr.ekt.cerif.services.link.event.LinkEventFundingRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityFundingRepository;
import gr.ekt.cerif.services.link.funding.LinkFundingClassRepository;
import gr.ekt.cerif.services.link.funding.LinkFundingFundingRepository;
import gr.ekt.cerif.services.link.funding.LinkFundingIndicatorRepository;
import gr.ekt.cerif.services.link.funding.LinkFundingMeasurementRepository;
import gr.ekt.cerif.services.link.medium.LinkMediumFundingRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitFundingRepository;
import gr.ekt.cerif.services.link.person.LinkPersonFundingRepository;
import gr.ekt.cerif.services.link.project.LinkProjectFundingRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentFundingRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductFundingRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationFundingRepository;
import gr.ekt.cerif.services.link.service.LinkServiceFundingRepository;
import gr.ekt.cerif.services.multilingual.funding.FundingDescriptionRepository;
import gr.ekt.cerif.services.multilingual.funding.FundingKeywordRepository;
import gr.ekt.cerif.services.multilingual.funding.FundingNameRepository;

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
public class FundingRepositoryImpl implements FundingRepository {

	private static final Logger log = LoggerFactory.getLogger(FundingRepositoryImpl.class);

	@Autowired
	private FundingCrudRepository fundingCrudRepository;
	
	@Autowired
	private FundingNameRepository fundingNameRepository;
	
	@Autowired
	private FundingKeywordRepository fundingKeywordRepository;
	
	@Autowired
	private FundingDescriptionRepository fundingDescriptionRepository;
	
	@Autowired
	private LinkProjectFundingRepository linkProjectFundingRepository;
	
	@Autowired
	private LinkOrganisationUnitFundingRepository linkOrganisationUnitFundingRepository;
	
	@Autowired
	private LinkPersonFundingRepository linkPersonFundingRepository;
	
	@Autowired
	private LinkResultPatentFundingRepository linkResultPatentFundingRepository;
	
	@Autowired
	private LinkResultProductFundingRepository linkResultProductFundingRepository;
	
	@Autowired
	private LinkResultPublicationFundingRepository linkResultPublicationFundingRepository;
	
	@Autowired
	private LinkFundingClassRepository linkFundingClassRepository;
	
	@Autowired
	private LinkFacilityFundingRepository linkFacilityFundingRepository;
	
	@Autowired
	private LinkFundingFundingRepository linkFundingFundingRepository;
	
	@Autowired
	private LinkServiceFundingRepository linkServiceFundingRepository;
	
	@Autowired
	private LinkEquipmentFundingRepository linkEquipmentFundingRepository;
	
	@Autowired
	private LinkMediumFundingRepository linkMediumFundingRepository;
	
	@Autowired
	private LinkFundingIndicatorRepository linkFundingIndicatorRepository;
	
	@Autowired
	private LinkEventFundingRepository linkEventFundingRepository;	
	
	@Autowired
	private LinkFundingMeasurementRepository linkFundingMeasurementRepository;
	
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FundingRepository#delete(gr.ekt.cerif.entities.second.Funding)
	 */
	@Override
	@Transactional
	public void delete(Funding entity) {
		List<FundingName> fundname = fundingNameRepository.findByFunding(entity);
		if (fundname != null) fundingNameRepository.delete(fundname);
		entity.setFundingNames(null);
		
		List<FundingKeyword> fundkey = fundingKeywordRepository.findByFunding(entity);
		if (fundkey != null) fundingKeywordRepository.delete(fundkey);
		entity.setFundingKeywords(null);
		
		List<FundingDescription> funddescr = fundingDescriptionRepository.findByFunding(entity);
		if (funddescr != null) fundingDescriptionRepository.delete(funddescr);
		entity.setFundingDescriptions(null);
		
		List<Project_Funding> pf = linkProjectFundingRepository.findByFunding(entity);
		if (pf != null) linkProjectFundingRepository.delete(pf);
		entity.setProjects_fundings(null);
		
		List<OrganisationUnit_Funding> oufun = linkOrganisationUnitFundingRepository.findByFunding(entity);
		if (oufun != null) linkOrganisationUnitFundingRepository.delete(oufun);
		entity.setOrganisationUnits_fundings(null);
		
		List<Person_Funding> pfun = linkPersonFundingRepository.findByFunding(entity);
		if (pfun != null) linkPersonFundingRepository.delete(pfun);
		entity.setPersons_fundings(null);
		
		List<ResultPatent_Funding> respatfund = linkResultPatentFundingRepository.findByFunding(entity);
		if (respatfund != null) linkResultPatentFundingRepository.delete(respatfund);
		entity.setResultPatents_fundings(null);
		
		List<ResultProduct_Funding> resprodfund = linkResultProductFundingRepository.findByFunding(entity);
		if (resprodfund != null) linkResultProductFundingRepository.delete(resprodfund);
		entity.setResultProducts_fundings(null);
		
		List<ResultPublication_Funding> respublfund = linkResultPublicationFundingRepository.findByFunding(entity);
		if (respublfund != null) linkResultPublicationFundingRepository.delete(respublfund);
		entity.setResultPublications_fundings(null);
		
		List<Funding_Class> fundcl = linkFundingClassRepository.findByFunding(entity);
		if (fundcl != null) linkFundingClassRepository.delete(fundcl);
		entity.setFundings_classes(null);
		
		List<Facility_Funding> facfund = linkFacilityFundingRepository.findByFunding(entity);
		if (facfund != null) linkFacilityFundingRepository.delete(facfund);
		entity.setFacilities_fundings(null);
		
		List<Funding_Funding> fundfund1 = linkFundingFundingRepository.findByFunding1(entity);
		if (fundfund1 != null) linkFundingFundingRepository.delete(fundfund1);
		entity.setFundings_fundings1(null);
		
		List<Funding_Funding> fundfund2 = linkFundingFundingRepository.findByFunding2(entity);
		if (fundfund2 != null) linkFundingFundingRepository.delete(fundfund2);
		entity.setFundings_fundings2(null);
		
		List<Service_Funding> srvfund = linkServiceFundingRepository.findByFunding(entity);
		if (srvfund != null) linkServiceFundingRepository.delete(srvfund);
		entity.setServices_fundings(null);
		
		List<Equipment_Funding> eqfund = linkEquipmentFundingRepository.findByFunding(entity);
		if (eqfund != null) linkEquipmentFundingRepository.delete(eqfund);
		entity.setEquipments_fundings(null);
		
		List<Medium_Funding> medfund = linkMediumFundingRepository.findByFunding(entity);
		if (medfund != null) linkMediumFundingRepository.delete(medfund);
		entity.setMediums_fundings(null);
		
		List<Funding_Indicator> fundind = linkFundingIndicatorRepository.findByFunding(entity);
		if (fundind != null) linkFundingIndicatorRepository.delete(fundind);
		entity.setFundings_indicators(null);
		
		List<Event_Funding> evFund = linkEventFundingRepository.findByFunding(entity);
		if (evFund != null) linkEventFundingRepository.delete(evFund);
		entity.setEvents_fundings(null);
		
		List<Funding_Measurement> fundMeas = linkFundingMeasurementRepository.findByFunding(entity);
		if (fundMeas != null) linkFundingMeasurementRepository.delete(fundMeas);
		entity.setFundings_measurement(null);
		
		entity = fundingCrudRepository.save(entity);
		fundingCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FundingRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<Funding> entities) {
		fundingCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FundingRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<Funding> save(Iterable<Funding> entities) {
		return fundingCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FundingRepository#save(gr.ekt.cerif.entities.second.Funding)
	 */
	@Override
	public Funding save(Funding entity) {
		return fundingCrudRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FundingRepository#findByAcronym(java.lang.String)
	 */
	@Override
	public Funding findByAcronym(String acronym) {
		return fundingCrudRepository.findByAcronym(acronym);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FundingRepository#findById(java.lang.Long)
	 */
	@Override
	public Funding findById(Long id) {
		return fundingCrudRepository.findById(id);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FundingRepository#findAll()
	 */
	@Override
	public List<Funding> findAll() {
		return fundingCrudRepository.findAll();
	}

	@Override
	public Page<Funding> findAll(Pageable page) {
		return fundingCrudRepository.findAll(page);
	}

	@Override
	public Funding findByUri(String Uri) {
		return fundingCrudRepository.findByUri(Uri);
	}

	@Override
	public Funding findByUUID(String uuid) {
		return fundingCrudRepository.findByUuid(uuid);
	}

}

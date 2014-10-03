/**
 * 
 */
package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultProduct_Class;
import gr.ekt.cerif.entities.link.result.ResultProduct_Country;
import gr.ekt.cerif.entities.link.result.ResultProduct_Equipment;
import gr.ekt.cerif.entities.link.result.ResultProduct_Facility;
import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;
import gr.ekt.cerif.entities.link.result.ResultProduct_GeographicBoundingBox;
import gr.ekt.cerif.entities.link.result.ResultProduct_Indicator;
import gr.ekt.cerif.entities.link.result.ResultProduct_Measurement;
import gr.ekt.cerif.entities.link.result.ResultProduct_Medium;
import gr.ekt.cerif.entities.link.result.ResultProduct_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultProduct_Service;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ResultProductDescription;
import gr.ekt.cerif.features.multilingual.ResultProductKeyword;
import gr.ekt.cerif.features.multilingual.ResultProductName;
import gr.ekt.cerif.features.multilingual.ResultProductVersionInfo;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitResultProductRepository;
import gr.ekt.cerif.services.link.person.LinkPersonResultProductRepository;
import gr.ekt.cerif.services.link.project.LinkProjectResultProductRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductClassRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductCountryRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductEquipmentRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductFacilityRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductFundingRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductGeographicBoundingBoxRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductIndicatorRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductMeasurementRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductMediumRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductResultProductRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductServiceRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationResultProductRepository;
import gr.ekt.cerif.services.multilingual.resultproduct.ResultProductDescriptionRepository;
import gr.ekt.cerif.services.multilingual.resultproduct.ResultProductKeywordRepository;
import gr.ekt.cerif.services.multilingual.resultproduct.ResultProductNameRepository;
import gr.ekt.cerif.services.multilingual.resultproduct.ResultProductVersionInfoRepository;

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
public class ResultProductRepositoryImpl implements ResultProductRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultProductRepositoryImpl.class);

	@Autowired
	private ResultProductCrudRepository resultProductCrudRepository;
	
	@Autowired
	private ResultProductDescriptionRepository resultProductDescriptionRepository;
	
	@Autowired
	private ResultProductNameRepository resultProductNameRepository;
	
	@Autowired
	private ResultProductKeywordRepository resultProductKeywordRepository;
	
	@Autowired
	private ResultProductVersionInfoRepository resultProductVersionInfoRepository;
	
	@Autowired
	private LinkOrganisationUnitResultProductRepository linkOrganisationUnitResultProductRepository;
	
	@Autowired
	private LinkPersonResultProductRepository linkPersonResultProductRepository;
	
	@Autowired
	private LinkResultPublicationResultProductRepository linkResultPublicationResultProductRepository;
	
	@Autowired
	private LinkResultProductServiceRepository linkResultProductServiceRepository;
	
	@Autowired
	private LinkResultProductFacilityRepository linkResultProductFacilityRepository;
	
	@Autowired
	private LinkResultProductClassRepository linkResultProductClassRepository;
	
	@Autowired
	private LinkProjectResultProductRepository linkProjectResultProductRepository;
	
	@Autowired
	private LinkResultProductCountryRepository linkResultProductCountryRepository;
	
	@Autowired
	private LinkResultProductGeographicBoundingBoxRepository linkResultProductGeographicBoundingBoxRepository;
	
	@Autowired
	private LinkResultProductFundingRepository linkResultProductFundingRepository;
	
	@Autowired
	private LinkResultProductIndicatorRepository linkResultProductIndicatorRepository;
	
	@Autowired
	private LinkResultProductMeasurementRepository linkResultProductMeasurementRepository;
	
	@Autowired
	private LinkResultProductResultProductRepository linkResultProductResultProductRepository;
	
	@Autowired
	private LinkResultProductEquipmentRepository linkResultProductEquipmentRepository;
	
	@Autowired
	private LinkResultProductMediumRepository linkResultProductMediumRepository;
	

	@Override
	@Transactional
	public void delete(ResultProduct entity) {
		List<ResultProductDescription> resprodDescr = resultProductDescriptionRepository.findByResultProduct(entity);
		if (resprodDescr != null) resultProductDescriptionRepository.delete(resprodDescr);
		entity.setResultProductDescriptions(null);
		
		List<ResultProductName> resprodname = resultProductNameRepository.findByResultProduct(entity);
		if (resprodname != null) resultProductNameRepository.delete(resprodname);
		entity.setResultProductNames(null);
		
		List<ResultProductKeyword> resprodkey = resultProductKeywordRepository.findByResultProduct(entity);
		if (resprodkey != null) resultProductKeywordRepository.delete(resprodkey);
		entity.setResultProductKeywords(null);
		
		List<ResultProductVersionInfo> resprodversinf = resultProductVersionInfoRepository.findByResultProduct(entity);
		if (resprodversinf != null) resultProductVersionInfoRepository.delete(resprodversinf);
		entity.setResultProductVersionInfos(null);
		
		List<OrganisationUnit_ResultProduct> prods = linkOrganisationUnitResultProductRepository.findByResultProduct(entity);
		if (prods != null) linkOrganisationUnitResultProductRepository.delete(prods);
		entity.setOrganisationUnits_resultProducts(null);
		
		List<Person_ResultProduct> pprod = linkPersonResultProductRepository.findByResultProduct(entity);
		if (pprod != null) linkPersonResultProductRepository.delete(pprod);
		entity.setPersons_resultProducts(null);
		
		List<ResultPublication_ResultProduct> respublresprod = linkResultPublicationResultProductRepository.findByResultProduct(entity);
		if (respublresprod != null) linkResultPublicationResultProductRepository.delete(respublresprod);
		entity.setResultPublications_resultProducts(null);
		
		List<ResultProduct_Service> resprodserv = linkResultProductServiceRepository.findByResultProduct(entity);
		if (resprodserv != null) linkResultProductServiceRepository.delete(resprodserv);
		entity.setResultProducts_services(null);
		
		List<ResultProduct_Facility> resproflfac = linkResultProductFacilityRepository.findByResultProduct(entity);
		if (resproflfac != null) linkResultProductFacilityRepository.delete(resproflfac);
		entity.setResultProducts_facilities(null);
		
		List<ResultProduct_Class> resprodcl = linkResultProductClassRepository.findByResultProduct(entity);
		if (resprodcl != null) linkResultProductClassRepository.delete(resprodcl);
		entity.setResultProducts_classes(null);
		
		List<Project_ResultProduct> projresprod = linkProjectResultProductRepository.findByResultProduct(entity);
		if (projresprod != null) linkProjectResultProductRepository.delete(projresprod);
		entity.setProjects_resultProducts(null);
		
		List<ResultProduct_Country> resprodcoun = linkResultProductCountryRepository.findByResultProduct(entity);
		if (resprodcoun != null) linkResultProductCountryRepository.delete(resprodcoun);
		entity.setResultProducts_countries(null);
		
		List<ResultProduct_GeographicBoundingBox> resprodgeobox = linkResultProductGeographicBoundingBoxRepository.findByResultProduct(entity);
		if (resprodgeobox != null) linkResultProductGeographicBoundingBoxRepository.delete(resprodgeobox);
		entity.setResultProducts_geographicBoundingBoxes(null);
		
		List<ResultProduct_Funding> resprodfund = linkResultProductFundingRepository.findByResultProduct(entity);
		if (resprodfund != null) linkResultProductFundingRepository.delete(resprodfund);
		entity.setResultProducts_fundings(null);
		
		List<ResultProduct_Indicator> resprodind = linkResultProductIndicatorRepository.findByResultProduct(entity);
		if (resprodind != null) linkResultProductIndicatorRepository.delete(resprodind);
		entity.setResultProducts_indicators(null);
		
		List<ResultProduct_Measurement> resprodmeas = linkResultProductMeasurementRepository.findByResultProduct(entity);
		if (resprodmeas != null) linkResultProductMeasurementRepository.delete(resprodmeas);
		entity.setResultProducts_measurements(null);
		
		List<ResultProduct_ResultProduct> resprodresprod1 = linkResultProductResultProductRepository.findByResultProduct1(entity);
		if (resprodresprod1 != null) linkResultProductResultProductRepository.delete(resprodresprod1);
		entity.setResultProducts_resultProducts1(null);
		
		List<ResultProduct_ResultProduct> resprodresprod2 = linkResultProductResultProductRepository.findByResultProduct2(entity);
		if (resprodresprod2 != null) linkResultProductResultProductRepository.delete(resprodresprod2);
		entity.setResultProducts_resultProducts1(null);
		
		List<ResultProduct_Equipment> resprodequip = linkResultProductEquipmentRepository.findByResultProduct(entity);
		if (resprodequip != null) linkResultProductEquipmentRepository.delete(resprodequip);
		entity.setResultProducts_equipments(null);
		
		List<ResultProduct_Medium> resprodmed = linkResultProductMediumRepository.findByResultProduct(entity);
		if (resprodmed != null) linkResultProductMediumRepository.delete(resprodmed);
		entity.setResultProducts_mediums(null);
		
		entity = resultProductCrudRepository.save(entity);
		resultProductCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<ResultProduct> entities) {
		resultProductCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<ResultProduct> save(Iterable<ResultProduct> entities) {
		return resultProductCrudRepository.save(entities);
	}

	@Override
	public ResultProduct save(ResultProduct entity) {
		return resultProductCrudRepository.save(entity);
	}

	@Override
	public List<ResultProduct> findAll() {
		return resultProductCrudRepository.findAll();
	}

	@Override
	public Page<ResultProduct> findAll(Pageable page) {
		return resultProductCrudRepository.findAll(page);
	}

	@Override
	public ResultProduct findById(Long id) {
		return resultProductCrudRepository.findById(id);
	}

	@Override
	public ResultProduct findByUUID(String uuid) {
		return resultProductCrudRepository.findByUuid(uuid);
	}

}

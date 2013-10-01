package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.FormalisedDublinCoreRightsManagementPricing;

@Component
public class FormalisedDublinCoreRightsManagementPricingRepositoryImpl
		implements FormalisedDublinCoreRightsManagementPricingRepository {
	
	private static final Logger log = LoggerFactory.getLogger(FormalisedDublinCoreRightsManagementPricingRepositoryImpl.class);
	
	@Autowired
	private FormalisedDublinCoreRightsManagementPricingCrudRepository formalisedDublinCoreRightsManagementPricingCrudRepository;

	@Override
	public void delete(FormalisedDublinCoreRightsManagementPricing entity) {
		formalisedDublinCoreRightsManagementPricingCrudRepository.delete(entity);
	}

	@Override
	public void delete(
			Iterable<FormalisedDublinCoreRightsManagementPricing> entities) {
		formalisedDublinCoreRightsManagementPricingCrudRepository.delete(entities);
	}

	@Override
	public Iterable<FormalisedDublinCoreRightsManagementPricing> save(
			Iterable<FormalisedDublinCoreRightsManagementPricing> entities) {
		return formalisedDublinCoreRightsManagementPricingCrudRepository.save(entities);
	}

	@Override
	public FormalisedDublinCoreRightsManagementPricing save(
			FormalisedDublinCoreRightsManagementPricing entity) {
		return formalisedDublinCoreRightsManagementPricingCrudRepository.save(entity);
	}

}

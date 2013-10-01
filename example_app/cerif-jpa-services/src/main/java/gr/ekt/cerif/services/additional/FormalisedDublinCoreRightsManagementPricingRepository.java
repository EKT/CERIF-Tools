package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.FormalisedDublinCoreRightsManagementPricing;

/**
 * A repository for dublin core contributor.
 * 
 */
public interface FormalisedDublinCoreRightsManagementPricingRepository {

	public void delete(FormalisedDublinCoreRightsManagementPricing entity); 
	
	public void delete(Iterable<FormalisedDublinCoreRightsManagementPricing> entities); 

	public Iterable<FormalisedDublinCoreRightsManagementPricing> save(Iterable<FormalisedDublinCoreRightsManagementPricing> entities); 
	
	public FormalisedDublinCoreRightsManagementPricing save(FormalisedDublinCoreRightsManagementPricing entity);
}


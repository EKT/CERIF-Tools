package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.FormalisedDublinCoreRightsManagementSecurity;

/**
 * A repository for FormalisedDublinCoreRightsManagementSecurity.
 * 
 */
public interface FormalisedDublinCoreRightsManagementSecurityRepository {

	public void delete(FormalisedDublinCoreRightsManagementSecurity entity); 
	
	public void delete(Iterable<FormalisedDublinCoreRightsManagementSecurity> entities); 

	public Iterable<FormalisedDublinCoreRightsManagementSecurity> save(Iterable<FormalisedDublinCoreRightsManagementSecurity> entities); 
	
	public FormalisedDublinCoreRightsManagementSecurity save(FormalisedDublinCoreRightsManagementSecurity entity);
}


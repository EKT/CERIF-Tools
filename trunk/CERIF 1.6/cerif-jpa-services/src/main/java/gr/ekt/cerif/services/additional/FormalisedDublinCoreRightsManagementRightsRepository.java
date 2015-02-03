package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.FormalisedDublinCoreRightsManagementRights;

/**
 * A repository for FormalisedDublinCoreRightsManagementRights.
 * 
 */
@Deprecated
public interface FormalisedDublinCoreRightsManagementRightsRepository {

	public void delete(FormalisedDublinCoreRightsManagementRights entity); 
	
	public void delete(Iterable<FormalisedDublinCoreRightsManagementRights> entities); 

	public Iterable<FormalisedDublinCoreRightsManagementRights> save(Iterable<FormalisedDublinCoreRightsManagementRights> entities); 
	
	public FormalisedDublinCoreRightsManagementRights save(FormalisedDublinCoreRightsManagementRights entity);
}


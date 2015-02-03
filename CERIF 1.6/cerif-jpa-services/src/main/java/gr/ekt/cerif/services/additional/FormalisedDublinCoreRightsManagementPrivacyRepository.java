package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.FormalisedDublinCoreRightsManagementPrivacy;

/**
 * A repository for FormalisedDublinCoreRightsManagementPrivacy.
 * 
 */
@Deprecated
public interface FormalisedDublinCoreRightsManagementPrivacyRepository {

	public void delete(FormalisedDublinCoreRightsManagementPrivacy entity); 
	
	public void delete(Iterable<FormalisedDublinCoreRightsManagementPrivacy> entities); 

	public Iterable<FormalisedDublinCoreRightsManagementPrivacy> save(Iterable<FormalisedDublinCoreRightsManagementPrivacy> entities); 
	
	public FormalisedDublinCoreRightsManagementPrivacy save(FormalisedDublinCoreRightsManagementPrivacy entity);
}


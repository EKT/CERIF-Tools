package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreRightsManagementAccessRights;

/**
 * A repository for dublin core rights management access rights.
 * 
 */
@Deprecated
public interface DublinCoreRightsManagementAccessRightsRepository {

	public void delete(DublinCoreRightsManagementAccessRights entity); 
	
	public void delete(Iterable<DublinCoreRightsManagementAccessRights> entities); 

	public Iterable<DublinCoreRightsManagementAccessRights> save(Iterable<DublinCoreRightsManagementAccessRights> entities); 
	
	public DublinCoreRightsManagementAccessRights save(DublinCoreRightsManagementAccessRights entity);
}


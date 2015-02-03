package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreRightsManagement;

/**
 * A repository for dublin core rights management.
 * 
 */
public interface DublinCoreRightsManagementRepository {

	public void delete(DublinCoreRightsManagement entity); 
	
	public void delete(Iterable<DublinCoreRightsManagement> entities); 

	public Iterable<DublinCoreRightsManagement> save(Iterable<DublinCoreRightsManagement> entities); 
	
	public DublinCoreRightsManagement save(DublinCoreRightsManagement entity);
}


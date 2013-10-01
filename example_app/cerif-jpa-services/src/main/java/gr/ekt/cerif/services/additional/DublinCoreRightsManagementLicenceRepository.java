package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreRightsManagementLicence;

/**
 * A repository for dublin core rights management licence.
 * 
 */
public interface DublinCoreRightsManagementLicenceRepository {

	public void delete(DublinCoreRightsManagementLicence entity); 
	
	public void delete(Iterable<DublinCoreRightsManagementLicence> entities); 

	public Iterable<DublinCoreRightsManagementLicence> save(Iterable<DublinCoreRightsManagementLicence> entities); 
	
	public DublinCoreRightsManagementLicence save(DublinCoreRightsManagementLicence entity);
}


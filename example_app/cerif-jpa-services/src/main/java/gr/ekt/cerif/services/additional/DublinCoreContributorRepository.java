package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreContributor;

/**
 * A repository for dublin core contributor.
 * 
 */
public interface DublinCoreContributorRepository {

	public void delete(DublinCoreContributor entity); 
	
	public void delete(Iterable<DublinCoreContributor> entities); 

	public Iterable<DublinCoreContributor> save(Iterable<DublinCoreContributor> entities); 
	
	public DublinCoreContributor save(DublinCoreContributor entity);
}


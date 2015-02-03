package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCore;

/**
 * A repository for dublin core relation.
 * 
 */
@Deprecated
public interface DublinCoreRepository {

	public void delete(DublinCore entity); 
	
	public void delete(Iterable<DublinCore> entities); 

	public Iterable<DublinCore> save(Iterable<DublinCore> entities); 
	
	public DublinCore save(DublinCore entity);
}


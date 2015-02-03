package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreFormat;

/**
 * A repository for dublin core format.
 * 
 */
@Deprecated
public interface DublinCoreFormatRepository {

	public void delete(DublinCoreFormat entity); 
	
	public void delete(Iterable<DublinCoreFormat> entities); 

	public Iterable<DublinCoreFormat> save(Iterable<DublinCoreFormat> entities); 
	
	public DublinCoreFormat save(DublinCoreFormat entity);
}


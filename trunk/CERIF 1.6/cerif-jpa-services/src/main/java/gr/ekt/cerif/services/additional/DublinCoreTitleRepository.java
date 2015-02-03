package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreTitle;

/**
 * A repository for dublin core title.
 * 
 */
public interface DublinCoreTitleRepository {

	public void delete(DublinCoreTitle entity); 
	
	public void delete(Iterable<DublinCoreTitle> entities); 

	public Iterable<DublinCoreTitle> save(Iterable<DublinCoreTitle> entities); 
	
	public DublinCoreTitle save(DublinCoreTitle entity);
}


package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreLanguage;

/**
 * A repository for dublin core language.
 * 
 */
public interface DublinCoreLanguageRepository {

	public void delete(DublinCoreLanguage entity); 
	
	public void delete(Iterable<DublinCoreLanguage> entities); 

	public Iterable<DublinCoreLanguage> save(Iterable<DublinCoreLanguage> entities); 
	
	public DublinCoreLanguage save(DublinCoreLanguage entity);
}


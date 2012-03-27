/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a service entity.
 * 
 * 
 */

public interface ServiceTranslation extends CerifMultipleLanguageFeature{

	public Service getService();
	
	public void setService(Service service);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a medium entity.
 * 
 * 
 */

public interface MediumTranslation extends CerifMultipleLanguageFeature{

	public Medium getMedium();
	
	public void setMedium(Medium medium);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a language entity.
 * 
 * 
 */

public interface LanguageTranslation extends CerifMultipleLanguageFeature{

	public Language getLanguageOfName();
	
	public void setLanguageOfName(Language languageOfName);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


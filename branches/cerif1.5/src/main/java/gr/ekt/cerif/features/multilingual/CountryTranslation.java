/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a Country entity.
 * 
 * 
 */

public interface CountryTranslation extends CerifMultipleLanguageFeature{

	public Country getCountry();
	
	public void setCountry(Country country);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


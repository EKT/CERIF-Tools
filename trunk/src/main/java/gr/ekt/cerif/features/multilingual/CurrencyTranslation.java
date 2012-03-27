/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a currency entity.
 * 
 * 
 */

public interface CurrencyTranslation extends CerifMultipleLanguageFeature{

	public Currency getCurrency();
	
	public void setCurrency(Currency currency);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


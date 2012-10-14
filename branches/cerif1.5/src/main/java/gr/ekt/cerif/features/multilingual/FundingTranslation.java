/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a funding entity.
 * 
 * 
 */

public interface FundingTranslation extends CerifMultipleLanguageFeature{

	public Funding getFunding();
	
	public void setFunding(Funding funding);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


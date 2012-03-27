/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a indicator entity.
 * 
 * 
 */

public interface IndicatorTranslation extends CerifMultipleLanguageFeature{

	public Indicator getIndicator();
	
	public void setIndicator(Indicator indicator);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


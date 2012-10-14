/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a prize entity.
 * 
 * 
 */

public interface PrizeTranslation extends CerifMultipleLanguageFeature{

	public Prize getPrize();
	
	public void setPrize(Prize prize);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


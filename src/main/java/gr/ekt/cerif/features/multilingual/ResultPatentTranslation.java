/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a ResultPatent entity.
 * 
 * 
 */
public interface ResultPatentTranslation extends CerifMultipleLanguageFeature{

	public ResultPatent getResultPatent();
	
	public void setResultPatent(ResultPatent resultPatent);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}
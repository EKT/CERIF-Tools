/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a ResultPublication entity.
 * 
 * 
 */
public interface ResultPublicationTranslation extends CerifMultipleLanguageFeature{

	public ResultPublication getResultPublication();
	
	public void setResultPublication(ResultPublication resultPublication);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}
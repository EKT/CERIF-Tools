/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a ResultProduct entity.
 * 
 * 
 */
public interface ResultProductTranslation extends CerifMultipleLanguageFeature{

	public ResultProduct getResultProduct();
	
	public void setResultProduct(ResultProduct resultProduct);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}
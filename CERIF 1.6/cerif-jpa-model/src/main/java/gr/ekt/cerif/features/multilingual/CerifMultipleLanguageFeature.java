/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.entities.second.Language;

/**
 * Represents a CERIF Multiple Language Feature.
 * 
 */
public interface CerifMultipleLanguageFeature extends CerifEntity {
	public void setLanguage(Language language);
	public Language getLanguage() ;
	public Translation getTranslation();
	public void setTranslation(Translation translation);
}

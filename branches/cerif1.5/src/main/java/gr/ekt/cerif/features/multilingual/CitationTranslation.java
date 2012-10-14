/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a Citation entity.
 * 
 * 
 */

public interface CitationTranslation extends CerifMultipleLanguageFeature{

	public Citation getCitation();
	
	public void setCitation(Citation citation);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


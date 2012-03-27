/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.semantics.ClassScheme;

/**
 * Holds the multi-lingual fields of a ClassScheme entity.
 * 
 * 
 */

public interface ClassSchemeTranslation extends CerifMultipleLanguageFeature{

	public ClassScheme getClassScheme();
	
	public void setClassScheme(ClassScheme scheme);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


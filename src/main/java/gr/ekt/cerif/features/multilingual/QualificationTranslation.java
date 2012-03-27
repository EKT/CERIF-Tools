/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a qualification entity.
 * 
 * 
 */

public interface QualificationTranslation extends CerifMultipleLanguageFeature{

	public Qualification getQualification();
	
	public void setQualification(Qualification qualification);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


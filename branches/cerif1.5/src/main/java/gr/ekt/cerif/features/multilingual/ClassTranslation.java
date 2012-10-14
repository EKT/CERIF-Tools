/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

/**
 * Holds the multi-lingual fields of a Class entity.
 * 
 * 
 */

public interface ClassTranslation extends CerifMultipleLanguageFeature{

	public Class getTheClass();
	
	public void setTheClass(Class theClass);
	
	public ClassScheme getClassScheme();
	
	public void setClassScheme(ClassScheme classScheme);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}
/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a Person entity.
 * 
 * 
 */
public interface PersonTranslation extends CerifMultipleLanguageFeature{

	public Person getPerson();
	
	public void setPerson(Person person);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}

/**
 * 
 */
package gr.ekt.cerif.pk.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.Translation;

import java.io.Serializable;

/**
 * Compound key for Person translations.
 * @see PersonTranslation
 * @see Language
 * 
 */
public class PersonTranslationtId implements Serializable {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3054682977536202316L;

	/**
	 * The person.
	 */
	private Person person;
	
	/**
	 * The language.
	 */
	private Language language;
	
	/**
	 * The translation.
	 */
	private Translation translation;

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the language
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

	/**
	 * @return the translation
	 */
	public Translation getTranslation() {
		return translation;
	}

	/**
	 * @param translation the translation to set
	 */
	public void setTranslation(Translation translation) {
		this.translation = translation;
	}
}

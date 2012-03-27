/**
 * 
 */
package gr.ekt.cerif.pk;

import java.io.Serializable;

import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.Translation;

/**
 * Compound key for qualification translations.
 * 
 */
public class QualificationTranslationId implements Serializable  {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 2960119785408005081L;

	/**
	 * The qualification.
	 */
	private Qualification qualification;
	
	/**
	 * The language.
	 */
	private Language language;
	
	/**
	 * The translation.
	 */
	private Translation translation;

	/**
	 * @return the Qualification
	 */
	public Qualification getQualification() {
		return qualification;
	}

	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
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

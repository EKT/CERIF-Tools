/**
 * 
 */
package gr.ekt.cerif.pk;

import java.io.Serializable;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.Translation;

/**
 * Compound key for expertiseAndSkills translations.
 * 
 */
public class ExpertiseAndSkillsTranslationId implements Serializable  {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3013486586424379670L;

	/**
	 * The expertiseAndSkills.
	 */
	private ExpertiseAndSkills expertiseAndSkills;
	
	/**
	 * The language.
	 */
	private Language language;
	
	/**
	 * The translation.
	 */
	private Translation translation;

	/**
	 * @return the ExpertiseAndSkills
	 */
	public ExpertiseAndSkills getExpertiseAndSkills() {
		return expertiseAndSkills;
	}

	/**
	 * @param expertiseAndSkills the expertiseAndSkills to set
	 */
	public void setExpertiseAndSkills(ExpertiseAndSkills expertiseAndSkills) {
		this.expertiseAndSkills = expertiseAndSkills;
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

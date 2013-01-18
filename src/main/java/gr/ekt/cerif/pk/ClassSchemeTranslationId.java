/**
 * 
 */
package gr.ekt.cerif.pk;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.io.Serializable;

/**
 * Compound key for class scheme translations.
 * @see ClassScheme
 * @see Language
 * 
 */
public class ClassSchemeTranslationId implements Serializable {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 23423890977843261L;

	/**
	 * The class scheme.
	 */
	private ClassScheme scheme;
	
	/**
	 * The language.
	 */
	private Language language;
	
	/**
	 * The translation.
	 */
	private Translation translation;


	/**
	 * @return the classScheme
	 */
	public ClassScheme getClassScheme() {
		return scheme;
	}

	/**
	 * @param classScheme the classScheme to set
	 */
	public void setClassScheme(ClassScheme scheme) {
		this.scheme = scheme;
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

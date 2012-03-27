/**
 * 
 */
package gr.ekt.cerif.pk;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.io.Serializable;

/**
 * Compound key for class translations.
 * @see Class
 * @see Language
 * 
 */
public class ClassTranslationId implements Serializable {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 65343458670981233L;

	/**
	 * The class.
	 */
	private Class theClass;
	
	/**
	 * The class scheme.
	 */
	private ClassScheme classScheme;
	
	/**
	 * The language.
	 */
	private Language language;
	
	/**
	 * The translation.
	 */
	private Translation translation;

	/**
	 * @return the theClass
	 */
	public Class getTheClass() {
		return theClass;
	}

	/**
	 * @param theClass the theClass to set
	 */
	public void setTheClass(Class theClass) {
		this.theClass = theClass;
	}

	public ClassScheme getClassScheme() {
		return classScheme;
	}

	public void setClassScheme(ClassScheme classScheme) {
		this.classScheme = classScheme;
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

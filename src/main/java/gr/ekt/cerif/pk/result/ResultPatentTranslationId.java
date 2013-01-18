/**
 * 
 */
package gr.ekt.cerif.pk.result;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.Translation;

import java.io.Serializable;

/**
 * Compound key for ResultPatent translations.
 * @see ResultPatentTranslation
 * @see Language
 * 
 */
public class ResultPatentTranslationId implements Serializable {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -4363210678380184295L;

	/**
	 * The result patent.
	 */
	private ResultPatent resultPatent;
	
	/**
	 * The language.
	 */
	private Language language;
	
	/**
	 * The translation.
	 */
	private Translation translation;

	/**
	 * @return the resultPatent
	 */
	public ResultPatent getResultPatent() {
		return resultPatent;
	}

	/**
	 * @param resultPatent the resultPatent to set
	 */
	public void setResultPatent(ResultPatent resultPatent) {
		this.resultPatent = resultPatent;
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

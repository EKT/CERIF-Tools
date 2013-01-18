/**
 * 
 */
package gr.ekt.cerif.pk.result;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.Translation;

import java.io.Serializable;

/**
 * Compound key for associating a publication with its translated fields.
 * @see ResultPublication
 * @see Language
 * 
 */

public class ResultPublicationTranslationId implements Serializable {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 2458111632305089241L;

	/**
	 * The translation.
	 */
	private Translation translation;

	/**
	 * The publication.
	 */
	private ResultPublication resultPublication;
	
	/**
	 * The language.
	 */
	private Language language;

	/**
	 * Returns the translation.
	 * @return the translation.
	 */
	public Translation getTranslation() {
		return translation;
	}

	/**
	 * Sets the translation.
	 * @param translation the translation.
	 */
	public void setTranslation(Translation translation) {
		this.translation = translation;
	}

	/**
	 * Returns the publication.
	 * @return the publication.
	 */
	public ResultPublication getResultPublication() {
		return resultPublication;
	}

	/**
	 * Sets the publication.
	 * @param resultPublication the publication.
	 */
	public void setResultPublication(ResultPublication resultPublication) {
		this.resultPublication = resultPublication;
	}

	/**
	 * Returns the language.
	 * @return the language.
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 * @param language the language.
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

}

/**
 * 
 */
package gr.ekt.cerif.pk;

import java.io.Serializable;

import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.Translation;

/**
 * Compound key for indicator translations.
 * 
 */
public class IndicatorTranslationId implements Serializable  {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 7492242617428139505L;

	/**
	 * The indicator.
	 */
	private Indicator indicator;
	
	/**
	 * The language.
	 */
	private Language language;
	
	/**
	 * The translation.
	 */
	private Translation translation;

	/**
	 * @return the Indicator
	 */
	public Indicator getIndicator() {
		return indicator;
	}

	/**
	 * @param indicator the indicator to set
	 */
	public void setIndicator(Indicator indicator) {
		this.indicator = indicator;
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

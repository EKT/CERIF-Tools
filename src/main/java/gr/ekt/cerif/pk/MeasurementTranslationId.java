/**
 * 
 */
package gr.ekt.cerif.pk;

import java.io.Serializable;

import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.Translation;

/**
 * Compound key for measurement translations.
 * 
 */
public class MeasurementTranslationId implements Serializable  {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 7212600789783562017L;

	/**
	 * The measurement.
	 */
	private Measurement measurement;
	
	/**
	 * The language.
	 */
	private Language language;
	
	/**
	 * The translation.
	 */
	private Translation translation;

	/**
	 * @return the Measurement
	 */
	public Measurement getMeasurement() {
		return measurement;
	}

	/**
	 * @param measurement the measurement to set
	 */
	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
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

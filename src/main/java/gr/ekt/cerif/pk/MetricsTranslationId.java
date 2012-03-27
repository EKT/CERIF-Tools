/**
 * 
 */
package gr.ekt.cerif.pk;

import java.io.Serializable;

import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.Translation;

/**
 * Compound key for metrics translations.
 * 
 */
public class MetricsTranslationId implements Serializable  {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -7623289390070874833L;

	/**
	 * The metrics.
	 */
	private Metrics metrics;
	
	/**
	 * The language.
	 */
	private Language language;
	
	/**
	 * The translation.
	 */
	private Translation translation;

	/**
	 * @return the Metrics
	 */
	public Metrics getMetrics() {
		return metrics;
	}

	/**
	 * @param metrics the metrics to set
	 */
	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
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

/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a metrics entity.
 * 
 * 
 */

public interface MetricsTranslation extends CerifMultipleLanguageFeature{

	public Metrics getMetrics();
	
	public void setMetrics(Metrics metrics);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


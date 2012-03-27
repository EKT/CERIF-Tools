/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a measurement entity.
 * 
 * 
 */

public interface MeasurementTranslation extends CerifMultipleLanguageFeature{

	public Measurement getMeasurement();
	
	public void setMeasurement(Measurement measurement);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


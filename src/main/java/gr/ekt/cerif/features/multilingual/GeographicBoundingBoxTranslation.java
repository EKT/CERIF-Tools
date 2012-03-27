/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a GeographicBoundingBox entity.
 * 
 * 
 */

public interface GeographicBoundingBoxTranslation extends CerifMultipleLanguageFeature{

	public GeographicBoundingBox getGeographicBoundingBox();
	
	public void setGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}
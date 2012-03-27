/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a facility entity.
 * 
 */

public interface FacilityTranslation extends CerifMultipleLanguageFeature{

	public Facility getFacility();
	
	public void setFacility(Facility facility);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


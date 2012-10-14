/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a event entity.
 * 
 * 
 */

public interface EventTranslation extends CerifMultipleLanguageFeature{

	public Event getEvent();
	
	public void setEvent(Event event);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


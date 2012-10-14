/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a equipment entity.
 * 
 * 
 */

public interface EquipmentTranslation extends CerifMultipleLanguageFeature{

	public Equipment getEquipment();
	
	public void setEquipment(Equipment equipment);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


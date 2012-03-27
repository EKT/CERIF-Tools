/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a expertiseAndSkills entity.
 * 
 * 
 */

public interface ExpertiseAndSkillsTranslation extends CerifMultipleLanguageFeature{

	public ExpertiseAndSkills getExpertiseAndSkills();
	
	public void setExpertiseAndSkills(ExpertiseAndSkills expertiseAndSkills);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}


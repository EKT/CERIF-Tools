/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a Project entity.
 * 
 * 
 */
public interface ProjectTranslation extends CerifMultipleLanguageFeature{

	public Project getProject();
	
	public void setProject(Project project);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}

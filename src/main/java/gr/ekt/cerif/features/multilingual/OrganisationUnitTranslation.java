/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.second.Language;

/**
 * Holds the multi-lingual fields of a OrganisationUnit entity.
 * 
 * 
 */
public interface OrganisationUnitTranslation extends CerifMultipleLanguageFeature{

	public OrganisationUnit getOrganisationUnit();
	
	public void setOrganisationUnit(OrganisationUnit organisationUnit);
	
	public Language getLanguage();
	
	public void setLanguage(Language language);
	
	public Translation getTranslation();
	
	public void setTranslation(Translation translation);
}

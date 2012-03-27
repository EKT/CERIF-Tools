/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.organisationunit.OrganisationUnitTranslationId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Holds the multi-lingual research activity of an OrganisationUnit entity.
 * 
 */
@Entity
@Table(name="cfOrgUnitResAct")
@IdClass(OrganisationUnitTranslationId.class)
public class OrganisationUnitResearchActivity implements OrganisationUnitTranslation {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 318813824254546521L;
		
	
	/**
	 * The organisation unit.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfOrgUnitId")
	private OrganisationUnit organisationUnit;
	
	/**
	 * The language.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfLangCode")
	private Language language;
	
	/**
	 * The translation.
	 */
	@Id
	@Column(name="cfTrans")
	@Enumerated(EnumType.STRING)
	private Translation translation;
	
	/**
	 * The organisation unit research activity.
	 */
	@Column(name="cfResAct")
	private String researchActivity;	

	/**
	 * @return the organisationUnit
	 */
	public OrganisationUnit getOrganisationUnit() {
		return organisationUnit;
	}

	/**
	 * @param organisationUnit the organisationUnit to set
	 */
	public void setOrganisationUnit(OrganisationUnit organisationUnit) {
		this.organisationUnit = organisationUnit;
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

	/**
	 * @return the researchActivity
	 */
	public String getResearchActivity() {
		return researchActivity;
	}

	/**
	 * @param researchActivity the researchActivity to set
	 */
	public void setResearchActivity(String researchActivity) {
		this.researchActivity = researchActivity;
	}
}

/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.second.Language;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * Holds the multi-lingual research activity of an OrganisationUnit entity.
 * 
 */
@Entity
@Table(name="cfOrgUnitResAct", uniqueConstraints=@UniqueConstraint(columnNames={"cfOrgUnitId","cfLangCode","cfTrans"}))
public class OrganisationUnitResearchActivity implements OrganisationUnitTranslation {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 318813824254546521L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The organisation unit.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfOrgUnitId")
	private OrganisationUnit organisationUnit;
	
	/**
	 * The language.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfLangCode")
	private Language language;
	
	/**
	 * The translation.
	 */
	@NotNull
	@Column(name="cfTrans")
	@Enumerated(EnumType.STRING)
	private Translation translation;
	
	/**
	 * The organisation unit research activity.
	 */
	@Column(name="cfResAct")
	private String researchActivity;	

	/**
	 * Default Constructor
	 */
	public OrganisationUnitResearchActivity(){
		
	}
	
	/**
	 * 
	 * @param organisationUnit
	 * @param language
	 * @param translation
	 * @param researchActivity
	 */
	public OrganisationUnitResearchActivity(OrganisationUnit organisationUnit,
			Language language, Translation translation, String researchActivity) {
		this.organisationUnit = organisationUnit;
		this.language = language;
		this.translation = translation;
		this.researchActivity = researchActivity;
	}

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

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
}

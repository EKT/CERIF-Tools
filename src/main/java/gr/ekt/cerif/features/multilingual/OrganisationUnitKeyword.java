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
 * Holds the multi-lingual keyword of an OrganisationUnit entity.
 * 
 */
@Entity
@Table(name="cfOrgUnitKeyw")
@IdClass(OrganisationUnitTranslationId.class)
public class OrganisationUnitKeyword implements OrganisationUnitTranslation {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6615846857842781143L;

	/**
	 * Serialization version.
	 */
	
	
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
	 * The organisation unit keywords.
	 */
	@Column(name="cfKeyw")
	private String keyword;	

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
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}


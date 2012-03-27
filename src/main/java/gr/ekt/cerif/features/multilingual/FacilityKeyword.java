/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.FacilityTranslationId;

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
 * Holds the multi-lingual keyword of a facility entity.
 * 
 */
@Entity
@Table(name="cfFacilKeyw")
@IdClass(FacilityTranslationId.class)
public class FacilityKeyword implements FacilityTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 8282802600983418000L;

	/**
	 * The facility.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfFacilId")
	private Facility facility;
	
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
	 * The facility keyword.
	 */
	@Column(name="cfKeyw")
	private String keyword;
	
	/**
	 * @return the facility
	 */
	public Facility getFacility() {
		return facility;
	}
	
	/**
	 * @param facility the facility to set
	 */
	public void setFacility(Facility facility) {
		this.facility = facility;
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

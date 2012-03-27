/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.MediumTranslationId;

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
 * Holds the multi-lingual keyword of a medium entity.
 * 
 */
@Entity
@Table(name="cfMediumKeyw")
@IdClass(MediumTranslationId.class)
public class MediumKeyword implements MediumTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -4017737031264833569L;

	/**
	 * The medium.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfMediumId")
	private Medium medium;
	
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
	 * The medium keyword.
	 */
	@Column(name="cfKeyw")
	private String keyword;
	
	/**
	 * @return the medium
	 */
	public Medium getMedium() {
		return medium;
	}
	
	/**
	 * @param medium the medium to set
	 */
	public void setMedium(Medium medium) {
		this.medium = medium;
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

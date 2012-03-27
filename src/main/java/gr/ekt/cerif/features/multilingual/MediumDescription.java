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
 * Holds the multi-lingual description of a medium entity.
 * 
 */
@Entity
@Table(name="cfMediumDescr")
@IdClass(MediumTranslationId.class)
public class MediumDescription implements MediumTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 2334004703433996886L;

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
	 * The medium description.
	 */
	@Column(name="cfDescr")
	private String description;
	
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}

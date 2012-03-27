/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.ExpertiseAndSkillsTranslationId;

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
 * Holds the multi-lingual description of a expertiseAndSkills entity.
 * 
 */
@Entity
@Table(name="cfExpSkillsDescr")
@IdClass(ExpertiseAndSkillsTranslationId.class)
public class ExpertiseAndSkillsDescription implements ExpertiseAndSkillsTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -2538553368644029568L;

	/**
	 * The expertiseAndSkills.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfExpSkillsId")
	private ExpertiseAndSkills expertiseAndSkills;
	
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
	 * The expertiseAndSkills description.
	 */
	@Column(name="cfDescr")
	private String description;
	
	/**
	 * @return the expertiseAndSkills
	 */
	public ExpertiseAndSkills getExpertiseAndSkills() {
		return expertiseAndSkills;
	}
	
	/**
	 * @param expertiseAndSkills the expertiseAndSkills to set
	 */
	public void setExpertiseAndSkills(ExpertiseAndSkills expertiseAndSkills) {
		this.expertiseAndSkills = expertiseAndSkills;
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

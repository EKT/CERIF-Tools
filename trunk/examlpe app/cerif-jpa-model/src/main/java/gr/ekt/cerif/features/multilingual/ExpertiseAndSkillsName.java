/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
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
 * Holds the multi-lingual name of a expertiseAndSkills entity.
 * 
 */
@Entity
@Table(name="cfExpSkillsName", uniqueConstraints=@UniqueConstraint(columnNames={"cfExpSkillsId","cfLangCode","cfTrans"}))
public class ExpertiseAndSkillsName implements CerifMultipleLanguageFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 7222478821819547758L;

	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The expertiseAndSkills.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfExpSkillsId")
	private ExpertiseAndSkills expertiseAndSkills;
	
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
	 * The expertiseAndSkills name.
	 */
	@Column(name="cfName")
	private String name;
	
	/**
	 * Default constructor
	 */
	public ExpertiseAndSkillsName() {
		
	}
	
	/**
	 * 
	 * @param expertiseAndSkills
	 * @param language
	 * @param translation
	 * @param name
	 */
	public ExpertiseAndSkillsName(ExpertiseAndSkills expertiseAndSkills,
			Language language, Translation translation, String name) {
		this.expertiseAndSkills = expertiseAndSkills;
		this.language = language;
		this.translation = translation;
		this.name = name;
	}

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.base.Person;
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
 * Holds the multi-lingual keyword of a person entity.
 * 
 */
@Entity
@Table(name="cfPersKeyw", uniqueConstraints=@UniqueConstraint(columnNames={"cfPersId","cfLangCode","cfTrans"}))
public class PersonKeyword implements PersonTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -966026461484526429L;
		
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	/**
	 * The person.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfPersId")
	private Person person;
	
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
	 * The person's keywords.
	 */
	@Column(name="cfKeyw")
	private String keyword;

	/**
	 * Default Constructor
	 */
	public PersonKeyword() {
		
	}
	
	/**
	 * 
	 * @param person
	 * @param language
	 * @param translation
	 * @param keyword
	 */
	public PersonKeyword(Person person, Language language,
			Translation translation, String keyword) {
		this.person = person;
		this.language = language;
		this.translation = translation;
		this.keyword = keyword;
	}


	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}


	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
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
	 * @return the keywords
	 */
	public String getKeyword() {
		return keyword;
	}


	/**
	 * @param keywords the keywords to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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

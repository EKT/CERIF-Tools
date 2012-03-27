/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.person.PersonTranslationtId;

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
 * Holds the multi-lingual research interest of a person entity.
 * 
 */
@Entity
@Table(name="cfPersResInt")
@IdClass(PersonTranslationtId.class)
public class PersonResearchInterest implements PersonTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3303081887774658428L;	

	/**
	 * The person.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfPersId")
	private Person person;
	
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
	 * The person's research interests.
	 */
	@Column(name="cfResInt")
	private String researchInterests;
				
	
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
	 * @return the researchInterests
	 */
	public String getResearchInterests() {
		return researchInterests;
	}


	/**
	 * @param researchInterests the researchInterests to set
	 */
	public void setResearchInterests(String researchInterests) {
		this.researchInterests = researchInterests;
	}
	
	
}

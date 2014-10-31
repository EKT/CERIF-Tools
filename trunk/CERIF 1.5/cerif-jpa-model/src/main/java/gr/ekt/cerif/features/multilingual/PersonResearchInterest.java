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
 * Holds the multi-lingual research interest of a person entity.
 * 
 */
@Entity
@Table(name="cfPersResInt", uniqueConstraints=@UniqueConstraint(columnNames={"cfPersId","cfLangCode","cfTrans"}))
public class PersonResearchInterest implements CerifMultipleLanguageFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3303081887774658428L;	

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
	 * The person's research interests.
	 */
	@NotNull
	@Column(name="cfResInt", length=20000)
	private String researchInterests;
	
	/**
	 * Default Constructor
	 */
	public PersonResearchInterest() {
		
	}
	
	/**
	 * Constructor
	 * @param person
	 * @param language
	 * @param translation
	 * @param researchInterests
	 */
	public PersonResearchInterest(Person person, Language language,
			Translation translation, String researchInterests) {
		this.person = person;
		this.language = language;
		this.translation = translation;
		this.researchInterests = researchInterests;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result
				+ ((translation == null) ? 0 : translation.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonResearchInterest other = (PersonResearchInterest) obj;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (translation != other.translation)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonResearchInterest [id=" + id + ", language=" + language
				+ ", translation=" + translation + ", researchInterests="
				+ researchInterests + "]";
	}
	
}

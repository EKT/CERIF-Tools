/**
 * 
 */
package gr.ekt.cerif.entities.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.enumerations.LanguageSkills;
import gr.ekt.cerif.features.semantics.Class;

import java.util.Date;

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

@Entity
@Table(name="cfPers_Lang", uniqueConstraints=@UniqueConstraint(columnNames={"cfPersId","cfLangCode","cfClassId","cfStartDate","cfEndDate"}))
public class Person_Language implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -6547898956812123403L;
	
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
	 * The class.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassId")
	private Class theClass;
	
	/**
	 * The start date.
	 */
	@NotNull
	@Column (name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@NotNull
	@Column (name="cfEndDate")
	private Date endDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;
	
	/**
	 * Language reading skills.
	 */
	@Column(name="cfSkillReading")
	@Enumerated(EnumType.STRING)
	private LanguageSkills reading;

	/**
	 * Language speaking skills.
	 */
	@Column(name="cfSkillSpeaking")
	@Enumerated(EnumType.STRING)
	private LanguageSkills speaking;
	
	/**
	 * Language writing skills.
	 */
	@Column(name="cfSkillWriting")
	@Enumerated(EnumType.STRING)
	private LanguageSkills writing;

	/**
	 * Default Constructor
	 */
	public Person_Language() {
		
	}
	
	/**
	 * 
	 * @param person
	 * @param language
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 * @param reading
	 * @param speaking
	 * @param writing
	 */
	public Person_Language(Person person, Language language, Class theClass,
			Date startDate, Date endDate, Double fraction, LanguageSkills reading,
			LanguageSkills speaking, LanguageSkills writing) {
		this.person = person;
		this.language = language;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
		this.reading = reading;
		this.speaking = speaking;
		this.writing = writing;
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
	 * @return the theClass
	 */
	public Class getTheClass() {
		return theClass;
	}

	/**
	 * @param theClass the theClass to set
	 */
	public void setTheClass(Class theClass) {
		this.theClass = theClass;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the fraction
	 */
	public Double getFraction() {
		return fraction;
	}

	/**
	 * @param fraction the fraction to set
	 */
	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}

	/**
	 * @return the reading
	 */
	public LanguageSkills getReading() {
		return reading;
	}

	/**
	 * @param reading the reading to set
	 */
	public void setReading(LanguageSkills reading) {
		this.reading = reading;
	}

	/**
	 * @return the speaking
	 */
	public LanguageSkills getSpeaking() {
		return speaking;
	}

	/**
	 * @param speaking the speaking to set
	 */
	public void setSpeaking(LanguageSkills speaking) {
		this.speaking = speaking;
	}

	/**
	 * @return the writing
	 */
	public LanguageSkills getWriting() {
		return writing;
	}

	/**
	 * @param writing the writing to set
	 */
	public void setWriting(LanguageSkills writing) {
		this.writing = writing;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person_Language [id=" + id + ", person=" + person
				+ ", language=" + language + ", theClass=" + theClass
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", fraction=" + fraction + ", reading=" + reading
				+ ", speaking=" + speaking + ", writing=" + writing + "]";
	}
	
}

/**
 * 
 */
package gr.ekt.cerif.entities.base;

import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.entities.link.person.Person_Country;
import gr.ekt.cerif.entities.link.person.Person_Cv;
import gr.ekt.cerif.entities.link.person.Person_DublinCore;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;
import gr.ekt.cerif.entities.link.person.Person_Equipment;
import gr.ekt.cerif.entities.link.person.Person_Event;
import gr.ekt.cerif.entities.link.person.Person_ExpertiseAndSkills;
import gr.ekt.cerif.entities.link.person.Person_Facility;
import gr.ekt.cerif.entities.link.person.Person_Funding;
import gr.ekt.cerif.entities.link.person.Person_Language;
import gr.ekt.cerif.entities.link.person.Person_Medium;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.entities.link.person.Person_Person;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;
import gr.ekt.cerif.entities.link.person.Person_Prize;
import gr.ekt.cerif.entities.link.person.Person_Qualification;
import gr.ekt.cerif.entities.link.person.Person_ResultPatent;
import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.link.person.Person_Service;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.multilingual.PersonKeyword;
import gr.ekt.cerif.features.multilingual.PersonResearchInterest;

import java.util.Date;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//import gr.ekt.cerif.entities.link.person.Person_Person;

/**
 * Represents a person base entity.
 */
@Entity
@Table(name="cfPers")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Person implements CerifBaseEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 4364641049921754259L;

	/**
	 * The person unique identifier.
	 */
	@Id
	@Column(name="cfPersId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The birth date.
	 */
	@Column(name="cfBirthdate")
	private Date birthDate;
	
	/**
	 * The gender of a human person.
	 * <ul>
	 *   <li>m = male</li>
	 *   <li>f = female</li>
	 *   <li>u = unknown</li>
	 * </ul>
	 */
	@Column(name="cfGender")
	private String gender;

	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	/**
	 * The person research interests.
	 */
	@OneToMany(mappedBy="person")
	private Set<PersonResearchInterest> personResearchInterests;
	
	/**
	 * The person keywords.
	 */
	@OneToMany(mappedBy="person")
	private Set<PersonKeyword> personKeywords;
	
	@OneToMany(mappedBy="person")
	private Set<Person_Class> classes;
	
	@OneToMany(mappedBy="person")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<PersonName> personNames;
	
	/**
	 * The projects.
	 */
	@OneToMany(mappedBy="person")
	private Set<Project_Person> projects;
	
	@OneToMany(mappedBy="person")
	private Set<Person_Country> persons_countries;
	
	@OneToMany(mappedBy="person")
	private Set<Person_Cv> persons_cvs;

	@OneToMany(mappedBy="person")
	private Set<Person_DublinCore> persons_dublinCores;
	
	@OneToMany(mappedBy="person")
	private Set<Person_ElectronicAddress> persons_electronicAddresses;
	
	@OneToMany(mappedBy="person")
	private Set<Person_Equipment> persons_equipments;
	
	@OneToMany(mappedBy="person")
	private Set<Person_Event> persons_events;
	
	@OneToMany(mappedBy="person")
	private Set<Person_ExpertiseAndSkills> persons_expertiseAndSkills;
	
	@OneToMany(mappedBy="person")
	private Set<Person_Facility> persons_facilities;
	
	@OneToMany(mappedBy="person")
	private Set<Person_Funding> persons_fundings;
	
	@OneToMany(mappedBy="person")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<Person_Language> persons_languages;
	
	@OneToMany(mappedBy="person")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<Person_OrganisationUnit> persons_organisationUnits;
	
	@OneToMany(mappedBy="person1")
	private Set<Person_Person> person1_persons;
	
	@OneToMany(mappedBy="person2")
	private Set<Person_Person> person2_persons;

	@OneToMany(mappedBy="person")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<Person_PostalAddress> persons_postalAddresses;
	
	@OneToMany(mappedBy="person")
	private Set<Person_Prize> persons_prizes;
	
	@OneToMany(mappedBy="person")
	private Set<Person_Qualification> persons_qualifications;
	
	@OneToMany(mappedBy="person")
	private Set<Person_ResultPatent> persons_resultPatents;
	
	@OneToMany(mappedBy="person")
	private Set<Person_ResultProduct> resultProducts;
	
	@OneToMany(mappedBy="person")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<Person_ResultPublication> persons_resultPublications;
	
	@OneToMany(mappedBy="person")
	private Set<Person_Service> persons_services;
	
	@OneToMany(mappedBy="person")
	private Set<Person_Medium> persons_medium;
	
	/**
	 * Default Constructor
	 */
	public Person(){
		
	}
	/**
	 * Constructor
	 * @param id
	 * @param birthDate
	 * @param gender
	 * @param uri
	 * @param personResearchInterests
	 * @param personKeywords
	 * @param personName
	 */
	public Person(Long id, Date birthDate, String gender, String uri,
			Set<PersonResearchInterest> personResearchInterests,
			Set<PersonKeyword> personKeywords,
			Set<PersonName> personNames) {
		this.id = id;
		this.birthDate = birthDate;
		this.gender = gender;
		this.uri = uri;
		this.personResearchInterests = personResearchInterests;
		this.personKeywords = personKeywords;
		this.personNames = personNames;
	}

	/**
	 * Returns the unique identifier.
	 * @return the unique identifier.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the unique identifier.
	 * @param id the unique identifier.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the birth date.
	 * @return the birth date.
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the birth date.
	 * @param birthDate the birth date.
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Returns the gender.
	 * @return the gender.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 * @param gender the gender.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Returns the URI.
	 * @return the URI.
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * Sets the URI.
	 * @param uri the URI.
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}	
	
	/**
	 * Returns the person research interests.
	 * @return the person research interests.
	 */
	public Set<PersonResearchInterest> getPersonResearchInterests() {
		return personResearchInterests;
	}

	/**
	 * Sets the person research interests.
	 * @param personResearchInterests the person research interests.
	 */
	public void setPersonResearchInterests(Set<PersonResearchInterest> personResearchInterests) {
		this.personResearchInterests = personResearchInterests;
	}
	
	/**
	 * Returns the person keywords.
	 * @return the person keywords.
	 */
	public Set<PersonKeyword> getPersonKeywords() {
		return personKeywords;
	}

	/**
	 * Sets the person keywords.
	 * @param personKeywords the person keywords.
	 */
	public void setPersonKeywords(Set<PersonKeyword> personKeywords) {
		this.personKeywords = personKeywords;
	}

	/**
	 * @return the resultProducts
	 */
	public Set<Person_ResultProduct> getResultProducts() {
		return resultProducts;
	}

	/**
	 * @param resultProducts the resultProducts to set
	 */
	public void setResultProducts(Set<Person_ResultProduct> resultProducts) {
		this.resultProducts = resultProducts;
	}

	/**
	 * @return the classes
	 */
	public Set<Person_Class> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(Set<Person_Class> classes) {
		this.classes = classes;
	}
	
	public Set<PersonName> getPersonNames() {
		return personNames;
	}
	
	public void setPersonNames(Set<PersonName> personNames) {
		this.personNames = personNames;
	}
	
	/**
	 * @return the projects
	 */
	public Set<Project_Person> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(Set<Project_Person> projects) {
		this.projects = projects;
	}
	
	/**
	 * @return the persons_countries
	 */
	public Set<Person_Country> getPersons_countries() {
		return persons_countries;
	}
	
	/**
	 * @param persons_countries the persons_countries to set
	 */
	public void setPersons_countries(Set<Person_Country> persons_countries) {
		this.persons_countries = persons_countries;
	}
	
	/**
	 * @return the persons_cvs
	 */
	public Set<Person_Cv> getPersons_cvs() {
		return persons_cvs;
	}
	
	/**
	 * @param persons_cvs the persons_cvs to set
	 */
	public void setPersons_cvs(Set<Person_Cv> persons_cvs) {
		this.persons_cvs = persons_cvs;
	}
	
	/**
	 * @return the persons_dublinCores
	 */
	public Set<Person_DublinCore> getPersons_dublinCores() {
		return persons_dublinCores;
	}
	
	/**
	 * @param persons_dublinCores the persons_dublinCores to set
	 */
	public void setPersons_dublinCores(
			Set<Person_DublinCore> persons_dublinCores) {
		this.persons_dublinCores = persons_dublinCores;
	}
	
	/**
	 * @return the persons_electronicAddresses
	 */
	public Set<Person_ElectronicAddress> getPersons_electronicAddresses() {
		return persons_electronicAddresses;
	}
	
	/**
	 * @param persons_electronicAddresses the persons_electronicAddresses to set
	 */
	public void setPersons_electronicAddresses(
			Set<Person_ElectronicAddress> persons_electronicAddresses) {
		this.persons_electronicAddresses = persons_electronicAddresses;
	}
	
	/**
	 * @return the persons_equipments
	 */
	public Set<Person_Equipment> getPersons_equipments() {
		return persons_equipments;
	}
	
	/**
	 * @param persons_equipments the persons_equipments to set
	 */
	public void setPersons_equipments(Set<Person_Equipment> persons_equipments) {
		this.persons_equipments = persons_equipments;
	}
	
	/**
	 * @return the persons_events
	 */
	public Set<Person_Event> getPersons_events() {
		return persons_events;
	}
	
	/**
	 * @param persons_events the persons_events to set
	 */
	public void setPersons_events(Set<Person_Event> persons_events) {
		this.persons_events = persons_events;
	}
	
	/**
	 * @return the persons_expertiseAndSkills
	 */
	public Set<Person_ExpertiseAndSkills> getPersons_expertiseAndSkills() {
		return persons_expertiseAndSkills;
	}
	
	/**
	 * @param persons_expertiseAndSkills the persons_expertiseAndSkills to set
	 */
	public void setPersons_expertiseAndSkills(
			Set<Person_ExpertiseAndSkills> persons_expertiseAndSkills) {
		this.persons_expertiseAndSkills = persons_expertiseAndSkills;
	}
	
	/**
	 * @return the persons_facilities
	 */
	public Set<Person_Facility> getPersons_facilities() {
		return persons_facilities;
	}
	
	/**
	 * @param persons_facilities the persons_facilities to set
	 */
	public void setPersons_facilities(Set<Person_Facility> persons_facilities) {
		this.persons_facilities = persons_facilities;
	}
	
	/**
	 * @return the persons_fundings
	 */
	public Set<Person_Funding> getPersons_fundings() {
		return persons_fundings;
	}
	
	/**
	 * @param persons_fundings the persons_fundings to set
	 */
	public void setPersons_fundings(Set<Person_Funding> persons_fundings) {
		this.persons_fundings = persons_fundings;
	}
	
	/**
	 * @return the persons_languages
	 */
	public Set<Person_Language> getPersons_languages() {
		return persons_languages;
	}
	
	/**
	 * @param persons_languages the persons_languages to set
	 */
	public void setPersons_languages(Set<Person_Language> persons_languages) {
		this.persons_languages = persons_languages;
	}
	
	/**
	 * @return the persons_organisationUnits
	 */
	public Set<Person_OrganisationUnit> getPersons_organisationUnits() {
		return persons_organisationUnits;
	}
	
	/**
	 * @param persons_organisationUnits the persons_organisationUnits to set
	 */
	public void setPersons_organisationUnits(
			Set<Person_OrganisationUnit> persons_organisationUnits) {
		this.persons_organisationUnits = persons_organisationUnits;
	}
	
	/**
	 * @return the person1_persons
	 */
	public Set<Person_Person> getPerson1_persons() {
		return person1_persons;
	}
	
	/**
	 * @param person1_persons the person1_persons to set
	 */
	public void setPerson1_persons(Set<Person_Person> person1_persons) {
		this.person1_persons = person1_persons;
	}
	
	/**
	 * @return the person2_persons
	 */
	public Set<Person_Person> getPerson2_persons() {
		return person2_persons;
	}
	
	/**
	 * @param person2_persons the person2_persons to set
	 */
	public void setPerson2_persons(Set<Person_Person> person2_persons) {
		this.person2_persons = person2_persons;
	}
	
	/**
	 * @return the persons_postalAddresses
	 */
	public Set<Person_PostalAddress> getPersons_postalAddresses() {
		return persons_postalAddresses;
	}
	
	/**
	 * @param persons_postalAddresses the persons_postalAddresses to set
	 */
	public void setPersons_postalAddresses(
			Set<Person_PostalAddress> persons_postalAddresses) {
		this.persons_postalAddresses = persons_postalAddresses;
	}
	
	/**
	 * @return the persons_prizes
	 */
	public Set<Person_Prize> getPersons_prizes() {
		return persons_prizes;
	}
	
	/**
	 * @param persons_prizes the persons_prizes to set
	 */
	public void setPersons_prizes(Set<Person_Prize> persons_prizes) {
		this.persons_prizes = persons_prizes;
	}
	
	/**
	 * @return the persons_qualifications
	 */
	public Set<Person_Qualification> getPersons_qualifications() {
		return persons_qualifications;
	}
	
	/**
	 * @param persons_qualifications the persons_qualifications to set
	 */
	public void setPersons_qualifications(
			Set<Person_Qualification> persons_qualifications) {
		this.persons_qualifications = persons_qualifications;
	}
	
	/**
	 * @return the persons_resultPatents
	 */
	public Set<Person_ResultPatent> getPersons_resultPatents() {
		return persons_resultPatents;
	}
	
	/**
	 * @param persons_resultPatents the persons_resultPatents to set
	 */
	public void setPersons_resultPatents(
			Set<Person_ResultPatent> persons_resultPatents) {
		this.persons_resultPatents = persons_resultPatents;
	}
	
	/**
	 * @return the persons_resultPublications
	 */
	public Set<Person_ResultPublication> getPersons_resultPublications() {
		return persons_resultPublications;
	}
	
	/**
	 * @param persons_resultPublications the persons_resultPublications to set
	 */
	public void setPersons_resultPublications(
			Set<Person_ResultPublication> persons_resultPublications) {
		this.persons_resultPublications = persons_resultPublications;
	}
	
	/**
	 * @return the persons_services
	 */
	public Set<Person_Service> getPersons_services() {
		return persons_services;
	}
	
	/**
	 * @param persons_services the persons_services to set
	 */
	public void setPersons_services(Set<Person_Service> persons_services) {
		this.persons_services = persons_services;
	}
	
	/**
	 * @return the persons_medium
	 */
	public Set<Person_Medium> getPersons_medium() {
		return persons_medium;
	}
	
	/**
	 * @param persons_medium the persons_services to set
	 */
	public void setPersons_medium(Set<Person_Medium> persons_medium) {
		this.persons_medium = persons_medium;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}

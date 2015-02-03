/**
 * 
 */
package gr.ekt.cerif.features.additional;

import java.util.Set;

import gr.ekt.cerif.entities.link.PersonName_Class;
import gr.ekt.cerif.entities.link.PersonName_Person;

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
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * Holds the names of the person entity.
 * 
 */
@Entity
@Table(name="cfPersName")
@Indexed(index="indexes/persons/names")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class PersonName implements CerifAdditionalFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -445651440143730694L;
	
	@Id
	@Column(name="cfPersNameId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The person first names
	 */
	@Column(name="cfFirstNames")
	@Field(name="personFirstNames", index=Index.YES, store=Store.YES)
	private String firstNames;
	
	/**
	 * The person family names
	 */
	@Column(name="cfFamilyNames")
	@Field(name="personFamilyNames", index=Index.YES, store=Store.YES)
	private String familyNames;
	
	/**
	 * The person other names
	 */
	@Deprecated
	@Column(name="cfOtherNames")
	@Field(name="personOtherNames", index=Index.YES, store=Store.YES)
	private String otherNames;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="personName")
	private Set<PersonName_Person> personNames_persons;
	
	@OneToMany(mappedBy="personName")
	private Set<PersonName_Class> personNames_classes;
	
	
	/**
	 * Default Constructor  
	 */
	public PersonName() {
		
	}

	/**
	 * @param firstNames
	 * @param familyNames
	 * @param otherNames
	 */
	public PersonName(String firstNames, String familyNames, String otherNames) {
		this.firstNames = firstNames;
		this.familyNames = familyNames;
		this.otherNames = otherNames;
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


	/**
	 * @return the first names
	 */
	public String getFirstNames() {
		return firstNames;
	}

	/**
	 * @param firstNames the firstNames to set
	 */
	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}

	/**
	 * @return the family names
	 */
	public String getFamilyNames() {
		return familyNames;
	}

	/**
	 * @param familyNames the familyNames to set
	 */
	public void setFamilyNames(String familyNames) {
		this.familyNames = familyNames;
	}

	/**
	 * @return the other names
	 */
	public String getOtherNames() {
		return otherNames;
	}

	/**
	 * @param otherNames the otherNames to set
	 */
	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}

	/**
	 * @return the personNames_persons
	 */
	public Set<PersonName_Person> getPersonNames_persons() {
		return personNames_persons;
	}

	/**
	 * @param personNames_persons the personNames_persons to set
	 */
	public void setPersonNames_persons(Set<PersonName_Person> personNames_persons) {
		this.personNames_persons = personNames_persons;
	}

	/**
	 * @return the personNames_classes
	 */
	public Set<PersonName_Class> getPersonNames_classes() {
		return personNames_classes;
	}

	/**
	 * @param personNames_classes the personNames_classes to set
	 */
	public void setPersonNames_classes(Set<PersonName_Class> personNames_classes) {
		this.personNames_classes = personNames_classes;
	}
	
}

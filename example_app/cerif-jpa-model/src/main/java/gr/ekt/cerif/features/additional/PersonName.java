/**
 * 
 */
package gr.ekt.cerif.features.additional;

import gr.ekt.cerif.entities.base.Person;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
@Table(name="cfPersName", uniqueConstraints=@UniqueConstraint(columnNames={"cfPersId"}))
@Indexed(index="indexes/persons/names")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class PersonName implements CerifAdditionalFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -445651440143730694L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The person.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfPersId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Person person;
	
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
	@Column(name="cfOtherNames")
	@Field(name="personOtherNames", index=Index.YES, store=Store.YES)
	private String otherNames;
	
	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	
	/**
	 * Default Constructor
	 */
	public PersonName() {
		
	}
	
	/**
	 * 
	 * @param person
	 * @param firstNames
	 * @param familyNames
	 * @param otherNames
	 */
	public PersonName(Person person, String firstNames,
			String familyNames, String otherNames) {
		this.person = person;
		this.firstNames = firstNames;
		this.familyNames = familyNames;
		this.otherNames = otherNames;
	}


	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
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
	
}

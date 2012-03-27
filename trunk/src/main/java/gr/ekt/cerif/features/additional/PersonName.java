/**
 * 
 */
package gr.ekt.cerif.features.additional;

import gr.ekt.cerif.entities.base.Person;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Holds the names of the person entity.
 * 
 */
@Entity
@Table(name="cfPersName")
public class PersonName implements CerifAdditionalFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -445651440143730694L;
	
	@Id @GeneratedValue(generator = "customForeignGenerator")
	@Column(name="cfPersId")
    @org.hibernate.annotations.GenericGenerator(
        name = "customForeignGenerator",
        strategy = "foreign",
        parameters = @org.hibernate.annotations.Parameter(name = "property", value = "person")
    )
    private Long id;
	
	/**
	 * The person.
	 */
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="cfPersId")
	private Person person;
	
	/**
	 * The person first names
	 */
	@Column(name="cfFirstNames")
	private String firstNames;
	
	/**
	 * The person family names
	 */
	@Column(name="cfFamilyNames")
	private String familyNames;
	
	/**
	 * The person other names
	 */
	@Column(name="cfOtherNames")
	private String otherNames;
	
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

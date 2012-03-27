/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.person.Person_Cv;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents a cv second level entity.
 * 
 */
@Entity
@Table(name="cfCV")
public class CV implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -5661213458990111785L;	

	/**
	 * The citation id.
	 */
	@Id
	@Column(name="cfCVId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The URI.
	 */
	@Column(name="cfCVDoc")
	private Byte[] doc;

	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	@OneToMany(mappedBy="cv")
	private Set<Person_Cv> persons_cvs;

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
	 * @return the doc
	 */
	public Byte[] getDoc() {
		return doc;
	}

	/**
	 * @param doc the doc to set
	 */
	public void setDoc(Byte[] doc) {
		this.doc = doc;
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
	
}

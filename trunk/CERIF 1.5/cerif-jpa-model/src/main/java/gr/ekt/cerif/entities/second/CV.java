/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.Cv_Class;
import gr.ekt.cerif.entities.link.person.Person_Cv;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	@Basic(fetch=FetchType.LAZY)
	@Column(name="cfCVDoc",length = 20971520)
	private byte[] doc;

	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	/**
	 * The UUID.
	 */
	@Column(name="cfUUID")
	private String uuid;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="cv")
	private Set<Person_Cv> persons_cvs;
	
	@OneToMany(mappedBy="cv")
	private Set<Cv_Class> cvs_classes;
	
	
	/**
	 * FederatedIdentifier entities related to CV instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//

	/**
	 * Default Constructor
	 */
	public CV() {
		
	}
	
	/**
	 * 
	 * @param doc
	 * @param uri
	 */
	public CV(byte[] doc, String uri) {
		this.doc = doc;
		this.uri = uri;
	}
	
	/**
	 * 
	 * @param doc
	 */
	public CV(byte[] doc) {
		this.doc = doc;
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
	 * @return the doc
	 */
	public byte[] getDoc() {
		return doc;
	}

	/**
	 * @param doc the doc to set
	 */
	public void setDoc(byte[] doc) {
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
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	 * @return the cvs_classes
	 */
	public Set<Cv_Class> getCvs_classes() {
		return cvs_classes;
	}

	/**
	 * @param cvs_classes the cvs_classes to set
	 */
	public void setCvs_classes(Set<Cv_Class> cvs_classes) {
		this.cvs_classes = cvs_classes;
	}

	/**
	 * @return the federatedIdentifiers
	 */
	public List<FederatedIdentifier> getFederatedIdentifiers() {
		return federatedIdentifiers;
	}

	/**
	 * @param federatedIdentifiers the federatedIdentifiers to set
	 */
	public void setFederatedIdentifiers(
			List<FederatedIdentifier> federatedIdentifiers) {
		this.federatedIdentifiers = federatedIdentifiers;
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
		CV other = (CV) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CV [id=" + id + ", doc=" + Arrays.toString(doc) + ", uri="
				+ uri + ", uuid=" + uuid + "]";
	}


}

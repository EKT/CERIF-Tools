/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.CurriculumVitae_Class;
import gr.ekt.cerif.entities.link.person.Person_CurriculumVitae;

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
 * Represents a Curriculum Vitae second level entity.
 * 
 */
@Entity
@Table(name="cfCV")
public class CurriculumVitae implements CerifSecondLevelEntity {
	
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
	@OneToMany(mappedBy="curriculumVitae")
	private Set<Person_CurriculumVitae> persons_curriculumVitaes;
	
	@OneToMany(mappedBy="curriculumVitae")
	private Set<CurriculumVitae_Class> curriculumVitaes_classes;
	
	
	/**
	 * FederatedIdentifier entities related to CV instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//

	/**
	 * Default Constructor
	 */
	public CurriculumVitae() {
		
	}
	
	/**
	 * 
	 * @param doc
	 * @param uri
	 */
	public CurriculumVitae(byte[] doc, String uri) {
		this.doc = doc;
		this.uri = uri;
	}
	
	/**
	 * 
	 * @param doc
	 */
	public CurriculumVitae(byte[] doc) {
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
	 * @return the persons_curriculumVitaes
	 */
	public Set<Person_CurriculumVitae> getPersons_curriculumVitaes() {
		return persons_curriculumVitaes;
	}

	/**
	 * @param persons_curriculumVitaes the persons_curriculumVitaes to set
	 */
	public void setPersons_curriculumVitaes(
			Set<Person_CurriculumVitae> persons_curriculumVitaes) {
		this.persons_curriculumVitaes = persons_curriculumVitaes;
	}

	/**
	 * @return the curriculumVitaes_classes
	 */
	public Set<CurriculumVitae_Class> getCurriculumVitaes_classes() {
		return curriculumVitaes_classes;
	}

	/**
	 * @param curriculumVitaes_classes the curriculumVitaes_classes to set
	 */
	public void setCurriculumVitaes_classes(
			Set<CurriculumVitae_Class> curriculumVitaes_classes) {
		this.curriculumVitaes_classes = curriculumVitaes_classes;
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
		CurriculumVitae other = (CurriculumVitae) obj;
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
		return "CurriculumVitae [id=" + id + ", doc=" + Arrays.toString(doc) + ", uri="
				+ uri + ", uuid=" + uuid + "]";
	}


}

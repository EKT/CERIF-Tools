/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.Qualification_Class;
import gr.ekt.cerif.entities.link.person.Person_Qualification;
import gr.ekt.cerif.features.multilingual.QualificationDescription;
import gr.ekt.cerif.features.multilingual.QualificationKeyword;
import gr.ekt.cerif.features.multilingual.QualificationTitle;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Represents a Qualification second level entity.
 * 
 */
@Entity
@Table(name="cfQual")
public class Qualification implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -862947308643033005L;

	/**
	 * The citation id.
	 */
	@Id
	@Column(name="cfQualId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

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
	 * Multilingual.
	 */
	@OneToMany(mappedBy="qualification")
	private Set<QualificationTitle> qualificationTitles;
	
	@OneToMany(mappedBy="qualification")
	private Set<QualificationKeyword> qualificationKeywords;
	
	@OneToMany(mappedBy="qualification")
	private Set<QualificationDescription> qualificationDescriptions;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="qualification")
	private Set<Person_Qualification> persons_qualifications;
	
	@OneToMany(mappedBy="qualification")
	private Set<Qualification_Class> qualifications_classes;

	
	/**
	 * FederatedIdentifier entities related to Qualification instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//

	/**
	 * Default constructor
	 */
	public Qualification() {
		
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
	 * @return the qualificationTitles
	 */
	public Set<QualificationTitle> getQualificationTitles() {
		return qualificationTitles;
	}

	/**
	 * @param qualificationTitles the qualificationTitles to set
	 */
	public void setQualificationTitles(Set<QualificationTitle> qualificationTitles) {
		this.qualificationTitles = qualificationTitles;
	}

	/**
	 * @return the qualificationKeywords
	 */
	public Set<QualificationKeyword> getQualificationKeywords() {
		return qualificationKeywords;
	}

	/**
	 * @param qualificationKeywords the qualificationKeywords to set
	 */
	public void setQualificationKeywords(
			Set<QualificationKeyword> qualificationKeywords) {
		this.qualificationKeywords = qualificationKeywords;
	}

	/**
	 * @return the qualificationDescriptions
	 */
	public Set<QualificationDescription> getQualificationDescriptions() {
		return qualificationDescriptions;
	}

	/**
	 * @param qualificationDescriptions the qualificationDescriptions to set
	 */
	public void setQualificationDescriptions(
			Set<QualificationDescription> qualificationDescriptions) {
		this.qualificationDescriptions = qualificationDescriptions;
	}

	/**
	 * @return the qualifications_classes
	 */
	public Set<Qualification_Class> getQualifications_classes() {
		return qualifications_classes;
	}

	/**
	 * @param qualifications_classes the qualifications_classes to set
	 */
	public void setQualifications_classes(
			Set<Qualification_Class> qualifications_classes) {
		this.qualifications_classes = qualifications_classes;
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
		Qualification other = (Qualification) obj;
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
		return "Qualification [id=" + id + ", uri=" + uri + ", uuid=" + uuid
				+ "]";
	}

	
}

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
	private Set<QualificationTitle> titles;
	
	@OneToMany(mappedBy="qualification")
	private Set<QualificationKeyword> keywords;
	
	@OneToMany(mappedBy="qualification")
	private Set<QualificationDescription> descriptions;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="qualification")
	private Set<Person_Qualification> persons_qualifications;
	
	@OneToMany(mappedBy="qualification")
	private Set<Qualification_Class> classes;

	
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
	 * 
	 * @param uri
	 * @param titles
	 * @param keywords
	 * @param descriptions
	 */
	public Qualification(String uri, Set<QualificationTitle> titles,
			Set<QualificationKeyword> keywords,
			Set<QualificationDescription> descriptions) {
		this.uri = uri;
		this.titles = titles;
		this.keywords = keywords;
		this.descriptions = descriptions;
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

	public Set<QualificationTitle> getTitles() {
		return titles;
	}

	public void setTitles(Set<QualificationTitle> titles) {
		this.titles = titles;
	}

	public Set<QualificationKeyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<QualificationKeyword> keywords) {
		this.keywords = keywords;
	}

	public Set<QualificationDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<QualificationDescription> descriptions) {
		this.descriptions = descriptions;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Qualification [id=" + id + ", uri=" + uri + ", uuid=" + uuid
				+ "]";
	}

	
}

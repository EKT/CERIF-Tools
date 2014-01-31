/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.Service_Medium;
import gr.ekt.cerif.entities.link.person.Person_Medium;
import gr.ekt.cerif.entities.link.result.ResultPublication_Medium;
import gr.ekt.cerif.features.multilingual.MediumDescription;
import gr.ekt.cerif.features.multilingual.MediumKeyword;
import gr.ekt.cerif.features.multilingual.MediumTitle;

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


/**
 * Represents a medium second level entity.
 * 
 */
@Entity
@Table(name="cfMedium")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Medium implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -240908659483900668L;	
	
	/**
	 * The Medium id.
	 */
	@Id
	@Column(name="cfMediumId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The medium creation date.
	 */
	@Column(name="cfMediumCreationDate")
	private String mediumCreationDate;
	
	/**
	 * The size.
	 */
	@Column(name="cfSize")
	private Double size;
	
	/**
	 * The mimeType.
	 */
	@Column(name="cfMimeType")
	private String mimeType;
	
	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	@OneToMany(mappedBy="medium")
	private Set<MediumTitle> names;
	
	@OneToMany(mappedBy="medium")
	private Set<MediumKeyword> keywords;
	
	@OneToMany(mappedBy="medium")
	private Set<MediumDescription> descriptions;
	
	/**
	 * The persons_medium.
	 */
	@OneToMany(mappedBy="medium")
	private Set<Person_Medium> persons_medium;
	
	/**
	 * The resultPublications_medium.
	 */
	@OneToMany(mappedBy="medium")
	private Set<ResultPublication_Medium> resultPublications_medium;
	
	@OneToMany(mappedBy="medium")
	private Set<Service_Medium> services_mediums;

	/**
	 * Default Constructor
	 */
	public Medium() {
		
	}
	
	/**
	 * 
	 * @param mediumCreationDate
	 * @param size
	 * @param mimeType
	 * @param uri
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public Medium(String mediumCreationDate, Double size, String mimeType,
			String uri, Set<MediumTitle> names, Set<MediumKeyword> keywords,
			Set<MediumDescription> descriptions) {
		this.mediumCreationDate = mediumCreationDate;
		this.size = size;
		this.mimeType = mimeType;
		this.uri = uri;
		this.names = names;
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
	 * @return the mediumCreationDate
	 */
	public String getMediumCreationDate() {
		return mediumCreationDate;
	}

	/**
	 * @param mediumCreationDate the mediumCreationDate to set
	 */
	public void setMediumCreationDate(String mediumCreationDate) {
		this.mediumCreationDate = mediumCreationDate;
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
	 * @return the size
	 */
	public Double getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Double size) {
		this.size = size;
	}

	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * @param mimeType the mimeType to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	/**
	 * @return the names
	 */
	public Set<MediumTitle> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(Set<MediumTitle> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public Set<MediumKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(Set<MediumKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public Set<MediumDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(Set<MediumDescription> descriptions) {
		this.descriptions = descriptions;
	}
	
	/**
	 * @return the persons_medium
	 */
	public Set<Person_Medium> getPersons_medium() {
		return persons_medium;
	}
	
	/**
	 * @param persons_medium the persons_medium to set
	 */
	public void setPersons_medium(
			Set<Person_Medium> persons_medium) {
		this.persons_medium = persons_medium;
	}
	
	/**
	 * @return the resultPublications_medium
	 */
	public Set<ResultPublication_Medium> getResultPublications_medium() {
		return resultPublications_medium;
	}

	/**
	 * @param resultPublications_medium the resultPublications_medium to set
	 */
	public void setResultPublications_medium(
			Set<ResultPublication_Medium> resultPublications_medium) {
		this.resultPublications_medium = resultPublications_medium;
	}

	/**
	 * @return the services_mediums
	 */
	public Set<Service_Medium> getServices_mediums() {
		return services_mediums;
	}

	/**
	 * @param services_mediums the services_mediums to set
	 */
	public void setServices_mediums(Set<Service_Medium> services_mediums) {
		this.services_mediums = services_mediums;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
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
		Medium other = (Medium) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Medium [id=" + id + ", mediumCreationDate="
				+ mediumCreationDate + ", size=" + size + ", mimeType="
				+ mimeType + ", uri=" + uri + "]";
	}
	
	
}

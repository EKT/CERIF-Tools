/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.Citation_Class;
import gr.ekt.cerif.entities.link.Citation_Medium;
import gr.ekt.cerif.entities.link.result.ResultPublication_Citation;
import gr.ekt.cerif.features.multilingual.CitationDescription;
import gr.ekt.cerif.features.multilingual.CitationTitle;

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
 * Represents a citation second level entity.
 * 
 */
@Entity
@Table(name="cfCite")
public class Citation implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 8532992093242487321L;

	/**
	 * The citation id.
	 */
	@Id
	@Column(name="cfCiteId")
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
	@OneToMany(mappedBy="citation")
	private Set<CitationDescription> citationDescriptions;
	
	@OneToMany(mappedBy="citation")
	private Set<CitationTitle> citationTitles;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="citation")
	private Set<ResultPublication_Citation> resultPublications_citations;
	
	@OneToMany(mappedBy="citation")
	private Set<Citation_Class> classes;
	
	@OneToMany(mappedBy="citation")
	private Set<Citation_Medium> citations_mediums;
	
	
	/**
	 * FederatedIdentifier entities related to Citation instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//

	/**
	 * Default Constructor
	 */
	public Citation() {
		
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
	 * @return the citationDescriptions
	 */
	public Set<CitationDescription> getCitationDescriptions() {
		return citationDescriptions;
	}

	/**
	 * @param citationDescriptions the citationDescriptions to set
	 */
	public void setCitationDescriptions(
			Set<CitationDescription> citationDescriptions) {
		this.citationDescriptions = citationDescriptions;
	}

	/**
	 * @return the citationTitles
	 */
	public Set<CitationTitle> getCitationTitles() {
		return citationTitles;
	}

	/**
	 * @param citationTitles the citationTitles to set
	 */
	public void setCitationTitles(Set<CitationTitle> citationTitles) {
		this.citationTitles = citationTitles;
	}

	/**
	 * @return the resultPublications_citations
	 */
	public Set<ResultPublication_Citation> getResultPublications_citations() {
		return resultPublications_citations;
	}
	
	/**
	 * @param resultPublications_citations the resultPublications_citations to set
	 */
	public void setResultPublications_citations(
			Set<ResultPublication_Citation> resultPublications_citations) {
		this.resultPublications_citations = resultPublications_citations;
	}

	/**
	 * @return the classes
	 */
	public Set<Citation_Class> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(Set<Citation_Class> classes) {
		this.classes = classes;
	}

	/**
	 * @return the citations_mediums
	 */
	public Set<Citation_Medium> getCitations_mediums() {
		return citations_mediums;
	}

	/**
	 * @param citations_mediums the citations_mediums to set
	 */
	public void setCitations_mediums(Set<Citation_Medium> citations_mediums) {
		this.citations_mediums = citations_mediums;
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
		Citation other = (Citation) obj;
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
		return "Citation [id=" + id + ", uri=" + uri + ", uuid=" + uuid + "]";
	}

	
}

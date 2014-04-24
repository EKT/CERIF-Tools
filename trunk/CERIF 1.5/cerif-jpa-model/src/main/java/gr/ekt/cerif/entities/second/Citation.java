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
	private Set<CitationDescription> descriptions;
	
	@OneToMany(mappedBy="citation")
	private Set<CitationTitle> titles;
	
	
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
	 * 
	 * @param uri
	 * @param descriptions
	 * @param titles
	 */
	public Citation(String uri, Set<CitationDescription> descriptions,
			Set<CitationTitle> titles) {
		this.uri = uri;
		this.descriptions = descriptions;
		this.titles = titles;
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
	 * @return the descriptions
	 */
	public Set<CitationDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(Set<CitationDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/**
	 * @return the titles
	 */
	public Set<CitationTitle> getTitles() {
		return titles;
	}

	/**
	 * @param titles the titles to set
	 */
	public void setTitles(Set<CitationTitle> titles) {
		this.titles = titles;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Citation [id=" + id + ", uri=" + uri + ", uuid=" + uuid + "]";
	}

	
}

/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.result.ResultPublication_Citation;
import gr.ekt.cerif.features.multilingual.CitationDescription;
import gr.ekt.cerif.features.multilingual.CitationTitle;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	@OneToMany(mappedBy="citation")
	private Set<CitationDescription> descriptions;
	
	@OneToMany(mappedBy="citation")
	private Set<CitationTitle> titles;
	
	@OneToMany(mappedBy="citation")
	private Set<ResultPublication_Citation> resultPublications_citations;

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
}

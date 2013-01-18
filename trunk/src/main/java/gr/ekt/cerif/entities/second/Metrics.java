/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.result.ResultPublication_Metrics;
import gr.ekt.cerif.features.multilingual.MetricsDescription;
import gr.ekt.cerif.features.multilingual.MetricsKeyword;
import gr.ekt.cerif.features.multilingual.MetricsName;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents a metrics second level entity.
 * 
 */
@Entity
@Table(name="cfMetrics")
public class Metrics implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -798754325875412309L;
	
	/**
	 * The metrics id.
	 */
	@Id
	@Column(name="cfCMetricsId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	@OneToMany(mappedBy="metrics")
	private Set<MetricsName> names;
	
	@OneToMany(mappedBy="metrics")
	private Set<MetricsKeyword> keywords;
	
	@OneToMany(mappedBy="metrics")
	private Set<MetricsDescription> descriptions;
	
	@OneToMany(mappedBy="metrics")
	private Set<ResultPublication_Metrics> resultPublications_metrics;

	/**
	 * Default Constructor
	 */
	public Metrics() {
		
	}
	
	/**
	 * 
	 * @param uri
	 * @param names
	 * @param keywords
	 * @param descriptions
	 * @param resultPublications_metrics
	 */
	public Metrics(String uri, Set<MetricsName> names,
			Set<MetricsKeyword> keywords, Set<MetricsDescription> descriptions,
			Set<ResultPublication_Metrics> resultPublications_metrics) {
		this.uri = uri;
		this.names = names;
		this.keywords = keywords;
		this.descriptions = descriptions;
		this.resultPublications_metrics = resultPublications_metrics;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Set<MetricsName> getNames() {
		return names;
	}

	public void setNames(Set<MetricsName> names) {
		this.names = names;
	}

	public Set<MetricsKeyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<MetricsKeyword> keywords) {
		this.keywords = keywords;
	}

	public Set<MetricsDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<MetricsDescription> descriptions) {
		this.descriptions = descriptions;
	}
	
	/**
	 * @return the resultPublications_metrics
	 */
	public Set<ResultPublication_Metrics> getResultPublications_metrics() {
		return resultPublications_metrics;
	}
	
	/**
	 * @param resultPublications_metrics the resultPublications_metrics to set
	 */
	public void setResultPublications_metrics(
			Set<ResultPublication_Metrics> resultPublications_metrics) {
		this.resultPublications_metrics = resultPublications_metrics;
	}
}

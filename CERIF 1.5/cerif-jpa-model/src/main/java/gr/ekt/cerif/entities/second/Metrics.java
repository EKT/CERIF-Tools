/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.Metrics_Class;
import gr.ekt.cerif.entities.link.result.ResultPublication_Metrics;
import gr.ekt.cerif.features.multilingual.MetricsDescription;
import gr.ekt.cerif.features.multilingual.MetricsKeyword;
import gr.ekt.cerif.features.multilingual.MetricsName;

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
	
	/**
	 * The UUID.
	 */
	@Column(name="cfUUID")
	private String uuid;
	
	
	/**
	 * Multilingual.
	 */
	@OneToMany(mappedBy="metrics")
	private Set<MetricsName> names;
	
	@OneToMany(mappedBy="metrics")
	private Set<MetricsKeyword> keywords;
	
	@OneToMany(mappedBy="metrics")
	private Set<MetricsDescription> descriptions;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="metrics")
	private Set<ResultPublication_Metrics> resultPublications_metrics;
	
	@OneToMany(mappedBy="metrics")
	private Set<Metrics_Class> classes;

	
	/**
	 * FederatedIdentifier entities related to Metrics instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//

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

	/**
	 * @return the classes
	 */
	public Set<Metrics_Class> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(Set<Metrics_Class> classes) {
		this.classes = classes;
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
		return "Metrics [id=" + id + ", uri=" + uri + "]";
	}
	
	
}

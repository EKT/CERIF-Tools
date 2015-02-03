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
	@Column(name="cfMetricsId")
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
	private Set<MetricsName> metricsNames;
	
	@OneToMany(mappedBy="metrics")
	private Set<MetricsKeyword> metricsKeywords;
	
	@OneToMany(mappedBy="metrics")
	private Set<MetricsDescription> metricsDescriptions;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="metrics")
	private Set<ResultPublication_Metrics> resultPublications_metrics;
	
	@OneToMany(mappedBy="metrics")
	private Set<Metrics_Class> metrics_classes;

	
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

	/**
	 * @return the metricsNames
	 */
	public Set<MetricsName> getMetricsNames() {
		return metricsNames;
	}

	/**
	 * @param metricsNames the metricsNames to set
	 */
	public void setMetricsNames(Set<MetricsName> metricsNames) {
		this.metricsNames = metricsNames;
	}

	/**
	 * @return the metricsKeywords
	 */
	public Set<MetricsKeyword> getMetricsKeywords() {
		return metricsKeywords;
	}

	/**
	 * @param metricsKeywords the metricsKeywords to set
	 */
	public void setMetricsKeywords(Set<MetricsKeyword> metricsKeywords) {
		this.metricsKeywords = metricsKeywords;
	}
	
	/**
	 * @return the metricsDescriptions
	 */
	public Set<MetricsDescription> getMetricsDescriptions() {
		return metricsDescriptions;
	}

	/**
	 * @param metricsDescriptions the metricsDescriptions to set
	 */
	public void setMetricsDescriptions(Set<MetricsDescription> metricsDescriptions) {
		this.metricsDescriptions = metricsDescriptions;
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
	 * @return the metrics_classes
	 */
	public Set<Metrics_Class> getMetrics_classes() {
		return metrics_classes;
	}

	/**
	 * @param metrics_classes the metrics_classes to set
	 */
	public void setMetrics_classes(Set<Metrics_Class> metrics_classes) {
		this.metrics_classes = metrics_classes;
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
		Metrics other = (Metrics) obj;
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
		return "Metrics [id=" + id + ", uri=" + uri + "]";
	}
	
	
}

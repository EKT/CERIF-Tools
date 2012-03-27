/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.result.ResultPatent_Indicator;
import gr.ekt.cerif.entities.link.result.ResultProduct_Indicator;
import gr.ekt.cerif.entities.link.result.ResultPublication_Indicator;

import java.util.Set;

import gr.ekt.cerif.features.multilingual.IndicatorDescription;
import gr.ekt.cerif.features.multilingual.IndicatorKeyword;
import gr.ekt.cerif.features.multilingual.IndicatorName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents an indicator second level entity.
 * 
 */
@Entity
@Table(name="cfIndic")
public class Indicator implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -2859095654662437486L;

	/**
	 * The citation id.
	 */
	@Id
	@Column(name="cfIndicId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	@OneToMany(mappedBy="indicator")
	private Set<ResultPatent_Indicator> resultPatents_indicators;
	
	@OneToMany(mappedBy="indicator")
	private Set<ResultProduct_Indicator> resultProducts_indicators;
	
	@OneToMany(mappedBy="indicator", fetch=FetchType.EAGER)
	private Set<IndicatorName> names;
	
	@OneToMany(mappedBy="indicator", fetch=FetchType.EAGER)
	private Set<IndicatorKeyword> keywords;
	
	@OneToMany(mappedBy="indicator", fetch=FetchType.EAGER)
	private Set<IndicatorDescription> descriptions;
	
	@OneToMany(mappedBy="indicator")
	private Set<ResultPublication_Indicator> resultPublications_indicators;

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
	 * @return the resultPatents_indicators
	 */
	public Set<ResultPatent_Indicator> getResultPatents_indicators() {
		return resultPatents_indicators;
	}
	
	/**
	 * @param resultPatents_indicators the resultPatents_indicators to set
	 */
	public void setResultPatents_indicators(
			Set<ResultPatent_Indicator> resultPatents_indicators) {
		this.resultPatents_indicators = resultPatents_indicators;
	}
	
	/**
	 * @return the resultProducts_indicators
	 */
	public Set<ResultProduct_Indicator> getResultProducts_indicators() {
		return resultProducts_indicators;
	}
	
	/**
	 * @param resultProducts_indicators the resultProducts_indicators to set
	 */
	public void setResultProducts_indicators(
			Set<ResultProduct_Indicator> resultProducts_indicators) {
		this.resultProducts_indicators = resultProducts_indicators;
	}
	
	/**
	 * @return the names
	 */
	public Set<IndicatorName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(Set<IndicatorName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public Set<IndicatorKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(Set<IndicatorKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public Set<IndicatorDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(Set<IndicatorDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/**
	 * @return the resultPublications_indicators
	 */
	public Set<ResultPublication_Indicator> getResultPublications_indicators() {
		return resultPublications_indicators;
	}
	
	/**
	 * @param resultPublications_indicators the resultPublications_indicators to set
	 */
	public void setResultPublications_indicators(
			Set<ResultPublication_Indicator> resultPublications_indicators) {
		this.resultPublications_indicators = resultPublications_indicators;
	}
	
}

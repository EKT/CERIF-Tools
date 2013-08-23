package gr.ekt.cerif.services.multilingual.metrics;

import gr.ekt.cerif.features.multilingual.MetricsDescription;
import gr.ekt.cerif.features.multilingual.MetricsKeyword;
import gr.ekt.cerif.features.multilingual.MetricsName;

import java.util.List;

public class MetricsMultilingualTO {

	/**
	 * The metrics id.
	 */
	private Long id;
	
	/**
	 * The metrics names.
	 */
	private List<MetricsName> names;
	
	/**
	 * The metrics keywords.
	 */
	private List<MetricsKeyword> keywords;
	
	/**
	 * The metrics descriptions.
	 */
	private List<MetricsDescription> descriptions;

	/**
	 * @param id
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public MetricsMultilingualTO(Long id, List<MetricsName> names,
			List<MetricsKeyword> keywords, List<MetricsDescription> descriptions) {
		super();
		this.id = id;
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
	 * @return the names
	 */
	public List<MetricsName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(List<MetricsName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public List<MetricsKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<MetricsKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public List<MetricsDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(List<MetricsDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MetricsMultilingualTO [id=" + id + ", names=" + names
				+ ", keywords=" + keywords + ", descriptions=" + descriptions
				+ "]";
	}
	
	
	
}

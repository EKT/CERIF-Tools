package gr.ekt.cerif.services.multilingual.indicator;

import gr.ekt.cerif.features.multilingual.IndicatorDescription;
import gr.ekt.cerif.features.multilingual.IndicatorKeyword;
import gr.ekt.cerif.features.multilingual.IndicatorName;

import java.util.List;

public class IndicatorMultilingualTO {

	/**
	 * The citation id.
	 */
	private Long id;

	/**
	 * The citation names.
	 */
	private List<IndicatorName> names;
	
	/**
	 * The citation keywords.
	 */
	private List<IndicatorKeyword> keywords;
	
	/**
	 * The citation descriptions.
	 */
	private List<IndicatorDescription> descriptions;

	/**
	 * @param id
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public IndicatorMultilingualTO(Long id, List<IndicatorName> names,
			List<IndicatorKeyword> keywords,
			List<IndicatorDescription> descriptions) {
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
	public List<IndicatorName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(List<IndicatorName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public List<IndicatorKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<IndicatorKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public List<IndicatorDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(List<IndicatorDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IndicatorMultilingualTO [id=" + id + ", names=" + names
				+ ", keywords=" + keywords + ", descriptions=" + descriptions
				+ "]";
	}
	
	
}

package gr.ekt.cerif.services.multilingual.funding;

import gr.ekt.cerif.features.multilingual.FundingDescription;
import gr.ekt.cerif.features.multilingual.FundingKeyword;
import gr.ekt.cerif.features.multilingual.FundingName;

import java.util.List;

public class FundingMultilingualTO {

	/**
	 * The funding unique identifier.
	 */
	private Long id;

	/**
	 * The funding names.
	 */
	private List<FundingName> names;
	
	/**
	 * The funding keywords.
	 */
	private List<FundingKeyword> keywords;
	
	/**
	 * The funding descriptions.
	 */
	private List<FundingDescription> descriptions;

	/**
	 * @param id
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public FundingMultilingualTO(Long id, List<FundingName> names,
			List<FundingKeyword> keywords, List<FundingDescription> descriptions) {
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
	public List<FundingName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(List<FundingName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public List<FundingKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<FundingKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public List<FundingDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(List<FundingDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FundingMultilingualTO [id=" + id + ", names=" + names
				+ ", keywords=" + keywords + ", descriptions=" + descriptions
				+ "]";
	}

		
}

package gr.ekt.cerif.services.multilingual.prize;

import gr.ekt.cerif.features.multilingual.PrizeDescription;
import gr.ekt.cerif.features.multilingual.PrizeKeyword;
import gr.ekt.cerif.features.multilingual.PrizeName;

import java.util.List;

public class PrizeMultilingualTO {

	/**
	 * The citation id.
	 */
	private Long id;

	/**
	 * The citation names.
	 */
	private List<PrizeName> names;
	
	/**
	 * The citation keywords.
	 */
	private List<PrizeKeyword> keywords;
	
	/**
	 * The citation descriptions.
	 */
	private List<PrizeDescription> descriptions;

	/**
	 * @param id
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public PrizeMultilingualTO(Long id, List<PrizeName> names,
			List<PrizeKeyword> keywords, List<PrizeDescription> descriptions) {
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
	public List<PrizeName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(List<PrizeName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public List<PrizeKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<PrizeKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public List<PrizeDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(List<PrizeDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PrizeMultilingualTO [id=" + id + ", names=" + names
				+ ", keywords=" + keywords + ", descriptions=" + descriptions
				+ "]";
	}
	
	

}

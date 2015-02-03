package gr.ekt.cerif.services.multilingual.medium;

import gr.ekt.cerif.features.multilingual.MediumDescription;
import gr.ekt.cerif.features.multilingual.MediumKeyword;
import gr.ekt.cerif.features.multilingual.MediumTitle;

import java.util.List;

public class MediumMultilingualTO {

	/**
	 * The Medium id.
	 */
	private Long id;

	private List<MediumTitle> names;
	
	private List<MediumKeyword> keywords;
	
	private List<MediumDescription> descriptions;

	/**
	 * @param id
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public MediumMultilingualTO(Long id, List<MediumTitle> names,
			List<MediumKeyword> keywords, List<MediumDescription> descriptions) {
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
	public List<MediumTitle> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(List<MediumTitle> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public List<MediumKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<MediumKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public List<MediumDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(List<MediumDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MediumMultilingualTO [id=" + id + ", names=" + names
				+ ", keywords=" + keywords + ", descriptions=" + descriptions
				+ "]";
	}
	
	
}

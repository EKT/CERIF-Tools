package gr.ekt.cerif.services.multilingual.facility;

import gr.ekt.cerif.features.multilingual.FacilityDescription;
import gr.ekt.cerif.features.multilingual.FacilityKeyword;
import gr.ekt.cerif.features.multilingual.FacilityName;

import java.util.List;

public class FacilityMultilingualTO {

	/**
	 * The facility id.
	 */
	private Long id;

	/**
	 * The facility names.
	 */
	private List<FacilityName> names;
	
	/**
	 * The facility keywords.
	 */
	private List<FacilityKeyword> keywords;
	
	/**
	 * The facility descriptions.
	 */
	private List<FacilityDescription> descriptions;

	/**
	 * @param id
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public FacilityMultilingualTO(Long id, List<FacilityName> names,
			List<FacilityKeyword> keywords,
			List<FacilityDescription> descriptions) {
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
	public List<FacilityName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(List<FacilityName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public List<FacilityKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<FacilityKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public List<FacilityDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(List<FacilityDescription> descriptions) {
		this.descriptions = descriptions;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FacilityMultilingualTO [id=" + id + ", names=" + names
				+ ", keywords=" + keywords + ", descriptions=" + descriptions
				+ "]";
	}

	
	
}

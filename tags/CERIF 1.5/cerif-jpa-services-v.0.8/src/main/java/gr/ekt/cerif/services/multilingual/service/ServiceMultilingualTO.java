package gr.ekt.cerif.services.multilingual.service;

import gr.ekt.cerif.features.multilingual.ServiceDescription;
import gr.ekt.cerif.features.multilingual.ServiceKeyword;
import gr.ekt.cerif.features.multilingual.ServiceName;

import java.util.List;

public class ServiceMultilingualTO {

	/**
	 * The service id.
	 */
	private Long id;

	/**
	 * The service names.
	 */
	private List<ServiceName> names;
	
	/**
	 * The service keywords.
	 */
	private List<ServiceKeyword> keywords;
	
	/**
	 * The service descriptions.
	 */
	private List<ServiceDescription> descriptions;

	/**
	 * @param id
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public ServiceMultilingualTO(Long id, List<ServiceName> names,
			List<ServiceKeyword> keywords, List<ServiceDescription> descriptions) {
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
	public List<ServiceName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(List<ServiceName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public List<ServiceKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<ServiceKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public List<ServiceDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(List<ServiceDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServiceMultilingualTO [id=" + id + ", names=" + names
				+ ", keywords=" + keywords + ", descriptions=" + descriptions
				+ "]";
	}
	
	

}

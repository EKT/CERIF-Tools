package gr.ekt.cerif.services.multilingual.measurement;

import gr.ekt.cerif.features.multilingual.MeasurementDescription;
import gr.ekt.cerif.features.multilingual.MeasurementKeyword;
import gr.ekt.cerif.features.multilingual.MeasurementName;

import java.util.List;

public class MeasurementMultilingualTO {

	/**
	 * The Measurement id.
	 */
	private Long id;

	/**
	 * The Measurement names.
	 */
	private List<MeasurementName> names;
	
	/**
	 * The Measurement keywords.
	 */
	private List<MeasurementKeyword> keywords;
	
	/**
	 * The Measurement descriptions.
	 */
	private List<MeasurementDescription> descriptions;

	/**
	 * @param id
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public MeasurementMultilingualTO(Long id, List<MeasurementName> names,
			List<MeasurementKeyword> keywords,
			List<MeasurementDescription> descriptions) {
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
	public List<MeasurementName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(List<MeasurementName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public List<MeasurementKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<MeasurementKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public List<MeasurementDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(List<MeasurementDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MeasurementMultilingualTO [id=" + id + ", names=" + names
				+ ", keywords=" + keywords + ", descriptions=" + descriptions
				+ "]";
	}
	
	
}

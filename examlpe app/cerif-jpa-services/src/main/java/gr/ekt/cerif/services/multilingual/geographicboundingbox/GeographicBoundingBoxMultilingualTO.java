package gr.ekt.cerif.services.multilingual.geographicboundingbox;

import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxDescription;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxKeyword;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxName;

import java.util.List;

public class GeographicBoundingBoxMultilingualTO {

	/**
	 * The bounding box unique identifier.
	 */
	private Long id;

	/**
	 * The Geographic Bounding Box Names.
	 */
	private List<GeographicBoundingBoxName> geographicBoundingBoxNames;
	
	/**
	 * The Geographic Bounding Box Descriptions.
	 */
	private List<GeographicBoundingBoxDescription> geographicBoundingBoxDescriptions;
	
	/**
	 * The Geographic Bounding Box Keywords.
	 */
	private List<GeographicBoundingBoxKeyword> geographicBoundingBoxKeywords;

	/**
	 * @param id
	 * @param geographicBoundingBoxNames
	 * @param geographicBoundingBoxDescriptions
	 * @param geographicBoundingBoxKeywords
	 */
	public GeographicBoundingBoxMultilingualTO(
			Long id,
			List<GeographicBoundingBoxName> geographicBoundingBoxNames,
			List<GeographicBoundingBoxDescription> geographicBoundingBoxDescriptions,
			List<GeographicBoundingBoxKeyword> geographicBoundingBoxKeywords) {
		super();
		this.id = id;
		this.geographicBoundingBoxNames = geographicBoundingBoxNames;
		this.geographicBoundingBoxDescriptions = geographicBoundingBoxDescriptions;
		this.geographicBoundingBoxKeywords = geographicBoundingBoxKeywords;
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
	 * @return the geographicBoundingBoxNames
	 */
	public List<GeographicBoundingBoxName> getGeographicBoundingBoxNames() {
		return geographicBoundingBoxNames;
	}

	/**
	 * @param geographicBoundingBoxNames the geographicBoundingBoxNames to set
	 */
	public void setGeographicBoundingBoxNames(
			List<GeographicBoundingBoxName> geographicBoundingBoxNames) {
		this.geographicBoundingBoxNames = geographicBoundingBoxNames;
	}

	/**
	 * @return the geographicBoundingBoxDescriptions
	 */
	public List<GeographicBoundingBoxDescription> getGeographicBoundingBoxDescriptions() {
		return geographicBoundingBoxDescriptions;
	}

	/**
	 * @param geographicBoundingBoxDescriptions the geographicBoundingBoxDescriptions to set
	 */
	public void setGeographicBoundingBoxDescriptions(
			List<GeographicBoundingBoxDescription> geographicBoundingBoxDescriptions) {
		this.geographicBoundingBoxDescriptions = geographicBoundingBoxDescriptions;
	}

	/**
	 * @return the geographicBoundingBoxKeywords
	 */
	public List<GeographicBoundingBoxKeyword> getGeographicBoundingBoxKeywords() {
		return geographicBoundingBoxKeywords;
	}

	/**
	 * @param geographicBoundingBoxKeywords the geographicBoundingBoxKeywords to set
	 */
	public void setGeographicBoundingBoxKeywords(
			List<GeographicBoundingBoxKeyword> geographicBoundingBoxKeywords) {
		this.geographicBoundingBoxKeywords = geographicBoundingBoxKeywords;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GeographicBoundingBoxMultilingualTO [id=" + id
				+ ", geographicBoundingBoxNames=" + geographicBoundingBoxNames
				+ ", geographicBoundingBoxDescriptions="
				+ geographicBoundingBoxDescriptions
				+ ", geographicBoundingBoxKeywords="
				+ geographicBoundingBoxKeywords + "]";
	}

	
}

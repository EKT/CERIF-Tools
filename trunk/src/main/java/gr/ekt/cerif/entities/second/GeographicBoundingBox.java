/**
 * 
 */
package gr.ekt.cerif.entities.second;


import gr.ekt.cerif.entities.link.result.ResultProduct_GeographicBoundingBox;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxDescription;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxKeyword;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxName;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents a geographic bounding box second level entity.
 * 
 */
@Entity
@Table(name="cfGeoBBox")
public class GeographicBoundingBox implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -8559225299989580503L;

	/**
	 * The bounding box unique identifier.
	 */
	@Id
	@Column(name="cfGeoBBoxId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The West Bound Longitude.
	 */
	@Column(name="cfWBLong")
	private String WBLong;
	
	/**
	 * The East Bound Longitude.
	 */
	@Column(name="cfEBLong")
	private String EBLong;
	
	/**
	 * The South Bound Latitude.
	 */
	@Column(name="cfSBLat")
	private String SBLat;
	
	/**
	 * The North Bound Latitude.
	 */
	@Column(name="cfNBLat")
	private String NBLat;
	
	/**
	 * The Minimum Elevation.
	 */
	@Column(name="cfMinELev")
	private String MinElev;
	
	/**
	 * The Maximum Elevation.
	 */
	@Column(name="cfMaxElev")
	private String MaxElev;
	
	
	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;

	/**
	 * The result products.
	 */
	@OneToMany(mappedBy="geographicBoundingBox")
	private Set<ResultProduct_GeographicBoundingBox> resultProduct;
	
	/**
	 * The Geographic Bounding Box Names.
	 */
	@OneToMany(mappedBy="geographicBoundingBox")
	private Set<GeographicBoundingBoxName> geographicBoundingBoxNames;
	
	/**
	 * The Geographic Bounding Box Descriptions.
	 */
	@OneToMany(mappedBy="geographicBoundingBox")
	private Set<GeographicBoundingBoxDescription> geographicBoundingBoxDescriptions;
	
	/**
	 * The Geographic Bounding Box Keywords.
	 */
	@OneToMany(mappedBy="geographicBoundingBox")
	private Set<GeographicBoundingBoxKeyword> geographicBoundingBoxKeywords;


	/**
	 * Returns the unique identifier.
	 * @return the unique identifier.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the unique identifier.
	 * @param id the unique identifier.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	
	/**
	 * Returns the West Bound Longitude.
	 * @return WBLong the West Bound Longitude.
	 */
	public String getWBLong() {
		return WBLong;
	}

	/**
	 * Sets the West Bound Longitude.
	 * @param wBLong the West Bound Longitude.
	 */
	public void setWBLong(String wBLong) {
		WBLong = wBLong;
	}

	/**
	 * Returns the East Bound Longitude.
	 * @return EBLong the East Bound Longitude.
	 */
	public String getEBLong() {
		return EBLong;
	}
	
	/**
	 * Sets the West Bound Longitude.
	 * @param eBLong the West Bound Longitude.
	 */
	public void setEBLong(String eBLong) {
		EBLong = eBLong;
	}

	/**
	 * Returns the South Bound Latitude.
	 * @return SBLat the South Bound Latitude.
	 */
	public String getSBLat() {
		return SBLat;
	}

	/**
	 * Sets the South Bound Latitude.
	 * @param sBLat the South Bound Latitude.
	 */
	public void setSBLat(String sBLat) {
		SBLat = sBLat;
	}
	
	/**
	 * Returns the North Bound Latitude.
	 * @return NBLat the North Bound Latitude.
	 */
	public String getNBLat() {
		return NBLat;
	}

	/**
	 * Sets the North Bound Latitude.
	 * @param nBLat the North Bound Latitude.
	 */
	public void setNBLat(String nBLat) {
		NBLat = nBLat;
	}

	/**
	 * Returns the Minimum Elevation.
	 * @return MinElev the Minimum Elevation.
	 */
	public String getMinElev() {
		return MinElev;
	}

	/**
	 * Sets the Minimum Elevation.
	 * @param minElev the Minimum Elevation.
	 */
	public void setMinElev(String minElev) {
		MinElev = minElev;
	}

	/**
	 * Returns the Maximum Elevation.
	 * @return MaxElev the Maximum Elevation.
	 */
	public String getMaxElev() {
		return MaxElev;
	}
	
	/**
	 * Sets the Maximum Elevation.
	 * @param maxElev the Maximum Elevation.
	 */
	public void setMaxElev(String maxElev) {
		MaxElev = maxElev;
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
	 * @return the resultProducts
	 */
	public Set<ResultProduct_GeographicBoundingBox> getResultProduct() {
		return resultProduct;
	}

	/**
	 * @param resultProducts the resultProducts to set
	 */
	public void setResultProducts(
			Set<ResultProduct_GeographicBoundingBox> resultProduct) {
		this.resultProduct = resultProduct;
	}

	public Set<GeographicBoundingBoxName> getGeographicBoundingBoxNames() {
		return geographicBoundingBoxNames;
	}

	public void setGeographicBoundingBoxNames(
			Set<GeographicBoundingBoxName> geographicBoundingBoxNames) {
		this.geographicBoundingBoxNames = geographicBoundingBoxNames;
	}

	public Set<GeographicBoundingBoxDescription> getGeographicBoundingBoxDescriptions() {
		return geographicBoundingBoxDescriptions;
	}

	public void setGeographicBoundingBoxDescriptions(
			Set<GeographicBoundingBoxDescription> geographicBoundingBoxDescriptions) {
		this.geographicBoundingBoxDescriptions = geographicBoundingBoxDescriptions;
	}

	public Set<GeographicBoundingBoxKeyword> getGeographicBoundingBoxKeywords() {
		return geographicBoundingBoxKeywords;
	}

	public void setGeographicBoundingBoxKeywords(
			Set<GeographicBoundingBoxKeyword> geographicBoundingBoxKeywords) {
		this.geographicBoundingBoxKeywords = geographicBoundingBoxKeywords;
	}
	
}

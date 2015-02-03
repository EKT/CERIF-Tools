/**
 * 
 */
package gr.ekt.cerif.entities.second;


import gr.ekt.cerif.entities.link.GeographicBoundingBox_Class;
import gr.ekt.cerif.entities.link.GeographicBoundingBox_GeographicBoundingBox;
import gr.ekt.cerif.entities.link.GeographicBoundingBox_Measurement;
import gr.ekt.cerif.entities.link.PostalAddress_GeographicBoundingBox;
import gr.ekt.cerif.entities.link.result.ResultProduct_GeographicBoundingBox;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxDescription;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxKeyword;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxName;



import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	 * The UUID.
	 */
	@Column(name="cfUUID")
	private String uuid;

	
	/**
	 * Multilingual.
	 */
	@OneToMany(mappedBy="geographicBoundingBox")
	private Set<GeographicBoundingBoxName> geographicBoundingBoxNames;
	
	@OneToMany(mappedBy="geographicBoundingBox")
	private Set<GeographicBoundingBoxDescription> geographicBoundingBoxDescriptions;
	
	@OneToMany(mappedBy="geographicBoundingBox")
	private Set<GeographicBoundingBoxKeyword> geographicBoundingBoxKeywords;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="geographicBoundingBox")
	private Set<ResultProduct_GeographicBoundingBox> resultProducts_geographicBoundingBoxes;
	
	@OneToMany(mappedBy="geographicBoundingBox")
	private Set<PostalAddress_GeographicBoundingBox> postalAddresses_geographicBoundingBoxes;
	
	@OneToMany(mappedBy="geographicBoundingBox")
	private Set<GeographicBoundingBox_Class> geographicBoundingBoxes_classes;
	
	@OneToMany(mappedBy="geographicBoundingBox1")
	private Set<GeographicBoundingBox_GeographicBoundingBox> geographicBoundingBoxes_geographicBoundingBoxes1;
	
	@OneToMany(mappedBy="geographicBoundingBox2")
	private Set<GeographicBoundingBox_GeographicBoundingBox> geographicBoundingBoxes_geographicBoundingBoxes2;
	
	@OneToMany(mappedBy="geographicBoundingBox")
	private Set<GeographicBoundingBox_Measurement> geographicBoundingBoxes_measurements;

	
	/**
	 * FederatedIdentifier entities related to GeographicBoundingBox instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//

	/**
	 * Default Constructor
	 */
	public GeographicBoundingBox() {
		
	}
	
	/**
	 * 
	 * @param wBLong
	 * @param eBLong
	 * @param sBLat
	 * @param nBLat
	 * @param minElev
	 * @param maxElev
	 * @param uri
	 * @param resultProduct
	 * @param geographicBoundingBoxNames
	 * @param geographicBoundingBoxDescriptions
	 * @param geographicBoundingBoxKeywords
	 */
	public GeographicBoundingBox(
			String wBLong,
			String eBLong,
			String sBLat,
			String nBLat,
			String minElev,
			String maxElev,
			String uri,
			Set<ResultProduct_GeographicBoundingBox> resultProduct,
			Set<GeographicBoundingBoxName> geographicBoundingBoxNames,
			Set<GeographicBoundingBoxDescription> geographicBoundingBoxDescriptions,
			Set<GeographicBoundingBoxKeyword> geographicBoundingBoxKeywords) {
		WBLong = wBLong;
		EBLong = eBLong;
		SBLat = sBLat;
		NBLat = nBLat;
		MinElev = minElev;
		MaxElev = maxElev;
		this.uri = uri;
		this.resultProducts_geographicBoundingBoxes = resultProduct;
		this.geographicBoundingBoxNames = geographicBoundingBoxNames;
		this.geographicBoundingBoxDescriptions = geographicBoundingBoxDescriptions;
		this.geographicBoundingBoxKeywords = geographicBoundingBoxKeywords;
	}

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

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the resultProducts_geographicBoundingBoxes
	 */
	public Set<ResultProduct_GeographicBoundingBox> getResultProducts_geographicBoundingBoxes() {
		return resultProducts_geographicBoundingBoxes;
	}

	/**
	 * @param resultProducts_geographicBoundingBoxes the resultProducts_geographicBoundingBoxes to set
	 */
	public void setResultProducts_geographicBoundingBoxes(
			Set<ResultProduct_GeographicBoundingBox> resultProducts_geographicBoundingBoxes) {
		this.resultProducts_geographicBoundingBoxes = resultProducts_geographicBoundingBoxes;
	}

	/**
	 * @return the postalAddresses_geographicBoundingBoxes
	 */
	public Set<PostalAddress_GeographicBoundingBox> getPostalAddresses_geographicBoundingBoxes() {
		return postalAddresses_geographicBoundingBoxes;
	}

	/**
	 * @param postalAddresses_geographicBoundingBoxes the postalAddresses_geographicBoundingBoxes to set
	 */
	public void setPostalAddresses_geographicBoundingBoxes(
			Set<PostalAddress_GeographicBoundingBox> postalAddresses_geographicBoundingBoxes) {
		this.postalAddresses_geographicBoundingBoxes = postalAddresses_geographicBoundingBoxes;
	}

	/**
	 * @return the geographicBoundingBoxes_classes
	 */
	public Set<GeographicBoundingBox_Class> getGeographicBoundingBoxes_classes() {
		return geographicBoundingBoxes_classes;
	}

	/**
	 * @param geographicBoundingBoxes_classes the geographicBoundingBoxes_classes to set
	 */
	public void setGeographicBoundingBoxes_classes(
			Set<GeographicBoundingBox_Class> geographicBoundingBoxes_classes) {
		this.geographicBoundingBoxes_classes = geographicBoundingBoxes_classes;
	}

	/**
	 * @return the geographicBoundingBoxes_geographicBoundingBoxes1
	 */
	public Set<GeographicBoundingBox_GeographicBoundingBox> getGeographicBoundingBoxes_geographicBoundingBoxes1() {
		return geographicBoundingBoxes_geographicBoundingBoxes1;
	}

	/**
	 * @param geographicBoundingBoxes_geographicBoundingBoxes1 the geographicBoundingBoxes_geographicBoundingBoxes1 to set
	 */
	public void setGeographicBoundingBoxes_geographicBoundingBoxes1(
			Set<GeographicBoundingBox_GeographicBoundingBox> geographicBoundingBoxes_geographicBoundingBoxes1) {
		this.geographicBoundingBoxes_geographicBoundingBoxes1 = geographicBoundingBoxes_geographicBoundingBoxes1;
	}

	/**
	 * @return the geographicBoundingBoxes_geographicBoundingBoxes2
	 */
	public Set<GeographicBoundingBox_GeographicBoundingBox> getGeographicBoundingBoxes_geographicBoundingBoxes2() {
		return geographicBoundingBoxes_geographicBoundingBoxes2;
	}

	/**
	 * @param geographicBoundingBoxes_geographicBoundingBoxes2 the geographicBoundingBoxes_geographicBoundingBoxes2 to set
	 */
	public void setGeographicBoundingBoxes_geographicBoundingBoxes2(
			Set<GeographicBoundingBox_GeographicBoundingBox> geographicBoundingBoxes_geographicBoundingBoxes2) {
		this.geographicBoundingBoxes_geographicBoundingBoxes2 = geographicBoundingBoxes_geographicBoundingBoxes2;
	}
	
	/**
	 * Returns the geographicBoundingBoxes_measurements.
	 * @return the geographicBoundingBoxes_measurements.
	 */
	public Set<GeographicBoundingBox_Measurement> getGeographicBoundingBoxes_measurements() {
		return geographicBoundingBoxes_measurements;
	}

	/**
	 * Sets the geographicBoundingBoxes_measurements.
	 * @param geographicBoundingBoxes_measurements the geographicBoundingBoxes_measurements.
	 */
	public void setGeographicBoundingBoxes_measurements(Set<GeographicBoundingBox_Measurement> geographicBoundingBoxes_measurements) {
		this.geographicBoundingBoxes_measurements = geographicBoundingBoxes_measurements;
	}

	/**
	 * @return the federatedIdentifiers
	 */
	public List<FederatedIdentifier> getFederatedIdentifiers() {
		return federatedIdentifiers;
	}

	/**
	 * @param federatedIdentifiers the federatedIdentifiers to set
	 */
	public void setFederatedIdentifiers(
			List<FederatedIdentifier> federatedIdentifiers) {
		this.federatedIdentifiers = federatedIdentifiers;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GeographicBoundingBox [id=" + id + ", WBLong=" + WBLong
				+ ", EBLong=" + EBLong + ", SBLat=" + SBLat + ", NBLat="
				+ NBLat + ", MinElev=" + MinElev + ", MaxElev=" + MaxElev
				+ ", uri=" + uri + ", uuid=" + uuid + "]";
	}


}

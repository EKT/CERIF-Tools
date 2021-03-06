/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.Equipment_PostalAddress;
import gr.ekt.cerif.entities.link.Facility_PostalAddress;
import gr.ekt.cerif.entities.link.PostalAddress_Class;
import gr.ekt.cerif.entities.link.PostalAddress_GeographicBoundingBox;
import gr.ekt.cerif.entities.link.Service_PostalAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Represents a postal address second level entity.
 * 
 */
@Entity
@Table(name="cfPAddr")
public class PostalAddress implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 4033595261782306275L;

	/**
	 * The postal address unique identifier.
	 */
	@Id
	@Column(name="cfPAddrId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

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
	 * The country.
	 */
	@ManyToOne
	@JoinColumn(name="cfCountryCode", nullable=false)
	private Country country;

	/**
	 * The address line 1.
	 */
	@Column(name="cfAddrline1")
	private String addressLine1;
	
	/**
	 * The address line 2.
	 */
	@Column(name="cfAddrline2")
	private String addressLine2;
	
	/**
	 * The address line 3.
	 */
	@Column(name="cfAddrline3")
	private String addressLine3;
	
	/**
	 * The address line 4.
	 */
	@Column(name="cfAddrline4")
	private String addressLine4;
	
	/**
	 * The address line 5.
	 */
	@Column(name="cfAddrline5")
	private String addressLine5;
	
	/**
	 * The postal code.
	 */
	@Column(name="cfPostCode")
	private String postalCode;
	
	/**
	 * The city/town.
	 */
	@Column(name="cfCityTown")
	private String cityTown;
	
	/**
	 * The state.
	 */
	@Column(name="cfStateOfCountry")
	private String state;


	/**
	 * Links.
	 */
	@OneToMany(mappedBy="postalAddress")
	private Set<OrganisationUnit_PostalAddress> organisationUnits_postalAddresses;
	
	@OneToMany(mappedBy="postalAddress")
	private Set<Person_PostalAddress> persons_postalAddresses;
	
	@OneToMany(mappedBy="postalAddress")
	private Set<Service_PostalAddress> services_postalAddresses;
	
	@OneToMany(mappedBy="postalAddress")
	private Set<Facility_PostalAddress> facilities_postalAddresses;
	
	@OneToMany(mappedBy="postalAddress")
	private Set<Equipment_PostalAddress> equipments_postalAddresses;
	
	@OneToMany(mappedBy="postalAddress")
	private Set<PostalAddress_Class> postalAddresses_classes;
	
	@OneToMany(mappedBy="postalAddress")
	private Set<PostalAddress_GeographicBoundingBox> postalAddresses_geographicBoundingBoxes;
	
	
	/**
	 * FederatedIdentifier entities related to PostalAddress instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	// ---------------------------------------------------------------------- //
	
	/**
	 * Default Constructor
	 */
	public PostalAddress() {
		
	}
	/**
	 * 
	 * @param uri
	 * @param country
	 * @param addressLine1
	 * @param addressLine2
	 * @param addressLine3
	 * @param addressLine4
	 * @param addressLine5
	 * @param postalCode
	 * @param cityTown
	 * @param state
	 */
	public PostalAddress(String uri, Country country,
			String addressLine1, String addressLine2, String addressLine3,
			String addressLine4, String addressLine5, String postalCode,
			String cityTown, String state) {
		this.uri = uri;
		this.country = country;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.addressLine4 = addressLine4;
		this.addressLine5 = addressLine5;
		this.postalCode = postalCode;
		this.cityTown = cityTown;
		this.state = state;
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
	 * Returns the country.
	 * @return the country.
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 * @param country the country.
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * Returns the address line 1.
	 * @return the address line 1.
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * Sets the address line 1.
	 * @param addressLine1 the address line 1.
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * Returns the address line 2.
	 * @return the address line 2.
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * Sets the address line 2.
	 * @param addressLine2 the address line 2.
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * Returns the address line 3.
	 * @return the address line 3.
	 */
	public String getAddressLine3() {
		return addressLine3;
	}

	/**
	 * Sets the address line 3.
	 * @param addressLine3 the address line 3.
	 */
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	/**
	 * Returns the address line 4.
	 * @return the address line 4.
	 */
	public String getAddressLine4() {
		return addressLine4;
	}

	/**
	 * Sets the address line 4.
	 * @param addressLine4 the address line 4.
	 */
	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
	}

	/**
	 * Returns the address line 5.
	 * @return the address line 5.
	 */
	public String getAddressLine5() {
		return addressLine5;
	}

	/**
	 * Sets the address line 5.
	 * @param addressLine5 the address line 5.
	 */
	public void setAddressLine5(String addressLine5) {
		this.addressLine5 = addressLine5;
	}

	/**
	 * Returns the postal code.
	 * @return the postal code.
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Sets the postal code.
	 * @param postalCode the postal code.
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Returns the city/town.
	 * @return the city/town.
	 */
	public String getCityTown() {
		return cityTown;
	}

	/**
	 * Sets the city/town.
	 * @param cityTown the city/town.
	 */
	public void setCityTown(String cityTown) {
		this.cityTown = cityTown;
	}

	/**
	 * Returns the state.
	 * @return the state.
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 * @param state the state.
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the organisationUnits_postalAddresses
	 */
	public Set<OrganisationUnit_PostalAddress> getOrganisationUnits_postalAddresses() {
		return organisationUnits_postalAddresses;
	}
	/**
	 * @param organisationUnits_postalAddresses the organisationUnits_postalAddresses to set
	 */
	public void setOrganisationUnits_postalAddresses(
			Set<OrganisationUnit_PostalAddress> organisationUnits_postalAddresses) {
		this.organisationUnits_postalAddresses = organisationUnits_postalAddresses;
	}
	/**
	 * @return the persons_postalAddresses
	 */
	public Set<Person_PostalAddress> getPersons_postalAddresses() {
		return persons_postalAddresses;
	}
	
	/**
	 * @param persons_postalAddresses the persons_postalAddresses to set
	 */
	public void setPersons_postalAddresses(
			Set<Person_PostalAddress> persons_postalAddresses) {
		this.persons_postalAddresses = persons_postalAddresses;
	}
	
	/**
	 * @return the services_postalAddresses
	 */
	public Set<Service_PostalAddress> getServices_postalAddresses() {
		return services_postalAddresses;
	}
	
	/**
	 * @param services_postalAddresses the services_postalAddresses to set
	 */
	public void setServices_postalAddresses(
			Set<Service_PostalAddress> services_postalAddresses) {
		this.services_postalAddresses = services_postalAddresses;
	}
	
	/**
	 * @return the facilities_postalAddresses
	 */
	public Set<Facility_PostalAddress> getFacilities_postalAddresses() {
		return facilities_postalAddresses;
	}
	
	/**
	 * @param facilities_postalAddresses the facilities_postalAddresses to set
	 */
	public void setFacilities_postalAddresses(
			Set<Facility_PostalAddress> facilities_postalAddresses) {
		this.facilities_postalAddresses = facilities_postalAddresses;
	}
	
	/**
	 * @return the equipments_postalAddresses
	 */
	public Set<Equipment_PostalAddress> getEquipments_postalAddresses() {
		return equipments_postalAddresses;
	}
	
	/**
	 * @param equipments_postalAddresses the equipments_postalAddresses to set
	 */
	public void setEquipments_postalAddresses(
			Set<Equipment_PostalAddress> equipments_postalAddresses) {
		this.equipments_postalAddresses = equipments_postalAddresses;
	}
	
	/**
	 * @return the postalAddresses_classes
	 */
	public Set<PostalAddress_Class> getPostalAddresses_classes() {
		return postalAddresses_classes;
	}
	/**
	 * @param postalAddresses_classes the postalAddresses_classes to set
	 */
	public void setPostalAddresses_classes(
			Set<PostalAddress_Class> postalAddresses_classes) {
		this.postalAddresses_classes = postalAddresses_classes;
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
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostalAddress other = (PostalAddress) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PostalAddress [id=" + id + ", uri=" + uri + ", uuid=" + uuid
				+ ", country=" + country + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", addressLine3="
				+ addressLine3 + ", addressLine4=" + addressLine4
				+ ", addressLine5=" + addressLine5 + ", postalCode="
				+ postalCode + ", cityTown=" + cityTown + ", state=" + state
				+ "]";
	}

	
}

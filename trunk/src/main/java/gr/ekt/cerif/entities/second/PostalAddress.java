/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	 * The country.
	 */
	@ManyToOne(cascade=CascadeType.ALL)
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
	 * The organisation units.
	 */
	@OneToMany(mappedBy="postalAddress")
	private Set<OrganisationUnit_PostalAddress> organisationUnits;
	
	@OneToMany(mappedBy="postalAddress")
	private Set<Person_PostalAddress> persons_postalAddresses;
	
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
	 * @return the organisationUnits
	 */
	public Set<OrganisationUnit_PostalAddress> getOrganisationUnits() {
		return organisationUnits;
	}

	/**
	 * @param organisationUnits the organisationUnits to set
	 */
	public void setOrganisationUnits(
			Set<OrganisationUnit_PostalAddress> organisationUnits) {
		this.organisationUnits = organisationUnits;
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
	
}

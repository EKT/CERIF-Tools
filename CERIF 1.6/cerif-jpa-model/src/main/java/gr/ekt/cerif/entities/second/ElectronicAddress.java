/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.ElectronicAddress_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Represents an electronic address second level entity.
 * 
 */
@Entity
@Table(name="cfEAddr")
public class ElectronicAddress implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -8559572299989580503L;

	/**
	 * The electronic address unique identifier.
	 */
	@Id
	@Column(name="cfEAddrId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The postal address.
	 */
	@OneToOne
	@JoinColumn(name="cfPAddrId")
	private PostalAddress postalAddress;
	
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
	 * Links.
	 */
	@OneToMany(mappedBy="electronicAddress")
	private Set<OrganisationUnit_ElectronicAddress> organisationUnits_electronicAddresses;
	
	@OneToMany(mappedBy="electronicAddress")
	private Set<Person_ElectronicAddress> persons_electronicAddresses;
	
	@OneToMany(mappedBy="electronicAddress")
	private Set<ElectronicAddress_Class> electronicAddresses_classes;
	
	
	/**
	 * FederatedIdentifier entities related to ElectronicAddress instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//
	
	
	/**
	 * Default Constructor
	 */
	public ElectronicAddress() {
		
	}
	
	/**
	 * 
	 * @param postalAddress
	 * @param uri
	 */
	public ElectronicAddress(PostalAddress postalAddress, String uri) {
	this.postalAddress = postalAddress;
	this.uri = uri;	
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
	 * Returns the postal address.
	 * @return the postal address.
	 */
	public PostalAddress getPostalAddress() {
		return postalAddress;
	}

	/**
	 * Sets the postal address.
	 * @param postalAddress the postal address.
	 */
	public void setPostalAddress(PostalAddress postalAddress) {
		this.postalAddress = postalAddress;
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
	 * @return the persons_electronicAddresses
	 */
	public Set<Person_ElectronicAddress> getPersons_electronicAddresses() {
		return persons_electronicAddresses;
	}

	/**
	 * @param persons_electronicAddresses the persons_electronicAddresses to set
	 */
	public void setPersons_electronicAddresses(
			Set<Person_ElectronicAddress> persons_electronicAddresses) {
		this.persons_electronicAddresses = persons_electronicAddresses;
	}

	/**
	 * @return the organisationUnits_electronicAddresses
	 */
	public Set<OrganisationUnit_ElectronicAddress> getOrganisationUnits_electronicAddresses() {
		return organisationUnits_electronicAddresses;
	}

	/**
	 * @param organisationUnits_electronicAddresses the organisationUnits_electronicAddresses to set
	 */
	public void setOrganisationUnits_electronicAddresses(
			Set<OrganisationUnit_ElectronicAddress> organisationUnits_electronicAddresses) {
		this.organisationUnits_electronicAddresses = organisationUnits_electronicAddresses;
	}

	/**
	 * @return the electronicAddresses_classes
	 */
	public Set<ElectronicAddress_Class> getElectronicAddresses_classes() {
		return electronicAddresses_classes;
	}

	/**
	 * @param electronicAddresses_classes the electronicAddresses_classes to set
	 */
	public void setElectronicAddresses_classes(
			Set<ElectronicAddress_Class> electronicAddresses_classes) {
		this.electronicAddresses_classes = electronicAddresses_classes;
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
		ElectronicAddress other = (ElectronicAddress) obj;
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
		return "ElectronicAddress [id=" + id + ", postalAddress="
				+ postalAddress + ", uri=" + uri + ", uuid=" + uuid + "]";
	}


}

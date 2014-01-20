/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.ElectronicAddress_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;

import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Represents an electronic address second level entity.
 * 
 */
@Entity
@Table(name="cfEAddr")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ElectronicAddress implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -8559572299989580503L;

	/**
	 * The electronic address unique identifier.
	 */
	@Id
	@Column(name="cfEaddrId")
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
	 * The organisation units.
	 */
	@OneToMany(mappedBy="electronicAddress")
	private Set<OrganisationUnit_ElectronicAddress> organisationUnits;
	
	@OneToMany(mappedBy="electronicAddress")
	private Set<Person_ElectronicAddress> persons_electronicAddresses;
	
	@OneToMany(mappedBy="electronicAddress")
	private Set<ElectronicAddress_Class> classes;
	
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
	 * @return the organisationUnits
	 */
	public Set<OrganisationUnit_ElectronicAddress> getOrganisationUnits() {
		return organisationUnits;
	}

	/**
	 * @param organisationUnits the organisationUnits to set
	 */
	public void setOrganisationUnits(
			Set<OrganisationUnit_ElectronicAddress> organisationUnits) {
		this.organisationUnits = organisationUnits;
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
	 * @return the classes
	 */
	public Set<ElectronicAddress_Class> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(Set<ElectronicAddress_Class> classes) {
		this.classes = classes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElectronicAddress [id=" + id + ", postalAddress="
				+ postalAddress + ", uri=" + uri + "]";
	}
	
	
}

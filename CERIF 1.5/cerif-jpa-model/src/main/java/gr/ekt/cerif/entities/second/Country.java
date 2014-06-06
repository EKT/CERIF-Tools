/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.person.Person_Country;
import gr.ekt.cerif.entities.link.result.ResultProduct_Country;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.multilingual.CountryName;

import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Represents a country second level entity.
 * 
 */
@Entity
@Table(name="cfCountry")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Country implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 918224389382487329L;

	/**
	 * The country code.
	 */
	@Id
	@Column(name="cfCountryCode")
	private String code;

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
	@OneToMany(mappedBy="country")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<CountryName> names;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="country")
	private Set<ResultProduct_Country> resultProducts;
	
	@OneToMany(mappedBy="country")
	private Set<Event> events;
	
	@OneToMany(mappedBy="country")
	private Set<ResultPatent> patents;
	
	@OneToMany(mappedBy="country")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<PostalAddress> postalAddresses;
	
	@OneToMany(mappedBy="country")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<Person_Country> persons_countries;
	
	
	/**
	 * FederatedIdentifier entities related to Country instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//
	
	/**
	 * Default Constructor
	 */
	public Country(){
		
	}
	
	/**
	 * 
	 * @param code
	 * @param uri
	 */
	public Country(String code, String uri) {
		this.code = code;
		this.uri = uri;
	}

	/**
	 * Returns the code.
	 * @return the code.
	 */
	public String getCode() {
		return code;
	}
	
	public String getCodeLowercase() {
		return code.toLowerCase();
	}

	/**
	 * Sets the code.
	 * @param code the code.
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the resultProducts
	 */
	public Set<ResultProduct_Country> getResultProducts() {
		return resultProducts;
	}

	/**
	 * @param resultProducts the resultProducts to set
	 */
	public void setOrganisationUnits(
			Set<ResultProduct_Country> resultProducts) {
		this.resultProducts = resultProducts;
	}

	/**
	 * @return the events
	 */
	public Set<Event> getEvents() {
		return events;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	/**
	 * @return the patents
	 */
	public Set<ResultPatent> getPatents() {
		return patents;
	}

	/**
	 * @param patents the patents to set
	 */
	public void setPatents(Set<ResultPatent> patents) {
		this.patents = patents;
	}

	/**
	 * @return the postalAddresses
	 */
	public Set<PostalAddress> getPostalAddresses() {
		return postalAddresses;
	}

	/**
	 * @param postalAddresses the postalAddresses to set
	 */
	public void setPostalAddresses(Set<PostalAddress> postalAddresses) {
		this.postalAddresses = postalAddresses;
	}
	
	/**
	 * @return the persons_countries
	 */
	public Set<Person_Country> getPersons_countries() {
		return persons_countries;
	}
	
	/**
	 * @param persons_countries the persons_countries to set
	 */
	public void setPersons_countries(Set<Person_Country> persons_countries) {
		this.persons_countries = persons_countries;
	}

	/**
	 * @return the names
	 */
	public Set<CountryName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(Set<CountryName> names) {
		this.names = names;
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
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Country)) {
			return false;
		}
		Country other = (Country) obj;
		if (uri == null) {
			if (other.uri != null) {
				return false;
			}
		} else if (!uri.equals(other.uri)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Country [code=" + code + ", uri=" + uri + ", uuid=" + uuid
				+ "]";
	}

}

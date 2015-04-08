/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.Currency_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_Equipment;
import gr.ekt.cerif.entities.link.project.Project_Facility;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.features.multilingual.CurrencyEntityName;
import gr.ekt.cerif.features.multilingual.CurrencyName;

import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Represents a currency second level entity.
 * 
 */
@Entity
@Table(name="cfCurrency")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Currency implements CerifSecondLevelEntity {
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 87304389612480632L;

	/**
	 * The currency code.
	 */
	@Id
	@Column(name="cfCurrCode", length=5)
	private String code;

	@Column(name="cfNumCurrCode", length=3)
	private String numeric;
	
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
	@OneToMany(mappedBy="currency")
	private Set<CurrencyName> currencyNames;
	
	@OneToMany(mappedBy="currency")
	private Set<CurrencyEntityName> entityNames;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="currency")
	private Set<OrganisationUnit> organisationUnits;
	
	@OneToMany(mappedBy="currency")
	private Set<OrganisationUnit_ResultProduct> organisationUnits_ResultProducts;
	
	@OneToMany(mappedBy="currency")
	private Set<Funding> fundings;
	
	@OneToMany(mappedBy="currency")
	private Set<Project_Equipment> projects_equipments;
	
	@OneToMany(mappedBy="currency")
	private Set<Project_Facility> projects_facilities;
	
	@OneToMany(mappedBy="currency")
	private Set<Project_Service> projects_services;
	
	@OneToMany(mappedBy="currency")
	private Set<Project_Funding> projects_fundings;
	
	@OneToMany(mappedBy="currency")
	private Set<Currency_Class> currencies_classes;

	
	//----------------------------------------------------------------------------------------------//
	
	/**
	 * Default Constructor
	 */
	public Currency(){
		
	}
	
	/**
	 * Returns the code.
	 * @return the code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 * @param code the code.
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * @return the numeric
	 */
	public String getNumeric() {
		return numeric;
	}

	/**
	 * @param numeric the numeric to set
	 */
	public void setNumeric(String numeric) {
		this.numeric = numeric;
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
	 * @return the currencyNames
	 */
	public Set<CurrencyName> getCurrencyNames() {
		return currencyNames;
	}

	/**
	 * @param currencyNames the currencyNames to set
	 */
	public void setCurrencyNames(Set<CurrencyName> currencyNames) {
		this.currencyNames = currencyNames;
	}

	/**
	 * @return the organisationUnits
	 */
	public Set<OrganisationUnit> getOrganisationUnits() {
		return organisationUnits;
	}

	/**
	 * @param organisationUnits the organisationUnits to set
	 */
	public void setOrganisationUnits(Set<OrganisationUnit> organisationUnits) {
		this.organisationUnits = organisationUnits;
	}

	/**
	 * @return the organisationUnits_ResultProducts
	 */
	public Set<OrganisationUnit_ResultProduct> getOrganisationUnits_ResultProducts() {
		return organisationUnits_ResultProducts;
	}

	/**
	 * @param organisationUnits_ResultProducts the organisationUnits_ResultProducts to set
	 */
	public void setOrganisationUnits_ResultProducts(
			Set<OrganisationUnit_ResultProduct> organisationUnits_ResultProducts) {
		this.organisationUnits_ResultProducts = organisationUnits_ResultProducts;
	}

	/**
	 * @return the fundings
	 */
	public Set<Funding> getFundings() {
		return fundings;
	}

	/**
	 * @param fundings the fundings to set
	 */
	public void setFundings(Set<Funding> fundings) {
		this.fundings = fundings;
	}

	/**
	 * @return the projects_equipments
	 */
	public Set<Project_Equipment> getProjects_equipments() {
		return projects_equipments;
	}

	/**
	 * @param projects_equipments the projects_equipments to set
	 */
	public void setProjects_equipments(Set<Project_Equipment> projects_equipments) {
		this.projects_equipments = projects_equipments;
	}

	/**
	 * @return the projects_facilities
	 */
	public Set<Project_Facility> getProjects_facilities() {
		return projects_facilities;
	}

	/**
	 * @param projects_facilities the projects_facilities to set
	 */
	public void setProjects_facilities(Set<Project_Facility> projects_facilities) {
		this.projects_facilities = projects_facilities;
	}

	/**
	 * @return the projects_services
	 */
	public Set<Project_Service> getProjects_services() {
		return projects_services;
	}

	/**
	 * @param projects_services the projects_services to set
	 */
	public void setProjects_services(Set<Project_Service> projects_services) {
		this.projects_services = projects_services;
	}

	/**
	 * @return the projects_fundings
	 */
	public Set<Project_Funding> getProjects_fundings() {
		return projects_fundings;
	}

	/**
	 * @param projects_fundings the projects_fundings to set
	 */
	public void setProjects_fundings(Set<Project_Funding> projects_fundings) {
		this.projects_fundings = projects_fundings;
	}

	/**
	 * @return the entityNames
	 */
	public Set<CurrencyEntityName> getEntityNames() {
		return entityNames;
	}

	/**
	 * @param entityNames the entityNames to set
	 */
	public void setEntityNames(Set<CurrencyEntityName> entityNames) {
		this.entityNames = entityNames;
	}

	/**
	 * @return the currencies_classes
	 */
	public Set<Currency_Class> getCurrencies_classes() {
		return currencies_classes;
	}

	/**
	 * @param currencies_classes the currencies_classes to set
	 */
	public void setCurrencies_classes(Set<Currency_Class> currencies_classes) {
		this.currencies_classes = currencies_classes;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Currency other = (Currency) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Currency [code=" + code + ", numeric=" + numeric + ", uri="
				+ uri + ", uuid=" + uuid + "]";
	}


	
}

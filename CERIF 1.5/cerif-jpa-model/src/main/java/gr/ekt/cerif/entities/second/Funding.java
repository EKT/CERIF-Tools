/**
 * 
 */
package gr.ekt.cerif.entities.second;


import gr.ekt.cerif.entities.link.Equipment_Funding;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.entities.link.Funding_Funding;
import gr.ekt.cerif.entities.link.Medium_Funding;
import gr.ekt.cerif.entities.link.Service_Funding;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Funding;
import gr.ekt.cerif.entities.link.person.Person_Funding;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.link.result.ResultPatent_Funding;
import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;
import gr.ekt.cerif.entities.link.result.ResultPublication_Funding;
import gr.ekt.cerif.features.multilingual.FundingDescription;
import gr.ekt.cerif.features.multilingual.FundingKeyword;
import gr.ekt.cerif.features.multilingual.FundingName;

import java.util.Date;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Represents an funding second level entity.
 * 
 */
@Entity
@Table(name="cfFund")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Funding implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -4656355686071155891L;
	

	/**
	 * The funding unique identifier.
	 */
	@Id
	@Column(name="cfFundId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The currency code.
	 */
	@ManyToOne
	@JoinColumn(name="cfCurrCode")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Currency currency;
	
	/**
	 * The start date.
	 */
	@Column (name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@Column (name="cfEndDate")
	private Date endDate;
	
	/**
	 * The acronym.
	 */
	@Column(name="cfAcro")
	private String acronym;
	
	/**
	 * The amount.
	 */
	@Column(name="cfAmount")
	private Double amount;
	
	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	/**
	 * The link entities of projects and fundings.
	 */
	@OneToMany(mappedBy="funding")
	private Set<Project_Funding> projects_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<OrganisationUnit_Funding> organisationUnits_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<FundingName> names;
	
	@OneToMany(mappedBy="funding")
	private Set<FundingKeyword> keywords;
	
	@OneToMany(mappedBy="funding")
	private Set<FundingDescription> descriptions;

	@OneToMany(mappedBy="funding")
	private Set<Person_Funding> persons_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<ResultPatent_Funding> resultPatents_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<ResultProduct_Funding> resultProducts_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<ResultPublication_Funding> resultPublications_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<Funding_Class> classes;
	
	@OneToMany(mappedBy="funding")
	private Set<Facility_Funding> facilities_fundings;
	
	@OneToMany(mappedBy="funding1")
	private Set<Funding_Funding> funding1_fundings;

	@OneToMany(mappedBy="funding2")
	private Set<Funding_Funding> funding2_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<Service_Funding> services_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<Equipment_Funding> equipments_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<Medium_Funding> mediums_fundings;
	
	/**
	 * Default Constructor
	 */
	public Funding() {
		
	}
	/**
	 * 
	 * @param currency
	 * @param startDate
	 * @param endDate
	 * @param acronym
	 * @param amount
	 * @param uri
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public Funding(Currency currency, Date startDate, Date endDate,
			String acronym, Double amount, String uri, Set<FundingName> names,
			Set<FundingKeyword> keywords, Set<FundingDescription> descriptions) {
		this.currency = currency;
		this.startDate = startDate;
		this.endDate = endDate;
		this.acronym = acronym;
		this.amount = amount;
		this.uri = uri;
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
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the acronym
	 */
	public String getAcronym() {
		return acronym;
	}

	/**
	 * @param acronym the acronym to set
	 */
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
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
	 * @return the organisationUnits_fundings
	 */
	public Set<OrganisationUnit_Funding> getOrganisationUnits_fundings() {
		return organisationUnits_fundings;
	}
	/**
	 * @param organisationUnits_fundings the organisationUnits_fundings to set
	 */
	public void setOrganisationUnits_fundings(
			Set<OrganisationUnit_Funding> organisationUnits_fundings) {
		this.organisationUnits_fundings = organisationUnits_fundings;
	}
	/**
	 * @return the names
	 */
	public Set<FundingName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(Set<FundingName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public Set<FundingKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(Set<FundingKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public Set<FundingDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(Set<FundingDescription> descriptions) {
		this.descriptions = descriptions;
	}
	
	/**
	 * @return the persons_fundings
	 */
	public Set<Person_Funding> getPersons_fundings() {
		return persons_fundings;
	}
	/**
	 * @param persons_fundings the persons_fundings to set
	 */
	public void setPersons_fundings(Set<Person_Funding> persons_fundings) {
		this.persons_fundings = persons_fundings;
	}
	/**
	 * @return the resultPatents_fundings
	 */
	public Set<ResultPatent_Funding> getResultPatents_fundings() {
		return resultPatents_fundings;
	}
	
	/**
	 * @param resultPatents_fundings the resultPatents_fundings to set
	 */
	public void setResultPatents_fundings(
			Set<ResultPatent_Funding> resultPatents_fundings) {
		this.resultPatents_fundings = resultPatents_fundings;
	}
	
	/**
	 * @return the resultPublications_fundings
	 */
	public Set<ResultPublication_Funding> getResultPublications_fundings() {
		return resultPublications_fundings;
	}
	/**
	 * @param resultPublications_fundings the resultPublications_fundings to set
	 */
	public void setResultPublications_fundings(
			Set<ResultPublication_Funding> resultPublications_fundings) {
		this.resultPublications_fundings = resultPublications_fundings;
	}
	/**
	 * @return the resultProducts_fundings
	 */
	public Set<ResultProduct_Funding> getResultProducts_fundings() {
		return resultProducts_fundings;
	}
	
	/**
	 * @param resultProducts_fundings the resultProducts_fundings to set
	 */
	public void setResultProducts_fundings(
			Set<ResultProduct_Funding> resultProducts_fundings) {
		this.resultProducts_fundings = resultProducts_fundings;
	}
	
	/**
	 * @return the classes
	 */
	public Set<Funding_Class> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(Set<Funding_Class> classes) {
		this.classes = classes;
	}

	/**
	 * @return the facilities_fundings
	 */
	public Set<Facility_Funding> getFacilities_fundings() {
		return facilities_fundings;
	}
	/**
	 * @param facilities_fundings the facilities_fundings to set
	 */
	public void setFacilities_fundings(Set<Facility_Funding> facilities_fundings) {
		this.facilities_fundings = facilities_fundings;
	}
	/**
	 * @return the funding1_fundings
	 */
	public Set<Funding_Funding> getFunding1_fundings() {
		return funding1_fundings;
	}
	
	/**
	 * @param funding1_fundings the funding1_fundings to set
	 */
	public void setFunding1_fundings(Set<Funding_Funding> funding1_fundings) {
		this.funding1_fundings = funding1_fundings;
	}
	
	/**
	 * @return the funding2_fundings
	 */
	public Set<Funding_Funding> getFunding2_fundings() {
		return funding2_fundings;
	}
	
	/**
	 * @param funding2_fundings the funding2_fundings to set
	 */
	public void setFunding2_fundings(Set<Funding_Funding> funding2_fundings) {
		this.funding2_fundings = funding2_fundings;
	}
	/**
	 * @return the services_fundings
	 */
	public Set<Service_Funding> getServices_fundings() {
		return services_fundings;
	}
	/**
	 * @param services_fundings the services_fundings to set
	 */
	public void setServices_fundings(Set<Service_Funding> services_fundings) {
		this.services_fundings = services_fundings;
	}
	
	/**
	 * @return the equipments_fundings
	 */
	public Set<Equipment_Funding> getEquipments_fundings() {
		return equipments_fundings;
	}
	/**
	 * @param equipments_fundings the equipments_fundings to set
	 */
	public void setEquipments_fundings(Set<Equipment_Funding> equipments_fundings) {
		this.equipments_fundings = equipments_fundings;
	}
	/**
	 * @return the mediums_fundings
	 */
	public Set<Medium_Funding> getMediums_fundings() {
		return mediums_fundings;
	}
	/**
	 * @param mediums_fundings the mediums_fundings to set
	 */
	public void setMediums_fundings(Set<Medium_Funding> mediums_fundings) {
		this.mediums_fundings = mediums_fundings;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Funding [id=" + id + ", currency=" + currency + ", startDate="
				+ startDate + ", endDate=" + endDate + ", acronym=" + acronym
				+ ", amount=" + amount + ", uri=" + uri + "]";
	}
	
	
}

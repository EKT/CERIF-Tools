/**
 * 
 */
package gr.ekt.cerif.entities.second;


import gr.ekt.cerif.entities.link.Equipment_Funding;
import gr.ekt.cerif.entities.link.Event_Funding;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.entities.link.Funding_Funding;
import gr.ekt.cerif.entities.link.Funding_Indicator;
import gr.ekt.cerif.entities.link.Funding_Measurement;
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
import java.util.List;
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
import javax.persistence.Transient;

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
	 * The UUID.
	 */
	@Column(name="cfUUID")
	private String uuid;
	
	
	/**
	 * Multilingual.
	 */
	@OneToMany(mappedBy="funding")
	private Set<FundingName> fundingNames;
	
	@OneToMany(mappedBy="funding")
	private Set<FundingKeyword> fundingKeywords;
	
	@OneToMany(mappedBy="funding")
	private Set<FundingDescription> fundingDescriptions;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="funding")
	private Set<Project_Funding> projects_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<OrganisationUnit_Funding> organisationUnits_fundings;

	@OneToMany(mappedBy="funding")
	private Set<Person_Funding> persons_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<ResultPatent_Funding> resultPatents_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<ResultProduct_Funding> resultProducts_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<ResultPublication_Funding> resultPublications_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<Funding_Class> fundings_classes;
	
	@OneToMany(mappedBy="funding")
	private Set<Facility_Funding> facilities_fundings;
	
	@OneToMany(mappedBy="funding1")
	private Set<Funding_Funding> fundings_fundings1;

	@OneToMany(mappedBy="funding2")
	private Set<Funding_Funding> fundings_fundings2;
	
	@OneToMany(mappedBy="funding")
	private Set<Service_Funding> services_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<Equipment_Funding> equipments_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<Medium_Funding> mediums_fundings;
	
	@OneToMany(mappedBy="funding")
	private Set<Funding_Indicator> fundings_indicators;
	
	@OneToMany(mappedBy="funding")
	private Set<Funding_Measurement> fundings_measurements;
	
	@OneToMany(mappedBy="funding")
	private Set<Event_Funding> events_fundings;
	
	
	/**
	 * FederatedIdentifier entities related to Funding instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	// ---------------------------------------------------------------------- //
	
	
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
			String acronym, Double amount, String uri, Set<FundingName> fundingNames,
			Set<FundingKeyword> keywords, Set<FundingDescription> descriptions) {
		this.currency = currency;
		this.startDate = startDate;
		this.endDate = endDate;
		this.acronym = acronym;
		this.amount = amount;
		this.uri = uri;
		this.fundingNames = fundingNames;
		this.fundingKeywords = keywords;
		this.fundingDescriptions = descriptions;
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
	 * @return the fundingNames
	 */
	public Set<FundingName> getFundingNames() {
		return fundingNames;
	}
	
	/**
	 * @param fundingNames the fundingNames to set
	 */
	public void setFundingNames(Set<FundingName> fundingNames) {
		this.fundingNames = fundingNames;
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
	 * @return the fundingKeywords
	 */
	public Set<FundingKeyword> getFundingKeywords() {
		return fundingKeywords;
	}
	
	/**
	 * @param fundingKeywords the fundingKeywords to set
	 */
	public void setFundingKeywords(Set<FundingKeyword> fundingKeywords) {
		this.fundingKeywords = fundingKeywords;
	}
	
	/**
	 * @return the fundingDescriptions
	 */
	public Set<FundingDescription> getFundingDescriptions() {
		return fundingDescriptions;
	}
	
	/**
	 * @param fundingDescriptions the fundingDescriptions to set
	 */
	public void setFundingDescriptions(Set<FundingDescription> fundingDescriptions) {
		this.fundingDescriptions = fundingDescriptions;
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
	
	/**
	 * @return the fundings_indicators
	 */
	public Set<Funding_Indicator> getFundings_indicators() {
		return fundings_indicators;
	}
	/**
	 * @param fundings_indicators the fundings_indicators to set
	 */
	public void setFundings_indicators(Set<Funding_Indicator> fundings_indicators) {
		this.fundings_indicators = fundings_indicators;
	}
	
	/**
	 * @return the fundings_fundings1
	 */
	public Set<Funding_Funding> getFundings_fundings1() {
		return fundings_fundings1;
	}
	
	/**
	 * @param fundings_fundings1 the fundings_fundings1 to set
	 */
	public void setFundings_fundings1(Set<Funding_Funding> fundings_fundings1) {
		this.fundings_fundings1 = fundings_fundings1;
	}

	/**
	 * @return the fundings_classes
	 */
	public Set<Funding_Class> getFundings_classes() {
		return fundings_classes;
	}
	/**
	 * @param fundings_classes the fundings_classes to set
	 */
	public void setFundings_classes(Set<Funding_Class> fundings_classes) {
		this.fundings_classes = fundings_classes;
	}
	/**
	 * @return the fundings_fundings2
	 */
	public Set<Funding_Funding> getFundings_fundings2() {
		return fundings_fundings2;
	}
	/**
	 * @param fundings_fundings2 the fundings_fundings2 to set
	 */
	public void setFundings_fundings2(Set<Funding_Funding> fundings_fundings2) {
		this.fundings_fundings2 = fundings_fundings2;
	}
	/**
	 * @return the events_fundings
	 */
	public Set<Event_Funding> getEvents_fundings() {
		return events_fundings;
	}
	/**
	 * @param events_fundings the events_fundings to set
	 */
	public void setEvents_fundings(Set<Event_Funding> events_fundings) {
		this.events_fundings = events_fundings;
	}
	/**
	 * @return the fundings_measurements
	 */
	public Set<Funding_Measurement> getFundings_measurements() {
		return fundings_measurements;
	}
	/**
	 * @param fundings_measurements the fundings_measurements to set
	 */
	public void setFundings_measurements(
			Set<Funding_Measurement> fundings_measurements) {
		this.fundings_measurements = fundings_measurements;
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
		Funding other = (Funding) obj;
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
		return "Funding [id=" + id + ", currency=" + currency + ", startDate="
				+ startDate + ", endDate=" + endDate + ", acronym=" + acronym
				+ ", amount=" + amount + ", uri=" + uri + "]";
	}
	
	
}

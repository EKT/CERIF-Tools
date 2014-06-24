/**
 * 
 */
package gr.ekt.cerif.entities.base;


import gr.ekt.cerif.entities.link.ClassScheme_OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Equipment;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Event;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ExpertiseAndSkills;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Funding;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Indicator;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Measurement;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Medium;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Prize;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Service;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.OrganisationUnitKeyword;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitResearchActivity;

import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
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
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.springframework.util.StringUtils;

/**
 * Represents an organization unit base entity.
 */
@Entity
@Table(name="cfOrgUnit")
@Indexed(index="indexes/organisationUnits")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class OrganisationUnit implements CerifBaseEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 4703858171074790007L;

	/**
	 * The organisation unique identifier.
	 */
	@Id
	@Column(name="cfOrgUnitId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The currency code.
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cfCurrCode")
	private Currency currency;
	
	/**
	 * The acronym.
	 */
	@Column(name="cfAcro")
	@Field(name="organisationUnitAcronym", index=Index.YES, store=Store.YES)
	private String acronym;

	/**
	 * The count of working staff.
	 */
	@Column(name="cfHeadcount")
	private Integer headCount;
	
	/**
	 * The number of times an asset is replaced during a financial period.
	 */
	@Column(name="cfTurn")
	private Double turn;

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
	@OneToMany(mappedBy="organisationUnit")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<OrganisationUnitName> organisationUnitNames;
	
	@OneToMany(mappedBy="organisationUnit")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<OrganisationUnitResearchActivity> organisationUnitResearchActivities;
	
	@OneToMany(mappedBy="organisationUnit")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<OrganisationUnitKeyword> organisationUnitKeywords;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_ResultProduct> organisationUnits_resultProducts;
	
	@OneToMany(mappedBy="organisationUnit")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<OrganisationUnit_ResultPublication> organisationUnits_resultPublications;

	@OneToMany(mappedBy="organisationUnit")
	private Set<Project_OrganisationUnit> projects;
	
	@OneToMany(mappedBy="organisationUnit")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<OrganisationUnit_PostalAddress> organisationUnits_postalAddresses;
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_ElectronicAddress> organisationUnits_electronicAddresses;	
	
	@OneToMany(mappedBy="organisationUnit1")
	private Set<OrganisationUnit_OrganisationUnit> organisationUnits_organisationUnits1;
	
	@OneToMany(mappedBy="organisationUnit2")
	private Set<OrganisationUnit_OrganisationUnit> organisationUnits_organisationUnits2;	
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<Person_OrganisationUnit> persons_organisationUnits;
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_Facility> organisationUnits_facilities;
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_Funding> organisationUnits_fundings;
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_Equipment> organisationUnits_equipments;
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_Class> classes;
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_Service> organisationUnits_services;
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_Medium> organisationUnits_mediums;
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<ClassScheme_OrganisationUnit> classScheme_organisationUnits;
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_ExpertiseAndSkills> organisationUnits_expertiseAndSkills;
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_Indicator> organisationUnits_indicators;
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_Prize> organisationUnits_prizes;
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_Measurement> organisationUnits_measurements;
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_Event> organisationUnits_events;

	
	/**
	 * FederatedIdentifier entities related to OrganisationUnit instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//
	
	/**
	 * Default Constructor
	 */
	public OrganisationUnit(){
		
	}
	
	/**
	 * Constructor
	 * @param id
	 * @param currency
	 * @param acronym
	 * @param headCount
	 * @param turn
	 * @param uri
	 * @param organisationUnitNames
	 * @param organisationUnitResearchActivities
	 * @param organisationUnitKeywords
	 */
	public OrganisationUnit(
			Long id,
			Currency currency,
			String acronym,
			Integer headCount,
			Double turn,
			String uri,
			Set<OrganisationUnitName> organisationUnitNames,
			Set<OrganisationUnitResearchActivity> organisationUnitResearchActivities,
			Set<OrganisationUnitKeyword> organisationUnitKeywords) {
		this.id = id;
		this.currency = currency;
		this.acronym = acronym;
		this.headCount = headCount;
		this.turn = turn;
		this.uri = uri;
		this.organisationUnitNames = organisationUnitNames;
		this.organisationUnitResearchActivities = organisationUnitResearchActivities;
		this.organisationUnitKeywords = organisationUnitKeywords;
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
	 * Returns the currency.
	 * @return the currency.
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 * @param currency the currency.
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	/**
	 * Returns the acronym.
	 * @return the acronym.
	 */
	public String getAcronym() {
		return acronym;
	}

	/**
	 * Sets the acronym.
	 * @param acronym the acronym.
	 */
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	/**
	 * Returns the count of working staff.
	 * @return the count of working staff.
	 */
	public Integer getHeadCount() {
		return headCount;
	}

	/**
	 * Sets the count of working staff.
	 * @param headCount the count of working staff.
	 */
	public void setHeadCount(Integer headCount) {
		this.headCount = headCount;
	}

	/**
	 * Returns the number of times an asset is replaced during a financial period.
	 * @return the number of times an asset is replaced during a financial period.
	 */
	public Double getTurn() {
		return turn;
	}

	/**
	 * Sets the number of times an asset is replaced during a financial period.
	 * @param turn the number of times an asset is replaced during a financial period.
	 */
	public void setTurn(Double turn) {
		this.turn = turn;
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
	 * @return the organisationUnits_resultProducts
	 */
	public Set<OrganisationUnit_ResultProduct> getOrganisationUnits_resultProducts() {
		return organisationUnits_resultProducts;
	}

	/**
	 * @param organisationUnits_resultProducts the organisationUnits_resultProducts to set
	 */
	public void setOrganisationUnits_resultProducts(
			Set<OrganisationUnit_ResultProduct> organisationUnits_resultProducts) {
		this.organisationUnits_resultProducts = organisationUnits_resultProducts;
	}

	/**
	 * @return the organisationUnits_resultPublications
	 */
	public Set<OrganisationUnit_ResultPublication> getOrganisationUnits_resultPublications() {
		return organisationUnits_resultPublications;
	}

	/**
	 * @param organisationUnits_resultPublications the organisationUnits_resultPublications to set
	 */
	public void setOrganisationUnits_resultPublications(
			Set<OrganisationUnit_ResultPublication> organisationUnits_resultPublications) {
		this.organisationUnits_resultPublications = organisationUnits_resultPublications;
	}

	/**
	 * Returns the projects.
	 * @return the projects.
	 */
	public Set<Project_OrganisationUnit> getProjects() {
		return projects;
	}

	/**
	 * Sets the projects.
	 * @param projects the projects.
	 */
	public void setProjects(Set<Project_OrganisationUnit> projects) {
		this.projects = projects;
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
	 * @return the organisationUnits_organisationUnits1
	 */
	public Set<OrganisationUnit_OrganisationUnit> getOrganisationUnits_organisationUnits1() {
		return organisationUnits_organisationUnits1;
	}

	/**
	 * @param organisationUnits_organisationUnits1 the organisationUnits_organisationUnits1 to set
	 */
	public void setOrganisationUnits_organisationUnits1(
			Set<OrganisationUnit_OrganisationUnit> organisationUnits_organisationUnits1) {
		this.organisationUnits_organisationUnits1 = organisationUnits_organisationUnits1;
	}

	/**
	 * @return the organisationUnits_organisationUnits2
	 */
	public Set<OrganisationUnit_OrganisationUnit> getOrganisationUnits_organisationUnits2() {
		return organisationUnits_organisationUnits2;
	}

	/**
	 * @param organisationUnits_organisationUnits2 the organisationUnits_organisationUnits2 to set
	 */
	public void setOrganisationUnits_organisationUnits2(
			Set<OrganisationUnit_OrganisationUnit> organisationUnits_organisationUnits2) {
		this.organisationUnits_organisationUnits2 = organisationUnits_organisationUnits2;
	}

	/**
	 * Returns the organisation names.
	 * @return the organisation names.
	 */
	public Set<OrganisationUnitName> getOrganisationUnitNames() {
		return organisationUnitNames;
	}

	/**
	 * Sets the organisation names.
	 * @param organisationUnitNames the organisation names.
	 */
	public void setOrganisationUnitNames(Set<OrganisationUnitName> organisationUnitNames) {
		this.organisationUnitNames = organisationUnitNames;
	}
	
	/**
	 * @return the persons_organisationUnits
	 */
	public Set<Person_OrganisationUnit> getPersons_organisationUnits() {
		return persons_organisationUnits;
	}
	
	/**
	 * @param persons_organisationUnits the persons_organisationUnits to set
	 */
	public void setPersons_organisationUnits(
			Set<Person_OrganisationUnit> persons_organisationUnits) {
		this.persons_organisationUnits = persons_organisationUnits;
	}
	
	/**
	 * Returns the organisation Research Activities.
	 * @return the organisation Research Activities.
	 */
	public Set<OrganisationUnitResearchActivity> getOrganisationUnitResearchActivities() {
		return organisationUnitResearchActivities;
	}

	/**
	 * Sets the organisation  Research Activities.
	 * @param organisationUnitResearchActivities the organisation  Research Activities.
	 */
	public void setOrganisationUnitResearchActivities(Set<OrganisationUnitResearchActivity> organisationUnitResearchActivities) {
		this.organisationUnitResearchActivities = organisationUnitResearchActivities;
	}
	
	/**
	 * Returns the organisation Keywords.
	 * @return the organisation Keywords.
	 */
	public Set<OrganisationUnitKeyword> getOrganisationUnitKeywords() {
		return organisationUnitKeywords;
	}

	/**
	 * Sets the organisation Keywords.
	 * @param organisationUnitResearchActivities the organisation Keywords.
	 */
	public void setOrganisationUnitKeywords(Set<OrganisationUnitKeyword> organisationUnitKeywords) {
		this.organisationUnitKeywords = organisationUnitKeywords;
	}
	
	public Set<OrganisationUnit_Facility> getOrganisationUnits_facilities() {
		return organisationUnits_facilities;
	}

	public void setOrganisationUnits_facilities(
			Set<OrganisationUnit_Facility> organisationUnits_facilities) {
		this.organisationUnits_facilities = organisationUnits_facilities;
	}

	public Set<OrganisationUnit_Funding> getOrganisationUnits_fundings() {
		return organisationUnits_fundings;
	}

	public void setOrganisationUnits_fundings(
			Set<OrganisationUnit_Funding> organisationUnits_fundings) {
		this.organisationUnits_fundings = organisationUnits_fundings;
	}

	/**
	 * @return the organisationUnits_equipments
	 */
	public Set<OrganisationUnit_Equipment> getOrganisationUnits_equipments() {
		return organisationUnits_equipments;
	}

	/**
	 * @param organisationUnits_equipments the organisationUnits_equipments to set
	 */
	public void setOrganisationUnits_equipments(
			Set<OrganisationUnit_Equipment> organisationUnits_equipments) {
		this.organisationUnits_equipments = organisationUnits_equipments;
	}

	/**
	 * @return the classes
	 */
	public Set<OrganisationUnit_Class> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(Set<OrganisationUnit_Class> classes) {
		this.classes = classes;
	}

	/**
	 * @return the organisationUnits_services
	 */
	public Set<OrganisationUnit_Service> getOrganisationUnits_services() {
		return organisationUnits_services;
	}

	/**
	 * @param organisationUnits_services the organisationUnits_services to set
	 */
	public void setOrganisationUnits_services(
			Set<OrganisationUnit_Service> organisationUnits_services) {
		this.organisationUnits_services = organisationUnits_services;
	}

	/**
	 * @return the organisationUnits_mediums
	 */
	public Set<OrganisationUnit_Medium> getOrganisationUnits_mediums() {
		return organisationUnits_mediums;
	}

	/**
	 * @param organisationUnits_mediums the organisationUnits_mediums to set
	 */
	public void setOrganisationUnits_mediums(
			Set<OrganisationUnit_Medium> organisationUnits_mediums) {
		this.organisationUnits_mediums = organisationUnits_mediums;
	}

	/**
	 * @return the classScheme_organisationUnits
	 */
	public Set<ClassScheme_OrganisationUnit> getClassScheme_organisationUnits() {
		return classScheme_organisationUnits;
	}

	/**
	 * @param classScheme_organisationUnits the classScheme_organisationUnits to set
	 */
	public void setClassScheme_organisationUnits(
			Set<ClassScheme_OrganisationUnit> classScheme_organisationUnits) {
		this.classScheme_organisationUnits = classScheme_organisationUnits;
	}

	/**
	 * @return the organisationUnits_expertiseAndSkills
	 */
	public Set<OrganisationUnit_ExpertiseAndSkills> getOrganisationUnits_expertiseAndSkills() {
		return organisationUnits_expertiseAndSkills;
	}

	/**
	 * @param organisationUnits_expertiseAndSkills the organisationUnits_expertiseAndSkills to set
	 */
	public void setOrganisationUnits_expertiseAndSkills(
			Set<OrganisationUnit_ExpertiseAndSkills> organisationUnits_expertiseAndSkills) {
		this.organisationUnits_expertiseAndSkills = organisationUnits_expertiseAndSkills;
	}

	/**
	 * @return the organisationUnits_indicators
	 */
	public Set<OrganisationUnit_Indicator> getOrganisationUnits_indicators() {
		return organisationUnits_indicators;
	}

	/**
	 * @param organisationUnits_indicators the organisationUnits_indicators to set
	 */
	public void setOrganisationUnits_indicators(
			Set<OrganisationUnit_Indicator> organisationUnits_indicators) {
		this.organisationUnits_indicators = organisationUnits_indicators;
	}

	/**
	 * @return the organisationUnits_prizes
	 */
	public Set<OrganisationUnit_Prize> getOrganisationUnits_prizes() {
		return organisationUnits_prizes;
	}

	/**
	 * @param organisationUnits_prizes the organisationUnits_prizes to set
	 */
	public void setOrganisationUnits_prizes(
			Set<OrganisationUnit_Prize> organisationUnits_prizes) {
		this.organisationUnits_prizes = organisationUnits_prizes;
	}

	/**
	 * @return the organisationUnits_measurements
	 */
	public Set<OrganisationUnit_Measurement> getOrganisationUnits_measurements() {
		return organisationUnits_measurements;
	}

	/**
	 * @param organisationUnits_measurements the organisationUnits_measurements to set
	 */
	public void setOrganisationUnits_measurements(
			Set<OrganisationUnit_Measurement> organisationUnits_measurements) {
		this.organisationUnits_measurements = organisationUnits_measurements;
	}

	/**
	 * @return the organisationUnits_events
	 */
	public Set<OrganisationUnit_Event> getOrganisationUnits_events() {
		return organisationUnits_events;
	}

	/**
	 * @param organisationUnits_events the organisationUnits_events to set
	 */
	public void setOrganisationUnits_events(
			Set<OrganisationUnit_Event> organisationUnits_events) {
		this.organisationUnits_events = organisationUnits_events;
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
		result = prime * result + ((acronym == null) ? 0 : acronym.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
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
		if (!(obj instanceof OrganisationUnit)) {
			return false;
		}
		
		OrganisationUnit other = (OrganisationUnit) obj;
		
		if (id != null && other.id != null) { //check only the ids
			if (id.equals(other.id)) {
				return true;
			} else {
				return false;
			}
		} else { //both or one of them are new objects and checks should be done based on other data
			if (uri == null) {
				if (other.uri == null) {
					if (acronym == null) {
						return false;
					} else {
						if (acronym.equals(other.acronym)) {
							return true;
						} else {
							return false;
						}
					}
				} else {
					return false;
				}
			} else {
				if (other.uri == null) {
					return false;
				} else {
					if (uri.equals(other.uri)) {
						if (acronym == null) {
							if (other.acronym == null) {
								return true;
							} else {
								return false;
							}
						} else {
							if (acronym.equals(other.acronym)) {
								return true;
							} else {
								return false;
							}
						}
					} else {
						return false;
					}
				}
			}
		}

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrganisationUnit [id=" + id + ", currency=" + currency
				+ ", acronym=" + acronym + ", headCount=" + headCount
				+ ", turn=" + turn + ", uri=" + uri + ", uuid=" + uuid + "]";
	}


	
}

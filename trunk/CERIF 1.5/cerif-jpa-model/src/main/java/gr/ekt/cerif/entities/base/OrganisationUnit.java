/**
 * 
 */
package gr.ekt.cerif.entities.base;


import gr.ekt.cerif.entities.link.ClassScheme_OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Equipment;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Funding;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Medium;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
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
	private Set<OrganisationUnit_ResultProduct> resultProducts;
	
	@OneToMany(mappedBy="organisationUnit")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<OrganisationUnit_ResultPublication> resultPublications;

	@OneToMany(mappedBy="organisationUnit")
	private Set<Project_OrganisationUnit> projects;
	
	@OneToMany(mappedBy="organisationUnit")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<OrganisationUnit_PostalAddress> postalAddresses;
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_ElectronicAddress> electronicAddresses;	
	
	@OneToMany(mappedBy="organisationUnit1")
	private Set<OrganisationUnit_OrganisationUnit> organisationUnits1;
	
	@OneToMany(mappedBy="organisationUnit2")
	private Set<OrganisationUnit_OrganisationUnit> organisationUnits2;	
	
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
	private Set<OrganisationUnit_Medium> organisationUnits_medium;
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<ClassScheme_OrganisationUnit> classScheme_organisationUnits;

	
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
	 * Returns the result products.
	 * @return the result products.
	 */
	public Set<OrganisationUnit_ResultProduct> getResultProducts() {
		return resultProducts;
	}

	/**
	 * Sets the result products.
	 * @param resultProducts the result products.
	 */
	public void setResultProducts(Set<OrganisationUnit_ResultProduct> resultProducts) {
		this.resultProducts = resultProducts;
	}

	/**
	 * @return the resultPublications
	 */
	public Set<OrganisationUnit_ResultPublication> getResultPublications() {
		return resultPublications;
	}

	/**
	 * @param resultPublications the resultPublications to set
	 */
	public void setResultPublications(Set<OrganisationUnit_ResultPublication> resultPublications) {
		this.resultPublications = resultPublications;
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
	 * @return the postalAddresses
	 */
	public Set<OrganisationUnit_PostalAddress> getPostalAddresses() {
		return postalAddresses;
	}

	/**
	 * @param postalAddresses the postalAddresses to set
	 */
	public void setPostalAddresses(
			Set<OrganisationUnit_PostalAddress> postalAddresses) {
		this.postalAddresses = postalAddresses;
	}

	/**
	 * @return the electronicAddresses
	 */
	public Set<OrganisationUnit_ElectronicAddress> getElectronicAddresses() {
		return electronicAddresses;
	}

	/**
	 * @param electronicAddresses the electronicAddresses to set
	 */
	public void setElectronicAddresses(
			Set<OrganisationUnit_ElectronicAddress> electronicAddresses) {
		this.electronicAddresses = electronicAddresses;
	}

	
	
	/**
	 * @return the organisationUnits1
	 */
	public Set<OrganisationUnit_OrganisationUnit> getOrganisationUnits1() {
		return organisationUnits1;
	}

	/**
	 * @param organisationUnits1 the organisationUnits1 to set
	 */
	public void setOrganisationUnits1(Set<OrganisationUnit_OrganisationUnit> organisationUnits1) {
		this.organisationUnits1 = organisationUnits1;
	}

	/**
	 * @return the organisationUnits2
	 */
	public Set<OrganisationUnit_OrganisationUnit> getOrganisationUnits2() {
		return organisationUnits2;
	}

	/**
	 * @param organisationUnits2 the organisationUnits2 to set
	 */
	public void setOrganisationUnits2(Set<OrganisationUnit_OrganisationUnit> organisationUnits2) {
		this.organisationUnits2 = organisationUnits2;
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
	 * Returns the organisation translations.
	 * @return the organisation translations.
	 */
	public OrganisationUnitName getOrganisationUnitNameTranslation(Language language) {
		OrganisationUnitName result = null; 
		if (organisationUnitNames != null) {
			for (OrganisationUnitName translation : organisationUnitNames) {
				if (language.equals(translation.getLanguage())) {
					result = translation;
					break;
				}
			}
		}
		return result;
	}
	
	public OrganisationUnitName getFirstTranslationName() {
		OrganisationUnitName name = null;
		if (organisationUnitNames != null && organisationUnitNames.size() > 0) {
			for (OrganisationUnitName translation : organisationUnitNames) {
				if (StringUtils.hasText(translation.getName())) {
					name = translation;
					break;
				}
			}
		}
		return name;
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
	 * Returns the organisation Research Activities translations.
	 * @return the organisation Research Activities translations.
	 */
	public OrganisationUnitResearchActivity getOrganisationUnitResearchActivityTranslation(Language language) {
		OrganisationUnitResearchActivity result = null; 
		if (organisationUnitResearchActivities != null) {
			for (OrganisationUnitResearchActivity translation : organisationUnitResearchActivities) {
				if (language.equals(translation.getLanguage())) {
					result = translation;
					break;
				}
			}
		}
		return result;
	}
	
	public OrganisationUnitResearchActivity getFirstTranslationResearchActivity() {
		OrganisationUnitResearchActivity result = null;
		if (organisationUnitResearchActivities != null && organisationUnitResearchActivities.size() > 0) {
			for (OrganisationUnitResearchActivity translation : organisationUnitResearchActivities) {
				if (StringUtils.hasText(translation.getResearchActivity())) {
					result = translation;
					break;
				}
			}
		}
		return result;
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
	
	/**
	 * Returns the organisation Keywords translations.
	 * @return the organisation Keywords translations.
	 */
	public OrganisationUnitKeyword getOrganisationUnitKeywordsTranslation(Language language) {
		OrganisationUnitKeyword result = null; 
		if (organisationUnitKeywords != null) {
			for (OrganisationUnitKeyword translation : organisationUnitKeywords) {
				if (language.equals(translation.getLanguage())) {
					result = translation;
					break;
				}
			}
		}
		return result;
	}
	
	public OrganisationUnitKeyword getFirstTranslationKeyword() {
		OrganisationUnitKeyword result = null;
		if (organisationUnitKeywords != null && organisationUnitKeywords.size() > 0) {
			for (OrganisationUnitKeyword translation : organisationUnitKeywords) {
				if (StringUtils.hasText(translation.getKeyword())) {
					result = translation;
					break;
				}
			}
		}
		return result;
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
	 * @return the organisationUnits_medium
	 */
	public Set<OrganisationUnit_Medium> getOrganisationUnits_medium() {
		return organisationUnits_medium;
	}

	/**
	 * @param organisationUnits_medium the organisationUnits_medium to set
	 */
	public void setOrganisationUnits_medium(
			Set<OrganisationUnit_Medium> organisationUnits_medium) {
		this.organisationUnits_medium = organisationUnits_medium;
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
				+ ", turn=" + turn + ", uri=" + uri + "]";
	}

	
	
}

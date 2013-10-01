/**
 * 
 */
package gr.ekt.cerif.entities.infrastructure;

import java.util.Set;

import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.entities.link.Facility_Facility;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.link.Facility_PostalAddress;
import gr.ekt.cerif.entities.link.Facility_Service;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.entities.link.person.Person_Facility;
import gr.ekt.cerif.entities.link.project.Project_Facility;
import gr.ekt.cerif.entities.link.result.ResultPublication_Facility;
import gr.ekt.cerif.features.multilingual.FacilityDescription;
import gr.ekt.cerif.features.multilingual.FacilityKeyword;
import gr.ekt.cerif.features.multilingual.FacilityName;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;


/**
 * Represents a facility second level entity.
 */
@Entity
@Table(name="cfFacil")
@Indexed(index="indexes/facilities")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Facility implements CerifInfrastructureEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 651181766774581326L;	
	
	/**
	 * The facility id.
	 */
	@Id
	@Column(name="cfFacilId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The acronym.
	 */
	@Column(name="cfAcro")
	@Field(name="facilityAcronym", index=Index.YES, store=Store.YES)
	private String acronym;
	
	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	/**
	 * The link entities of projects and facilities.
	 */
	@OneToMany(mappedBy="facility")
	private Set<Project_Facility> projects_facilities;
	
	@OneToMany(mappedBy="facility")
	private Set<OrganisationUnit_Facility> organisationUnits_facilities;
	
	@OneToMany(mappedBy="facility")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<FacilityName> names;
	
	@OneToMany(mappedBy="facility")
	private Set<FacilityKeyword> keywords;
	
	@OneToMany(mappedBy="facility")
	private Set<FacilityDescription> descriptions;

	@OneToMany(mappedBy="facility")
	private Set<Person_Facility> persons_facilities;
	
	@OneToMany(mappedBy="facility")
	private Set<ResultPublication_Facility> resultPublications_facilities;
	
	@OneToMany(mappedBy="facility")
	private Set<Facility_Class> classes;
	
	@OneToMany(mappedBy="facility")
	private Set<Facility_Funding> facilities_fundings;
	
	@OneToMany(mappedBy="facility1")
	private Set<Facility_Facility> facilities_facilities1;
	
	@OneToMany(mappedBy="facility2")
	private Set<Facility_Facility> facilities_facilities2;
	
	@OneToMany(mappedBy="facility")
	private Set<Facility_Service> facilities_services;
	
	/**
	 * The postal addresses.
	 */
	@OneToMany(mappedBy="facility")
	private Set<Facility_PostalAddress> postalAddresses;
	
	/**
	 * Default Constructor
	 */
	public Facility(){
		
	}
	
	/**
	 * 
	 * @param acronym
	 * @param uri
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public Facility(String acronym, String uri, 
			Set<FacilityName> names,
			Set<FacilityKeyword> keywords,
			Set<FacilityDescription> descriptions) {
		this.acronym = acronym;
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
	 * @return the names
	 */
	public Set<FacilityName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(Set<FacilityName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public Set<FacilityKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(Set<FacilityKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public Set<FacilityDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(Set<FacilityDescription> descriptions) {
		this.descriptions = descriptions;
	}
	
	/**
	 * @return the persons_facilities
	 */
	public Set<Person_Facility> getPersons_facilities() {
		return persons_facilities;
	}
	
	/**
	 * @param persons_facilities the persons_facilities to set
	 */
	public void setPersons_facilities(Set<Person_Facility> persons_facilities) {
		this.persons_facilities = persons_facilities;
	}
	
	/**
	 * @return the resultPublications_facilities
	 */
	public Set<ResultPublication_Facility> getResultPublications_facilities() {
		return resultPublications_facilities;
	}
	
	/**
	 * @param resultPublications_facilities the resultPublications_facilities to set
	 */
	public void setResultPublications_facilities(
			Set<ResultPublication_Facility> resultPublications_facilities) {
		this.resultPublications_facilities = resultPublications_facilities;
	}

	public Set<OrganisationUnit_Facility> getOrganisationUnits_facilities() {
		return organisationUnits_facilities;
	}

	public void setOrganisationUnits_facilities(
			Set<OrganisationUnit_Facility> organisationUnits_facilities) {
		this.organisationUnits_facilities = organisationUnits_facilities;
	}

	/**
	 * @return the classes
	 */
	public Set<Facility_Class> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(Set<Facility_Class> classes) {
		this.classes = classes;
	}

	public Set<Facility_Funding> getFacilities_fundings() {
		return facilities_fundings;
	}

	public void setFacilities_fundings(Set<Facility_Funding> facilities_fundings) {
		this.facilities_fundings = facilities_fundings;
	}	

	/**
	 * @return the facilities_facilities1
	 */
	public Set<Facility_Facility> getFacilities_facilities1() {
		return facilities_facilities1;
	}

	/**
	 * @param facilities_facilities1 the facilities_facilities1 to set
	 */
	public void setFacilities_facilities1(Set<Facility_Facility> facilities_facilities1) {
		this.facilities_facilities1 = facilities_facilities1;
	}

	/**
	 * @return the facilities_facilities2
	 */
	public Set<Facility_Facility> getFacilities_facilities2() {
		return facilities_facilities2;
	}

	/**
	 * @param facilities_facilities2 the facilities_facilities2 to set
	 */
	public void setFacilities_facilities2(Set<Facility_Facility> facilities_facilities2) {
		this.facilities_facilities2 = facilities_facilities2;
	}

	/**
	 * @return the facilities_services
	 */
	public Set<Facility_Service> getFacilities_services() {
		return facilities_services;
	}

	/**
	 * @param facilities_services the facilities_services to set
	 */
	public void setFacilities_services(Set<Facility_Service> facilities_services) {
		this.facilities_services = facilities_services;
	}

	/**
	 * @return the postalAddresses
	 */
	public Set<Facility_PostalAddress> getPostalAddresses() {
		return postalAddresses;
	}

	/**
	 * @param postalAddresses the postalAddresses to set
	 */
	public void setPostalAddresses(
			Set<Facility_PostalAddress> postalAddresses) {
		this.postalAddresses = postalAddresses;
	}
	
}

/**
 * 
 */
package gr.ekt.cerif.features.semantics;

import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.project.Project_Classification;
import gr.ekt.cerif.entities.link.project.Project_Equipment;
import gr.ekt.cerif.entities.link.project.Project_Event;
import gr.ekt.cerif.entities.link.project.Project_Facility;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.entities.link.project.Project_PrizeAward;
import gr.ekt.cerif.entities.link.project.Project_Project;
import gr.ekt.cerif.entities.link.project.Project_ResultPatent;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.entities.link.result.ResultPatent_Class;
import gr.ekt.cerif.entities.link.result.ResultProduct_Class;
import gr.ekt.cerif.entities.link.result.ResultProduct_GeographicBoundingBox;
import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ClassDefinition;
import gr.ekt.cerif.features.multilingual.ClassDescription;
import gr.ekt.cerif.features.multilingual.ClassEx;
import gr.ekt.cerif.features.multilingual.ClassTerm;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents a classification semantic.
 * 
 */
@Entity
@Table(name="cfClass")
public class Class implements CerifSemanticFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3602671648727049566L;

	/**
	 * The classification unique identifier.
	 */
	@Id
	@Column(name="cfClassId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The start date.
	 */
	@Column(name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@Column(name="cfEndDate")
	private Date endDate;
	
	/**
	 * The URI.
	 */
	@Column(name="cfUri")
	private String uri;
	
	/**
	 * The classification scheme.
	 */
	@ManyToOne
	@JoinColumn (name = "cfClassSchemeId")
	private ClassScheme scheme;

	@OneToMany(mappedBy="theClass")
	private Set<Project_OrganisationUnit> project_organisationUnits;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_ResultProduct> person_resultProducts;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_ResultProduct> orgUnit_resultProducts;	
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultProduct_Class> resultProducts;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_Class> persons;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultProduct_GeographicBoundingBox> resultProduct_GeographicBoundingBoxes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Project_Project> projects;
	
	@OneToMany(mappedBy="theClass")
	private Set<Project_Classification> projects_classes;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Equipment> projects_equipments;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Event> projects_events;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Facility> projects_facilities;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Funding> projects_fundings;

	@OneToMany(mappedBy="theClass")
	private Set<Project_PrizeAward> projects_prizes;

	@OneToMany(mappedBy="theClass")
	private Set<Project_ResultPatent> projects_resultPatents;

	@OneToMany(mappedBy="theClass")
	private Set<Project_ResultPublication> projects_resultPublications;

	@OneToMany(mappedBy="theClass")
	private Set<Project_ResultProduct> projects_resultProducts;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Service> projects_services;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Person> projects_persons;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPatent_Class> resultPatents_classes;
	
	//Define relations with organisationUnit link enktities
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_ElectronicAddress> organisationUnits_electronicAddresses;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_OrganisationUnit> organisationUnits;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_PostalAddress> organisationUnits_postalAddresses;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_ResultProduct> organisationUnits_resultProducts;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_ResultPublication> organisationUnits_resultPublications;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPublication_Class> resultPublications_classes;
	
	@OneToMany(mappedBy="theClass", fetch=FetchType.EAGER)
	private Set<ClassDescription> descriptions;
	
	@OneToMany(mappedBy="theClass", fetch=FetchType.EAGER)
	private Set<ClassTerm> terms;
	
	@OneToMany(mappedBy="theClass", fetch=FetchType.EAGER)
	private Set<ClassEx> exs;
	
	@OneToMany(mappedBy="theClass", fetch=FetchType.EAGER)
	private Set<ClassDefinition> definitions;
	
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
	 * Returns the start date.
	 * @return the start date.
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 * @param startDate the start date.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Returns the end date.
	 * @return the end date.
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 * @param endDate the end date.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	 * Returns the scheme.
	 * @return the scheme.
	 */
	public ClassScheme getScheme() {
		return scheme;
	}

	/**
	 * Sets the scheme.
	 * @param scheme the scheme.
	 */
	public void setScheme(ClassScheme scheme) {
		this.scheme = scheme;
	}

	/**
	 * @return the person_resultProducts
	 */
	public Set<Person_ResultProduct> getPerson_resultProducts() {
		return person_resultProducts;
	}

	/**
	 * @param person_resultProducts the person_resultProducts to set
	 */
	public void setPerson_resultProducts(
			Set<Person_ResultProduct> person_resultProducts) {
		this.person_resultProducts = person_resultProducts;
	}
	/**
	 * Returns the project_organisation links.
	 * @return the project_organisation links.
	 */
	public Set<Project_OrganisationUnit> getProject_organisationUnits() {
		return project_organisationUnits;
	}
	
	/**
	 * Sets the project_organisation links.
	 * @param project_organisationUnits the project_organisation links.
	 */
	public void setProject_organisationUnits(Set<Project_OrganisationUnit> project_organisationUnits) {
		this.project_organisationUnits = project_organisationUnits;
	}
	
	/**
	 * @return the resultProducts
	 */
	public Set<ResultProduct_Class> getResultProducts() {
		return resultProducts;
	}

	/**
	 * @param resultProducts the resultProducts to set
	 */
	public void setResultProducts(Set<ResultProduct_Class> resultProducts) {
		this.resultProducts = resultProducts;
	}

	/**
	 * @return the persons
	 */
	public Set<Person_Class> getPersons() {
		return persons;
	}

	/**
	 * @param persons the persons to set
	 */
	public void setPersons(Set<Person_Class> persons) {
		this.persons = persons;
	}

	
	public ClassTerm getOriginalTranslation() {
		ClassTerm result = null;
		if (terms != null && terms.iterator().hasNext()) {
			result = terms.iterator().next();
		}
		return result;
	}
	
	public ClassTerm getTranslation(Language language) {
		ClassTerm result = null;
		if (terms != null) {
			for (ClassTerm translation : terms) {
				if (translation.getLanguage().equals(language)) {
					result = translation;
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Returns the orgUnit_resultProducts.
	 * @return the orgUnit_resultProducts.
	 */
	public Set<Person_ResultProduct> getOrgUnit_resultProducts() {
		return orgUnit_resultProducts;
	}

	/**
	 * Sets the orgUnit_resultProducts.
	 * @param orgUnit_resultProducts the orgUnit_resultProducts.
	 */
	public void setOrgUnit_resultProducts(Set<Person_ResultProduct> orgUnit_resultProducts) {
		this.orgUnit_resultProducts = orgUnit_resultProducts;
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

	/**
	 * Returns the resultProduct_GeographicBoundingBoxes.
	 * @return the resultProduct_GeographicBoundingBoxes.
	 */
	public Set<ResultProduct_GeographicBoundingBox> getResultProduct_GeographicBoundingBoxes() {
		return resultProduct_GeographicBoundingBoxes;
	}
	
	/**
	 * Sets the resultProduct_GeographicBoundingBoxes.
	 * @param resultProduct_GeographicBoundingBoxes the resultProduct_GeographicBoundingBoxes.
	 */
	public void setResultProduct_GeographicBoundingBoxes(
			Set<ResultProduct_GeographicBoundingBox> resultProduct_GeographicBoundingBoxes) {
		this.resultProduct_GeographicBoundingBoxes = resultProduct_GeographicBoundingBoxes;
	}
	
	public Set<ClassDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<ClassDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public Set<ClassTerm> getTerms() {
		return terms;
	}

	public void setTerms(Set<ClassTerm> terms) {
		this.terms = terms;
	}

	public Set<ClassEx> getExs() {
		return exs;
	}

	public void setExs(Set<ClassEx> exs) {
		this.exs = exs;
	}

	public Set<ClassDefinition> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(Set<ClassDefinition> definitions) {
		this.definitions = definitions;
	}

	/**
	 * @return the projects
	 */
	public Set<Project_Project> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(Set<Project_Project> projects) {
		this.projects = projects;
	}

	/**
	 * @return the projects_classes
	 */
	public Set<Project_Classification> getProjects_classes() {
		return projects_classes;
	}

	/**
	 * @param projects_classes the projects_classes to set
	 */
	public void setProjects_classes(Set<Project_Classification> projects_classes) {
		this.projects_classes = projects_classes;
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
	 * @return the projects_events
	 */
	public Set<Project_Event> getProjects_events() {
		return projects_events;
	}

	/**
	 * @param projects_events the projects_events to set
	 */
	public void setProjects_events(Set<Project_Event> projects_events) {
		this.projects_events = projects_events;
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
	 * @return the projects_prizes
	 */
	public Set<Project_PrizeAward> getProjects_prizes() {
		return projects_prizes;
	}

	/**
	 * @param projects_prizes the projects_prizes to set
	 */
	public void setProjects_prizes(Set<Project_PrizeAward> projects_prizes) {
		this.projects_prizes = projects_prizes;
	}

	/**
	 * @return the projects_resultPatents
	 */
	public Set<Project_ResultPatent> getProjects_resultPatents() {
		return projects_resultPatents;
	}

	/**
	 * @param projects_resultPatents the projects_resultPatents to set
	 */
	public void setProjects_resultPatents(Set<Project_ResultPatent> projects_resultPatents) {
		this.projects_resultPatents = projects_resultPatents;
	}

	/**
	 * @return the projects_resultPublications
	 */
	public Set<Project_ResultPublication> getProjects_resultPublications() {
		return projects_resultPublications;
	}

	/**
	 * @param projects_resultPublications the projects_resultPublications to set
	 */
	public void setProjects_resultPublications(
			Set<Project_ResultPublication> projects_resultPublications) {
		this.projects_resultPublications = projects_resultPublications;
	}

	/**
	 * @return the projects_resultProducts
	 */
	public Set<Project_ResultProduct> getProjects_resultProducts() {
		return projects_resultProducts;
	}

	/**
	 * @param projects_resultProducts the projects_resultProducts to set
	 */
	public void setProjects_resultProducts(Set<Project_ResultProduct> projects_resultProducts) {
		this.projects_resultProducts = projects_resultProducts;
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
	 * @return the projects_persons
	 */
	public Set<Project_Person> getProjects_persons() {
		return projects_persons;
	}

	/**
	 * @param projects_persons the projects_persons to set
	 */
	public void setProjects_persons(Set<Project_Person> projects_persons) {
		this.projects_persons = projects_persons;
	}

	/**
	 * @return the organisationUnits_electronicAddresses
	 */
	public Set<OrganisationUnit_ElectronicAddress> getOrganisationUnit_electronicAddresses() {
		return organisationUnits_electronicAddresses;
	}

	/**
	 * @param organisationUnits_electronicAddresses the organisationUnits_electronicAddresses to set
	 */
	public void setOrganisationUnit_electronicAddresses(
			Set<OrganisationUnit_ElectronicAddress> organisationUnits_electronicAddresses) {
		this.organisationUnits_electronicAddresses = organisationUnits_electronicAddresses;
	}

	/**
	 * @return the organisationUnits
	 */
	public Set<OrganisationUnit_OrganisationUnit> getOrganisationUnits() {
		return organisationUnits;
	}

	/**
	 * @param organisationUnits the organisationUnits to set
	 */
	public void setOrganisationUnits(Set<OrganisationUnit_OrganisationUnit> organisationUnits) {
		this.organisationUnits = organisationUnits;
	}

	/**
	 * @return the organisationUnits_postalAddresses
	 */
	public Set<OrganisationUnit_PostalAddress> getOrganisationUnit_postalAddresses() {
		return organisationUnits_postalAddresses;
	}

	/**
	 * @param organisationUnits_postalAddresses the organisationUnits_postalAddresses to set
	 */
	public void setOrganisationUnit_postalAddresses(
			Set<OrganisationUnit_PostalAddress> organisationUnits_postalAddresses) {
		this.organisationUnits_postalAddresses = organisationUnits_postalAddresses;
	}

	/**
	 * @return the organisationUnits_resultProducts
	 */
	public Set<OrganisationUnit_ResultProduct> getOrganisationUnit_resultProducts() {
		return organisationUnits_resultProducts;
	}

	/**
	 * @param organisationUnits_resultProducts the organisationUnits_resultProducts to set
	 */
	public void setOrganisationUnit_resultProducts(
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
	 * @return the resultPatents_classes
	 */
	public Set<ResultPatent_Class> getResultPatents_classes() {
		return resultPatents_classes;
	}
	
	/**
	 * @param resultPatents_classes the resultPatents_classes to set
	 */
	public void setResultPatents_classes(
			Set<ResultPatent_Class> resultPatents_classes) {
		this.resultPatents_classes = resultPatents_classes;
	}
	
	/**
	 * @return the resultPublications_classes
	 */
	public Set<ResultPublication_Class> getResultPublications_classes() {
		return resultPublications_classes;
	}
	
	/**
	 * @param resultPublications_classes the resultPublications_classes to set
	 */
	public void setResultPublications_classes(
			Set<ResultPublication_Class> resultPublications_classes) {
		this.resultPublications_classes = resultPublications_classes;
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
		if (!(obj instanceof Class)) {
			return false;
		}
		Class other = (Class) obj;
		if (uri == null) {
			if (other.uri != null) {
				return false;
			}
		} else if (!uri.equals(other.uri)) {
			return false;
		}
		return true;
	}
	
}

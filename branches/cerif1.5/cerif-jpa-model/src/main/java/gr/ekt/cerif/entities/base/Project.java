/**
 * 
 */
package gr.ekt.cerif.entities.base;

import gr.ekt.cerif.entities.link.project.Project_Class;
import gr.ekt.cerif.entities.link.project.Project_Equipment;
import gr.ekt.cerif.entities.link.project.Project_Event;
import gr.ekt.cerif.entities.link.project.Project_Facility;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.entities.link.project.Project_Prize;
import gr.ekt.cerif.entities.link.project.Project_Project;
import gr.ekt.cerif.entities.link.project.Project_ResultPatent;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;
import gr.ekt.cerif.features.multilingual.ProjectKeyword;
import gr.ekt.cerif.features.multilingual.ProjectTitle;

import java.util.Date;
import java.util.Set;

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
 * Represents a project base entity.
 */
@Entity
@Table(name="cfProj")
@Indexed(index="indexes/projects")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Project implements CerifBaseEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -8878055306297616330L;

	/**
	 * The project unique identifier.
	 */
	@Id
	@Column(name="cfProjId")
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
	 * The acronym.
	 */
	@Column(name="cfAcro")
	@Field(name="projectAcronym", index=Index.YES, store=Store.YES)
	private String acronym;

	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;	
	
	/**
	 * The project titles.
	 */
	@OneToMany(mappedBy="project")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<ProjectTitle> projectTitles;
	
	/**
	 * The project abstracts.
	 */
	@OneToMany(mappedBy="project")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<ProjectAbstract> projectAbstracts;
	
	/**
	 * The project keywords.
	 */
	@OneToMany(mappedBy="project")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<ProjectKeyword> projectKeywords;

	/**
	 * The organisations.
	 */
	@OneToMany(mappedBy="project")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<Project_OrganisationUnit> organisationUnits;
	
	/**
	 * The projects.
	 */
	@OneToMany(mappedBy="project1")
	private Set<Project_Project> projects1;
	
	/**
	 * The projects.
	 */
	@OneToMany(mappedBy="project2")
	private Set<Project_Project> projects2;
	
	/**
	 * The persons.
	 */
	@OneToMany(mappedBy="project")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<Project_Person> persons;
	
	
	/**
	 * The result products.
	 */
	@OneToMany(mappedBy="project")
	private Set<Project_ResultProduct> resultProducts;
	
	@OneToMany(mappedBy="project")
	private Set<Project_Class> projects_classes;

	@OneToMany(mappedBy="project")
	private Set<Project_Equipment> projects_equipments;

	@OneToMany(mappedBy="project")
	private Set<Project_Event> projects_events;

	@OneToMany(mappedBy="project")
	private Set<Project_Facility> projects_facilities;

	@OneToMany(mappedBy="project")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<Project_Funding> projects_fundings;

	@OneToMany(mappedBy="project")
	private Set<Project_Prize> projects_prizes;

	@OneToMany(mappedBy="project")
	private Set<Project_ResultPatent> projects_resultPatents;

	@OneToMany(mappedBy="project")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<Project_ResultPublication> projects_resultPublications;

	@OneToMany(mappedBy="project")
	private Set<Project_Service> projects_services;

	/**
	 * Default Constructor
	 */
	public Project(){
		
	}
	
	/**
	 * 
	 * @param id
	 * @param startDate
	 * @param endDate
	 * @param acronym
	 * @param uri
	 * @param projectTitles
	 * @param projectAbstracts
	 * @param projectKeywords
	 */
	public Project(Long id, Date startDate, Date endDate, String acronym,
			String uri, Set<ProjectTitle> projectTitles,
			Set<ProjectAbstract> projectAbstracts,
			Set<ProjectKeyword> projectKeywords) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.acronym = acronym;
		this.uri = uri;
		this.projectTitles = projectTitles;
		this.projectAbstracts = projectAbstracts;
		this.projectKeywords = projectKeywords;
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
	 * Returns the project titles.
	 * @return the project titles.
	 */
	public Set<ProjectTitle> getProjectTitles() {
		return projectTitles;
	}

	/**
	 * Sets the project titles.
	 * @param projectTitles the project titles.
	 */
	public void setProjectTitles(Set<ProjectTitle> projectTitles) {
		this.projectTitles = projectTitles;
	}

	/**
	 * Returns the project abstracts.
	 * @return the project abstracts.
	 */
	public Set<ProjectAbstract> getProjectAbstracts() {
		return projectAbstracts;
	}

	/**
	 * Sets the project abstracts.
	 * @param projectAbstracts the project abstracts.
	 */
	public void setProjectAbstracts(Set<ProjectAbstract> projectAbstracts) {
		this.projectAbstracts = projectAbstracts;
	}

	/**
	 * Returns the project keywords.
	 * @return the project keywords.
	 */
	public Set<ProjectKeyword> getProjectKeywords() {
		return projectKeywords;
	}

	/**
	 * Sets the project keywords.
	 * @param projectKeywords the project keywords.
	 */
	public void setProjectKeywords(Set<ProjectKeyword> projectKeywords) {
		this.projectKeywords = projectKeywords;
	}


	/**
	 * Returns the organisations.
	 * @return the organisations.
	 */
	public Set<Project_OrganisationUnit> getOrganisationUnits() {
		return organisationUnits;
	}

	/**
	 * Sets the organisations.
	 * @param organisationUnits the organisations.
	 */
	public void setOrganisationUnits(Set<Project_OrganisationUnit> organisationUnits) {
		this.organisationUnits = organisationUnits;
	}

	/**
	 * @return the projects1
	 */
	public Set<Project_Project> getProjects1() {
		return projects1;
	}

	/**
	 * @param projects1 the projects1 to set
	 */
	public void setProjects1(Set<Project_Project> projects1) {
		this.projects1 = projects1;
	}

	/**
	 * @return the projects2
	 */
	public Set<Project_Project> getProjects2() {
		return projects2;
	}

	/**
	 * @param projects2 the projects2 to set
	 */
	public void setProjects2(Set<Project_Project> projects2) {
		this.projects2 = projects2;
	}	

	/**
	 * @return the persons
	 */
	public Set<Project_Person> getPersons() {
		return persons;
	}

	/**
	 * @param persons the persons to set
	 */
	public void setPersons(Set<Project_Person> persons) {
		this.persons = persons;
	}

	/**
	 * @return the resultProducts
	 */
	public Set<Project_ResultProduct> getResultProducts() {
		return resultProducts;
	}

	/**
	 * @param resultProducts the resultProducts to set
	 */
	public void setResultProducts(Set<Project_ResultProduct> resultProducts) {
		this.resultProducts = resultProducts;
	}
	
	/**
	 * @return the projects_classes
	 */
	public Set<Project_Class> getProjects_classes() {
		return projects_classes;
	}

	/**
	 * @param projects_classes the projects_classes to set
	 */
	public void setProjects_classes(Set<Project_Class> projects_classes) {
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
	public Set<Project_Prize> getProjects_prizes() {
		return projects_prizes;
	}

	/**
	 * @param projects_prizes the projects_prizes to set
	 */
	public void setProjects_prizes(Set<Project_Prize> projects_prizes) {
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

}

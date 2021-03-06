/**
 * 
 */
package gr.ekt.cerif.entities.base;

import gr.ekt.cerif.entities.link.project.Project_Class;
import gr.ekt.cerif.entities.link.project.Project_DublinCore;
import gr.ekt.cerif.entities.link.project.Project_Equipment;
import gr.ekt.cerif.entities.link.project.Project_Event;
import gr.ekt.cerif.entities.link.project.Project_Facility;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.link.project.Project_Indicator;
import gr.ekt.cerif.entities.link.project.Project_Measurement;
import gr.ekt.cerif.entities.link.project.Project_Medium;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.entities.link.project.Project_Prize;
import gr.ekt.cerif.entities.link.project.Project_Project;
import gr.ekt.cerif.entities.link.project.Project_ResultPatent;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;
import gr.ekt.cerif.features.multilingual.ProjectKeyword;
import gr.ekt.cerif.features.multilingual.ProjectTitle;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Represents a project base entity.
 */
@Entity
@Table(name="cfProj")
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
	@Deprecated
	@Column(name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@Deprecated
	@Column(name="cfEndDate")
	private Date endDate;
	
	/**
	 * The acronym.
	 */
	@Column(name="cfAcro")
	private String acronym;

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
	@OneToMany(mappedBy="project")
	private Set<ProjectTitle> projectTitles;
	
	@OneToMany(mappedBy="project")
	private Set<ProjectAbstract> projectAbstracts;
	
	@OneToMany(mappedBy="project")
	private Set<ProjectKeyword> projectKeywords;

	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="project")
	private Set<Project_OrganisationUnit> projects_organisationUnits;
	
	@OneToMany(mappedBy="project1")
	private Set<Project_Project> projects_projects1;
	
	@OneToMany(mappedBy="project2")
	private Set<Project_Project> projects_projects2;
	
	@OneToMany(mappedBy="project")
	private Set<Project_Person> projects_persons;
	
	@OneToMany(mappedBy="project")
	private Set<Project_ResultProduct> projects_resultProducts;
	
	@OneToMany(mappedBy="project")
	private Set<Project_Class> projects_classes;

	@OneToMany(mappedBy="project")
	private Set<Project_Equipment> projects_equipments;

	@OneToMany(mappedBy="project")
	private Set<Project_Event> projects_events;

	@OneToMany(mappedBy="project")
	private Set<Project_Facility> projects_facilities;

	@OneToMany(mappedBy="project")
	private Set<Project_Funding> projects_fundings;

	@OneToMany(mappedBy="project")
	private Set<Project_Prize> projects_prizes;

	@OneToMany(mappedBy="project")
	private Set<Project_ResultPatent> projects_resultPatents;

	@OneToMany(mappedBy="project")
	private Set<Project_ResultPublication> projects_resultPublications;

	@OneToMany(mappedBy="project")
	private Set<Project_Service> projects_services;
	
	@OneToMany(mappedBy="project")
	private Set<Project_Indicator> projects_indicators;
	
	@OneToMany(mappedBy="project")
	private Set<Project_Measurement> projects_measurements;
	
	@OneToMany(mappedBy="project")
	private Set<Project_Medium> projects_mediums;
	
	@OneToMany(mappedBy="project")
	private Set<Project_DublinCore> projects_DublinCores;
	
	
	/**
	 * FederatedIdentifier entities related to Project instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//

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
	 * @return the projects_resultProducts
	 */
	public Set<Project_ResultProduct> getProjects_resultProducts() {
		return projects_resultProducts;
	}

	/**
	 * @param projects_resultProducts the projects_resultProducts to set
	 */
	public void setProjects_resultProducts(
			Set<Project_ResultProduct> projects_resultProducts) {
		this.projects_resultProducts = projects_resultProducts;
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

	/**
	 * @return the projects_indicators
	 */
	public Set<Project_Indicator> getProjects_indicators() {
		return projects_indicators;
	}

	/**
	 * @param projects_indicators the projects_indicators to set
	 */
	public void setProjects_indicators(Set<Project_Indicator> projects_indicators) {
		this.projects_indicators = projects_indicators;
	}

	/**
	 * @return the projects_measurements
	 */
	public Set<Project_Measurement> getProjects_measurements() {
		return projects_measurements;
	}

	/**
	 * @param projects_measurements the projects_measurements to set
	 */
	public void setProjects_measurements(
			Set<Project_Measurement> projects_measurements) {
		this.projects_measurements = projects_measurements;
	}

	/**
	 * @return the projects_projects1
	 */
	public Set<Project_Project> getProjects_projects1() {
		return projects_projects1;
	}

	/**
	 * @param projects_projects1 the projects_projects1 to set
	 */
	public void setProjects_projects1(Set<Project_Project> projects_projects1) {
		this.projects_projects1 = projects_projects1;
	}

	/**
	 * @return the projects_projects2
	 */
	public Set<Project_Project> getProjects_projects2() {
		return projects_projects2;
	}

	/**
	 * @param projects_projects2 the projects_projects2 to set
	 */
	public void setProjects_projects2(Set<Project_Project> projects_projects2) {
		this.projects_projects2 = projects_projects2;
	}

	/**
	 * @return the projects_mediums
	 */
	public Set<Project_Medium> getProjects_mediums() {
		return projects_mediums;
	}

	/**
	 * @param projects_mediums the projects_mediums to set
	 */
	public void setProjects_mediums(Set<Project_Medium> projects_mediums) {
		this.projects_mediums = projects_mediums;
	}

	/**
	 * @return the projects_organisationUnits
	 */
	public Set<Project_OrganisationUnit> getProjects_organisationUnits() {
		return projects_organisationUnits;
	}

	/**
	 * @param projects_organisationUnits the projects_organisationUnits to set
	 */
	public void setProjects_organisationUnits(
			Set<Project_OrganisationUnit> projects_organisationUnits) {
		this.projects_organisationUnits = projects_organisationUnits;
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
	 * @return the projects_DublinCores
	 */
	public Set<Project_DublinCore> getProjects_DublinCores() {
		return projects_DublinCores;
	}

	/**
	 * @param projects_DublinCores the projects_DublinCores to set
	 */
	public void setProjects_DublinCores(Set<Project_DublinCore> projects_DublinCores) {
		this.projects_DublinCores = projects_DublinCores;
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
	public void setFederatedIdentifiers(List<FederatedIdentifier> federatedIdentifiers) {
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
		
		if (!(obj instanceof Project)) {
			return false;
		}
		
		Project other = (Project) obj;
		
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
		return "Project [id=" + id + ", startDate=" + startDate + ", endDate="
				+ endDate + ", acronym=" + acronym + ", uri=" + uri + ", uuid="
				+ uuid + "]";
	}


}

/**
 * 
 */
package gr.ekt.cerif.entities.infrastructure;

import gr.ekt.cerif.entities.link.person.Person_Service;
import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.features.multilingual.ServiceDescription;
import gr.ekt.cerif.features.multilingual.ServiceKeyword;
import gr.ekt.cerif.features.multilingual.ServiceName;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;

/**
 * Represents a service second level entity.
 */
@Entity
@Table(name="cfSrv")
public class Service implements CerifInfrastructureEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 8420804898605631508L;
	
	/**
	 * The service id.
	 */
	@Id
	@Column(name="cfSrvId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

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
	 * The link entities of projects and services.
	 */
	@OneToMany(mappedBy="service")
	private Set<Project_Service> projects_services;

	@OneToMany(mappedBy="service")
	private Set<ServiceName> names;
	
	@OneToMany(mappedBy="service")
	private Set<ServiceKeyword> keywords;
	
	@OneToMany(mappedBy="service")
	private Set<ServiceDescription> descriptions;
	
	@OneToMany(mappedBy="service")
	private Set<Person_Service> persons_services;

	/**
	 * Default Constructor
	 */
	public Service() {
		
	}
	
	/**
	 * 
	 * @param acronym
	 * @param uri
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public Service(String acronym, String uri, Set<ServiceName> names,
			Set<ServiceKeyword> keywords, Set<ServiceDescription> descriptions) {
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

	public Set<ServiceName> getNames() {
		return names;
	}

	public void setNames(Set<ServiceName> names) {
		this.names = names;
	}

	public Set<ServiceKeyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<ServiceKeyword> keywords) {
		this.keywords = keywords;
	}

	public Set<ServiceDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<ServiceDescription> descriptions) {
		this.descriptions = descriptions;
	}
	
	/**
	 * @return the persons_services
	 */
	public Set<Person_Service> getPersons_services() {
		return persons_services;
	}
	
	/**
	 * @param persons_services the persons_services to set
	 */
	public void setPersons_services(Set<Person_Service> persons_services) {
		this.persons_services = persons_services;
	}
	
}

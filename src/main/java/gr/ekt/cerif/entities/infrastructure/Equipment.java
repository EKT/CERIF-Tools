/**
 * 
 */
package gr.ekt.cerif.entities.infrastructure;

import java.util.Set;

import gr.ekt.cerif.entities.link.person.Person_Equipment;
import gr.ekt.cerif.entities.link.project.Project_Equipment;
import gr.ekt.cerif.entities.link.result.ResultPublication_Equipment;
import gr.ekt.cerif.features.multilingual.EquipmentDescription;
import gr.ekt.cerif.features.multilingual.EquipmentKeyword;
import gr.ekt.cerif.features.multilingual.EquipmentName;

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
 * Represents an equipment second level entity.
 */
@Entity
@Table(name="cfEquip")
public class Equipment implements CerifInfrastructureEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -240908659483900668L;	
	
	/**
	 * The equipment id.
	 */
	@Id
	@Column(name="cfEquipId")
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
	 * The link entities of projects and equipments.
	 */
	@OneToMany(mappedBy="equipment")
	private Set<Project_Equipment> projects_equipments;
	
	@OneToMany(mappedBy="equipment")
	private Set<EquipmentName> names;
	
	@OneToMany(mappedBy="equipment")
	private Set<EquipmentKeyword> keywords;
	
	@OneToMany(mappedBy="equipment")
	private Set<EquipmentDescription> descriptions;

	@OneToMany(mappedBy="equipment")
	private Set<Person_Equipment> persons_equipments;
	
	@OneToMany(mappedBy="equipment")
	private Set<ResultPublication_Equipment> resultPublications_equipments;

	/**
	 * Default Constructor
	 */
	public Equipment() { 
		
	}
	
	/**
	 * 
	 * @param acronym
	 * @param uri
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public Equipment(String acronym, String uri,
			Set<EquipmentName> names, Set<EquipmentKeyword> keywords,
			Set<EquipmentDescription> descriptions) {
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
	 * @return the names
	 */
	public Set<EquipmentName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(Set<EquipmentName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public Set<EquipmentKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(Set<EquipmentKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public Set<EquipmentDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(Set<EquipmentDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/**
	 * @return the persons_equipments
	 */
	public Set<Person_Equipment> getPersons_equipments() {
		return persons_equipments;
	}
	
	/**
	 * @param persons_equipments the persons_equipments to set
	 */
	public void setPersons_equipments(Set<Person_Equipment> persons_equipments) {
		this.persons_equipments = persons_equipments;
	}
	
	/**
	 * @return the resultPublications_equipments
	 */
	public Set<ResultPublication_Equipment> getResultPublications_equipments() {
		return resultPublications_equipments;
	}
	
	/**
	 * @param resultPublications_equipments the resultPublications_equipments to set
	 */
	public void setResultPublications_equipments(
			Set<ResultPublication_Equipment> resultPublications_equipments) {
		this.resultPublications_equipments = resultPublications_equipments;
	}
}

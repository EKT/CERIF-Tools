/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.ExpertiseAndSkills_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ExpertiseAndSkills;
import gr.ekt.cerif.entities.link.person.Person_ExpertiseAndSkills;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsDescription;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsKeyword;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsName;

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
 * Represents a expertise and skills second level entity.
 * 
 */
@Entity
@Table(name="cfExpSkills")
public class ExpertiseAndSkills implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 742158110063925750L;
	
	/**
	 * The expertise and skill id.
	 */
	@Id
	@Column(name="cfExpSkillsId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

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
	@OneToMany(mappedBy="expertiseAndSkills")
	private Set<ExpertiseAndSkillsName> names;
	
	@OneToMany(mappedBy="expertiseAndSkills")
	private Set<ExpertiseAndSkillsKeyword> keywords;
	
	@OneToMany(mappedBy="expertiseAndSkills")
	private Set<ExpertiseAndSkillsDescription> descriptions;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="expertiseAndSkills")
	private Set<Person_ExpertiseAndSkills> persons_expertiseAndSkills;
	
	@OneToMany(mappedBy="expertiseAndSkills")
	private Set<OrganisationUnit_ExpertiseAndSkills> organisationUnits_expertiseAndSkills;
	
	@OneToMany(mappedBy="expertiseAndSkills")
	private Set<ExpertiseAndSkills_Class> classes;

	
	/**
	 * FederatedIdentifier entities related to ExpertiseAndSkills instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//

	/**
	 * Default Constructor
	 */
	public ExpertiseAndSkills() {
		
	}
	
	/**
	 * 
	 * @param uri
	 * @param names
	 * @param keywords
	 * @param descriptions
	 * @param persons_expertiseAndSkills
	 */
	public ExpertiseAndSkills(String uri, Set<ExpertiseAndSkillsName> names,
			Set<ExpertiseAndSkillsKeyword> keywords,
			Set<ExpertiseAndSkillsDescription> descriptions) {
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
	 * @return the names
	 */
	public Set<ExpertiseAndSkillsName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(Set<ExpertiseAndSkillsName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public Set<ExpertiseAndSkillsKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(Set<ExpertiseAndSkillsKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public Set<ExpertiseAndSkillsDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(Set<ExpertiseAndSkillsDescription> descriptions) {
		this.descriptions = descriptions;
	}
	
	/**
	 * @return the persons_expertiseAndSkills
	 */
	public Set<Person_ExpertiseAndSkills> getPersons_expertiseAndSkills() {
		return persons_expertiseAndSkills;
	}
	
	/**
	 * @param persons_expertiseAndSkills the persons_expertiseAndSkills to set
	 */
	public void setPersons_expertiseAndSkills(
			Set<Person_ExpertiseAndSkills> persons_expertiseAndSkills) {
		this.persons_expertiseAndSkills = persons_expertiseAndSkills;
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
	 * @return the classes
	 */
	public Set<ExpertiseAndSkills_Class> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(Set<ExpertiseAndSkills_Class> classes) {
		this.classes = classes;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExpertiseAndSkills [id=" + id + ", uri=" + uri + ", uuid="
				+ uuid + "]";
	}


}

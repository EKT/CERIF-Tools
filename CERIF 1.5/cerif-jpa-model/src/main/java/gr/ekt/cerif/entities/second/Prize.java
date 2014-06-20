/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.Prize_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Prize;
import gr.ekt.cerif.entities.link.person.Person_Prize;
import gr.ekt.cerif.entities.link.project.Project_Prize;
import gr.ekt.cerif.features.multilingual.PrizeDescription;
import gr.ekt.cerif.features.multilingual.PrizeKeyword;
import gr.ekt.cerif.features.multilingual.PrizeName;

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
 * Represents a prize second level entity.
 * 
 */
@Entity
@Table(name="cfPrize")
public class Prize implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -7660981404694663002L;

	/**
	 * The citation id.
	 */
	@Id
	@Column(name="cfPrizeId")
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
	@OneToMany(mappedBy="prize")
	private Set<PrizeName> prizeNames;
	
	@OneToMany(mappedBy="prize")
	private Set<PrizeKeyword> prizeKeywords;
	
	@OneToMany(mappedBy="prize")
	private Set<PrizeDescription> prizeDescriptions;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="prize")
	private Set<Person_Prize> persons_prizes;
	
	@OneToMany(mappedBy="prize")
	private Set<OrganisationUnit_Prize> organisationUnits_prizes;
	
	@OneToMany(mappedBy="prize")
	private Set<Project_Prize> projects_prizes;
	
	@OneToMany(mappedBy="prize")
	private Set<Prize_Class> prizes_classes;

	
	/**
	 * FederatedIdentifier entities related to OrganisationUnit instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//

	/**
	 * Default Constructor
	 */
	public Prize() {
		
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
	 * @return the prizeNames
	 */
	public Set<PrizeName> getPrizeNames() {
		return prizeNames;
	}

	/**
	 * @param prizeNames the prizeNames to set
	 */
	public void setPrizeNames(Set<PrizeName> prizeNames) {
		this.prizeNames = prizeNames;
	}

	/**
	 * @return the prizeKeywords
	 */
	public Set<PrizeKeyword> getPrizeKeywords() {
		return prizeKeywords;
	}

	/**
	 * @param prizeKeywords the prizeKeywords to set
	 */
	public void setPrizeKeywords(Set<PrizeKeyword> prizeKeywords) {
		this.prizeKeywords = prizeKeywords;
	}

	/**
	 * @return the prizeDescriptions
	 */
	public Set<PrizeDescription> getPrizeDescriptions() {
		return prizeDescriptions;
	}

	/**
	 * @param prizeDescriptions the prizeDescriptions to set
	 */
	public void setPrizeDescriptions(Set<PrizeDescription> prizeDescriptions) {
		this.prizeDescriptions = prizeDescriptions;
	}

	/**
	 * @return the prizes_classes
	 */
	public Set<Prize_Class> getPrizes_classes() {
		return prizes_classes;
	}

	/**
	 * @param prizes_classes the prizes_classes to set
	 */
	public void setPrizes_classes(Set<Prize_Class> prizes_classes) {
		this.prizes_classes = prizes_classes;
	}

	/**
	 * @return the persons_prizes
	 */
	public Set<Person_Prize> getPersons_prizes() {
		return persons_prizes;
	}
	
	/**
	 * @param persons_prizes the persons_prizes to set
	 */
	public void setPersons_prizes(Set<Person_Prize> persons_prizes) {
		this.persons_prizes = persons_prizes;
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
		Prize other = (Prize) obj;
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
		return "Prize [id=" + id + ", uri=" + uri + ", uuid=" + uuid + "]";
	}


}

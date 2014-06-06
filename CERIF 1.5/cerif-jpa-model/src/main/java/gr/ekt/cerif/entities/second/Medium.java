/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.Equipment_Medium;
import gr.ekt.cerif.entities.link.Event_Medium;
import gr.ekt.cerif.entities.link.Facility_Medium;
import gr.ekt.cerif.entities.link.Medium_Class;
import gr.ekt.cerif.entities.link.Medium_Funding;
import gr.ekt.cerif.entities.link.Medium_Indicator;
import gr.ekt.cerif.entities.link.Medium_Measurement;
import gr.ekt.cerif.entities.link.Medium_Medium;
import gr.ekt.cerif.entities.link.Service_Medium;
import gr.ekt.cerif.entities.link.person.Person_Medium;
import gr.ekt.cerif.entities.link.project.Project_Medium;
import gr.ekt.cerif.entities.link.result.ResultPublication_Medium;
import gr.ekt.cerif.features.multilingual.MediumDescription;
import gr.ekt.cerif.features.multilingual.MediumKeyword;
import gr.ekt.cerif.features.multilingual.MediumTitle;

import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * Represents a medium second level entity.
 * 
 */
@Entity
@Table(name="cfMedium")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Medium implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -240908659483900668L;	
	
	/**
	 * The Medium id.
	 */
	@Id
	@Column(name="cfMediumId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The medium creation date.
	 */
	@Column(name="cfMediumCreationDate")
	private String mediumCreationDate;
	
	/**
	 * The size.
	 */
	@Column(name="cfSize")
	private Double size;
	
	/**
	 * The mimeType.
	 */
	@Column(name="cfMimeType")
	private String mimeType;
	
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
	@OneToMany(mappedBy="medium")
	private Set<MediumTitle> names;
	
	@OneToMany(mappedBy="medium")
	private Set<MediumKeyword> keywords;
	
	@OneToMany(mappedBy="medium")
	private Set<MediumDescription> descriptions;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="medium")
	private Set<Person_Medium> persons_medium;
	
	@OneToMany(mappedBy="medium")
	private Set<ResultPublication_Medium> resultPublications_medium;
	
	@OneToMany(mappedBy="medium")
	private Set<Service_Medium> services_mediums;
	
	@OneToMany(mappedBy="medium")
	private Set<Equipment_Medium> equipments_medium;
	
	@OneToMany(mappedBy="medium")
	private Set<Event_Medium> events_medium;
	
	@OneToMany(mappedBy="medium")
	private Set<Facility_Medium> facilities_medium;
	
	@OneToMany(mappedBy="medium")
	private Set<Medium_Funding> mediums_fundings;
	
	@OneToMany(mappedBy="medium")
	private Set<Medium_Indicator> mediums_indicators;
	
	@OneToMany(mappedBy="medium")
	private Set<Medium_Measurement> mediums_measurements;
	
	@OneToMany(mappedBy="medium1")
	private Set<Medium_Medium> mediums_mediums1;
	
	@OneToMany(mappedBy="medium2")
	private Set<Medium_Medium> mediums_mediums2;
	
	@OneToMany(mappedBy="medium")
	private Set<Project_Medium> projects_mediums;
	
	@OneToMany(mappedBy="medium")
	private Set<Medium_Class> mediums_classes;

	
	/**
	 * FederatedIdentifier entities related to Measurement instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//

	/**
	 * Default Constructor
	 */
	public Medium() {
		
	}
	
	/**
	 * 
	 * @param mediumCreationDate
	 * @param size
	 * @param mimeType
	 * @param uri
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public Medium(String mediumCreationDate, Double size, String mimeType,
			String uri, Set<MediumTitle> names, Set<MediumKeyword> keywords,
			Set<MediumDescription> descriptions) {
		this.mediumCreationDate = mediumCreationDate;
		this.size = size;
		this.mimeType = mimeType;
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
	 * @return the mediumCreationDate
	 */
	public String getMediumCreationDate() {
		return mediumCreationDate;
	}

	/**
	 * @param mediumCreationDate the mediumCreationDate to set
	 */
	public void setMediumCreationDate(String mediumCreationDate) {
		this.mediumCreationDate = mediumCreationDate;
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
	 * @return the size
	 */
	public Double getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Double size) {
		this.size = size;
	}

	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * @param mimeType the mimeType to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	/**
	 * @return the names
	 */
	public Set<MediumTitle> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(Set<MediumTitle> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public Set<MediumKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(Set<MediumKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public Set<MediumDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(Set<MediumDescription> descriptions) {
		this.descriptions = descriptions;
	}
	
	/**
	 * @return the persons_medium
	 */
	public Set<Person_Medium> getPersons_medium() {
		return persons_medium;
	}
	
	/**
	 * @param persons_medium the persons_medium to set
	 */
	public void setPersons_medium(
			Set<Person_Medium> persons_medium) {
		this.persons_medium = persons_medium;
	}
	
	/**
	 * @return the resultPublications_medium
	 */
	public Set<ResultPublication_Medium> getResultPublications_medium() {
		return resultPublications_medium;
	}

	/**
	 * @param resultPublications_medium the resultPublications_medium to set
	 */
	public void setResultPublications_medium(
			Set<ResultPublication_Medium> resultPublications_medium) {
		this.resultPublications_medium = resultPublications_medium;
	}

	/**
	 * @return the services_mediums
	 */
	public Set<Service_Medium> getServices_mediums() {
		return services_mediums;
	}

	/**
	 * @param services_mediums the services_mediums to set
	 */
	public void setServices_mediums(Set<Service_Medium> services_mediums) {
		this.services_mediums = services_mediums;
	}

	/**
	 * @return the equipments_medium
	 */
	public Set<Equipment_Medium> getEquipments_medium() {
		return equipments_medium;
	}

	/**
	 * @param equipments_medium the equipments_medium to set
	 */
	public void setEquipments_medium(Set<Equipment_Medium> equipments_medium) {
		this.equipments_medium = equipments_medium;
	}

	/**
	 * @return the events_medium
	 */
	public Set<Event_Medium> getEvents_medium() {
		return events_medium;
	}

	/**
	 * @param events_medium the events_medium to set
	 */
	public void setEvents_medium(Set<Event_Medium> events_medium) {
		this.events_medium = events_medium;
	}

	/**
	 * @return the facilities_medium
	 */
	public Set<Facility_Medium> getFacilities_medium() {
		return facilities_medium;
	}

	/**
	 * @param facilities_medium the facilities_medium to set
	 */
	public void setFacilities_medium(Set<Facility_Medium> facilities_medium) {
		this.facilities_medium = facilities_medium;
	}

	/**
	 * @return the mediums_fundings
	 */
	public Set<Medium_Funding> getMediums_fundings() {
		return mediums_fundings;
	}

	/**
	 * @param mediums_fundings the mediums_fundings to set
	 */
	public void setMediums_fundings(Set<Medium_Funding> mediums_fundings) {
		this.mediums_fundings = mediums_fundings;
	}

	/**
	 * @return the mediums_indicators
	 */
	public Set<Medium_Indicator> getMediums_indicators() {
		return mediums_indicators;
	}

	/**
	 * @param mediums_indicators the mediums_indicators to set
	 */
	public void setMediums_indicators(Set<Medium_Indicator> mediums_indicators) {
		this.mediums_indicators = mediums_indicators;
	}

	/**
	 * @return the mediums_measurements
	 */
	public Set<Medium_Measurement> getMediums_measurements() {
		return mediums_measurements;
	}

	/**
	 * @param mediums_measurements the mediums_measurements to set
	 */
	public void setMediums_measurements(Set<Medium_Measurement> mediums_measurements) {
		this.mediums_measurements = mediums_measurements;
	}

	/**
	 * @return the mediums_mediums1
	 */
	public Set<Medium_Medium> getMediums_mediums1() {
		return mediums_mediums1;
	}

	/**
	 * @param mediums_mediums1 the mediums_mediums1 to set
	 */
	public void setMediums_mediums1(Set<Medium_Medium> mediums_mediums1) {
		this.mediums_mediums1 = mediums_mediums1;
	}

	/**
	 * @return the mediums_mediums2
	 */
	public Set<Medium_Medium> getMediums_mediums2() {
		return mediums_mediums2;
	}

	/**
	 * @param mediums_mediums2 the mediums_mediums2 to set
	 */
	public void setMediums_mediums2(Set<Medium_Medium> mediums_mediums2) {
		this.mediums_mediums2 = mediums_mediums2;
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
	 * @return the mediums_classes
	 */
	public Set<Medium_Class> getMediums_classes() {
		return mediums_classes;
	}

	/**
	 * @param mediums_classes the mediums_classes to set
	 */
	public void setMediums_classes(Set<Medium_Class> mediums_classes) {
		this.mediums_classes = mediums_classes;
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
		Medium other = (Medium) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Medium [id=" + id + ", mediumCreationDate="
				+ mediumCreationDate + ", size=" + size + ", mimeType="
				+ mimeType + ", uri=" + uri + ", uuid=" + uuid + "]";
	}


}

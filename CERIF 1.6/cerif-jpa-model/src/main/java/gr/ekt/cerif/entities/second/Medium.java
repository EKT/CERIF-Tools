/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.Citation_Medium;
import gr.ekt.cerif.entities.link.Equipment_Medium;
import gr.ekt.cerif.entities.link.Event_Medium;
import gr.ekt.cerif.entities.link.Facility_Medium;
import gr.ekt.cerif.entities.link.Medium_Class;
import gr.ekt.cerif.entities.link.Medium_Funding;
import gr.ekt.cerif.entities.link.Medium_Indicator;
import gr.ekt.cerif.entities.link.Medium_Measurement;
import gr.ekt.cerif.entities.link.Medium_Medium;
import gr.ekt.cerif.entities.link.Service_Medium;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Medium;
import gr.ekt.cerif.entities.link.person.Person_Medium;
import gr.ekt.cerif.entities.link.project.Project_Medium;
import gr.ekt.cerif.entities.link.result.ResultPatent_Medium;
import gr.ekt.cerif.entities.link.result.ResultProduct_Medium;
import gr.ekt.cerif.entities.link.result.ResultPublication_Medium;
import gr.ekt.cerif.features.multilingual.MediumDescription;
import gr.ekt.cerif.features.multilingual.MediumKeyword;
import gr.ekt.cerif.features.multilingual.MediumTitle;

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
 * Represents a medium second level entity.
 * 
 */
@Entity
@Table(name="cfMedium")
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
	private Set<MediumTitle> mediumTitles;
	
	@OneToMany(mappedBy="medium")
	private Set<MediumKeyword> mediumKeywords;
	
	@OneToMany(mappedBy="medium")
	private Set<MediumDescription> mediumDescriptions;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="medium")
	private Set<Person_Medium> persons_mediums;
	
	@OneToMany(mappedBy="medium")
	private Set<ResultPublication_Medium> resultPublications_mediums;
	
	@OneToMany(mappedBy="medium")
	private Set<Service_Medium> services_mediums;
	
	@OneToMany(mappedBy="medium")
	private Set<Equipment_Medium> equipments_mediums;
	
	@OneToMany(mappedBy="medium")
	private Set<Event_Medium> events_mediums;
	
	@OneToMany(mappedBy="medium")
	private Set<Facility_Medium> facilities_mediums;
	
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
	private Set<OrganisationUnit_Medium> organisationUnits_mediums;
	
	@OneToMany(mappedBy="medium")
	private Set<Medium_Class> mediums_classes;
	
	@OneToMany(mappedBy="medium")
	private Set<ResultPatent_Medium> resultPatents_mediums;
	
	@OneToMany(mappedBy="medium")
	private Set<ResultProduct_Medium> resultProducts_mediums;
	
	@OneToMany(mappedBy="medium")
	private Set<Citation_Medium> citations_mediums;

	
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
	 * @return the mediumTitles
	 */
	public Set<MediumTitle> getMediumTitles() {
		return mediumTitles;
	}

	/**
	 * @param mediumTitles the mediumTitles to set
	 */
	public void setMediumTitles(Set<MediumTitle> mediumTitles) {
		this.mediumTitles = mediumTitles;
	}

	/**
	 * @return the mediumKeywords
	 */
	public Set<MediumKeyword> getMediumKeywords() {
		return mediumKeywords;
	}

	/**
	 * @param mediumKeywords the mediumKeywords to set
	 */
	public void setMediumKeywords(Set<MediumKeyword> mediumKeywords) {
		this.mediumKeywords = mediumKeywords;
	}

	/**
	 * @return the mediumDescriptions
	 */
	public Set<MediumDescription> getMediumDescriptions() {
		return mediumDescriptions;
	}

	/**
	 * @param mediumDescriptions the mediumDescriptions to set
	 */
	public void setMediumDescriptions(Set<MediumDescription> mediumDescriptions) {
		this.mediumDescriptions = mediumDescriptions;
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
	 * @return the persons_mediums
	 */
	public Set<Person_Medium> getPersons_mediums() {
		return persons_mediums;
	}

	/**
	 * @param persons_mediums the persons_mediums to set
	 */
	public void setPersons_mediums(Set<Person_Medium> persons_mediums) {
		this.persons_mediums = persons_mediums;
	}

	/**
	 * @return the resultPublications_mediums
	 */
	public Set<ResultPublication_Medium> getResultPublications_mediums() {
		return resultPublications_mediums;
	}

	/**
	 * @param resultPublications_mediums the resultPublications_mediums to set
	 */
	public void setResultPublications_mediums(
			Set<ResultPublication_Medium> resultPublications_mediums) {
		this.resultPublications_mediums = resultPublications_mediums;
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
	 * @return the equipments_mediums
	 */
	public Set<Equipment_Medium> getEquipments_mediums() {
		return equipments_mediums;
	}

	/**
	 * @param equipments_mediums the equipments_mediums to set
	 */
	public void setEquipments_mediums(Set<Equipment_Medium> equipments_mediums) {
		this.equipments_mediums = equipments_mediums;
	}

	/**
	 * @return the events_mediums
	 */
	public Set<Event_Medium> getEvents_mediums() {
		return events_mediums;
	}

	/**
	 * @param events_mediums the events_mediums to set
	 */
	public void setEvents_mediums(Set<Event_Medium> events_mediums) {
		this.events_mediums = events_mediums;
	}

	/**
	 * @return the facilities_mediums
	 */
	public Set<Facility_Medium> getFacilities_mediums() {
		return facilities_mediums;
	}

	/**
	 * @param facilities_mediums the facilities_mediums to set
	 */
	public void setFacilities_mediums(Set<Facility_Medium> facilities_mediums) {
		this.facilities_mediums = facilities_mediums;
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
	 * @return the organisationUnits_mediums
	 */
	public Set<OrganisationUnit_Medium> getOrganisationUnits_mediums() {
		return organisationUnits_mediums;
	}

	/**
	 * @param organisationUnits_mediums the organisationUnits_mediums to set
	 */
	public void setOrganisationUnits_mediums(
			Set<OrganisationUnit_Medium> organisationUnits_mediums) {
		this.organisationUnits_mediums = organisationUnits_mediums;
	}

	/**
	 * @return the resultPatents_mediums
	 */
	public Set<ResultPatent_Medium> getResultPatents_mediums() {
		return resultPatents_mediums;
	}

	/**
	 * @param resultPatents_mediums the resultPatents_mediums to set
	 */
	public void setResultPatents_mediums(
			Set<ResultPatent_Medium> resultPatents_mediums) {
		this.resultPatents_mediums = resultPatents_mediums;
	}

	/**
	 * @return the resultProducts_mediums
	 */
	public Set<ResultProduct_Medium> getResultProducts_mediums() {
		return resultProducts_mediums;
	}

	/**
	 * @param resultProducts_mediums the resultProducts_mediums to set
	 */
	public void setResultProducts_mediums(
			Set<ResultProduct_Medium> resultProducts_mediums) {
		this.resultProducts_mediums = resultProducts_mediums;
	}

	/**
	 * @return the citations_mediums
	 */
	public Set<Citation_Medium> getCitations_mediums() {
		return citations_mediums;
	}

	/**
	 * @param citations_mediums the citations_mediums to set
	 */
	public void setCitations_mediums(Set<Citation_Medium> citations_mediums) {
		this.citations_mediums = citations_mediums;
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
		Medium other = (Medium) obj;
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
		return "Medium [id=" + id + ", mediumCreationDate="
				+ mediumCreationDate + ", size=" + size + ", mimeType="
				+ mimeType + ", uri=" + uri + ", uuid=" + uuid + "]";
	}


}

/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.Equipment_Measurement;
import gr.ekt.cerif.entities.link.Event_Measurement;
import gr.ekt.cerif.entities.link.Facility_Measurement;
import gr.ekt.cerif.entities.link.Indicator_Measurement;
import gr.ekt.cerif.entities.link.Measurement_Class;
import gr.ekt.cerif.entities.link.Measurement_Measurement;
import gr.ekt.cerif.entities.link.Medium_Measurement;
import gr.ekt.cerif.entities.link.Service_Measurement;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Measurement;
import gr.ekt.cerif.entities.link.person.Person_Measurement;
import gr.ekt.cerif.entities.link.project.Project_Measurement;
import gr.ekt.cerif.entities.link.result.ResultPatent_Measurement;
import gr.ekt.cerif.entities.link.result.ResultProduct_Measurement;
import gr.ekt.cerif.entities.link.result.ResultPublication_Measurement;
import gr.ekt.cerif.features.multilingual.MeasurementDescription;
import gr.ekt.cerif.features.multilingual.MeasurementKeyword;
import gr.ekt.cerif.features.multilingual.MeasurementName;

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
@Table(name="cfMeas")
public class Measurement implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 3381530078195219172L;	
	
	/**
	 * The Measurement id.
	 */
	@Id
	@Column(name="cfMeasId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The counter.
	 */
	@Column(name="cfCountInt")
	private Integer counter;
	
	/**
	 * The valFloatP.
	 */
	@Column(name="cfValFloatP")
	private Double valFloatP;
	
	/**
	 * The valJudgeNum.
	 */
	@Column(name="cfValJudgeNum")
	private Double valJudgeNum;
	
	/**
	 * The countIntChange.
	 */
	@Column(name="cfCountIntChange")
	private Integer countIntChange;
	
	/**
	 * The countFloatPChange.
	 */
	@Column(name="cfCountFloatPChange")
	private Double countFloatPChange;
	
	/**
	 * The valJudgeNumChange.
	 */
	@Column(name="cfValJudgeNumChange")
	private Double valJudgeNumChange;
	
	/**
	 * The valJudgeText.
	 */
	@Column(name="cfValJudgeText", length=10000)
	private String valJudgeText;
	
	/**
	 * The valJudgeText.
	 */
	@Column(name="cfValJudgeTextChange", length=10000)
	private String valJudgeTextChange;
	
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
	@OneToMany(mappedBy="measurement")
	private Set<MeasurementName> measurementNames;
	
	@OneToMany(mappedBy="measurement")
	private Set<MeasurementKeyword> measurementKeywords;
	
	@OneToMany(mappedBy="measurement")
	private Set<MeasurementDescription> measurementDescriptions;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="measurement")
	private Set<Measurement_Class> measurements_classes;
	
	@OneToMany(mappedBy="measurement")
	private Set<ResultPatent_Measurement> resultPatents_measurements;
	
	@OneToMany(mappedBy="measurement")
	private Set<ResultProduct_Measurement> resultProducts_measurements;
	
	@OneToMany(mappedBy="measurement")
	private Set<Facility_Measurement> facilities_measurements;
	
	@OneToMany(mappedBy="measurement")
	private Set<ResultPublication_Measurement> resultPublications_measurements;
	
	@OneToMany(mappedBy="measurement")
	private Set<Service_Measurement> services_measurements;
	
	@OneToMany(mappedBy="measurement")
	private Set<Equipment_Measurement> equipments_measurements;
	
	@OneToMany(mappedBy="measurement")
	private Set<Medium_Measurement> mediums_measurements;
	
	@OneToMany(mappedBy="measurement")
	private Set<Indicator_Measurement> indicators_measurements;
	
	@OneToMany(mappedBy="measurement")
	private Set<Person_Measurement> persons_measurements;
	
	@OneToMany(mappedBy="measurement")
	private Set<OrganisationUnit_Measurement> organisationUnits_measurements;
	
	@OneToMany(mappedBy="measurement")
	private Set<Project_Measurement> projects_measurements;
	
	@OneToMany(mappedBy="measurement")
	private Set<Event_Measurement> events_measurements;
	
	@OneToMany(mappedBy="measurement1")
	private Set<Measurement_Measurement> measurements_measurements1;
	
	@OneToMany(mappedBy="measurement2")
	private Set<Measurement_Measurement> measurements_measurements2;

	
	/**
	 * FederatedIdentifier entities related to OrganisationUnit instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//

	/**
	 * Default Constructor
	 */
	public Measurement() {
		
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
	 * @return the counter
	 */
	public Integer getCounter() {
		return counter;
	}

	/**
	 * @param counter the counter to set
	 */
	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	/**
	 * @return the valFloatP
	 */
	public Double getValFloatP() {
		return valFloatP;
	}

	/**
	 * @param valFloatP the valFloatP to set
	 */
	public void setValFloatP(Double valFloatP) {
		this.valFloatP = valFloatP;
	}

	/**
	 * @return the valJudgeNum
	 */
	public Double getValJudgeNum() {
		return valJudgeNum;
	}

	/**
	 * @param valJudgeNum the valJudgeNum to set
	 */
	public void setValJudgeNum(Double valJudgeNum) {
		this.valJudgeNum = valJudgeNum;
	}

	/**
	 * @return the countIntChange
	 */
	public Integer getCountIntChange() {
		return countIntChange;
	}

	/**
	 * @param countIntChange the countIntChange to set
	 */
	public void setCountIntChange(Integer countIntChange) {
		this.countIntChange = countIntChange;
	}

	/**
	 * @return the countFloatPChange
	 */
	public Double getCountFloatPChange() {
		return countFloatPChange;
	}

	/**
	 * @param countFloatPChange the countFloatPChange to set
	 */
	public void setCountFloatPChange(Double countFloatPChange) {
		this.countFloatPChange = countFloatPChange;
	}

	/**
	 * @return the valJudgeNumChange
	 */
	public Double getValJudgeNumChange() {
		return valJudgeNumChange;
	}

	/**
	 * @param valJudgeNumChange the valJudgeNumChange to set
	 */
	public void setValJudgeNumChange(Double valJudgeNumChange) {
		this.valJudgeNumChange = valJudgeNumChange;
	}

	/**
	 * @return the valJudgeText
	 */
	public String getValJudgeText() {
		return valJudgeText;
	}

	/**
	 * @param valJudgeText the valJudgeText to set
	 */
	public void setValJudgeText(String valJudgeText) {
		this.valJudgeText = valJudgeText;
	}

	/**
	 * @return the valJudgeTextChange
	 */
	public String getValJudgeTextChange() {
		return valJudgeTextChange;
	}

	/**
	 * @param valJudgeTextChange the valJudgeTextChange to set
	 */
	public void setValJudgeTextChange(String valJudgeTextChange) {
		this.valJudgeTextChange = valJudgeTextChange;
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
	 * @return the measurementNames
	 */
	public Set<MeasurementName> getMeasurementNames() {
		return measurementNames;
	}

	/**
	 * @param measurementNames the measurementNames to set
	 */
	public void setMeasurementNames(Set<MeasurementName> measurementNames) {
		this.measurementNames = measurementNames;
	}

	/**
	 * @return the measurementKeywords
	 */
	public Set<MeasurementKeyword> getMeasurementKeywords() {
		return measurementKeywords;
	}

	/**
	 * @param measurementKeywords the measurementKeywords to set
	 */
	public void setMeasurementKeywords(Set<MeasurementKeyword> measurementKeywords) {
		this.measurementKeywords = measurementKeywords;
	}
	
	/**
	 * @return the measurementDescriptions
	 */
	public Set<MeasurementDescription> getMeasurementDescriptions() {
		return measurementDescriptions;
	}

	/**
	 * @param measurementDescriptions the measurementDescriptions to set
	 */
	public void setMeasurementDescriptions(
			Set<MeasurementDescription> measurementDescriptions) {
		this.measurementDescriptions = measurementDescriptions;
	}

	/**
	 * @return the measurements_classes
	 */
	public Set<Measurement_Class> getMeasurements_classes() {
		return measurements_classes;
	}

	/**
	 * @param measurements_classes the measurements_classes to set
	 */
	public void setMeasurements_classes(Set<Measurement_Class> measurements_classes) {
		this.measurements_classes = measurements_classes;
	}

	/**
	 * @return the resultPatents_measurements
	 */
	public Set<ResultPatent_Measurement> getResultPatents_measurements() {
		return resultPatents_measurements;
	}
	
	/**
	 * @param resultPatents_measurements the resultPatents_measurements to set
	 */
	public void setResultPatents_measurements(
			Set<ResultPatent_Measurement> resultPatents_measurements) {
		this.resultPatents_measurements = resultPatents_measurements;
	}
	
	/**
	 * @return the resultProducts_measurements
	 */
	public Set<ResultProduct_Measurement> getResultProducts_measurements() {
		return resultProducts_measurements;
	}
	
	/**
	 * @param resultProducts_measurements the resultProducts_measurements to set
	 */
	public void setResultProducts_measurements(
			Set<ResultProduct_Measurement> resultProducts_measurements) {
		this.resultProducts_measurements = resultProducts_measurements;
	}
	
	/**
	 * @return the facilities_measurements
	 */
	public Set<Facility_Measurement> getFacilities_measurements() {
		return facilities_measurements;
	}

	/**
	 * @param facilities_measurements the facilities_measurements to set
	 */
	public void setFacilities_measurements(
			Set<Facility_Measurement> facilities_measurements) {
		this.facilities_measurements = facilities_measurements;
	}

	/**
	 * @return the resultPublications_measurements
	 */
	public Set<ResultPublication_Measurement> getResultPublications_measurements() {
		return resultPublications_measurements;
	}
	
	/**
	 * @param resultPublications_measurements the resultPublications_measurements to set
	 */
	public void setResultPublications_measurements(
			Set<ResultPublication_Measurement> resultPublications_measurements) {
		this.resultPublications_measurements = resultPublications_measurements;
	}

	/**
	 * @return the services_measurements
	 */
	public Set<Service_Measurement> getServices_measurements() {
		return services_measurements;
	}

	/**
	 * @param services_measurements the services_measurements to set
	 */
	public void setServices_measurements(
			Set<Service_Measurement> services_measurements) {
		this.services_measurements = services_measurements;
	}

	/**
	 * @return the equipments_measurements
	 */
	public Set<Equipment_Measurement> getEquipments_measurements() {
		return equipments_measurements;
	}

	/**
	 * @param equipments_measurements the equipments_measurements to set
	 */
	public void setEquipments_measurements(
			Set<Equipment_Measurement> equipments_measurements) {
		this.equipments_measurements = equipments_measurements;
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
	 * @return the indicators_measurements
	 */
	public Set<Indicator_Measurement> getIndicators_measurements() {
		return indicators_measurements;
	}

	/**
	 * @param indicators_measurements the indicators_measurements to set
	 */
	public void setIndicators_measurements(
			Set<Indicator_Measurement> indicators_measurements) {
		this.indicators_measurements = indicators_measurements;
	}

	/**
	 * @return the persons_measurements
	 */
	public Set<Person_Measurement> getPersons_measurements() {
		return persons_measurements;
	}

	/**
	 * @param persons_measurements the persons_measurements to set
	 */
	public void setPersons_measurements(Set<Person_Measurement> persons_measurements) {
		this.persons_measurements = persons_measurements;
	}

	/**
	 * @return the organisationUnits_measurements
	 */
	public Set<OrganisationUnit_Measurement> getOrganisationUnits_measurements() {
		return organisationUnits_measurements;
	}

	/**
	 * @param organisationUnits_measurements the organisationUnits_measurements to set
	 */
	public void setOrganisationUnits_measurements(
			Set<OrganisationUnit_Measurement> organisationUnits_measurements) {
		this.organisationUnits_measurements = organisationUnits_measurements;
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
	 * @return the events_measurements
	 */
	public Set<Event_Measurement> getEvents_measurements() {
		return events_measurements;
	}

	/**
	 * @param events_measurements the events_measurements to set
	 */
	public void setEvents_measurements(Set<Event_Measurement> events_measurements) {
		this.events_measurements = events_measurements;
	}

	/**
	 * @return the measurements_measurements1
	 */
	public Set<Measurement_Measurement> getMeasurements_measurements1() {
		return measurements_measurements1;
	}

	/**
	 * @param measurements_measurements1 the measurements_measurements1 to set
	 */
	public void setMeasurements_measurements1(
			Set<Measurement_Measurement> measurements_measurements1) {
		this.measurements_measurements1 = measurements_measurements1;
	}

	/**
	 * @return the measurements_measurements2
	 */
	public Set<Measurement_Measurement> getMeasurements_measurements2() {
		return measurements_measurements2;
	}

	/**
	 * @param measurements_measurements2 the measurements_measurements2 to set
	 */
	public void setMeasurements_measurements2(
			Set<Measurement_Measurement> measurements_measurements2) {
		this.measurements_measurements2 = measurements_measurements2;
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
		Measurement other = (Measurement) obj;
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
		return "Measurement [id=" + id + ", counter=" + counter
				+ ", valFloatP=" + valFloatP + ", valJudgeNum=" + valJudgeNum
				+ ", countIntChange=" + countIntChange + ", countFloatPChange="
				+ countFloatPChange + ", valJudgeNumChange="
				+ valJudgeNumChange + ", valJudgeText=" + valJudgeText
				+ ", valJudgeTextChange=" + valJudgeTextChange + ", uri=" + uri
				+ ", uuid=" + uuid + "]";
	}


}

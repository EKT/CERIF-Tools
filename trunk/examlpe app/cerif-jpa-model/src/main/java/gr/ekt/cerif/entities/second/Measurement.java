/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.Facility_Measurement;
import gr.ekt.cerif.entities.link.Service_Measurement;
import gr.ekt.cerif.entities.link.result.ResultPatent_Measurement;
import gr.ekt.cerif.entities.link.result.ResultProduct_Measurement;
import gr.ekt.cerif.entities.link.result.ResultPublication_Measurement;
import gr.ekt.cerif.features.multilingual.MeasurementDescription;
import gr.ekt.cerif.features.multilingual.MeasurementKeyword;
import gr.ekt.cerif.features.multilingual.MeasurementName;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


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
	@Column(name="cfValJudgeText")
	private String valJudgeText;
	
	/**
	 * The valJudgeText.
	 */
	@Column(name="cfValJudgeTextChange")
	private String valJudgeTextChange;
	
	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	@OneToMany(mappedBy="measurement")
	private Set<ResultPatent_Measurement> resultPatents_measurements;
	
	@OneToMany(mappedBy="measurement")
	private Set<ResultProduct_Measurement> resultProducts_measurements;
	
	@OneToMany(mappedBy="measurement")
	private Set<Facility_Measurement> facility_measurements;
	
	@OneToMany(mappedBy="measurement")
	private Set<MeasurementName> names;
	
	@OneToMany(mappedBy="measurement")
	private Set<MeasurementKeyword> keywords;
	
	@OneToMany(mappedBy="measurement")
	private Set<MeasurementDescription> descriptions;
	
	@OneToMany(mappedBy="measurement")
	private Set<ResultPublication_Measurement> resultPublications_measurements;
	
	@OneToMany(mappedBy="measurement")
	private Set<Service_Measurement> services_measurements;

	/**
	 * Default Constructor
	 */
	public Measurement() {
		
	}
	
	/**
	 * 
	 * @param counter
	 * @param valFloatP
	 * @param valJudgeNum
	 * @param countIntChange
	 * @param countFloatPChange
	 * @param valJudgeNumChange
	 * @param valJudgeText
	 * @param valJudgeTextChange
	 * @param uri
	 * @param resultPatents_measurements
	 * @param resultProducts_measurements
	 * @param names
	 * @param keywords
	 * @param descriptions
	 * @param resultPublications_measurements
	 */
	public Measurement(Integer counter, Double valFloatP, Double valJudgeNum,
			Integer countIntChange, Double countFloatPChange,
			Double valJudgeNumChange, String valJudgeText,
			String valJudgeTextChange, String uri,
			Set<ResultPatent_Measurement> resultPatents_measurements,
			Set<ResultProduct_Measurement> resultProducts_measurements,
			Set<MeasurementName> names, Set<MeasurementKeyword> keywords,
			Set<MeasurementDescription> descriptions,
			Set<ResultPublication_Measurement> resultPublications_measurements) {
		this.counter = counter;
		this.valFloatP = valFloatP;
		this.valJudgeNum = valJudgeNum;
		this.countIntChange = countIntChange;
		this.countFloatPChange = countFloatPChange;
		this.valJudgeNumChange = valJudgeNumChange;
		this.valJudgeText = valJudgeText;
		this.valJudgeTextChange = valJudgeTextChange;
		this.uri = uri;
		this.resultPatents_measurements = resultPatents_measurements;
		this.resultProducts_measurements = resultProducts_measurements;
		this.names = names;
		this.keywords = keywords;
		this.descriptions = descriptions;
		this.resultPublications_measurements = resultPublications_measurements;
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
	 * @return the names
	 */
	public Set<MeasurementName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(Set<MeasurementName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public Set<MeasurementKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(Set<MeasurementKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public Set<MeasurementDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(Set<MeasurementDescription> descriptions) {
		this.descriptions = descriptions;
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
	
}

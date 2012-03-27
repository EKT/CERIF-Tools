/**
 * 
 */
package gr.ekt.cerif.entities.result;

import gr.ekt.cerif.entities.link.person.Person_ResultPatent;
import gr.ekt.cerif.entities.link.project.Project_ResultPatent;
import gr.ekt.cerif.entities.link.result.ResultPatent_Class;
import gr.ekt.cerif.entities.link.result.ResultPatent_Funding;
import gr.ekt.cerif.entities.link.result.ResultPatent_Indicator;
import gr.ekt.cerif.entities.link.result.ResultPatent_Measurement;
import gr.ekt.cerif.entities.link.result.ResultPatent_ResultPatent;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPatent;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.features.multilingual.ResultPatentAbstract;
import gr.ekt.cerif.features.multilingual.ResultPatentKeyword;
import gr.ekt.cerif.features.multilingual.ResultPatentTitle;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents a patent result entity.
 * 
 */
@Entity
@Table(name="cfResPat")
public class ResultPatent implements CerifResultEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -1523634389757097712L;

	/**
	 * The patent unique identifier.
	 */
	@Id
	@Column(name="cfResPatId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The patent country.
	 */
	@Column(name="cfCountryCode")
	private Country country;
	
	/**
	 * The date of patent registration.
	 */
	@Column(name="cfRegistrDate")
	private Date registrationDate;

	/**
	 * The date of patent approval.
	 */
	@Column(name="cfApprovDate")
	private Date approvalDate;

	/**
	 * The patent number.
	 */
	@Column(name="cfPatentNum")
	private String number;
	
	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	/**
	 * The result patent titles.
	 */
	@OneToMany(mappedBy="resultPatent", fetch=FetchType.EAGER)
	private Set<ResultPatentTitle> resultPatentTitles;
	
	/**
	 * The result patent abstracts.
	 */
	@OneToMany(mappedBy="resultPatent", fetch=FetchType.EAGER)
	private Set<ResultPatentAbstract> resultPatentAbstracts;
	
	/**
	 * The result patent keywords.
	 */
	@OneToMany(mappedBy="resultPatent", fetch=FetchType.EAGER)
	private Set<ResultPatentKeyword> resultPatentKeywords;
	
	@OneToMany(mappedBy="resultPatent", fetch=FetchType.EAGER)
	private Set<ResultPatentKeyword> resultPatentVersionInfos;
	
	/**
	 * The link entities of projects and resultPatents.
	 */
	@OneToMany(mappedBy="resultPatent")
	private Set<Project_ResultPatent> projects_resultPatents;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<Person_ResultPatent> persons_resultPatents;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPatent_Class> resultPatents_classes;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPatent_Funding> resultPatents_fundings;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPatent_Indicator> resultPatents_indicators;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPatent_Measurement> resultPatents_measurements;
	
	@OneToMany(mappedBy="resultPatent1")
	private Set<ResultPatent_ResultPatent> resultPatents1_resultPatents;

	@OneToMany(mappedBy="resultPatent2")
	private Set<ResultPatent_ResultPatent> resultPatents2_resultPatents;
	
	@OneToMany(mappedBy="resultPatent")
	private Set<ResultPublication_ResultPatent> resultPublications_resultPatents;

	
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
	 * Returns the country.
	 * @return the country.
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 * @param country the country.
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * Returns the registration date.
	 * @return the registration date.
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * Sets the registration date.
	 * @param registrationDate the registration date.
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * Returns the approval date.
	 * @return the approval date.
	 */
	public Date getApprovalDate() {
		return approvalDate;
	}

	/**
	 * Sets the approval date.
	 * @param approvalDate the approval date.
	 */
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	/**
	 * Returns the number.
	 * @return the number.
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 * @param number the number.
	 */
	public void setNumber(String number) {
		this.number = number;
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

	public Set<ResultPatentTitle> getResultPatentTitles() {
		return resultPatentTitles;
	}

	public void setResultPatentTitles(Set<ResultPatentTitle> resultPatentTitles) {
		this.resultPatentTitles = resultPatentTitles;
	}

	public Set<ResultPatentAbstract> getResultPatentAbstracts() {
		return resultPatentAbstracts;
	}

	public void setResultPatentAbstracts(Set<ResultPatentAbstract> resultPatentAbstracts) {
		this.resultPatentAbstracts = resultPatentAbstracts;
	}

	public Set<ResultPatentKeyword> getResultPatentKeywords() {
		return resultPatentKeywords;
	}

	public void setResultPatentKeywords(Set<ResultPatentKeyword> resultPatentKeywords) {
		this.resultPatentKeywords = resultPatentKeywords;
	}

	public Set<ResultPatentKeyword> getResultPatentVersionInfos() {
		return resultPatentVersionInfos;
	}

	public void setResultPatentVersionInfos(Set<ResultPatentKeyword> resultPatentVersionInfos) {
		this.resultPatentVersionInfos = resultPatentVersionInfos;
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
	 * @return the persons_resultPatents
	 */
	public Set<Person_ResultPatent> getPersons_resultPatents() {
		return persons_resultPatents;
	}
	
	/**
	 * @param persons_resultPatents the persons_resultPatents to set
	 */
	public void setPersons_resultPatents(
			Set<Person_ResultPatent> persons_resultPatents) {
		this.persons_resultPatents = persons_resultPatents;
	}
	
	/**
	 * @return the resultPatents_classes
	 */
	public Set<ResultPatent_Class> getResultPatents_classes() {
		return resultPatents_classes;
	}
	
	/**
	 * @param resultPatents_classes the resultPatents_classes to set
	 */
	public void setResultPatents_classes(
			Set<ResultPatent_Class> resultPatents_classes) {
		this.resultPatents_classes = resultPatents_classes;
	}

	/**
	 * @return the resultPatents_fundings
	 */
	public Set<ResultPatent_Funding> getResultPatents_fundings() {
		return resultPatents_fundings;
	}

	/**
	 * @param resultPatents_fundings the resultPatents_fundings to set
	 */
	public void setResultPatents_fundings(
			Set<ResultPatent_Funding> resultPatents_fundings) {
		this.resultPatents_fundings = resultPatents_fundings;
	}

	/**
	 * @return the resultPatents_indicators
	 */
	public Set<ResultPatent_Indicator> getResultPatents_indicators() {
		return resultPatents_indicators;
	}

	/**
	 * @param resultPatents_indicators the resultPatents_indicators to set
	 */
	public void setResultPatents_indicators(
			Set<ResultPatent_Indicator> resultPatents_indicators) {
		this.resultPatents_indicators = resultPatents_indicators;
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
	 * @return the resultPatents1_resultPatents
	 */
	public Set<ResultPatent_ResultPatent> getResultPatents1_resultPatents() {
		return resultPatents1_resultPatents;
	}
	
	/**
	 * @param resultPatents1_resultPatents the resultPatents1_resultPatents to set
	 */
	public void setResultPatents1_resultPatents(
			Set<ResultPatent_ResultPatent> resultPatents1_resultPatents) {
		this.resultPatents1_resultPatents = resultPatents1_resultPatents;
	}
	
	/**
	 * @return the resultPatents2_resultPatents
	 */
	public Set<ResultPatent_ResultPatent> getResultPatents2_resultPatents() {
		return resultPatents2_resultPatents;
	}
	
	/**
	 * @param resultPatents2_resultPatents the resultPatents2_resultPatents to set
	 */
	public void setResultPatents2_resultPatents(
			Set<ResultPatent_ResultPatent> resultPatents2_resultPatents) {
		this.resultPatents2_resultPatents = resultPatents2_resultPatents;
	}
	
	/**
	 * @return the resultPublications_resultPatents
	 */
	public Set<ResultPublication_ResultPatent> getResultPublications_resultPatents() {
		return resultPublications_resultPatents;
	}
	
	/**
	 * @param resultPublications_resultPatents the resultPublications_resultPatents to set
	 */
	public void setResultPublications_resultPatents(
			Set<ResultPublication_ResultPatent> resultPublications_resultPatents) {
		this.resultPublications_resultPatents = resultPublications_resultPatents;
	}
	
}

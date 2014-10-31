/**
 * 
 */
package gr.ekt.cerif.entities.second;


import gr.ekt.cerif.entities.link.Language_Class;
import gr.ekt.cerif.entities.link.person.Person_Language;
import gr.ekt.cerif.features.multilingual.CitationDescription;
import gr.ekt.cerif.features.multilingual.CitationTitle;
import gr.ekt.cerif.features.multilingual.ClassDefinition;
import gr.ekt.cerif.features.multilingual.ClassDescription;
import gr.ekt.cerif.features.multilingual.ClassEx;
import gr.ekt.cerif.features.multilingual.ClassSchemeDescription;
import gr.ekt.cerif.features.multilingual.ClassSchemeName;
import gr.ekt.cerif.features.multilingual.ClassTerm;
import gr.ekt.cerif.features.multilingual.CountryName;
import gr.ekt.cerif.features.multilingual.CurrencyEntityName;
import gr.ekt.cerif.features.multilingual.CurrencyName;
import gr.ekt.cerif.features.multilingual.EquipmentDescription;
import gr.ekt.cerif.features.multilingual.EquipmentKeyword;
import gr.ekt.cerif.features.multilingual.EquipmentName;
import gr.ekt.cerif.features.multilingual.EventDescription;
import gr.ekt.cerif.features.multilingual.EventKeyword;
import gr.ekt.cerif.features.multilingual.EventName;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsDescription;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsKeyword;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsName;
import gr.ekt.cerif.features.multilingual.FacilityDescription;
import gr.ekt.cerif.features.multilingual.FacilityKeyword;
import gr.ekt.cerif.features.multilingual.FacilityName;
import gr.ekt.cerif.features.multilingual.FundingDescription;
import gr.ekt.cerif.features.multilingual.FundingKeyword;
import gr.ekt.cerif.features.multilingual.FundingName;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxDescription;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxKeyword;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxName;
import gr.ekt.cerif.features.multilingual.IndicatorDescription;
import gr.ekt.cerif.features.multilingual.IndicatorKeyword;
import gr.ekt.cerif.features.multilingual.IndicatorName;
import gr.ekt.cerif.features.multilingual.LanguageName;
import gr.ekt.cerif.features.multilingual.MeasurementDescription;
import gr.ekt.cerif.features.multilingual.MeasurementKeyword;
import gr.ekt.cerif.features.multilingual.MeasurementName;
import gr.ekt.cerif.features.multilingual.MediumDescription;
import gr.ekt.cerif.features.multilingual.MediumKeyword;
import gr.ekt.cerif.features.multilingual.MediumTitle;
import gr.ekt.cerif.features.multilingual.MetricsDescription;
import gr.ekt.cerif.features.multilingual.MetricsKeyword;
import gr.ekt.cerif.features.multilingual.MetricsName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitKeyword;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitResearchActivity;
import gr.ekt.cerif.features.multilingual.PrizeDescription;
import gr.ekt.cerif.features.multilingual.PrizeKeyword;
import gr.ekt.cerif.features.multilingual.PrizeName;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;
import gr.ekt.cerif.features.multilingual.ProjectKeyword;
import gr.ekt.cerif.features.multilingual.ProjectTitle;
import gr.ekt.cerif.features.multilingual.QualificationDescription;
import gr.ekt.cerif.features.multilingual.QualificationKeyword;
import gr.ekt.cerif.features.multilingual.QualificationTitle;
import gr.ekt.cerif.features.multilingual.ResultPatentAbstract;
import gr.ekt.cerif.features.multilingual.ResultPatentKeyword;
import gr.ekt.cerif.features.multilingual.ResultPatentTitle;
import gr.ekt.cerif.features.multilingual.ResultProductDescription;
import gr.ekt.cerif.features.multilingual.ResultProductKeyword;
import gr.ekt.cerif.features.multilingual.ResultProductName;
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;
import gr.ekt.cerif.features.multilingual.ResultPublicationBibliographicNote;
import gr.ekt.cerif.features.multilingual.ResultPublicationKeyword;
import gr.ekt.cerif.features.multilingual.ResultPublicationNameAbbreviation;
import gr.ekt.cerif.features.multilingual.ResultPublicationSubtitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationVersionInfo;
import gr.ekt.cerif.features.multilingual.ServiceDescription;
import gr.ekt.cerif.features.multilingual.ServiceKeyword;
import gr.ekt.cerif.features.multilingual.ServiceName;

import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Represents a language second level entity.
 * 
 */
@Entity
@Table(name="cfLang")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Language implements CerifSecondLevelEntity, Comparable<Language> {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -7279208934092852352L;

	public final static Language ENGLISH = new Language("en", "English");
	
	public final static Language HELLENIC = new Language("el", "Hellenic");
	
	public final static Language HEBREW = new Language("he", "Hebrew");
	
	public final static Language GERMAN = new Language("de", "German");
	
	public final static Language DUTCH = new Language("nl", "Dutch");
	
	/**
	 * <p>
	 * A two-letter language code with regional sub-tags, according to this <a href="http://www.w3.org/International/articles/bcp47">link</a>.<br/>
	 * Example 1: For German language in Austria, this would look like "DE-AT". <br/>
	 * Example 2: For English in the UK, this would look like "EN-GB". <br/>
	 * </p>
	 */
	@Id
	@Column(name="cfLangCode")
	private String code;
	
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
	@OneToMany(mappedBy="languageOfName")
	private Set<LanguageName> names;
	
	@OneToMany(mappedBy="language")
	private Set<LanguageName> languageNames;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="language")
	private Set<CitationDescription> citationDescriptions;
	
	@OneToMany(mappedBy="language")
	private Set<CitationTitle> citationTitles;
	
	@OneToMany(mappedBy="language")
	private Set<ClassDescription> classDescriptions;
	
	@OneToMany(mappedBy="language")
	private Set<ClassTerm> classTerms;
	
	@OneToMany(mappedBy="language")
	private Set<ClassEx> classExs;
	
	@OneToMany(mappedBy="language")
	private Set<ClassDefinition> classDefinitions;
	
	@OneToMany(mappedBy="language")
	private Set<ClassSchemeDescription> classSchemeDescriptions;
	
	@OneToMany(mappedBy="language")
	private Set<ClassSchemeName> classSchemeNames;
	
	@OneToMany(mappedBy="language")
	private Set<CountryName> countryNames;
	
	@OneToMany(mappedBy="language")
	private Set<CurrencyName> currencyNames;
	
	@OneToMany(mappedBy="language")
	private Set<CurrencyEntityName> currencyEntityNames;
	
	@OneToMany(mappedBy="language")
	private Set<EquipmentName> equipmentNames;
	
	@OneToMany(mappedBy="language")
	private Set<EquipmentKeyword> equipmentKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<EquipmentDescription> equipmentDescriptions;
	
	@OneToMany(mappedBy="language")
	private Set<EventName> eventNames;
	
	@OneToMany(mappedBy="language")
	private Set<EventKeyword> eventKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<EventDescription> eventDescriptions;
	
	@OneToMany(mappedBy="language")
	private Set<ExpertiseAndSkillsName> expertiseAndSkillsNames;
	
	@OneToMany(mappedBy="language")
	private Set<ExpertiseAndSkillsKeyword> expertiseAndSkillsKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<ExpertiseAndSkillsDescription> expertiseAndSkillsDescriptions;
	
	@OneToMany(mappedBy="language")
	private Set<FacilityName> facilityNames;
	
	@OneToMany(mappedBy="language")
	private Set<FacilityKeyword> facilityKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<FacilityDescription> facilityDescriptions;
	
	@OneToMany(mappedBy="language")
	private Set<FundingName> fundingNames;
	
	@OneToMany(mappedBy="language")
	private Set<FundingKeyword> fundingKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<FundingDescription> fundingDescriptions;
	
	@OneToMany(mappedBy="language")
	private Set<GeographicBoundingBoxName> geographicBoundingBoxNames;
	
	@OneToMany(mappedBy="language")
	private Set<GeographicBoundingBoxDescription> geographicBoundingBoxDescriptions;

	@OneToMany(mappedBy="language")
	private Set<GeographicBoundingBoxKeyword> geographicBoundingBoxKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<IndicatorName> indicatorNames;
	
	@OneToMany(mappedBy="language")
	private Set<IndicatorKeyword> indicatorKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<IndicatorDescription> indicatorDescriptions;
	
	@OneToMany(mappedBy="language")
	private Set<MeasurementName> measurementNames;
	
	@OneToMany(mappedBy="language")
	private Set<MeasurementKeyword> measurementKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<MeasurementDescription> measurementDescriptions;
	
	@OneToMany(mappedBy="language")
	private Set<MediumTitle> mediumNames;
	
	@OneToMany(mappedBy="language")
	private Set<MediumKeyword> mediumKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<MediumDescription> mediumDescriptions;
	
	@OneToMany(mappedBy="language")
	private Set<MetricsName> metricsNames;
	
	@OneToMany(mappedBy="language")
	private Set<MetricsKeyword> metricsKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<MetricsDescription> metricsDescriptions;

	@OneToMany(mappedBy="language")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<OrganisationUnitName> organisationUnitNames;
	
	@OneToMany(mappedBy="language")
	private Set<OrganisationUnitResearchActivity> organisationUnitResearchActivities;
	
	@OneToMany(mappedBy="language")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<OrganisationUnitKeyword> organisationUnitKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<PrizeName> prizeNames;
	
	@OneToMany(mappedBy="language")
	private Set<PrizeKeyword> prizeKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<PrizeDescription> prizeDescriptions;
	
	@OneToMany(mappedBy="language")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<ProjectTitle> projectTitles;
	
	@OneToMany(mappedBy="language")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<ProjectAbstract> projectAbstracts;
	
	@OneToMany(mappedBy="language")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<ProjectKeyword> projectKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<QualificationTitle> qualificationTitles;
	
	@OneToMany(mappedBy="language")
	private Set<QualificationKeyword> qualificationKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<QualificationDescription> qualificationDescriptions;
	
	@OneToMany(mappedBy="language")
	private Set<ResultPatentTitle> resultPatentTitles;
	
	@OneToMany(mappedBy="language")
	private Set<ResultPatentAbstract> resultPatentAbstracts;
	
	@OneToMany(mappedBy="language")
	private Set<ResultPatentKeyword> resultPatentKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<ResultPatentKeyword> resultPatentVersionInfos;
	
	@OneToMany(mappedBy="language")
	private Set<ResultProductDescription> resultProductDescriptions;
	
	@OneToMany(mappedBy="language")
	private Set<ResultProductName> resultProductNames;
	
	@OneToMany(mappedBy="language")
	private Set<ResultProductKeyword> resultProductKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<ResultProductKeyword> resultProductVersionInfos;
	
	@OneToMany(mappedBy="language")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<ResultPublicationTitle> resultPublicationTitles;
	
	@OneToMany(mappedBy="language")
	private Set<ResultPublicationSubtitle> resultPublicationSubtitles;
	
	@OneToMany(mappedBy="language")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<ResultPublicationAbstract> resultPublicationAbstracts;
	
	@OneToMany(mappedBy="language")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<ResultPublicationKeyword> resultPublicationKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<ResultPublicationBibliographicNote> resultPublicationBibliographicNotes;
	
	@OneToMany(mappedBy="language")
	private Set<ResultPublicationNameAbbreviation> resultPublicationNameAbbreviations;
	
	@OneToMany(mappedBy="language")
	private Set<ResultPublicationVersionInfo> resultPublicationVersionInfos;
	
	@OneToMany(mappedBy="language")
	private Set<ServiceName> serviceNames;
	
	@OneToMany(mappedBy="language")
	private Set<ServiceKeyword> serviceKeywords;
	
	@OneToMany(mappedBy="language")
	private Set<ServiceDescription> serviceDescriptions;

	@OneToMany(mappedBy="language")
	private Set<Person_Language> persons_languages;
	
	@OneToMany(mappedBy="language")
	private Set<Language_Class> languages_classes;

	
	/**
	 * FederatedIdentifier entities related to OrganisationUnit instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//
	
	public Language() {
		// nothing to implement here
	}
	
	
	public Language(String code) {
		this();
		this.code = code;
	}

	/**
	 * Constructor.
	 * @param code The code.
	 * @param uri The URI.
	 */
	public Language(String code, String uri) {

		this.code = code;
		this.uri = uri;
	}
	
	/**
	 * Returns the code.
	 * @return the code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 * @param code the code.
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the persons_languages
	 */
	public Set<Person_Language> getPersons_languages() {
		return persons_languages;
	}
	
	/**
	 * @param persons_languages the persons_languages to set
	 */
	public void setPersons_languages(Set<Person_Language> persons_languages) {
		this.persons_languages = persons_languages;
	}

	/**
	 * @return the citationDescriptions
	 */
	public Set<CitationDescription> getCitationDescriptions() {
		return citationDescriptions;
	}

	/**
	 * @param citationDescriptions the citationDescriptions to set
	 */
	public void setCitationDescriptions(Set<CitationDescription> citationDescriptions) {
		this.citationDescriptions = citationDescriptions;
	}

	/**
	 * @return the citationTitles
	 */
	public Set<CitationTitle> getCitationTitles() {
		return citationTitles;
	}

	/**
	 * @param citationTitles the citationTitles to set
	 */
	public void setCitationTitles(Set<CitationTitle> citationTitles) {
		this.citationTitles = citationTitles;
	}

	/**
	 * @return the classDescriptions
	 */
	public Set<ClassDescription> getClassDescriptions() {
		return classDescriptions;
	}

	/**
	 * @param classDescriptions the classDescriptions to set
	 */
	public void setClassDescriptions(Set<ClassDescription> classDescriptions) {
		this.classDescriptions = classDescriptions;
	}

	/**
	 * @return the classTerms
	 */
	public Set<ClassTerm> getClassTerms() {
		return classTerms;
	}

	/**
	 * @param classTerms the classTerms to set
	 */
	public void setClassTerms(Set<ClassTerm> classTerms) {
		this.classTerms = classTerms;
	}

	/**
	 * @return the classExs
	 */
	public Set<ClassEx> getClassExs() {
		return classExs;
	}

	/**
	 * @param classExs the classExs to set
	 */
	public void setClassExs(Set<ClassEx> classExs) {
		this.classExs = classExs;
	}

	/**
	 * @return the classDefinitions
	 */
	public Set<ClassDefinition> getClassDefinitions() {
		return classDefinitions;
	}

	/**
	 * @param classDefinitions the classDefinitions to set
	 */
	public void setClassDefinitions(Set<ClassDefinition> classDefinitions) {
		this.classDefinitions = classDefinitions;
	}
	
	/**
	 * @return the classSchemeDescriptions
	 */
	public Set<ClassSchemeDescription> getClassSchemeDescriptions() {
		return classSchemeDescriptions;
	}

	/**
	 * @param classSchemeDescriptions the classSchemeDescriptions to set
	 */
	public void setClassSchemeDescriptions(Set<ClassSchemeDescription> classSchemeDescriptions) {
		this.classSchemeDescriptions = classSchemeDescriptions;
	}

	/**
	 * @return the classSchemeNames
	 */
	public Set<ClassSchemeName> getClassSchemeNames() {
		return classSchemeNames;
	}

	/**
	 * @param classSchemeNames the classSchemeNames to set
	 */
	public void setClassSchemeNames(Set<ClassSchemeName> classSchemeNames) {
		this.classSchemeNames = classSchemeNames;
	}

	/**
	 * @return the countryNames
	 */
	public Set<CountryName> getCountryNames() {
		return countryNames;
	}

	/**
	 * @param countryNames the countryNames to set
	 */
	public void setCountryNames(Set<CountryName> countryNames) {
		this.countryNames = countryNames;
	}

	/**
	 * @return the currencyNames
	 */
	public Set<CurrencyName> getCurrencyNames() {
		return currencyNames;
	}

	/**
	 * @param currencyNames the currencyNames to set
	 */
	public void setCurrencyNames(Set<CurrencyName> currencyNames) {
		this.currencyNames = currencyNames;
	}

	/**
	 * @return the currencyEntityNames
	 */
	public Set<CurrencyEntityName> getCurrencyEntityNames() {
		return currencyEntityNames;
	}

	/**
	 * @param currencyEntityNames the currencyEntityNames to set
	 */
	public void setCurrencyEntityNames(Set<CurrencyEntityName> currencyEntityNames) {
		this.currencyEntityNames = currencyEntityNames;
	}

	/**
	 * @return the equipmentNames
	 */
	public Set<EquipmentName> getEquipmentNames() {
		return equipmentNames;
	}

	/**
	 * @param equipmentNames the equipmentNames to set
	 */
	public void setEquipmentNames(Set<EquipmentName> equipmentNames) {
		this.equipmentNames = equipmentNames;
	}

	/**
	 * @return the equipmentKeywords
	 */
	public Set<EquipmentKeyword> getEquipmentKeywords() {
		return equipmentKeywords;
	}

	/**
	 * @param equipmentKeywords the equipmentKeywords to set
	 */
	public void setEquipmentKeywords(Set<EquipmentKeyword> equipmentKeywords) {
		this.equipmentKeywords = equipmentKeywords;
	}

	/**
	 * @return the equipmentDescriptions
	 */
	public Set<EquipmentDescription> getEquipmentDescriptions() {
		return equipmentDescriptions;
	}

	/**
	 * @param equipmentDescriptions the equipmentDescriptions to set
	 */
	public void setEquipmentDescriptions(Set<EquipmentDescription> equipmentDescriptions) {
		this.equipmentDescriptions = equipmentDescriptions;
	}

	/**
	 * @return the eventNames
	 */
	public Set<EventName> getEventNames() {
		return eventNames;
	}

	/**
	 * @param eventNames the eventNames to set
	 */
	public void setEventNames(Set<EventName> eventNames) {
		this.eventNames = eventNames;
	}

	/**
	 * @return the eventKeywords
	 */
	public Set<EventKeyword> getEventKeywords() {
		return eventKeywords;
	}

	/**
	 * @param eventKeywords the eventKeywords to set
	 */
	public void setEventKeywords(Set<EventKeyword> eventKeywords) {
		this.eventKeywords = eventKeywords;
	}

	/**
	 * @return the eventDescriptions
	 */
	public Set<EventDescription> getEventDescriptions() {
		return eventDescriptions;
	}

	/**
	 * @param eventDescriptions the eventDescriptions to set
	 */
	public void setEventDescriptions(Set<EventDescription> eventDescriptions) {
		this.eventDescriptions = eventDescriptions;
	}

	/**
	 * @return the expertiseAndSkillsNames
	 */
	public Set<ExpertiseAndSkillsName> getExpertiseAndSkillsNames() {
		return expertiseAndSkillsNames;
	}

	/**
	 * @param expertiseAndSkillsNames the expertiseAndSkillsNames to set
	 */
	public void setExpertiseAndSkillsNames(Set<ExpertiseAndSkillsName> expertiseAndSkillsNames) {
		this.expertiseAndSkillsNames = expertiseAndSkillsNames;
	}

	/**
	 * @return the expertiseAndSkillsKeywords
	 */
	public Set<ExpertiseAndSkillsKeyword> getExpertiseAndSkillsKeywords() {
		return expertiseAndSkillsKeywords;
	}

	/**
	 * @param expertiseAndSkillsKeywords the expertiseAndSkillsKeywords to set
	 */
	public void setExpertiseAndSkillsKeywords(
			Set<ExpertiseAndSkillsKeyword> expertiseAndSkillsKeywords) {
		this.expertiseAndSkillsKeywords = expertiseAndSkillsKeywords;
	}

	/**
	 * @return the expertiseAndSkillsDescriptions
	 */
	public Set<ExpertiseAndSkillsDescription> getExpertiseAndSkillsDescriptions() {
		return expertiseAndSkillsDescriptions;
	}

	/**
	 * @param expertiseAndSkillsDescriptions the expertiseAndSkillsDescriptions to set
	 */
	public void setExpertiseAndSkillsDescriptions(
			Set<ExpertiseAndSkillsDescription> expertiseAndSkillsDescriptions) {
		this.expertiseAndSkillsDescriptions = expertiseAndSkillsDescriptions;
	}

	/**
	 * @return the facilityNames
	 */
	public Set<FacilityName> getFacilityNames() {
		return facilityNames;
	}

	/**
	 * @param facilityNames the facilityNames to set
	 */
	public void setFacilityNames(Set<FacilityName> facilityNames) {
		this.facilityNames = facilityNames;
	}

	/**
	 * @return the facilityKeywords
	 */
	public Set<FacilityKeyword> getFacilityKeywords() {
		return facilityKeywords;
	}

	/**
	 * @param facilityKeywords the facilityKeywords to set
	 */
	public void setFacilityKeywords(Set<FacilityKeyword> facilityKeywords) {
		this.facilityKeywords = facilityKeywords;
	}

	/**
	 * @return the facilityDescriptions
	 */
	public Set<FacilityDescription> getFacilityDescriptions() {
		return facilityDescriptions;
	}

	/**
	 * @param facilityDescriptions the facilityDescriptions to set
	 */
	public void setFacilityDescriptions(Set<FacilityDescription> facilityDescriptions) {
		this.facilityDescriptions = facilityDescriptions;
	}

	/**
	 * @return the fundingNames
	 */
	public Set<FundingName> getFundingNames() {
		return fundingNames;
	}

	/**
	 * @param fundingNames the fundingNames to set
	 */
	public void setFundingNames(Set<FundingName> fundingNames) {
		this.fundingNames = fundingNames;
	}

	/**
	 * @return the fundingKeywords
	 */
	public Set<FundingKeyword> getFundingKeywords() {
		return fundingKeywords;
	}

	/**
	 * @param fundingKeywords the fundingKeywords to set
	 */
	public void setFundingKeywords(Set<FundingKeyword> fundingKeywords) {
		this.fundingKeywords = fundingKeywords;
	}

	/**
	 * @return the fundingDescriptions
	 */
	public Set<FundingDescription> getFundingDescriptions() {
		return fundingDescriptions;
	}

	/**
	 * @param fundingDescriptions the fundingDescriptions to set
	 */
	public void setFundingDescriptions(Set<FundingDescription> fundingDescriptions) {
		this.fundingDescriptions = fundingDescriptions;
	}

	/**
	 * @return the geographicBoundingBoxNames
	 */
	public Set<GeographicBoundingBoxName> getGeographicBoundingBoxNames() {
		return geographicBoundingBoxNames;
	}

	/**
	 * @param geographicBoundingBoxNames the geographicBoundingBoxNames to set
	 */
	public void setGeographicBoundingBoxNames(
			Set<GeographicBoundingBoxName> geographicBoundingBoxNames) {
		this.geographicBoundingBoxNames = geographicBoundingBoxNames;
	}

	/**
	 * @return the geographicBoundingBoxDescriptions
	 */
	public Set<GeographicBoundingBoxDescription> getGeographicBoundingBoxDescriptions() {
		return geographicBoundingBoxDescriptions;
	}

	/**
	 * @param geographicBoundingBoxDescriptions the geographicBoundingBoxDescriptions to set
	 */
	public void setGeographicBoundingBoxDescriptions(
			Set<GeographicBoundingBoxDescription> geographicBoundingBoxDescriptions) {
		this.geographicBoundingBoxDescriptions = geographicBoundingBoxDescriptions;
	}

	/**
	 * @return the geographicBoundingBoxKeywords
	 */
	public Set<GeographicBoundingBoxKeyword> getGeographicBoundingBoxKeywords() {
		return geographicBoundingBoxKeywords;
	}

	/**
	 * @param geographicBoundingBoxKeywords the geographicBoundingBoxKeywords to set
	 */
	public void setGeographicBoundingBoxKeywords(
			Set<GeographicBoundingBoxKeyword> geographicBoundingBoxKeywords) {
		this.geographicBoundingBoxKeywords = geographicBoundingBoxKeywords;
	}

	/**
	 * @return the indicatorNames
	 */
	public Set<IndicatorName> getIndicatorNames() {
		return indicatorNames;
	}

	/**
	 * @param indicatorNames the indicatorNames to set
	 */
	public void setIndicatorNames(Set<IndicatorName> indicatorNames) {
		this.indicatorNames = indicatorNames;
	}

	/**
	 * @return the indicatorKeywords
	 */
	public Set<IndicatorKeyword> getIndicatorKeywords() {
		return indicatorKeywords;
	}

	/**
	 * @param indicatorKeywords the indicatorKeywords to set
	 */
	public void setIndicatorKeywords(Set<IndicatorKeyword> indicatorKeywords) {
		this.indicatorKeywords = indicatorKeywords;
	}

	/**
	 * @return the indicatorDescriptions
	 */
	public Set<IndicatorDescription> getIndicatorDescriptions() {
		return indicatorDescriptions;
	}

	/**
	 * @param indicatorDescriptions the indicatorDescriptions to set
	 */
	public void setIndicatorDescriptions(Set<IndicatorDescription> indicatorDescriptions) {
		this.indicatorDescriptions = indicatorDescriptions;
	}

	/**
	 * @return the names
	 */
	public Set<LanguageName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(Set<LanguageName> names) {
		this.names = names;
	}

	/**
	 * @return the languageNames
	 */
	public Set<LanguageName> getLanguageNames() {
		return languageNames;
	}

	/**
	 * @param languageNames the languageNames to set
	 */
	public void setLanguageNames(Set<LanguageName> languageNames) {
		this.languageNames = languageNames;
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
	public void setMeasurementDescriptions(Set<MeasurementDescription> measurementDescriptions) {
		this.measurementDescriptions = measurementDescriptions;
	}

	/**
	 * @return the mediumNames
	 */
	public Set<MediumTitle> getMediumNames() {
		return mediumNames;
	}

	/**
	 * @param mediumNames the mediumNames to set
	 */
	public void setMediumNames(Set<MediumTitle> mediumNames) {
		this.mediumNames = mediumNames;
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

	public Set<MediumDescription> getMediumDescriptions() {
		return mediumDescriptions;
	}

	public void setMediumDescriptions(Set<MediumDescription> mediumDescriptions) {
		this.mediumDescriptions = mediumDescriptions;
	}

	public Set<MetricsName> getMetricsNames() {
		return metricsNames;
	}

	public void setMetricsNames(Set<MetricsName> metricsNames) {
		this.metricsNames = metricsNames;
	}

	public Set<MetricsKeyword> getMetricsKeywords() {
		return metricsKeywords;
	}

	public void setMetricsKeywords(Set<MetricsKeyword> metricsKeywords) {
		this.metricsKeywords = metricsKeywords;
	}

	public Set<MetricsDescription> getMetricsDescriptions() {
		return metricsDescriptions;
	}

	public void setMetricsDescriptions(Set<MetricsDescription> metricsDescriptions) {
		this.metricsDescriptions = metricsDescriptions;
	}

	public Set<OrganisationUnitName> getOrganisationUnitNames() {
		return organisationUnitNames;
	}

	public void setOrganisationUnitNames(Set<OrganisationUnitName> organisationUnitNames) {
		this.organisationUnitNames = organisationUnitNames;
	}

	public Set<OrganisationUnitResearchActivity> getOrganisationUnitResearchActivities() {
		return organisationUnitResearchActivities;
	}

	public void setOrganisationUnitResearchActivities(
			Set<OrganisationUnitResearchActivity> organisationUnitResearchActivities) {
		this.organisationUnitResearchActivities = organisationUnitResearchActivities;
	}

	public Set<OrganisationUnitKeyword> getOrganisationUnitKeywords() {
		return organisationUnitKeywords;
	}

	public void setOrganisationUnitKeywords(Set<OrganisationUnitKeyword> organisationUnitKeywords) {
		this.organisationUnitKeywords = organisationUnitKeywords;
	}

	public Set<PrizeName> getPrizeNames() {
		return prizeNames;
	}

	public void setPrizeNames(Set<PrizeName> prizeNames) {
		this.prizeNames = prizeNames;
	}

	public Set<PrizeKeyword> getPrizeKeywords() {
		return prizeKeywords;
	}

	public void setPrizeKeywords(Set<PrizeKeyword> prizeKeywords) {
		this.prizeKeywords = prizeKeywords;
	}

	public Set<PrizeDescription> getPrizeDescriptions() {
		return prizeDescriptions;
	}

	public void setPrizeDescriptions(Set<PrizeDescription> prizeDescriptions) {
		this.prizeDescriptions = prizeDescriptions;
	}

	public Set<ProjectTitle> getProjectTitles() {
		return projectTitles;
	}

	public void setProjectTitles(Set<ProjectTitle> projectTitles) {
		this.projectTitles = projectTitles;
	}

	public Set<ProjectAbstract> getProjectAbstracts() {
		return projectAbstracts;
	}

	public void setProjectAbstracts(Set<ProjectAbstract> projectAbstracts) {
		this.projectAbstracts = projectAbstracts;
	}

	public Set<ProjectKeyword> getProjectKeywords() {
		return projectKeywords;
	}

	public void setProjectKeywords(Set<ProjectKeyword> projectKeywords) {
		this.projectKeywords = projectKeywords;
	}

	public Set<QualificationTitle> getQualificationTitles() {
		return qualificationTitles;
	}

	public void setQualificationTitles(Set<QualificationTitle> qualificationTitles) {
		this.qualificationTitles = qualificationTitles;
	}

	public Set<QualificationKeyword> getQualificationKeywords() {
		return qualificationKeywords;
	}

	public void setQualificationKeywords(Set<QualificationKeyword> qualificationKeywords) {
		this.qualificationKeywords = qualificationKeywords;
	}

	public Set<QualificationDescription> getQualificationDescriptions() {
		return qualificationDescriptions;
	}

	public void setQualificationDescriptions(
			Set<QualificationDescription> qualificationDescriptions) {
		this.qualificationDescriptions = qualificationDescriptions;
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

	public Set<ResultProductDescription> getResultProductDescriptions() {
		return resultProductDescriptions;
	}

	public void setResultProductDescriptions(
			Set<ResultProductDescription> resultProductDescriptions) {
		this.resultProductDescriptions = resultProductDescriptions;
	}

	public Set<ResultProductName> getResultProductNames() {
		return resultProductNames;
	}

	public void setResultProductNames(Set<ResultProductName> resultProductNames) {
		this.resultProductNames = resultProductNames;
	}

	public Set<ResultProductKeyword> getResultProductKeywords() {
		return resultProductKeywords;
	}

	public void setResultProductKeywords(Set<ResultProductKeyword> resultProductKeywords) {
		this.resultProductKeywords = resultProductKeywords;
	}

	public Set<ResultProductKeyword> getResultProductVersionInfos() {
		return resultProductVersionInfos;
	}

	public void setResultProductVersionInfos(
			Set<ResultProductKeyword> resultProductVersionInfos) {
		this.resultProductVersionInfos = resultProductVersionInfos;
	}

	public Set<ResultPublicationTitle> getResultPublicationTitles() {
		return resultPublicationTitles;
	}

	public void setResultPublicationTitles(Set<ResultPublicationTitle> resultPublicationTitles) {
		this.resultPublicationTitles = resultPublicationTitles;
	}

	public Set<ResultPublicationSubtitle> getResultPublicationSubtitles() {
		return resultPublicationSubtitles;
	}

	public void setResultPublicationSubtitles(
			Set<ResultPublicationSubtitle> resultPublicationSubtitles) {
		this.resultPublicationSubtitles = resultPublicationSubtitles;
	}

	public Set<ResultPublicationAbstract> getResultPublicationAbstracts() {
		return resultPublicationAbstracts;
	}

	public void setResultPublicationAbstracts(
			Set<ResultPublicationAbstract> resultPublicationAbstracts) {
		this.resultPublicationAbstracts = resultPublicationAbstracts;
	}

	public Set<ResultPublicationKeyword> getResultPublicationKeywords() {
		return resultPublicationKeywords;
	}

	public void setResultPublicationKeywords(
			Set<ResultPublicationKeyword> resultPublicationKeywords) {
		this.resultPublicationKeywords = resultPublicationKeywords;
	}

	public Set<ResultPublicationBibliographicNote> getResultPublicationBibliographicNotes() {
		return resultPublicationBibliographicNotes;
	}

	public void setResultPublicationBibliographicNotes(
			Set<ResultPublicationBibliographicNote> resultPublicationBibliographicNotes) {
		this.resultPublicationBibliographicNotes = resultPublicationBibliographicNotes;
	}

	public Set<ResultPublicationNameAbbreviation> getResultPublicationNameAbbreviations() {
		return resultPublicationNameAbbreviations;
	}

	public void setResultPublicationNameAbbreviations(
			Set<ResultPublicationNameAbbreviation> resultPublicationNameAbbreviations) {
		this.resultPublicationNameAbbreviations = resultPublicationNameAbbreviations;
	}

	public Set<ResultPublicationVersionInfo> getResultPublicationVersionInfos() {
		return resultPublicationVersionInfos;
	}

	public void setResultPublicationVersionInfos(
			Set<ResultPublicationVersionInfo> resultPublicationVersionInfos) {
		this.resultPublicationVersionInfos = resultPublicationVersionInfos;
	}

	public Set<ServiceName> getServiceNames() {
		return serviceNames;
	}

	public void setServiceNames(Set<ServiceName> serviceNames) {
		this.serviceNames = serviceNames;
	}

	public Set<ServiceKeyword> getServiceKeywords() {
		return serviceKeywords;
	}

	public void setServiceKeywords(Set<ServiceKeyword> serviceKeywords) {
		this.serviceKeywords = serviceKeywords;
	}

	public Set<ServiceDescription> getServiceDescriptions() {
		return serviceDescriptions;
	}

	public void setServiceDescriptions(Set<ServiceDescription> serviceDescriptions) {
		this.serviceDescriptions = serviceDescriptions;
	}

	/**
	 * @return the languages_classes
	 */
	public Set<Language_Class> getLanguages_classes() {
		return languages_classes;
	}


	/**
	 * @param languages_classes the languages_classes to set
	 */
	public void setLanguages_classes(Set<Language_Class> languages_classes) {
		this.languages_classes = languages_classes;
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
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Language)) {
			return false;
		}
		Language other = (Language) obj;
		if (uri == null) {
			if (other.uri != null) {
				return false;
			}
		} else if (!uri.equals(other.uri)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Language o) {
		return code.compareTo(o.code);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Language [code=" + code + ", uri=" + uri + "]";
	}
	
	
}

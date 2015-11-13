/**
 * 
 */
package gr.ekt.cerif.entities.result;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.link.result.ResultPublication_Citation;
import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.link.result.ResultPublication_DublinCore;
import gr.ekt.cerif.entities.link.result.ResultPublication_Equipment;
import gr.ekt.cerif.entities.link.result.ResultPublication_Event;
import gr.ekt.cerif.entities.link.result.ResultPublication_Facility;
import gr.ekt.cerif.entities.link.result.ResultPublication_Funding;
import gr.ekt.cerif.entities.link.result.ResultPublication_Indicator;
import gr.ekt.cerif.entities.link.result.ResultPublication_Measurement;
import gr.ekt.cerif.entities.link.result.ResultPublication_Medium;
import gr.ekt.cerif.entities.link.result.ResultPublication_Metrics;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPatent;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPublication;
import gr.ekt.cerif.entities.link.result.ResultPublication_Service;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;
import gr.ekt.cerif.features.multilingual.ResultPublicationBibliographicNote;
import gr.ekt.cerif.features.multilingual.ResultPublicationKeyword;
import gr.ekt.cerif.features.multilingual.ResultPublicationNameAbbreviation;
import gr.ekt.cerif.features.multilingual.ResultPublicationSubtitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationVersionInfo;

import java.util.Date;
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
 * Represents a result publication entity.
 * 
 */
@Entity
@Table(name="cfResPubl")
public class ResultPublication implements CerifResultEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -7703630289724190191L;

	/**
	 * The publication unique identifier.
	 */
	@Id
	@Column(name="cfResPublId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The year of publication or, if unpublished, the year of creation.
	 */
	@Column(name="cfResPublDate")
	private Date date;

	/**
	 * The number of a journal, magazine, or technical report, if applicable.
	 */
	@Column(name="cfNum")
	private String num;
	
	/**
	 * The volume (book), a single book that is part of a collection.
	 */
	@Column(name="cfVol")
	private String vol;
	
	/**
	 * The edition of a book, long form (such as "first" or "second").
	 */
	@Column(name="cfEdition")
	private String edition;
	
	/**
	 * The series of books the book was published in.
	 */
	@Column(name="cfSeries")
	private String series;
	
	/**
	 * The issue.
	 */
	@Column(name="cfIssue")
	private String issue;
	
	/**
	 * The start page.
	 */
	@Column(name="cfStartPage")
	private String startPage;
	
	/**
	 * The end page.
	 */
	@Column(name="cfEndPage")
	private String endPage;
	
	/**
	 * The total number of pages.
	 */
	@Column(name="cfTotalPages")
	private String totalPages;
	
	/**
	 * The ISBN.
	 */
	@Deprecated
	@Column(name="cfISBN")
	private String isbn;
	
	/**
	 * The ISSN.
	 */
	@Deprecated
	@Column(name="cfISSN")
	private String issn;
	
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
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublicationTitle> resultPublicationTitles;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublicationSubtitle> resultPublicationSubtitles;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublicationAbstract> resultPublicationAbstracts;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublicationKeyword> resultPublicationKeywords;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublicationBibliographicNote> resultPublicationBibliographicNotes;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublicationNameAbbreviation> resultPublicationNameAbbreviations;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublicationVersionInfo> resultPublicationVersionInfos;
	

	/**
	 * Links.
	 */
	@OneToMany (mappedBy = "resultPublication")
	private Set<ResultPublication_ResultProduct> resultPublications_resultProducts;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<Project_ResultPublication> projects_resultPublications;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<Person_ResultPublication> persons_resultPublications;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<OrganisationUnit_ResultPublication> organisationUnits_resultPublications;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublication_Citation> resultPublications_citations;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublication_Class> resultPublications_classes;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublication_DublinCore> resultPublications_dublinCores;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublication_Equipment> resultPublications_equipments;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublication_Event> resultPublications_events;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublication_Facility> resultPublications_facilities;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublication_Funding> resultPublications_fundings;

	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublication_Indicator> resultPublications_indicators;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublication_Measurement> resultPublications_measurements;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublication_Metrics> resultPublications_metrics;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublication_Medium> resultPublications_mediums;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublication_ResultPatent> resultPublications_resultPatents;
	
	@OneToMany(mappedBy="resultPublication1")
	private Set<ResultPublication_ResultPublication> resultPublications_resultPublications1;
	
	@OneToMany(mappedBy="resultPublication2")
	private Set<ResultPublication_ResultPublication> resultPublications_resultPublications2;
    
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublication_Service> resultPublications_services;
	
	
	/**
	 * FederatedIdentifier entities related to ResultPublication instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;	
	
	// ---------------------------------------------------------------------- //
	
	
	/**
	 * Default Constructor
	 */
	public ResultPublication(){
		
	}
	
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
	 * Returns the date.
	 * @return the date.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 * @param date the date.
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Returns the number.
	 * @return the number.
	 */
	public String getNum() {
		return num;
	}

	/**
	 * Sets the number.
	 * @param num the number.
	 */
	public void setNum(String num) {
		this.num = num;
	}

	/**
	 * Returns the volume.
	 * @return the volume.
	 */
	public String getVol() {
		return vol;
	}

	/**
	 * Sets the volume.
	 * @param vol the volume.
	 */
	public void setVol(String vol) {
		this.vol = vol;
	}

	/**
	 * Returns the edition.
	 * @return the edition.
	 */
	public String getEdition() {
		return edition;
	}

	/**
	 * Sets the edition.
	 * @param edition the edition.
	 */
	public void setEdition(String edition) {
		this.edition = edition;
	}

	/**
	 * Returns the series.
	 * @return the series.
	 */
	public String getSeries() {
		return series;
	}

	/**
	 * Sets the series.
	 * @param series the series.
	 */
	public void setSeries(String series) {
		this.series = series;
	}

	/**
	 * Returns the issue.
	 * @return the issue.
	 */
	public String getIssue() {
		return issue;
	}

	/**
	 * Sets the issue.
	 * @param issue the issue.
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}

	/**
	 * Returns the start page.
	 * @return the start page.
	 */
	public String getStartPage() {
		return startPage;
	}

	/**
	 * Sets the start page.
	 * @param startPage the start page.
	 */
	public void setStartPage(String startPage) {
		this.startPage = startPage;
	}

	/**
	 * Returns the end page.
	 * @return the end page.
	 */
	public String getEndPage() {
		return endPage;
	}

	/**
	 * Sets the end page.
	 * @param endPage the end page.
	 */
	public void setEndPage(String endPage) {
		this.endPage = endPage;
	}

	/**
	 * Returns the total pages.
	 * @return the total pages.
	 */
	public String getTotalPages() {
		return totalPages;
	}

	/**
	 * Sets the total pages.
	 * @param totalPages the total pages.
	 */
	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * Returns the ISBN.
	 * @return the ISBN.
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Sets the ISBN.
	 * @param isbn the ISBN.
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Returns the ISSN.
	 * @return the ISSN.
	 */
	public String getIssn() {
		return issn;
	}

	/**
	 * Sets the ISSN.
	 * @param issn the ISSN.
	 */
	public void setIssn(String issn) {
		this.issn = issn;
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

	/**
	 * @return the resultPublications_resultProducts
	 */
	public Set<ResultPublication_ResultProduct> getResultPublications_resultProducts() {
		return resultPublications_resultProducts;
	}

	/**
	 * @param resultPublications_resultProducts the resultPublications_resultProducts to set
	 */
	public void setResultPublications_resultProducts(
			Set<ResultPublication_ResultProduct> resultPublications_resultProducts) {
		this.resultPublications_resultProducts = resultPublications_resultProducts;
	}

	/**
	 * @return the projects_resultPublications
	 */
	public Set<Project_ResultPublication> getProjects_resultPublications() {
		return projects_resultPublications;
	}

	/**
	 * @param projects_resultPublications the projects_resultPublications to set
	 */
	public void setProjects_resultPublications(
			Set<Project_ResultPublication> projects_resultPublications) {
		this.projects_resultPublications = projects_resultPublications;
	}
	
	/**
	 * @return the persons_resultPublications
	 */
	public Set<Person_ResultPublication> getPersons_resultPublications() {
		return persons_resultPublications;
	}
	
	/**
	 * @param persons_resultPublications the persons_resultPublications to set
	 */
	public void setPersons_resultPublications(
			Set<Person_ResultPublication> persons_resultPublications) {
		this.persons_resultPublications = persons_resultPublications;
	}

	/**
	 * @return the organisationUnits_resultPublications
	 */
	public Set<OrganisationUnit_ResultPublication> getOrganisationUnits_resultPublications() {
		return organisationUnits_resultPublications;
	}

	/**
	 * @param organisationUnits_resultPublications the organisationUnits_resultPublications to set
	 */
	public void setOrganisationUnits_resultPublications(
			Set<OrganisationUnit_ResultPublication> organisationUnits_resultPublications) {
		this.organisationUnits_resultPublications = organisationUnits_resultPublications;
	}

	/**
	 * @return the resultPublications_citations
	 */
	public Set<ResultPublication_Citation> getResultPublications_citations() {
		return resultPublications_citations;
	}

	/**
	 * @param resultPublications_citations the resultPublications_citations to set
	 */
	public void setResultPublications_citations(
			Set<ResultPublication_Citation> resultPublications_citations) {
		this.resultPublications_citations = resultPublications_citations;
	}

	/**
	 * @return the resultPublications_classes
	 */
	public Set<ResultPublication_Class> getResultPublications_classes() {
		return resultPublications_classes;
	}

	/**
	 * @param resultPublications_classes the resultPublications_classes to set
	 */
	public void setResultPublications_classes(
			Set<ResultPublication_Class> resultPublications_classes) {
		this.resultPublications_classes = resultPublications_classes;
	}

	/**
	 * @return the resultPublications_dublinCores
	 */
	public Set<ResultPublication_DublinCore> getResultPublications_dublinCores() {
		return resultPublications_dublinCores;
	}

	/**
	 * @param resultPublications_dublinCores the resultPublications_dublinCores to set
	 */
	public void setResultPublications_dublinCores(
			Set<ResultPublication_DublinCore> resultPublications_dublinCores) {
		this.resultPublications_dublinCores = resultPublications_dublinCores;
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

	/**
	 * @return the resultPublications_events
	 */
	public Set<ResultPublication_Event> getResultPublications_events() {
		return resultPublications_events;
	}

	/**
	 * @param resultPublications_events the resultPublications_events to set
	 */
	public void setResultPublications_events(
			Set<ResultPublication_Event> resultPublications_events) {
		this.resultPublications_events = resultPublications_events;
	}

	/**
	 * @return the resultPublications_facilities
	 */
	public Set<ResultPublication_Facility> getResultPublications_facilities() {
		return resultPublications_facilities;
	}

	/**
	 * @param resultPublications_facilities the resultPublications_facilities to set
	 */
	public void setResultPublications_facilities(
			Set<ResultPublication_Facility> resultPublications_facilities) {
		this.resultPublications_facilities = resultPublications_facilities;
	}

	/**
	 * @return the resultPublications_fundings
	 */
	public Set<ResultPublication_Funding> getResultPublications_fundings() {
		return resultPublications_fundings;
	}

	/**
	 * @param resultPublications_fundings the resultPublications_fundings to set
	 */
	public void setResultPublications_fundings(
			Set<ResultPublication_Funding> resultPublications_fundings) {
		this.resultPublications_fundings = resultPublications_fundings;
	}

	/**
	 * @return the resultPublications_indicators
	 */
	public Set<ResultPublication_Indicator> getResultPublications_indicators() {
		return resultPublications_indicators;
	}

	/**
	 * @param resultPublications_indicators the resultPublications_indicators to set
	 */
	public void setResultPublications_indicators(
			Set<ResultPublication_Indicator> resultPublications_indicators) {
		this.resultPublications_indicators = resultPublications_indicators;
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
	 * @return the resultPublications_metrics
	 */
	public Set<ResultPublication_Metrics> getResultPublications_metrics() {
		return resultPublications_metrics;
	}

	/**
	 * @param resultPublications_metrics the resultPublications_metrics to set
	 */
	public void setResultPublications_metrics(
			Set<ResultPublication_Metrics> resultPublications_metrics) {
		this.resultPublications_metrics = resultPublications_metrics;
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

	/**
	 * @return the resultPublications_services
	 */
	public Set<ResultPublication_Service> getResultPublications_services() {
		return resultPublications_services;
	}

	/**
	 * @param resultPublications_services the resultPublications_services to set
	 */
	public void setResultPublications_services(
			Set<ResultPublication_Service> resultPublications_services) {
		this.resultPublications_services = resultPublications_services;
	}

	/**
	 * @return the resultPublications_resultPublications1
	 */
	public Set<ResultPublication_ResultPublication> getResultPublications_resultPublications1() {
		return resultPublications_resultPublications1;
	}

	/**
	 * @param resultPublications_resultPublications1 the resultPublications_resultPublications1 to set
	 */
	public void setResultPublications_resultPublications1(
			Set<ResultPublication_ResultPublication> resultPublications_resultPublications1) {
		this.resultPublications_resultPublications1 = resultPublications_resultPublications1;
	}

	/**
	 * @return the resultPublications_resultPublications2
	 */
	public Set<ResultPublication_ResultPublication> getResultPublications_resultPublications2() {
		return resultPublications_resultPublications2;
	}

	/**
	 * @param resultPublications_resultPublications2 the resultPublications_resultPublications2 to set
	 */
	public void setResultPublications_resultPublications2(
			Set<ResultPublication_ResultPublication> resultPublications_resultPublications2) {
		this.resultPublications_resultPublications2 = resultPublications_resultPublications2;
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
		ResultPublication other = (ResultPublication) obj;
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
		return "ResultPublication [id=" + id + ", date=" + date + ", num="
				+ num + ", vol=" + vol + ", edition=" + edition + ", series="
				+ series + ", issue=" + issue + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", totalPages=" + totalPages
				+ ", isbn=" + isbn + ", issn=" + issn + ", uri=" + uri
				+ ", uuid=" + uuid + "]";
	}

	
}

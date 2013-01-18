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
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;
import gr.ekt.cerif.features.multilingual.ResultPublicationBibliographicNote;
import gr.ekt.cerif.features.multilingual.ResultPublicationKeyword;
import gr.ekt.cerif.features.multilingual.ResultPublicationNameAbbreviation;
import gr.ekt.cerif.features.multilingual.ResultPublicationSubtitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationVersionInfo;
import gr.ekt.cerif.features.multilingual.Translation;

import java.util.Date;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Represents a result publication entity.
 * 
 */
@Entity
@Table(name="cfResPubl")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
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
	@Column(name="cfISBN")
	private String isbn;
	
	/**
	 * The ISSN.
	 */
	@Column(name="cfISSN")
	private String issn;
	
	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	/**
	 * The publication Titles.
	 */
	@OneToMany(mappedBy="resultPublication", fetch=FetchType.EAGER)
	private Set<ResultPublicationTitle> resultPublicationTitles;
	
	/**
	 * The publication Subtitles.
	 */
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublicationSubtitle> resultPublicationSubtitles;
	
	/**
	 * The publication Abstracts.
	 */
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublicationAbstract> resultPublicationAbstracts;
	
	/**
	 * The publication Keywords.
	 */
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublicationKeyword> resultPublicationKeywords;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublicationBibliographicNote> resultPublicationBibliographicNotes;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublicationNameAbbreviation> resultPublicationNameAbbreviations;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublicationVersionInfo> resultPublicationVersionInfos;
	
	/**
	 * The result products.
	 */
	@OneToMany (mappedBy = "resultPublication")
	private Set<ResultPublication_ResultProduct> resultProducts;
	
	/**
	 * The link entities of projects and resultPublications.
	 */
	@OneToMany(mappedBy="resultPublication")
	private Set<Project_ResultPublication> projects_resultPublications;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<Person_ResultPublication> persons_resultPublications;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<OrganisationUnit_ResultPublication> organisationUnit_resultPublications;
	
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
	private Set<ResultPublication_Medium> resultPublications_medium;
	
	@OneToMany(mappedBy="resultPublication")
	private Set<ResultPublication_ResultPatent> resultPublications_resultPatents;
	
	@OneToMany(mappedBy="resultPublication1")
	private Set<ResultPublication_ResultPublication> resultPublications1_resultPublications;
	
	@OneToMany(mappedBy="resultPublication2")
	private Set<ResultPublication_ResultPublication> resultPublications2_resultPublications;
    
	/**
	 * Default Constructor
	 */
	public ResultPublication(){
		
	}
	
	/**
	 * 
	 * @param date
	 * @param num
	 * @param vol
	 * @param edition
	 * @param series
	 * @param issue
	 * @param startPage
	 * @param endPage
	 * @param totalPages
	 * @param isbn
	 * @param issn
	 * @param uri
	 * @param resultPublicationTitles
	 * @param resultPublicationSubtitles
	 * @param resultPublicationAbstracts
	 * @param resultPublicationKeywords
	 * @param resultPublicationBibliographicNotes
	 * @param resultPublicationNameAbbreviations
	 * @param resultPublicationVersionInfos
	 */
	public ResultPublication(
			Date date,
			String num,
			String vol,
			String edition,
			String series,
			String issue,
			String startPage,
			String endPage,
			String totalPages,
			String isbn,
			String issn,
			String uri,
			Set<ResultPublicationTitle> resultPublicationTitles,
			Set<ResultPublicationSubtitle> resultPublicationSubtitles,
			Set<ResultPublicationAbstract> resultPublicationAbstracts,
			Set<ResultPublicationKeyword> resultPublicationKeywords,
			Set<ResultPublicationBibliographicNote> resultPublicationBibliographicNotes,
			Set<ResultPublicationNameAbbreviation> resultPublicationNameAbbreviations,
			Set<ResultPublicationVersionInfo> resultPublicationVersionInfos
			) {
		this.date = date;
		this.num = num;
		this.vol = vol;
		this.edition = edition;
		this.series = series;
		this.issue = issue;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPages = totalPages;
		this.isbn = isbn;
		this.issn = issn;
		this.uri = uri;
		this.resultPublicationTitles = resultPublicationTitles;
		this.resultPublicationSubtitles = resultPublicationSubtitles;
		this.resultPublicationAbstracts = resultPublicationAbstracts;
		this.resultPublicationKeywords = resultPublicationKeywords;
		this.resultPublicationBibliographicNotes = resultPublicationBibliographicNotes;
		this.resultPublicationNameAbbreviations = resultPublicationNameAbbreviations;
		this.resultPublicationVersionInfos = resultPublicationVersionInfos;
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
	 * @return the resultProducts
	 */
	public Set<ResultPublication_ResultProduct> getResultProducts() {
		return resultProducts;
	}

	/**
	 * @param resultProducts the resultProducts to set
	 */
	public void setResultProducts(
			Set<ResultPublication_ResultProduct> resultProducts) {
		this.resultProducts = resultProducts;
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
	 * @return the organisationUnit_resultPublications
	 */
	public Set<OrganisationUnit_ResultPublication> getOrganisationUnit_ResultPublication() {
		return organisationUnit_resultPublications;
	}

	/**
	 * @param organisationUnit_resultPublications the organisationUnit_resultPublications to set
	 */
	public void setOrganisationUnit_ResultPublication(
			Set<OrganisationUnit_ResultPublication> organisationUnit_resultPublications) {
		this.organisationUnit_resultPublications = organisationUnit_resultPublications;
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
	 * @return the resultPublications1_resultPublications
	 */
	public Set<ResultPublication_ResultPublication> getResultPublications1_resultPublications() {
		return resultPublications1_resultPublications;
	}

	/**
	 * @param resultPublications1_resultPublications the resultPublications1_resultPublications to set
	 */
	public void setResultPublications1_resultPublications(
			Set<ResultPublication_ResultPublication> resultPublications1_resultPublications) {
		this.resultPublications1_resultPublications = resultPublications1_resultPublications;
	}

	/**
	 * @return the resultPublications2_resultPublications
	 */
	public Set<ResultPublication_ResultPublication> getResultPublications2_resultPublications() {
		return resultPublications2_resultPublications;
	}

	/**
	 * @param resultPublications2_resultPublications the resultPublications2_resultPublications to set
	 */
	public void setResultPublications2_resultPublications(
			Set<ResultPublication_ResultPublication> resultPublications2_resultPublications) {
		this.resultPublications2_resultPublications = resultPublications2_resultPublications;
	}

	public ResultPublicationTitle findOriginalTranslation() {
		for (ResultPublicationTitle translation : resultPublicationTitles) {
			System.out.format("Found %s", translation.getTitle());
			if (translation.getTranslation().equals(Translation.ORIGINAL)) return translation;
		}
		return null;
	}
	
	public ResultPublicationTitle findTranslationByLanguage(String language) {
		for (ResultPublicationTitle translation : resultPublicationTitles) {
			if (translation.getLanguage().getCode().equalsIgnoreCase(language)) return translation;
		}
		return null;
	}
}

package gr.ekt.cerif.entities.base;

import gr.ekt.cerif.entities.result.ResultPublicationView;
import gr.ekt.cerif.entities.second.Funding;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectView {

	/**
	 * The Id
	 */
	private Long id;
	
	/**
	 * The start date.
	 */
	private Date startDate;
	
	/**
	 * The end date.
	 */
	private Date endDate;
	
	/**
	 * The acronym.
	 */
	private String acronym;
	

	/**
	 * The fundings.
	 */
	private List<Funding> fundings;
	
	/**
	 * The funding.
	 */
	private String funding;
	
	/**
	 * The title.
	 */
	private String title;
		
	/**
	 * The factsheet.
	 */
	private String factsheet;
	
	/**
	 * The website.
	 */
	private String website;
	
	/**
	 * The organisationstatus.
	 */
	private String organisationstatus;
	
	/**
	 * The domain.
	 */
	private String domain;
	
	/**
	 * The files.
	 */
	private List<ResultPublicationView> files;
	
	private String projectAbstract;
	
	/**
	 * default
	 */
	public ProjectView() {
		super();
	}
	
	/**
	 * @param id
	 * @param startDate
	 * @param endDate
	 * @param acronym
	 * @param title
	 * @param website
	 * @param fundings
	 * @param factsheet
	 */
	public ProjectView(Long id, String acronym, Date startDate, Date endDate,
			String title, String website, ArrayList<Funding> fundings,
			String factsheet) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.acronym = acronym;
		this.factsheet = factsheet;
		this.fundings = fundings;
		this.website = website;
		this.title = title;
	}
	
	/**
	 * @param id
	 * @param startDate
	 * @param endDate
	 * @param acronym
	 * @param title
	 * @param website
	 * @param funding
	 * @param factsheet
	 */
	public ProjectView(Long id, String acronym, Date startDate, Date endDate,
			String title, String website, String funding, String projectAbstract) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.acronym = acronym;
		this.funding = funding;
		this.website = website;
		this.title = title;
		this.projectAbstract = projectAbstract;
	}
	
	/**
	 * @param id
	 * @param startDate
	 * @param endDate
	 * @param acronym
	 * @param title
	 * @param website
	 * @param fundings
	 */
	public ProjectView(Long id, String acronym, Date startDate, Date endDate,
			String title, String website, ArrayList<Funding> fundings) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.acronym = acronym;
		this.fundings = fundings;
		this.website = website;
		this.title = title;
	}
	
	/**
	 * @param id
	 * @param startDate
	 * @param endDate
	 * @param acronym
	 * @param title
	 * @param website
	 */
	public ProjectView(Long id, String acronym, Date startDate, Date endDate,
			String title, String website) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.acronym = acronym;
		this.website = website;
		this.title = title;
	}
	
	
	/**
	 * @param id
	 * @param title
	 */
	public ProjectView(Long id, String acronym, String title, String organisationstatus) {
		super();
		this.id = id;
		this.acronym = acronym;
		this.title = title;
		this.organisationstatus = organisationstatus;
	}
	
	/**
	 * @param id
	 * @param acronym
	 */
	public ProjectView(Long id, String acronym) {
		super();
		this.id = id;
		this.acronym = acronym;
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
	 * Returns the start date.
	 * @return the start date.
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 * @param startDate the start date.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Returns the end date.
	 * @return the end date.
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 * @param endDate the end date.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Returns the acronym.
	 * @return the acronym.
	 */
	public String getAcronym() {
		return acronym;
	}

	/**
	 * Sets the acronym.
	 * @param acronym the acronym.
	 */
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	
		
	/**
	 * Returns the fundings.
	 * @return the fundings.
	 */
	public List<Funding> getFundings() {
		return fundings;
	}

	/**
	 * Sets the fundings.
	 * @param fundings the fundings.
	 */
	public void setFundings(List<Funding> fundings) {
		this.fundings = fundings;
	}
	
	/**
	 * Returns the funding.
	 * @return the funding.
	 */
	public String getFunding() {
		return funding;
	}

	/**
	 * Sets the funding.
	 * @param funding the funding.
	 */
	public void setFunding(String funding) {
		this.funding = funding;
	}
	
	/**
	 * Returns the title.
	 * @return the title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 * @param title the title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Returns the factsheet.
	 * @return the factsheet.
	 */
	public String getFactsheet() {
		return factsheet;
	}

	/**
	 * Sets the factsheet.
	 * @param factsheet the factsheet.
	 */
	public void setFactsheet(String factsheet) {
		this.factsheet = factsheet;
	}
	
	/**
	 * Returns the website.
	 * @return the website.
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * Sets the website.
	 * @param website the website.
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
		
	/**
	 * @return the organisationstatus
	 */
	public String getOrganisationstatus() {
		return organisationstatus;
	}

	/**
	 * @param organisationstatus the organisationstatus to set
	 */
	public void setOrganisationstatus(String organisationstatus) {
		this.organisationstatus = organisationstatus;
	}
	
	/**
	 * Returns the domain.
	 * @return the domain.
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * Sets the domain.
	 * @param domain the domain.
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	/**
	 * @return the files
	 */
	public List<ResultPublicationView> getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(List<ResultPublicationView> files) {
		this.files = files;
	}
	
	public String getProjectAbstract() {
		return projectAbstract;
	}
	
	public void setProjectAbstract(String projectAbstract) {
		this.projectAbstract = projectAbstract;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectView [id=" + id + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", acronym=" + acronym
				+ ", funding=" + fundings + ", title=" + title + ", factsheet="
				+ factsheet + ", website=" + website + ", organisationstatus="
				+ organisationstatus + "]";
	}

	

}


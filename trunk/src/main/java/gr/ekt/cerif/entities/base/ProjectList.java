package gr.ekt.cerif.entities.base;

import java.util.Date;

public class ProjectList {
	
	/*
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
	 * The title.
	 */
	private String title;
	
	/**
	 * The domain.
	 */
	private String domain;
	
	/**
	 * The website.
	 */
	private String website;
	
	/**
	 * The noDocs.
	 */
	private Long noDocs;
	
	public ProjectList() {
		//
	}
	
	
	/**
	 * @param startDate
	 * @param id
	 * @param endDate
	 * @param acronym
	 * @param title
	 * @param domain
	 * @param website
	 */
	public ProjectList(Long id, Date startDate, Date endDate, String acronym,
			String title, String domain, String website) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.acronym = acronym;
		this.title = title;
		this.domain = domain;
		this.website = website;
	}
	
	/**
	 * @param startDate
	 * @param id
	 * @param endDate
	 * @param acronym
	 * @param title
	 * @param website
	 */
	public ProjectList(Long id, Date startDate, Date endDate, String acronym,
			String title, String website) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.acronym = acronym;
		this.title = title;
		this.website = website;
	}
	
	/**
	 * @param id
	 * @param acronym
	 */
	public ProjectList(Long id, String acronym) {
		super();
		this.id = id;
		this.acronym = acronym;
	}
	
	/**
	 * @param id
	 * @param domain
	 */
	public ProjectList(String domain, Long id) {
		super();
		this.id = id;
		this.domain = domain;
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
	 * Returns the title.
	 * @return the title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the URI.
	 * @param uri the URI.
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @param domain.
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the noDocs
	 */
	public Long getNoDocs() {
		return noDocs;
	}


	/**
	 * @param noDocs the noDocs to set
	 */
	public void setNoDocs(Long noDocs) {
		this.noDocs = noDocs;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectList [acronym=" + acronym + ", id=" + id + ", "+
				"startDate=" + startDate + ", endDate=" + endDate +
				", title=" + title +", domain="+domain+
				", website=" + website +"]"+"\n";
	}

}

package gr.ekt.exampleapp.transferobjects;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ProjectView {
	
	private Long id;
	private String acronym;
	private String title;
	private String abstractText;
	private Date startDate;
	private Date endDate;
	private ClassView status;
	private String roleofOrganisation;
	private Map<String, List<OrganisationView>> organisations;
	
	
	/**
	 * @return the acronym
	 */
	public String getAcronym() {
		return acronym;
	}


	/**
	 * @param acronym the acronym to set
	 */
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the abstractText
	 */
	public String getAbstractText() {
		return abstractText;
	}


	/**
	 * @param abstractText the abstractText to set
	 */
	public void setAbstractText(String abstractText) {
		this.abstractText = abstractText;
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}


	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}


	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	/**
	 * @return the organisations
	 */
	public Map<String, List<OrganisationView>> getOrganisations() {
		return organisations;
	}


	/**
	 * @param organisations the organisations to set
	 */
	public void setOrganisations(Map<String, List<OrganisationView>> organisations) {
		this.organisations = organisations;
	}


	/**
	 * @return the roleofOrganisation
	 */
	public String getRoleofOrganisation() {
		return roleofOrganisation;
	}


	/**
	 * @param roleofOrganisation the roleofOrganisation to set
	 */
	public void setRoleofOrganisation(String roleofOrganisation) {
		this.roleofOrganisation = roleofOrganisation;
	}


	/**
	 * @param id
	 * @param acronym
	 * @param title
	 * @param abstractText
	 * @param startDate
	 * @param endDate
	 */
	public ProjectView(Long id, String acronym, String title,
			String abstractText, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.acronym = acronym;
		this.title = title;
		this.abstractText = abstractText;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	
	/**
	 * @param id
	 * @param title
	 * @param roleofOrganisation
	 */
	public ProjectView(Long id, String title, String roleofOrganisation) {
		super();
		this.id = id;
		this.title = title;
		this.roleofOrganisation = roleofOrganisation;
	}


	/**
	 * @return the status
	 */
	public ClassView getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(ClassView status) {
		this.status = status;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectView [id=" + id + ", acronym=" + acronym + ", title="
				+ title + ", abstractText=" + abstractText + ", startDate="
				+ startDate + ", endDate=" + endDate + ", status="
				+ status + ", roleofOrganisation="
				+ roleofOrganisation + ", organisations=" + organisations + "]";
	}

	
}

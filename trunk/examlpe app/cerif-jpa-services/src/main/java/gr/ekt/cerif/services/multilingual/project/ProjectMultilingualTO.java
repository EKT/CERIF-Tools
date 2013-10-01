package gr.ekt.cerif.services.multilingual.project;

import gr.ekt.cerif.features.multilingual.ProjectAbstract;
import gr.ekt.cerif.features.multilingual.ProjectKeyword;
import gr.ekt.cerif.features.multilingual.ProjectTitle;

import java.util.List;


public class ProjectMultilingualTO {

	/**
	 * The project unique identifier.
	 */
	private Long id;
	
	/**
	 * The project titles.
	 */
	private List<ProjectTitle> projectTitles;
	
	/**
	 * The project abstracts.
	 */
	private List<ProjectAbstract> projectAbstracts;
	
	/**
	 * The project keywords.
	 */
	private List<ProjectKeyword> projectKeywords;

	/**
	 * @param id
	 * @param projectTitles
	 * @param projectAbstracts
	 * @param projectKeywords
	 */
	public ProjectMultilingualTO(Long id, List<ProjectTitle> projectTitles,
			List<ProjectAbstract> projectAbstracts,
			List<ProjectKeyword> projectKeywords) {
		super();
		this.id = id;
		this.projectTitles = projectTitles;
		this.projectAbstracts = projectAbstracts;
		this.projectKeywords = projectKeywords;
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
	 * @return the projectTitles
	 */
	public List<ProjectTitle> getProjectTitles() {
		return projectTitles;
	}

	/**
	 * @param projectTitles the projectTitles to set
	 */
	public void setProjectTitles(List<ProjectTitle> projectTitles) {
		this.projectTitles = projectTitles;
	}

	/**
	 * @return the projectAbstracts
	 */
	public List<ProjectAbstract> getProjectAbstracts() {
		return projectAbstracts;
	}

	/**
	 * @param projectAbstracts the projectAbstracts to set
	 */
	public void setProjectAbstracts(List<ProjectAbstract> projectAbstracts) {
		this.projectAbstracts = projectAbstracts;
	}

	/**
	 * @return the projectKeywords
	 */
	public List<ProjectKeyword> getProjectKeywords() {
		return projectKeywords;
	}

	/**
	 * @param projectKeywords the projectKeywords to set
	 */
	public void setProjectKeywords(List<ProjectKeyword> projectKeywords) {
		this.projectKeywords = projectKeywords;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectMultilingualTO [id=" + id + ", projectTitles="
				+ projectTitles + ", projectAbstracts=" + projectAbstracts
				+ ", projectKeywords=" + projectKeywords + "]";
	}

	
}

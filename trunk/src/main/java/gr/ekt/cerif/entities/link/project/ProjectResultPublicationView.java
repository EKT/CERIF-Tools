package gr.ekt.cerif.entities.link.project;

public class ProjectResultPublicationView {

	/**
	 * The project id.
	 */
	private Long projectId;
	
	/**
	 * The project name.
	 */
	private String projectName;
	
	/**
	 * The resultPublication id.
	 */
	private Long resultPublicationId;
	
	/**
	 * The className (author, editor, creator) 
	 */
	private String className;
	
	

	/**
	 * @param projectId
	 * @param projectName
	 * @param resultPublicationId  
	 */
	public ProjectResultPublicationView(Long projectId,
			String projectName, Long resultPublicationId) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.resultPublicationId = resultPublicationId;		
	}

	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the resultPublicationId
	 */
	public Long getResultPublicationId() {
		return resultPublicationId;
	}

	/**
	 * @param resultPublicationId the resultPublicationId to set
	 */
	public void setResultPublicationId(Long resultPublicationId) {
		this.resultPublicationId = resultPublicationId;
	}
	
	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectResultPublicationView [projectId=" + projectId
				+ ", projectName=" + projectName + ", resultPublicationId="
				+ resultPublicationId + ", className=" + className + "]";
	}
	
	
	


}

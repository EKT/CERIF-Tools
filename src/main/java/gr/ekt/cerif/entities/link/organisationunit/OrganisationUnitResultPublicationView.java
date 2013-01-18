package gr.ekt.cerif.entities.link.organisationunit;

public class OrganisationUnitResultPublicationView {

	/**
	 * The organisation id.
	 */
	private Long organisationId;
	
	/**
	 * The organisation name.
	 */
	private String organisationName;
	
	/**
	 * The resultPublication id.
	 */
	private Long resultPublicationId;
	
	/**
	 * The className (RI NCP, RI policy body, Εuropean Commission, NCP network (for source), author institution, external institution) 
	 */
	private String className;
	
	

	/**
	 * @param organisationId
	 * @param organisationName
	 * @param resultPublicationId
	 * @param className
	 */
	public OrganisationUnitResultPublicationView(Long organisationId,
			String organisationName, Long resultPublicationId, String className) {
		super();
		this.organisationId = organisationId;
		this.organisationName = organisationName;
		this.resultPublicationId = resultPublicationId;
		this.className = className;
	}
	
	public OrganisationUnitResultPublicationView() {
		super();
	}

	/**
	 * @return the organisationId
	 */
	public Long getOrganisationId() {
		return organisationId;
	}

	/**
	 * @param organisationId the organisationId to set
	 */
	public void setOrganisationId(Long organisationId) {
		this.organisationId = organisationId;
	}

	/**
	 * @return the organisationName
	 */
	public String getOrganisationName() {
		return organisationName;
	}

	/**
	 * @param organisationName the organisationName to set
	 */
	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
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
		return "OrganisationUnitResultPublicationView [organisationId="
				+ organisationId + ", organisationName=" + organisationName
				+ ", resultPublicationId=" + resultPublicationId
				+ ", className=" + className + "]";
	}
	
	
}

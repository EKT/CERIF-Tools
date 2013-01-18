package gr.ekt.cerif.entities.link.result;

import gr.ekt.cerif.entities.second.Medium;

public class ResultPublicationMediumView {
	
	/**
	 * The medium.
	 */
	private Medium medium;
	
	
	/**
	 * The resultPublication id.
	 */
	private Long resultPublicationId;
	
	/**
	 * The resultPublication title.
	 */
	private String resultPublicationTitle;
	
	/**
	 * The className (author, editor, creator) 
	 */
	private String className;
	
	/**
	 * @param medium
	 * @param resultPublicationId
	 * @param className
	 */
	public ResultPublicationMediumView(Medium medium, Long resultPublicationId,
			String className, String title) {
		super();
		this.medium = medium;
		this.resultPublicationId = resultPublicationId;
		this.className = className;
		this.resultPublicationTitle = title;
	}
	
	
	/**
	 * @param medium
	 * @param resultPublicationId
	 * @param className
	 */
	public ResultPublicationMediumView(Medium medium, Long resultPublicationId,
			String className) {
		super();
		this.medium = medium;
		this.resultPublicationId = resultPublicationId;
		this.className = className;
	}
	
	/**
	 * @param medium
	 * @param resultPublicationId
	 */
	public ResultPublicationMediumView(Medium medium, Long resultPublicationId) {
		super();
		this.medium = medium;
		this.resultPublicationId = resultPublicationId;
	}
	
	/**
	 * @param medium
	 */
	public ResultPublicationMediumView(Medium medium) {
		super();
		this.medium = medium;
	}

	

	/**
	 * @return the medium
	 */
	public Medium getMedium() {
		return medium;
	}



	/**
	 * @param medium the medium to set
	 */
	public void setMedium(Medium medium) {
		this.medium = medium;
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
	 * @return the resultPublicationTitle
	 */
	public String getResultPublicationTitle() {
		return resultPublicationTitle;
	}


	/**
	 * @param resultPublicationTitle the resultPublicationTitle to set
	 */
	public void setResultPublicationTitle(String resultPublicationTitle) {
		this.resultPublicationTitle = resultPublicationTitle;
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
		return "ResultPublicationMediumView [medium=" + medium
				+ ", resultPublicationId=" + resultPublicationId
				+ ", className=" + className + "]";
	}

	
}

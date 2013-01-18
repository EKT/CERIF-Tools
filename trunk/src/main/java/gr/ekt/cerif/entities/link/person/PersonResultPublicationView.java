package gr.ekt.cerif.entities.link.person;

public class PersonResultPublicationView {

	/**
	 * The person id.
	 */
	private Long personId;
	
	/**
	 * The person name.
	 */
	private String personName;
	
	/**
	 * The resultPublication id.
	 */
	private Long resultPublicationId;
	
	/**
	 * The className (author, editor, creator) 
	 */
	private String className;
	
	/**
	 * The firstName.
	 */
	private String firstName;
	
	/**
	 * The lastName.
	 */
	private String lastName;
	
	

	/**
	 * @param personId
	 * @param personName
	 * @param resultPublicationId
	 * @param className
	 */
	public PersonResultPublicationView(Long personId,
			String firstName, String lastName, Long resultPublicationId, String className) {
		super();
		if (firstName==null) {firstName="";}
		if (lastName==null) {lastName="";}
		this.personName = firstName.trim()+" "+lastName.trim();
		this.personId = personId;
		this.resultPublicationId = resultPublicationId;
		this.className = className;
	}
	
	/**
	 * @param personId
	 * @param resultPublicationId
	 *  @param className
	 */
	public PersonResultPublicationView(Long personId, Long resultPublicationId, String className) {
		super();
		this.personId = personId;
		this.resultPublicationId = resultPublicationId;
		this.className = className;
	}

	/**
	 * @return the personId
	 */
	public Long getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return "PersonResultPublicationView [personId=" + personId
				+ ", personName=" + personName + ", resultPublicationId="
				+ resultPublicationId + ", className=" + className + "]";
	}	
	
	
}


package gr.ekt.cerif.entities.base;

import java.util.List;

public class PersonList {

	/**
	 * The name.
	 */
	private String name;
	
	/**
	 * The firstName.
	 */
	private String firstName;
	
	/**
	 * The lastName.
	 */
	private String lastName;
	
	/**
	 * The id.
	 */
	private Long id;
	
	/**
	 * The projectid.
	 */
	private Long projectid;
	
	/**
	 * The projectacro.
	 */
	private String projectacro;
	
	/**
	 * The projects.
	 */
	private List<ProjectList> projects;
	
	/**
	 * The email.
	 */
	private String email;
	
	/**
	 * The tel.
	 */
	private String tel;
	
	
	/**
	 * The stakeholder.
	 */
	private String stakeholder;
	
	/**
	 * The country.
	 */
	private String country;
	
	/**
	 * The organisation.
	 */
	private String organisation;
	
	/**
	 * The organisationId.
	 */
	private Long organisationId;
	
	/**
	 * The pbRole.
	 */
	private String pbRole;
	
	/**
	 * The registrationStatus.
	 */
	private String registrationStatus;
	
	/**
	 * The stakeholder list.
	 */
	private List<String> stakeholders;
	
	/**
	 * The policy body.
	 */
	private List<String> policyBodies;
	
	/**
	 * The photo.
	 */
	private String photo;
	
	public PersonList() {
		//default constructor
	}
	
	/**
	 * @param name
	 * @param id
	 * @param email
	 * @param tel
	 * @param stakeholder
	 * @param country
	 */
	public PersonList(Long id, String name, String email, String tel,
			String stakeholder, String organisation, String country) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.tel = tel;
		this.stakeholder = stakeholder;
		this.organisation = organisation;
		this.country = country;
	}
			
	/**
	 * @param name
	 * @param id
	 * @param email
	 * @param tel
	 * @param stakeholder
	 */
	public PersonList(Long id, String name, String email, String tel, String stakeholder, String organisation) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.tel = tel;
		this.stakeholder = stakeholder;
		this.organisation = organisation;
	}
	
	/**
	 * @param name
	 * @param id
	 * @param stakeholder
	 * @param organisation
	 */
	public PersonList(Long id, String name, String stakeholder, String organisation) {
		super();
		this.name = name;
		this.id = id;
		this.stakeholder = stakeholder;
		this.organisation = organisation;
	}
	
	/**
	 * @param name
	 * @param id
	 * @param stakeholder
	 * @param pbRole
	 * @param country
	 */
	public PersonList(String firstName, String lastName, String pbRole, String stakeholder,
			String country, Long id) {
		super();
		if (firstName==null) {firstName="";}
		if (lastName==null) {lastName="";}
		this.name = firstName.trim()+" "+lastName.trim();
		this.id = id;
		this.stakeholder = stakeholder;
		this.pbRole = pbRole;
		this.country = country;
	}
	
	/**
	 * @param name
	 * @param id
	 * @param stakeholder
	 * @param pbRole
	 */
	public PersonList(String firstName, String pbRole, String stakeholder,
			Long id, String lastName) {
		super();
		if (firstName==null) {firstName="";}
		if (lastName==null) {lastName="";}
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.stakeholder = stakeholder;
		this.pbRole = pbRole;
		this.name = firstName.trim()+" "+lastName.trim();
	}
	
	
	/**
	 * @param name
	 * @param id
	 * @param pbRole
	 */
	public PersonList(String firstName, String lastName, String pbRole, Long id) {
		super();
		if (firstName==null) {firstName="";}
		if (lastName==null) {lastName="";}
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.pbRole = pbRole;
		this.name =firstName.trim()+" "+lastName.trim();
	}
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param id
	 * @param country
	 */
	public PersonList(Long id, String country, String firstName, String lastName, Long id2) {
		super();
		if (firstName==null) {firstName="";}
		if (lastName==null) {lastName="";}
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.country = country;
		this.name =firstName.trim()+" "+lastName.trim();
	}
	
	/**
	 * @param name
	 * @param id
	 * @param country
	 */
	public PersonList(String country, Long id, String name, String organisation) {
		super();
		this.name = name;
		this.id = id;
		this.country = country;
		this.organisation = organisation;
	}
	
	/**
	 * @param name
	 * @param id
	 * @param country
	 */
	public PersonList(String country, Long id, String firstName, String lastName, String organisation, Long organisationId) {
		super();
		if (firstName==null) {firstName="";}
		if (lastName==null) {lastName="";}
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.country = country;
		this.organisation = organisation;
		this.organisationId = organisationId;
		this.name = firstName.trim()+" "+lastName.trim();
	}
	
	public PersonList(String country, Long id, String name, String organisation, String pbRole, String email) {
		super();
		this.name = name;
		this.id = id;
		this.country = country;
		this.organisation = organisation;
		this.pbRole = pbRole;
		this.email = email;
	}
	
	public PersonList(Long id, String firstName, String lastName, String email, String tel) {
		super();
		if (firstName==null) {firstName="";}
		if (lastName==null) {lastName="";}
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.email = email;
		this.tel = tel;
		this.name = firstName.trim()+" "+lastName.trim();
	}
	
	public PersonList(String country, Long id, String firstName, String lastName, String organisation, Long organisationId, String pbRole, String email, String photo) {
		super();
		if (firstName==null) {firstName="";}
		if (lastName==null) {lastName="";}
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.country = country;
		this.organisation = organisation;
		this.organisationId = organisationId;
		this.pbRole = pbRole;
		this.email = email;
		this.photo = photo;
		this.name = firstName.trim()+" "+lastName.trim();
	}
	
	public PersonList(Long id, String name, String registrationStatus) {
		super();
		this.registrationStatus=registrationStatus;
		this.name = name;
		this.id = id;
	}
	
	public PersonList(String lastName, String firstName, Long id, String registrationStatus) {
		super();
		if (firstName==null) {firstName="";}
		if (lastName==null) {lastName="";}
		this.registrationStatus=registrationStatus;
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
		this.name = firstName.trim()+" "+lastName.trim();
	}
	

	/**
	 * @param name
	 * @param id
	 */
	public PersonList(String firstName, Long id, String lastName) {
		super();
		if (firstName==null) {firstName="";}
		if (lastName==null) {lastName="";}
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.name = firstName.trim()+" "+lastName.trim();
	}
	
	/**
	 * @param lastName
	 * @param firstName
	 * @param id
	 */
	public PersonList(String firstName, String lastName, Long id, Long id2) {
		super();
		if (firstName==null) {firstName="";}
		if (lastName==null) {lastName="";}
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.name = firstName.trim()+" "+lastName.trim();
	}
	
	/**
	 * @param name
	 * @param id
	 * @param projectid
	 * @param projectacro
	 */
	public PersonList(Long id, String firstName, String lastName, Long projectid, String projectacro) {
		super();
		if (firstName==null) {firstName="";}
		if (lastName==null) {lastName="";}
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.name = firstName.trim()+" "+lastName.trim();
		this.projectid = projectid;
		this.projectacro = projectacro;
	}

	/**
	 * Returns the id.
	 * @return the id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id the id.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Returns the name.
	 * @return the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * @param name the name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	

	public String getFirstName() {
		return firstName;
	}

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
	 * Returns the email.
	 * @return the email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * @param email the email.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Returns the telephone number.
	 * @return the tel.
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * Sets the telephone number.
	 * @param tel the telephone number.
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	
	/**
	 * @return the stakeholder
	 */
	public String getStakeholder() {
		return stakeholder;
	}

	/**
	 * @param stakeholder the stakeholder to set
	 */
	public void setStakeholder(String stakeholder) {
		this.stakeholder = stakeholder;
	}

	/**
	 * @return the organisation
	 */
	public String getOrganisation() {
		return organisation;
	}


	/**
	 * @param organisation the organisation to set
	 */
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	
	/**
	 * @return the pbRole
	 */
	public String getPbRole() {
		return pbRole;
	}

	/**
	 * @param pbRole the pbRole to set
	 */
	public void setPbRole(String pbRole) {
		this.pbRole = pbRole;
	}

	/**
	 * @return the stakeholders
	 */
	public List<String> getStakeholders() {
		return stakeholders;
	}

	/**
	 * @param stakeholders the stakeholders to set
	 */
	public void setStakeholders(List<String> stakeholders) {
		this.stakeholders = stakeholders;
	}

	/**
	 * @return the policyBodies
	 */
	public List<String> getPolicyBodies() {
		return policyBodies;
	}

	/**
	 * @param policyBodies the policyBodies to set
	 */
	public void setPolicyBodies(List<String> policyBodies) {
		this.policyBodies = policyBodies;
	}
	
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Returns the projectid.
	 * @return the projectid.
	 */
	public Long getProjectid() {
		return projectid;
	}

	/**
	 * Sets the projectid.
	 * @param projectid the projectid.
	 */
	public void setProjectid(Long projectid) {
		this.projectid = projectid;
	}
	
	/**
	 * @return the projectacro
	 */
	public String getProjectacro() {
		return projectacro;
	}

	/**
	 * @param projectacro the projectacro to set
	 */
	public void setProjectacro(String projectacro) {
		this.projectacro = projectacro;
	}
	
	
	/**
	 * @return the projects
	 */
	public List<ProjectList> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(List<ProjectList> projects) {
		this.projects = projects;
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
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	/**
	 * @return the registrationStatus
	 */
	public String getRegistrationStatus() {
		return registrationStatus;
	}

	/**
	 * @param registrationStatus the registrationStatus to set
	 */
	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonList [name=" + name + ", id=" + id + ", email=" + email
				+ ", tel=" + tel + ", stakeholder=" + stakeholder
				+ ", organisation=" + organisation + ", country=" +
				country +", pbRole=" + pbRole + ", projectacro=" + projectacro +
				", projectid=" + projectid +"]";
	}



	
	
}

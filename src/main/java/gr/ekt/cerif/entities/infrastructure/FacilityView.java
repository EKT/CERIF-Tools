package gr.ekt.cerif.entities.infrastructure;

public class FacilityView {
	/**
	 * The id.
	 */
	private Long id;
	
	/**
	 * The acronym.
	 */
	private String acronym;
	
	/**
	 * The title.
	 */
	private String title;
	
	/**
	 * The description.
	 */
	private String description;
	
	/**
	 * The funding.
	 */
	private String funding;
	
	/**
	 * The organisation.
	 */
	private String organisation;
	
	/**
	 * The country.
	 */
	private String country;
	
	/**
	 * The website.
	 */
	private String website;
	
	/**
	 * The contact person.
	 */
	private String contactPerson;
	
	/**
	 * The contact person ID.
	 */
	private Long contactPersonID;
	
	/**
	 * The email.
	 */
	private String email;
	


	public FacilityView(String acronym, String title, String description,
			String funding, String organisation, String country,
			String website, String contactPerson, String email) {
		super();
		this.acronym = acronym;
		this.title = title;
		this.description = description;
		this.funding = funding;
		this.organisation = organisation;
		this.country = country;
		this.website = website;
		this.contactPerson = contactPerson;
		this.email = email;
	}
	
	public FacilityView(String acronym, String title, String description,
			String funding, String website, String contactPerson, String email) {
		super();
		this.acronym = acronym;
		this.title = title;
		this.description = description;
		this.funding = funding;		
		this.website = website;
		this.contactPerson = contactPerson;
		this.email = email;
	}
	
	public FacilityView(String acronym, String title, String description,
			String funding, String website) {
		super();
		this.acronym = acronym;
		this.title = title;
		this.description = description;
		this.funding = funding;		
		this.website = website;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the funding
	 */
	public String getFunding() {
		return funding;
	}

	/**
	 * @param funding the funding to set
	 */
	public void setFunding(String funding) {
		this.funding = funding;
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
	 * @return the contactPerson
	 */
	public String getContactPerson() {
		return contactPerson;
	}

	/**
	 * @param contactPerson the contactPerson to set
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	/**
	 * @return the contactPersonID
	 */
	public Long getContactPersonID() {
		return contactPersonID;
	}

	/**
	 * @param contactPersonID the contactPersonID to set
	 */
	public void setContactPersonID(Long contactPersonID) {
		this.contactPersonID = contactPersonID;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FacilityView [acronym=" + acronym + ", title=" + title
				+ ", description=" + description + ", funding=" + funding
				+ ", organisation=" + organisation + ", country=" + country
				+ ", website=" + website + ", contactPerson=" + contactPerson
				+ ", email=" + email + "]";
	}

	
	
	
}

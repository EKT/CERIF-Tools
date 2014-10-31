package gr.ekt.exampleapp.transferobjects;

import java.util.ArrayList;

public class PersonView {

	private Long id;
	private String firstName;
	private String lastName;
	private ArrayList<OrganisationView> organisations;
	private String roleInOrg;
	
	/**
	 * Default constructor
	 */
	public PersonView() {
	}
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 */
	public PersonView(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param roleInOrg
	 */
	public PersonView(Long id, String firstName, String lastName,
			String roleInOrg) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleInOrg = roleInOrg;
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
	 * @return the organisations
	 */
	public ArrayList<OrganisationView> getOrganisations() {
		return organisations;
	}

	/**
	 * @param organisations the organisations to set
	 */
	public void setOrganisations(ArrayList<OrganisationView> organisations) {
		this.organisations = organisations;
	}

	/**
	 * @return the roleInOrg
	 */
	public String getRoleInOrg() {
		return roleInOrg;
	}

	/**
	 * @param roleInOrg the roleInOrg to set
	 */
	public void setRoleInOrg(String roleInOrg) {
		this.roleInOrg = roleInOrg;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonView [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", organisations=" + organisations
				+ "]";
	}
	
	
}

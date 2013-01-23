package gr.ekt.cerif.entities.base;

public class OrganisationUnitList {
	
	/**
	 * The id.
	 */
	private Long id;
	
	/**
	 * The name.
	 */
	private String name;
		
	/**
	 * The classuri.
	 */
	private String classuri;
	
	/**
	 * The orgunituri.
	 */
	private String orgunituri;
	
	/**
	 * The country.
	 */
	private String country;
	
	/**
	 * The postal Address.
	 */
	private String postalAddress;
	
	/**
	 * The count.
	 */
	private Long count;
	
	/**
	 * @param id
	 * @param name
	 * @param classuri
	 * @param country
	 */
	public OrganisationUnitList(Long id, String name, String classuri, String country) {
		super();
		this.id = id;
		this.name = name;
		this.classuri = classuri;
		this.country = country;
	}

	/**
	 * @param id
	 * @param name
	 * @param classuri
	 * @param country
	 * @param count
	 */
	public OrganisationUnitList(Long id, String name, String classuri, String orgunituri, String country, Long count) {
		super();
		this.id = id;
		this.name = name;
		this.classuri = classuri;
		this.orgunituri = orgunituri;
		this.country = country;
		this.count = count;
	}
	
	/**
	 * @param id
	 * @param name
	 * @param classuri
	 * @param country
	 * @param count
	 */
	public OrganisationUnitList(Long id, String name, String classuri, String orgunituri, String country) {
		super();
		this.id = id;
		this.name = name;
		this.classuri = classuri;
		this.orgunituri = orgunituri;
		this.country = country;
	}

	/**
	 * @param id
	 * @param name
	 * @param country
	 */
	public OrganisationUnitList(String name, Long id, String country, String postalAddress) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.postalAddress = postalAddress;
	}
	
	/**
	 * @param id
	 * @param name
	 */
	public OrganisationUnitList(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	/**
	 */
	public OrganisationUnitList() {
		super();
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
	
	/**
	 * Returns the classuri.
	 * @return the classuri.
	 */
	public String getClassuri() {
		return classuri;
	}

	/**
	 * Sets the classuri.
	 * @param classuri the classuri.
	 */
	public void setClassuri(String classuri) {
		this.classuri = classuri;
	}
	
	public String getOrgunituri() {
		return orgunituri;
	}
	
	public void setOrgunituri(String orgunituri) {
		this.orgunituri = orgunituri;
	}
	
	/**
	 * Returns the country.
	 * @return the country.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 * @param country the country.
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	/**
	 * @return the postalAddress
	 */
	public String getPostalAddress() {
		return postalAddress;
	}

	/**
	 * @param postalAddress the postalAddress to set
	 */
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	
	public Long getCount() {
		return count;
	}
	
	public void setCount(Long count) {
		this.count = count;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrganisationUnitView [name=" + name + ", classuri=" + classuri+
				", id=" + id+ ", country=" + country+"]"+"\n";
	}

}

package gr.ekt.cerif.transferobjects;

import java.util.List;
import java.util.Map;

public class OrganisationView {

	private Long id;
	private String name;
	private String url;
	private String country;
	private String address;
	private String telephone;
	private String roleinProject;
	private ClassView type;
	private Map<String, List<ProjectView>> projects;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**
	 * @return the roleinProject
	 */
	public String getRoleinProject() {
		return roleinProject;
	}
	
	/**
	 * @param roleinProject the roleinProject to set
	 */
	public void setRoleinProject(String roleinProject) {
		this.roleinProject = roleinProject;
	}
	
	/**
	 * @return the type
	 */
	public ClassView getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(ClassView type) {
		this.type = type;
	}
	
	/**
	 * @return the projects
	 */
	public Map<String, List<ProjectView>> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(Map<String, List<ProjectView>> projects) {
		this.projects = projects;
	}

	/**
	 * @param id
	 * @param name
	 * @param url
	 * @param country
	 * @param address
	 * @param telephone
	 */
	public OrganisationView(Long id, String name, String url, String country,
			String address, String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.country = country;
		this.address = address;
		this.telephone = telephone;
	}
	
	/**
	 * @param id
	 * @param name
	 * @param roleinProject
	 */
	public OrganisationView(Long id, String name, String roleinProject) {
		super();
		this.id = id;
		this.name = name;
		this.roleinProject = roleinProject;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrganisationView [id=" + id + ", name=" + name + ", url=" + url
				+ ", country=" + country + ", address=" + address
				+ ", telephone=" + telephone + ", roleinProject="
				+ roleinProject + ", type=" + type + ", projects=" + projects
				+ "]";
	}	
	
	
	
}

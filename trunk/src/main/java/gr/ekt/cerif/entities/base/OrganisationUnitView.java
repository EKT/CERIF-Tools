package gr.ekt.cerif.entities.base;

import gr.ekt.cerif.entities.result.ResultPublicationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrganisationUnitView {
	
	/**
	 * The name.
	 */
	private Long id;
	
	/**
	 * The name.
	 */
	private String name;

	/**
	 * The acronym.
	 */
	private String acronym;
	
	/**
	 * The headCount.
	 */
	private Integer headCount;
	
	/**
	 * The country.
	 */
	private String country;
	
	/**
	 * The url.
	 */
	private String url;
	
	/**
	 * The address.
	 */
	private String address;
	
	/**
	 * The organisationstatus.
	 */
	private String organisationstatus;
	
	/**
	 * The files.
	 */
	private Map<String,List<ResultPublicationView>> files;
	
	/**
	 * The institutionRole.
	 */
	private ArrayList<String> institutionRole;
	
	public OrganisationUnitView() {
		super();
	}
	
	
	/**
	 * @param name
	 * @param country
	 * @param url
	 * @param organisationstatus
	 */
	public OrganisationUnitView(Long id, String name, String country, String url, String address, String organisationstatus) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.url = url;
		this.address = address;
		this.organisationstatus = organisationstatus;
	}
	
	/**
	 * @param name
	 * @param acronym
	 * @param headCount
	 * @param country
	 * @param url
	 * @param address
	 */
	public OrganisationUnitView(Long id, String name, String acronym, Integer headCount, String country, String url, String address) {
		super();
		this.id = id;
		this.name = name;
		this.acronym = acronym;
		this.headCount = headCount;
		this.country = country;
		this.url = url;
		this.address = address;
	}
	
	/**
	 * @param name
	 * @param country
	 * @param url
	 */
	public OrganisationUnitView(Long id, String name, String country, String url, String address) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.url = url;
		this.address = address;
	}
	
	/**
	 * @param name
	 * @param country
	 */
	public OrganisationUnitView(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}
	
	/**
	 * @param name
	 */
	public OrganisationUnitView(String name) {
		super();
		this.name = name;
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

	public String getAcronym() {
		return acronym;
	}
	
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	
	public Integer getHeadCount() {
		return headCount;
	}
	
	public void setHeadCount(Integer headCount) {
		this.headCount = headCount;
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
	 * Returns the url.
	 * @return the url.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 * @param url the url.
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * Returns the organisationstatus.
	 * @return the organisationstatus.
	 */
	public String getOrganisationstatus() {
		return organisationstatus;
	}

	/**
	 * Sets the organisationstatus.
	 * @param organisationstatus the organisationstatus.
	 */
	public void setOrganisationstatus(String organisationstatus) {
		this.organisationstatus = organisationstatus;
	}
	
	/**
	 * @return the files
	 */
	public Map<String,List<ResultPublicationView>> getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(Map<String,List<ResultPublicationView>> files) {
		this.files = files;
	}
	
	
	/**
	 * @return the institutionRole
	 */
	public ArrayList<String> getInstitutionRole() {
		return institutionRole;
	}

	/**
	 * @param institutionRole the institutionRole to set
	 */
	public void setInstitutionRole(ArrayList<String> institutionRole) {
		this.institutionRole = institutionRole;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrganisationUnitView [name=" + name + ", country=" + country+
				", url=" + url+", organisationstatus=" + organisationstatus+
				"]"+"\n";
	}

}

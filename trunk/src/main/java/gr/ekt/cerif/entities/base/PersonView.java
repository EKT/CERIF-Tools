package gr.ekt.cerif.entities.base;

import gr.ekt.cerif.entities.result.ResultPublicationView;

import java.util.List;
import java.util.Map;
import java.util.Date;

public class PersonView {
	/**
	 * The id.
	 */
	private Long id;
	
	/**
	 * The familyNames.
	 */
	private String familyNames;
	
	/**
	 * The firstName.
	 */
	private String firstNames;
	
	/**
	 * The name.
	 */
	private String name;
	
	/**
	 * The otherNames.
	 */
	private String otherNames;
	
	/**
	 * The title.
	 */
	private String title;
	
	/**
	 * The email.
	 */
	private String email;
	
	/**
	 * The tel.
	 */
	private String tel;
	
	/**
	 * The address.
	 */
	private String address;
	
	/**
	 * The orgname.
	 */
	private String orgname;
	
	/**
	 * The country.
	 */
	private String country;
	
	/**
	 * The photo.
	 */
	private String photo;
	
	/**
	 * The fieldOfInterest.
	 */
	private String fieldOfInterest;
	
	/**
	 * The summary.
	 */
	private String summary;
	
	/**
	 * The profile.
	 */
	private String profile;
	
	/**
	 * The registrationStatus.
	 */
	private String registrationStatus;
	
	/**
	 * The startDate.
	 */
	private Date startDate;
	
	/**
	 * The files.
	 */
	private Map<String,List<ResultPublicationView>> files;
	
	/**
	 * @param id
	 * @param familyNames
	 * @param email
	 * @param tel
	 * @param country
	 * @param orgname
	 * @param otherNames
	 */
	public PersonView(Long id, String familyNames, String email, String tel, 
			String orgname,String country, String otherNames) {
		super();
		this.id = id;
		this.familyNames = familyNames;
		this.email = email;
		this.tel = tel;
		this.orgname = orgname;
		this.country = country;
		this.otherNames = otherNames;
	}
	
	/**
	 * @param id
	 * @param familyNames
	 * @param email
	 * @param tel
	 * @param orgname
	 */
	public PersonView(Long id, String familyNames, String email, String tel,
			String orgname) {
		super();
		this.id = id;
		this.familyNames = familyNames;
		this.email = email;
		this.tel = tel;
		this.orgname = orgname;
	}
	
	
	public PersonView(String familyNames, Long id, String email, String tel, String address, String country) {
		super();
		this.id = id;
		this.familyNames = familyNames;
		this.email = email;
		this.tel = tel;
		this.address = address;
		this.country = country;
	}
	
	
	public PersonView(String familyNames, Long id, String email, String tel, String address, String country, String photo) {
		super();
		this.id = id;
		this.familyNames = familyNames;
		this.email = email;
		this.tel = tel;
		this.address = address;
		this.country = country;
		this.photo = photo;
	}
	
	public PersonView(String familyNames, String firstNames, Long id, String email, String tel, String address, String country, String photo) {
		super();
		this.id = id;
		this.familyNames = familyNames;
		this.firstNames = firstNames;
		this.email = email;
		this.tel = tel;
		this.address = address;
		this.country = country;
		this.photo = photo;
	}
	
	public PersonView(String familyNames, String firstNames, String otherNames, Long id, String email, String tel, String address, String country, String photo) {
		super();
		this.id = id;
		this.familyNames = familyNames;
		this.firstNames = firstNames;
		this.otherNames = otherNames;
		this.email = email;
		this.tel = tel;
		this.address = address;
		this.country = country;
		this.photo = photo;
	}
	
	public PersonView(String familyNames, String firstNames, String email) {
		super();
		this.familyNames = familyNames;
		this.firstNames = firstNames;
		this.email = email;
	}
	
	/**
	 * @param id
	 * @param familyNames
	 * @param email
	 */
	public PersonView(Long id, String firstNames, String familyNames, String email) {
		super();
		if (firstNames==null) {firstNames="";}
		if (familyNames==null) {familyNames="";}
		this.name = familyNames.trim()+" "+firstNames.trim();
		this.id = id;
		this.familyNames = familyNames;
		this.firstNames = firstNames;
		this.email = email;
	}
	
	/**
	 * @param id
	 * @param familyNames
	 */
	public PersonView(Long id, String familyNames) {
		super();
		this.id = id;
		this.familyNames = familyNames;
	}
	
	/**
	 * @param startDate
	 * @param otherNames
	 */
	public PersonView(Date startDate, String otherNames) {
		super();
		this.startDate = startDate;
		this.otherNames = otherNames;
	}
	
	/**
	 * @param startDate
	 * @param familyNames
	 */
	public PersonView(String firstNames, String familyNames, Date startDate) {
		super();
		if (firstNames==null) {firstNames="";}
		if (familyNames==null) {familyNames="";}
		this.name = familyNames.trim()+" "+firstNames.trim();
		this.familyNames = familyNames;
		this.firstNames = firstNames;
		this.startDate = startDate;
		this.familyNames = familyNames;
	}
	
	public PersonView() {
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
	 * @return the familyNames
	 */
	public String getFamilyNames() {
		return familyNames;
	}

	/**
	 * @param familyNames the familyNames to set
	 */
	public void setFamilyNames(String familyNames) {
		this.familyNames = familyNames;
	}
	
	/**
	 * @return the firstNames
	 */
	public String getFirstNames() {
		return firstNames;
	}

	/**
	 * @param firstName the firstNames to set
	 */
	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}

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
	 * @return the otherNames
	 */
	public String getOtherNames() {
		return otherNames;
	}

	/**
	 * @param otherNames the otherNames to set
	 */
	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}
	
	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param tel the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param tel the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * @return the orgname
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * @param tel the orgname to set
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
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
	 * @return the fieldOfInterest
	 */
	public String getFieldOfInterest() {
		return fieldOfInterest;
	}

	/**
	 * @param fieldOfInterest the fieldOfInterest to set
	 */
	public void setFieldOfInterest(String fieldOfInterest) {
		this.fieldOfInterest = fieldOfInterest;
	}
	
	

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
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

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonView [name=" + familyNames + ", id=" + id + ", email=" + email
				+ ", tel=" + tel  + ", orgname=" + orgname 
				+ ", country=" + country  +"]\n";
	}
	
}

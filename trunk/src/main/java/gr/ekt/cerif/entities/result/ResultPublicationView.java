package gr.ekt.cerif.entities.result;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnitResultPublicationView;
import gr.ekt.cerif.entities.link.person.PersonResultPublicationView;
import gr.ekt.cerif.entities.link.project.ProjectResultPublicationView;
import gr.ekt.cerif.entities.link.result.ResultPublicationMediumView;
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.semantics.ClassView;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ResultPublicationView {

	/**
	 * The id.
	 */
	private Long id;
	
	/**
	 * The title.
	 */
	private String title;
	
	/**
	 * The description.
	 */
	private String description;
	
	/**
	 * The keywords.
	 */
	private String keywords;
	
	/**
	 * The className.
	 */
	private String className;
	
	/**
	 * The medium.
	 */
	private Medium medium;
	
	/**
	 * The mediumClass.
	 */
	private String mediumClass;

	/**
	 * The visible.
	 */
	private boolean visible;
	
	/**
	 * The published.
	 */
	private boolean published;
	
	/**
	 * The selfCreator.
	 */
	private boolean selfCreator;
	
	/**
	 * The creatorLdapId.
	 */
	private Long creatorLdapId;
	
	/**
	 * The url.
	 */
	private String url;
	
	/**
	 * The dateOfIssue.
	 */
	private Date dateOfIssue;
	
	/**
	 * The organisationsMap.
	 */
	private Map<String,List<OrganisationUnitResultPublicationView>> organisationsMap;
	
	/**
	 * The personsMap.
	 */
	private Map<String,List<PersonResultPublicationView>> personsMap;
	
	/**
	 * The projects.
	 */
	private List<ProjectResultPublicationView> projects;
	
	/**
	 * The files.
	 */
	private List<ResultPublicationMediumView> files;
	
	/**
	 * The countries.
	 */
	private List<ClassView> countries;
	
		
	/**
	 * @param id
	 * @param title
	 * @param description
	 * @param keywords
	 * @param className
	 * @param url
	 * @param dateOfIssue
	 */
	public ResultPublicationView(Long id, String title, String description, String keywords,
			String className, String url, Date dateOfIssue) {

		this.id=id;
		this.title=title;
		this.description=description;
		this.keywords=keywords;
		this.className=className;
		this.url=url;
		this.dateOfIssue=dateOfIssue;
	}
	
	/**
	 * @param id
	 * @param title
	 * @param keywords
	 * @param dateOfIssue
	 */
	public ResultPublicationView(Long id, String title, String keywords, Date dateOfIssue) {

		this.id=id;
		this.title=title;
		this.keywords=keywords;
		this.dateOfIssue=dateOfIssue;
	}
	
	/**
	 * @param id
	 * @param title
	 * @param dateOfIssue
	 */
	public ResultPublicationView(Long id, String title, Date dateOfIssue) {

		this.id=id;
		this.title=title;
		this.dateOfIssue=dateOfIssue;
	}
	
	/**
	 * @param id
	 * @param title
	 * @param keywords
	 * @param dateOfIssue
	 * @param creatorLdapId
	 */
	public ResultPublicationView(Long id, String title, String keywords, Date dateOfIssue, Long creatorLdapId) {

		this.id=id;
		this.title=title;
		this.keywords=keywords;
		this.dateOfIssue=dateOfIssue;
		this.creatorLdapId = creatorLdapId;
	}
	
	/**
	 * @param id
	 * @param creatorLdapId
	 */
	public ResultPublicationView(Long id, Long creatorLdapId) {

		this.id=id;
		this.creatorLdapId = creatorLdapId;
	}
	
	/**
	 * @param id
	 * @param title
	 * @param keywords
	 */
	public ResultPublicationView(Long id, String title, String keywords) {

		this.id=id;
		this.title=title;
		this.keywords=keywords;
	}
	
	/**
	 * @param id
	 * @param title
	 * @param keywords
	 * @param medium
	 */
	public ResultPublicationView(Long id, String title, String keywords, Medium medium) {

		this.id=id;
		this.title=title;
		this.keywords=keywords;
		this.medium = medium;
	}
	
	
	
	/**
	 * @param id
	 * @param title
	 * @param medium
	 */
	public ResultPublicationView(String title, Long id, Medium medium) {
		this.id = id;
		this.title = title;
		this.medium = medium;		
	}
	
	/**
	 * @param id
	 * @param title
	 * @param medium
	 * @param className
	 */
	public ResultPublicationView(String title, Long id, Medium medium, String className) {
		this.id = id;
		this.title = title;
		this.medium = medium;
		this.className = className;
	}
	
	/**
	 * @param id
	 * @param medium
	 */
	public ResultPublicationView(Long id, Medium medium, String mediumClass) {
		this.id = id;
		this.medium = medium;	
		this.mediumClass = mediumClass;
	}
	
	/**
	 * @param className
	 * @param id
	 * @param title
	 */
	public ResultPublicationView(String className, Long id, String title) {
		this.className = className;
		this.id = id;
		this.title = title;			
	}
	
	/**
	 * @param id
	 * @param title
	 */
	public ResultPublicationView(String title, Long id) {
		this.id = id;
		this.title = title;
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
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
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
	 * @return the mediumClass
	 */
	public String getMediumClass() {
		return mediumClass;
	}

	/**
	 * @param mediumClass the mediumClass to set
	 */
	public void setMediumClass(String mediumClass) {
		this.mediumClass = mediumClass;
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
	 * @return the visible
	 */
	public boolean getVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	
	
	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	
	public boolean isSelfCreator() {
		return selfCreator;
	}

	public void setSelfCreator(boolean selfCreator) {
		this.selfCreator = selfCreator;
	}

	
	public Long getCreatorLdapId() {
		return creatorLdapId;
	}

	public void setCreatorLdapId(Long creatorLdapId) {
		this.creatorLdapId = creatorLdapId;
	}

	/**
	 * @return the dateOfIssue
	 */
	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	/**
	 * @param url the dateOfIssue to set
	 */
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	
	/**
	 * @return the organisationsMap
	 */
	public Map<String,List<OrganisationUnitResultPublicationView>> getOrganisationsMap() {
		return organisationsMap;
	}

	/**
	 * @param organisationsMap the organisationsMap to set
	 */
	public void setOrganisationsMap(Map<String,List<OrganisationUnitResultPublicationView>> organisationsMap) {
		this.organisationsMap = organisationsMap;
	}

	/**
	 * @return the personsMap
	 */
	public Map<String,List<PersonResultPublicationView>> getPersonsMap() {
		return personsMap;
	}

	/**
	 * @param personsMap the personsMap to set
	 */
	public void setPersonsMap(Map<String,List<PersonResultPublicationView>> personsMap) {
		this.personsMap = personsMap;
	}
	
	/**
	 * @return the projects
	 */
	public List<ProjectResultPublicationView> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(List<ProjectResultPublicationView> projects) {
		this.projects = projects;
	}

	/**
	 * @return the files
	 */
	public List<ResultPublicationMediumView> getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(List<ResultPublicationMediumView> files) {
		this.files = files;
	}
	
	/**
	 * @return the countries
	 */
	public List<ClassView> getCountries() {
		return countries;
	}

	/**
	 * @param countries the countries to set
	 */
	public void setCountries(List<ClassView> countries) {
		this.countries = countries;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String filename="null";
		if (medium!=null) {
			filename=medium.getUri();
		}
		
		return "ResultPublicationView [id=" + id + ", "+"title="+title+", "+
				"descr="+description+", "+"keywords="+keywords+", "+"class="+className+
				", "+"file="+filename+", "+"url="+url+
				", "+"dateOfIssue="+dateOfIssue+ "]";

	}
	
	
	
}

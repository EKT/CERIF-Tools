package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.result.ResultPublicationView;

import java.util.Date;
import java.util.List;
import java.util.Map;


public class EventView {
	
	/**
	 * The id.
	 */
	private Long id;
	
	/**
	 * The name.
	 */
	private String name;
	
	/**
	 * The start date.
	 */
	private Date startDate;
	
	/**
	 * The end date.
	 */
	private Date endDate;
	
	/**
	 * The type.
	 */
	private String type;
	
	/**
	 * The city.
	 */
	private String city;
	
	/**
	 * The organizer.
	 */
	private String organizer;
	
	/**
	 * The URL.
	 */
	private String URL;
	
	/**
	 * The project.
	 */
	private String project;
	
	/**
	 * The country.
	 */
	private String country;
	
	/**
	 * The feeOrFree.
	 */
	private String feeOrFree;
	
	/**
	 * The files.
	 */
	private Map<String,List<ResultPublicationView>> files;
	

	/**
	 * @param id
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @param type
	 * @param city
	 * @param country
	 * @param organizer
	 * @param URL
	 * @param project
	 */
	public EventView(Long id, String name, Date startDate, Date endDate, String type, 
			String city, String country, String organizer, String URL, String project) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.city = city;
		this.country = country;
		this.organizer = organizer;
		this.URL = URL;
		this.project = project;
	}
	
	/**
	 * @param id
	 * @param name
	 */
	public EventView(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Default
	 */
	public EventView() {
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @return the organizer
	 */
	public String getOrganizer() {
		return organizer;
	}

	/**
	 * @param organizer the organizer to set
	 */
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	
	/**
	 * @return the URL
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * @param URL the URL to set
	 */
	public void setURL(String URL) {
		this.URL = URL;
	}
	
	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(String project) {
		this.project = project;
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
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	 * @return the feeOrFree
	 */
	public String getFeeOrFree() {
		return feeOrFree;
	}

	/**
	 * @param feeOrFree the feeOrFree to set
	 */
	public void setFeeOrFree(String feeOrFree) {
		this.feeOrFree = feeOrFree;
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
		return "EventView [id="+id+", name=" + name + ", startDate="+startDate+", endDate="+endDate+", country=" + country+
				", type=" + type+", city=" + city+", organizer=" + organizer+", project=" + project+", feeOrFree=" + feeOrFree+
				", url=" + URL+"]"+"\n";
	}

	
}

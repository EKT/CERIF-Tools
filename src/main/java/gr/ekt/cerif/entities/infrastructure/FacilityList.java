package gr.ekt.cerif.entities.infrastructure;

/**
 * 
 * @author
 */
public class FacilityList {
	
	/**
	 * The acronym.
	 */
	private String acronym;
	
	/**
	 * The name.
	 */
	private String name;
	
	/**
	 * The uri.
	 */
	private String uri;
	
	/**
	 * The id.
	 */
	private Long id;
	
	/**
	 * The funding.
	 */
	private String funding;
	
	/**
	 * The focusArea.
	 */
	private String focusArea;
	
	/**
	 * The origin.
	 */
	private String origin;

	/**
	 * @param acronym
	 * @param id
	 * @param funding
	 * @param focusArea
	 * @param origin
	 */
	public FacilityList(String acronym, String name, Long id, String funding,
			String focusArea, String origin) {
		super();
		this.acronym = acronym;
		this.name = name;
		this.id = id;
		this.funding = funding;
		this.focusArea = focusArea;
		this.origin = origin;
	}
	
	public FacilityList(String acronym, Long id, String focusArea, String origin) {
		super();
		this.acronym = acronym;
		this.id = id;
		this.focusArea = focusArea;
		this.origin = origin;
	}
	
	/*public FacilityList(String acronym, String uri, String focusArea, String origin) {
		super();
		this.acronym = acronym;
		this.uri = uri;
		this.focusArea = focusArea;
		this.origin = origin;
	}*/

	/**
	 * Returns the acronym.
	 * @return the acronym.
	 */
	public String getAcronym() {
		return acronym;
	}

	/**
	 * Sets the acronym.
	 * @param acronym the acronym.
	 */
	public void setAcronym(String acronym) {
		this.acronym = acronym;
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
	 * Returns the funding.
	 * @return the funding.
	 */
	public String getFunding() {
		return funding;
	}

	/**
	 * Sets the funding.
	 * @param funding the funding.
	 */
	public void setFunding(String funding) {
		this.funding = funding;
	}


	/**
	 * @return the focusArea
	 */
	public String getFocusArea() {
		return focusArea;
	}

	/**
	 * @param focusArea the focusArea to set
	 */
	public void setFocusArea(String focusArea) {
		this.focusArea = focusArea;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FacilityList [acronym=" + acronym + ", id=" + id + ", funding="
				+ funding + ", focusArea=" + focusArea + ", origin=" + origin
				+ "]";
	}

	
	
}

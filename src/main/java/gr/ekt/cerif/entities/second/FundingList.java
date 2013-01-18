package gr.ekt.cerif.entities.second;

public class FundingList {
	
	/**
	 * The name.
	 */
	private String name;
	
	/**
	 * The id.
	 */
	private Long id;
	
	/**
	 * @param name
	 * @param id
	 */
	public FundingList(Long id, String name) {
		super();
		this.name = name;
		this.id = id;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FundingList [name=" + name + ", id=" + id +"]";
	}


}

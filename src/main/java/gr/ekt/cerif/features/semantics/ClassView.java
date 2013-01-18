package gr.ekt.cerif.features.semantics;

public class ClassView {
	
	/**
	 * The id.
	 */
	private Long id;
	
	/**
	 * The term.
	 */
	private String term;
	
	public ClassView() {
		super();
	}
	
	public ClassView(String term) {
		super();
		this.term = term;
	}

	public ClassView(String term, Long id) {
		super();
		this.term = term;
		this.id = id;
	}

	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * @param term the term to set
	 */
	public void setTerm(String term) {
		this.term = term;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassView [term=" + term + ", id="+id+ "]";
	}
	
	

}

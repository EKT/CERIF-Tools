package gr.ekt.exampleapp.transferobjects;

public class ClassView {

	private String term;

	/**
	 * @param term
	 */
	public ClassView(String term) {
		super();
		this.term = term;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassView [term=" + term + "]";
	}
	
	
}

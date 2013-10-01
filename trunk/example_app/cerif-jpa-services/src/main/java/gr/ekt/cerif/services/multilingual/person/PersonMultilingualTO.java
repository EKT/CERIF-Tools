package gr.ekt.cerif.services.multilingual.person;

import gr.ekt.cerif.features.multilingual.PersonKeyword;
import gr.ekt.cerif.features.multilingual.PersonResearchInterest;

import java.util.List;

public class PersonMultilingualTO {

	/**
	 * The person unique identifier.
	 */
	private Long id;
	
	/**
	 * The person research interests.
	 */
	private List<PersonResearchInterest> personResearchInterests;
	
	/**
	 * The person keywords.
	 */
	private List<PersonKeyword> personKeywords;

	/**
	 * @param id
	 * @param personResearchInterests
	 * @param personKeywords
	 */
	public PersonMultilingualTO(Long id,
			List<PersonResearchInterest> personResearchInterests,
			List<PersonKeyword> personKeywords) {
		super();
		this.id = id;
		this.personResearchInterests = personResearchInterests;
		this.personKeywords = personKeywords;
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
	 * @return the personResearchInterests
	 */
	public List<PersonResearchInterest> getPersonResearchInterests() {
		return personResearchInterests;
	}

	/**
	 * @param personResearchInterests the personResearchInterests to set
	 */
	public void setPersonResearchInterests(
			List<PersonResearchInterest> personResearchInterests) {
		this.personResearchInterests = personResearchInterests;
	}

	/**
	 * @return the personKeywords
	 */
	public List<PersonKeyword> getPersonKeywords() {
		return personKeywords;
	}

	/**
	 * @param personKeywords the personKeywords to set
	 */
	public void setPersonKeywords(List<PersonKeyword> personKeywords) {
		this.personKeywords = personKeywords;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonMultilingualTO [id=" + id + ", personResearchInterests="
				+ personResearchInterests + ", personKeywords="
				+ personKeywords + "]";
	}
	
	

}

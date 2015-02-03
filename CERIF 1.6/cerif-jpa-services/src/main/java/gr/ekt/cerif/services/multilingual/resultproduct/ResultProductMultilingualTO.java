package gr.ekt.cerif.services.multilingual.resultproduct;

import gr.ekt.cerif.features.multilingual.ResultProductDescription;
import gr.ekt.cerif.features.multilingual.ResultProductKeyword;
import gr.ekt.cerif.features.multilingual.ResultProductName;

import java.util.List;

public class ResultProductMultilingualTO {

	/**
	 * The product unique identifier.
	 */
	private Long id;

	/**
	 * The result product descriptions.
	 */
	private List<ResultProductDescription> resultProductDescriptions;
	
	/**
	 * The result product names.
	 */
	private List<ResultProductName> resultProductNames;
	
	/**
	 * The result product keywords.
	 */
	private List<ResultProductKeyword> resultProductKeywords;
	
	/**
	 * The result product resultProductVersionInfos.
	 */
	private List<ResultProductKeyword> resultProductVersionInfos;

	/**
	 * @param id
	 * @param resultProductDescriptions
	 * @param resultProductNames
	 * @param resultProductKeywords
	 * @param resultProductVersionInfos
	 */
	public ResultProductMultilingualTO(Long id,
			List<ResultProductDescription> resultProductDescriptions,
			List<ResultProductName> resultProductNames,
			List<ResultProductKeyword> resultProductKeywords,
			List<ResultProductKeyword> resultProductVersionInfos) {
		super();
		this.id = id;
		this.resultProductDescriptions = resultProductDescriptions;
		this.resultProductNames = resultProductNames;
		this.resultProductKeywords = resultProductKeywords;
		this.resultProductVersionInfos = resultProductVersionInfos;
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
	 * @return the resultProductDescriptions
	 */
	public List<ResultProductDescription> getResultProductDescriptions() {
		return resultProductDescriptions;
	}

	/**
	 * @param resultProductDescriptions the resultProductDescriptions to set
	 */
	public void setResultProductDescriptions(
			List<ResultProductDescription> resultProductDescriptions) {
		this.resultProductDescriptions = resultProductDescriptions;
	}

	/**
	 * @return the resultProductNames
	 */
	public List<ResultProductName> getResultProductNames() {
		return resultProductNames;
	}

	/**
	 * @param resultProductNames the resultProductNames to set
	 */
	public void setResultProductNames(List<ResultProductName> resultProductNames) {
		this.resultProductNames = resultProductNames;
	}

	/**
	 * @return the resultProductKeywords
	 */
	public List<ResultProductKeyword> getResultProductKeywords() {
		return resultProductKeywords;
	}

	/**
	 * @param resultProductKeywords the resultProductKeywords to set
	 */
	public void setResultProductKeywords(
			List<ResultProductKeyword> resultProductKeywords) {
		this.resultProductKeywords = resultProductKeywords;
	}

	/**
	 * @return the resultProductVersionInfos
	 */
	public List<ResultProductKeyword> getResultProductVersionInfos() {
		return resultProductVersionInfos;
	}

	/**
	 * @param resultProductVersionInfos the resultProductVersionInfos to set
	 */
	public void setResultProductVersionInfos(
			List<ResultProductKeyword> resultProductVersionInfos) {
		this.resultProductVersionInfos = resultProductVersionInfos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResultProductMultilingualTO [id=" + id
				+ ", resultProductDescriptions=" + resultProductDescriptions
				+ ", resultProductNames=" + resultProductNames
				+ ", resultProductKeywords=" + resultProductKeywords
				+ ", resultProductVersionInfos=" + resultProductVersionInfos
				+ "]";
	}
	
	

}

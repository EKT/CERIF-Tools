package gr.ekt.cerif.services.multilingual.resultpatent;

import gr.ekt.cerif.features.multilingual.ResultPatentAbstract;
import gr.ekt.cerif.features.multilingual.ResultPatentKeyword;
import gr.ekt.cerif.features.multilingual.ResultPatentTitle;

import java.util.List;


public class ResultPatentMultilingualTO {

	/**
	 * The patent unique identifier.
	 */
	private Long id;

	/**
	 * The result patent titles.
	 */
	private List<ResultPatentTitle> resultPatentTitles;
	
	/**
	 * The result patent abstracts.
	 */
	private List<ResultPatentAbstract> resultPatentAbstracts;
	
	/**
	 * The result patent keywords.
	 */
	private List<ResultPatentKeyword> resultPatentKeywords;
	
	/**
	 * The result patent resultPatentVersionInfos.
	 */
	private List<ResultPatentKeyword> resultPatentVersionInfos;

	/**
	 * @param id
	 * @param resultPatentTitles
	 * @param resultPatentAbstracts
	 * @param resultPatentKeywords
	 * @param resultPatentVersionInfos
	 */
	public ResultPatentMultilingualTO(Long id,
			List<ResultPatentTitle> resultPatentTitles,
			List<ResultPatentAbstract> resultPatentAbstracts,
			List<ResultPatentKeyword> resultPatentKeywords,
			List<ResultPatentKeyword> resultPatentVersionInfos) {
		super();
		this.id = id;
		this.resultPatentTitles = resultPatentTitles;
		this.resultPatentAbstracts = resultPatentAbstracts;
		this.resultPatentKeywords = resultPatentKeywords;
		this.resultPatentVersionInfos = resultPatentVersionInfos;
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
	 * @return the resultPatentTitles
	 */
	public List<ResultPatentTitle> getResultPatentTitles() {
		return resultPatentTitles;
	}

	/**
	 * @param resultPatentTitles the resultPatentTitles to set
	 */
	public void setResultPatentTitles(List<ResultPatentTitle> resultPatentTitles) {
		this.resultPatentTitles = resultPatentTitles;
	}

	/**
	 * @return the resultPatentAbstracts
	 */
	public List<ResultPatentAbstract> getResultPatentAbstracts() {
		return resultPatentAbstracts;
	}

	/**
	 * @param resultPatentAbstracts the resultPatentAbstracts to set
	 */
	public void setResultPatentAbstracts(
			List<ResultPatentAbstract> resultPatentAbstracts) {
		this.resultPatentAbstracts = resultPatentAbstracts;
	}

	/**
	 * @return the resultPatentKeywords
	 */
	public List<ResultPatentKeyword> getResultPatentKeywords() {
		return resultPatentKeywords;
	}

	/**
	 * @param resultPatentKeywords the resultPatentKeywords to set
	 */
	public void setResultPatentKeywords(
			List<ResultPatentKeyword> resultPatentKeywords) {
		this.resultPatentKeywords = resultPatentKeywords;
	}

	/**
	 * @return the resultPatentVersionInfos
	 */
	public List<ResultPatentKeyword> getResultPatentVersionInfos() {
		return resultPatentVersionInfos;
	}

	/**
	 * @param resultPatentVersionInfos the resultPatentVersionInfos to set
	 */
	public void setResultPatentVersionInfos(
			List<ResultPatentKeyword> resultPatentVersionInfos) {
		this.resultPatentVersionInfos = resultPatentVersionInfos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResultPatentMultilingualTO [id=" + id + ", resultPatentTitles="
				+ resultPatentTitles + ", resultPatentAbstracts="
				+ resultPatentAbstracts + ", resultPatentKeywords="
				+ resultPatentKeywords + ", resultPatentVersionInfos="
				+ resultPatentVersionInfos + "]";
	}

	
}

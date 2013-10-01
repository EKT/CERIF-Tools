package gr.ekt.cerif.services.multilingual.resultpublication;

import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;
import gr.ekt.cerif.features.multilingual.ResultPublicationBibliographicNote;
import gr.ekt.cerif.features.multilingual.ResultPublicationKeyword;
import gr.ekt.cerif.features.multilingual.ResultPublicationNameAbbreviation;
import gr.ekt.cerif.features.multilingual.ResultPublicationSubtitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationVersionInfo;

import java.util.List;

public class ResultPublicationMultilingualTO {

	/**
	 * The publication unique identifier.
	 */
	private Long id;
	
	/**
	 * The publication Titles.
	 */
	private List<ResultPublicationTitle> resultPublicationTitles;
	
	/**
	 * The publication Subtitles.
	 */
	private List<ResultPublicationSubtitle> resultPublicationSubtitles;
	
	/**
	 * The publication resultPublicationAbstracts.
	 */
	private List<ResultPublicationAbstract> resultPublicationAbstracts;
	
	/**
	 * The publication resultPublicationKeywords.
	 */
	private List<ResultPublicationKeyword> resultPublicationKeywords;
	
	/**
	 * The publication resultPublicationBibliographicNotes.
	 */
	private List<ResultPublicationBibliographicNote> resultPublicationBibliographicNotes;
	
	/**
	 * The publication resultPublicationNameAbbreviations.
	 */
	private List<ResultPublicationNameAbbreviation> resultPublicationNameAbbreviations;
	
	/**
	 * The publication resultPublicationVersionInfos.
	 */
	private List<ResultPublicationVersionInfo> resultPublicationVersionInfos;

	/**
	 * @param id
	 * @param resultPublicationTitles
	 * @param resultPublicationSubtitles
	 * @param resultPublicationAbstracts
	 * @param resultPublicationKeywords
	 * @param resultPublicationBibliographicNotes
	 * @param resultPublicationNameAbbreviations
	 * @param resultPublicationVersionInfos
	 */
	public ResultPublicationMultilingualTO(
			Long id,
			List<ResultPublicationTitle> resultPublicationTitles,
			List<ResultPublicationSubtitle> resultPublicationSubtitles,
			List<ResultPublicationAbstract> resultPublicationAbstracts,
			List<ResultPublicationKeyword> resultPublicationKeywords,
			List<ResultPublicationBibliographicNote> resultPublicationBibliographicNotes,
			List<ResultPublicationNameAbbreviation> resultPublicationNameAbbreviations,
			List<ResultPublicationVersionInfo> resultPublicationVersionInfos) {
		super();
		this.id = id;
		this.resultPublicationTitles = resultPublicationTitles;
		this.resultPublicationSubtitles = resultPublicationSubtitles;
		this.resultPublicationAbstracts = resultPublicationAbstracts;
		this.resultPublicationKeywords = resultPublicationKeywords;
		this.resultPublicationBibliographicNotes = resultPublicationBibliographicNotes;
		this.resultPublicationNameAbbreviations = resultPublicationNameAbbreviations;
		this.resultPublicationVersionInfos = resultPublicationVersionInfos;
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
	 * @return the resultPublicationTitles
	 */
	public List<ResultPublicationTitle> getResultPublicationTitles() {
		return resultPublicationTitles;
	}

	/**
	 * @param resultPublicationTitles the resultPublicationTitles to set
	 */
	public void setResultPublicationTitles(
			List<ResultPublicationTitle> resultPublicationTitles) {
		this.resultPublicationTitles = resultPublicationTitles;
	}

	/**
	 * @return the resultPublicationSubtitles
	 */
	public List<ResultPublicationSubtitle> getResultPublicationSubtitles() {
		return resultPublicationSubtitles;
	}

	/**
	 * @param resultPublicationSubtitles the resultPublicationSubtitles to set
	 */
	public void setResultPublicationSubtitles(
			List<ResultPublicationSubtitle> resultPublicationSubtitles) {
		this.resultPublicationSubtitles = resultPublicationSubtitles;
	}

	/**
	 * @return the resultPublicationAbstracts
	 */
	public List<ResultPublicationAbstract> getResultPublicationAbstracts() {
		return resultPublicationAbstracts;
	}

	/**
	 * @param resultPublicationAbstracts the resultPublicationAbstracts to set
	 */
	public void setResultPublicationAbstracts(
			List<ResultPublicationAbstract> resultPublicationAbstracts) {
		this.resultPublicationAbstracts = resultPublicationAbstracts;
	}

	/**
	 * @return the resultPublicationKeywords
	 */
	public List<ResultPublicationKeyword> getResultPublicationKeywords() {
		return resultPublicationKeywords;
	}

	/**
	 * @param resultPublicationKeywords the resultPublicationKeywords to set
	 */
	public void setResultPublicationKeywords(
			List<ResultPublicationKeyword> resultPublicationKeywords) {
		this.resultPublicationKeywords = resultPublicationKeywords;
	}

	/**
	 * @return the resultPublicationBibliographicNotes
	 */
	public List<ResultPublicationBibliographicNote> getResultPublicationBibliographicNotes() {
		return resultPublicationBibliographicNotes;
	}

	/**
	 * @param resultPublicationBibliographicNotes the resultPublicationBibliographicNotes to set
	 */
	public void setResultPublicationBibliographicNotes(
			List<ResultPublicationBibliographicNote> resultPublicationBibliographicNotes) {
		this.resultPublicationBibliographicNotes = resultPublicationBibliographicNotes;
	}

	/**
	 * @return the resultPublicationNameAbbreviations
	 */
	public List<ResultPublicationNameAbbreviation> getResultPublicationNameAbbreviations() {
		return resultPublicationNameAbbreviations;
	}

	/**
	 * @param resultPublicationNameAbbreviations the resultPublicationNameAbbreviations to set
	 */
	public void setResultPublicationNameAbbreviations(
			List<ResultPublicationNameAbbreviation> resultPublicationNameAbbreviations) {
		this.resultPublicationNameAbbreviations = resultPublicationNameAbbreviations;
	}

	/**
	 * @return the resultPublicationVersionInfos
	 */
	public List<ResultPublicationVersionInfo> getResultPublicationVersionInfos() {
		return resultPublicationVersionInfos;
	}

	/**
	 * @param resultPublicationVersionInfos the resultPublicationVersionInfos to set
	 */
	public void setResultPublicationVersionInfos(
			List<ResultPublicationVersionInfo> resultPublicationVersionInfos) {
		this.resultPublicationVersionInfos = resultPublicationVersionInfos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResultPublicationMultilingualTO [id=" + id
				+ ", resultPublicationTitles=" + resultPublicationTitles
				+ ", resultPublicationSubtitles=" + resultPublicationSubtitles
				+ ", resultPublicationAbstracts=" + resultPublicationAbstracts
				+ ", resultPublicationKeywords=" + resultPublicationKeywords
				+ ", resultPublicationBibliographicNotes="
				+ resultPublicationBibliographicNotes
				+ ", resultPublicationNameAbbreviations="
				+ resultPublicationNameAbbreviations
				+ ", resultPublicationVersionInfos="
				+ resultPublicationVersionInfos + "]";
	}

	
}

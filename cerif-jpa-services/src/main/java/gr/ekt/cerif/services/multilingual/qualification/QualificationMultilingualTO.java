package gr.ekt.cerif.services.multilingual.qualification;

import gr.ekt.cerif.features.multilingual.QualificationDescription;
import gr.ekt.cerif.features.multilingual.QualificationKeyword;
import gr.ekt.cerif.features.multilingual.QualificationTitle;

import java.util.List;


public class QualificationMultilingualTO {

	/**
	 * The citation id.
	 */
	private Long id;

	/**
	 * The citation titles.
	 */
	private List<QualificationTitle> titles;
	
	/**
	 * The citation keywords.
	 */
	private List<QualificationKeyword> keywords;
	
	/**
	 * The citation descriptions.
	 */
	private List<QualificationDescription> descriptions;

	/**
	 * @param id
	 * @param titles
	 * @param keywords
	 * @param descriptions
	 */
	public QualificationMultilingualTO(Long id,
			List<QualificationTitle> titles,
			List<QualificationKeyword> keywords,
			List<QualificationDescription> descriptions) {
		super();
		this.id = id;
		this.titles = titles;
		this.keywords = keywords;
		this.descriptions = descriptions;
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
	 * @return the titles
	 */
	public List<QualificationTitle> getTitles() {
		return titles;
	}

	/**
	 * @param titles the titles to set
	 */
	public void setTitles(List<QualificationTitle> titles) {
		this.titles = titles;
	}

	/**
	 * @return the keywords
	 */
	public List<QualificationKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<QualificationKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public List<QualificationDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(List<QualificationDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QualificationMultilingualTO [id=" + id + ", titles=" + titles
				+ ", keywords=" + keywords + ", descriptions=" + descriptions
				+ "]";
	}
	
	

}

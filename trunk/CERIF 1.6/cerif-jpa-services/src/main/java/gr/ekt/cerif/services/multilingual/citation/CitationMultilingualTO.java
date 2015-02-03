package gr.ekt.cerif.services.multilingual.citation;

import gr.ekt.cerif.features.multilingual.CitationDescription;
import gr.ekt.cerif.features.multilingual.CitationTitle;

import java.util.List;

public class CitationMultilingualTO {

	/**
	 * The citation id.
	 */
	private Long id;
	
	/**
	 * The citation descriptions.
	 */
	private List<CitationDescription> descriptions;
	
	/**
	 * The citation titles.
	 */
	private List<CitationTitle> titles;

	
		
	public CitationMultilingualTO(Long id,
			List<CitationDescription> descriptions, List<CitationTitle> titles) {
		super();
		this.id = id;
		this.descriptions = descriptions;
		this.titles = titles;
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
	 * @return the descriptions
	 */
	public List<CitationDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(List<CitationDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/**
	 * @return the titles
	 */
	public List<CitationTitle> getTitles() {
		return titles;
	}

	/**
	 * @param titles the titles to set
	 */
	public void setTitles(List<CitationTitle> titles) {
		this.titles = titles;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CitationMultilingualTO [id=" + id + ", descriptions="
				+ descriptions + ", titles=" + titles + "]";
	}
	
	
	
}

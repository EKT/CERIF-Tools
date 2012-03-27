/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.CitationTranslationId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Holds the multi-lingual title of a citation entity.
 * 
 */
@Entity
@Table(name="cfCiteTitle")
@IdClass(CitationTranslationId.class)
public class CitationTitle implements CitationTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -1775379743833271978L;

	/**
	 * The citation.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfCiteId")
	private Citation citation;
	
	/**
	 * The language.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfLangCode")
	private Language language;
	
	/**
	 * The translation.
	 */
	@Id
	@Column(name="cfTrans")
	@Enumerated(EnumType.STRING)
	private Translation translation;
	
	/**
	 * The citation title.
	 */
	@Column(name="cfTitle")
	private String title;
	
	/**
	 * @return the citation
	 */
	public Citation getCitation() {
		return citation;
	}
	
	/**
	 * @param citation the citation to set
	 */
	public void setCitation(Citation citation) {
		this.citation = citation;
	}
	
	/**
	 * @return the language
	 */
	public Language getLanguage() {
		return language;
	}


	/**
	 * @param language the language to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}


	/**
	 * @return the translation
	 */
	public Translation getTranslation() {
		return translation;
	}


	/**
	 * @param translation the translation to set
	 */
	public void setTranslation(Translation translation) {
		this.translation = translation;
	}	

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}

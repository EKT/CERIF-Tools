/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.result.ResultPublicationTranslationId;

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
 * Holds the multi-lingual fields of a publication result entity.
 * 
 */
@Entity
@Table(name="cfResPublBiblNote")
@IdClass(ResultPublicationTranslationId.class)
public class ResultPublicationBibliographicNote implements ResultPublicationTranslation {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -8204123285067903117L;

	/**
	 * The translation.
	 */
	@Id
	@Column(name="cfTrans")
	@Enumerated(EnumType.STRING)
	private Translation translation = Translation.MACHINE;
	
	/**
	 * The publication.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfResPublId")
	private ResultPublication resultPublication;
	
	/**
	 * The language.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfLangCode")
	private Language language;
	
	/**
	 * The bibliographicNote.
	 */
	@Column(name="cfBiblNote")
	private String bibliographicNote;
	
	/**
	 * Returns the translation.
	 * @return the translation
	 */
	public Translation getTranslation() {
		return translation;
	}

	/**
	 * Sets the translation.
	 * @param translation the translation
	 */
	public void setTranslation(Translation translation) {
		this.translation = translation;
	}

	/**
	 * Returns the publication.
	 * @return the publication.
	 */
	public ResultPublication getResultPublication() {
		return resultPublication;
	}

	/**
	 * Sets the publication.
	 * @param resultPublication the publication.
	 */
	public void setResultPublication(ResultPublication resultPublication) {
		this.resultPublication = resultPublication;
	}

	/**
	 * Returns the language.
	 * @return the language.
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 * @param language the language.
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

	/**
	 * Returns the bibliographicNote.
	 * @return the bibliographicNote.
	 */
	public String getBibliographicNote() {
		return bibliographicNote;
	}

	/**
	 * Sets the bibliographicNote.
	 * @param bibliographicNote the bibliographicNote.
	 */
	public void setBibliographicNote(String bibliographicNote) {
		this.bibliographicNote = bibliographicNote;
	}
	
}

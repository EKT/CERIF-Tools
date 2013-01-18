/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Language;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Holds the multi-lingual fields of a publication result entity.
 * 
 */
@Entity
@Table(name="cfResPublBiblNote", uniqueConstraints=@UniqueConstraint(columnNames={"cfResPublId","cfLangCode","cfTrans"}))
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ResultPublicationBibliographicNote implements CerifMultipleLanguageFeature {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -8204123285067903117L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The translation.
	 */
	@NotNull
	@Column(name="cfTrans")
	@Enumerated(EnumType.STRING)
	private Translation translation = Translation.MACHINE;
	
	/**
	 * The publication.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfResPublId")
	private ResultPublication resultPublication;
	
	/**
	 * The language.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfLangCode")
	private Language language;
	
	/**
	 * The bibliographicNote.
	 */
	@Column(name="cfBiblNote")
	private String bibliographicNote;
	
	/**
	 * Default Constructor
	 */
	public ResultPublicationBibliographicNote() {
		
	}
	
	/**
	 * 
	 * @param translation
	 * @param resultPublication
	 * @param language
	 * @param bibliographicNote
	 */
	public ResultPublicationBibliographicNote(Translation translation,
			ResultPublication resultPublication, Language language,
			String bibliographicNote) {
		this.translation = translation;
		this.resultPublication = resultPublication;
		this.language = language;
		this.bibliographicNote = bibliographicNote;
	}

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
	
}

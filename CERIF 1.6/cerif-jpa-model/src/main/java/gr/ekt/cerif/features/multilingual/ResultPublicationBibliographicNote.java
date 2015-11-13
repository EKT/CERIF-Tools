/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Language;

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

/**
 * Holds the multi-lingual fields of a publication result entity.
 * 
 */
@Entity
@Table(name="cfResPublBiblNote", uniqueConstraints=@UniqueConstraint(columnNames={"cfResPublId","cfLangCode","cfTrans"}))
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
	private Translation translation;
	
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
	@NotNull
	@Column(name="cfBiblNote", length=20000)
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime
				* result
				+ ((resultPublication == null) ? 0 : resultPublication
						.hashCode());
		result = prime * result
				+ ((translation == null) ? 0 : translation.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultPublicationBibliographicNote other = (ResultPublicationBibliographicNote) obj;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (resultPublication == null) {
			if (other.resultPublication != null)
				return false;
		} else if (!resultPublication.equals(other.resultPublication))
			return false;
		if (translation != other.translation)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResultPublicationBibliographicNote [id=" + id
				+ ", resultPublication=" + resultPublication + ", language="
				+ language + ", bibliographicNote=" + bibliographicNote + "]";
	}
	
}

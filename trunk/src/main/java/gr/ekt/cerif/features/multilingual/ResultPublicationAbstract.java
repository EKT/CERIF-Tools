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
 * Holds the multi-lingual abstract of a publication result entity.
 * 
 */
@Entity
@Table(name="cfResPublAbstr")
@IdClass(ResultPublicationTranslationId.class)
public class ResultPublicationAbstract implements ResultPublicationTranslation {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 6871234809317027016L;	

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
	 * The abstract.
	 */
	@Column(name="cfAbstr")
	private String abstractText;
	
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
	 * Returns the abstract.
	 * @return the abstract.
	 */
	public String getAbstractText() {
		return abstractText;
	}

	/**
	 * Sets the abstract.
	 * @param abstractText the abstract.
	 */
	public void setAbstractText(String abstractText) {
		this.abstractText = abstractText;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
				.format("ResultPublicationAbstract [translation=%s, resultPublication=%s, language=%s, abstractText=%s]",
						translation, resultPublication, language, abstractText);
	}
	
}

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
 * Holds the multi-lingual subtitle of a publication result entity.
 * 
 */
@Entity
@Table(name="cfResPublSubtitle", uniqueConstraints=@UniqueConstraint(columnNames={"cfResPublId","cfLangCode","cfTrans"}))
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ResultPublicationSubtitle implements CerifMultipleLanguageFeature {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 1830637508197874842L;

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
	 * The subtitle.
	 */
	@Column(name="cfSubtitle")
	private String subtitle;

	/**
	 * Default Constructor
	 */
	public ResultPublicationSubtitle() { 
		
	}
	
	/**
	 * 
	 * @param translation
	 * @param resultPublication
	 * @param language
	 * @param subtitle
	 */
	public ResultPublicationSubtitle(Translation translation,
			ResultPublication resultPublication, Language language,
			String subtitle) {
		this.translation = translation;
		this.resultPublication = resultPublication;
		this.language = language;
		this.subtitle = subtitle;
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
	 * Returns the subtitle.
	 * @return the subtitle.
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * Sets the subtitle.
	 * @param subtitle the subtitle.
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
				.format("ResultPublicationSubtitle [translation=%s, resultPublication=%s, language=%s, subtitle=%s]",
						translation, resultPublication, language, subtitle);
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

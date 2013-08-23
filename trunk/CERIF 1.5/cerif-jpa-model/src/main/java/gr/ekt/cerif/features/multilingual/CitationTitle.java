/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Citation;
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
 * Holds the multi-lingual title of a citation entity.
 * 
 */
@Entity
@Table(name="cfCiteTitle", uniqueConstraints=@UniqueConstraint(columnNames={"cfCiteId","cfLangCode","cfTrans"}))
public class CitationTitle implements CerifMultipleLanguageFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -1775379743833271978L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The citation.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfCiteId")
	private Citation citation;
	
	/**
	 * The language.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfLangCode")
	private Language language;
	
	/**
	 * The translation.
	 */
	@NotNull
	@Column(name="cfTrans")
	@Enumerated(EnumType.STRING)
	private Translation translation;
	
	/**
	 * The citation title.
	 */
	@Column(name="cfTitle")
	private String title;
	
	/**
	 * Default Constructor
	 */
	public CitationTitle() {
		
	}
	
	/**
	 * 
	 * @param citation
	 * @param language
	 * @param translation
	 * @param title
	 */
	public CitationTitle(Citation citation, Language language,
			Translation translation, String title) {
		this.citation = citation;
		this.language = language;
		this.translation = translation;
		this.title = title;
	}

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

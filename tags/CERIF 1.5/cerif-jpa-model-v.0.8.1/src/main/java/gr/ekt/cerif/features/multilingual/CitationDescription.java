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
 * Holds the multi-lingual description of a citation entity.
 * 
 */
@Entity
@Table(name="cfCiteDescr", uniqueConstraints=@UniqueConstraint(columnNames={"cfCiteId","cfLangCode","cfTrans"}))
public class CitationDescription implements CerifMultipleLanguageFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 2610134703520942851L;

	
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
	@NotNull
	@Column(name="cfDescr", length=20000)
	private String description;
	
	/**
	 * Default Constructor
	 */
	public CitationDescription() {
		
	}
	
	/**
	 * 
	 * @param citation
	 * @param language
	 * @param translation
	 * @param description
	 */
	public CitationDescription(Citation citation, Language language,
			Translation translation, String description) {
		this.citation = citation;
		this.language = language;
		this.translation = translation;
		this.description = description;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
				+ ((citation == null) ? 0 : citation.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
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
		CitationDescription other = (CitationDescription) obj;
		if (citation == null) {
			if (other.citation != null)
				return false;
		} else if (!citation.equals(other.citation))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
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
		return "CitationDescription [id=" + id + ", language=" + language
				+ ", translation=" + translation + ", description="
				+ description + "]";
	}

	
}

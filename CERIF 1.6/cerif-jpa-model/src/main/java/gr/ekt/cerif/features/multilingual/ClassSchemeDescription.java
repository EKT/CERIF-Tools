/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.semantics.ClassScheme;

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
 * Holds the multi-lingual description of a class scheme entity.
 * 
 */
@Entity
@Table(name="cfClassSchemeDescr", uniqueConstraints=@UniqueConstraint(columnNames={"cfClassSchemeId", "cfLangCode", "cfTrans"}) )
public class ClassSchemeDescription implements CerifMultipleLanguageFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -2804499062529714599L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The class scheme.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassSchemeId")
	private ClassScheme scheme;
	
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
	 * The class scheme description.
	 */
	@NotNull
	@Column(name="cfDescr", length=10600)
	private String description;
	
	/**
	 * The class scheme description source.
	 */
	@Column(name="cfDescrSrc", length=10600)
	private String descriptionSrc;

	/**
	 * Default Constructor
	 */
	public ClassSchemeDescription() {
		
	}
	
	/**
	 * 
	 * @param scheme
	 * @param language
	 * @param translation
	 * @param description
	 * @param descriptionSrc
	 */
	public ClassSchemeDescription(ClassScheme scheme, Language language,
			Translation translation, String description, String descriptionSrc) {
		this.scheme = scheme;
		this.language = language;
		this.translation = translation;
		this.description = description;
		this.descriptionSrc = descriptionSrc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the classScheme
	 */
	public ClassScheme getClassScheme() {
		return scheme;
	}

	/**
	 * @param classScheme the classScheme to set
	 */
	public void setClassScheme(ClassScheme scheme) {
		this.scheme = scheme;
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

	public String getDescriptionSrc() {
		return descriptionSrc;
	}

	public void setDescriptionSrc(String descriptionSrc) {
		this.descriptionSrc = descriptionSrc;
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
		result = prime * result + ((scheme == null) ? 0 : scheme.hashCode());
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
		ClassSchemeDescription other = (ClassSchemeDescription) obj;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (scheme == null) {
			if (other.scheme != null)
				return false;
		} else if (!scheme.equals(other.scheme))
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
		return "ClassSchemeDescription [id=" + id + ", language=" + language
				+ ", translation=" + translation + ", description="
				+ description + ", descriptionSrc=" + descriptionSrc + "]";
	}
	
	
}

/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

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
 * Holds the multi-lingual name of a language entity.
 * 
 */
@Entity
@Table(name="cfLangName", uniqueConstraints=@UniqueConstraint(columnNames={"cfLangCodeOfLangName","cfLangCode","cfTrans"}))
public class LanguageName implements CerifMultipleLanguageFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -1631689381651151112L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The language.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfLangCodeOfLangName")
	private Language languageOfName;
	
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
	 * The language name.
	 */
	@NotNull
	@Column(name="cfName")
	private String name;
	
	/**
	 * Default Constructor
	 */
	public LanguageName() {
		
	}
	
	/**
	 * 
	 * @param languageOfName
	 * @param language
	 * @param translation
	 * @param name
	 */
	public LanguageName(Language languageOfName, Language language,
			Translation translation, String name) {
		this.languageOfName = languageOfName;
		this.language = language;
		this.translation = translation;
		this.name = name;
	}

	/**
	 * @return the language
	 */
	public Language getLanguageOfName() {
		return languageOfName;
	}
	
	/**
	 * @param language the language to set
	 */
	public void setLanguageOfName(Language languageOfName) {
		this.languageOfName = languageOfName;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
		result = prime * result
				+ ((languageOfName == null) ? 0 : languageOfName.hashCode());
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
		LanguageName other = (LanguageName) obj;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (languageOfName == null) {
			if (other.languageOfName != null)
				return false;
		} else if (!languageOfName.equals(other.languageOfName))
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
		return "LanguageName [id=" + id + ", language=" + language
				+ ", translation=" + translation + ", name=" + name + "]";
	}

}

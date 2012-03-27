/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.LanguageTranslationId;

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
 * Holds the multi-lingual name of a language entity.
 * 
 */
@Entity
@Table(name="cfLangName")
@IdClass(LanguageTranslationId.class)
public class LanguageName implements LanguageTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -1631689381651151112L;

	/**
	 * The language.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfLangCodeOfLangName")
	private Language languageOfName;
	
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
	 * The language name.
	 */
	@Column(name="cfName")
	private String name;
	
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

}

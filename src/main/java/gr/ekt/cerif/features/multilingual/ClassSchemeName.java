/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.pk.ClassSchemeTranslationId;

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
 * Holds the multi-lingual name of a class scheme entity.
 * 
 */
@Entity
@Table(name="cfClassSchemeName")
@IdClass(ClassSchemeTranslationId.class)
public class ClassSchemeName implements ClassSchemeTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -1934084923799686231L;

	/**
	 * The class scheme.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassSchemeId")
	private ClassScheme scheme;
	
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
	 * The class scheme name.
	 */
	@Column(name="cfName")
	private String name;
	
	/**
	 * The class scheme name source.
	 */
	@Column(name="cfNameSrc")
	private String nameSrc;

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
	 * @return the name source
	 */
	public String getNameSrc() {
		return nameSrc;
	}

	/**
	 * @param nameSrc the nameSrc to set
	 */
	public void setNameSrc(String nameSrc) {
		this.nameSrc = nameSrc;
	}
}

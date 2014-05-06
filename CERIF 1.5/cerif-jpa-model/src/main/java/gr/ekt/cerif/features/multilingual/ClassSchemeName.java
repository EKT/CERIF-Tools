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
 * Holds the multi-lingual name of a class scheme entity.
 * 
 */
@Entity
@Table(name="cfClassSchemeName", uniqueConstraints=@UniqueConstraint(columnNames={"cfClassSchemeId", "cfLangCode", "cfTrans"}) )
public class ClassSchemeName implements CerifMultipleLanguageFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -1934084923799686231L;

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
	 * The class scheme name.
	 */
	@NotNull
	@Column(name="cfName", length=10600)
	private String name;
	
	/**
	 * The class scheme name source.
	 */
	@Column(name="cfNameSrc", length=10600)
	private String nameSrc;

	/**
	 * Default Constructor
	 */
	public ClassSchemeName() {
		
	}
	
	/**
	 * 
	 * @param scheme
	 * @param language
	 * @param translation
	 * @param name
	 */
	public ClassSchemeName(ClassScheme scheme, Language language,
			Translation translation, String name) {
		this.scheme = scheme;
		this.language = language;
		this.translation = translation;
		this.name = name;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassSchemeName [id=" + id + ", language=" + language
				+ ", translation=" + translation + ", name=" + name
				+ ", nameSrc=" + nameSrc + "]";
	}
	
	
}

/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.semantics.Class;
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
 * Holds the multi-lingual description of a class entity.
 * 
 */
@Entity
@Table(name="cfClassDescr", uniqueConstraints=@UniqueConstraint(columnNames={"cfClassId","cfClassSchemeId","cfLangCode","cfTrans"}))
public class ClassDescription implements ClassTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -2252035706673338532L;	
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The class.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassId")
	private Class theClass;
	
	/**
	 * The class scheme.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassSchemeId")
	private ClassScheme classScheme;
	
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
	 * The class description.
	 */
	@Column(name="cfDescr")
	private String description;
	
	/**
	 * The class description source.
	 */
	@Column(name="cfDescrSrc")
	private String descriptionSrc;

	/**
	 * Default Constructor
	 */
	public ClassDescription() {
	
	}
	
	/**
	 * 
	 * @param theClass
	 * @param classScheme
	 * @param language
	 * @param translation
	 * @param description
	 * @param descriptionSrc
	 */
	public ClassDescription(Class theClass, ClassScheme classScheme,
			Language language, Translation translation, String description,
			String descriptionSrc) {
		this.theClass = theClass;
		this.classScheme = classScheme;
		this.language = language;
		this.translation = translation;
		this.description = description;
		this.descriptionSrc = descriptionSrc;
	}


	/**
	 * @return the theClass
	 */
	public Class getTheClass() {
		return theClass;
	}


	/**
	 * @param theClass the theClass to set
	 */
	public void setTheClass(Class theClass) {
		this.theClass = theClass;
	}


	/**
	 * @return the classScheme
	 */
	public ClassScheme getClassScheme() {
		return classScheme;
	}


	/**
	 * @param classScheme the classScheme to set
	 */
	public void setClassScheme(ClassScheme classScheme) {
		this.classScheme = classScheme;
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

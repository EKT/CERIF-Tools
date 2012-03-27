/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.pk.ClassTranslationId;

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
 * Holds the multi-lingual definition of a class entity.
 * 
 */
@Entity
@Table(name="cfClassDef")
@IdClass(ClassTranslationId.class)
public class ClassDefinition implements ClassTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 6244094329769588315L;
	
	/**
	 * The class.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassId")
	private Class theClass;
	
	/**
	 * The class scheme.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassSchemeId")
	private ClassScheme classScheme;
	
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
	 * The class description.
	 */
	@Column(name="cfDef")
	private String definition;
	
	/**
	 * The class description source.
	 */
	@Column(name="cfDefSrc")
	private String definitionSrc;


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
	 * @return the definition
	 */
	public String getDefinition() {
		return definition;
	}

	/**
	 * @param definition the definition to set
	 */
	public void setDefinition(String definition) {
		this.definition = definition;
	}

	/**
	 * @return the definitionSrc
	 */
	public String getDefinitionSrc() {
		return definitionSrc;
	}

	/**
	 * @param definitionSrc the definitionSrc to set
	 */
	public void setDefinitionSrc(String definitionSrc) {
		this.definitionSrc = definitionSrc;
	}
}

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
 * Holds the multi-lingual term of a class entity.
 * 
 */
@Entity
@Table(name="cfClassTerm")
@IdClass(ClassTranslationId.class)
public class ClassTerm implements ClassTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 782213354305473362L;	
	
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
	 * The class term.
	 */
	@Column(name="cfTerm")
	private String term;
	
	/**
	 * The class roleExpr.
	 */
	@Column(name="cfRoleExpr")
	private String roleExpr;
	
	/**
	 * The class roleExprOpp.
	 */
	@Column(name="cfRoleExprOpp")
	private String roleExprOpp;
	
	/**
	 * The class termSrc.
	 */
	@Column(name="cfTermSrc")
	private String termSrc;


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
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}


	/**
	 * @param terms the terms to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}


	public String getRoleExpr() {
		return roleExpr;
	}


	public void setRoleExpr(String roleExpr) {
		this.roleExpr = roleExpr;
	}


	public String getRoleExprOpp() {
		return roleExprOpp;
	}


	public void setRoleExprOpp(String roleExprOpp) {
		this.roleExprOpp = roleExprOpp;
	}


	public String getTermSrc() {
		return termSrc;
	}


	public void setTermSrc(String termSrc) {
		this.termSrc = termSrc;
	}
}

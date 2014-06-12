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
 * Holds the multi-lingual term of a class entity.
 * 
 */
@Entity
@Table(name="cfClassTerm", uniqueConstraints=@UniqueConstraint(columnNames={"cfClassId","cfClassSchemeId","cfLangCode","cfTrans"}))
public class ClassTerm implements CerifMultipleLanguageFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 782213354305473362L;	
	
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
	 * The class term.
	 */
	@NotNull
	@Column(name="cfTerm", length=20000)
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
	 * Default Constructor
	 */
	public ClassTerm(){
		
	}
	
	/**
	 * 
	 * @param theClass
	 * @param classScheme
	 * @param language
	 * @param translation
	 * @param term
	 * @param roleExpr
	 * @param roleExprOpp
	 * @param termSrc
	 */
	public ClassTerm(Class theClass, ClassScheme classScheme,
			Language language, Translation translation, String term,
			String roleExpr, String roleExprOpp, String termSrc) {
		this.theClass = theClass;
		this.classScheme = classScheme;
		this.language = language;
		this.translation = translation;
		this.term = term;
		this.roleExpr = roleExpr;
		this.roleExprOpp = roleExprOpp;
		this.termSrc = termSrc;
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
				+ ((classScheme == null) ? 0 : classScheme.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result
				+ ((theClass == null) ? 0 : theClass.hashCode());
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
		ClassTerm other = (ClassTerm) obj;
		if (classScheme == null) {
			if (other.classScheme != null)
				return false;
		} else if (!classScheme.equals(other.classScheme))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (theClass == null) {
			if (other.theClass != null)
				return false;
		} else if (!theClass.equals(other.theClass))
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
		return "ClassTerm [id=" + id + ", classScheme=" + classScheme
				+ ", language=" + language + ", translation=" + translation
				+ ", term=" + term + ", roleExpr=" + roleExpr
				+ ", roleExprOpp=" + roleExprOpp + ", termSrc=" + termSrc + "]";
	}
	
	
}

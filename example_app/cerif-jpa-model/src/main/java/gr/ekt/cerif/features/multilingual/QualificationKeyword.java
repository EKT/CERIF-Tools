/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Qualification;
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
 * Holds the multi-lingual keyword of a qualification entity.
 * 
 */
@Entity
@Table(name="cfQualKeyw", uniqueConstraints=@UniqueConstraint(columnNames={"cfQualId","cfLangCode","cfTrans"}))
public class QualificationKeyword implements CerifMultipleLanguageFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3953951167292983041L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The qualification.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfQualId")
	private Qualification qualification;
	
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
	 * The qualification keyword.
	 */
	@NotNull
	@Column(name="cfKeyw", length=20000)
	private String keyword;
	
	/**
	 * Default Constructor
	 */
	public QualificationKeyword() {
		
	}
	
	/**
	 * 
	 * @param qualification
	 * @param language
	 * @param translation
	 * @param keyword
	 */
	public QualificationKeyword(Qualification qualification, Language language,
			Translation translation, String keyword) {
		this.qualification = qualification;
		this.language = language;
		this.translation = translation;
		this.keyword = keyword;
	}

	/**
	 * @return the qualification
	 */
	public Qualification getQualification() {
		return qualification;
	}
	
	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
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
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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

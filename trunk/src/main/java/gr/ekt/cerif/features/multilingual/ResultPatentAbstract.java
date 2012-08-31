/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.result.ResultPatent;
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
 * Holds the multi-lingual keyword of a ResultPatent entity.
 * 
 */
@Entity
@Table(name="cfResPatAbstr", uniqueConstraints=@UniqueConstraint(columnNames={"cfResPatId","cfLangCode","cfTrans"}))
public class ResultPatentAbstract implements ResultPatentTranslation {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -5273009887217327359L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The result patent.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfResPatId")
	private ResultPatent resultPatent;
	
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
	 * The result patent abstract.
	 */
	@Column(name="cfAbstr")
	private String abstractText;

	/**
	 * Default Constructor
	 */
	public ResultPatentAbstract(){
		
	}
	/**
	 * Constructor
	 * @param resultPatent
	 * @param language
	 * @param translation
	 * @param abstractText
	 */
	public ResultPatentAbstract(ResultPatent resultPatent, Language language,
			Translation translation, String abstractText) {
		this.resultPatent = resultPatent;
		this.language = language;
		this.translation = translation;
		this.abstractText = abstractText;
	}

	/**
	 * @return the resultPatent
	 */
	public ResultPatent getResultPatent() {
		return resultPatent;
	}

	/**
	 * @param resultPatent the resultPatent to set
	 */
	public void setResultPatent(ResultPatent resultPatent) {
		this.resultPatent = resultPatent;
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
	 * @return the abstractText
	 */
	public String getAbstractText() {
		return abstractText;
	}

	/**
	 * @param abstractText the abstractText to set
	 */
	public void setAbstractText(String abstractText) {
		this.abstractText = abstractText;
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




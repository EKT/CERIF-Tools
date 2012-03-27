/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.result.ResultPatentTranslationId;

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
 * Holds the multi-lingual keyword of a ResultPatent entity.
 * 
 */
@Entity
@Table(name="cfResPatKeyw")
@IdClass(ResultPatentTranslationId.class)
public class ResultPatentKeyword implements ResultPatentTranslation {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 4706680035680909482L;	
	
	/**
	 * The result patent.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfResPatId")
	private ResultPatent resultPatent;
	
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
	 * The result patent title.
	 */
	@Column(name="cfKeyw")
	private String keyword;

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
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}




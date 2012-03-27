/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.result.ResultProductTranslationId;

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
 * Holds the multi-lingual versionInfo of a ResultProduct entity.
 * 
 */
@Entity
@Table(name="cfResProdVersInfo")
@IdClass(ResultProductTranslationId.class)
public class ResultProductVersionInfo implements ResultProductTranslation{

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 744507769483523987L;
	
	/**
	 * The result product.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfResProdId")
	private ResultProduct resultProduct;
	
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
	 * The result product versionInfo.
	 */
	@Column(name="cfVersInfo")
	private String versionInfo;

	/**
	 * @return the resultProduct
	 */
	public ResultProduct getResultProduct() {
		return resultProduct;
	}

	/**
	 * @param resultProduct the resultProduct to set
	 */
	public void setResultProduct(ResultProduct resultProduct) {
		this.resultProduct = resultProduct;
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
	 * @return the versionInfo
	 */
	public String getVersionInfo() {
		return versionInfo;
	}

	/**
	 * @param versionInfo the versionInfo to set
	 */
	public void setVersionInfo(String versionInfo) {
		this.versionInfo = versionInfo;
	}	

}


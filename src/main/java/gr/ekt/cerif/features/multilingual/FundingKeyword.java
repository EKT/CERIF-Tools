/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.FundingTranslationId;

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
 * Holds the multi-lingual keyword of a funding entity.
 * 
 */
@Entity
@Table(name="cfFundKeyw")
@IdClass(FundingTranslationId.class)
public class FundingKeyword implements FundingTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -485976212032846123L;

	/**
	 * The funding.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfFundId")
	private Funding funding;
	
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
	 * The funding keyword.
	 */
	@Column(name="cfKeyw")
	private String keyword;
	
	/**
	 * @return the funding
	 */
	public Funding getFunding() {
		return funding;
	}
	
	/**
	 * @param funding the funding to set
	 */
	public void setFunding(Funding funding) {
		this.funding = funding;
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

}

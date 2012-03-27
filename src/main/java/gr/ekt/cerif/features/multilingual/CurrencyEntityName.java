/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.CurrencyTranslationId;

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
 * Holds the multi-lingual entity name of a currency entity.
 * 
 */
@Entity
@Table(name="cfCurrencyEntName")
@IdClass(CurrencyTranslationId.class)
public class CurrencyEntityName implements CurrencyTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -2246692827611179613L;

	/**
	 * The currency.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfCurrCode")
	private Currency currency;
	
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
	 * The currency entity name.
	 */
	@Column(name="cfEntName")
	private String entityName;
	
	/**
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}
	
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
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
	 * @return the entityName
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * @param entityName the entityName to set
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

}

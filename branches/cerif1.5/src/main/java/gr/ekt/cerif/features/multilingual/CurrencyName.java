/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Currency;
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
 * Holds the multi-lingual name of a currency entity.
 * 
 */
@Entity
@Table(name="cfCurrencyName", uniqueConstraints=@UniqueConstraint(columnNames={"cfCurrCode","cfLangCode","cfTrans"}))
public class CurrencyName implements CurrencyTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -4071378948198300904L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The currency.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfCurrCode")
	private Currency currency;
	
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
	 * The currency name.
	 */
	@Column(name="cfName")
	private String name;
	
	/**
	 * Default Constructor
	 */
	public CurrencyName() {
		
	}
	
	/**
	 * 
	 * @param currency
	 * @param language
	 * @param translation
	 * @param name
	 */
	public CurrencyName(Currency currency, Language language,
			Translation translation, String name) {
		this.currency = currency;
		this.language = language;
		this.translation = translation;
		this.name = name;
	}

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.result.ResultProduct;
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

@Entity
@Table(name="cfResProdAltName", uniqueConstraints=@UniqueConstraint(columnNames={"cfResProdId","cfLangCode","cfTrans"}))
public class ResultProductAlternateName implements CerifMultipleLanguageFeature {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -6297737780280465788L;

	/**
	 * The identifier.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The result product.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfResProdId")
	private ResultProduct resultProduct;
	
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
	 * The alternate name.
	 */
	@Column(name="cfAltName", length=20000)
	private String alternateName;

	/**
	 * Returns the id.
	 * @return the id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id the id.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the resultProduct.
	 * @return the resultProduct.
	 */
	public ResultProduct getResultProduct() {
		return resultProduct;
	}

	/**
	 * Sets the resultProduct.
	 * @param resultProduct the resultProduct.
	 */
	public void setResultProduct(ResultProduct resultProduct) {
		this.resultProduct = resultProduct;
	}

	/**
	 * Returns the language.
	 * @return the language.
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 * @param language the language.
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

	/**
	 * Returns the translation.
	 * @return the translation.
	 */
	public Translation getTranslation() {
		return translation;
	}

	/**
	 * Sets the translation.
	 * @param translation the translation.
	 */
	public void setTranslation(Translation translation) {
		this.translation = translation;
	}

	/**
	 * Returns the alternateName.
	 * @return the alternateName.
	 */
	public String getAlternateName() {
		return alternateName;
	}

	/**
	 * Sets the alternateName.
	 * @param alternateName the alternateName.
	 */
	public void setAlternateName(String alternateName) {
		this.alternateName = alternateName;
	}
	
}

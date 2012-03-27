/**
 * 
 */
package gr.ekt.cerif.entities.link.result;

import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.pk.result.ResultProduct_CountryId;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Links an organization unit with a postal address.
 * 
 */
@Entity
@Table(name="cfResProd_Country")
@IdClass(ResultProduct_CountryId.class)
@NamedQueries({
	@NamedQuery(name="ResultProduct_Country.getProductsByCountry", query="SELECT a.country, count(a.country) FROM ResultProduct_Country a GROUP BY a.country"),
	@NamedQuery(name="ResultProduct_Country.getProductsByCountryCode", query="SELECT a.resultProduct FROM ResultProduct_Country a WHERE a.country.code LIKE :code OR a.country.uri LIKE :code")
})

public class ResultProduct_Country implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -389578121645571064L;
	
	/**
	 * The result product.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfResProdId")
	private ResultProduct resultProduct;

	/**
	 * The country.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfCountryId")
	private Country country;

	/**
	 * The class.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassId")	
	private Class theClass;
	
	/**
	 * The start date.
	 */
	@Id
	@Column (name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@Id
	@Column (name="cfEndDate")
	private Date endDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;
	
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
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
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
	 * Returns the start date.
	 * @return the start date.
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 * @param startDate the start date.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Returns the end date.
	 * @return the end date.
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 * @param endDate the end date.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Returns the fraction.
	 * @return the fraction.
	 */
	public Double getFraction() {
		return fraction;
	}

	/**
	 * Sets the fraction.
	 * @param fraction the fraction.
	 */
	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}


}

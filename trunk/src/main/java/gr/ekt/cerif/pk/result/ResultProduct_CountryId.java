/**
 * 
 */
package gr.ekt.cerif.pk.result;

import java.io.Serializable;
import java.util.Date;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.features.semantics.Class;

/**
 * Compound key for associating an organisation with a postal address.
 * @see ResultProduct
 * @see Country
 * 
 */
public class ResultProduct_CountryId implements Serializable {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 2713795253519213348L;

	/**
	 * The result product.
	 */
	private ResultProduct resultProduct;

	/**
	 * The country.
	 */
	private Country country;

	/**
	 * The class.
	 */
	private Class theClass;
	
	/**
	 * The start date.
	 */
	private Date startDate;
	
	/**
	 * The end date.
	 */
	private Date endDate;

	/**
	 * @return the resultProduct
	 */
	public ResultProduct getResultProduct() {
		return resultProduct;
	}

	/**
	 * @param ResultProduct the resultProduct to set
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}

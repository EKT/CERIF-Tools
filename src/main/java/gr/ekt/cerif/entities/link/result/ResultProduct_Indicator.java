/**
 * 
 */
package gr.ekt.cerif.entities.link.result;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.result.ResultProduct_IndicatorId;

/**
 * 
 */
@Entity
@Table(name="cfResProd_Indic")
@IdClass(ResultProduct_IndicatorId.class)
public class ResultProduct_Indicator implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5321868604172974100L;

	/**
	 * The result product.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfResProdId")
	private ResultProduct resultProduct;
	
	/**
	 * The indicator.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfIndicId")
	private Indicator indicator;
	
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
	 * @return the indicator
	 */
	public Indicator getIndicator() {
		return indicator;
	}

	/**
	 * @param indicator the indicator to set
	 */
	public void setIndicator(Indicator indicator) {
		this.indicator = indicator;
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

	/**
	 * @return the fraction
	 */
	public Double getFraction() {
		return fraction;
	}

	/**
	 * @param fraction the fraction to set
	 */
	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}
	
}

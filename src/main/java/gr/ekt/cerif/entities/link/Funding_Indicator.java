/**
 * 
 */
package gr.ekt.cerif.entities.link;

import java.util.Date;

import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.Funding_IndicatorId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="cfFund_Indic")
@IdClass(Funding_IndicatorId.class)
public class Funding_Indicator implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3391364531265701846L;
	
	/**
	 * The funding.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfFundId")
	private Funding funding;
	
	/**
	 * The indicator.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfIndicId")
	private Indicator indicator;
	
	/**
	 * The Class.
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
	 * The amount.
	 */
	@Column(name="cfAmount")
	private Double amount;
	
	/**
	 * The currency.
	 */
	@Column(name="cfCurrCode")
	private Currency currency;

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

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
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
	
}

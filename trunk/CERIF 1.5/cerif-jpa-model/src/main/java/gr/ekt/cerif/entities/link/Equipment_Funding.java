/**
 * 
 */
package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.semantics.Class;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 */
@Entity
@Table(name="cfEquip_Fund", uniqueConstraints=@UniqueConstraint(columnNames={"cfEquipId", "cfFundId", "cfClassId", "cfStartDate", "cfEndDate"}) )
public class Equipment_Funding implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4466478409053153427L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The equipment.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfEquipId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Equipment equipment;
	
	/**
	 * The funding.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfFundId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Funding funding;
	
	/**
	 * The Class.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassId")	
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Class theClass;
	
	/**
	 * The start date.
	 */
	@NotNull
	@Column (name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@NotNull
	@Column (name="cfEndDate")
	private Date endDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;
	
	/**
	 * The currency code.
	 */
	@ManyToOne
	@JoinColumn(name="cfCurrCode")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Currency currency;
	
	/**
	 * The amount.
	 */
	@Column(name="cfAmount")
	private Double amount;

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

	/**
	 * Default Constructor
	 */
	public Equipment_Funding() {
		
	}
	
	/**
	 * 
	 * @param equipment
	 * @param funding
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 * @param amount
	 * @param currency
	 */
	public Equipment_Funding(Equipment equipment, Funding funding,
			Class theClass, Date startDate, Date endDate, Double fraction,
			Double amount, Currency currency) {
		this.equipment = equipment;
		this.funding = funding;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
		this.amount = amount;
		this.currency = currency;
	}

	/**
	 * @return the equipment
	 */
	public Equipment getEquipment() {
		return equipment;
	}

	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

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

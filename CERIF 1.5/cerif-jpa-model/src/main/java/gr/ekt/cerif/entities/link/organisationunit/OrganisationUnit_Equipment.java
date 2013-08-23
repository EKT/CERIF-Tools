/**
 * 
 */
package gr.ekt.cerif.entities.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.second.Currency;
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
@Table(name="cfOrgUnit_Equip", uniqueConstraints=@UniqueConstraint(columnNames={"cfOrgUnitId", "cfEquipId", "cfClassId", "cfStartDate", "cfEndDate"}) )
public class OrganisationUnit_Equipment implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2514809715031910038L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The organisation unit.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfOrgUnitId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private OrganisationUnit organisationUnit;
	
	/**
	 * The equipment.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfEquipId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Equipment equipment;
	
	/**
	 * The class.
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
	 * The price.
	 */
	@Column(name="cfPrice")
	private Double price;
	
	/**
	 * The currency code.
	 */
	@ManyToOne
	@JoinColumn(name="cfCurrCode")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Currency currency;
	
	/**
	 * The availability.
	 */
	@Column(name="cfAvailability")
	private String availability;
	
	/**
	 * The conditions.
	 */
	@Column(name="cfConditions")
	private String conditions;

	/**
	 * Default Constructor
	 */
	public OrganisationUnit_Equipment() {
		
	}
	
	/**
	 * 
	 * @param organisationUnit
	 * @param equipment
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 * @param price
	 * @param currency
	 * @param availability
	 * @param conditions
	 */
	public OrganisationUnit_Equipment(OrganisationUnit organisationUnit,
			Equipment equipment, Date startDate, Date endDate, Double fraction,
			Double price, Currency currency, String availability,
			String conditions) {
		this.organisationUnit = organisationUnit;
		this.equipment = equipment;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
		this.price = price;
		this.currency = currency;
		this.availability = availability;
		this.conditions = conditions;
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

	/**
	 * @return the organisationUnit
	 */
	public OrganisationUnit getOrganisationUnit() {
		return organisationUnit;
	}

	/**
	 * @param organisationUnit the organisationUnit to set
	 */
	public void setOrganisationUnit(OrganisationUnit organisationUnit) {
		this.organisationUnit = organisationUnit;
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
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
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
	 * @return the availability
	 */
	public String getAvailability() {
		return availability;
	}

	/**
	 * @param availability the availability to set
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}

	/**
	 * @return the conditions
	 */
	public String getConditions() {
		return conditions;
	}

	/**
	 * @param conditions the conditions to set
	 */
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	
}

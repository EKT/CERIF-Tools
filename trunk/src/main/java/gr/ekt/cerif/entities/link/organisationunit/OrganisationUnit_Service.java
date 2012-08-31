/**
 * 
 */
package gr.ekt.cerif.entities.link.organisationunit;

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

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.second.Currency;

/**
 * 
 */
@Entity
@Table(name="cfOrgUnit_Srv", uniqueConstraints=@UniqueConstraint(columnNames={"cfOrgUnitId","cfSrvId","cfStartDate","cfEndDate"}))
public class OrganisationUnit_Service implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3838029240573386452L;

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
	private OrganisationUnit organisationUnit;
	
	/**
	 * The service.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfSrvId")
	private Service service;
	
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
	 * The currency.
	 */
	@ManyToOne
	@JoinColumn(name="cfCurrCode", nullable=false)
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
	public OrganisationUnit_Service() {
		
	}
	
	/**
	 * 
	 * @param organisationUnit
	 * @param service
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 * @param price
	 * @param currency
	 * @param availability
	 * @param conditions
	 */
	public OrganisationUnit_Service(OrganisationUnit organisationUnit,
			Service service, Date startDate, Date endDate, Double fraction,
			Double price, Currency currency, String availability,
			String conditions) {
		this.organisationUnit = organisationUnit;
		this.service = service;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
		this.price = price;
		this.currency = currency;
		this.availability = availability;
		this.conditions = conditions;
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
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(Service service) {
		this.service = service;
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

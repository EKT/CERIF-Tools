/**
 * 
 */
package gr.ekt.cerif.entities.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.semantics.Class;

import java.util.Date;

import javax.persistence.Cacheable;
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
 * Links a project with a Funding.
 * 
 */
@Entity
@Table(name="cfProj_Fund", uniqueConstraints=@UniqueConstraint(columnNames={"cfProjId", "cfFundId", "cfClassId", "cfStartDate", "cfEndDate"}) )
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Project_Funding implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 7399238214374425624L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The project.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfProjId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Project project;
	
	/**
	 * The Funding.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfFundId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Funding funding;
	
	/**
	 * The class.
	 */
	@ManyToOne
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
	public Project_Funding() {
		
	}
	/**
	 * 
	 * @param project
	 * @param funding
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 * @param currency
	 */
	public Project_Funding(Project project, Funding funding, Class theClass,
			Date startDate, Date endDate, Double fraction, Currency currency) {
		super();
		this.project = project;
		this.funding = funding;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
		this.currency = currency;
	}
	
	/**
	 * 
	 * @param project
	 * @param funding
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 */
	public Project_Funding(Project project, Funding funding, Class theClass, Date startDate, Date endDate) {
		super();
		this.project = project;
		this.funding = funding;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
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

	/**
	 * Returns the project.
	 * @return the project.
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * Sets the project.
	 * @param project the project.
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	public Funding getFunding() {
		return funding;
	}

	public void setFunding(Funding funding) {
		this.funding = funding;
	}

	/**
	 * Returns the class.
	 * @return the class.
	 */
	public Class getTheClass() {
		return theClass;
	}

	/**
	 * Sets the class.
	 * @param theClass the class.
	 */
	public void setTheClass(Class theClass) {
		this.theClass = theClass;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Project_Funding [id=" + id + ", project=" + project
				+ ", funding=" + funding + ", theClass=" + theClass
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", fraction=" + fraction + ", currency=" + currency
				+ ", amount=" + amount + "]";
	}

	
}

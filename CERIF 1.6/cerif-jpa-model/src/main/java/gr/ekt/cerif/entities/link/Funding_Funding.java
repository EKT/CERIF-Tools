/**
 * 
 */
package gr.ekt.cerif.entities.link;

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

/**
 * 
 */
@Entity
@Table(name="cfFund_Fund", uniqueConstraints=@UniqueConstraint(columnNames={"cfFundId1","cfFundId2", "cfClassId", "cfStartDate", "cfEndDate"}))
public class Funding_Funding implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5022721020255387896L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The first funding.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfFundId1")
	private Funding funding1;
	
	/**
	 * The second funding.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfFundId2")
	private Funding funding2;
	
	/**
	 * The Class.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfClassId")	
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
	 * Default Constructor
	 */
	public Funding_Funding(){
		
	}
	
	/**
	 * 
	 * @param funding1
	 * @param funding2
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public Funding_Funding(Funding funding1, Funding funding2, Class theClass,
			Date startDate, Date endDate, Double fraction) {
		this.funding1 = funding1;
		this.funding2 = funding2;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

	/**
	 * @return the funding1
	 */
	public Funding getFunding1() {
		return funding1;
	}

	/**
	 * @param funding1 the funding1 to set
	 */
	public void setFunding1(Funding funding1) {
		this.funding1 = funding1;
	}

	/**
	 * @return the funding2
	 */
	public Funding getFunding2() {
		return funding2;
	}

	/**
	 * @param funding2 the funding2 to set
	 */
	public void setFunding2(Funding funding2) {
		this.funding2 = funding2;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Funding_Funding [id=" + id + ", funding1=" + funding1
				+ ", funding2=" + funding2 + ", theClass=" + theClass
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", fraction=" + fraction + "]";
	}
	
	
}

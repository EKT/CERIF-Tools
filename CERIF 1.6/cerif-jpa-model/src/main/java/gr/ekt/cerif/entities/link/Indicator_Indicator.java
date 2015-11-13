/**
 * 
 */
package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.entities.second.Indicator;
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
@Table(name="cfIndic_Indic",uniqueConstraints=@UniqueConstraint(columnNames={"cfIndicId1", "cfIndicId2", "cfClassId", "cfStartDate", "cfEndDate"}))
public class Indicator_Indicator implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7125387232758656697L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The first indicator.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfIndicId1")
	private Indicator indicator1;
	
	/**
	 * The second indicator.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfIndicId2")
	private Indicator indicator2;
	
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
	public Indicator_Indicator() {
		
	}
	
	/**
	 * 
	 * @param indicator1
	 * @param indicator2
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public Indicator_Indicator(Indicator indicator1, Indicator indicator2,
			Class theClass, Date startDate, Date endDate, Double fraction) {
		this.indicator1 = indicator1;
		this.indicator2 = indicator2;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

	/**
	 * @return the indicator1
	 */
	public Indicator getIndicator1() {
		return indicator1;
	}

	/**
	 * @param indicator1 the indicator1 to set
	 */
	public void setIndicator1(Indicator indicator1) {
		this.indicator1 = indicator1;
	}

	/**
	 * @return the indicator2
	 */
	public Indicator getIndicator2() {
		return indicator2;
	}

	/**
	 * @param indicator2 the indicator2 to set
	 */
	public void setIndicator2(Indicator indicator2) {
		this.indicator2 = indicator2;
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
		return "Indicator_Indicator [id=" + id + ", indicator1=" + indicator1
				+ ", indicator2=" + indicator2 + ", theClass=" + theClass
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", fraction=" + fraction + "]";
	}
	
	
}

/**
 * 
 */
package gr.ekt.cerif.entities.link;

import java.util.Date;

import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.Indicator_IndicatorId;

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
@Table(name="cfIndic_Indic")
@IdClass(Indicator_IndicatorId.class)
public class Indicator_Indicator implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7125387232758656697L;

	/**
	 * The first indicator.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfIndicId1")
	private Indicator indicator1;
	
	/**
	 * The second indicator.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfIndicId2")
	private Indicator indicator2;
	
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
	
}

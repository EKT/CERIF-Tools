/**
 * 
 */
package gr.ekt.cerif.entities.link;

import java.util.Date;

import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.Measurement_MeasurementId;

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
@Table(name="cfMeas_Meas")
@IdClass(Measurement_MeasurementId.class)
public class Measurement_Measurement implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1486561624205350040L;
	
	/**
	 * The first measurement.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfMeasId1")
	private Measurement measurement1;

	/**
	 * The second measurement.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfMeasId2")
	private Measurement measurement2;
	
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
	 * @return the measurement1
	 */
	public Measurement getMeasurement1() {
		return measurement1;
	}

	/**
	 * @param measurement1 the measurement1 to set
	 */
	public void setMeasurement1(Measurement measurement1) {
		this.measurement1 = measurement1;
	}

	/**
	 * @return the measurement2
	 */
	public Measurement getMeasurement2() {
		return measurement2;
	}

	/**
	 * @param measurement2 the measurement2 to set
	 */
	public void setMeasurement2(Measurement measurement2) {
		this.measurement2 = measurement2;
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

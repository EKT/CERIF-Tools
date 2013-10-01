/**
 * 
 */
package gr.ekt.cerif.entities.link;

import java.util.Date;

import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.semantics.Class;

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
@Table(name="cfMeas_Meas", uniqueConstraints=@UniqueConstraint(columnNames={"cfMeasId1","cfMeasId2", "cfClassId", "cfStartDate", "cfEndDate"}))
public class Measurement_Measurement implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1486561624205350040L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The first measurement.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfMeasId1")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Measurement measurement1;

	/**
	 * The second measurement.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfMeasId2")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Measurement measurement2;
	
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
	 * Default Constructor
	 */
	public Measurement_Measurement() {
		
	}
	
	/**
	 * 
	 * @param measurement1
	 * @param measurement2
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public Measurement_Measurement(Measurement measurement1,
			Measurement measurement2, Class theClass, Date startDate,
			Date endDate, Double fraction) {
		this.measurement1 = measurement1;
		this.measurement2 = measurement2;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

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

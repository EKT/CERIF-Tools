package gr.ekt.cerif.entities.link;

import java.util.Date;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
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

@Entity
@Table(name="cfGeoBBox_Meas", uniqueConstraints=@UniqueConstraint(columnNames={"cfGeoBBoxId","cfMeasId","cfClassId","cfStartDate","cfEndDate"}))
public class GeographicBoundingBox_Measurement implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -2127008304415394198L;

	/**
	 * The identifier.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The geographic bounding box.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfGeoBBoxId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private GeographicBoundingBox geographicBoundingBox;
	
	/**
	 * The measurement.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfMeasId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Measurement measurement;
	
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
	 * Returns the id.
	 * @return the id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id the id.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the geographicBoundingBox.
	 * @return the geographicBoundingBox.
	 */
	public GeographicBoundingBox getGeographicBoundingBox() {
		return geographicBoundingBox;
	}

	/**
	 * Sets the geographicBoundingBox.
	 * @param geographicBoundingBox the geographicBoundingBox.
	 */
	public void setGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox) {
		this.geographicBoundingBox = geographicBoundingBox;
	}

	/**
	 * Returns the measurement.
	 * @return the measurement.
	 */
	public Measurement getMeasurement() {
		return measurement;
	}

	/**
	 * Sets the measurement.
	 * @param measurement the measurement.
	 */
	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}

	/**
	 * Returns the theClass.
	 * @return the theClass.
	 */
	public Class getTheClass() {
		return theClass;
	}

	/**
	 * Sets the theClass.
	 * @param theClass the theClass.
	 */
	public void setTheClass(Class theClass) {
		this.theClass = theClass;
	}

	/**
	 * Returns the startDate.
	 * @return the startDate.
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the startDate.
	 * @param startDate the startDate.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Returns the endDate.
	 * @return the endDate.
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the endDate.
	 * @param endDate the endDate.
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
	
}

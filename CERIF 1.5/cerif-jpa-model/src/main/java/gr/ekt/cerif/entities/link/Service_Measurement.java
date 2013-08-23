/**
 * 
 */
package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.second.Measurement;
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
@Table(name="cfSrv_Meas", uniqueConstraints=@UniqueConstraint(columnNames={"cfSrvId","cfMeasId","cfClassId","cfStartDate","cfEndDate"}))
public class Service_Measurement implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3550822798938041610L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The service.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfSrvId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Service service;
	
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
	 * Default Constructor
	 */
	public Service_Measurement() {
		
	}
	
	/**
	 * 
	 * @param service
	 * @param measurement
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public Service_Measurement(Service service, Measurement measurement,
			Class theClass, Date startDate, Date endDate, Double fraction) {
		this.service = service;
		this.measurement = measurement;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
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
	 * @return the measurement
	 */
	public Measurement getMeasurement() {
		return measurement;
	}

	/**
	 * @param measurement the measurement to set
	 */
	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
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

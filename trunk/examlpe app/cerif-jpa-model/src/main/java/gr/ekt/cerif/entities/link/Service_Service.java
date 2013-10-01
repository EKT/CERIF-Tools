/**
 * 
 */
package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.entities.infrastructure.Service;
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
@Table(name="cfSrv_Srv", uniqueConstraints=@UniqueConstraint(columnNames={"cfSrvId1","cfSrvId2","cfClassId","cfStartDate","cfEndDate"}))
public class Service_Service implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8107429870677817427L;

	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The first service.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfSrvId1")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Service service1;
	
	/**
	 * The second service.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfSrvId2")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Service service2;
	
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
	public Service_Service() {
		
	}
	
	/**
	 * 
	 * @param service1
	 * @param service2
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public Service_Service(Service service1, Service service2, Class theClass,
			Date startDate, Date endDate, Double fraction) {
		this.service1 = service1;
		this.service2 = service2;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

	/**
	 * @return the service1
	 */
	public Service getService1() {
		return service1;
	}

	/**
	 * @param service1 the service1 to set
	 */
	public void setService1(Service service1) {
		this.service1 = service1;
	}

	/**
	 * @return the service2
	 */
	public Service getService2() {
		return service2;
	}

	/**
	 * @param service2 the service2 to set
	 */
	public void setService2(Service service2) {
		this.service2 = service2;
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

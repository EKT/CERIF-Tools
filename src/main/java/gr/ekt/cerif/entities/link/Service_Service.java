/**
 * 
 */
package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.Service_ServiceId;

import java.util.Date;

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
@Table(name="cfSrv_Srv")
@IdClass(Service_ServiceId.class)
public class Service_Service implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8107429870677817427L;

	/**
	 * The first service.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfSrvId1")
	private Service service1;
	
	/**
	 * The second service.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfSrvId2")
	private Service service2;
	
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
	
}

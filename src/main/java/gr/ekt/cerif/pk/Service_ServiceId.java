/**
 * 
 */
package gr.ekt.cerif.pk;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
*/
public class Service_ServiceId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1033048493830763976L;

	/**
	 * The first service.
	 */
	private Service service1;
	
	/**
	 * The second service.
	 */
	private Service service2;
	
	/**
	 * The Class.
	 */
	private Class theClass;
	
	/**
	 * The start date.
	 */
	private Date startDate;
	
	/**
	 * The end date.
	 */
	private Date endDate;

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
	
}

/**
 * 
 */
package gr.ekt.cerif.pk;

import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
*/
public class Class_ClassId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1656170446016347250L;

	/**
	 * The first class.
	 */
	private Class theClass1;
	
	/**
	 * The second class.
	 */
	private Class theClass2;
	
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
	 * @return the theClass1
	 */
	public Class getTheClass1() {
		return theClass1;
	}

	/**
	 * @param theClass1 the theClass1 to set
	 */
	public void setTheClass1(Class theClass1) {
		this.theClass1 = theClass1;
	}

	/**
	 * @return the theClass2
	 */
	public Class getTheClass2() {
		return theClass2;
	}

	/**
	 * @param theClass2 the theClass2 to set
	 */
	public void setTheClass2(Class theClass2) {
		this.theClass2 = theClass2;
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

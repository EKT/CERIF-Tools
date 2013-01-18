/**
 * 
 */
package gr.ekt.cerif.pk;

import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
*/
public class Medium_MediumId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8932186211326877570L;

	/**
	 * The first medium.
	 */
	private Medium medium1;
	
	/**
	 * The second medium.
	 */
	private Medium medium2;
	
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
	 * @return the medium1
	 */
	public Medium getMedium1() {
		return medium1;
	}

	/**
	 * @param medium1 the medium1 to set
	 */
	public void setMedium1(Medium medium1) {
		this.medium1 = medium1;
	}

	/**
	 * @return the medium2
	 */
	public Medium getMedium2() {
		return medium2;
	}

	/**
	 * @param medium2 the medium2 to set
	 */
	public void setMedium2(Medium medium2) {
		this.medium2 = medium2;
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

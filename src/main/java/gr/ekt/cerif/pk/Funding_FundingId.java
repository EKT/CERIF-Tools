/**
 * 
 */
package gr.ekt.cerif.pk;

import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
*/
public class Funding_FundingId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7989449644445185657L;

	/**
	 * The first funding.
	 */
	private Funding funding1;
	
	/**
	 * The second funding.
	 */
	private Funding funding2;
	
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
	 * @return the funding1
	 */
	public Funding getFunding1() {
		return funding1;
	}

	/**
	 * @param funding1 the funding1 to set
	 */
	public void setFunding1(Funding funding1) {
		this.funding1 = funding1;
	}

	/**
	 * @return the funding2
	 */
	public Funding getFunding2() {
		return funding2;
	}

	/**
	 * @param funding2 the funding2 to set
	 */
	public void setFunding2(Funding funding2) {
		this.funding2 = funding2;
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

/**
 * 
 */
package gr.ekt.cerif.pk.result;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 */
public class ResultPatent_ResultPatentId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6583084169905572853L;

	/**
	 * The first result patent.
	 */
	private ResultPatent resultPatent1;
	
	/**
	 * The result patent.
	 */
	private ResultPatent resultPatent2;
	
	/**
	 * The class.
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
	 * @return the resultPatent1
	 */
	public ResultPatent getResultPatent1() {
		return resultPatent1;
	}

	/**
	 * @param resultPatent1 the resultPatent1 to set
	 */
	public void setResultPatent1(ResultPatent resultPatent1) {
		this.resultPatent1 = resultPatent1;
	}

	/**
	 * @return the resultPatent2
	 */
	public ResultPatent getResultPatent2() {
		return resultPatent2;
	}

	/**
	 * @param resultPatent2 the resultPatent2 to set
	 */
	public void setResultPatent2(ResultPatent resultPatent2) {
		this.resultPatent2 = resultPatent2;
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

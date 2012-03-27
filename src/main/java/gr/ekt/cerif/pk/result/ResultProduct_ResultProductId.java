/**
 * 
 */
package gr.ekt.cerif.pk.result;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 */
public class ResultProduct_ResultProductId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 281078205900874694L;
	
	/**
	 * The first result product.
	 */
	private ResultProduct resultProduct1;
	
	/**
	 * The second result product.
	 */
	private ResultProduct resultProduct2;
	
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
	 * @return the resultProduct1
	 */
	public ResultProduct getResultProduct1() {
		return resultProduct1;
	}

	/**
	 * @param resultProduct1 the resultProduct1 to set
	 */
	public void setResultProduct1(ResultProduct resultProduct1) {
		this.resultProduct1 = resultProduct1;
	}

	/**
	 * @return the resultProduct2
	 */
	public ResultProduct getResultProduct2() {
		return resultProduct2;
	}

	/**
	 * @param resultProduct2 the resultProduct2 to set
	 */
	public void setResultProduct2(ResultProduct resultProduct2) {
		this.resultProduct2 = resultProduct2;
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

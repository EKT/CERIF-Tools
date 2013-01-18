/**
 * 
 */
package gr.ekt.cerif.pk.result;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 */
public class ResultPublication_ResultPublicationId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1676042711953401137L;

	/**
	 * The first result publication.
	 */
	private ResultPublication resultPublication1;
	
	/**
	 * The second result publication.
	 */
	private ResultPublication resultPublication2;
	
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
	 * @return the resultPublication1
	 */
	public ResultPublication getResultPublication1() {
		return resultPublication1;
	}

	/**
	 * @param resultPublication1 the resultPublication1 to set
	 */
	public void setResultPublication1(ResultPublication resultPublication1) {
		this.resultPublication1 = resultPublication1;
	}

	/**
	 * @return the resultPublication2
	 */
	public ResultPublication getResultPublication2() {
		return resultPublication2;
	}

	/**
	 * @param resultPublication2 the resultPublication2 to set
	 */
	public void setResultPublication2(ResultPublication resultPublication2) {
		this.resultPublication2 = resultPublication2;
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

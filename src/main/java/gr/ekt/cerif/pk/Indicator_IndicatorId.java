/**
 * 
 */
package gr.ekt.cerif.pk;

import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
*/
public class Indicator_IndicatorId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7649869457058692747L;

	/**
	 * The first indicator.
	 */
	private Indicator indicator1;
	
	/**
	 * The second indicator.
	 */
	private Indicator indicator2;
	
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
	 * @return the indicator1
	 */
	public Indicator getIndicator1() {
		return indicator1;
	}

	/**
	 * @param indicator1 the indicator1 to set
	 */
	public void setIndicator1(Indicator indicator1) {
		this.indicator1 = indicator1;
	}

	/**
	 * @return the indicator2
	 */
	public Indicator getIndicator2() {
		return indicator2;
	}

	/**
	 * @param indicator2 the indicator2 to set
	 */
	public void setIndicator2(Indicator indicator2) {
		this.indicator2 = indicator2;
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

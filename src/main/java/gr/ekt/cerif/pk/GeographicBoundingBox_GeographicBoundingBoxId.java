/**
 * 
 */
package gr.ekt.cerif.pk;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
*/
public class GeographicBoundingBox_GeographicBoundingBoxId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -481654017189171168L;

	/**
	 * The first geographic Bounding Box.
	 */
	private GeographicBoundingBox geographicBoundingBox1;
	
	/**
	 * The second geographic Bounding Box.
	 */
	private GeographicBoundingBox geographicBoundingBox2;
	
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
	 * @return the geographicBoundingBox1
	 */
	public GeographicBoundingBox getGeographicBoundingBox1() {
		return geographicBoundingBox1;
	}

	/**
	 * @param geographicBoundingBox1 the geographicBoundingBox1 to set
	 */
	public void setGeographicBoundingBox1(
			GeographicBoundingBox geographicBoundingBox1) {
		this.geographicBoundingBox1 = geographicBoundingBox1;
	}

	/**
	 * @return the geographicBoundingBox2
	 */
	public GeographicBoundingBox getGeographicBoundingBox2() {
		return geographicBoundingBox2;
	}

	/**
	 * @param geographicBoundingBox2 the geographicBoundingBox2 to set
	 */
	public void setGeographicBoundingBox2(
			GeographicBoundingBox geographicBoundingBox2) {
		this.geographicBoundingBox2 = geographicBoundingBox2;
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

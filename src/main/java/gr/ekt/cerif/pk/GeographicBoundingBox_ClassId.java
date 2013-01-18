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
public class GeographicBoundingBox_ClassId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5124447945026025877L;

	/**
	 * The geographic Bounding Box.
	 */
	private GeographicBoundingBox geographicBoundingBox;
	
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
	 * @return the geographicBoundingBox
	 */
	public GeographicBoundingBox getGeographicBoundingBox() {
		return geographicBoundingBox;
	}

	/**
	 * @param geographicBoundingBox the geographicBoundingBox to set
	 */
	public void setGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox) {
		this.geographicBoundingBox = geographicBoundingBox;
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

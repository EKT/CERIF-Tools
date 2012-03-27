/**
 * 
 */
package gr.ekt.cerif.pk;

import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
*/
public class Citation_MediumId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8482218250625481281L;

	/**
	 * The citation.
	 */
	private Citation citation;
	
	/**
	 * The medium.
	 */
	private Medium medium;
	
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
	 * @return the citation
	 */
	public Citation getCitation() {
		return citation;
	}

	/**
	 * @param citation the citation to set
	 */
	public void setCitation(Citation citation) {
		this.citation = citation;
	}

	/**
	 * @return the medium
	 */
	public Medium getMedium() {
		return medium;
	}

	/**
	 * @param medium the medium to set
	 */
	public void setMedium(Medium medium) {
		this.medium = medium;
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

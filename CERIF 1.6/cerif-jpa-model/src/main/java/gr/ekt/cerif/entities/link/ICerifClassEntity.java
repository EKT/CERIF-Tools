package gr.ekt.cerif.entities.link;

import java.util.Date;

import gr.ekt.cerif.features.semantics.Class;

public interface ICerifClassEntity extends CerifLinkEntity{
	/**
	 * Returns the class.
	 * @return the class.
	 */
	public Class getTheClass() ;

	/**
	 * Sets the class.
	 * @param theClass the class.
	 */
	public void setTheClass(Class theClass);
	
	/**
	 * Returns the start date.
	 * @return the start date.
	 */
	public Date getStartDate();

	/**
	 * Sets the start date.
	 * @param startDate the start date.
	 */
	public void setStartDate(Date startDate) ;

	/**
	 * Returns the end date.
	 * @return the end date.
	 */
	public Date getEndDate() ;

	/**
	 * Sets the end date.
	 * @param endDate the end date.
	 */
	public void setEndDate(Date endDate);
}

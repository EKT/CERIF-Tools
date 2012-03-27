/**
 * 
 */
package gr.ekt.cerif.pk;


import java.io.Serializable;
import java.util.Date;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

/**
 * Compound key for associating an organisation with a postal address.
 * @see OrganisationUnit
 * @see PostalAddress
 * 
 */
public abstract class Abstract implements Serializable {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 87479075305217612L;
	

	/**
	 * The class.
	 */
	private Class theClass;
	
	/**
	 * The class scheme.
	 */
	private ClassScheme classScheme;
	
	/**
	 * The start date.
	 */
	private Date startDate;
	
	/**
	 * The end date.
	 */
	private Date endDate;

	
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
	 * @return the classScheme
	 */
	public ClassScheme getClassScheme() {
		return classScheme;
	}

	/**
	 * @param classScheme the classScheme to set
	 */
	public void setClassScheme(ClassScheme classScheme) {
		this.classScheme = classScheme;
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

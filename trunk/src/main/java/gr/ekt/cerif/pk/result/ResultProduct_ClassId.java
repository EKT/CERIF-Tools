/**
 * 
 */
package gr.ekt.cerif.pk.result;

import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.entities.result.ResultProduct;

import java.io.Serializable;
import java.util.Date;


/**
 * Compound key for associating a product with a class.
 * @see ResultProduct
 * @see Class
 * 
 */
public class ResultProduct_ClassId implements Serializable {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -4028982986536209025L;

	/**
	 * The product.
	 */
	private ResultProduct resultProduct;
	
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
	 * Returns the product.
	 * @return the product.
	 */
	public ResultProduct getResultProduct() {
		return resultProduct;
	}

	/**
	 * Sets the product.
	* @param resultProduct the product.
	 */
	public void setResultProduct(ResultProduct resultProduct) {
		this.resultProduct = resultProduct;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((resultProduct == null) ? 0 : resultProduct.hashCode());
		result = prime * result
				+ ((theClass == null) ? 0 : theClass.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ResultProduct_ClassId)) {
			return false;
		}
		ResultProduct_ClassId other = (ResultProduct_ClassId) obj;
		if (resultProduct == null) {
			if (other.resultProduct != null) {
				return false;
			}
		} else if (!resultProduct.equals(other.resultProduct)) {
			return false;
		}
		if (theClass == null) {
			if (other.theClass != null) {
				return false;
			}
		} else if (!theClass.equals(other.theClass)) {
			return false;
		}
		return true;
	}
	
}

/**
 * 
 */
package gr.ekt.cerif.pk.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;

/**
 * Compound key for associating an organisation with a product.
 * @see OrganisationUnit
 * @see ResultProduct
 * 
 */
public class OrganisationUnit_ResultProductId implements Serializable {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -4028982986536209055L;

	/**
	 * The organization.
	 */
	private OrganisationUnit organisationUnit;
	
	/**
	 * The product.
	 */
	private ResultProduct resultProduct;
	

	
	/**
	 * The class.
	 */
	private Class theClass;

	/**
	 * Returns the organisation.
	 * @return the organisation.
	 */
	public OrganisationUnit getOrganisationUnit() {
		return organisationUnit;
	}

	/**
	 * Sets the organisation.
	 * @param organisationUnit the organisation.
	 */
	public void setOrganisationUnit(OrganisationUnit organisationUnit) {
		this.organisationUnit = organisationUnit;
	}

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
	
	public Class getTheClass() {
		return theClass;
	}

	public void setTheClass(Class theClass) {
		this.theClass = theClass;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((organisationUnit == null) ? 0 : organisationUnit.hashCode());
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
		if (!(obj instanceof OrganisationUnit_ResultProductId)) {
			return false;
		}
		OrganisationUnit_ResultProductId other = (OrganisationUnit_ResultProductId) obj;
		if (organisationUnit == null) {
			if (other.organisationUnit != null) {
				return false;
			}
		} else if (!organisationUnit.equals(other.organisationUnit)) {
			return false;
		}
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

/**
 * 
 */
package gr.ekt.cerif.entities.link.result;

import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.pk.result.ResultProduct_ClassId;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Links an organization unit with a result product.
 * 
 */
@Entity
@Table(name="cfResProd_Class")
@IdClass(ResultProduct_ClassId.class)
@NamedQueries({
	@NamedQuery(name="ResultProduct_Class.countProductsBySchemeURI", query="SELECT rpc.theClass, count(rpc.resultProduct) FROM ResultProduct_Class rpc WHERE rpc.theClass.scheme.uri = :uri group by rpc.theClass")
})

public class ResultProduct_Class implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -389578971645571064L;
	
	/**
	 * The result product.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfResProdId")
	private ResultProduct resultProduct;
	
	/**
	 * The class.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassId")	
	private Class theClass;
	
	/**
	 * The start date.
	 */
	@Id
	@Column (name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@Id
	@Column (name="cfEndDate")
	private Date endDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;
	

	/**
	 * Returns the result product.
	 * @return the result product.
	 */
	public ResultProduct getResultProduct() {
		return resultProduct;
	}

	/**
	 * Sets the result product.
	 * @param resultProduct the result product.
	 */
	public  void setResultProduct(ResultProduct resultProduct) {
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
	 * Returns the start date.
	 * @return the start date.
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 * @param startDate the start date.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Returns the end date.
	 * @return the end date.
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 * @param endDate the end date.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Returns the fraction.
	 * @return the fraction.
	 */
	public Double getFraction() {
		return fraction;
	}

	/**
	 * Sets the fraction.
	 * @param fraction the fraction.
	 */
	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}

	/**
	 * Returns whether this class represents temporal coverage information.
	 * @return whether this class represents temporal coverage information.
	 */
	public boolean getTemporalCoverage() {
		return theClass != null && 
			   theClass.getScheme() != null && 
			   "Temporal Coverage".equals(theClass.getScheme().getUri());
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
		if (!(obj instanceof ResultProduct_Class)) {
			return false;
		}
		ResultProduct_Class other = (ResultProduct_Class) obj;
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

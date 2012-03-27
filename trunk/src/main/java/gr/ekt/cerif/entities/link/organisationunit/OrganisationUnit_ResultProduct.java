/**
 * 
 */
package gr.ekt.cerif.entities.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.organisationunit.OrganisationUnit_ResultProductId;
import gr.ekt.cerif.entities.second.Currency;

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
 * Links an organization unit with a product.
 * 
 */
@Entity
@Table(name="cfOrgUnit_ResProd")
@IdClass(OrganisationUnit_ResultProductId.class)
@NamedQueries({
	@NamedQuery(name="OrganisationUnit_ResultProduct.countProductsBySchemeURI", query="SELECT rpc.organisationUnit, count(rpc.resultProduct) FROM OrganisationUnit_ResultProduct rpc WHERE rpc.theClass.uri = :uri group by rpc.organisationUnit")
})
public class OrganisationUnit_ResultProduct implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3895789716446471064L;
	
	/**
	 * The organisation unit.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfOrgUnitId")
	private OrganisationUnit organisationUnit;
	
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
	@Column (name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@Column (name="cfEndDate")
	private Date endDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;
	
	/**
	 * The price.
	 */
	@Column(name="cfPrice")
	private Double price;
	
	/**
	 * The currency.
	 */
	@ManyToOne
	@JoinColumn(name="cfCurrCode", nullable=false)
	private Currency currency;
	
	/**
	 * The availability.
	 */
	@Column(name="cfAvailability")
	private String availability;
	
	/**
	 * The conditions.
	 */
	@Column(name="cfConditions")
	private String conditions;

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
	 * Returns the price.
	 * @return the price.
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 * @param price the price.
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Returns the currency.
	 * @return the currency.
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 * @param currency the currency.
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	/**
	 * Returns the availability.
	 * @return the availability.
	 */
	public String getAvailability() {
		return availability;
	}

	/**
	 * Sets the availability.
	 * @param availability the availability.
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}

	/**
	 * Returns the conditions.
	 * @return the conditions.
	 */
	public String getConditions() {
		return conditions;
	}

	/**
	 * Sets the conditions.
	 * @param conditions the conditions.
	 */
	public void setConditions(String conditions) {
		this.conditions = conditions;
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
	 * Returns whether it defines the source organisation unit.
	 * @return whether it defines the source organisation unit.
	 */
	public boolean isSource() {
		return theClass != null && 
			   SOURCE_URI.equalsIgnoreCase(theClass.getUri());
	}
	
	/**
	 * Source classification.
	 */
	private final static String SOURCE_URI = "Source-URI";

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
		if (!(obj instanceof OrganisationUnit_ResultProduct)) {
			return false;
		}
		OrganisationUnit_ResultProduct other = (OrganisationUnit_ResultProduct) obj;
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

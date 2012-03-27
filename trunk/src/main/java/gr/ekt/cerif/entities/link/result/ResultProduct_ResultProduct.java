/**
 * 
 */
package gr.ekt.cerif.entities.link.result;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.result.ResultProduct_ResultProductId;

/**
 * 
 */
@Entity
@Table(name="cfResProd_ResProd")
@IdClass(ResultProduct_ResultProductId.class)
public class ResultProduct_ResultProduct implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5930415809369052887L;
	
	/**
	 * The first result product.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfResProdId1")
	private ResultProduct resultProduct1;
	
	/**
	 * The second result product.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfResProdId2")
	private ResultProduct resultProduct2;
	
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
	 * @return the resultProduct1
	 */
	public ResultProduct getResultProduct1() {
		return resultProduct1;
	}

	/**
	 * @param resultProduct1 the resultProduct1 to set
	 */
	public void setResultProduct1(ResultProduct resultProduct1) {
		this.resultProduct1 = resultProduct1;
	}

	/**
	 * @return the resultProduct2
	 */
	public ResultProduct getResultProduct2() {
		return resultProduct2;
	}

	/**
	 * @param resultProduct2 the resultProduct2 to set
	 */
	public void setResultProduct2(ResultProduct resultProduct2) {
		this.resultProduct2 = resultProduct2;
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

	/**
	 * @return the fraction
	 */
	public Double getFraction() {
		return fraction;
	}

	/**
	 * @param fraction the fraction to set
	 */
	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}

}

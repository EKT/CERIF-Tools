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
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.result.ResultPublication_ResultPublicationId;

/**
 * 
 */
@Entity
@Table(name="cfResPubl_ResPubl")
@IdClass(ResultPublication_ResultPublicationId.class)
public class ResultPublication_ResultPublication implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6430270707699705446L;
	
	/**
	 * The first result publication.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfResPublId1")
	private ResultPublication resultPublication1;
	
	/**
	 * The second result publication.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfResPublId2")
	private ResultPublication resultPublication2;
	
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
	 * @return the resultPublication1
	 */
	public ResultPublication getResultPublication1() {
		return resultPublication1;
	}

	/**
	 * @param resultPublication1 the resultPublication1 to set
	 */
	public void setResultPublication1(ResultPublication resultPublication1) {
		this.resultPublication1 = resultPublication1;
	}

	/**
	 * @return the resultPublication2
	 */
	public ResultPublication getResultPublication2() {
		return resultPublication2;
	}

	/**
	 * @param resultPublication2 the resultPublication2 to set
	 */
	public void setResultPublication2(ResultPublication resultPublication2) {
		this.resultPublication2 = resultPublication2;
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

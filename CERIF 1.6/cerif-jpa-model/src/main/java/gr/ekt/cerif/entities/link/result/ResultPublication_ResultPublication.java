/**
 * 
 */
package gr.ekt.cerif.entities.link.result;

import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.semantics.Class;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * 
 */
@Entity
@Table(name="cfResPubl_ResPubl", uniqueConstraints=@UniqueConstraint(columnNames={"cfResPublId1", "cfResPublId2", "cfClassId", "cfStartDate", "cfEndDate"}))
public class ResultPublication_ResultPublication implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6430270707699705446L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The first result publication.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfResPublId1")
	private ResultPublication resultPublication1;
	
	/**
	 * The second result publication.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfResPublId2")
	private ResultPublication resultPublication2;
	
	/**
	 * The class.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassId")	
	private Class theClass;
	
	/**
	 * The start date.
	 */
	@NotNull
	@Column (name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@NotNull
	@Column (name="cfEndDate")
	private Date endDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;

	/**
	 * Default Constructor
	 */
	public ResultPublication_ResultPublication() {
		
	}
	
	/**
	 * 
	 * @param resultPublication1
	 * @param resultPublication2
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public ResultPublication_ResultPublication(
			ResultPublication resultPublication1,
			ResultPublication resultPublication2, Class theClass,
			Date startDate, Date endDate, Double fraction) {
		this.resultPublication1 = resultPublication1;
		this.resultPublication2 = resultPublication2;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

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

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResultPublication_ResultPublication [id=" + id
				+ ", resultPublication1=" + resultPublication1
				+ ", resultPublication2=" + resultPublication2 + ", theClass="
				+ theClass + ", startDate=" + startDate + ", endDate="
				+ endDate + ", fraction=" + fraction + "]";
	}

	
}

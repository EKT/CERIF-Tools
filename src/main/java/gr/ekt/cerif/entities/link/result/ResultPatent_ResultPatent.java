/**
 * 
 */
package gr.ekt.cerif.entities.link.result;

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

import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.semantics.Class;

/**
 * 
 */
@Entity
@Table(name="cfResPat_ResPat", uniqueConstraints=@UniqueConstraint(columnNames={"cfResPatId1","cfResPatId2","cfClassId","cfStartDate","cfEndDate"}))
public class ResultPatent_ResultPatent implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8952655199283137820L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The first result patent.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfResPatId1")
	private ResultPatent resultPatent1;
	
	/**
	 * The result patent.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfResPatId2")
	private ResultPatent resultPatent2;
	
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
	public ResultPatent_ResultPatent() {
		
	}
	
	/**
	 * 
	 * @param resultPatent1
	 * @param resultPatent2
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public ResultPatent_ResultPatent(ResultPatent resultPatent1,
			ResultPatent resultPatent2, Class theClass, Date startDate,
			Date endDate, Double fraction) {
		this.resultPatent1 = resultPatent1;
		this.resultPatent2 = resultPatent2;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

	/**
	 * @return the resultPatent1
	 */
	public ResultPatent getResultPatent1() {
		return resultPatent1;
	}

	/**
	 * @param resultPatent1 the resultPatent1 to set
	 */
	public void setResultPatent1(ResultPatent resultPatent1) {
		this.resultPatent1 = resultPatent1;
	}

	/**
	 * @return the resultPatent2
	 */
	public ResultPatent getResultPatent2() {
		return resultPatent2;
	}

	/**
	 * @param resultPatent2 the resultPatent2 to set
	 */
	public void setResultPatent2(ResultPatent resultPatent2) {
		this.resultPatent2 = resultPatent2;
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
	
}

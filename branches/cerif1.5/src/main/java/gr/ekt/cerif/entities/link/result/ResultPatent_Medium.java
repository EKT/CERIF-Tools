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
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.semantics.Class;

/**
 * 
 */
@Entity
@Table(name="cfResPat_Medium", uniqueConstraints=@UniqueConstraint(columnNames={"cfResPatId","cfMediumId","cfClassId","cfStartDate","cfEndDate"}))
public class ResultPatent_Medium implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1194152302754275398L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The result patent.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfResPatId")
	private ResultPatent resultPatent;
	
	/**
	 * The Medium.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfMediumId")
	private Medium medium;
	
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
	public ResultPatent_Medium() {
		
	}
	
	/**
	 * 
	 * @param resultPatent
	 * @param medium
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public ResultPatent_Medium(ResultPatent resultPatent, Medium medium,
			Class theClass, Date startDate, Date endDate, Double fraction) {
		this.resultPatent = resultPatent;
		this.medium = medium;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

	/**
	 * @return the resultPatent
	 */
	public ResultPatent getResultPatent() {
		return resultPatent;
	}

	/**
	 * @param resultPatent the resultPatent to set
	 */
	public void setResultPatent(ResultPatent resultPatent) {
		this.resultPatent = resultPatent;
	}

	/**
	 * @return the medium
	 */
	public Medium getMedium() {
		return medium;
	}

	/**
	 * @param medium the medium to set
	 */
	public void setMedium(Medium medium) {
		this.medium = medium;
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

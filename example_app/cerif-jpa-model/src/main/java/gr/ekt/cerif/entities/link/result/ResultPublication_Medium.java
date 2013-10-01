/**
 * 
 */
package gr.ekt.cerif.entities.link.result;

import java.util.Date;

import javax.persistence.Cacheable;
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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.semantics.Class;

/**
 * 
 */
@Entity
@Table(name="cfResPubl_Medium", uniqueConstraints=@UniqueConstraint(columnNames={"cfResPublId","cfMediumId","cfClassId","cfStartDate","cfEndDate"}))
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ResultPublication_Medium implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1356078703737928542L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The result publication.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfResPublId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private ResultPublication resultPublication;
	
	/**
	 * The Medium.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfMediumId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Medium medium;
	
	/**
	 * The class.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassId")	
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
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
	public ResultPublication_Medium() {
		
	}
	
	/**
	 * 
	 * @param resultPublication
	 * @param medium
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public ResultPublication_Medium(ResultPublication resultPublication,
			Medium medium, Class theClass, Date startDate, Date endDate,
			Double fraction) {
		this.resultPublication = resultPublication;
		this.medium = medium;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

	/**
	 * @return the resultPublication
	 */
	public ResultPublication getResultPublication() {
		return resultPublication;
	}

	/**
	 * @param resultPublication the resultPublication to set
	 */
	public void setResultPublication(ResultPublication resultPublication) {
		this.resultPublication = resultPublication;
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

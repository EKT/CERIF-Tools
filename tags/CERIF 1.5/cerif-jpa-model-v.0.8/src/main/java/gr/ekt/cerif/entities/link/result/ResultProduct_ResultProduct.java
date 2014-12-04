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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.semantics.Class;
/**
 * 
 */
@Entity
@Table(name="cfResProd_ResProd", uniqueConstraints=@UniqueConstraint(columnNames={"cfResProdId1","cfResProdId2","cfClassId","cfStartDate","cfEndDate"}))
public class ResultProduct_ResultProduct implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5930415809369052887L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The first result product.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfResProdId1")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private ResultProduct resultProduct1;
	
	/**
	 * The second result product.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfResProdId2")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private ResultProduct resultProduct2;
	
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
	public ResultProduct_ResultProduct() {
		
	}
	
	/**
	 * 
	 * @param resultProduct1
	 * @param resultProduct2
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public ResultProduct_ResultProduct(ResultProduct resultProduct1,
			ResultProduct resultProduct2, Class theClass, Date startDate,
			Date endDate, Double fraction) {
		this.resultProduct1 = resultProduct1;
		this.resultProduct2 = resultProduct2;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

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

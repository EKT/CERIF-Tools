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

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.semantics.Class;

/**
 * 
 */
@Entity
@Table(name="cfResProd_Srv", uniqueConstraints=@UniqueConstraint(columnNames={"cfResProdId","cfSrvId","cfClassId","cfStartDate","cfEndDate"}))
public class ResultProduct_Service implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2515479365700787518L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The result product.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfResProdId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private ResultProduct resultProduct;
	
	/**
	 * The Service.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfSrvId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Service service;	
	
	/**
	 * The Class.
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
	public ResultProduct_Service() {
		
	}
	
	/**
	 * 
	 * @param resultProduct
	 * @param service
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public ResultProduct_Service(ResultProduct resultProduct, Service service,
			Class theClass, Date startDate, Date endDate, Double fraction) {
		this.resultProduct = resultProduct;
		this.service = service;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

	/**
	 * @return the resultProduct
	 */
	public ResultProduct getResultProduct() {
		return resultProduct;
	}

	/**
	 * @param resultProduct the resultProduct to set
	 */
	public void setResultProduct(ResultProduct resultProduct) {
		this.resultProduct = resultProduct;
	}

	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(Service service) {
		this.service = service;
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

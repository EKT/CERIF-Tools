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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.additional.DublinCore;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.result.ResultPublication_DublinCoreId;

/**
 * 
 */
@Entity
@Table(name="cfResPubl_DC")
@IdClass(ResultPublication_DublinCoreId.class)
public class ResultPublication_DublinCore implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6762889496200401995L;
	
	/**
	 * The result publication.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfResPublId")
	private ResultPublication resultPublication;
	
	/**
	 * The Dublin Core.
	 */
	@Id
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "cfDCId"),
			@JoinColumn(name = "cfDCScheme") })
	private DublinCore dublinCore;
	
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
	 * @return the dublinCore
	 */
	public DublinCore getDublinCore() {
		return dublinCore;
	}

	/**
	 * @param dublinCore the dublinCore to set
	 */
	public void setDublinCore(DublinCore dublinCore) {
		this.dublinCore = dublinCore;
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

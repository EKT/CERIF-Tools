/**
 * 
 */
package gr.ekt.cerif.entities.link.result;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.result.ResultPublication_MetricsId;

/**
 * 
 */
@Entity
@Table(name="cfResPubl_Metrics")
@IdClass(ResultPublication_MetricsId.class)
public class ResultPublication_Metrics implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -782640104740909225L;
	
	/**
	 * The result publication.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfResPublId")
	private ResultPublication resultPublication;
	
	/**
	 * The metrics.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfMetricsId")
	private Metrics metrics;
	
	/**
	 * The class.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassId")	
	private Class theClass;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;
	
	/**
	 * The year.
	 */
	@Column(name="cfYear")
	private Integer year;
	
	/**
	 * The count.
	 */
	@Column(name="cfCount")
	private Double count;

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
	 * @return the metrics
	 */
	public Metrics getMetrics() {
		return metrics;
	}

	/**
	 * @param metrics the metrics to set
	 */
	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
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
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * @return the count
	 */
	public Double getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Double count) {
		this.count = count;
	}

}

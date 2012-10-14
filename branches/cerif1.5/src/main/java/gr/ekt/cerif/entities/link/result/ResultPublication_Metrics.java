/**
 * 
 */
package gr.ekt.cerif.entities.link.result;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.features.semantics.Class;

/**
 * 
 */
@Entity
@Table(name="cfResPubl_Metrics", uniqueConstraints=@UniqueConstraint(columnNames={"cfResPublId","cfMetricsId","cfClassId"}))
public class ResultPublication_Metrics implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -782640104740909225L;
	
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
	private ResultPublication resultPublication;
	
	/**
	 * The metrics.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfMetricsId")
	private Metrics metrics;
	
	/**
	 * The class.
	 */
	@ManyToOne(optional=false)
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
	 * Default Constructor
	 */
	public ResultPublication_Metrics() {
		
	}
	
	/**
	 * 
	 * @param resultPublication
	 * @param metrics
	 * @param theClass
	 * @param fraction
	 * @param year
	 * @param count
	 */
	public ResultPublication_Metrics(ResultPublication resultPublication,
			Metrics metrics, Class theClass, Double fraction, Integer year,
			Double count) {
		this.resultPublication = resultPublication;
		this.metrics = metrics;
		this.theClass = theClass;
		this.fraction = fraction;
		this.year = year;
		this.count = count;
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

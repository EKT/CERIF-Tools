/**
 * 
 */
package gr.ekt.cerif.pk.result;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;

/**
 * 
 *
 */
public class ResultPublication_MetricsId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7130826247393695408L;

	/**
	 * The result publication.
	 */
	private ResultPublication resultPublication;
	
	/**
	 * The metrics.
	 */
	private Metrics metrics;
	
	/**
	 * The class.
	 */
	private Class theClass;

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
	
}

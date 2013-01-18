/**
 * 
 */
package gr.ekt.cerif.pk.result;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;


/**
 * Compound key for associating a result publication with a result product.
 * @see ResultPublication
 * @see ResultProduct
 * 
 */
public class ResultPublication_ResultProductId implements Serializable {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -1426683292397150793L;

	/**
	 * The result publication.
	 */
	private ResultPublication resultPublication;
	
	/**
	 * The result product.
	 */
	private ResultProduct resultProduct;
	
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

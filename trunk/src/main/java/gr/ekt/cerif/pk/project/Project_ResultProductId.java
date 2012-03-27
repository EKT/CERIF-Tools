/**
 * 
 */
package gr.ekt.cerif.pk.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;

/**
 * Compound key for associating a project with a result product.
 * @see Project
 * @see ResultProduct
 * 
 */
public class Project_ResultProductId implements Serializable {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 6533895877925592580L;

	/**
	 * The project.
	 */
	private Project project;
	
	/**
	 * The result product.
	 */
	private ResultProduct resultProduct;
	
	private Class theClass;

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
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

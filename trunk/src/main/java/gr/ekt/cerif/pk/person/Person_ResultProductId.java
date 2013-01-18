/**
 * 
 */
package gr.ekt.cerif.pk.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;

/**
 * Compound key for associating a person with a result product.
 * @see Person
 * @see ResultProduct
 * 
 */
public class Person_ResultProductId implements Serializable {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 4871660936654860472L;

	/**
	 * The person.
	 */
	private Person person;
	
	/**
	 * The result product.
	 */
	private ResultProduct resultProduct;
	
	private Class theClass;

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
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

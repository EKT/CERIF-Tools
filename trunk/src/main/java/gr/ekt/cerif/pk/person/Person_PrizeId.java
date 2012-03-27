/**
 * 
 */
package gr.ekt.cerif.pk.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;

/**
 * 
 */
public class Person_PrizeId implements Serializable {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -5437859342564789890L;

	/**
	 * The person.
	 */
	private Person person;
	
	/**
	 * The prize.
	 */
	private Prize prize;
	
	/**
	 * The class.
	 */
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
	 * @return the prize
	 */
	public Prize getPrize() {
		return prize;
	}

	/**
	 * @param prize the prize to set
	 */
	public void setPrize(Prize prize) {
		this.prize = prize;
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

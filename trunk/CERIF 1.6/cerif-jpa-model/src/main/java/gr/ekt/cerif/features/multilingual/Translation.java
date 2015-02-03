/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import java.io.Serializable;

/**
 * Allowed values for the translation field. According to its origin, the translation can be one of: O (original), H (human), M (machine)
 * 
 */
public enum Translation implements Serializable {
	
	/**
	 * Original.
	 */
	o,
	
	/**
	 * Human.
	 */
	h,
	
	/**
	 * Machine.
	 */
	m;
	
	/**
	 * Returns the original translation.
	 * @return a translation.
	 */
	public Translation getOriginal() {
		return o;
	}
	
	/**
	 * Returns the human translation.
	 * @return a translation.
	 */
	public Translation getHuman() {
		return h;
	}
	
	/**
	 * Returns the machine translation.
	 * @return a translation.
	 */
	public Translation getMachine() {
		return m;
	}

}

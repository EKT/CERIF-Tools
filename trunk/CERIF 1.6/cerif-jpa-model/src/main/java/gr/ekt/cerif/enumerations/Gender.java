package gr.ekt.cerif.enumerations;

import java.io.Serializable;

/**
 * Allowed values for the Gender field. According to its origin, the gender can be one of: m (Male), f (Female), u (Unknown)
 * 
 */
public enum Gender implements Serializable {

	/**
	 * Male.
	 */
	m,
	
	/**
	 * Female.
	 */
	f,
	
	/**
	 * Unknown
	 */
	u;
	
	/**
	 * Returns the male gender.
	 * @return a gender.
	 */
	public Gender getMale() {
		return m;
	}
	
	/**
	 * Returns the female gender.
	 * @return a gender.
	 */
	public Gender getFemale() {
		return f;
	}
	
	/**
	 * Returns the unknown gender.
	 * @return a gender.
	 */
	public Gender getUnknown() {
		return u;
	}
	
}

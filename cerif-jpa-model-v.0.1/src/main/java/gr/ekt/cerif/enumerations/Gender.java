package gr.ekt.cerif.enumerations;

import java.io.Serializable;

/**
 * Allowed values for the Gender field. According to its origin, the gender can be one of: m (Male), f (Female), u (Unknown)
 * 
 */
public enum Gender implements Serializable {

	MALE, //Male
	FEMALE, //Female
	UNKNOWN; //Unknown
}

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
	
	ORIGINAL, //ORIGINAL
	HUMAN, //HUMAN
	MACHINE; //MACHINE
}

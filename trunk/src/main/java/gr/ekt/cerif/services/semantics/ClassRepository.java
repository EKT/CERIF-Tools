/**
 * 
 */
package gr.ekt.cerif.services.semantics;

import java.util.List;

import gr.ekt.cerif.features.semantics.Class;


/**
 * A repository for classification classes.
 * 
 */
public interface ClassRepository {

	/**
	 * Saves the provided class.
	 * @param feature
	 */
	void save(Class feature);

	/**
	 * Saves the provided list of classes.
	 * @param featureList
	 */
	void save(List<Class> featureList);

}

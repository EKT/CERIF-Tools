/**
 * 
 */
package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

/**
 * A repository for classification schemes.
 * 
 */
public interface ClassSchemeRepository {

	/**
	 * Saves the provided scheme
	 * @param scheme
	 */
	void save(ClassScheme scheme);

	/**
	 * Saves the provided list of schemes
	 * @param schemeList
	 */
	void save(List<ClassScheme> schemeList);
	
}

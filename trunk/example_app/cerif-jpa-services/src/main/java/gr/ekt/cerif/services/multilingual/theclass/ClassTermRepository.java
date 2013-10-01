
package gr.ekt.cerif.services.multilingual.theclass;

import gr.ekt.cerif.features.multilingual.ClassTerm;
import gr.ekt.cerif.features.semantics.Class;



/**
 * A repository for ClassTerm.
 * 
 */
public interface ClassTermRepository {
	
	ClassTerm findByTerm(String term);
	
	ClassTerm findByTheClass(Class existInfras);
	
	public void delete(ClassTerm entity); 
	
	public void delete(Iterable<ClassTerm> entities); 

	public Iterable<ClassTerm> save(Iterable<ClassTerm> entities); 
	
	public ClassTerm save(ClassTerm entity);
}

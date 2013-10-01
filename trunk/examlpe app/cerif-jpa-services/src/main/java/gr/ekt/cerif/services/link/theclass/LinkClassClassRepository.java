package gr.ekt.cerif.services.link.theclass;

import gr.ekt.cerif.entities.link.Class_Class;
import gr.ekt.cerif.features.semantics.Class;

public interface LinkClassClassRepository {
	
	Class_Class findBytheClass1AndtheClass2(Class theClass1, Class theClass2);

	public void delete(Class_Class entity); 
	
	public void delete(Iterable<Class_Class> entities); 

	public Iterable<Class_Class> save(Iterable<Class_Class> entities); 
	
	public Class_Class save(Class_Class entity);
}

package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreSubject;

/**
 * A repository for dublin core subject.
 * 
 */
@Deprecated
public interface DublinCoreSubjectRepository {

	public void delete(DublinCoreSubject entity); 
	
	public void delete(Iterable<DublinCoreSubject> entities); 

	public Iterable<DublinCoreSubject> save(Iterable<DublinCoreSubject> entities); 
	
	public DublinCoreSubject save(DublinCoreSubject entity);
}


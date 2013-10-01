package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreRightsHolder;

public interface DublinCoreRightsHolderRepository {
	
	public void delete(DublinCoreRightsHolder entity); 
	
	public void delete(Iterable<DublinCoreRightsHolder> entities); 

	public Iterable<DublinCoreRightsHolder> save(Iterable<DublinCoreRightsHolder> entities); 
	
	public DublinCoreRightsHolder save(DublinCoreRightsHolder entity);

}

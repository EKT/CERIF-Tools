package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreRelation;

/**
 * A repository for dublin core relation.
 * 
 */
public interface DublinCoreRelationRepository {

	public void delete(DublinCoreRelation entity); 
	
	public void delete(Iterable<DublinCoreRelation> entities); 

	public Iterable<DublinCoreRelation> save(Iterable<DublinCoreRelation> entities); 
	
	public DublinCoreRelation save(DublinCoreRelation entity);
}


package gr.ekt.cerif.services.link.funding;

import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

/**
 * A repository for links between fundings and classes.
 * 
 */
public interface LinkFundingClassRepository {
	
	List<Funding_Class> findByTheClass(Class theClass);
	
	List<Funding_Class> findByTheClassAndFunding(Class theClass, Funding funding);
	
	public Funding_Class save(Funding_Class entity);
	
	public Iterable<? extends Funding_Class> save(Iterable<? extends Funding_Class> entities);
	
	public void delete(Funding_Class entity);
	
	public void delete(Iterable<Funding_Class> entities);
	
}

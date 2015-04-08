package gr.ekt.cerif.services.link.curriculumvitae;

import java.util.List;

import gr.ekt.cerif.entities.link.CurriculumVitae_Class;
import gr.ekt.cerif.entities.second.CurriculumVitae;
import gr.ekt.cerif.features.semantics.Class;

/**
 * A repository for links between cvs and classes.
 * 
 */
public interface LinkCurriculumVitaeClassRepository {

	public void delete(CurriculumVitae_Class entity); 
	
	public void delete(Iterable<CurriculumVitae_Class> entities); 

	public Iterable<CurriculumVitae_Class> save(Iterable<CurriculumVitae_Class> entities); 
	
	public CurriculumVitae_Class save(CurriculumVitae_Class entity);
	
	List<CurriculumVitae_Class> findByCurriculumVitae(CurriculumVitae curriculumVitae);
	
	List<CurriculumVitae_Class> findBytheClass(Class theClass);
	
}

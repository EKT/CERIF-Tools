package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Classification;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for links between organisation units and postal addresses.
 * 
 */
public interface LinkProjectClassRepository extends CrudRepository<Project_Classification, Long>{
		
	List<Project_Classification> findByTheClass(Class theClass);
	
	Project_Classification findByProjectAndTheClass(Project project, Class theClass); 
	
}

package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Class;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for links between organisation units and postal addresses.
 * 
 */
public interface LinkProjectClassCrudRepository extends CrudRepository<Project_Class, Long>{
		
	List<Project_Class> findByTheClass(Class theClass);
	
	List<Project_Class> findByProjectAndTheClass(Project project, Class theClass); 
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("Select pc from gr.ekt.cerif.entities.link.project.Project_Class pc where pc.project=?1 and pc.theClass=?2")
	List<Project_Class> findByProjectAndTheClassList(Project project, Class theClass); 

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("Select pc from gr.ekt.cerif.entities.link.project.Project_Class pc join pc.theClass cl where cl.uri=?1")
	List<Project_Class> findByTheClassUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("Select pc from gr.ekt.cerif.entities.link.project.Project_Class pc join pc.theClass cl where pc.project=?1 and cl.scheme=?2 and pc.theClass=?3")
	Project_Class findByProjectAndClassschemeAndClass(Project project,ClassScheme classScheme,Class theClass);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("Select pc from gr.ekt.cerif.entities.link.project.Project_Class pc join pc.theClass cl where pc.project=?1 and cl.scheme=?2")
	Project_Class findByProjectAndClassScheme(Project project, ClassScheme classScheme);
	
	List<Project_Class> findByProject(Project project);
}

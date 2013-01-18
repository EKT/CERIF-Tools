package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Class;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

public interface LinkProjectClassRepository {

	void delete(Project_Class entity);
	
	Project_Class save(Project_Class entity);
	
	List<Project_Class> save(List<Project_Class> entityList);
	
	Project_Class findOne(Long id);
	
	List<Project_Class> findByTheClass(Class theClass);
	
	Project_Class findByProjectAndTheClass(Project project, Class theClass); 
	
	List<Project_Class> findByProjectAndTheClassList(Project project, Class theClass); 

	List<Project_Class> findByTheClassUri(String uri);
	
	Project_Class findByProjectAndClassschemeAndClass(Project project,ClassScheme classScheme,Class theClass);

	Project_Class findByProjectAndClassScheme(Project project, ClassScheme classScheme);
}

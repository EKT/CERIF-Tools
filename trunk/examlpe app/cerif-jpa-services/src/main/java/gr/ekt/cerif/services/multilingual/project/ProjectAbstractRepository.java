package gr.ekt.cerif.services.multilingual.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;

import java.util.List;

public interface ProjectAbstractRepository {
	
	public List<ProjectAbstract> findByProject(Project project);
	
	public void delete(ProjectAbstract entity); 
	
	public void delete(Iterable<ProjectAbstract> entities); 

	public Iterable<ProjectAbstract> save(Iterable<ProjectAbstract> entities); 
	
	public ProjectAbstract save(ProjectAbstract entity);

}

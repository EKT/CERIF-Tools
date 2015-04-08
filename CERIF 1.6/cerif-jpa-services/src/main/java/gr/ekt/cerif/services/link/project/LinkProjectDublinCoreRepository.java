package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_DublinCore;

/**
 * A repository for links between projects and DublinCores.
 * 
 */
public interface LinkProjectDublinCoreRepository {

	public void delete(Project_DublinCore entity); 
	
	public void delete(Iterable<Project_DublinCore> entities); 

	public Iterable<Project_DublinCore> save(Iterable<Project_DublinCore> entities); 
	
	public Project_DublinCore save(Project_DublinCore entity);
	
	List<Project_DublinCore> findByProject(Project project);
	
}

package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

/**
 * A repository for links between projects and measurements.
 * 
 */
public interface LinkProjectMeasurementRepository {

	public void delete(Project_Measurement entity); 
	
	public void delete(Iterable<Project_Measurement> entities); 

	public Iterable<Project_Measurement> save(Iterable<Project_Measurement> entities); 
	
	public Project_Measurement save(Project_Measurement entity);
	
	List<Project_Measurement> findByProject(Project project);
	
	List<Project_Measurement> findByMeasurement(Measurement measurement);
	
	
}

package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkProjectMeasurementCrudRepository extends CrudRepository<Project_Measurement, Long> {
	
	List<Project_Measurement> findByProject(Project project);
	
	List<Project_Measurement> findByMeasurement(Measurement measurement);

}

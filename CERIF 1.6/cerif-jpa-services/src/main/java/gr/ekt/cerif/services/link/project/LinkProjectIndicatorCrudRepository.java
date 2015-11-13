package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Indicator;
import gr.ekt.cerif.entities.second.Indicator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkProjectIndicatorCrudRepository extends CrudRepository<Project_Indicator, Long> {
	
	public List<Project_Indicator> findByProject(Project project);
	
	public List<Project_Indicator> findByIndicator(Indicator indicator);

}

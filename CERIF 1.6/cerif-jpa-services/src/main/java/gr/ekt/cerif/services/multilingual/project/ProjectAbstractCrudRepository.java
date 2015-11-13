package gr.ekt.cerif.services.multilingual.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProjectAbstractCrudRepository extends CrudRepository<ProjectAbstract, Long> {

	public List<ProjectAbstract> findByProject(Project project);
	
}

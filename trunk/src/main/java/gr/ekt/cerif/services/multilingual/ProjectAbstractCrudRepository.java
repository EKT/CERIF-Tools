package gr.ekt.cerif.services.multilingual;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;

import org.springframework.data.repository.CrudRepository;

public interface ProjectAbstractCrudRepository extends CrudRepository<ProjectAbstract, Long> {

	public List<ProjectAbstract> findByProject(Project project);
	
}

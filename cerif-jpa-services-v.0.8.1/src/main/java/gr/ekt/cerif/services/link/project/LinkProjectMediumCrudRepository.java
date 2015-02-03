package gr.ekt.cerif.services.link.project;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Medium;
import gr.ekt.cerif.entities.second.Medium;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkProjectMediumCrudRepository extends CrudRepository<Project_Medium, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Project_Medium> findByProject(Project project);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Project_Medium> findByMedium(Medium medium);

}

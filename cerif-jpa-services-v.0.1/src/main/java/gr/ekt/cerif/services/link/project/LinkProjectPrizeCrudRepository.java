package gr.ekt.cerif.services.link.project;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Prize;
import gr.ekt.cerif.entities.second.Prize;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkProjectPrizeCrudRepository extends CrudRepository<Project_Prize, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Project_Prize> findByProject(Project project);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Project_Prize> findByPrize(Prize Prize);

}

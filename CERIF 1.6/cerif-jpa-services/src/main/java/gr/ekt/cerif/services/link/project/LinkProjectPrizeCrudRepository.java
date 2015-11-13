package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Prize;
import gr.ekt.cerif.entities.second.Prize;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkProjectPrizeCrudRepository extends CrudRepository<Project_Prize, Long> {
	
	public List<Project_Prize> findByProject(Project project);
	
	public List<Project_Prize> findByPrize(Prize Prize);

}

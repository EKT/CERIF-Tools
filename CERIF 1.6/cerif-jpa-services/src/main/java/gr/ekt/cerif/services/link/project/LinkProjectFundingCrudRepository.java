package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkProjectFundingCrudRepository  extends CrudRepository<Project_Funding, Long> {

	public List<Project_Funding> findByProject(Project project);
	
	public List<Project_Funding> findByFunding(Funding funding);
	
}

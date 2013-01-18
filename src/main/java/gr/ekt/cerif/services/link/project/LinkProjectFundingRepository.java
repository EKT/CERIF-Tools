/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import java.util.List;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.second.Funding;


/**
 * A repository for links between projects and fundings.
 * 
 */
public interface LinkProjectFundingRepository {

	public List<Project_Funding> findByProject(Project project);
	
	public List<Project_Funding> findByFunding(Funding funding);
	
	public Project_Funding save(Project_Funding entity);
	
	public Iterable<? extends Project_Funding> save(Iterable<? extends Project_Funding> entities);
	
	public void delete(Project_Funding entity);
	
}

/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;

import java.util.List;

/**
 * A repository for links between projects and ResultPublications.
 * 
 */
public interface LinkProjectResultPublicationRepository {

	public Project_ResultPublication save(Project_ResultPublication entity);
	
	public Iterable<Project_ResultPublication> save(Iterable<Project_ResultPublication> entityList);

	public void delete(Project_ResultPublication entity);
	
	public void delete(Iterable<Project_ResultPublication> entityList);
	
	public Project_ResultPublication queryProjResPubByResPubId(Long respubId, Long projId);	
	
	public Project_ResultPublication queryProjResPubById(Long projrespubId);
	
	public List<Project_ResultPublication> queryProjResPubByResPubId(Long respubId);
	
	public List<Long> queryProjIdsResPubId(Long respubId, String ClassUri);
	
	List<Project_ResultPublication> findByProject(Project project);
	
	List<Project_ResultPublication> findByResultPublication(ResultPublication resultPublication);
	
}

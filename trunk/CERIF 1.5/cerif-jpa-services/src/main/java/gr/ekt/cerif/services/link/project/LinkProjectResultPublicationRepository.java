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
	
	public List<Project_ResultPublication> findByResPublIdAndProjectId(Long respubId, Long projId);
	
	public Project_ResultPublication findById(Long id);
	
	public List<Project_ResultPublication> findByResPublId(Long respubId);
	
	public List<Long> findProjectIdsByResPublIdAndClassUri(Long respubId, String classUri);
	
	public List<Project_ResultPublication> findByResPublIdAndClassUri(Long respubId, String classUri);
	
	List<Project_ResultPublication> findByProject(Project project);
	
	List<Project_ResultPublication> findByResultPublication(ResultPublication resultPublication);
		
	public Project_ResultPublication findByResPublIdAndClassUriAndProjectId(Long respubId, String classUri, Long projId); 
	
	public Project_ResultPublication findByProjectIdAndResultPublicationId(Long prId, Long resId);
	
}

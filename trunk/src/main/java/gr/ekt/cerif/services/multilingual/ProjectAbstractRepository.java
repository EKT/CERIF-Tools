package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;

import java.util.List;

public interface ProjectAbstractRepository {
	
	public List<ProjectAbstract> findByProject(Project project);
	
	ProjectAbstract save(ProjectAbstract entity);
	
	Iterable<? extends ProjectAbstract> save(Iterable<? extends ProjectAbstract> entities);
	
	void delete(ProjectAbstract entity);
	
	void delete(List<ProjectAbstract> entities);

}

package gr.ekt.exampleapp.middleware;

import gr.ekt.exampleapp.transferobjects.ProjectView;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectMiddleRepositoryImpl implements ProjectMiddleRepository {

	private static final Logger log = LoggerFactory.getLogger(ProjectMiddleRepositoryImpl.class);
	
	@Autowired
	private ProjectCrudMiddleRepository projectCrudMiddleRepository;

	public List<ProjectView> findAllProjects() {
		return projectCrudMiddleRepository.findAllProjects();
	}

	public List<ProjectView> findProjectByOrganisationIdAndClassScheme(Long id,
			String classSchemeUUID) {
		return projectCrudMiddleRepository.findProjectByOrganisationIdAndClassScheme(id, classSchemeUUID);
	}
	
	public ProjectView findProjectById(Long id) {
		return projectCrudMiddleRepository.findProjectById(id);
	}

	
}

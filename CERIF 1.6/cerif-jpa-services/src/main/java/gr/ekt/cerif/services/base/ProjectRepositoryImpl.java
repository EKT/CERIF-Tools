package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.enumerations.semantics.ClassEnum;
import gr.ekt.cerif.services.second.SecondPersistenceService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProjectRepositoryImpl implements ProjectRepository {

	private static final Logger log = LoggerFactory.getLogger(ProjectRepositoryImpl.class);
	
	@Autowired
	private ProjectCrudRepository projectCrudRepository;
	
	/**
	 * Service for second level entities.
	 */
	@Autowired
	private SecondPersistenceService secondService;
	
	@Override
	@Transactional
	public void delete(Project entity) {		
		projectCrudRepository.delete(entity);
	}

	@Transactional
	public Iterable<Project> save(Iterable<Project> entities) {
		return projectCrudRepository.save(entities);
	}

	@Transactional
	public Project save(Project entity) {
		return projectCrudRepository.save(entity);
	}

	@Transactional
	public void delete(Iterable<Project> entities) {
		projectCrudRepository.delete(entities);		
	}

	@Override
	public Project findById(Long id) {
		return projectCrudRepository.findById(id);
	}

	@Override
	public List<Project> findByUri(String uri) {
		return projectCrudRepository.findByUri(uri);
	}

	@Override
	public Page<Project> findAll(Pageable page) {
		return projectCrudRepository.findAll(page);
	}

	@Override
	public Iterable<Project> findAll() {
		return projectCrudRepository.findAll();
	}

	@Override
	public Project findByUuid(String uuid) {
		return projectCrudRepository.findByUuid(uuid);
	}
	
	/*
	 * (non-Javadoc)
	 * @see gr.ekt.cerif.services.base.ProjectRepository#findByUuidFetchMultilingual(java.lang.String)
	 */
	@Override
	public Project findByUuidFetchMultilingual(String uuid) {
		return projectCrudRepository.findByUuidFetchMultilingual(uuid);
	}

	/*
	 * (non-Javadoc)
	 * @see gr.ekt.cerif.services.base.ProjectRepository#findByUuidFetchMultilingualAndFederatedIds(java.lang.String)
	 */
	@Override
	public Project findByUuidFetchMultilingualAndFederatedIds(String uuid) {
		Project project = findByUuidFetchMultilingual(uuid);
		if (project != null) {
			project.setFederatedIdentifiers(secondService.getFederatedIdentifiersForEntity(ClassEnum.PROJECT.getUuid(), project.getId()));
		}
		return project;
	}
	
}

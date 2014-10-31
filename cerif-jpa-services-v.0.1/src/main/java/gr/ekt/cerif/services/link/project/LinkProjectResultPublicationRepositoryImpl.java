package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.services.base.ProjectRepository;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkProjectResultPublicationRepositoryImpl implements LinkProjectResultPublicationRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProjectResultPublicationRepositoryImpl.class);

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private LinkProjectResultPublicationCrudRepository linkProjectResultPublicationCrudRepository;
	
	@Autowired
	private ClassRepository classRepository;
	

	@Transactional
	public Project_ResultPublication save(Project_ResultPublication entity) {
		return linkProjectResultPublicationCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<Project_ResultPublication> save(Iterable<Project_ResultPublication> entityList) {
		return linkProjectResultPublicationCrudRepository.save(entityList);
	}
	
	@Transactional
	public void delete(Project_ResultPublication entity) {
		linkProjectResultPublicationCrudRepository.delete(entity);
	}
	
	@Transactional
	public void delete(Iterable<Project_ResultPublication> entityList) {
		linkProjectResultPublicationCrudRepository.delete(entityList);
	}
	
	@Override
	public List<Project_ResultPublication> findByProject(Project project) {
		return linkProjectResultPublicationCrudRepository.findByProject(project);
	}

	@Override
	public List<Project_ResultPublication> findByResultPublication(ResultPublication resultPublication) {
		return linkProjectResultPublicationCrudRepository.findByResultPublication(resultPublication);
	}

	@Override
	public List<Project_ResultPublication> findByResPublIdAndProjectId(Long respubId, Long projId) {
		return linkProjectResultPublicationCrudRepository.findByResPublIdAndProjectId(respubId, projId);
	}

	@Override
	public Project_ResultPublication findById(Long id) {
		return linkProjectResultPublicationCrudRepository.findById(id);
	}

	@Override
	public List<Long> findProjectIdsByResPublIdAndClassUri(Long respubId, String classUri) {
		return linkProjectResultPublicationCrudRepository.findProjectIdsByResPublIdAndClassUri(respubId, classUri);
	}

	@Override
	public List<Project_ResultPublication> findByResPublId(Long respubId) {
		return linkProjectResultPublicationCrudRepository.findByResPublId(respubId);
	}
	
	@Override
	public List<Project_ResultPublication> findByResPublIdAndClassUri(Long respubId, String classUri) {
		return linkProjectResultPublicationCrudRepository.findByResPublIdAndClassUri(respubId, classUri);
	}

	@Override
	public Project_ResultPublication findByResPublIdAndClassUriAndProjectId(Long respubId, String classUri, Long projId) {
		return linkProjectResultPublicationCrudRepository.findByResPublIdAndClassUriAndProjectId(respubId, classUri, projId);
	}

	@Override
	public Project_ResultPublication findByProjectIdAndResultPublicationId(Long prId, Long resId) {
		return linkProjectResultPublicationCrudRepository.findByProjectIdAndResultPublicationId(prId, resId);
	}
}

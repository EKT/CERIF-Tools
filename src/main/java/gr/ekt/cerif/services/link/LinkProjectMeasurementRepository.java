package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.project.Project_Measurement;
import gr.ekt.cerif.services.second.MeasurementRepository;
import gr.ekt.cerif.services.base.ProjectRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between projects and measurements.
 * 
 */
@Component
public class LinkProjectMeasurementRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private MeasurementRepository measurementRepository;
	
	@Transactional
	public void save(Project_Measurement entity) {
		if (entity.getProject() == null || entity.getMeasurement() == null) {
			throw new IllegalArgumentException("Please provide both a project and a Measurement.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getMeasurement().getId() == null) {
			measurementRepository.save(entity.getMeasurement());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_Measurement> entityList) {
		for (Project_Measurement entity : entityList) {
			save(entity);
		}
	}
	
}

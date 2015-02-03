package gr.ekt.cerif.services.link.project;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

@Component
public class LinkProjectMeasurementRepositoryImpl implements
		LinkProjectMeasurementRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProjectMeasurementRepositoryImpl.class);
	
	@Autowired
	private LinkProjectMeasurementCrudRepository linkProjectMeasurementCrudRepository;

	@Override
	public void delete(Project_Measurement entity) {
		linkProjectMeasurementCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Project_Measurement> entities) {
		linkProjectMeasurementCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Project_Measurement> save(
			Iterable<Project_Measurement> entities) {
		return linkProjectMeasurementCrudRepository.save(entities);
	}

	@Override
	public Project_Measurement save(Project_Measurement entity) { 
		return linkProjectMeasurementCrudRepository.save(entity);
	}

	@Override
	public List<Project_Measurement> findByProject(Project project) {
		return linkProjectMeasurementCrudRepository.findByProject(project);
	}

	@Override
	public List<Project_Measurement> findByMeasurement(Measurement measurement) {
		return linkProjectMeasurementCrudRepository.findByMeasurement(measurement);
	}

}

package gr.ekt.cerif.services.link.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.project.Project_Measurement;

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

}

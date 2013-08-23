package gr.ekt.cerif.services.link.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.project.Project_Facility;

@Component
public class LinkProjectFacilityRepositoryImpl implements
		LinkProjectFacilityRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProjectFacilityRepositoryImpl.class);
	
	@Autowired
	private LinkProjectFacilityCrudRepository linkProjectFacilityCrudRepository;

	@Override
	public void delete(Project_Facility entity) {
		linkProjectFacilityCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Project_Facility> entities) {
		linkProjectFacilityCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Project_Facility> save(Iterable<Project_Facility> entities) {
		return linkProjectFacilityCrudRepository.save(entities);
	}

	@Override
	public Project_Facility save(Project_Facility entity) {
		return linkProjectFacilityCrudRepository.save(entity);
	}

}

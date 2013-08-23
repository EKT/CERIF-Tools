package gr.ekt.cerif.services.link.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.project.Project_Equipment;

@Component
public class LinkProjectEquipmentRepositoryImpl implements
		LinkProjectEquipmentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProjectEquipmentRepositoryImpl.class);
	
	@Autowired
	private LinkProjectEquipmentCrudRepository linkProjectEquipmentCrudRepository;

	@Override
	public void delete(Project_Equipment entity) {
		linkProjectEquipmentCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Project_Equipment> entities) {
		linkProjectEquipmentCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Project_Equipment> save(Iterable<Project_Equipment> entities) {
		return linkProjectEquipmentCrudRepository.save(entities);
	}

	@Override
	public Project_Equipment save(Project_Equipment entity) {
		return linkProjectEquipmentCrudRepository.save(entity);
	}

}

package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPublication_Equipment;

@Component
public class LinkResultPublicationEquipmentRepositoryImpl implements
		LinkResultPublicationEquipmentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPublicationEquipmentRepositoryImpl.class);
	
	@Autowired
	private LinkResultPublicationEquipmentCrudRepository linkResultPublicationEquipmentCrudRepository;

	@Override
	public void delete(ResultPublication_Equipment entity) {
		linkResultPublicationEquipmentCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublication_Equipment> entities) {
		linkResultPublicationEquipmentCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublication_Equipment> save(
			Iterable<ResultPublication_Equipment> entities) {
		return linkResultPublicationEquipmentCrudRepository.save(entities);
	}

	@Override
	public ResultPublication_Equipment save(ResultPublication_Equipment entity) {
		return linkResultPublicationEquipmentCrudRepository.save(entity);
	}

}

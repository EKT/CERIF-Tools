package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.result.ResultPublication_Equipment;
import gr.ekt.cerif.entities.result.ResultPublication;

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

	@Override
	public List<ResultPublication_Equipment> findByResultPublication(
			ResultPublication resultPublication) {
		return linkResultPublicationEquipmentCrudRepository.findByResultPublication(resultPublication);
	}

	@Override
	public List<ResultPublication_Equipment> findByEquipment(Equipment equipment) {
		return linkResultPublicationEquipmentCrudRepository.findByEquipment(equipment);
	}

}

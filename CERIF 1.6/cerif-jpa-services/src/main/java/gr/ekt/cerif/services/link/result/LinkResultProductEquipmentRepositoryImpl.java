package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.result.ResultProduct_Equipment;
import gr.ekt.cerif.entities.result.ResultProduct;

@Component
public class LinkResultProductEquipmentRepositoryImpl implements
		LinkResultProductEquipmentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultProductEquipmentRepositoryImpl.class);
	
	@Autowired
	private LinkResultProductEquipmentCrudRepository linkResultProductEquipmentCrudRepository;

	@Override
	public void delete(ResultProduct_Equipment entity) {
		linkResultProductEquipmentCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProduct_Equipment> entities) {
		linkResultProductEquipmentCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProduct_Equipment> save(
			Iterable<ResultProduct_Equipment> entities) {
		return linkResultProductEquipmentCrudRepository.save(entities);
	}

	@Override
	public ResultProduct_Equipment save(ResultProduct_Equipment entity) {
		return linkResultProductEquipmentCrudRepository.save(entity);
	}

	@Override
	public List<ResultProduct_Equipment> findByEquipment(Equipment equipment) {
		return linkResultProductEquipmentCrudRepository.findByEquipment(equipment);
	}

	@Override
	public List<ResultProduct_Equipment> findByResultProduct(
			ResultProduct resultProduct) {
		return linkResultProductEquipmentCrudRepository.findByResultProduct(resultProduct);
	}

}

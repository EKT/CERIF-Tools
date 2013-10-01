package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPatent_Equipment;

@Component
public class LinkResultPatentEquipmentRepositoryImpl implements
		LinkResultPatentEquipmentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPatentEquipmentRepositoryImpl.class);
	
	@Autowired
	private LinkResultPatentEquipmentCrudRepository linkResultPatentEquipmentCrudRepository;

	@Override
	public void delete(ResultPatent_Equipment entity) {
		linkResultPatentEquipmentCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPatent_Equipment> entities) {
		linkResultPatentEquipmentCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPatent_Equipment> save(
			Iterable<ResultPatent_Equipment> entities) {
		return linkResultPatentEquipmentCrudRepository.save(entities);
	}

	@Override
	public ResultPatent_Equipment save(ResultPatent_Equipment entity) {
		return linkResultPatentEquipmentCrudRepository.save(entity);
	}

}

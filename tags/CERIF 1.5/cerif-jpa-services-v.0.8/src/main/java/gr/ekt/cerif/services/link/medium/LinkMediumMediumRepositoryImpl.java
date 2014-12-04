package gr.ekt.cerif.services.link.medium;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Medium_Medium;
import gr.ekt.cerif.entities.second.Medium;

@Component
public class LinkMediumMediumRepositoryImpl implements
		LinkMediumMediumRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkMediumMediumRepositoryImpl.class);
	
	@Autowired
	private LinkMediumMediumCrudRepository linkMediumMediumCrudRepository;

	@Override
	public void delete(Medium_Medium entity) {
		linkMediumMediumCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Medium_Medium> entities) {
		linkMediumMediumCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Medium_Medium> save(Iterable<Medium_Medium> entities) {
		return linkMediumMediumCrudRepository.save(entities);
	}

	@Override
	public Medium_Medium save(Medium_Medium entity) {
		return linkMediumMediumCrudRepository.save(entity);
	}

	@Override
	public List<Medium_Medium> findByMedium1(Medium medium) {
		return linkMediumMediumCrudRepository.findByMedium1(medium);
	}

	@Override
	public List<Medium_Medium> findByMedium2(Medium medium) {
		return linkMediumMediumCrudRepository.findByMedium2(medium);
	}

}

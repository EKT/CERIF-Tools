package gr.ekt.cerif.services.link.citation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Citation_Class;

@Component
public class LinkCitationClassRepositoryImpl implements
		LinkCitationClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkCitationClassRepositoryImpl.class);
	
	@Autowired
	private LinkCitationClassCrudRepository linkCitationClassCrudRepository;

	@Override
	public void delete(Citation_Class entity) {
		linkCitationClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Citation_Class> entities) {
		linkCitationClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Citation_Class> save(Iterable<Citation_Class> entities) {
		return linkCitationClassCrudRepository.save(entities);
	}

	@Override
	public Citation_Class save(Citation_Class entity) {
		return linkCitationClassCrudRepository.save(entity);
	}

}

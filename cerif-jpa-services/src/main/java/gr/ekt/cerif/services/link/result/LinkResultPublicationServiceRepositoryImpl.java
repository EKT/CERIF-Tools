package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPublication_Service;

@Component
public class LinkResultPublicationServiceRepositoryImpl implements
		LinkResultPublicationServiceRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPublicationServiceRepositoryImpl.class);
	
	@Autowired
	private LinkResultPublicationServiceCrudRepository linkResultPublicationServiceCrudRepository;

	@Override
	public void delete(ResultPublication_Service entity) {
		linkResultPublicationServiceCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublication_Service> entities) {
		linkResultPublicationServiceCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublication_Service> save(
			Iterable<ResultPublication_Service> entities) {
		return linkResultPublicationServiceCrudRepository.save(entities);
	}

	@Override
	public ResultPublication_Service save(ResultPublication_Service entity) {
		return linkResultPublicationServiceCrudRepository.save(entity);
	}

}

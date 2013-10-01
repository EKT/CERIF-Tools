package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPublication_Citation;

@Component
public class LinkResultPublicationCitationRepositoryImpl implements
		LinkResultPublicationCitationRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPublicationCitationRepositoryImpl.class);
	
	@Autowired
	private LinkResultPublicationCitationCrudRepository linkResultPublicationCitationCrudRepository;

	@Override
	public void delete(ResultPublication_Citation entity) {
		linkResultPublicationCitationCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublication_Citation> entities) {
		linkResultPublicationCitationCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublication_Citation> save(
			Iterable<ResultPublication_Citation> entities) {
		return linkResultPublicationCitationCrudRepository.save(entities);
	}

	@Override
	public ResultPublication_Citation save(ResultPublication_Citation entity) {
		return linkResultPublicationCitationCrudRepository.save(entity);
	}

}

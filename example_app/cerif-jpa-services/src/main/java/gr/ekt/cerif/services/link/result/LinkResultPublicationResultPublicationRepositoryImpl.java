package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPublication;

@Component
public class LinkResultPublicationResultPublicationRepositoryImpl implements
		LinkResultPublicationResultPublicationRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPublicationResultPublicationRepositoryImpl.class);
	
	@Autowired
	private LinkResultPublicationResultPublicationCrudRepository linkResultPublicationResultPublicationCrudRepository;

	@Override
	public void delete(ResultPublication_ResultPublication entity) {
		linkResultPublicationResultPublicationCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublication_ResultPublication> entities) {
		linkResultPublicationResultPublicationCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublication_ResultPublication> save(
			Iterable<ResultPublication_ResultPublication> entities) {
		return linkResultPublicationResultPublicationCrudRepository.save(entities);
	}

	@Override
	public ResultPublication_ResultPublication save(
			ResultPublication_ResultPublication entity) {
		return linkResultPublicationResultPublicationCrudRepository.save(entity);
	}

}

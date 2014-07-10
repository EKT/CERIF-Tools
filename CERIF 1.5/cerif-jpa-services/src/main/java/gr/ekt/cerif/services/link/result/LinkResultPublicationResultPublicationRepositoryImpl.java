package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;

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

	@Override
	public List<ResultPublication_ResultPublication> findByResultPublication1(
			ResultPublication resultPublication) {
		return linkResultPublicationResultPublicationCrudRepository.findByResultPublication1(resultPublication);
	}

	@Override
	public List<ResultPublication_ResultPublication> findByResultPublication2(
			ResultPublication resultPublication) {
		return linkResultPublicationResultPublicationCrudRepository.findByResultPublication2(resultPublication);
	}

}

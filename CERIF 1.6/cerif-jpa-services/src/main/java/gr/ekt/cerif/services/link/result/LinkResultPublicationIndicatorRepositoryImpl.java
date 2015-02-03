package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPublication_Indicator;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Indicator;

@Component
public class LinkResultPublicationIndicatorRepositoryImpl implements
		LinkResultPublicationIndicatorRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPublicationIndicatorRepositoryImpl.class);
	
	@Autowired
	private LinkResultPublicationIndicatorCrudRepository linkResultPublicationIndicatorCrudRepository;

	@Override
	public void delete(ResultPublication_Indicator entity) {
		linkResultPublicationIndicatorCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublication_Indicator> entities) {
		linkResultPublicationIndicatorCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublication_Indicator> save(
			Iterable<ResultPublication_Indicator> entities) {
		return linkResultPublicationIndicatorCrudRepository.save(entities);
	}

	@Override
	public ResultPublication_Indicator save(ResultPublication_Indicator entity) {
		return linkResultPublicationIndicatorCrudRepository.save(entity);
	}

	@Override
	public List<ResultPublication_Indicator> findByIndicator(Indicator indicator) {
		return linkResultPublicationIndicatorCrudRepository.findByIndicator(indicator);
	}

	@Override
	public List<ResultPublication_Indicator> findByResultPublication(
			ResultPublication resultPublication) {
		return linkResultPublicationIndicatorCrudRepository.findByResultPublication(resultPublication);
	}

}

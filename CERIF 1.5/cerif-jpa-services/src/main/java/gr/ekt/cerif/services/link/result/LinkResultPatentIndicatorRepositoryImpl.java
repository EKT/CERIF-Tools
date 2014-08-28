package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPatent_Indicator;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.second.Indicator;

@Component
public class LinkResultPatentIndicatorRepositoryImpl implements
		LinkResultPatentIndicatorRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPatentIndicatorRepositoryImpl.class);
	
	@Autowired
	private LinkResultPatentIndicatorCrudRepository linkResultPatentIndicatorCrudRepository;

	@Override
	public void delete(ResultPatent_Indicator entity) {
		linkResultPatentIndicatorCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPatent_Indicator> entities) {
		linkResultPatentIndicatorCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPatent_Indicator> save(
			Iterable<ResultPatent_Indicator> entities) {
		return linkResultPatentIndicatorCrudRepository.save(entities);
	}

	@Override
	public ResultPatent_Indicator save(ResultPatent_Indicator entity) {
		return linkResultPatentIndicatorCrudRepository.save(entity);
	}

	@Override
	public List<ResultPatent_Indicator> findByIndicator(Indicator indicator) {
		return linkResultPatentIndicatorCrudRepository.findByIndicator(indicator);
	}

	@Override
	public List<ResultPatent_Indicator> findByResultPatent(
			ResultPatent resultPatent) {
		return linkResultPatentIndicatorCrudRepository.findByResultPatent(resultPatent);
	}

}

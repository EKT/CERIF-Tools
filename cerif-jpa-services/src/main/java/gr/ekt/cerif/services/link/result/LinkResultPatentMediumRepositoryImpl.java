package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPatent_Medium;

@Component
public class LinkResultPatentMediumRepositoryImpl implements
		LinkResultPatentMediumRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPatentMediumRepositoryImpl.class);
	
	@Autowired
	private LinkResultPatentMediumCrudRepository linkResultPatentMediumCrudRepository;

	@Override
	public void delete(ResultPatent_Medium entity) {
		linkResultPatentMediumCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPatent_Medium> entities) {
		linkResultPatentMediumCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPatent_Medium> save(
			Iterable<ResultPatent_Medium> entities) {
		return linkResultPatentMediumCrudRepository.save(entities);
	}

	@Override
	public ResultPatent_Medium save(ResultPatent_Medium entity) {
		return linkResultPatentMediumCrudRepository.save(entity);
	}

}

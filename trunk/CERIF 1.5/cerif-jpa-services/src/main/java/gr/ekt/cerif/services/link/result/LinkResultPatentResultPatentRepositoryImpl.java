package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPatent_ResultPatent;

@Component
public class LinkResultPatentResultPatentRepositoryImpl implements
		LinkResultPatentResultPatentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPatentResultPatentRepositoryImpl.class);
	
	@Autowired
	private LinkResultPatentResultPatentCrudRepository linkResultPatentResultPatentCrudRepository;

	@Override
	public void delete(ResultPatent_ResultPatent entity) {
		linkResultPatentResultPatentCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPatent_ResultPatent> entities) {
		linkResultPatentResultPatentCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPatent_ResultPatent> save(
			Iterable<ResultPatent_ResultPatent> entities) {
		return linkResultPatentResultPatentCrudRepository.save(entities);
	}

	@Override
	public ResultPatent_ResultPatent save(ResultPatent_ResultPatent entity) {
		return linkResultPatentResultPatentCrudRepository.save(entity);
	}

}

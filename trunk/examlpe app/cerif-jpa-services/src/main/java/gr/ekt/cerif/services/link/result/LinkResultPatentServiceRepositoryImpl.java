package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPatent_Service;

@Component
public class LinkResultPatentServiceRepositoryImpl implements
		LinkResultPatentServiceRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPatentServiceRepositoryImpl.class);
	
	@Autowired
	private LinkResultPatentServiceCrudRepository linkResultPatentServiceCrudRepository;

	@Override
	public void delete(ResultPatent_Service entity) {
		linkResultPatentServiceCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPatent_Service> entities) {
		linkResultPatentServiceCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPatent_Service> save(
			Iterable<ResultPatent_Service> entities) {
		return linkResultPatentServiceCrudRepository.save(entities);
	}

	@Override
	public ResultPatent_Service save(ResultPatent_Service entity) {
		return linkResultPatentServiceCrudRepository.save(entity);
	}

}

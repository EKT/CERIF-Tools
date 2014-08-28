package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPatent_Class;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.semantics.Class;

@Component
public class LinkResultPatentClassRepositoryImpl implements LinkResultPatentClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPatentClassRepositoryImpl.class);
	
	@Autowired
	private LinkResultPatentClassCrudRepository linkResultPatentClassCrudRepository;

	@Override
	public void delete(ResultPatent_Class entity) {
		linkResultPatentClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPatent_Class> entities) {
		linkResultPatentClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPatent_Class> save(Iterable<ResultPatent_Class> entities) {
		return linkResultPatentClassCrudRepository.save(entities);
	}

	@Override
	public ResultPatent_Class save(ResultPatent_Class entity) {
		return linkResultPatentClassCrudRepository.save(entity);
	}

	@Override
	public List<ResultPatent_Class> findByResultPatent(ResultPatent resultPatent) {
		return linkResultPatentClassCrudRepository.findByResultPatent(resultPatent);
	}

	@Override
	public List<ResultPatent_Class> findBytheClass(Class theClass) {
		return linkResultPatentClassCrudRepository.findBytheClass(theClass);
	}

}

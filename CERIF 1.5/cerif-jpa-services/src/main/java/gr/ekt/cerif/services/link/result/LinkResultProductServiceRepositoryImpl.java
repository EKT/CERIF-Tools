package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.result.ResultProduct_Service;
import gr.ekt.cerif.entities.result.ResultProduct;

@Component
public class LinkResultProductServiceRepositoryImpl implements
		LinkResultProductServiceRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultProductServiceRepositoryImpl.class);
	
	@Autowired
	private LinkResultProductServiceCrudRepository linkResultProductServiceCrudRepository;

	@Override
	public void delete(ResultProduct_Service entity) {
		linkResultProductServiceCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProduct_Service> entities) {
		linkResultProductServiceCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProduct_Service> save(
			Iterable<ResultProduct_Service> entities) {
		return linkResultProductServiceCrudRepository.save(entities);
	}

	@Override
	public ResultProduct_Service save(ResultProduct_Service entity) {
		return linkResultProductServiceCrudRepository.save(entity);
	}

	@Override
	public List<ResultProduct_Service> findByService(Service service) {
		return linkResultProductServiceCrudRepository.findByService(service);
	}

	@Override
	public List<ResultProduct_Service> findByResultProduct(
			ResultProduct resultProduct) {
		return linkResultProductServiceCrudRepository.findByResultProduct(resultProduct);
	}

}

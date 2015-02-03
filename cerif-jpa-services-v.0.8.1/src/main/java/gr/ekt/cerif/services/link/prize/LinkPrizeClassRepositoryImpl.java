package gr.ekt.cerif.services.link.prize;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Prize_Class;
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.semantics.Class;

@Component
public class LinkPrizeClassRepositoryImpl implements LinkPrizeClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPrizeClassRepositoryImpl.class);
	
	@Autowired
	private LinkPrizeClassCrudRepository LinkPrizeClassCrudRepository;

	@Override
	public void delete(Prize_Class entity) {
		LinkPrizeClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Prize_Class> entities) {
		LinkPrizeClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Prize_Class> save(Iterable<Prize_Class> entities) {
		return LinkPrizeClassCrudRepository.save(entities);
	}

	@Override
	public Prize_Class save(Prize_Class entity) {
		return LinkPrizeClassCrudRepository.save(entity);
	}

	@Override
	public List<Prize_Class> findByPrize(Prize prize) {
		return LinkPrizeClassCrudRepository.findByPrize(prize);
	}

	@Override
	public List<Prize_Class> findBytheClass(Class theClass) {
		return LinkPrizeClassCrudRepository.findBytheClass(theClass);
	}

}

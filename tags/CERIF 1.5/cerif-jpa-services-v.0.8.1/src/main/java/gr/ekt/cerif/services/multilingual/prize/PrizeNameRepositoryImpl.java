package gr.ekt.cerif.services.multilingual.prize;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.multilingual.PrizeName;

@Component
public class PrizeNameRepositoryImpl implements PrizeNameRepository {
	
	private static final Logger log = LoggerFactory.getLogger(PrizeNameRepositoryImpl.class);
	
	@Autowired
	private PrizeNameCrudRepository prizeNameCrudRepository;

	@Override
	public void delete(PrizeName entity) {
		prizeNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<PrizeName> entities) {
		prizeNameCrudRepository.delete(entities);
	}

	@Override
	public Iterable<PrizeName> save(Iterable<PrizeName> entities) {
		return prizeNameCrudRepository.save(entities);
	}

	@Override
	public PrizeName save(PrizeName entity) {
		return prizeNameCrudRepository.save(entity);
	}

	@Override
	public List<PrizeName> findByPrize(Prize prize) {
		return prizeNameCrudRepository.findByPrize(prize);
	}

}

package gr.ekt.cerif.services.multilingual.prize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.PrizeKeyword;

@Component
public class PrizeKeywordRepositoryImpl implements PrizeKeywordRepository {
	
	private static final Logger log = LoggerFactory.getLogger(PrizeKeywordRepositoryImpl.class);
	
	@Autowired
	private PrizeKeywordCrudRepository prizeKeywordCrudRepository;

	@Override
	public void delete(PrizeKeyword entity) {
		prizeKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<PrizeKeyword> entities) {
		prizeKeywordCrudRepository.delete(entities);
	}

	@Override
	public Iterable<PrizeKeyword> save(Iterable<PrizeKeyword> entities) {
		return prizeKeywordCrudRepository.save(entities);
	}

	@Override
	public PrizeKeyword save(PrizeKeyword entity) {
		return prizeKeywordCrudRepository.save(entity);
	}

}

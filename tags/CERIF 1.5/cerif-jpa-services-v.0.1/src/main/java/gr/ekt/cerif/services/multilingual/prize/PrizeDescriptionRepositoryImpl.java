package gr.ekt.cerif.services.multilingual.prize;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.multilingual.PrizeDescription;

@Component
public class PrizeDescriptionRepositoryImpl implements PrizeDescriptionRepository  {
	
	private static final Logger log = LoggerFactory.getLogger(PrizeDescriptionRepositoryImpl.class);
	
	@Autowired
	private PrizeDescriptionCrudRepository prizeDescriptionCrudRepository;

	@Override
	public void delete(PrizeDescription entity) {
		prizeDescriptionCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<PrizeDescription> entities) {
		prizeDescriptionCrudRepository.delete(entities);
	}

	@Override
	public Iterable<PrizeDescription> save(Iterable<PrizeDescription> entities) {
		return prizeDescriptionCrudRepository.save(entities);
	}

	@Override
	public PrizeDescription save(PrizeDescription entity) {
		return prizeDescriptionCrudRepository.save(entity);
	}

	@Override
	public List<PrizeDescription> findByPrize(Prize prize) {
		return prizeDescriptionCrudRepository.findByPrize(prize);
	}

}

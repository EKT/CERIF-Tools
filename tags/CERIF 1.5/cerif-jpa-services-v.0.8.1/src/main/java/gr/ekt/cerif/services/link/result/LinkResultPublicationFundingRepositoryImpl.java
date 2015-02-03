package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPublication_Funding;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Funding;

@Component
public class LinkResultPublicationFundingRepositoryImpl implements
		LinkResultPublicationFundingRepository {

	private static final Logger log = LoggerFactory.getLogger(LinkResultPublicationFundingRepositoryImpl.class);
	
	@Autowired
	private LinkResultPublicationFundingCrudRepository linkResultPublicationFundingCrudRepository;
	
	@Override
	public void delete(ResultPublication_Funding entity) {
		linkResultPublicationFundingCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublication_Funding> entities) {
		linkResultPublicationFundingCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublication_Funding> save(
			Iterable<ResultPublication_Funding> entities) {
		return linkResultPublicationFundingCrudRepository.save(entities);
	}

	@Override
	public ResultPublication_Funding save(ResultPublication_Funding entity) {
		return linkResultPublicationFundingCrudRepository.save(entity);
	}

	@Override
	public List<ResultPublication_Funding> findByFunding(Funding funding) {
		return linkResultPublicationFundingCrudRepository.findByFunding(funding);
	}

	@Override
	public List<ResultPublication_Funding> findByResultPublication(
			ResultPublication resultPublication) {
		return linkResultPublicationFundingCrudRepository.findByResultPublication(resultPublication);
	}

}

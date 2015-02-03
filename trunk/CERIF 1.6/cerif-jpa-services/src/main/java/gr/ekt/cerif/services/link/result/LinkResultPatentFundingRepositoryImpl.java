package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPatent_Funding;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.second.Funding;

@Component
public class LinkResultPatentFundingRepositoryImpl implements
		LinkResultPatentFundingRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPatentFundingRepositoryImpl.class);
	
	@Autowired
	private LinkResultPatentFundingCrudRepository linkResultPatentFundingCrudRepository;

	@Override
	public void delete(ResultPatent_Funding entity) {
		linkResultPatentFundingCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPatent_Funding> entities) {
		linkResultPatentFundingCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPatent_Funding> save(
			Iterable<ResultPatent_Funding> entities) {
		return linkResultPatentFundingCrudRepository.save(entities);
	}

	@Override
	public ResultPatent_Funding save(ResultPatent_Funding entity) {
		return linkResultPatentFundingCrudRepository.save(entity);
	}

	@Override
	public List<ResultPatent_Funding> findByFunding(Funding funding) {
		return linkResultPatentFundingCrudRepository.findByFunding(funding);
	}

	@Override
	public List<ResultPatent_Funding> findByResultPatent(
			ResultPatent resultPatent) {
		return linkResultPatentFundingCrudRepository.findByResultPatent(resultPatent);
	}

}

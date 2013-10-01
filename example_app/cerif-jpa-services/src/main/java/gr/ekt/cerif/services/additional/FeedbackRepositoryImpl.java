package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.Feedback;

@Component
public class FeedbackRepositoryImpl implements FeedbackRepository {
	
	private static final Logger log = LoggerFactory.getLogger(FeedbackRepositoryImpl.class);
	
	@Autowired
	private FeedbackCrudRepository feedbackCrudRepository;

	@Override
	public void delete(Feedback entity) {
		feedbackCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Feedback> entities) {
		feedbackCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Feedback> save(Iterable<Feedback> entities) {
		return feedbackCrudRepository.save(entities);
	}

	@Override
	public Feedback save(Feedback entity) {
		return feedbackCrudRepository.save(entity);
	}

}

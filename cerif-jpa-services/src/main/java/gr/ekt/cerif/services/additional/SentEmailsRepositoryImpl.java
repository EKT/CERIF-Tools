package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.SentEmails;

@Component
public class SentEmailsRepositoryImpl implements SentEmailsRepository {
	
	private static final Logger log = LoggerFactory.getLogger(SentEmailsRepositoryImpl.class);
	
	@Autowired
	private SentEmailsCrudRepository sentEmailsCrudRepository;

	@Override
	public void delete(SentEmails entity) {
		sentEmailsCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<SentEmails> entities) {
		sentEmailsCrudRepository.delete(entities);
	}

	@Override
	public Iterable<SentEmails> save(Iterable<SentEmails> entities) {
		return sentEmailsCrudRepository.save(entities);
	}

	@Override
	public SentEmails save(SentEmails entity) {
		return sentEmailsCrudRepository.save(entity);
	}

}

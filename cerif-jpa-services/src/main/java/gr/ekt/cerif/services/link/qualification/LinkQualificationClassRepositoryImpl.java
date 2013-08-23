package gr.ekt.cerif.services.link.qualification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Qualification_Class;

@Component
public class LinkQualificationClassRepositoryImpl implements
		LinkQualificationClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkQualificationClassRepositoryImpl.class);
	
	@Autowired
	private LinkQualificationClassCrudRepository linkQualificationClassCrudRepository;

	@Override
	public void delete(Qualification_Class entity) {
		linkQualificationClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Qualification_Class> entities) {
		linkQualificationClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Qualification_Class> save(
			Iterable<Qualification_Class> entities) {
		return linkQualificationClassCrudRepository.save(entities);
	}

	@Override
	public Qualification_Class save(Qualification_Class entity) {
		return linkQualificationClassCrudRepository.save(entity);
	}

}

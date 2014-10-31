package gr.ekt.cerif.services.link.qualification;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Qualification_Class;
import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.features.semantics.Class;

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

	@Override
	public List<Qualification_Class> findByQualification(
			Qualification qualification) {
		return linkQualificationClassCrudRepository.findByQualification(qualification);
	}

	@Override
	public List<Qualification_Class> findBytheClass(Class theClass) {
		return linkQualificationClassCrudRepository.findBytheClass(theClass);
	}

}

package gr.ekt.cerif.services.link.classscheme;

import java.util.List;

import gr.ekt.cerif.entities.link.ClassScheme_Class;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkClassSchemeClassRepositoryImpl implements LinkClassSchemeClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkClassSchemeClassRepositoryImpl.class);
	
	@Autowired
	private LinkClassSchemeClassCrudRepository linkClassSchemeClassCrudRepository;

	@Override
	public void delete(ClassScheme_Class entity) {
		linkClassSchemeClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ClassScheme_Class> entities) {
		linkClassSchemeClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ClassScheme_Class> save(Iterable<ClassScheme_Class> entities) {
		return linkClassSchemeClassCrudRepository.save(entities);
	}

	@Override
	public ClassScheme_Class save(ClassScheme_Class entity) {
		return linkClassSchemeClassCrudRepository.save(entity);
	}

	@Override
	public List<ClassScheme_Class> findByRelatedClassScheme(
			ClassScheme classScheme) {
		return linkClassSchemeClassCrudRepository.findByRelatedClassScheme(classScheme);
	}

	@Override
	public List<ClassScheme_Class> findByRelatedClass(Class theClass) {
		return linkClassSchemeClassCrudRepository.findByRelatedClass(theClass);
	}

}

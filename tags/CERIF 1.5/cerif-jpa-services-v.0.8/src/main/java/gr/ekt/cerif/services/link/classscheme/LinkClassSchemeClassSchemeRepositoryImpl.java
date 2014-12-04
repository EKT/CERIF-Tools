package gr.ekt.cerif.services.link.classscheme;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.ClassScheme_ClassScheme;

@Component
public class LinkClassSchemeClassSchemeRepositoryImpl implements
		LinkClassSchemeClassSchemeRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkClassSchemeClassSchemeRepositoryImpl.class);
	
	@Autowired
	private LinkClassSchemeClassSchemeCrudRepository linkClassSchemeClassSchemeCrudRepository;

	@Override
	public void delete(ClassScheme_ClassScheme entity) {
		linkClassSchemeClassSchemeCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ClassScheme_ClassScheme> entities) {
		linkClassSchemeClassSchemeCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ClassScheme_ClassScheme> save(
			Iterable<ClassScheme_ClassScheme> entities) {
		return linkClassSchemeClassSchemeCrudRepository.save(entities);
	}

	@Override
	public ClassScheme_ClassScheme save(ClassScheme_ClassScheme entity) {
		return linkClassSchemeClassSchemeCrudRepository.save(entity);
	}

}

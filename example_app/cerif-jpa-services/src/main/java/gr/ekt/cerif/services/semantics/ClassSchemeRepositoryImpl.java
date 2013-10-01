package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.ClassScheme;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Component
public class ClassSchemeRepositoryImpl implements ClassSchemeRepository {

	@Autowired
	private ClassSchemeCrudRepository classSchemeCrudRepository;

	@Override
	public ClassScheme findByUri(String uri) {
		return classSchemeCrudRepository.findByUri(uri);
	}

	@Override
	public ClassScheme save(ClassScheme entity) {
		return classSchemeCrudRepository.save(entity);
	}

	@Override
	public Iterable<ClassScheme> save(Iterable<ClassScheme> entities) {
		return classSchemeCrudRepository.save(entities);
	}

	@Override
	public void delete(ClassScheme entity) {
		classSchemeCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<ClassScheme> entities) {
		classSchemeCrudRepository.delete(entities);		
	}
	
	
}

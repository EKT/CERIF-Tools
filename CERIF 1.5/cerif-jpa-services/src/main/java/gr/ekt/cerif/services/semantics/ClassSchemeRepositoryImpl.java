package gr.ekt.cerif.services.semantics;

import java.util.List;

import gr.ekt.cerif.features.semantics.ClassScheme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

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

	@Override
	public List<ClassScheme> findAll() {
		return classSchemeCrudRepository.findAll();
	}

	@Override
	public Page<ClassScheme> findAll(Pageable page) {
		return classSchemeCrudRepository.findAll(page);
	}

	@Override
	public ClassScheme findByUuid(String uuid) {
		return classSchemeCrudRepository.findByUuid(uuid);
	}
	
	
}

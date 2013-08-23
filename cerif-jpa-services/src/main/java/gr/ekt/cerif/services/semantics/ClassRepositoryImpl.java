package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ClassRepositoryImpl implements ClassRepository {
	
	@Autowired
	private ClassCrudRepository classCrudRepository;
	
	public Class findById(Long id) {
		return classCrudRepository.findById(id);
	}

	public List<Class> findByUri(String uri) {
		return classCrudRepository.findByUri(uri);
	}
	
	public List<Class> findByScheme(ClassScheme scheme) {
		return classCrudRepository.findByScheme(scheme);
	}

	@Transactional
	public void delete(Class entity) {
		classCrudRepository.delete(entity);		
	}

	@Transactional
	public Iterable<Class> save(Iterable<Class> entityList) {
		return classCrudRepository.save(entityList);
	}

	@Transactional
	public Class save(Class entity) {
		return classCrudRepository.save(entity);
	}

	public Class findOne(Long id) {
		return classCrudRepository.findOne(id);
	}

	@Override
	public void delete(Iterable<Class> entityList) {
		classCrudRepository.delete(entityList);
	}

}

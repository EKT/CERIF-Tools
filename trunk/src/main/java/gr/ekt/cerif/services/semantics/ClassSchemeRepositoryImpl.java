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

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ClassSchemeCrudRepository classSchemeCrudRepository;
	
	@Transactional
	public ClassScheme save(ClassScheme scheme) {
		System.out.println("CUSTOM SAVE for class scheme!!");
		if (StringUtils.hasText(scheme.getUri())) {
			ClassScheme alreadyStored = classSchemeCrudRepository.findByUri(scheme.getUri());
			if (alreadyStored != null) {
				scheme.setId(alreadyStored.getId());
			}
		}
		entityManager.merge(scheme);
		return scheme;
	}

	@Transactional
	public Iterable<? extends ClassScheme> save(Iterable<? extends ClassScheme> entities) {
		for (ClassScheme scheme : entities) {
			save(scheme);
		}
		return entities;
	}

	public ClassScheme findByUri(String uri) {
		return classSchemeCrudRepository.findByUri(uri);
	}

	public void delete(ClassScheme entity) {
		classSchemeCrudRepository.delete(entity);
	}

}

/**
 * 
 */
package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * 
 */
@Component
public class ClassSchemeServiceImpl implements ClassSchemeService {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ClassSchemeRepository classSchemeRepository;

	@Override
	@Transactional
	public void save(ClassScheme scheme) {
		System.out.println("CUSTOM SAVE for class scheme!!");
		if (StringUtils.hasText(scheme.getUri())) {
			ClassScheme alreadyStored = classSchemeRepository.findByUri(scheme.getUri());
			if (alreadyStored != null) {
				scheme.setId(alreadyStored.getId());
			}
		}
		entityManager.merge(scheme);
	}

	@Override
	@Transactional
	public void save(List<? extends ClassScheme> entities) {
		for (ClassScheme scheme : entities) {
			save(scheme);
		}
	}
}

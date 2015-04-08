package gr.ekt.cerif.services.link.curriculumvitae;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.CurriculumVitae_Class;
import gr.ekt.cerif.entities.second.CurriculumVitae;
import gr.ekt.cerif.features.semantics.Class;

@Component
public class LinkCurriculumVitaeClassRepositoryImpl implements LinkCurriculumVitaeClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkCurriculumVitaeClassRepositoryImpl.class);
	
	@Autowired
	private LinkCurriculumVitaeClassCrudRepository linkCurriculumVitaeClassCrudRepository;

	@Override
	public void delete(CurriculumVitae_Class entity) {
		linkCurriculumVitaeClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<CurriculumVitae_Class> entities) {
		linkCurriculumVitaeClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<CurriculumVitae_Class> save(Iterable<CurriculumVitae_Class> entities) {
		return linkCurriculumVitaeClassCrudRepository.save(entities);
	}

	@Override
	public CurriculumVitae_Class save(CurriculumVitae_Class entity) {
		return linkCurriculumVitaeClassCrudRepository.save(entity);
	}

	@Override
	public List<CurriculumVitae_Class> findByCurriculumVitae(CurriculumVitae curriculumVitae) {
		return linkCurriculumVitaeClassCrudRepository.findByCurriculumVitae(curriculumVitae);
	}

	@Override
	public List<CurriculumVitae_Class> findBytheClass(Class theClass) {
		return linkCurriculumVitaeClassCrudRepository.findBytheClass(theClass);
	}

}

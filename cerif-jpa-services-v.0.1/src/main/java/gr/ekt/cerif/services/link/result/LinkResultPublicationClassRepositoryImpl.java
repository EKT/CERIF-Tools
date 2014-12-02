package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkResultPublicationClassRepositoryImpl implements LinkResultPublicationClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPublicationClassRepositoryImpl.class);
	
	@Autowired
	private LinkResultPublicationClassCrudRepository linkResultPublicationClassCrudRepository;
	
	
	@Transactional
	public ResultPublication_Class save(ResultPublication_Class entity) {
		return linkResultPublicationClassCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<ResultPublication_Class> save(Iterable<ResultPublication_Class> entityList) {
		return linkResultPublicationClassCrudRepository.save(entityList);
	}	
	
	@Transactional
	public void delete(ResultPublication_Class entity) {
		linkResultPublicationClassCrudRepository.delete(entity);
	}
	
	@Transactional
	public void delete(Iterable<ResultPublication_Class> entityList) {
		linkResultPublicationClassCrudRepository.delete(entityList);
	}

	@Override
	public List<ResultPublication_Class> findByResultPublication(ResultPublication resultPublication) {
		return linkResultPublicationClassCrudRepository.findByResultPublication(resultPublication);
	}

	@Override
	public List<ResultPublication_Class> findByResPublIdAndClScheme(Long respubId, String schUri) {
		return linkResultPublicationClassCrudRepository.findByResPublIdAndClScheme(respubId, schUri);
	}

	@Override
	public ResultPublication_Class findById(Long respubclId) {
		return linkResultPublicationClassCrudRepository.findById(respubclId);
	}

	@Override
	public ResultPublication_Class findByResPubIdAndClassId(Long respubId, Long clId) {
		return linkResultPublicationClassCrudRepository.findByResPubIdAndClassId(respubId, clId);
	}
	
	@Override
	public List<ResultPublication_Class> findByResPubId(Long respubId) {
		return linkResultPublicationClassCrudRepository.findByResPubId(respubId);
	}

	@Override
	public ResultPublication_Class findResPubClassBySchemeUriAndResPubId(String schemeUri, Long respubId) {
		return linkResultPublicationClassCrudRepository.findResPubClassBySchemeUriAndResPubId(schemeUri, respubId);
	}

	@Override
	public List<ResultPublication_Class> findBytheClass(Class theClass) {
		return linkResultPublicationClassCrudRepository.findBytheClass(theClass);
	}
}

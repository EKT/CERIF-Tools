package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkResultPublicationClassRepositoryImpl implements LinkResultPublicationClassRepository {

	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private LinkResultPublicationClassCrudRepository linkResultPublicationClassCrudRepository;
	
	
	@Transactional
	public ResultPublication_Class save(ResultPublication_Class entity) {
		return linkResultPublicationClassCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<ResultPublication_Class> save(Iterable<ResultPublication_Class> entityList) {
		return save(entityList);
	}
	
	
	@Transactional
	public void delete(ResultPublication_Class entity) {
		linkResultPublicationClassCrudRepository.delete(entity);
	}
	
	@Transactional
	public void delete(Iterable<ResultPublication_Class> entityList) {
		linkResultPublicationClassCrudRepository.delete(entityList);
	}

	@Transactional
	@Override
	public void updateResultPublication_ClassList(ResultPublication rp, List<Long> classIds, String classSchemeUri) {	
		List<ResultPublication_Class> existingResultPublication_Class = this.findByResPublIdAndClScheme(rp.getId(), classSchemeUri);
		ArrayList<Long> existingClassIds = new ArrayList<Long>();
		for (ResultPublication_Class rpc : existingResultPublication_Class) {
			existingClassIds.add(rpc.getTheClass().getId());
		}
		
		//remove the old ones
		if (existingClassIds != null) {
			for (Long existingClassId : existingClassIds) {
				if (classIds == null) {
					ResultPublication_Class rpc = this.findByResPubIdAndClassId(rp.getId(), existingClassId);
					this.delete(rpc);
				} else {
					if (!classIds.contains(existingClassId)) {
						ResultPublication_Class rpc = this.findByResPubIdAndClassId(rp.getId(), existingClassId);
						this.delete(rpc);
					}
				}
			}
		}
		
		//save the new ones
		if (classIds != null) {
			for (Long classId  : classIds) {
				if (!existingClassIds.contains(classId)) {
					Class cl = classRepository.findById(classId);
					ResultPublication_Class rpc = new ResultPublication_Class(rp, cl, new Date(), new Date(), (double)0);
					this.save(rpc);
				}
			}
		}
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

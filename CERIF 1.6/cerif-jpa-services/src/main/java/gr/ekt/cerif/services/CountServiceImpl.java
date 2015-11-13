package gr.ekt.cerif.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import gr.ekt.cerif.CerifEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

/**
 * Implementation of the counting service.
 * 
 * @author Nikolaos Pougounias <pougounias@ekt.gr>
 */
@Service
public class CountServiceImpl implements CountService {
	
	/**
	 * Entity manager.
	 */
	@PersistenceContext
	private EntityManager manager;
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.CountService#count(java.lang.Class)
	 */
	@Override
	public Long count(java.lang.Class<? extends CerifEntity> entityClass) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Root<? extends CerifEntity> root = query.from(entityClass);
		query.select(builder.count(root));
		return manager.createQuery(query).getSingleResult();
	}
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.CountService#count(java.util.List)
	 */
	@Override
	public Map<java.lang.Class<? extends CerifEntity>, Long> count(List<java.lang.Class<? extends CerifEntity>> entityClassList) {
		Map<java.lang.Class<? extends CerifEntity>, Long> result = new LinkedHashMap<Class<? extends CerifEntity>, Long>();
		for (java.lang.Class<? extends CerifEntity> entityClass : entityClassList) {
			Long count = count(entityClass);
			result.put(entityClass, count);
		}
		return result;
	}

}

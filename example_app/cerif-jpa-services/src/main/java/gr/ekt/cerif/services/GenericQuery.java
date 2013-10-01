package gr.ekt.cerif.services;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GenericQuery {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public <T> List<T> find(Class<T> type, String queryStr, HashMap<String, ?> parameters) {
		
		List<T> res = null;
		TypedQuery<T> query;
		
		query = entityManager.createQuery(queryStr, type);
		
		if (parameters!=null) {
			for (String key:parameters.keySet()) {
				query.setParameter(key, parameters.get(key));
			}
		}
		
		res = query.getResultList();
		
		return res;		
	}

}

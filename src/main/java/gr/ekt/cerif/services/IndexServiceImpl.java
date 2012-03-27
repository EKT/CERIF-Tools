/**
 * 
 */
package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifComponent;
import gr.ekt.cerif.entities.base.OrganisationUnit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of the index service for CERIF entities.
 * 
 */
@Component
public class IndexServiceImpl implements IndexService {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	/**
	 * Creates Lucene Index
	 * 
	 */
	public void createIndex() {

		System.out.println("Creating index...");
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		try {
			fullTextEntityManager.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Performs full text search on the Lucene Index
	 * 
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public List<CerifComponent> queryIndex(String q) {
		System.out.println("Searching index for " + q);
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		
		QueryBuilder qb = fullTextEntityManager
				.getSearchFactory()
				.buildQueryBuilder()
				.forEntity( OrganisationUnit.class )
				.get();
		
		// create native Lucene query
		org.apache.lucene.search.Query query = qb
				.keyword()
				.onFields("acronym")
				.matching(q)
				.createQuery();
		
		// wrap Lucene query in a javax.persistence.Query
		javax.persistence.Query persistenceQuery = fullTextEntityManager.createFullTextQuery(query, OrganisationUnit.class);
		
		final List list = persistenceQuery.getResultList();
		
		if (list.equals(Collections.emptyList())) {
			return new ArrayList<CerifComponent>();
		} else {
			return (ArrayList<CerifComponent>) persistenceQuery.getResultList();
		}
	}
	
}

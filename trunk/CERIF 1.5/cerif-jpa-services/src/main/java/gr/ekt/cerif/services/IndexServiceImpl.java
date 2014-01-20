/**
 * 
 */
package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;
import gr.ekt.cerif.features.multilingual.ResultPublicationKeyword;
import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.lucene.analysis.StopAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.DatabaseRetrievalMethod;
import org.hibernate.search.query.ObjectLookupMethod;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of the index service for CERIF entities.
 * 
 */
@Component
public class IndexServiceImpl implements IndexService {

	private static final Logger log = LoggerFactory.getLogger(IndexServiceImpl.class);
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	/**
	 * Creates Lucene Index
	 * 
	 */
	public void createIndex() {

		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		try {
			fullTextEntityManager.createIndexer()
			.threadsToLoadObjects(1)
			.startAndWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Performs full text search on the Lucene Index
	 * 
	 */
	@Transactional
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CerifEntity> queryIndexOld(String q) {
		//System.out.println("Searching index for " + q);
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
		log.info("Found " + list.size() + " results.");
		if (list.equals(Collections.emptyList())) {
			return new ArrayList<CerifEntity>();
		} else {
			return (ArrayList<CerifEntity>) persistenceQuery.getResultList();
		}
	}
	
	@Transactional
	public ArrayList<CerifEntity> queryIndex(String q) {
		ArrayList<CerifEntity> ret = new ArrayList<CerifEntity>();
		FullTextEntityManager fullTextSession = Search.getFullTextEntityManager(entityManager);

		MultiFieldQueryParser parser = new MultiFieldQueryParser(Version.LUCENE_31, 
                new String[] {
				"projectAcronym", "projectAbstract",							//Project
				"organisationUnitName", "organisationUnitAcronym",              //Organisation Unit
				"personFirstNames", "personFamilyNames", "personOtherNames",    //Person
				"resultPublicationKeyword", "resultPublicationTitle"},          //ResultPublication
                new StopAnalyzer(Version.LUCENE_31));
		
		try {
			Query query = parser.parse(q);
			
			log.info("About to send query.");
			FullTextQuery fullTextQuery =  fullTextSession.createFullTextQuery(query);
			fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SECOND_LEVEL_CACHE, DatabaseRetrievalMethod.QUERY);

			@SuppressWarnings("rawtypes")
			List resultList = fullTextQuery.getResultList();
			
			log.info("Found " + resultList.size() + " results.");
			
			for (int i = 0; i < resultList.size(); i++) {
				Object result = resultList.get(i);
				if (result instanceof OrganisationUnitName) {
					OrganisationUnitName on = (OrganisationUnitName) result;
					if (!ret.contains(on)) ret.add(on);
					//log.info(i + " - organisation unit name: " + on.getName());
				} else if (result instanceof Project) {
					Project p = (Project) result;
					if (!ret.contains(p)) ret.add(p);
					//log.info(i + " - project acronym: " + p.getAcronym());
				} else if (result instanceof ProjectAbstract) {
					ProjectAbstract pa = (ProjectAbstract) result;
					if (!ret.contains(pa.getProject())) ret.add(pa.getProject());
					//log.info(i + " - project abstract" + pa.getAbstractText());
				} else if (result instanceof PersonName) {
					PersonName pn = (PersonName) result;
					if (!ret.contains(pn)) ret.add(pn);
					//log.info(i + " - person: first names, family names, other names: " + pn.getFirstNames() + ", " + pn.getFamilyNames() + ", " + pn.getOtherNames());
				} else if (result instanceof ResultPublicationTitle) {
					ResultPublicationTitle pt = (ResultPublicationTitle) result;
					if (!ret.contains(pt)) ret.add(pt);
					//log.info(i + " - result publication title: " + pt.getTitle());
				} else if (result instanceof ResultPublicationKeyword) {
					ResultPublicationKeyword pt = (ResultPublicationKeyword) result;
					if (!ret.contains(pt)) ret.add(pt);
					//log.info(i + " - result publication keyword: " + pt.getKeyword());
				} else {
					log.warn("found result of Unknown type");
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	@Transactional
	public void clearSecondLevelCache() {
		log.info("Clearing second level cache...");
		Session s = (Session) entityManager.getDelegate();
		SessionFactory sf = s.getSessionFactory();
		sf.getCache().evictEntityRegions();
		sf.getCache().evictQueryRegions();
		sf.getCache().evictCollectionRegions();
		sf.getCache().evictNaturalIdRegions();
		sf.getCache().evictDefaultQueryRegion();
		log.info("Done.");
	}
	
}

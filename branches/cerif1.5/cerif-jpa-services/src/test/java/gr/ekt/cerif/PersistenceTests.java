package gr.ekt.cerif;

import java.util.Date;
import java.util.Set;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.FederatedIdentifier_Class;
import gr.ekt.cerif.entities.link.Service_FederatedIdentifier;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.services.PersistenceService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Test suite for persistence.
 * 
 */
@ContextConfiguration("cerif-persistence-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=false)
public class PersistenceTests {

	private static final Logger log = LoggerFactory.getLogger(PersistenceTests.class);
	
	/**
	 * The persistence service.
	 */
	@Autowired
	PersistenceService service;
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	

	
	@Test
	public void testOne() {
		Person p = service.getBaseService().getPersonRepository().findPersonById((long)2);
		System.out.println("Person: "+p.getId());
		FederatedIdentifier f = new FederatedIdentifier(p.getId(), "asdfvasdf",	new Date(), new Date());
		System.out.println("FederatedIdentifier: "+f);
		service.save(f);	
	}

	
	
	
}

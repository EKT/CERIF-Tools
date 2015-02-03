package gr.ekt.cerif;

import java.util.Date;
import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.PersonName_Class;
import gr.ekt.cerif.entities.link.PersonName_Person;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.semantics.Class;
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
		Class c = new Class();
		c.setUuid("uuid");
		service.save(c);
		
		Person p =new Person();
		service.save(p);
		PersonName pn = new PersonName();
		pn.setFamilyNames("familyname");
		service.save(pn);
		PersonName_Person pnp = new PersonName_Person(p, pn, 
				service.getSemanticService().getClassRepository().findByUuid("uuid").get(0), new Date(), new Date());
		service.save(pnp);
		PersonName_Class pnc = new PersonName_Class(pn, 
				service.getSemanticService().getClassRepository().findByUuid("uuid").get(0), new Date(), new Date());
		service.save(pnc);		
	}
	
	@Test
	public void testTwo() {
		List<PersonName_Class> pnc = service.getLinkService().getPersonNameClassRepository().findBytheClass(service.getSemanticService().getClassRepository().findByUuid("uuid").get(0));
		service.delete(pnc);
		
		List<PersonName_Person> pnp = service.getLinkService().getPersonNamePersonRepository().findByPerson(
				service.getBaseService().getPersonRepository().findById((long)2));
		service.delete(pnp);		
	}

	
	
	
}

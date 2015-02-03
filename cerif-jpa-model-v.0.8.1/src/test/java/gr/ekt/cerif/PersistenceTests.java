package gr.ekt.cerif;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Test suite for persistence.
 * 
 * @author Nikos Pougounias <pougounias@ekt.gr>
 * @author Nikolaos Konstantinou <nkons@ekt.gr>
 * @author Nikos Houssos <nhoussos@ekt.gr>
 * @author Christina Paschou <cpaschou@ekt.gr>
 * @author Vasilis Bonis <bonisv@ekt.gr>
 */
@ContextConfiguration("cerif-persistence-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=false)
public class PersistenceTests {

	private static final Logger log = LoggerFactory.getLogger(PersistenceTests.class);
	
	
	
	
}

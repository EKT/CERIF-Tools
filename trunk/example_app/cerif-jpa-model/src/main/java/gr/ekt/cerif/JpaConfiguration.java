package gr.ekt.cerif;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * The Spring-JPA configuration.
 */
@Configuration
public class JpaConfiguration {

	@Value("#{entityManagerFactory}")
	private javax.persistence.EntityManagerFactory entityManagerFactory;

	/**
	 * Defines the transaction manager.
	 * @return the transaction manager.
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager( entityManagerFactory );
	}

}

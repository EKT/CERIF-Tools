package gr.ekt.cerif;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.cache.HashtableCacheProvider;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.dialect.PostgreSQLDialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * The Spring-JPA configuration.
 */
@Configuration
public class JpaConfiguration {

	/**
	 * The data source.
	 */
	@Value("#{dataSource}")
	private javax.sql.DataSource dataSource;

	/**
	 * Defines the JPA properties.
	 * @return the JPA properties.
	 */
	@Bean
	public Map<String, Object> jpaProperties() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("hibernate.dialect", MySQL5InnoDBDialect.class.getName());
		//props.put("hibernate.dialect", PostgreSQLDialect.class.getName());
		props.put("hibernate.cache.provider_class", HashtableCacheProvider.class.getName());
		props.put("hibernate.hbm2ddl.auto", "create"); //create update
		props.put("hibernate.show_sql", "true");
		
		props.put("hibernate.search.default.directory_provider", "filesystem");
		props.put("hibernate.search.default.indexBase", "/var/lucene/indexes");
		
		return props;
	}

	/**
	 * Defines the JPA vendor adapter.
	 * @return the JPA vendor adapter.
	 */
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		return hibernateJpaVendorAdapter;
	}

	/**
	 * Defines the transaction manager.
	 * @return the transaction manager.
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager( localContainerEntityManagerFactoryBean().getObject() );
	}

	/**
	 * Defines the entity manager factory bean.
	 * @return the entity manager factory bean.
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(this.dataSource);
		lef.setJpaPropertyMap(this.jpaProperties());
		lef.setJpaVendorAdapter(this.jpaVendorAdapter());
		return lef;
	}

}

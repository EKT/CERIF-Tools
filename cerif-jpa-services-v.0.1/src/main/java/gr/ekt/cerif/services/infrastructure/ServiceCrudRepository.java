package gr.ekt.cerif.services.infrastructure;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import gr.ekt.cerif.entities.infrastructure.Service;

public interface ServiceCrudRepository extends CrudRepository<Service, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Service> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Page<Service> findAll(Pageable page);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Service findByUuid(String uuid);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Service findById(Long Id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Service> findByUri(String uri);

}

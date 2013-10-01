package gr.ekt.cerif.services.infrastructure;

import org.springframework.data.repository.CrudRepository;

import gr.ekt.cerif.entities.infrastructure.Service;

public interface ServiceCrudRepository extends CrudRepository<Service, Long> {

}

package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCore;

import org.springframework.data.repository.CrudRepository;

public interface DublinCoreCrudRepository extends CrudRepository<DublinCore, Long> {

}

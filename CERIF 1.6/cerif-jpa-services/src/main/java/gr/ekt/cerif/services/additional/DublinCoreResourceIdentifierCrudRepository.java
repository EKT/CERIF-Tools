package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreResourceIdentifier;

import org.springframework.data.repository.CrudRepository;

@Deprecated
public interface DublinCoreResourceIdentifierCrudRepository extends CrudRepository<DublinCoreResourceIdentifier, Long> {

}

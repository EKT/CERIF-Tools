package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreRelation;

import org.springframework.data.repository.CrudRepository;

@Deprecated
public interface DublinCoreRelationCrudRepository extends CrudRepository<DublinCoreRelation, Long> {

}

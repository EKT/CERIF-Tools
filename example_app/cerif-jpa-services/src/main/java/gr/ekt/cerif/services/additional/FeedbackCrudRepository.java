package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.Feedback;

import org.springframework.data.repository.CrudRepository;

public interface FeedbackCrudRepository extends CrudRepository<Feedback, Long> {

}

package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.Feedback;

import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepository extends CrudRepository<Feedback, Long> {

}

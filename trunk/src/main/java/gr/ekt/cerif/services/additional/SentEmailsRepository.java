package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.SentEmails;

import org.springframework.data.repository.CrudRepository;

public interface SentEmailsRepository extends CrudRepository<SentEmails, Long>{

}
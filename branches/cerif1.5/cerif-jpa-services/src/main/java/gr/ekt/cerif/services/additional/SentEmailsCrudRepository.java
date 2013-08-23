package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.SentEmails;

import org.springframework.data.repository.CrudRepository;

public interface SentEmailsCrudRepository extends CrudRepository<SentEmails, Long>{

}
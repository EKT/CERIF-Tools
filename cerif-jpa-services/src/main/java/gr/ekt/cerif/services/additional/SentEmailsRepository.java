package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.SentEmails;

public interface SentEmailsRepository {
	
	public void delete(SentEmails entity); 
	
	public void delete(Iterable<SentEmails> entities); 

	public Iterable<SentEmails> save(Iterable<SentEmails> entities); 
	
	public SentEmails save(SentEmails entity);

}

package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.Feedback;

public interface FeedbackRepository {
	
	public void delete(Feedback entity); 
	
	public void delete(Iterable<Feedback> entities); 

	public Iterable<Feedback> save(Iterable<Feedback> entities); 
	
	public Feedback save(Feedback entity);

}

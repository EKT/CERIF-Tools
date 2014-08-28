package gr.ekt.cerif.services.multilingual.qualification;

import java.util.List;

import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.features.multilingual.QualificationDescription;

public interface QualificationDescriptionRepository {
	
	public void delete(QualificationDescription entity); 
	
	public void delete(Iterable<QualificationDescription> entities); 

	public Iterable<QualificationDescription> save(Iterable<QualificationDescription> entities); 
	
	public QualificationDescription save(QualificationDescription entity);
	
	List<QualificationDescription> findByQualification(Qualification qualification);

}

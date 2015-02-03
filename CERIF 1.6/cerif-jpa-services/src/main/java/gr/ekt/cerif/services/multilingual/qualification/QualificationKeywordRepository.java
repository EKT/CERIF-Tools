package gr.ekt.cerif.services.multilingual.qualification;

import java.util.List;

import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.features.multilingual.QualificationKeyword;

public interface QualificationKeywordRepository {
	
	public void delete(QualificationKeyword entity); 
	
	public void delete(Iterable<QualificationKeyword> entities); 

	public Iterable<QualificationKeyword> save(Iterable<QualificationKeyword> entities); 
	
	public QualificationKeyword save(QualificationKeyword entity);
	
	List<QualificationKeyword> findByQualification(Qualification qualification);

}

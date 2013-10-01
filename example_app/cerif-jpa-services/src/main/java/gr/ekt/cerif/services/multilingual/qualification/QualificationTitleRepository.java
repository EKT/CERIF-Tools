package gr.ekt.cerif.services.multilingual.qualification;

import gr.ekt.cerif.features.multilingual.QualificationTitle;

public interface QualificationTitleRepository {
	
	public void delete(QualificationTitle entity); 
	
	public void delete(Iterable<QualificationTitle> entities); 

	public Iterable<QualificationTitle> save(Iterable<QualificationTitle> entities); 
	
	public QualificationTitle save(QualificationTitle entity);

}

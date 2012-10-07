package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultPublicationView;

import java.util.List;
import java.util.Map;

public interface ResultPublicationService {

	public List<ResultPublicationView> queryResPubView(List<String> parameters, String queryAdd);
}

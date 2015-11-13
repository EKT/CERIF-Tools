package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifEntity;

import java.util.List;
import java.util.Map;

/**
 * Count service.
 * 
 * @author Nikolaos Pougounias <pougounias@ekt.gr>
 */
public interface CountService {

	Long count(java.lang.Class<? extends CerifEntity> entityClass);

	Map<java.lang.Class<? extends CerifEntity>, Long> count(List<java.lang.Class<? extends CerifEntity>> entityClassList);

}
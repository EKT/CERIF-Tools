package gr.ekt.cerif.services.infrastructure;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.FacilityList;
import gr.ekt.cerif.entities.infrastructure.FacilityView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface FacilityCrudRepository extends CrudRepository<Facility, String> {

	Facility findById(Long id);
	
	Facility findByAcronym(String acronym);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.infrastructure.FacilityList(" +
			   "       f.acronym,    " +
			   "       fn.name,    	 " +
			   "       f.id,    	 " +
			   "       fund.acronym, " +
			   "       ffcl.uri,     " +
			   "       fundcl.uri)   " +
			   "  from Facility f    								" +
			   "  join f.names fn              						" +
			   "  join f.facilities_fundings ff              		" +
			   "  join ff.theClass ffcl              		 		" +
			   "  join ffcl.scheme ffs                       		" +
			   "  join ff.funding fund                       		" +
			   "  join fund.classes fundcls                  		" +
			   "  join fundcls.theClass fundcl               		" +
			   "  join fundcl.scheme funds                   		" +			   
			   "  where ffs.uri='focusarea' AND funds.uri='origin'	")
	List<FacilityList> findAllFacilities();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.infrastructure.FacilityList(" +
				   "       f.acronym,    " +
				   "       fn.name,    	 " +
				   "       f.id,    	 " +
				   "       fund.acronym, " +
				   "       ffcl.uri,     " +
				   "       fundcl.uri)   " +
				   "  from Facility f    												" +
				   "  join f.names fn              										" +
				   "  join f.facilities_fundings ff              						" +
				   "  join ff.theClass ffcl              		 						" +
				   "  join ffcl.scheme ffs                       						" +
				   "  join ff.funding fund                       						" +
				   "  join fund.classes fundcls                  						" +
				   "  join fundcls.theClass fundcl               						" +
				   "  join fundcl.scheme funds                   						" +
				   "  join f.organisationUnits_facilities orgfac 						" +
				   "  join orgfac.organisationUnit o             						" +
				   "  join o.postalAddresses op                  						" +
				   "  join op.postalAddress pa                   						" +
				   "  join pa.country c                          						" +
				   " where c.uri = ?1 AND ffs.uri='focusarea' AND funds.uri='origin'	")
	List<FacilityList> findByCountry(String country);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select				" +
			   "       o.id, 			" +
			   "       o.uri        	" +			   
			   "  from Facility f    						 " +
			   "  join f.organisationUnits_facilities orgfac " +
			   "  join orgfac.organisationUnit o             " +			   
			   " where f.id = ?1                             ")
	Object[] findOrgUnitByFacilityId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select				" +
			   "       c.uri        	" +			   
			   "  from OrganisationUnit o    						 " +
			   "  join o.postalAddresses op                  " +
			   "  join op.postalAddress pa                   " +
			   "  join pa.country c                          " +
			   " where o.id = ?1                             ")
	Object findOrgUnitCountryByOrgUnitId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select				" +
			   "       p.id,  " +
			   "       pn.familyNames	" +
			   "  from Facility f    						 " +
			   "  join f.persons_facilities fp               " +
			   "  join fp.person p							 " +
			   "  join p.personName pn						 " +			   		  
			   " where f.id = ?1                             ")
	Object[] findPersonNameByFacilityId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select				" +
			   "       e.uri        	" +
			   "  from Person p    						 " +
			   "  join p.persons_electronicAddresses pe		 " +
			   "  join pe.electronicAddress e		 		 " +			   
			   " where p.id = ?1                             ")
	Object findPersonEmailByPersonId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.infrastructure.FacilityView(" +
			   "       f.acronym,       " +
			   "       fn.name,    	    " +
			   "       fd.description,  " +
			   "       fund.acronym,    " +
			   "       f.uri)        	" +
			   "  from Facility f    						 " +
			   "  join f.names fn              				 " +
			   "  join f.descriptions fd              		 " +
			   "  join f.facilities_fundings ff              " +			   
			   "  join ff.funding fund                       " +			   			   
			   " where f.id = ?1                             ")
	FacilityView findByFacilityId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select				" +
			   "       f.acronym       	" +
			   "  from Facility f    						 " +			   		   			   
			   " where f.id = ?1                             ")
	Object findFacilityAcronymByFacilityId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.infrastructure.FacilityView(" +
			   "       f.acronym,       " +
			   "       fn.name,    	    " +
			   "       fd.description,  " +
			   "       fund.acronym, 	" +
			   "       f.uri,        	" +
			   "       pn.familyNames,  " +
			   "       e.uri)        	" +
			   "  from Facility f    						 " +
			   "  join f.names fn              				 " +
			   "  join f.descriptions fd              		 " +
			   "  join f.facilities_fundings ff              " +			   
			   "  join ff.funding fund                       " +
			   "  join f.persons_facilities fp               " +
			   "  join fp.person p							 " +
			   "  join p.personName pn						 " +
			   "  join p.persons_electronicAddresses pe		 " +
			   "  join pe.electronicAddress e		 		 " +			   
			   " where f.id = ?1                             ")
	FacilityView findByFacilityIdNoOrg(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.infrastructure.FacilityList(" +
			   "       f.acronym,    " +
			   "       fn.name,    	 " +
			   "       f.id,    	 " +
			   "       fund.acronym, " +
			   "       ffcl.uri,     " +
			   "       fundcl.uri)   " +
			   "  from Facility f    							" +
			   "  join f.names fn              					" +
			   "  join f.facilities_fundings ff              	" +
			   "  join ff.theClass ffcl              		 	" +
			   "  join ffcl.scheme ffs                       	" +
			   "  join ff.funding fund                       	" +
			   "  join fund.classes fundcls                  	" +
			   "  join fundcls.theClass fundcl               	" +
			   "  join fundcl.scheme funds                   	" +			   
			   "  join f.classes fc  							" +
	   	       "  join fc.theClass cl 							" +
			   " where cl.uri = ?1 AND ffs.uri='focusarea' AND funds.uri='origin'	")
	List<FacilityList> findByClass(String classUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.infrastructure.FacilityList(" +
			   "       f.acronym,    				" +
			   "       fn.name,    	 				" +
			   "       f.id,    	 				" +
			   "       fund.acronym, 				" +
			   "       ffcl.uri,     				" +
			   "       fundcl.uri)   				" +
			   "  from Facility f    							" +
			   "  join f.names fn              					" +
			   "  join f.facilities_fundings ff  				" +
			   "  join ff.theClass ffcl              		 	" +
			   "  join ffcl.scheme ffs                       	" +
			   "  join ff.funding fund              			" +
			   "  join fund.classes fundcls              		" +
			   "  join fundcls.theClass fundcl              	" +
			   "  join fundcl.scheme funds                   	" +	
			   " where fundcl.uri = ?1 AND ffs.uri='focusarea' AND funds.uri='origin'")
	List<FacilityList> findByFundingClass(String classUri);	
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.infrastructure.FacilityList(" +
			   "       fac.acronym,    				" +
			   "       fn.name,    	 				" +
			   "       fac.id,    	 				" +
			   "       fund.acronym, 				" +
			   "       ffcl.uri,     				" +
			   "       fundcl.uri)   				" +
			   "  from Facility_Funding ff    					" +
			   "  join ff.theClass ffcl              		 	" +
			   "  join ffcl.scheme ffs                       	" +
			   "  join ff.funding fund  						" +
			   "  join fund.classes fundcls              		" +
			   "  join fundcls.theClass fundcl              	" +
			   "  join fundcl.scheme funds                   	" +	
			   "  join ff.facility fac  						" +
			   "  join fac.names fn              				" +
			   "  join ff.theClass cl              				" +	
			   " where cl.uri = ?1 AND ffs.uri='focusarea' AND funds.uri='origin' 	")
	List<FacilityList> findByLinkFacilityFundingClass(String classUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.infrastructure.FacilityList(" +
			   "       f2.acronym,   				" +
			   "       fn.name,    	 				" +
			   "       f2.id,    	 				" +
			   "       fund.acronym, 				" +
			   "       ffcl.uri,     				" +
			   "       fundcl.uri)   				" +
			   "  from Facility f    							" +			   
			   "  join f.facilities_facilities1 ff1  			" +
			   "  join ff1.theClass ff1c  						" +
			   "  join ff1.facility1 f1  						" +
			   "  join ff1.facility2 f2  						" +
			   "  join f2.names fn              				" +
			   "  join f2.facilities_fundings ff  				" +
			   "  join ff.theClass ffcl              		 	" +
			   "  join ffcl.scheme ffs                       	" +
			   "  join ff.funding fund              			" +
			   "  join fund.classes fundcls              		" +
			   "  join fundcls.theClass fundcl              	" +
			   "  join fundcl.scheme funds                   	" +				   
			   " where ff1c.uri = ?1 AND f1.acronym = ?2 AND ffs.uri='focusarea' AND funds.uri='origin'			")
	List<FacilityList> findByClassAndLinkFacility(String classUri, String facilityURI);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.infrastructure.FacilityList(" +
			   "       f.acronym,    " +
			   "       fn.name,    	 " +
			   "       f.id,    	 " +
			   "       fund.acronym, " +
			   "       ffcl.uri,     " +
			   "       fundcl.uri)   " +
			   "  from Facility f    							" +
			   "  join f.names fn              					" +
			   "  join f.facilities_fundings ff              	" +
			   "  join ff.theClass ffcl              		 	" +
			   "  join ffcl.scheme ffs                       	" +
			   "  join ff.funding fund                       	" +
			   "  join fund.classes fundcls                  	" +
			   "  join fundcls.theClass fundcl               	" +
			   "  join fundcl.scheme funds                   	" +			   
			   "  join f.classes fc  							" +
	   	       "  join fc.theClass cl 							" +
			   " where ffs.uri='focusarea' AND funds.uri='origin' AND f.acronym like ?1	")
	List<FacilityList> findByTitleOrAcronymOrDescription(String query);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select c.uri, count(c) 	" +
			   "  from Facility f    		" +
			   "  join f.classes fc  		" +
			   "  join fc.theClass c		" +
			   "  join c.scheme s			" +
			   "  where s.uri = ?1			" +
				" group by c                ")
	List<Object[]> countByFacilityClass(String schemeUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select c.uri, count(c) 	" +
			   "  from Facility f    	" +
			   "  join f.facilities_fundings ff  	" +
			   "  join ff.funding fund  			" +
			   "  join fund.classes fc  			" +
			   "  join fc.theClass c				" +
			   "  join c.scheme s					" +
			   "  where s.uri = ?1					" +
				" group by c                		")
	List<Object[]> countByFundingClass(String schemeUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select c.uri, count(c) 			" +
			   "  from Facility f    				" +
			   "  join f.facilities_fundings ff  	" +
			   "  join ff.theClass c  				" +
			   "  join c.scheme s					" +
			   "  where s.uri = ?1					" +
				" group by c                		")
	List<Object[]> countByLinkFacilityFundingClass(String schemeUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select c.uri, count(c) 	" +
			   "  from Facility f    												" +
			   "  join f.organisationUnits_facilities orgfac 						" +
			   "  join orgfac.organisationUnit o             						" +
			   "  join o.postalAddresses op                  						" +
			   "  join op.postalAddress pa                   						" +
			   "  join pa.country c                          						" +
			   "  group by c             ")
	List<Object[]> countByCountry();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.infrastructure.FacilityList(" +
			   "       	f.acronym,   " +
			   "       	f.id,    	 " +
			   "       	ffcl.uri," +
			   "		fundcl.uri)        " +
			   "  from Facility f    " +
			   "  join f.facilities_fundings ff  				" +
			   "  join ff.theClass ffcl							" +
			   "  join ffcl.scheme ffclsch	                 	" +
			   "  join ff.funding fund							" +
			   "  join fund.classes fundcls						" +
			   "  join fundcls.theClass fundcl					" +
			   "  join fundcl.scheme fundclsch                 	" +
			   " where ffcl.uri = ?1 AND fundcl.uri = ?2 AND ffclsch.uri = 'focusarea' AND fundclsch.uri='origin'")
	List<FacilityList> findByFocusAreaAndOrigin(String focusAreaUri, String originUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.infrastructure.FacilityList(" +
			   "       	f.acronym,   " +
			   "       	f.id,    	 " +
			   "       	ffcl.uri," +
			   "		fundcl.uri)        " +
			   "  from Facility f    " +
			   "  join f.facilities_fundings ff  				" +
			   "  join ff.theClass ffcl							" +
			   "  join ffcl.scheme ffclsch	                 	" +
			   "  join ff.funding fund							" +
			   "  join fund.classes fundcls						" +
			   "  join fundcls.theClass fundcl					" +
			   "  join fundcl.scheme fundclsch                 	" +
			   " where fundcl.uri = ?1 AND ffclsch.uri = 'focusarea' AND fundclsch.uri='origin'")
	List<FacilityList> findByOrigin(String originUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.infrastructure.FacilityList(" +
			   "       f2.acronym,   				" +
			   "       f2.id,    	 				" +
			   "       ffcl.uri,     				" +
			   "       fundcl.uri)   				" +
			   "  from Facility f    							" +			   
			   "  join f.facilities_facilities1 ff1  			" +
			   "  join ff1.theClass ff1c  						" +
			   "  join ff1.facility1 f1  						" +
			   "  join ff1.facility2 f2  						" +
			   "  join f2.names fn              				" +
			   "  join f2.facilities_fundings ff  				" +
			   "  join ff.theClass ffcl              		 	" +
			   "  join ffcl.scheme ffs                       	" +
			   "  join ff.funding fund              			" +
			   "  join fund.classes fundcls              		" +
			   "  join fundcls.theClass fundcl              	" +
			   "  join fundcl.scheme funds                   	" +				   
			   " where ff1c.uri = ?1 AND f1.acronym = ?2 AND ffcl.uri=?3 AND ffs.uri='focusarea' AND funds.uri='origin'			")
	List<FacilityList> findByCollaborationTypeAndLinkFacilityAndFocusArea(String collaborationUri, String facilityURI, String focusAreaURI);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.infrastructure.FacilityList(" +
			   "       f2.acronym,   				" +
			   "       f2.id,    	 				" +
			   "       ffcl.uri,     				" +
			   "       fundcl.uri)   				" +
			   "  from Facility f    							" +			   
			   "  join f.facilities_facilities1 ff1  			" +
			   "  join ff1.theClass ff1c  						" +
			   "  join ff1.facility1 f1  						" +
			   "  join ff1.facility2 f2  						" +
			   "  join f2.names fn              				" +
			   "  join f2.facilities_fundings ff  				" +
			   "  join ff.theClass ffcl              		 	" +
			   "  join ffcl.scheme ffs                       	" +
			   "  join ff.funding fund              			" +
			   "  join fund.classes fundcls              		" +
			   "  join fundcls.theClass fundcl              	" +
			   "  join fundcl.scheme funds                   	" +				   
			   " where ff1c.uri = ?1 AND f1.acronym = ?2 AND ffs.uri='focusarea' AND funds.uri='origin'			")
	List<FacilityList> findByCollaborationTypeAndLinkFacility(String collaborationUri, String facilityURI);
	
}

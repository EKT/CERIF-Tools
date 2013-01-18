/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.FederatedIdentifier_Class;
import gr.ekt.cerif.entities.link.Service_FederatedIdentifier;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author nhoussos
 *
 */
@Entity
@Table(name="cfFedId")
public class FederatedIdentifier implements CerifSecondLevelEntity {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3294630150204664144L;

	/**
	 * 
	 */
	public FederatedIdentifier() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param id
	 * @param instanceId
	 * @param fedId
	 * @param startDate
	 * @param endDate
	 * @param fedIds_classes
	 * @param services_fedids
	 */
	public FederatedIdentifier(Long id, Long instanceId, String fedId,
			Date startDate, Date endDate,
			Set<FederatedIdentifier_Class> fedIds_classes,
			Set<Service_FederatedIdentifier> services_fedids) {
		super();
		this.id = id;
		this.instanceId = instanceId;
		this.fedId = fedId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fedIds_classes = fedIds_classes;
		this.services_fedids = services_fedids;
	}

	/**
	 * The federated identifier database-internal unique id.
	 */
	@Id
	@Column(name="cfFedIdId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The instance id of the CERIF entity identified by the federated identifier (e.g. cfPersonId, cfProjId, cfOrgUnitId).
	 */
	@Column(name="cfInstId")
	private Long instanceId;
	
	/**
	 * The federated identifier value.
	 */
	@Column(name="cfFedId", length=4000)
	private String fedId;
	
	/**
	 * The start date.
	 */
	@Column(name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@Column(name="cfEndDate")
	private Date endDate;

	/**
	 * The classifications.
	 */
	@OneToMany(mappedBy="fedId")
	private Set<FederatedIdentifier_Class> fedIds_classes;	
	
	/**
	 * The services.
	 */
	@OneToMany(mappedBy="fedId")
	private Set<Service_FederatedIdentifier> services_fedids;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the instanceId
	 */
	public Long getInstanceId() {
		return instanceId;
	}

	/**
	 * @param instanceId the instanceId to set
	 */
	public void setInstanceId(Long instanceId) {
		this.instanceId = instanceId;
	}

	/**
	 * @return the fedId
	 */
	public String getFedId() {
		return fedId;
	}

	/**
	 * @param fedId the fedId to set
	 */
	public void setFedId(String fedId) {
		this.fedId = fedId;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Set<FederatedIdentifier_Class> getFedIds_classes() {
		return fedIds_classes;
	}
	
	public void setFedIds_classes(Set<FederatedIdentifier_Class> fedIds_classes) {
		this.fedIds_classes = fedIds_classes;
	}
	
	/**
	 * @return the services_fedids
	 */
	public Set<Service_FederatedIdentifier> getServices_fedids() {
		return services_fedids;
	}

	/**
	 * @param services_fedids the services_fedids to set
	 */
	public void setServices_fedids(Set<Service_FederatedIdentifier> services_fedids) {
		this.services_fedids = services_fedids;
	}
}

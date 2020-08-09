package com.sample.ecom.jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "T_CUSTOMER", schema = "C##_LOCAL_DB_USER")
@NamedQueries({ @NamedQuery(name = "CustomerEntity.countAll", query = "SELECT COUNT(x) FROM CustomerEntity x") })
@Where(clause = "DEL_IND IS NULL")
@DynamicInsert
@DynamicUpdate
public class CustomerEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "customer_Sequence", sequenceName = "CUSTOMER_SEQ", 
		allocationSize = 1, schema = "C##_LOCAL_DB_USER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_Sequence")
	@Column(name = "CUSTOMER_ID", nullable = false)
	private Long customerId;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "MOBILE_NUMBER", nullable = false)
	private Integer mobileNumber;
	
	@Column(name = "EMAIL", nullable = false)	
	private String email;
	
	@OneToMany(mappedBy = "customer", targetEntity = OrderEntity.class)
	private List<OrderEntity> orders;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}
	
}

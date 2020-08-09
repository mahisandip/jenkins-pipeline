package com.sample.ecom.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "T_ORDER", schema = "C##_LOCAL_DB_USER")
@NamedQueries({ @NamedQuery(name = "OrderEntity.countAll", query = "SELECT COUNT(x) FROM OrderEntity x") })
@Where(clause = "DEL_IND IS NULL")
@DynamicInsert
@DynamicUpdate
public class OrderEntity extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "orders_Sequence", sequenceName = "ORDERS_SEQ", 
		allocationSize = 1, schema = "C##_LOCAL_DB_USER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_Sequence")
	@Column(name = "ORDER_ID", nullable = false)
	private Long orderId;
	
	@Column(name = "ORDER_STATUS")
	private String orderStatus;
	
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	
	@Column(name = "SHIP_DATE")
	private Date shipDate;
	
	@Column(name = "CANCEL_DATE")
	private Date cancelDate;
	
	@Column(name = "CANCEL_REASON")
	private String cancelReason;
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", nullable = false)
	private CustomerEntity customer;
	
	@OneToOne
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", nullable = false)
	private ProductEntity product;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

}

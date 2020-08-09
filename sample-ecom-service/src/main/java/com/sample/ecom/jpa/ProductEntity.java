package com.sample.ecom.jpa;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "T_PRODUCT", schema = "C##_LOCAL_DB_USER")
@NamedQueries({ @NamedQuery(name = "ProductEntity.countAll", query = "SELECT COUNT(x) FROM ProductEntity x") })
@Where(clause = "DEL_IND IS NULL")
@DynamicInsert
@DynamicUpdate
public class ProductEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "product_Sequence", sequenceName = "PRODUCT_SEQ", 
		allocationSize = 1, schema = "C##_LOCAL_DB_USER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_Sequence")
	@Column(name = "PRODUCT_ID", nullable = false)
	private Long productId;
	
	@Column(name = "PRODUCT", nullable = false)
	private String product;
	
	@Column(name = "PRODUCED_BY")
	private String producedBy;
	
	@Column(name = "DEALER")
	private String dealer;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "MADE_IN")
	private String madeIn;
	
	@Column(name = "PRICE", nullable = false)
	private BigDecimal price;
	
	@Column(name = "QTY_IN_STOCK")
	private Integer qtyInStock;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProducedBy() {
		return producedBy;
	}

	public void setProducedBy(String producedBy) {
		this.producedBy = producedBy;
	}

	public String getDealer() {
		return dealer;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMadeIn() {
		return madeIn;
	}

	public void setMadeIn(String madeIn) {
		this.madeIn = madeIn;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQtyInStock() {
		return qtyInStock;
	}

	public void setQtyInStock(Integer qtyInStock) {
		this.qtyInStock = qtyInStock;
	}

}

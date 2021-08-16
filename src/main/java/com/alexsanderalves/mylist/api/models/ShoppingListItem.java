package com.alexsanderalves.mylist.api.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="shopping_items")
public class ShoppingListItem implements ViewEntity {

	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	private String name;
	private String belongsToList;
	private long createdAt;
	private BigDecimal price;
	private String currency;
	private long priceDate;
	private boolean recurring;
	private int recurringValue;
	private String recurringUnit;
	private int quantity;
	private String productType;
	private String productImageURL;
	private boolean countIn;
	private String annotations = "";
	private String labels;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getBelongsToList() {
		return belongsToList;
	}

	public void setBelongsToList(String belongsToList) {
		this.belongsToList = belongsToList;
	}

	@Override
	public String getViewText() {
		return getName();
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getAnnotations() {
		return annotations;
	}

	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public long getPriceDate() {
		return priceDate;
	}

	public void setPriceDate(long priceDate) {
		this.priceDate = priceDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductImageURL() {
		return productImageURL;
	}

	public void setProductImageURL(String productImageURL) {
		this.productImageURL = productImageURL;
	}

	public boolean isCountIn() {
		return countIn;
	}

	public void setCountIn(boolean countIn) {
		this.countIn = countIn;
	}

	public boolean isRecurring() {
		return recurring;
	}

	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}

	public int getRecurringValue() {
		return recurringValue;
	}

	public void setRecurringValue(int recurringValue) {
		this.recurringValue = recurringValue;
	}

	public String getRecurringUnit() {
		return recurringUnit;
	}

	public void setRecurringUnit(String recurringUnit) {
		this.recurringUnit = recurringUnit;
	}
	
}

package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

	private Long id;
	private Customer fkCustomerId;
	private Double totalPrice;
	private String datePlaced;
	private List<Item> ordersItems = new ArrayList<>();

	public Order() {

	}

	public Order(Customer fkCustomerId, Double totalPrice, String datePlaced, List<Item> ordersItems) {
		super();
		this.fkCustomerId = fkCustomerId;
		this.totalPrice = totalPrice;
		this.ordersItems = ordersItems;
	}

	public Order(Long id, Customer fkCustomerId, Double totalPrice, String datePlaced, List<Item> ordersItems) {
		super();
		this.id = id;
		this.fkCustomerId = fkCustomerId;
		this.totalPrice = totalPrice;
		this.ordersItems = ordersItems;
	}

	public Order(Customer fk_customer_id) {
		this.setFkCustomerId(fk_customer_id);
	}

	public Order(Long id, Customer fk_customer_id) {
		this.setId(id);
		this.setFkCustomerId(fk_customer_id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getFkCustomerId() {
		return fkCustomerId;
	}

	public void setFkCustomerId(Customer fkCustomerId) {
		this.fkCustomerId = fkCustomerId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDatePlaced() {
		return datePlaced;
	}

	public void setDatePlaced(String datePlaced) {
		this.datePlaced = datePlaced;
	}

	public List<Item> getOrdersItems() {
		return ordersItems;
	}

	public void setOrdersItems(List<Item> ordersItems) {
		this.ordersItems = ordersItems;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", fkCustomerId=" + fkCustomerId + ", totalPrice=" + totalPrice + ", datePlaced="
				+ datePlaced + ", ordersItems=" + ordersItems + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(datePlaced, fkCustomerId, id, ordersItems, totalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(datePlaced, other.datePlaced) && Objects.equals(fkCustomerId, other.fkCustomerId)
				&& Objects.equals(id, other.id) && Objects.equals(ordersItems, other.ordersItems)
				&& Objects.equals(totalPrice, other.totalPrice);
	}

}

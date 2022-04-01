package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

	private Long id;
	private Customer fkCustomerId;
	private Double totalPrice;
	private List<Item> ordersItems = new ArrayList<>();

	public Order() {

	}

	public Order(Customer fkCustomerId, Double totalPrice, List<Item> ordersItems) {
		super();
		this.fkCustomerId = fkCustomerId;
		this.totalPrice = totalPrice;
		this.ordersItems = ordersItems;
	}

	public Order(Long id, Customer fkCustomerId, List<Item> ordersItems, Double totalPrice) {
		super();
		this.id = id;
		this.fkCustomerId = fkCustomerId;
		this.totalPrice = totalPrice;
		this.ordersItems = ordersItems;
	}

	public Order(Long id, Customer fkCustomerId, Double totalPrice, List<Item> ordersItems) {
		super();
		this.id = id;
		this.fkCustomerId = fkCustomerId;
		this.totalPrice = totalPrice;
		this.ordersItems = ordersItems;
	}

	public Order(Customer fkCustomerId) {
		this.setFkCustomerId(fkCustomerId);
	}

	public Order(Long id, Customer fkCustomerId) {
		this.setId(id);
		this.setFkCustomerId(fkCustomerId);
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

	public List<Item> getOrdersItems() {
		return ordersItems;
	}

	public void setOrdersItems(List<Item> ordersItems) {
		this.ordersItems = ordersItems;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", fkCustomerId=" + fkCustomerId + ", totalPrice=" + totalPrice + ", ordersItems="
				+ ordersItems + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fkCustomerId, id, ordersItems, totalPrice);
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
		return Objects.equals(fkCustomerId, other.fkCustomerId) && Objects.equals(id, other.id)
				&& Objects.equals(ordersItems, other.ordersItems) && Objects.equals(totalPrice, other.totalPrice);
	}

}

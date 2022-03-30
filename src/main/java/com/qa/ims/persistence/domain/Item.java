package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	// fields
	private long id;
	private String itemName;
	private String itemCategory;
	private float price;

	// constructor without id
	public Item(String itemName, String itemCategory, float price, int stock) {
		super();
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.price = price;
	}

	// constructor with id
	public Item(int id, String itemName, String itemCategory, float price, int stock) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.price = price;
	}

	// getters & setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", itemCategory=" + itemCategory + ", price=" + price
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemCategory, itemName, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return id == other.id && Objects.equals(itemCategory, other.itemCategory)
				&& Objects.equals(itemName, other.itemName)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price);
	}

}

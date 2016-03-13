package com.erp.dto;

public class Product {
	
	private String productId;
	private String productName;
	private int itemsAvailable;
	private double price;
	private int ram;
	private int harddisk;
	private int processor;
	private int warranty;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getItemsAvailable() {
		return itemsAvailable;
	}
	public void setItemsAvailable(int itemsAvailable) {
		this.itemsAvailable = itemsAvailable;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getHarddisk() {
		return harddisk;
	}
	
	public void setHarddisk(int harddisk) {
		this.harddisk = harddisk;
	}
	
	public int getProcessor() {
		return processor;
	}
	
	public void setProcessor(int processor) {
		this.processor = processor;
	}
	
	public int getWarranty() {
		return warranty;
	}
	
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	
}

package net.codejava;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String productName;
	private float subtotal;
	private float shipping;
	private float tax;
	private float total;
	public OrderDetail(String productName, String subtotal, String shipping, String tax, String total) {
		super();
		this.productName = productName;
		this.subtotal = Float.parseFloat(subtotal);
		this.shipping =Float.parseFloat(shipping);
		this.tax = Float.parseFloat(tax);
		this.total = Float.parseFloat(total);
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSubtotal() {
		return String.format("%.2f",subtotal);
	}
	
	public String getShipping() {
		return String.format("%.2f",shipping);
	}
	
	public String getTax() {
		return String.format("%.2f",tax);
	}
	
	public String getTotal() {
		return String.format("%.2f",total);
	}
	
	
	
}

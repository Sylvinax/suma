package com.inventory;

import java.sql.Date;

public class Orders {
	
	private String orderid;
	private Date order_date;
	private String itemid;
	private int quantity;
	private String custid;
	private String warehouseid;
	public Orders(String orderid, Date order_date, String itemid, int quantity,
			String custid, String warehouseid) {
		super();
		this.orderid = orderid;
		this.order_date = order_date;
		this.itemid = itemid;
		this.quantity = quantity;
		this.custid = custid;
		this.warehouseid = warehouseid;
	}
	public Orders() {
		super();
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid;
	}
	 
	
	
	
	
	

}

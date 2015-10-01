package com.inventory;

import java.sql.Date;

public class Purchase 
{
	private String purchaseid;
	private Date purchase_date;
	private String itemid;
	private int quantity;
	private String vendorid;
	private String warehouseid;
	public Purchase(String purchaseid, Date purchase_date, String itemid,
			int quantity, String vendorid, String warehouseid) {
		super();
		this.purchaseid = purchaseid;
		this.purchase_date = purchase_date;
		this.itemid = itemid;
		this.quantity = quantity;
		this.vendorid = vendorid;
		this.warehouseid = warehouseid;
	}
	public Purchase() {
		super();
	}
	public String getPurchaseid() {
		return purchaseid;
	}
	public void setPurchaseid(String purchaseid) {
		this.purchaseid = purchaseid;
	}
	public Date getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
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
	public String getVendorid() {
		return vendorid;
	}
	public void setVendorid(String vendorid) {
		this.vendorid = vendorid;
	}
	public String getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid;
	}
	
	
	

}

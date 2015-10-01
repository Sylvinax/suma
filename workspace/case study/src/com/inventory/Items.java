package com.inventory;

public class Items 
{
	private String itemid;
	private String item_name;
	private double price;
	private String item_type;
	private String vendor_id;
	private int quantity;
	private String warehouseid;
	private String warehousename;
	private String vendor_name;
	
	public Items() {
		super();
	}

	public Items(String itemid, String item_name, double price,
			String item_type, String vendorid, int quantity,
			String warehouseid, String warehousename, String vendor_name) {
		super();
		this.itemid = itemid;
		this.item_name = item_name;
		this.price = price;
		this.item_type = item_type;
		this.vendor_id = vendorid;
		this.quantity = quantity;
		this.warehouseid = warehouseid;
		this.warehousename = warehousename;
		this.vendor_name = vendor_name;
	}


	public String getWarehousename() {
		return warehousename;
	}

	public void setWarehousename(String warehousename) {
		this.warehousename = warehousename;
	}

	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public String getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(String vendorid) {
		this.vendor_id = vendorid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	


	public String getWarehouseid() {
		return warehouseid;
	}


	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid;
	}


	@Override
	public String toString() {
		return "Items [itemid=" + itemid + ", item_name=" + item_name
				+ ", price=" + price + ", item_type=" + item_type
				+ ", vendorid=" + vendor_id + ", quantity=" + quantity + "]";
	}
	
	
	

}

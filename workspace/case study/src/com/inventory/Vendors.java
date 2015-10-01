package com.inventory;

public class Vendors {

		private String vendorID;
		private String vendor_name;
		private String address;
		private long phone_num;
		private String items_distributed;
		
		public String getVendorID() {
			return vendorID;
		}
		public void setVendorID(String vendorID) {
			this.vendorID = vendorID;
		}
		public String getVendor_name() {
			return vendor_name;
		}
		public void setVendor_name(String vendor_name) {
			this.vendor_name = vendor_name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getItems_distributed() {
			return items_distributed;
		}
		public void setItems_distributed(String items_distributed) {
			this.items_distributed = items_distributed;
		}
		public long getPhone_num() {
			return phone_num;
		}
		public void setPhone_num(long phone_num) {
			this.phone_num = phone_num;
		}
		
}

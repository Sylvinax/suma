package com.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class dropDown {

	public ArrayList<Items> items(HttpServletRequest request)
	{
		Connection con;
		ResultSet rs1=null;
		ArrayList<Items> list=new ArrayList<Items>();
		try {
			con=DBHelper.connect();

			String sql1="select itemID,item_name from items";
			PreparedStatement ps1=con.prepareStatement(sql1);

			rs1=ps1.executeQuery();
			while(rs1.next())
			{
				Items item=new Items();
				item.setItemid(rs1.getString(1));
				item.setItem_name(rs1.getString(2));
				list.add(item);
			}
			
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;		
	}

	public ArrayList<Customers> customers(HttpServletRequest request)
	{
		Connection con;
		ResultSet rs2=null;
		ArrayList<Customers> list=new ArrayList<Customers>();
		try {
			con=DBHelper.connect();

			String sql2="select custID,cust_name from customers";
			PreparedStatement ps2=con.prepareStatement(sql2);

			rs2=ps2.executeQuery();
			while(rs2.next())
			{
				Customers customer=new Customers();
				customer.setCustID(rs2.getString(1));
				customer.setCust_name(rs2.getString(2));
				list.add(customer);
			}
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;		
	}

	public ArrayList<Warehouse> warehouse(HttpServletRequest request)
	{
		Connection con;
		ResultSet rs3=null;
		ArrayList<Warehouse> list=new ArrayList<Warehouse>();
		try {
			con=DBHelper.connect();

			String sql3="select warehouseID, warehouse_name from warehouse ";
			PreparedStatement ps3=con.prepareStatement(sql3);

			rs3=ps3.executeQuery();
			while(rs3.next())
			{
				Warehouse warehouse=new Warehouse();
				warehouse.setWarehouseID(rs3.getString(1));
				warehouse.setWarehouse_name(rs3.getString(2));
				list.add(warehouse);
			}
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;		
	}

	public ArrayList<Vendors> vendors(HttpServletRequest request)
	{
		Connection con;
		ResultSet rs4=null;
		ArrayList<Vendors> list=new ArrayList<Vendors>();
		try {
			con=DBHelper.connect();

			String sql4="select vendorID, vendor_name from vendors ";
			PreparedStatement ps4=con.prepareStatement(sql4);

			rs4=ps4.executeQuery();
			while(rs4.next())
			{
				Vendors vendor=new Vendors();
				vendor.setVendorID(rs4.getString(1));
				vendor.setVendor_name(rs4.getString(2));
				list.add(vendor);
			}
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;		
	}

	public ArrayList<Items> itemsPurchase(HttpServletRequest request)
	{
		Connection con;
		ResultSet rs5=null;
		ArrayList<Items> list=new ArrayList<Items>();
		try {
			con=DBHelper.connect();

			String sql5="select unique i.itemID,i.item_name from items i, total_quantity t " +
			"where i.itemID=t.itemID  and t.quantity<5";
			PreparedStatement ps1=con.prepareStatement(sql5);

			rs5=ps1.executeQuery();
			while(rs5.next())
			{
				Items item=new Items();
				item.setItemid(rs5.getString(1));
				item.setItem_name(rs5.getString(2));
				list.add(item);
			}
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;		
	}

	public ArrayList<ItemType> item_type(HttpServletRequest request)
	{
		Connection con;
		ResultSet rs6=null;
		ArrayList<ItemType> list=new ArrayList<ItemType>();
		try {
			con=DBHelper.connect();

			String sql6="select item_type from item_type";
			PreparedStatement ps6=con.prepareStatement(sql6);
			
			rs6=ps6.executeQuery();
			while(rs6.next())
			{
				ItemType item_type=new ItemType();
				item_type.setItem_type(rs6.getString(1));
				list.add(item_type);
			}
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;		
	}
}

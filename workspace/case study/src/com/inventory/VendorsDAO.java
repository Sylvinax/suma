package com.inventory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class VendorsDAO {

	public int add_vendors(HttpServletRequest request)
	{
		Connection con;
		ResultSet rs1=null;
		String vendorID=null;
		int flag=0;

		try {
			con=DBHelper.connect();
			
			String sql2="select concat('V',max(substr(vendorid,2,3))+1) from vendors";
			PreparedStatement ps2=con.prepareStatement(sql2);
			rs1=ps2.executeQuery();
			if(rs1.next())
			{
				vendorID=rs1.getString(1);
			}
			

			String sql1="insert into vendors values (?,UPPER(?),?,?,?)";
			PreparedStatement ps1=con.prepareStatement(sql1);

			ps1.setString(1,vendorID);
			ps1.setString(2,request.getParameter("vendor_name"));
			ps1.setString(3,request.getParameter("vendor_addr"));
			ps1.setString(4,request.getParameter("vendor_phone"));
			ps1.setString(5,request.getParameter("item_dist"));
			flag=ps1.executeUpdate();
			con.close();


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public int delete_vendors(HttpServletRequest request)
	{
		int count=0;
		ResultSet rs=null;
		Connection con;
		try{
			con=DBHelper.connect();
			String vid = request.getParameter("vendorid");
			vid = vid.trim();
			String sql2="delete from vendors where vendorid=?";
			PreparedStatement ps=con.prepareStatement(sql2);
			ps.setString(1,vid);
			count=ps.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public Vendors read(HttpServletRequest request)
	{
		Vendors vendor=new Vendors();
		String vid=request.getParameter("vendorid");
		vid=vid.trim();

		String sql="select vendor_name,address,phone_num,items_distributed from vendors where vendorid=?";

		ResultSet rs=null;
		Connection con;
		try{
			con=DBHelper.connect();

			PreparedStatement s=con.prepareStatement(sql);
			s.setString(1,vid);

			rs=s.executeQuery();
			if(rs.next())
			{
				//DTO (Data Transfer Object) Convert ResultSet into Object
				vendor.setVendorID(vid);
				vendor.setVendor_name(rs.getString(1));
				vendor.setAddress(rs.getString(2));
				vendor.setPhone_num(rs.getLong(3));
				vendor.setItems_distributed(rs.getString(4));		
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vendor;

	}

	public int update(HttpServletRequest request,Vendors vendor)
	{
		int count=0;
		String vid=vendor.getVendorID();
		Connection con;
		try{
			con=DBHelper.connect();
			String sql="update vendors set vendor_name=?,address=?,phone_num=?,items_distributed=? where vendorid=?";
			PreparedStatement s=con.prepareStatement(sql);

			s.setString(1,request.getParameter("vendor_name"));
			s.setString(2,request.getParameter("address"));
			s.setString(3,request.getParameter("phone_num"));
			s.setString(4,request.getParameter("items_distributed"));
			s.setString(5,vid);

			count=s.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;

	}

	public Vendors search(HttpServletRequest request)
	{

		Connection con;
		ResultSet rs=null;
		Vendors vendor=new Vendors();
		try {
			con=DBHelper.connect();

			String vid=request.getParameter("vendor_name");	
			vid=vid.trim();
			String sql1="select * from vendors where vendor_name like UPPER(replace('%"+vid+"%','*',''))";
			PreparedStatement ps=con.prepareStatement(sql1);
			//ps.setString(1,vid);
			rs=ps.executeQuery();

			if(rs.next())
			{
				vendor.setVendorID(rs.getString(1));
				vendor.setVendor_name(rs.getString(2));
				vendor.setAddress(rs.getString(3));
				vendor.setPhone_num(rs.getLong(4));
				vendor.setItems_distributed(rs.getString(5));
			}

			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vendor;
	}
	
	public ArrayList<Vendors> displayvendors(HttpServletRequest request)
	{
		ArrayList<Vendors> list=new ArrayList<Vendors>();
		ResultSet rs;
		try{
			String sql="select * from vendors order by vendorid";
			
			
			Connection con;
			con=DBHelper.connect();
			PreparedStatement ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				//DTO (Data Transfer Object) Convert ResultSet into Object
				Vendors ven=new Vendors();
				ven.setVendorID(rs.getString(1));
				ven.setVendor_name(rs.getString(2));
				ven.setAddress(rs.getString(3));
				ven.setPhone_num(rs.getLong(4));
				ven.setItems_distributed(rs.getString(5));
				list.add(ven);
			}
		}
			//con.close();
		catch (ClassNotFoundException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		} 
		catch (SQLException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return list;
		}

}

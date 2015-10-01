package com.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class WarehouseDAO {

	public int add_warehouse(HttpServletRequest request)
	{
		Connection con;
		ResultSet rs1=null;
		String warehouseID=null;
		int flag=0;

		try {
			con=DBHelper.connect();
			
			String sql2="select concat('W',max(substr(warehouseid,2,3))+1) from warehouse";
			PreparedStatement ps2=con.prepareStatement(sql2);
			rs1=ps2.executeQuery();
			if(rs1.next())
			{
				warehouseID=rs1.getString(1);
			}

			String sql1="insert into warehouse values (?,UPPER(?),?,?)";
			PreparedStatement ps1=con.prepareStatement(sql1);
			
			ps1.setString(1,warehouseID);
			ps1.setString(2,request.getParameter("warehouse_name"));
			ps1.setString(3,request.getParameter("address"));
			ps1.setString(4,request.getParameter("capacity"));
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
	
	public int delete_warehouse(HttpServletRequest request)
	{
		int count=0;
		ResultSet rs=null;
		Connection con;
		try{
			con=DBHelper.connect();
			String wid = request.getParameter("warehouseid");
			wid = wid.trim();
			String sql2="delete from warehouse where warehouseid=?";
			PreparedStatement ps=con.prepareStatement(sql2);
			ps.setString(1,wid);
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
	
	public Warehouse read(HttpServletRequest request)
	{
		Warehouse warehouse=new Warehouse();
		String wid=request.getParameter("warehouseid");
		wid=wid.trim();
		
		String sql="select warehouse_name,address,capacity from warehouse where warehouseid=?";
		
		ResultSet rs=null;
		Connection con;
		try{
			con=DBHelper.connect();
			
			PreparedStatement s=con.prepareStatement(sql);
			s.setString(1,wid);
						
			rs=s.executeQuery();
			if(rs.next())
			{
				//DTO (Data Transfer Object) Convert ResultSet into Object
				warehouse.setWarehouseID(wid);
				warehouse.setWarehouse_name(rs.getString(1));
				warehouse.setAddress(rs.getString(2));
				warehouse.setCapacity(rs.getInt(3));
			}
			con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return warehouse;
			
	}
	
	public int update(HttpServletRequest request, Warehouse warehouse)
	{
		int count=0;
		String wid=warehouse.getWarehouseID();
		Connection con;
		try{
			con=DBHelper.connect();
			String sql="update warehouse set warehouse_name=?,address=?,capacity=? where warehouseid=?";
			PreparedStatement s=con.prepareStatement(sql);
			
			s.setString(1,request.getParameter("warehouse_name"));
			s.setString(2,request.getParameter("address"));
			s.setString(3,request.getParameter("capacity"));
			s.setString(4,wid);
			
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
	
	public Warehouse search(HttpServletRequest request)
	{

		Connection con;
		ResultSet rs=null;
		Warehouse warehouse=new Warehouse();
		try {
			con=DBHelper.connect();

			String wid=request.getParameter("warehouse_name");	
			wid=wid.trim();
			String sql1="select * from warehouse where warehouse_name like UPPER(replace('%"+wid+"%','*',''))";
			PreparedStatement ps=con.prepareStatement(sql1);
			//ps.setString(1,wid);
			rs=ps.executeQuery();

			if(rs.next())
			{
				warehouse.setWarehouseID(rs.getString(1));
				warehouse.setWarehouse_name(rs.getString(2));
				warehouse.setAddress(rs.getString(3));
				warehouse.setCapacity(rs.getInt(4));
			}

			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return warehouse;
	}
	
	public ArrayList<Warehouse> displaywarehouse(HttpServletRequest request)
	{
		ArrayList<Warehouse> list=new ArrayList<Warehouse>();
		ResultSet rs;
		try{
			String sql="select * from warehouse order by warehouseid";
			
			
			Connection con;
			con=DBHelper.connect();
			PreparedStatement ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				//DTO (Data Transfer Object) Convert ResultSet into Object
				Warehouse wh=new Warehouse();
				wh.setWarehouseID(rs.getString(1));
				wh.setWarehouse_name(rs.getString(2));
				wh.setAddress(rs.getString(3));
				wh.setCapacity(rs.getInt(4));
				list.add(wh);
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

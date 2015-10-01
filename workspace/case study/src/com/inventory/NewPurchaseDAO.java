package com.inventory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class NewPurchaseDAO {

	public int update_Purchase(HttpServletRequest request)
	{
		Connection con;
		ResultSet rs1=null;
		ResultSet rs=null;
		Date date=null;
		String purchaseID=null;
		int flag1=1;
		int flag=0;
		int count=0;
		try {
			con=DBHelper.connect();
			String iid=request.getParameter("items_dropdown");
			iid=iid.trim();
			String vid=request.getParameter("vendor_dropdown");
			vid=vid.trim();
			String wid=request.getParameter("warehouse_dropdown");
			wid=wid.trim();
			
			String sql6="select sysdate from dual";
			PreparedStatement ps6=con.prepareStatement(sql6);
			//System.out.println("before execution");
			rs=ps6.executeQuery();
			//System.out.println("after execution");
			if(rs.next())
			{
				date=rs.getDate(1);
			}
			System.out.println(date);
			
			String sql4="select concat('P',max(substr(purchaseid,2,4))+1) from purchase";
			PreparedStatement ps2=con.prepareStatement(sql4);
			rs1=ps2.executeQuery();
			if(rs1.next())
			{
				purchaseID=rs1.getString(1);
			}
			
			String sql="select quantity from total_quantity where itemID=? and warehouseID=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,iid);
			ps.setString(2,wid);
			flag1=ps.executeUpdate();
			if(flag1==1)
			{
				String sql1="insert into purchase values (?,?,?,?,?,?)";
				PreparedStatement ps1=con.prepareStatement(sql1);
				
				//String purchaseID=request.getParameter("purchase_id");
				
				ps1.setString(1,purchaseID);
				ps1.setDate(2,date);
				ps1.setString(3,iid);
				ps1.setString(4,request.getParameter("qty"));
				ps1.setString(5,vid);
				ps1.setString(6,wid);
				flag=ps1.executeUpdate();
				
				TotalQuantity dao=new TotalQuantity();
				count=dao.updatePurchaseQty(request, purchaseID);
			}
			else
			{
				String sql2="insert into purchase values (?,?,?,?,?,?)";
				PreparedStatement ps1=con.prepareStatement(sql2);
				
				ps1.setString(1,purchaseID);
				ps1.setString(2,request.getParameter("date"));
				ps1.setString(3,iid);
				ps1.setString(4,request.getParameter("qty"));
				ps1.setString(5,vid);
				ps1.setString(6,wid);
				flag=ps1.executeUpdate();
				
				String sql3="insert into total_quantity values(?,?,?)";
				PreparedStatement ps3=con.prepareStatement(sql3);
				ps3.setString(1,iid);
				ps3.setString(2,request.getParameter("qty"));
				ps3.setString(3,wid);
				count=ps3.executeUpdate();
			}
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
	
	public ArrayList<Purchase> displaypurchase(HttpServletRequest request)
	{
		ArrayList<Purchase> list=new ArrayList<Purchase>();
		ResultSet rs;
		try{
			String sql="select * from purchase";
			
			
			Connection con;
			con=DBHelper.connect();
			PreparedStatement ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				//DTO (Data Transfer Object) Convert ResultSet into Object
				Purchase pc=new Purchase();
				pc.setPurchaseid(rs.getString(1));
				pc.setPurchase_date(rs.getDate(2));
				pc.setItemid(rs.getString(3));
				pc.setQuantity(rs.getInt(4));
				pc.setVendorid(rs.getString(5));
				pc.setWarehouseid(rs.getString(6));
				list.add(pc);
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

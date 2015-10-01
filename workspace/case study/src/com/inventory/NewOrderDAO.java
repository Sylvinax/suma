package com.inventory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;

public class NewOrderDAO {

	public int update_Order(HttpServletRequest request)
	{
		Connection con;

		ResultSet rs=null;
		ResultSet rs1=null;
		String orderID=null;
		Date date=null;
		int flag=0;
		int count=0;
		int temp=0;
		try {
			con=DBHelper.connect();
			String iid=request.getParameter("items_dropdown");
			iid=iid.trim();
			String cid=request.getParameter("cust_dropdown");
			cid=cid.trim();
			String wid=request.getParameter("warehouse_dropdown");
			wid=wid.trim();
			int quantity=Integer.parseInt(request.getParameter("qty"));
			
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
			
			//System.out.println(temp);
			
			String sql2="select concat('O',max(substr(orderid,2,3))+1) from orders";
			PreparedStatement ps2=con.prepareStatement(sql2);
			rs1=ps2.executeQuery();
			if(rs1.next())
			{
				orderID=rs1.getString(1);
			}

			String sql="select quantity from total_quantity where itemid=? and warehouseid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,iid);
			ps.setString(2,wid);
			rs=ps.executeQuery();
			if(rs.next())
			{
				if(rs.getInt(1)>=quantity)
				{
					String sql1="insert into orders values (?,?,?,?,?,?)";
					PreparedStatement ps1=con.prepareStatement(sql1);

					//String orderID=request.getParameter("order_id");

					ps1.setString(1,orderID);
					ps1.setDate(2,date);
					ps1.setString(3,iid);
					ps1.setInt(4,quantity);
					ps1.setString(5,cid);
					ps1.setString(6,wid);
					flag=ps1.executeUpdate();

					TotalQuantity dao=new TotalQuantity();
					count=dao.updateQty(request, orderID);
					System.out.println("after updateOty");
				}
			}

			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	public ArrayList<Orders> displayorders(HttpServletRequest request)
	{
		ArrayList<Orders> list=new ArrayList<Orders>();
		ResultSet rs;
		try{
			String sql="select * from orders";
			
			
			Connection con;
			con=DBHelper.connect();
			PreparedStatement ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				//DTO (Data Transfer Object) Convert ResultSet into Object
				Orders ord=new Orders();
				ord.setOrderid(rs.getString(1));
				ord.setOrder_date(rs.getDate(2));
				ord.setItemid(rs.getString(3));
				ord.setQuantity(rs.getInt(4));
				ord.setCustid(rs.getString(5));
				ord.setWarehouseid(rs.getString(6));
				list.add(ord);
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

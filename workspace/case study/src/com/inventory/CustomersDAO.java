package com.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class CustomersDAO {

	public int add_customer(HttpServletRequest request)
	{
		Connection con;
		ResultSet rs1=null;
		String customerID=null;
		int flag=0;

		try {
			con=DBHelper.connect();

			String sql2="select concat('C',max(substr(custid,2,3))+1) from customers";
			PreparedStatement ps2=con.prepareStatement(sql2);
			rs1=ps2.executeQuery();
			if(rs1.next())
			{
				customerID=rs1.getString(1);
			}

			String sql1="insert into customers values (?,UPPER(?),?,?)";
			PreparedStatement ps1=con.prepareStatement(sql1);

			ps1.setString(1,customerID);
			ps1.setString(2,request.getParameter("customer_name"));
			ps1.setString(3,request.getParameter("customer_addr"));
			ps1.setString(4,request.getParameter("customer_phone"));
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

	public int delete_customer(HttpServletRequest request)
	{
		int count=0;
		ResultSet rs=null;
		Connection con;
		try{
			con=DBHelper.connect();
			String cid = request.getParameter("customerid");
			cid = cid.trim();
			String sql2="delete from customers where custid=?";
			PreparedStatement ps=con.prepareStatement(sql2);
			ps.setString(1,cid);
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

	public Customers read(HttpServletRequest request)
	{
		Customers customer=new Customers();
		String cid=request.getParameter("customerid");
		cid=cid.trim();

		String sql="select cust_name,address,phone_number from customers where custid=?";

		ResultSet rs=null;
		Connection con;
		try{
			con=DBHelper.connect();

			PreparedStatement s=con.prepareStatement(sql);
			s.setString(1,cid);

			rs=s.executeQuery();
			if(rs.next())
			{
				//DTO (Data Transfer Object) Convert ResultSet into Object
				customer.setCustID(cid);
				customer.setCust_name(rs.getString(1));
				customer.setAddress(rs.getString(2));
				customer.setPhone_number(rs.getLong(3));
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;

	}

	public int update(HttpServletRequest request,Customers customer)
	{
		int count=0;
		String cid=customer.getCustID();
		Connection con;
		try{
			con=DBHelper.connect();
			String sql="update customers set cust_name=UPPER(?),address=?,phone_number=? where custid=?";
			PreparedStatement s=con.prepareStatement(sql);

			s.setString(1,request.getParameter("customer_name"));
			s.setString(2,request.getParameter("address"));
			s.setString(3,request.getParameter("phone_num"));
			s.setString(4,cid);

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

	public Customers search(HttpServletRequest request)
	{

		Connection con;
		ResultSet rs=null;
		Customers customer=new Customers();
		try {
			con=DBHelper.connect();

			String cid=request.getParameter("cust_name");	
			System.out.println(cid);
			//cid=cid.trim();
			String sql1="select * from customers where cust_name like UPPER(replace('%"+cid+"%','*',''))";
			PreparedStatement ps=con.prepareStatement(sql1);
			// ps.setString(1,cid);
			rs=ps.executeQuery();

			if(rs.next()) 
			{
				customer.setCustID(rs.getString(1));
				customer.setCust_name(rs.getString(2));
				customer.setAddress(rs.getString(3));
				customer.setPhone_number(rs.getLong(4));
			}

			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	public ArrayList<Customers> displaycustomers(HttpServletRequest request)
	{
		ArrayList<Customers> list1=new ArrayList<Customers>();
		ResultSet rs;
		try{
			String sql="select * from customers order by custid";


			Connection con;
			con=DBHelper.connect();
			PreparedStatement ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				//DTO (Data Transfer Object) Convert ResultSet into Object
				Customers c1=new Customers();
				c1.setCustID(rs.getString(1));
				c1.setCust_name(rs.getString(2));
				c1.setAddress(rs.getString(3));
				c1.setPhone_number(rs.getLong(4));
				list1.add(c1);
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
		return list1;
	}
}

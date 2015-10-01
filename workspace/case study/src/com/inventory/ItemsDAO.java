package com.inventory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class ItemsDAO 
{
	public int add_items(HttpServletRequest request)
	{
		Connection con;
		int flag=0;
		int flag1=0;
		Date date=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		String itemID=null;
		int temp=0;
		try {
			System.out.println("Inside add_items");
			con=DBHelper.connect();
			String vid = request.getParameter("vendorsid");
			vid = vid.trim();
			String itm=request.getParameter("itemtype");
			itm=itm.trim();
			System.out.println(vid);
			
			String sql2="select concat('I',max(substr(itemid,2,4))+1) from items";
			PreparedStatement ps2=con.prepareStatement(sql2);
			rs1=ps2.executeQuery();
			if(rs1.next())
			{
				itemID=rs1.getString(1);
			}
			String sql="insert into items values(?,UPPER(?),?,?,?)";
			//Statement cs=con.createStatement();

			PreparedStatement ps=con.prepareStatement(sql);

			ps.setString(1,itemID);
			ps.setString(2,request.getParameter("itemname"));
			ps.setString(3,request.getParameter("itemprice"));
			ps.setString(4,vid);
			ps.setString(5,itm);
			flag=ps.executeUpdate();
			
			if(flag==1)
			{
				String sql1="insert into total_quantity values(?,?,?)";
				PreparedStatement ps1=con.prepareStatement(sql1);
				ps1.setString(1,itemID);
				ps1.setString(2,request.getParameter("quantiy"));
				ps1.setString(3,request.getParameter("warehouseid"));	
				flag1=ps1.executeUpdate();
			}
			
			
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

		return flag1;
	}


	public int delete(HttpServletRequest request)
	{
		int count=0;
		int count1=0;
		ResultSet rs=null;
		Connection con;
		try{
			con=DBHelper.connect();
			String iid = request.getParameter("itemid");
			iid = iid.trim();
			
			String sql1="delete from total_quantity where itemid=?";
			PreparedStatement ps1=con.prepareStatement(sql1);
			ps1.setString(1,iid);
			count1=ps1.executeUpdate();
			if(count1==1)
			{
				String sql="delete from items where itemid=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,iid);
				count=ps.executeUpdate();
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

	public Items read(HttpServletRequest request)
	{
		Items itm=new Items();
		String iid=request.getParameter("itemid");
		iid=iid.trim();

		String sql="select itemid,item_name,price,item_type,vendorID from items where itemid=?";

		ResultSet rs=null;
		Connection con;
		try{
			con=DBHelper.connect();

			PreparedStatement s=con.prepareStatement(sql);
			s.setString(1,iid);

			rs=s.executeQuery();
			if(rs.next())
			{
				//DTO (Data Transfer Object) Convert ResultSet into Object
				itm.setItemid(iid);
				itm.setItem_name(rs.getString(2));
				itm.setPrice(rs.getDouble(3));
				itm.setItem_type(rs.getString(4));
				itm.setVendor_id(rs.getString(5));

			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itm;

	}

	public int update(HttpServletRequest request,Items itm)
	{
		int count=0;
		String iid=itm.getItemid();
		Connection con;
		try{
			con=DBHelper.connect();
			String sql="update items set item_name=?,price=?,item_type=?,vendorid=? where itemid=?";
			PreparedStatement s=con.prepareStatement(sql);



			s.setString(1,request.getParameter("itemname"));
			s.setString(2,request.getParameter("itemprice"));
			s.setString(3,request.getParameter("itemtype"));
			s.setString(4,request.getParameter("vendorid"));
			s.setString(5,iid);

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

	public ArrayList<Items> search(HttpServletRequest request)
	{
		ResultSet rs=null;
		//int flag=0;
		ArrayList<Items> list=new ArrayList<Items>();
		Connection con;
		CallableStatement stmt=null;
		String iid=null;
		Items itm=new Items();
		try {
			con=DBHelper.connect();
			String iname=request.getParameter("item_name");
			String sql="select itemid from items where item_name like UPPER(replace('%"+iname+"%','*',''))";
			
			PreparedStatement ps1=con.prepareStatement(sql);
			//ps1.setString(1,iname);
			rs=ps1.executeQuery();
			while(rs.next())
			{
				itm=new Items();
				iid=rs.getString(1);
				String sql1="{call total_qty(?,?,?,?,?,?)}";
				stmt=con.prepareCall(sql1);
				stmt.setString(1, iid);
				stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
				stmt.registerOutParameter(3, java.sql.Types.DOUBLE);
				stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
				stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
				stmt.registerOutParameter(6, java.sql.Types.INTEGER);
				stmt.execute();
				itm.setItemid(iid);
				itm.setItem_name(stmt.getString(2));
				itm.setPrice(stmt.getDouble(3));
				itm.setItem_type(stmt.getString(4));
				itm.setVendor_id(stmt.getString(5));
				itm.setQuantity(stmt.getInt(6));
			
				list.add(itm);
				
			}
			
			/*String sql1="{call total_qty(?,?,?,?,?,?)}";
			stmt=con.prepareCall(sql1);
			stmt.setString(1, iid);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(3, java.sql.Types.DOUBLE);
			stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(6, java.sql.Types.INTEGER);
			stmt.execute();
			itm.setItemid(iid);
			itm.setItem_name(stmt.getString(2));
			itm.setPrice(stmt.getDouble(3));
			itm.setItem_type(stmt.getString(4));
			itm.setVendor_id(stmt.getString(5));
			itm.setQuantity(stmt.getInt(6));*/
		

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
	
	public ArrayList<Items> displayitems(HttpServletRequest request)
	{
		ArrayList<Items> list=new ArrayList<Items>();
		ResultSet rs=null;
		try{
			String sql="select i.itemid,i.item_name,i.price,i.vendorid,i.item_type,t.quantity,t.warehouseid from items i,total_quantity t where i.itemid=t.itemid and i.itemid in (select itemid from total_quantity) order by itemid";
			
			
			Connection con;
			con=DBHelper.connect();
			PreparedStatement ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				//DTO (Data Transfer Object) Convert ResultSet into Object
				Items itm=new Items();
				itm.setItemid(rs.getString(1));
				itm.setItem_name(rs.getString(2));
				itm.setPrice(rs.getDouble(3));
				itm.setVendor_id(rs.getString(4));
				itm.setItem_type(rs.getString(5));
				itm.setQuantity(rs.getInt(6));
				itm.setWarehouseid(rs.getString(7));
				list.add(itm);
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
	
	public ArrayList<Items> sortitems(HttpServletRequest request)
	{
		ArrayList<Items> list=new ArrayList<Items>();
		ResultSet rs=null;
		try{
			String sql="select i.itemid,i.item_name,i.price,i.vendorid,i.item_type,t.quantity,t.warehouseid from items i,total_quantity t where i.itemid=t.itemid and i.itemid in (select itemid from total_quantity) order by upper(item_name)";
			Connection con;
			con=DBHelper.connect();
			PreparedStatement ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				//DTO (Data Transfer Object) Convert ResultSet into Object
				Items itm=new Items();
				itm.setItemid(rs.getString(1));
				itm.setItem_name(rs.getString(2));
				itm.setPrice(rs.getDouble(3));
				itm.setVendor_id(rs.getString(4));
				itm.setItem_type(rs.getString(5));
				itm.setQuantity(rs.getInt(6));
				itm.setWarehouseid(rs.getString(7));
				list.add(itm);
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
	
	public ArrayList<Items> displaybyvendorid(HttpServletRequest request)
	{
		ArrayList<Items> list=new ArrayList<Items>();
		String vid = request.getParameter("vendorsid");
		vid = vid.trim();
		ResultSet rs;
		try{
			String sql="select i.itemid,i.item_name,i.price,i.item_type,i.vendorid,v.vendor_name from items i,vendors v where i.vendorid=v.vendorid and v.vendorid=?";
			Connection con;
			con=DBHelper.connect();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, vid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				//DTO (Data Transfer Object) Convert ResultSet into Object
				Items itm=new Items();
				itm.setItemid(rs.getString(1));
				itm.setItem_name(rs.getString(2));
				itm.setPrice(rs.getDouble(3));
				itm.setItem_type(rs.getString(4));
				itm.setVendor_id(rs.getString(5));
				itm.setVendor_name(rs.getString(6));
				list.add(itm);
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
	
	public ArrayList<Items> displaybywarehouseid(HttpServletRequest request)
	{
		ArrayList<Items> list=new ArrayList<Items>();
		String wid = request.getParameter("warehouseid");
		wid = wid.trim();
		ResultSet rs;
		try{
			String sql="select i.itemid,i.item_name,i.price,i.item_type,i.vendorid,t.warehouseid,w.warehouse_name from items i,total_quantity t,warehouse w where i.itemid=t.itemid and t.warehouseid=w.warehouseid and t.warehouseid=?";
			Connection con;
			con=DBHelper.connect();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, wid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				//DTO (Data Transfer Object) Convert ResultSet into Object
				Items itm=new Items();
				itm.setItemid(rs.getString(1));
				itm.setItem_name(rs.getString(2));
				itm.setPrice(rs.getDouble(3));
				itm.setItem_type(rs.getString(4));
				itm.setVendor_id(rs.getString(5));
				itm.setWarehouseid(rs.getString(6));
				itm.setWarehousename(rs.getString(7));
				
				list.add(itm);
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
	
	
	public ArrayList<Items> displaybyitemtype(HttpServletRequest request)
	{
		ArrayList<Items> list=new ArrayList<Items>();
		String itype = request.getParameter("item_type");
		itype = itype.trim();
		ResultSet rs;
		try{
			String sql="select * from items where item_type=?";
			Connection con;
			con=DBHelper.connect();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, itype);
			rs=ps.executeQuery();
			while(rs.next())
			{
				//DTO (Data Transfer Object) Convert ResultSet into Object
				Items itm=new Items();
				itm.setItemid(rs.getString(1));
				itm.setItem_name(rs.getString(2));
				itm.setPrice(rs.getDouble(3));
				itm.setVendor_id(rs.getString(4));
				itm.setItem_type(rs.getString(5));
				list.add(itm);
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






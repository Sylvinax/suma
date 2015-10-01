package com.inventory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class TotalQuantity {

	public int updateQty(HttpServletRequest request, String OrdID)
	{
		Connection con, con2;
		int flag=0;
		ResultSet rs=null;

		try {
			con=DBHelper.connect();
			con2=DBHelper.connect();
			CallableStatement stmt=null;

			String sql1="select itemID, quantity, warehouseID from orders where orderID=?";
			PreparedStatement ps1=con.prepareStatement(sql1);
			ps1.setString(1,OrdID);
			rs=ps1.executeQuery();
			String iid=null;
			int qty=0;
			String wid=null;
			if(rs.next())
			{
				iid=rs.getString(1);
				qty=rs.getInt(2);
				wid=rs.getString(3);
			}
			con.close();

			String sql2="{call updated_qty (?,?,?)}";
			stmt=con2.prepareCall(sql2);
			stmt.setString(1, iid);
			stmt.setInt(2, qty);
			stmt.setString(3,wid);
			stmt.execute();
			flag=1;
			stmt.close();

			con2.close();


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public int updatePurchaseQty(HttpServletRequest request, String PurID)
	{
		Connection con, con2;
		int flag=0;
		ResultSet rs=null;

		try {
			con=DBHelper.connect();
			con2=DBHelper.connect();
			CallableStatement stmt=null;

			String sql1="select itemID, quantity, warehouseID from purchase where purchaseID=?";
			PreparedStatement ps1=con.prepareStatement(sql1);
			ps1.setString(1,PurID);
			rs=ps1.executeQuery();
			String iid=null;
			int qty=0;
			String wid=null;
			if(rs.next())
			{
				iid=rs.getString(1);
				qty=rs.getInt(2);
				wid=rs.getString(3);
			}
			con.close();

			String sql2="{call purchase_qty (?,?,?)}";
			stmt=con2.prepareCall(sql2);
			stmt.setString(1, iid);
			stmt.setInt(2, qty);
			stmt.setString(3,wid);
			stmt.execute();
			flag=1;
			stmt.close();
			con2.close();


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}

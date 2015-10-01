package com.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

 

public class UserIdDAO {

	public int validate(HttpServletRequest request)
	{
		Connection con;
		int flag=0;
		ResultSet rs=null;
		try {
			con=DBHelper.connect();
			
			String sql="select * from login where user_name=? and password=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,request.getParameter("userid"));
			ps.setString(2,request.getParameter("password"));
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				if(rs.getString(3).equalsIgnoreCase("admin"))
				{
					flag=1;
				}
				else
				{
					flag=2;
				}
			}
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
}

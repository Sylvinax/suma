package com.inventory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Items itm=new Items();
	Vendors vendor=new Vendors();
	Warehouse warehouse=new Warehouse();
	Customers customer=new Customers();
	/**
	 * Default constructor. 
	 */
	public MainServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String str=request.getParameter("command");
		/*For login*/
		if(str.startsWith("LOGIN"))
		{
			UserIdDAO dao=new UserIdDAO();
			int flag=dao.validate(request);

			if(flag==1)
			{
				RequestDispatcher rd1=getServletContext().getRequestDispatcher("/admin_page.jsp");
				
				rd1.forward(request, response);


			}
			else if(flag==2)
			{
				RequestDispatcher rd1=getServletContext().getRequestDispatcher("/user_page.jsp");
				
				rd1.forward(request, response);	
			}
			else
			{
				RequestDispatcher rd1=getServletContext().getRequestDispatcher("/login_error.jsp");
				rd1.forward(request, response);	
			}
		}
		/*to go to new order page(admin)*/
		if(str.startsWith("NEW ORDER"))
		{
			dropDown obj=new dropDown();
			ArrayList<Items> list=new ArrayList<Items>();
			ArrayList<Customers> list1=new ArrayList<Customers>();
			ArrayList<Warehouse> list2=new ArrayList<Warehouse>();
			list=obj.items(request);
			list1=obj.customers(request);
			list2=obj.warehouse(request);
			RequestDispatcher rd2=getServletContext().getRequestDispatcher("/newOrder.jsp");
			request.setAttribute("model1", list );
			request.setAttribute("model5", list1 );
			request.setAttribute("model4", list2 );
			rd2.forward(request, response);	
			
		}
		/*to go to new purchase page(admin)*/
		if(str.startsWith("NEW PURCHASE"))
		{
			dropDown obj=new dropDown();
			ArrayList<Items> list=new ArrayList<Items>();
			ArrayList<Vendors> list1=new ArrayList<Vendors>();
			ArrayList<Warehouse> list2=new ArrayList<Warehouse>();
			list=obj.itemsPurchase(request);
			list1=obj.vendors(request);
			list2=obj.warehouse(request);
			RequestDispatcher rd2=getServletContext().getRequestDispatcher("/newPurchase.jsp");
			request.setAttribute("model1", list );
			request.setAttribute("model5", list1 );
			request.setAttribute("model6", list2 );
			rd2.forward(request, response);	
			
		}
		/*to go to items page(admin)*/
		if(str.startsWith("ITEMS"))
		{
			RequestDispatcher rd2=getServletContext().getRequestDispatcher("/items.jsp");
			rd2.forward(request, response);		
		}
		/*to go to vendors page(admin)*/
		if(str.startsWith("VENDORS"))
		{
			RequestDispatcher rd2=getServletContext().getRequestDispatcher("/vendors.jsp");
			rd2.forward(request, response);		
		}
		/*to go to warehouse page(admin)*/
		if(str.startsWith("WAREHOUSE"))
		{
			RequestDispatcher rd2=getServletContext().getRequestDispatcher("/warehouse.jsp");
			rd2.forward(request, response);		
		}
		/*to go to customers page(admin)*/
		if(str.startsWith("CUSTOMERS"))
		{
			RequestDispatcher rd2=getServletContext().getRequestDispatcher("/customers.jsp");
			rd2.forward(request, response);		
		}
		/*to go to items page(user)*/
		if(str.startsWith(" ITEMS"))
		{
			RequestDispatcher rd2=getServletContext().getRequestDispatcher("/items_user.jsp");
			rd2.forward(request, response);		
		}
		/*to go to vendors page(user)*/
		if(str.startsWith(" VENDORS"))
		{
			RequestDispatcher rd2=getServletContext().getRequestDispatcher("/vendors_user.jsp");
			rd2.forward(request, response);		
		}
		/*to go to warehouse page(user)*/
		if(str.startsWith(" WAREHOUSE"))
		{
			RequestDispatcher rd2=getServletContext().getRequestDispatcher("/warehouse_user.jsp");
			rd2.forward(request, response);		
		}
		/*to go to customers page(user)*/
		if(str.startsWith(" CUSTOMERS"))
		{
			RequestDispatcher rd2=getServletContext().getRequestDispatcher("/customers_user.jsp");
			rd2.forward(request, response);		
		}
		/*to add new item*/
		if(str.startsWith("ADD NEW ITEM"))
		{
			dropDown obj=new dropDown();
			ArrayList<Items> list=new ArrayList<Items>();
			ArrayList<Vendors> list1=new ArrayList<Vendors>();
			ArrayList<Customers> list2=new ArrayList<Customers>();
			ArrayList<Warehouse> list3=new ArrayList<Warehouse>();
			ArrayList<ItemType> list4=new ArrayList<ItemType>();
			list=obj.items(request);
			list1=obj.vendors(request);
			list2=obj.customers(request);
			list3=obj.warehouse(request);
			list4=obj.item_type(request);
			RequestDispatcher rd1=request.getRequestDispatcher("/add_items.jsp");
			request.setAttribute("model10", list );
			request.setAttribute("model11", list1 );
			request.setAttribute("model12", list2 );
			request.setAttribute("model13", list3 );
			request.setAttribute("model14", list4 );
			rd1.forward(request,response);	
		}
		/*to delete an item*/
		if(str.startsWith("DELETE AN ITEM"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/delete_items.jsp");
			dropDown obj=new dropDown();
			ArrayList<Items> list=new ArrayList<Items>();
			list=obj.items(request);
			request.setAttribute("model10", list );
			rd1.forward(request,response);	
		}
		/*to modify an item*/
		if(str.startsWith("MODIFY AN ITEM"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/modify_items.jsp");
			dropDown obj=new dropDown();
			ArrayList<Items> list=new ArrayList<Items>();
			list=obj.items(request);
			request.setAttribute("model10", list );
			rd1.forward(request,response);	
		}
		/*to view all items*/
		if(str.startsWith("VIEW ALL ITEMS"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/view_items.jsp");
			dropDown obj=new dropDown();
			ArrayList<Warehouse> list3=new ArrayList<Warehouse>();
			ArrayList<ItemType> list4=new ArrayList<ItemType>();
			ArrayList<Vendors> list1=new ArrayList<Vendors>();
			list1=obj.vendors(request);
			list3=obj.warehouse(request);
			list4=obj.item_type(request);
			request.setAttribute("model11", list1 );
			request.setAttribute("model13", list3 );
			request.setAttribute("model14", list4 );
			rd1.forward(request,response);	
		}
		/*to search an item*/
		if(str.startsWith("SEARCH AN ITEM"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/search_items.jsp");
			rd1.forward(request,response);	
		}
		/*to add new vendor*/
		if(str.startsWith("ADD NEW VENDOR"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/add_vendor.jsp");
			rd1.forward(request,response);	
		}
		/*to delete a vendor*/
		if(str.startsWith("DELETE A VENDOR"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/delete_vendor.jsp");
			dropDown obj=new dropDown();
			ArrayList<Vendors> list=new ArrayList<Vendors>();
			list=obj.vendors(request);
			request.setAttribute("model10", list );
			rd1.forward(request,response);	
		}
		/*to modify a vendor*/
		if(str.startsWith("MODIFY A VENDOR"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/modify_vendor.jsp");
			dropDown obj=new dropDown();
			ArrayList<Vendors> list=new ArrayList<Vendors>();
			list=obj.vendors(request);
			request.setAttribute("model10", list );
			rd1.forward(request,response);	
		}
		/*to view all vendors*/
		if(str.startsWith("VIEW ALL VENDORS"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/view_vendors.jsp");
			rd1.forward(request,response);	
		}
		/*to search a vendor*/
		if(str.startsWith("SEARCH A VENDOR"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/search_vendor.jsp");
			rd1.forward(request,response);	
		}
		/*to add new warehouse*/
		if(str.startsWith("ADD NEW WAREHOUSE"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/add_warehouse.jsp");
			rd1.forward(request,response);	
		}
		/*to delete a warehouse*/
		if(str.startsWith("DELETE A WAREHOUSE"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/delete_warehouse.jsp");
			dropDown obj=new dropDown();
			ArrayList<Warehouse> list=new ArrayList<Warehouse>();
			list=obj.warehouse(request);
			request.setAttribute("model10", list );
			rd1.forward(request,response);	
		}
		/*to modify a warehouse*/
		if(str.startsWith("MODIFY A WAREHOUSE"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/modify_warehouse.jsp");
			dropDown obj=new dropDown();
			ArrayList<Warehouse> list=new ArrayList<Warehouse>();
			list=obj.warehouse(request);
			request.setAttribute("model10", list );
			rd1.forward(request,response);	
		}
		/*to view all warehouses*/
		if(str.startsWith("VIEW ALL WAREHOUSES"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/view_warehouse.jsp");
			rd1.forward(request,response);	
		}
		/*to search a warehouse*/
		if(str.startsWith("SEARCH A WAREHOUSE"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/search_warehouse.jsp");
			rd1.forward(request,response);	
		}
		/*to add new customer*/
		if(str.startsWith("ADD NEW CUSTOMER"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/add_customer.jsp");
			rd1.forward(request,response);	
		}
		/*to delete a customer*/
		if(str.startsWith("DELETE A CUSTOMER"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/delete_customer.jsp");
			dropDown obj=new dropDown();
			ArrayList<Customers> list=new ArrayList<Customers>();
			list=obj.customers(request);
			request.setAttribute("model10", list );
			rd1.forward(request,response);	
		}
		/*to modify a customer*/
		if(str.startsWith("MODIFY A CUSTOMER"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/modify_customer.jsp");
			dropDown obj=new dropDown();
			ArrayList<Customers> list=new ArrayList<Customers>();
			list=obj.customers(request);
			request.setAttribute("model10", list );
			rd1.forward(request,response);	
		}
		/*to view all customer*/
		if(str.startsWith("VIEW ALL CUSTOMERS"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/view_customer.jsp");
			rd1.forward(request,response);	
		}
		
		if(str.startsWith("SEARCH A CUSTOMER"))
		{
			RequestDispatcher rd1=request.getRequestDispatcher("/search_customer.jsp");
			rd1.forward(request,response);	
		}
		
		
		
		/*Place new order*/
		if(str.startsWith("ENTER"))
		{
				dropDown obj=new dropDown();
				ArrayList<Items> list=new ArrayList<Items>();
				ArrayList<Customers> list1=new ArrayList<Customers>();
				ArrayList<Warehouse> list2=new ArrayList<Warehouse>();
				list=obj.items(request);
				list1=obj.customers(request);
				list2=obj.warehouse(request);
			NewOrderDAO dao2=new NewOrderDAO();
			int flag2=dao2.update_Order(request);
			if(flag2==1)
			{
				RequestDispatcher rd2=getServletContext().getRequestDispatcher("/newOrder.jsp");
				request.setAttribute("model1", list );
				request.setAttribute("model5", list1 );
				request.setAttribute("model4", list2 );
				request.setAttribute("model2", flag2+ " order placed" );
				rd2.forward(request, response);	
			}
			else
			{
				RequestDispatcher rd2=getServletContext().getRequestDispatcher("/order_error.jsp");
				request.setAttribute("model1", list );
				request.setAttribute("model5", list1 );
				request.setAttribute("model4", list2 );
				rd2.forward(request, response);	
			}
		}
		
		/*Place new purchase*/
		if(str.startsWith("PURCHASE"))
		{
				dropDown obj=new dropDown();
				ArrayList<Items> list=new ArrayList<Items>();
				ArrayList<Vendors> list1=new ArrayList<Vendors>();
				ArrayList<Warehouse> list2=new ArrayList<Warehouse>();
				list=obj.itemsPurchase(request);
				list1=obj.vendors(request);
				list2=obj.warehouse(request);
			NewPurchaseDAO dao3=new NewPurchaseDAO();
			int flag3=dao3.update_Purchase(request);
			RequestDispatcher rd3=getServletContext().getRequestDispatcher("/newPurchase.jsp");
			request.setAttribute("model1", list );
			request.setAttribute("model5", list1 );
			request.setAttribute("model6", list2 );
			request.setAttribute("model3", flag3+ " purchase placed");
			rd3.forward(request, response);
		}
		
		/*Add item*/
		if(str.startsWith("ADD ITEM"))
		{
			dropDown obj=new dropDown();
			ArrayList<Items> list=new ArrayList<Items>();
			ArrayList<Vendors> list1=new ArrayList<Vendors>();
			ArrayList<Customers> list2=new ArrayList<Customers>();
			ArrayList<Warehouse> list3=new ArrayList<Warehouse>();
			ArrayList<ItemType> list4=new ArrayList<ItemType>();
			list=obj.items(request);
			list1=obj.vendors(request);
			list2=obj.customers(request);
			list3=obj.warehouse(request);
			list4=obj.item_type(request);
				int flag1;
				ItemsDAO dao1=new ItemsDAO();
				flag1=dao1.add_items(request);
				RequestDispatcher rd1=request.getRequestDispatcher("/add_items.jsp");
				request.setAttribute("model10", list );
				request.setAttribute("model11", list1 );
				request.setAttribute("model12", list2 );
				request.setAttribute("model13", list3 );
				request.setAttribute("model14", list4 );
				request.setAttribute("model1", flag1+ " item added");
				rd1.forward(request,response);	
		}
		/*Delete item*/
		if(str.startsWith("DELETE ITEM"))
		{
			ItemsDAO dao2=new ItemsDAO();

			int flag=dao2.delete(request);
			dropDown obj=new dropDown();
			ArrayList<Items> list=new ArrayList<Items>();
			list=obj.items(request);
			if(flag==1)
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/delete_items.jsp");
				request.setAttribute("model2", flag+ " item deleted");
				request.setAttribute("model10", list );
				rd1.forward(request,response);
			}
			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/delete_items.jsp");
				request.setAttribute("model10", list );
				request.setAttribute("model2"," Reference of this item exists in order/purchase. It cannot be deleted.");
				rd1.forward(request,response);
			}
		}
		/*Read item in order to modify*/
		if(str.startsWith("READ ITEM"))
		{
			ItemsDAO dao=new ItemsDAO();
			itm=dao.read(request);
			dropDown obj=new dropDown();
			ArrayList<Items> list=new ArrayList<Items>();
			list=obj.items(request);
			RequestDispatcher rd=request.getRequestDispatcher("/modify_items.jsp");
			request.setAttribute("model2", itm);
			request.setAttribute("model10", list );
			rd.forward(request, response);
		}
		/*update item*/
		if(str.startsWith("UPDATE ITEM"))
		{

			ItemsDAO dao1=new ItemsDAO();
			int flag=dao1.update(request,itm);
			dropDown obj=new dropDown();
			ArrayList<Items> list=new ArrayList<Items>();
			list=obj.items(request);
			if(flag==1)
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/modify_items.jsp");
				request.setAttribute("model1", flag+ " item updated");
				request.setAttribute("model10", list );
				rd1.forward(request,response);

			}
			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/modify_items.jsp");
				request.setAttribute("model1","Item type does not exist or Vendor ID does not exist");
				request.setAttribute("model10", list );
				rd1.forward(request,response);
			}
		}
		/*to search an item*/
		if(str.startsWith("SEARCH ITEM"))
		{
			ResultSet rs;
			ItemsDAO dao1=new ItemsDAO();
			//ItemsDAO dao=new ItemsDAO();
			ArrayList<Items> list=new ArrayList<Items>();
			//list=dao.displayitems(request);
			dropDown obj=new dropDown();
			//ArrayList<Warehouse> list3=new ArrayList<Warehouse>();
			//ArrayList<ItemType> list4=new ArrayList<ItemType>();
			//ArrayList<Vendors> list1=new ArrayList<Vendors>();
			//list1=obj.vendors(request);
			//list3=obj.warehouse(request);
			//list4=obj.item_type(request);
		
			//ItemsDAO dao1=new ItemsDAO();
			list=dao1.search(request);

			//System.out.println(rs.toString());

			if(list.isEmpty())
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/search_items.jsp");
				request.setAttribute("model3","Sorry!Item does not Exist");
				rd1.forward(request,response);
				/*RequestDispatcher rd1=request.getRequestDispatcher("/searchdetails.jsp");
				request.setAttribute("model3",itm);
				rd1.forward(request,response);*/
			}
			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/searchdetails.jsp");
				request.setAttribute("model3",list);
				rd1.forward(request,response);
				/*RequestDispatcher rd1=request.getRequestDispatcher("/search_items.jsp");
				request.setAttribute("model3","Sorry!Item does not Exist");
				rd1.forward(request,response);*/
			}		
		}
		/*to add new vendor*/
		if(str.startsWith("ADD VENDOR"))
		{
			VendorsDAO dao1=new VendorsDAO();
			int flag1=dao1.add_vendors(request);
			RequestDispatcher rd2=getServletContext().getRequestDispatcher("/add_vendor.jsp");
			
			request.setAttribute("model1", flag1+ " vendor added" );
			rd2.forward(request, response);	

		}
		/*to delete a vendor*/
		if(str.startsWith("DELETE VENDOR"))
		{
			VendorsDAO dao2=new VendorsDAO();
			int flag=dao2.delete_vendors(request);
			dropDown obj=new dropDown();
			ArrayList<Vendors> list=new ArrayList<Vendors>();
			list=obj.vendors(request);
			
			if(flag==1)
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/delete_vendor.jsp");
				request.setAttribute("model2", flag+ " vendor deleted");
				request.setAttribute("model10", list );
				rd1.forward(request,response);
			}
			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/delete_vendor.jsp");
				request.setAttribute("model2"," Reference of this vendor exists in database. It cannot be deleted.");
				request.setAttribute("model10", list );
				rd1.forward(request,response);
			}
		}
		/*to read vendor details*/
		if(str.startsWith("READ VENDOR"))
		{
			VendorsDAO dao3=new VendorsDAO();
			vendor=dao3.read(request);
			dropDown obj=new dropDown();
			ArrayList<Vendors> list=new ArrayList<Vendors>();
			list=obj.vendors(request);

			RequestDispatcher rd=request.getRequestDispatcher("/modify_vendor.jsp");
			request.setAttribute("model2", vendor);
			request.setAttribute("model10", list );
			rd.forward(request, response);
		}
		/*to update vendor details*/
		if(str.startsWith("UPDATE VENDOR"))
		{

			VendorsDAO dao4=new VendorsDAO();
			int flag=dao4.update(request,vendor);
			dropDown obj=new dropDown();
			ArrayList<Vendors> list=new ArrayList<Vendors>();
			list=obj.vendors(request);
			if(flag==1)
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/modify_vendor.jsp");
				request.setAttribute("model1", flag+ " vendor updated");
				request.setAttribute("model10", list );
				rd1.forward(request,response);
			}
		}
		/*to search a vendor*/
		if(str.startsWith("SEARCH VENDOR"))
		{
			VendorsDAO dao5=new VendorsDAO();
			vendor=dao5.search(request);

			if(vendor.getVendor_name()!=null)
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/searchvendordetails.jsp");
				request.setAttribute("model3",vendor);
				rd1.forward(request,response);
			}
			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/search_vendor.jsp");
				request.setAttribute("model3","Sorry! Vendor does not Exist");
				rd1.forward(request,response);
			}		
		}
		/*to add a new warehouse*/
		if(str.startsWith("ADD WAREHOUSE"))
		{
			WarehouseDAO dao1=new WarehouseDAO();
			int flag1=dao1.add_warehouse(request);
			RequestDispatcher rd2=getServletContext().getRequestDispatcher("/add_warehouse.jsp");
			request.setAttribute("model1", flag1+ " warehouse added" );
			rd2.forward(request, response);		
		}
		/*to delete warehouse*/
		if(str.startsWith("DELETE WAREHOUSE"))
		{
			WarehouseDAO dao2=new WarehouseDAO();
			int flag=dao2.delete_warehouse(request);
			dropDown obj=new dropDown();
			ArrayList<Warehouse> list=new ArrayList<Warehouse>();
			list=obj.warehouse(request);
			if(flag==1)
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/delete_warehouse.jsp");
				request.setAttribute("model2", flag+ " warehouse deleted");
				request.setAttribute("model10", list );
				rd1.forward(request,response);
			}
			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/delete_warehouse.jsp");
				request.setAttribute("model2"," Reference of this warehouse exists in database. It cannot be deleted.");
				request.setAttribute("model10", list );
				rd1.forward(request,response);
			}
		} 
		/*to read a warehouse*/
		if(str.startsWith("READ WAREHOUSE"))
		{
			WarehouseDAO dao3=new WarehouseDAO();
			warehouse=dao3.read(request);
			dropDown obj=new dropDown();
			ArrayList<Warehouse> list=new ArrayList<Warehouse>();
			list=obj.warehouse(request);

			RequestDispatcher rd=request.getRequestDispatcher("/modify_warehouse.jsp");
			request.setAttribute("model2", warehouse);
			request.setAttribute("model10", list );
			rd.forward(request, response);
		}
		/*to update warehouse details*/
		if(str.startsWith("UPDATE WAREHOUSE"))
		{

			WarehouseDAO dao4=new WarehouseDAO();
			int flag=dao4.update(request,warehouse);
			dropDown obj=new dropDown();
			ArrayList<Warehouse> list=new ArrayList<Warehouse>();
			list=obj.warehouse(request);

			if(flag==1)
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/modify_warehouse.jsp");
				request.setAttribute("model1", flag+ " warehouse updated");
				request.setAttribute("model10", list );
				rd1.forward(request,response);
			}
		}
		/*to search warehouse*/
		if(str.startsWith("SEARCH WAREHOUSE"))
		{
			WarehouseDAO dao5=new WarehouseDAO();
			warehouse=dao5.search(request);

			if(warehouse.getWarehouse_name()!=null)
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/searchwarehousedetails.jsp");
				request.setAttribute("model3",warehouse);
				rd1.forward(request,response);
			}
			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/search_warehouse.jsp");
				request.setAttribute("model3","Sorry! Warehouse does not Exist");
				rd1.forward(request,response);
			}		
		}
		/*to add customer*/
		if(str.startsWith("ADD CUSTOMER"))
		{
			CustomersDAO dao1=new CustomersDAO();
			int flag1=dao1.add_customer(request);
			RequestDispatcher rd2=getServletContext().getRequestDispatcher("/add_customer.jsp");
			request.setAttribute("model1", flag1+ " customer added" );
			rd2.forward(request, response);	

		}
		/*to delete a customer*/
		if(str.startsWith("DELETE CUSTOMER"))
		{ 
			CustomersDAO dao2=new CustomersDAO();
			int flag=dao2.delete_customer(request);
			dropDown obj=new dropDown();
			ArrayList<Customers> list=new ArrayList<Customers>();
			list=obj.customers(request);
			if(flag==1)
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/delete_customer.jsp");
				request.setAttribute("model2", flag+ " customer deleted");
				request.setAttribute("model10", list );
				rd1.forward(request,response);
			}
			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/delete_customer.jsp");
				request.setAttribute("model2"," Reference of this customer exists in database. It cannot be deleted.");
				request.setAttribute("model10", list );
				rd1.forward(request,response);
			}
		}
		/*to read customer details*/
		if(str.startsWith("READ CUSTOMER"))
		{
			CustomersDAO dao3=new CustomersDAO();
			customer=dao3.read(request);
			dropDown obj=new dropDown();
			ArrayList<Customers> list=new ArrayList<Customers>();
			list=obj.customers(request);

			RequestDispatcher rd=request.getRequestDispatcher("/modify_customer.jsp");
			request.setAttribute("model2", customer);
			request.setAttribute("model10", list );
			rd.forward(request, response);
		}
		/*to update customer details*/
		if(str.startsWith("UPDATE CUSTOMER"))
		{

			CustomersDAO dao4=new CustomersDAO();
			int flag=dao4.update(request,customer);
			dropDown obj=new dropDown();
			ArrayList<Customers> list=new ArrayList<Customers>();
			list=obj.customers(request);

			if(flag==1)
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/modify_customer.jsp");
				request.setAttribute("model1", flag+ " customer updated");
				request.setAttribute("model10", list );
				rd1.forward(request,response);
			}
		}
		/*to search customer*/
		if(str.startsWith("SEARCH CUSTOMER"))
		{
			CustomersDAO dao5=new CustomersDAO();
			customer=dao5.search(request);

			if(customer.getCust_name()!=null)
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/searchcustomerdetails.jsp");
				request.setAttribute("model3",customer);
				rd1.forward(request,response);
			}

			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/search_customer.jsp");
				request.setAttribute("model3","Sorry! Customer does not Exist");
				rd1.forward(request,response);
			}		
		}
		/*to display item details*/
		if(str.startsWith("DISPLAY ITEM DETAILS"))
		{
			//ResultSet rs;
			ItemsDAO dao=new ItemsDAO();
			ArrayList<Items> list=new ArrayList<Items>();
			list=dao.displayitems(request);
			dropDown obj=new dropDown();
			ArrayList<Warehouse> list3=new ArrayList<Warehouse>();
			ArrayList<ItemType> list4=new ArrayList<ItemType>();
			ArrayList<Vendors> list1=new ArrayList<Vendors>();
			list1=obj.vendors(request);
			list3=obj.warehouse(request);
			list4=obj.item_type(request);
		

			if(list.isEmpty())
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/view_items.jsp");
				request.setAttribute("model3","NO ITEMS AVAILABLE,PLEASE BUY NEW STOCK");
				request.setAttribute("model11", list1 );
				request.setAttribute("model13", list3 );
				request.setAttribute("model14", list4 );
				rd1.forward(request,response);
			}
			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/itemdetails.jsp");
				request.setAttribute("model3",list);
				rd1.forward(request,response);	
			}
		}
		/*to sort item by item name*/
		if(str.startsWith("SORT ITEM BY ITEM NAME"))
		{

			ItemsDAO dao=new ItemsDAO();
			ArrayList<Items> list=new ArrayList<Items>();
			list=dao.sortitems(request);

			RequestDispatcher rd1=request.getRequestDispatcher("/itemdetails.jsp");
			request.setAttribute("model3",list);
			rd1.forward(request,response);

		}
		/*to search by vendor id*/
		if(str.startsWith("SEARCH BY VENDOR"))
		{
			ItemsDAO dao=new ItemsDAO();
			ArrayList<Items> list=new ArrayList<Items>();
			list=dao.displaybyvendorid(request);
			dropDown obj=new dropDown();
			ArrayList<Warehouse> list3=new ArrayList<Warehouse>();
			ArrayList<ItemType> list4=new ArrayList<ItemType>();
			ArrayList<Vendors> list1=new ArrayList<Vendors>();
			list1=obj.vendors(request);
			list3=obj.warehouse(request);
			list4=obj.item_type(request);

			if(list.isEmpty())
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/view_items.jsp");
				request.setAttribute("model3","No items are purchased from the selected Vendor");
				request.setAttribute("model11", list1 );
				request.setAttribute("model13", list3 );
				request.setAttribute("model14", list4 );
				rd1.forward(request,response);
			}
			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/itemdetailsbyvid.jsp");
				request.setAttribute("model3",list);
				rd1.forward(request,response);
			}
		}
		/*to search by warehouseid*/
		if(str.startsWith("SEARCH BY WAREHOUSE"))
		{
			ItemsDAO dao=new ItemsDAO();
			ArrayList<Items> list=new ArrayList<Items>();
			list=dao.displaybywarehouseid(request);
			dropDown obj=new dropDown();
			ArrayList<Warehouse> list3=new ArrayList<Warehouse>();
			ArrayList<ItemType> list4=new ArrayList<ItemType>();
			ArrayList<Vendors> list1=new ArrayList<Vendors>();
			list1=obj.vendors(request);
			list3=obj.warehouse(request);
			list4=obj.item_type(request);

			if(list.isEmpty())
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/view_items.jsp");
				request.setAttribute("model3","No items are Stored in the selected Warehouse");
				request.setAttribute("model11", list1 );
				request.setAttribute("model13", list3 );
				request.setAttribute("model14", list4 );
				rd1.forward(request,response);

			}
			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/itemdetailsbywid.jsp");
				request.setAttribute("model3",list);
				rd1.forward(request,response);
			}

		}
		/*to filter items based on item type*/
		if(str.startsWith("FILTER"))
		{
			ItemsDAO dao=new ItemsDAO();
			ArrayList<Items> list=new ArrayList<Items>();
			list=dao.displaybyitemtype(request);
			dropDown obj=new dropDown();
			ArrayList<Warehouse> list3=new ArrayList<Warehouse>();
			ArrayList<ItemType> list4=new ArrayList<ItemType>();
			ArrayList<Vendors> list1=new ArrayList<Vendors>();
			list1=obj.vendors(request);
			list3=obj.warehouse(request);
			list4=obj.item_type(request);
			
			if(list.isEmpty())
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/view_items.jsp");
				request.setAttribute("model3","No items of the selected Item type");
				request.setAttribute("model11", list1 );
				request.setAttribute("model13", list3 );
				request.setAttribute("model14", list4 );
				rd1.forward(request,response);

			}
			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/itemdetailsbyitemtype.jsp");
				request.setAttribute("model3",list);
				rd1.forward(request,response);
			}

		}
		/*to display vendor details*/
		if(str.startsWith("DISPLAY VENDOR DETAILS"))
		{
			//ResultSet rs;
			VendorsDAO dao=new VendorsDAO();
			ArrayList<Vendors> list=new ArrayList<Vendors>();
			list=dao.displayvendors(request);

			if(list.isEmpty())
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/view_vendors.jsp");
				request.setAttribute("model3","NO VENDORS AVAILABLE");
				rd1.forward(request,response);
			}
			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/vendordetails.jsp");
				request.setAttribute("model3",list);
				rd1.forward(request,response);	
			}
		}

		/*to display warehouse details*/
		if(str.startsWith("DISPLAY WAREHOUSE DETAILS"))
		{
			//ResultSet rs;
			WarehouseDAO dao=new WarehouseDAO();
			ArrayList<Warehouse> list=new ArrayList<Warehouse>();
			list=dao.displaywarehouse(request);

			if(list.isEmpty())
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/view_warehouse.jsp");
				request.setAttribute("model3","NO WAREHOUSE AVAILABLE");
				rd1.forward(request,response);
			}
			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/warehousedetails.jsp");
				request.setAttribute("model3",list);
				rd1.forward(request,response);	
			}
		}
		/*to display customer details*/
		if(str.startsWith("DISPLAY CUSTOMER DETAILS"))
		{
			//ResultSet rs;
			CustomersDAO dao=new CustomersDAO();
			ArrayList<Customers> list=new ArrayList<Customers>();
			list=dao.displaycustomers(request);

			if(list.isEmpty())
			{
				System.out.println("in if display main");
				RequestDispatcher rd1=request.getRequestDispatcher("/view_customer.jsp");
				request.setAttribute("model3","NO CUSTOMERS AVAILABLE");
				rd1.forward(request,response);
			}
			else
			{
				System.out.println("in main servlet display else");
				RequestDispatcher rd1=request.getRequestDispatcher("/customerdetails.jsp");
				request.setAttribute("model3",list);
				rd1.forward(request,response);	
			}
		}
		/*to display order details*/
		if(str.startsWith("DISPLAY ORDER DETAILS"))
		{
			//ResultSet rs;
			NewOrderDAO dao=new NewOrderDAO();
			ArrayList<Orders> list=new ArrayList<Orders>();
			list=dao.displayorders(request);

			if(list.isEmpty())
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/newOrder.jsp");
				request.setAttribute("model3","NO ORDERS AVAILABLE");
				rd1.forward(request,response);
			}
			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/orderdetails.jsp");
				request.setAttribute("model3",list);
				rd1.forward(request,response);	
			}
		}
		/*to display purchase details*/
		if(str.startsWith("DISPLAY PURCHASE DETAILS"))
		{
			//ResultSet rs;
			NewPurchaseDAO dao=new NewPurchaseDAO();
			ArrayList<Purchase> list=new ArrayList<Purchase>();
			list=dao.displaypurchase(request);

			if(list.isEmpty())
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/newPurchase.jsp");
				request.setAttribute("model4","NO PURCHASE DETAILS AVAILABLE");
				rd1.forward(request,response);
			}
			else
			{
				RequestDispatcher rd1=request.getRequestDispatcher("/purchasedetails.jsp");
				request.setAttribute("model4",list);
				rd1.forward(request,response);	
			}
		}
		/*to logout*/
		if(str.startsWith("LOGOUT"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("/Index.jsp");
			request.setAttribute("model5", "Thank You! You have successfully logged out.");
			rd.forward(request, response);
		}
		/*to go to admin home*/
		if(str.startsWith("ADMIN HOME"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("./frame2.jsp");
			rd.forward(request, response);
		}
		/*to go to user home*/
		if(str.startsWith("USER HOME"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("/frame4.jsp");
			rd.forward(request, response);
		}
	}
}



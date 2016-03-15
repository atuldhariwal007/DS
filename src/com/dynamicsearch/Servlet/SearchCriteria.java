package com.dynamicsearch.Servlet;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.sql.DataSource;

import com.dynamicsearch.Constants.DynamicSearchConstants;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Servlet implementation class SearchCriteria
 */
@WebServlet("/SearchCriteria")
public class SearchCriteria extends HttpServlet {
	private static final long serialVersionUID = 1L;
      Connection con = null;
      ResultSet rs = null;
      ResultSet rs1 = null;
      ResultSet rs2 = null;
      ResultSet rs3 = null;
      PreparedStatement ps = null;
      PreparedStatement ps1 = null;
      PreparedStatement ps2 = null;
      PreparedStatement ps3 = null;
      DataSource ds= null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCriteria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageName="viewsalesorder";
		String BT_Name="View_Sales_Order";
		String BT_ID;
		
		
	try
		{
	    con=getConnection();// creating connection to database
		String query="select BT_ID from BUSINESS_Transaction  where BT_Name=? ";
		 ps=con.prepareStatement(query);
		ps.setString(1,BT_Name);
	    ArrayList<Integer> table_Id=new ArrayList<>();
	    ArrayList<String> table_name=new ArrayList<>();
	     rs=ps.executeQuery();
	    HashMap<Integer,ArrayList<String>> map=new HashMap<Integer,ArrayList<String>>(); 
	    if(rs.next()){
	    	BT_ID=(rs.getString(1));
	    	System.out.println(BT_ID);
	    	String query1="select Table_ID from BT_Table  where BT_ID=? ";
	    	ps1=con.prepareStatement(query1);
			ps1.setString(1,BT_ID);
			rs1=ps1.executeQuery();
			while(rs1.next()){
				table_Id.add(rs1.getInt(1));
				System.out.println("bt_id");
				System.out.println(rs1.getInt(1));
				
			}	
			}
			for(int i=0;i<table_Id.size();i++)
			{
				String query2="select Table_Description from Transaction_Table  where Table_ID=? ";
		    	ps2=con.prepareStatement(query2);
			    ps2.setInt(1,table_Id.get(i) );
				rs2=ps2.executeQuery();
				while(rs2.next()){
					table_name.add(rs2.getString(1));
					System.out.println("table name");
					System.out.println(rs2.getString(1));
			}}
				for(int i=0;i<table_name.size();i++)
				{
					String query3="show columns from " +table_name.get(i);
			    	ps3=con.prepareStatement(query3);
				   
					rs3=ps3.executeQuery();
					ArrayList<String> columns=new ArrayList<>();
					while(rs3.next()){
						columns.add(rs3.getString(1));
				}
					map.put(i, columns);
	        
	    }
				
				request.setAttribute("map", map);    // sending ArrayList object to next resource to display missing person
		    	request.getRequestDispatcher("viewsalesorder.jsp").forward(request,  response);
		}catch(Exception e){
			System.out.println(e.getMessage());
	        
		}
		
		
		
	}
public Connection getConnection(){
		
		
		try{
			InitialContext context = new InitialContext();
			Context env = (Context) context.lookup("java:/comp/env");
			ds = (DataSource) env.lookup("jdbc/erp");
			con = ds.getConnection();
			
			}
			catch(NamingException ex){
			ex.printStackTrace();
				System.out.println("hi");
			} 
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return con;
	}
}

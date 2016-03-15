package com.dynamicsearch.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.dynamicsearch.Bean.DynamicSearchBean;
import com.dynamicsearch.Constants.DynamicSearchConstants;

public class DynamicSearchDao {

	private DataSource ds = null;
	Connection conn = null;
	PreparedStatement st =null;
	ResultSet rs= null;
	
	
	public List<List<String>> getSearchResult(DynamicSearchBean dynamicSearchBeanObj){
        
		
		try{
		conn = getConnection();
		
		System.out.println(conn.toString());
		st = conn.prepareStatement(DynamicSearchConstants.GET_SALES_CRITERIA_BASE_QUERY);
		
		 rs= st.executeQuery();
		 System.out.println("hello" + rs.toString());
		 	while(rs.next()){
			System.out.println( rs.getString("name"));
			}
			System.out.println("Connection Successful");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
		
		
	public Connection getConnection(){
		
		
		try{
			InitialContext context = new InitialContext();
			Context env = (Context) context.lookup("java:/comp/env");
			ds = (DataSource) env.lookup("jdbc/erp");
			conn = ds.getConnection();
			
			}
			catch(NamingException ex){
			ex.printStackTrace();
				System.out.println("hi");
			} 
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return conn;
	}
	}


package com.dynamicsearch.Servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dynamicsearch.Bean.DynamicSearchBean;
import com.dynamicsearch.Business.DynamicSearchBusiness;


@WebServlet("/DynamicSearchServlet")
public class DynamicSearchServlet extends HttpServlet {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DynamicSearchBean dynamicsearchbeanObj = new DynamicSearchBean();
	 List<List<String>> dynamicsearchlist = new ArrayList<List<String>>();
	 
	 public void  doGet(HttpServletRequest request, HttpServletResponse response)
				throws IOException{
	 dynamicsearchlist = new DynamicSearchBusiness().getSearchCriteriResult(dynamicsearchbeanObj);
	 
	 /*return dynamicsearchlist;*/
	 }
	
}

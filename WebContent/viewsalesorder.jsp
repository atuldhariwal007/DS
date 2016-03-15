<%@page import="com.google.gson.Gson"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.Map.Entry" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html >
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>eRP</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<style>


#div2{
    
    position: absolute;
    top: 50px;
    bottom: 0;
    background-color:blue;/*Development Only*/
}





        h1.page-header {
            margin-top: -5px;
        }
        
        .sidebar {
            padding-left: 0;
            width: 183px;
            margin-left: -16px;
        }
        
        .main-container {
            background: #FFF;
            padding-top: 15px;
            margin-top: -20px;
        }
        
        
        
        
        
        .side-menu {
            position: relative;
            width: 100%;
            height: 100%;
            background-color: #f8f8f8;
            border-right: 1px solid #e7e7e7;
        }
        
        .side-menu .navbar {
            border: none;
        }
        
        .side-menu .navbar-header {
            width: 100%;
            border-bottom: 1px solid #e7e7e7;
        }
        
        .side-menu .navbar-nav .active a {
            background-color: transparent;
            margin-right: -1px;
            border-right: 5px solid #e7e7e7;
        }
        
        .side-menu .navbar-nav li {
            display: block;
            width: 100%;
            
        }
        
        .side-menu .navbar-nav li a {
            padding: 15px;
        }
        
        .side-menu .navbar-nav li a .glyphicon {
            padding-right: 10px;
			padding-left:10px;
        }
      
        
      
      
        /* Main body section */
        
        .side-body {
            margin-left: 310px;
        }
       
   </style>
   <script>
    function showResult( ){
       
       var movie = document.getElementById("mydiv").innerHTML;
       
        var json = JSON.parse( movie );
	
       
       
        
        
     alert(json);
      
    
    }
    </script>
<body >


<div class="navbar navbar-default navbar-fixed-top">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-inverse-collapse">
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="">xyz</a>
  </div>
  <div class="navbar-collapse collapse navbar-inverse-collapse">
    <ul class="nav navbar-nav">
      <li class=""><a href="index.jsp">Home <span class="glyphicon glyphicon-home"></span></a></li>
      
    </ul>
   
    <ul class="nav navbar-nav navbar-right">
     <li><a href="#largeModal" data-toggle="modal" >Search <span class="glyphicon glyphicon-search"></span>&nbsp&nbsp&nbsp</a></li>
    </ul>
     
  </div>
</div>


<div class="featurette" id="about" style="margin-top:50px">
            <!------------------------code---------------start---------------->
            
            <div class="container-fluid main-container " >
                <div class="col-md-2 sidebar " >
                    <div class="row">
                        
                        <!-- Menu -->
                        <div class="side-menu" >
                            <nav class="navbar navbar-default" role="navigation">
                                <!-- Main Menu -->
                                <div class="side-menu-container">
                                    <ul class="nav navbar-nav">
                                        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span>View Sales </a></li>
                                        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span>Make Order</a></li>

                                       
                                        <li><a href="#"></a></li>
                                        <li><a href="#"></a></li>
                                        <li><a href="#"> </a></li>
                                        <li><a href="#"></a></li>
                                        <li><a href="#"> </a></li>

                                         <li><a href="#"> </a></li>
                                        <li><a href="#"></a></li>
                                        <li><a href="#"> </a></li>
										<li><a href="#"> </a></li>
                                        <li><a href="#"></a></li>
                                        <li><a href="#"> </a></li>
										<li><a href="#"></a></li>
                                        <li><a href="#"> </a></li>
										<li><a href="#"> </a></li>
                                    </ul>
                                </div>
                                <!-- /.navbar-collapse -->
                            </nav>

                        </div>
                    </div>
                </div>
             

<!--Large model-->
<div id="largeModal" class="modal">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Search Criteria</h4>
                </div>
                <div class="modal-body">
                    
  <form class="form-horizontal">
   <%
HashMap<Integer,ArrayList<String>> map=(HashMap<Integer,ArrayList<String>>)(request.getAttribute("map"));; 
ArrayList<String> values =new ArrayList();
%>
   <%for (Entry<Integer, ArrayList<String>> ee : map.entrySet()) {
				    int key = ee.getKey();
				   // values = ee.getValue();
				    values.addAll(ee.getValue());
				    // TODO: Do something.
   }  %> 
				 <% int i=0;
for(i=0;i<values.size();i++)
{
	
%>

  <fieldset>
    
 <div class="form-group">
     
      <div class="col-lg-3">
        <select class="form-control" id="select" name="<%=values.get(i)%>">
          <option><%=values.get(i)%></option>
          
         
        </select>
       
      </div>
	  <div class="col-lg-3">
        <select class="form-control"   name="condition">
          <option>is</option>
          <option>is not</option>
          
        </select>
       
      </div>
	  <div class="col-lg-3">
        <input type="text" class="form-control" id="usr" name="valueByUser" >
       
      </div>
	  <div class="col-lg-2">
	   
	   <a href="#"><span class="glyphicon glyphicon-plus"> </span></a>
      <a href="#"><span class="glyphicon glyphicon-minus">
      
    </span></a>
	</div>
	
    </div>
	
	</fieldset>
	
  


<%break;} 

Gson gson = new Gson();


String json = gson.toJson(values);%>

<div id="mydiv" style="display:none"><%=json%></div>

	<button id="mybtn" onclick="showResult()">Show</button>			

	
	<button type="submit" class="btn btn-default btn-sm">Search</button>
	<button type="reset" class="btn btn-default btn-sm">Clear</button>
	<button type="button" class="btn btn-default btn-sm">Save</button>
	</form>
</div> 
                
            </div>
        </div>
    </div>


            </div>
            <!----Code------end----------------------------------->
        </div>
<div class="container-fluid" style="background-color:#f2f2f2;height:80px;padding-top:10px;">
<br>
<br>
<div class="row" >
<div class="col-md-4"></div>
<div class="col-md-4">Copyright 1999-2015 .... All Rights Reserved.
</div>
<div class="col-md-4"></div>
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 
</body>
</html>
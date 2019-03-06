<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Admin - Add Product</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</head>
	<link href="styles/adminAddProduct.css" type="text/css" rel="stylesheet">
</head>
 <script language="javascript"> 
window.history.forward(1); 
browser.cache.offline.enable = false; 
function noBack() { window.history.forward(1); 

} 
//***Get what is above onto one line*** 

self.close() 
function disableBackButton() 
{ 
window.history.forward(1); 
} 
setTimeout("disableBackButton()", 0); 
</script>  
</head>
<body onload="noBack()">
	<div id="main" class="container-fluid row">
		<div id="top">
		<nav class="navbar navbar-default">	
    		<div id="nav" class="navbar-header">
      			<a class="navbar-brand" href="#"><img id="picture" src="images/nav_logo.jpg"/></a>
			</div>
			<form class="navbar-form navbar-left">
				<div class="input-group add-on">
				<input class="form-control" placeholder="Search" id="search" type="text">
					<div class="input-group-btn">
						<button type="submit" class="btn btn-default" id="searchbtn">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
   			</form>
   			
			 <div id="last" class="navbar-form navbar-right">
				 <form action="/grizzly-store-admin-web/LogoutController">		
	        				<span id="bell" class="glyphicon glyphicon-bell"></span>
	        				<span id="info"><b>Welcome, <%HttpSession hs=request.getSession(false);%><%=hs.getAttribute("name")%></b></span>
	        				<input type="submit" id="logout" value="Logout"/>	        					   			
				</form>
			</div>
  		</nav>
  		</div>
  		<div id="middle" class="row">
  			<div class="col-sm-1"></div>
			<div class="col-sm-3" id=mid_left>
				<div  align="center" id="profile_bar" class="row">
					<div align="left" id="profile" >PROFILE</div>
				</div>
				<div align="center" id="profile_contents">
					<img class="img-responsive" id="profilePicture" src="images/billgates.jpg"/>
					<h3><%=hs.getAttribute("name") %></h3>
					<h5><b>ID</b></h5><h5 id="idspace"><%=hs.getAttribute("id") %></h5>
					<h5><b>Designation</b></h5> <h5 id="idspace"><%=hs.getAttribute("designation") %></h5>
					<h5><b>Office</b></h5><h5 id="idspace3"><%=hs.getAttribute("office") %></h5>
				</div>
			</div>
			<div class="col-sm-1"></div>
			<div  class="col-sm-6">
				<div id="categories" class="row">
				<ul class="nav nav-pills nav-justified" style="background-color:#e6e6e6;">
    				<li class="active"><a data-toggle="tab" data-toggle="pill" href="#product" style="font-size:30px;" href="#">PRODUCTS</a></li>
    				<li><a data-toggle="pill" href="#vendor" style="font-size:30px;">VENDORS</a></li>
    				<li><a data-toggle="pill" href="#category" style="font-size:30px;">CATEGORY</a></li>
  				</ul>
  				</div>
				<div class="tab-content">
				<div id="product" class="tab-pane fade in active">
  				<div class="col-sm-7" >
  					<div id="box">
  						<img id="add_image" src="images/add_image.jpg"/><br/>	
  					</div>
  					<div style="padding:20px;">
  						<a target="_blank" href="images/billgates.jpg">
  						<img src="images/billgates.jpg" alt="Forest" style="width:50px; height:50px; border: 2px solid black; padding: 2px;">
  						<span><button type="button" class="btn btn-default" style="border-radius:50%; width:20px;height:20px; transform:translate(-60%,-120%); background-color: black; color:white;"><span style="position:absolute; transform:translate(-50%,0%);" class="glyphicon glyphicon-remove"></span></button></span>
						</a>
  					</div>

				</div>
				<form action="/grizzly-store-admin-web/AddProductController" method="POST">
				<div class="col-sm-3" >
				
					<table class="table" >
    					<tbody>
      						<!-- <tr>
        						<td><input class="abc" type="text" name="ipid" placeholder="Enter ProductID"/></td>
      						</tr> -->
      						<tr>
      							<td>
        							<button type="button" class="btn btn-info" id="category_button" data-toggle="collapse" data-target="#demo"><span id="category_text">Category</span></button><span class="glyphicon glyphicon-chevron-down"></span>
  								<div id="demo" class="collapse">
									
    										<div class="radio">
      											<label class="category"><input type="radio" name="optradio" value="Electronics" checked>Electronics</label>
    										</div>
    										<div class="radio">
      											<label class="category"><input type="radio" name="optradio" value="Appliances">Appliances</label>
    										</div>
    										<div class="radio">
      											<label class="category"><input type="radio" name="optradio" value="Healthcare">Healthcare</label>
    										</div>
										<div class="radio">
      											<label class="category"><input type="radio" name="optradio" value="Furniture">Furniture</label>
    										</div>
										<div class="radio">
      											<label class="category"><input type="radio" name="optradio" value="Automobile">Automobile</label>
    										</div>
  									
  								</div>
							</td>	
      						</tr>
      						<tr>
        						<td><input class="abc" type="text" name="ipname" placeholder="Name"/></td>
      						</tr>
      						<tr>
        						<td><input class="abc" type="text" name="ipbrand" placeholder="Brand"/></td>
      						</tr>
      						<tr>
        						<td><input class="abc" type="text" name="ipdescription" placeholder="Description"/></td>
      						</tr>
      						<tr>
        						<td><input class="abc" type="text" name="ipprice" placeholder="Price"/></td>
      						</tr>
      						
    				</tbody>
  				</table>
				
				</div>
				<div class="col-sm-1" id="buttons">
                    
						<div class="col-sm-1"><input id="add" type="submit" value="Add"/></div><br/><br/>
						
						<div class="col-sm-1"><input id="cancel" type="submit" value="Cancel"/></div>
					</form>
				</div>
			</div>
			</div>
			</div>
	</div>
	</div>
</body>
</html>
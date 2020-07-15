<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book Details</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script type="text/javascript" src="js/validation.js"></script>
<style>
	.container{
	border:red solid 1px;
	border-radius:10px;
}
</style>
</head>
<body>
<br>
	<div class="container">
<jsp:include page="header.html"></jsp:include>
		<hr>
		<h1>Update Book Details</h1>
		<hr>
		<form action="modifiedbook">
			<div class="form-group">
				<input type="text" id="bookname" class="form-control" onfocusout="validateBookname()" placeholder="Enter Book Name"/>
				<div id="booknameerror" style="color:red"></div>	
			</div>
			
			<div class="form-group">
				<input type="text" id="publication" class="form-control" onfocusout="validatePublication()" placeholder="Enter Name of Publication"/>
				<div id="publicationerror" style="color:red"></div>
			</div>
			
			<div class="form-group">
				<input type="text" id="isbn" class="form-control" onfocusout="validateIsbn()" placeholder="Enter Book ISBN No."/>
				<div id="isbnerror" style="color:red"></div>
			</div>
			
			<div class="form-group">
				<input type="text" id="price" class="form-control" onfocusout="validatePrice()" placeholder="Enter Book Price"/>
				<div id="priceerror" style="color:red"></div>
			</div>
			
			<div class="form-group">
				<input type="text" id="qty" class="form-control" onfocusout="validateQty()" placeholder="Enter Book Qty"/>
				<div id="qtyerror" style="color:red"></div>
			</div>
			<div class="form-group">
				<input type="submit" value="Update Book" class="btn btn-info btn-block">
			</div>
		</form>
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script type="text/javascript" src="js/validation.js"></script>
<style>
	.container{
	border:red solid 1px;
	border-radius:10px
}
</style>
</head>
<body>
<br>
	<div class="container">
	<jsp:include page="header.html"></jsp:include>
		<hr>
		<h1>Add New Book Details</h1>
		<hr>
		<form action="insertbook">
			<div class="form-group">
				<input type="text" name="bookname" id="bookname" class="form-control" onfocusout="validateBookname()" placeholder="Enter Book Name"/>
				<div id="booknameerror" style="color:red"></div>	
			</div>
			
			<div class="form-group">
				<input type="text" name="publication" id="publication" class="form-control" onfocusout="validatePublication()" placeholder="Enter Name of Publication"/>
				<div id="publicationerror" style="color:red"></div>
			</div>
			
			<div class="form-group">
				<input type="text" name="isbn"  id="isbn" class="form-control" onfocusout="validateIsbn()" placeholder="Enter Book ISBN No."/>
				<div id="isbnerror" style="color:red"></div>
			</div>
			
			<div class="form-group">
				<input type="text" name="price"  id="price" class="form-control" onfocusout="validatePrice()" placeholder="Enter Book Price"/>
				<div id="priceerror" style="color:red"></div>
			</div>
			
			<div class="form-group">
				<input type="text" name="qty" id="qty" class="form-control" onfocusout="validateQty()" placeholder="Enter Book Qty"/>
				<div id="qtyerror" style="color:red"></div>
			</div>
			<div class="form-group">
				<input type="submit" value="Add Book" class="btn btn-info btn-block">
			</div>
		</form>
	</div>
</body>
</html>
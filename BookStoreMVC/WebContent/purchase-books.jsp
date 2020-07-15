<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Book</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
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
		<h1>Purchase Book</h1>
		<hr>
		<form action="buybook">
			<div class="form-group">
				<input type="text" name="bookname" class="form-control" placeholder="Enter Book Name" />
			</div>
			
			<div class="form-group">
				<input type="text" name="isbn" class="form-control" placeholder="Enter ISBN No." />
			</div>
			
			<div class="form-group">
				<input type="text" name="copies" class="form-control" placeholder="Enter No. of Copies" />
			</div>
			
			<div class="form-group">
				<input type="submit" value="Purchase" class="btn btn-info btn-block" />
			</div>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.BookModel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book Details</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script type="text/javascript" src="js/validation.js"></script>
<% BookModel bmodel=(BookModel)request.getAttribute("book"); %>
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
		<form action="modifybook">
			<input type="hidden" name="bookid" value="<%=bmodel.getBookId()%>"/>
			<div class="form-group">
				<input type="text" name="bookname" id="bookname" class="form-control" value="<%=bmodel.getBookName() %>" onfocusout="validateBookname()" placeholder="ENTER BOOK NAME" />
				<div id="booknameerror" style="color:red"></div>
			</div>
			<div class="form-group">
				<input type="text" name="publication" id="publication" class="form-control" value="<%=bmodel.getBookPublication() %>" onfocusout="validatePublication()" placeholder="ENTER NAME OF PUBLICATION" />
				<div id="publicationerror" style="color:red"></div>
			</div>
			<div class="form-group">
				<input type="text" name="isbn" id="isbn" class="form-control" value="<%=bmodel.getBookIsbn() %>" onfocusout="validateIsbn()" placeholder="ENTER BOOK ISBN NO" />
				<div id="isbnerror" style="color:red"></div>
			</div>
			<div class="form-group">
				<input type="text" name="price" id="price" class="form-control" value="<%=bmodel.getBookPrice() %>" onfocusout="validatePrice()" placeholder="ENTER BOOK PRICE" />
				<div id="priceerror" style="color:red"></div>
			</div>
			<div class="form-group">
				<input type="text" name="qty" id="qty" class="form-control" value="<%=bmodel.getBookQty() %>" onfocusout="validateQty()" placeholder="ENTER BOOK QTY" />
				<div id="qtyerror" style="color:red"></div>
			</div>
			<div class="form-group">
				<input type="submit" value="Update Book" class="btn btn-info btn-block">
			</div>
		</form>
	</div>
</body>
</html>
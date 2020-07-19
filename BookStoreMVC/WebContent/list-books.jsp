<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="model.BookModel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list-books</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
 <script src="js/jquery-3.5.1.min.js"></script>   
<script src="js/jquery.tablesorter.min.js"></script>
<% 
	List<BookModel>books=(List<BookModel>)request.getAttribute("booklist");
%>
	<style>
		 table, th, td {
		text-align: center;
		border: 1px solid white;
		} 
	
		.container {
		border: red solid 1px;
		border-radius: 10px;
		}
	</style>
</head>
<body>
	<br>
	<div class="container">
		<jsp:include page="header.html"></jsp:include>
		<hr>
		<a href="add-books"><button class="btn btn-success btn-lg">Add
				Book</button></a>
		<hr>
		<div class="row">
			<div class="col-4">
				<input type="text" id="myinput" class="form-control" placeholder="Search..." />
			</div>
		</div>
		<hr>
		<table class="table table-dark table-bordered" id="books">
			<thead>
				<tr>
					<th>Book Id</th>
					<th>Book Name</th>
					<th>Book Publication</th>
					<th>Book ISBN</th>
					<th>Book Price</th>
					<th>Book QTY</th>
					<th>Book Action</th>
				</tr>
			</thead>
			<tbody id="myresults">
				<%for(BookModel b: books)
					{%>
					<tr>
						<td><%=b.getBookId() %></td>
						<td><%=b.getBookName() %></td>
						<td><%=b.getBookPublication()%></td>
						<td><%=b.getBookIsbn() %></td>
						<td><%=b.getBookPrice() %></td>
						<td><%=b.getBookQty() %></td>
					<td>
					<a href="loadbook?bid=<%=b.getBookId()%>"><button class="btn btn-success btn-sm">Update</button></a>
					<a href="delete-books?bid=<%=b.getBookId()%>" onclick="if(!(confirm('Are You Sure?'))) return false"><button class="btn btn-danger btn-sm">Delete</button></a>
					</td>
					</tr>
					<%}%>
			</tbody>
		</table>
	</div>
	
	<script>
	$(document).ready(function(){
	  $("#myinput").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#myresults tr").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	});
</script>
	
	<script >
	 $(function(){
		 $("#books").tablesorter();
		 
	 });
	</script>

</body></html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list-books</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/jquery.tablesorter.min.js"></script>

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
				<tr>
					<td>1</td>
					<td>J2EE</td>
					<td>O'Really</td>
					<td>JE2058</td>
					<td>2500.36</td>
					<td>10</td>
					<td>
					<a href="update-books">
					<button class="btn btn-primary btn-sm">Update</button></a>
					<a href="delete-books"><button class="btn btn-danger btn-sm">Delete</button></a></td>
				</tr>

				<tr>
					<td>2</td>
					<td>Wt</td>
					<td>R'Really</td>
					<td>KE2058</td>
					<td>2600.36</td>
					<td>20</td>
					<td><a href="update-books"><button class="btn btn-primary btn-sm">Update</button></a>
						<button class="btn btn-danger btn-sm">Delete</button></td>
				</tr>

				<tr>
					<td>3</td>
					<td>JS</td>
					<td>S'Really</td>
					<td>LE2058</td>
					<td>2700.36</td>
					<td>30</td>
					<td><a href="update-books"><button class="btn btn-primary btn-sm">Update</button></a>
						<button class="btn btn-danger btn-sm">Delete</button></td>
				</tr>

				<tr>
					<td>4</td>
					<td>Angular JS</td>
					<td>u'Really</td>
					<td>ME2058</td>
					<td>2800.36</td>
					<td>40</td>
					<td><a href="update-books"><button class="btn btn-primary btn-sm">Update</button></a>
						<button class="btn btn-danger btn-sm">Delete</button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<script >
	 $(document).ready(function() {
		$("#myinput").on("keyup", function() {
			var value=$(this).val().toLowerCase();
			$("myresults tr").filter(function() {
				$(this).toggle($(this).text().toLowerCase().indexOf(value)> -1)
				
			});
			
		}) ;
		 
	 });
	</script>
	
	<script >
	 $(function(){
		 $("#books").tablesorter();
		 
	 });
	</script>

</body></html>
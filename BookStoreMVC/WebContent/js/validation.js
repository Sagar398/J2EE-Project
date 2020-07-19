/**
 * Validation rules For Add Books, Update Book & Purchase Books
 */

/*Null Values Validation & Data Validation*/
/*1*/
function validateBookname()
{
	var bookname = document.getElementById("bookname").value;
	if(bookname=="")
	{
		document.getElementById("booknameerror").innerText = "Please Provide Book Name";
		document.getElementById("bookname").style.borderColor = "red";
	}
	else
	{
		var regx=/^[a-zA-Z0-9]/; /*/^[a-zA-Z\s]+$/;*/
		
		if(regx.test(bookname) === false)
		{
			document.getElementById("booknameerror").innerText = "Please Provide Valid Book Name";
			document.getElementById("bookname").style.borderColor = "red";
		}
		else
		{
			document.getElementById("booknameerror").innerText = "";
		document.getElementById("bookname").style.borderColor = "green";
		}
	}
}
/*2*/
function validatePublication()
{
	var publication = document.getElementById("publication").value;
	if(publication=="")
	{
		document.getElementById("publicationerror").innerText = "Please Provide Publication Name";
		document.getElementById("publication").style.borderColor = "red";
	}
	else
	{
		var regx=  /^[a-zA-Z\s]+$/;
		
		if(regx.test(publication) === false)
		{
			document.getElementById("publicationerror").innerText = "Please Provide Valid Publication Name";
			document.getElementById("publication").style.borderColor = "red";
		}
		else
		{
			document.getElementById("publicationerror").innerText = "";
			document.getElementById("publication").style.borderColor = "green";
		}
	}
}
/*3*/
function validateIsbn()
{
	var isbn = document.getElementById("isbn").value;
	if(isbn=="")
	{
		document.getElementById("isbnerror").innerText = "Please Provide ISBN No.";
		document.getElementById("isbn").style.borderColor = "red";
	}
	else
	{
		var regx=/^[a-zA-Z0-9\s]+$/;
		
		if(regx.test(isbn) === false)
		{
			document.getElementById("isbnerror").innerText = "Please Provide Valid ISBN No.";
			document.getElementById("isbn").style.borderColor = "red";
		}
		else
		{
			document.getElementById("isbnerror").innerText = "";
			document.getElementById("isbn").style.borderColor = "green";
		}
	}
}
/*4*/
function validatePrice()
{
	var price = document.getElementById("price").value;
	if(price=="")
	{
		document.getElementById("priceerror").innerText = "Please Provide Book Price";
		document.getElementById("price").style.borderColor = "red";
	}
	else
	{
		var regx= /\-?\d+\.\d+/;
		
		if(regx.test(price) === false)
		{
			document.getElementById("priceerror").innerText = "Please Provide Valid Book Price";
			document.getElementById("price").style.borderColor = "red";
		}
		else
		{
			document.getElementById("priceerror").innerText = "";
			document.getElementById("price").style.borderColor = "green";
		}
	}
}
/*5*/
function validateQty()
{
	var qty = document.getElementById("qty").value;
	if(qty=="")
	{
		document.getElementById("qtyerror").innerText = "Please Provide Book Qty";
		document.getElementById("qty").style.borderColor = "red";
	}
	else
	{
		var regx=/^[0-9]+$/;
		
		if(regx.test(qty) === false)
		{
			document.getElementById("qtyerror").innerText = "Please Provide Valid Qty";
			document.getElementById("qty").style.borderColor = "red";
		}
		else
		{
			document.getElementById("qtyerror").innerText = "";
			document.getElementById("qty").style.borderColor = "green";
		}
	}
}

/*6*/
function validateCopies()
{
	var copies = document.getElementById("copies").value;
	if(copies=="")
	{
		document.getElementById("copieserror").innerText = "Please Provide Copies";
		document.getElementById("copies").style.borderColor = "red";
	}
	else
	{
		var regx=/^[0-9]+$/;
		
		if(regx.test(copies) === false)
		{
			document.getElementById("copieserror").innerText = "Please Provide Valid Copies";
			document.getElementById("copies").style.borderColor = "red";
		}
		else
		{
			document.getElementById("copieserror").innerText = "";
			document.getElementById("copies").style.borderColor = "green";
		}
	}
}
/*https://www.regextester.com/96986
*/
package controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.BookDao;
import model.BookModel;

@WebServlet(urlPatterns = {"/list-books","/purchase-books","/add-books","/update-books","/delete-books","/insertbook","/buybook","/modifybook"})
public class BookController extends HttpServlet
{
	private BookDao bdata;
	
	@Resource(name="jdbc/book_tracker")
	private DataSource dsource;
	
	@Override
	public void init() throws ServletException 
	{
		bdata = new BookDao(dsource);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String path = req.getServletPath();

		switch(path)
		{
		case "/list-books" : showbooks(req,resp);
		break;

		case "/purchase-books" : purchasebooks(req,resp);
		break;

		case "/add-books" : savebooks(req,resp);
		break;

		case "/update-books" : updatebooks(req,resp);
		break;

		case "/delete-books" : removebooks(req,resp);
		break;

		case "/insertbook" : insertbooks(req,resp);
		break;

		case "/modifybook" : modifybooks(req,resp);
		break;

		case "/buybooks" : buybooks(req,resp);
		break;
		}
	}

	private void buybooks(HttpServletRequest req, HttpServletResponse resp) 
	{

	}

	private void modifybooks(HttpServletRequest req, HttpServletResponse resp) 
	{

	}
	//Display HTML Form
	private void savebooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("add-books.jsp");
		rd.forward(req, resp);
	}
	//Process HTML Form
	private void insertbooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//Fetch The Value From JSP File.
		String bookName = req.getParameter("bookname");
		String bookPublication = req.getParameter("publication");
		String bookIsbn = req.getParameter("isbn");
		String price = req.getParameter("price");
		String qty = req.getParameter("qty");
		
		//Parsing
		double bookPrice=Double.parseDouble(price);
		int bookQty=Integer.parseInt(qty);
		
		//Add Data Inside The Model
		BookModel bmodel = new BookModel();
		bmodel.setBookName(bookName);
		bmodel.setBookPublication(bookPublication);
		bmodel.setBookIsbn(bookIsbn);
		bmodel.setBookPrice(bookPrice);
		bmodel.setBookQty(bookQty);
		
		//Call Method of DAO Class
		bdata.storeBooks(bmodel);
		
		//send back to list page
		showbooks(req,resp);
	}

	private void removebooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

	}

	private void updatebooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("update-books.jsp");
		rd.forward(req, resp);
	}

	private void purchasebooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("purchase-books.jsp");
		rd.forward(req, resp);
	}

	private void showbooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//Call The Method of DAO Class
		List<BookModel> allbooks=bdata.getAllBooks();
		
		//Add Books To The Request
		req.setAttribute("booklist", allbooks);
		
		//Send The Output To JSP File
		RequestDispatcher rd = req.getRequestDispatcher("list-books.jsp");
		rd.forward(req, resp);
		
	}
}

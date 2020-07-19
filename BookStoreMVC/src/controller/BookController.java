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

@WebServlet(urlPatterns= {"/list-books","/add-books","/loadbook","/purchase-books","/delete-books","/insertbook","/modifybook","/buybook"})
public class BookController extends HttpServlet
{
	
	private BookDao bdata;
	
	@Resource(name="jdbc/book_tracker")
	private DataSource dsource;
	
	@Override
	public void init() throws ServletException 
	{
		bdata=new BookDao(dsource);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String path=req.getServletPath();
		
		switch(path)
		{
		case "/list-books":showbooks(req,resp);
							break;
							
		case "/purchase-books":purchasebooks(req,resp);
								break;
		
		case "/add-books":savebooks(req,resp);
							break;
							
		case "/loadbook": loadbook(req,resp);
								break;
								
		case "/delete-books": removebooks(req,resp);
								break;
								
		case "/insertbook": insertbooks(req,resp);
								break;
								
		case "/modifybook": modifybooks(req,resp);
							break;
							
		case "/buybook": buybooks(req,resp);
							break;
		}
	}

	private void buybooks(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void modifybooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//fetch the values from html form
		String id=req.getParameter("bookid");
		String bookName=req.getParameter("bookname");
		String bookPublication=req.getParameter("publication");
		String bookIsbn=req.getParameter("isbn");
		String price=req.getParameter("price");
		String qty=req.getParameter("qty");
		
		//parsing
		int bookId=Integer.parseInt(id);
		double bookPrice=Double.parseDouble(price);
		int bookQty=Integer.parseInt(qty);
		
		//add the values inside the model
		BookModel bmodel=new BookModel();
		bmodel.setBookId(bookId);
		bmodel.setBookName(bookName);
		bmodel.setBookPublication(bookPublication);
		bmodel.setBookIsbn(bookIsbn);
		bmodel.setBookPrice(bookPrice);
		bmodel.setBookQty(bookQty);
		
		//call the method of DAO class
		bdata.updateBook(bmodel);
		
		//send back to list page
		showbooks(req, resp);
	}

	

	private void removebooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//fetch the value from HTML form
		String id=req.getParameter("bid");
		int bookid=Integer.parseInt(id);
		
		//add the bookid inside the model class
		
		BookModel bmodel=new BookModel();
		bmodel.setBookId(bookid);
		
		//call method of DAO class
		bdata.deletebooks(bmodel);
		
		//send back to list page
		showbooks(req, resp);
	}

	private void loadbook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//fetch the book id from html form
		String id=req.getParameter("bid");
		int bookid=Integer.parseInt(id);
		
		//add the value inside the model
		BookModel bmodel=new BookModel();
		bmodel.setBookId(bookid);
		
		//call the method of DAO class
		BookModel bookref=bdata.searchbook(bmodel);
		
		//add book ref into the attribute
		req.setAttribute("book", bookref);
	
		//forward the req to update form
		RequestDispatcher rd=req.getRequestDispatcher("update-books.jsp");
		rd.forward(req, resp);
	}

	//DISPLAY HTML FORM
	private void savebooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd=req.getRequestDispatcher("add-books.jsp");
		rd.forward(req, resp);
	}
	
	//PROCESS HTML FORM
	private void insertbooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//fetch the values from JSP file.
		String bookName=req.getParameter("bookname");
		String bookPublication=req.getParameter("publication");
		String bookIsbn=req.getParameter("isbn");
		String price=req.getParameter("price");
		String qty=req.getParameter("qty");
		
		//parsing
		double bookPrice=Double.parseDouble(price);
		int bookQty=Integer.parseInt(qty);
		
		//add data inside the model
		BookModel bmodel=new BookModel();
		bmodel.setBookName(bookName);
		bmodel.setBookPublication(bookPublication);
		bmodel.setBookIsbn(bookIsbn);
		bmodel.setBookPrice(bookPrice);
		bmodel.setBookQty(bookQty);
		
		//call method of DAO class
		bdata.storeBooks(bmodel);
		
		//send back to list page
		showbooks(req, resp);
		
	}

	private void purchasebooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd=req.getRequestDispatcher("purchase-books.jsp");
		rd.forward(req, resp);
	}

	private void showbooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//call the method of DAO class
		List<BookModel> allbooks=bdata.getAllBooks();
		
		//add books to the request
		req.setAttribute("booklist", allbooks);
		
		//send the output to JSP file
		RequestDispatcher rd=req.getRequestDispatcher("list-books.jsp");
		rd.forward(req, resp);
	}
}

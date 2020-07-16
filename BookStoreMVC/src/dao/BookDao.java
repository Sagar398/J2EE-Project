package dao;


import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.BookModel;

public class BookDao 
{
	//Persistence Operations(JDBC Code)
	private DataSource dsource;
	public BookDao(DataSource dsource) 
	{
		this.dsource = dsource;
	}
	
	public void storeBooks(BookModel bmodel)
	{
		Connection con = null;
		PreparedStatement pstmt=null;
		
		String query = "insert into book_shop values(?,?,?,?,?,?)";
		
		try 
		{
			con=dsource.getConnection();
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setString(2,bmodel.getBookName());
			pstmt.setString(3,bmodel.getBookPublication());
			pstmt.setString(4,bmodel.getBookIsbn());
			pstmt.setDouble(5,bmodel.getBookPrice());
			pstmt.setInt(6,bmodel.getBookQty());
			
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public List<BookModel> getAllBooks()
	{
		List<BookModel> listbooks=new ArrayList<BookModel>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String query = "select * from book_shop";
		
		try 
		{
			con=dsource.getConnection();
			
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			while (rs.next())
			{
				int id =rs.getInt(1);
				String name = rs.getString(2);
				String publication = rs.getString(3);
				String isbn = rs.getString(4);
				double price = rs.getDouble(5);
				int qty = rs.getInt(6);
				
				BookModel bmodel = new BookModel();
				bmodel.setBookId(id);
				bmodel.setBookName(name);
				bmodel.setBookPublication(publication);
				bmodel.setBookIsbn(isbn);
				bmodel.setBookPrice(price);
				bmodel.setBookQty(qty);	
				
				listbooks.add(bmodel);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return listbooks;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.BookModel;

public class BookDao 
{
	//persistence operations (JDBC CODE)
	
	private DataSource dsource;

	public BookDao(DataSource dsource) 
	{
		this.dsource=dsource;
	}
	

	public void storeBooks(BookModel bmodel)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String query="insert into book_shop values(?,?,?,?,?,?)";
		
		try 
		{
			con=dsource.getConnection();
			
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setString(2, bmodel.getBookName());
			pstmt.setString(3, bmodel.getBookPublication());
			pstmt.setString(4, bmodel.getBookIsbn());
			pstmt.setDouble(5, bmodel.getBookPrice());
			pstmt.setInt(6, bmodel.getBookQty());
			
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
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select * from book_shop";
		
		try 
		{
			con=dsource.getConnection();
			
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String publication=rs.getString(3);
				String isbn=rs.getString(4);
				double price=rs.getDouble(5);
				int qty=rs.getInt(6);
				
				BookModel bmodel=new BookModel();
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


	public void deletebooks(BookModel bmodel) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String query="delete from book_shop where book_id=?";
		
		try 
		{
			con=dsource.getConnection();
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, bmodel.getBookId());
			
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}


	public BookModel searchbook(BookModel bmodel)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String query="select * from book_shop where book_id=?";
		
		try 
		{
			con=dsource.getConnection();
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, bmodel.getBookId());
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				//int id = bmodel.getBookId();
				int bookid = rs.getInt("book_id");
				String name=rs.getString("book_name");
				String publication=rs.getString("book_publication");
				String isbn=rs.getString("book_isbn");
				double price=rs.getDouble("book_price");
				int qty=rs.getInt("book_qty");
				
				bmodel=new BookModel();
				bmodel.setBookId(bookid);/*(bmodel.getBookId());*/
				bmodel.setBookName(name);
				bmodel.setBookPublication(publication);
				bmodel.setBookIsbn(isbn);
				bmodel.setBookPrice(price);
				bmodel.setBookQty(qty);
			}
			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return bmodel;
	}


	public void updateBook(BookModel bmodel) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String query="update book_shop set book_name=?, book_publication=?, book_isbn=?, book_price=?, book_qty=? where book_id=?";
		
		try
		{
			con=dsource.getConnection();
			
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, bmodel.getBookName());
			pstmt.setString(2, bmodel.getBookPublication());
			pstmt.setString(3, bmodel.getBookIsbn());
			pstmt.setDouble(4, bmodel.getBookPrice());
			pstmt.setInt(5, bmodel.getBookQty());
			pstmt.setInt(6, bmodel.getBookId());
			
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}

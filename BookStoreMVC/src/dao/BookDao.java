package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}

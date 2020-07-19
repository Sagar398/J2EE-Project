package model;
//DTO Class or Java Bean Class
public class BookModel 
{
	private int bookId;
	private String bookName;
	private String bookPublication;
	private String bookIsbn;
	private double bookPrice;
	private int bookQty;
	
	public int getBookId() 
	{
		return bookId;
	}
	public String getBookName() 
	{
		return bookName;
	}
	public String getBookPublication()
	{
		return bookPublication;
	}
	public String getBookIsbn() 
	{
		return bookIsbn;
	}
	public double getBookPrice()
	{
		return bookPrice;
	}
	public int getBookQty()
	{
		return bookQty;
	}
	public void setBookId(int bookId) 
	{
		this.bookId = bookId;
	}
	public void setBookName(String bookName) 
	{
		this.bookName = bookName;
	}
	public void setBookPublication(String bookPublication)
	{
		this.bookPublication = bookPublication;
	}
	public void setBookIsbn(String bookIsbn) 
	{
		this.bookIsbn = bookIsbn;
	}
	public void setBookPrice(double bookPrice)
	{
		this.bookPrice = bookPrice;
	}
	public void setBookQty(int bookQty)
	{
		this.bookQty = bookQty;
	}
	
	
}

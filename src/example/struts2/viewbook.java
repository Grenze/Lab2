package example.struts2;

import com.opensymphony.xwork2.Action;

import java.util.Date;
import java.sql.*;


public class viewbook implements Action{
	private String authorID;
	private String name;
	private int age;
	private String country;	
	private String isbn;
	private String title;
	private String publisher;
	private Date publishdate;
	private double price;
	
	public String getAuthorID(){
		return authorID;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getCountry(){
		return country;
	}
	
	public String getIsbn(){
		return isbn;
	}

	
	public String getPublisher(){
		return publisher;
	}
	
	public Date getPublishdate(){
		return publishdate;
	}
	
	public double getPrice(){
		return price;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title.trim();
		
	}
	

	public String execute(){

		try{
	        Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
	        //Class.forName("org.gjt.mm.mysql.Driver");

		}
	    catch (Exception e) {

		    e.printStackTrace();
		    return "error";
		 	}
		try{
	        Connection connect = DriverManager.getConnection(
	        		"jdbc:mysql://bwphndouiaqc.rds.sae.sina.com.cn:10126/bookdb?characterEncoding=utf8&useSSL=true","lingo_yyl","aiyixidielu");		    	
	        		//连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

	        Statement stmt = connect.createStatement();	
	        //String str = new String(title.getBytes("ISO-8859-1"), "utf-8");
	        //title = str;
	        String Query = "select *from Book where Title='"+title+"';";	        
	        ResultSet rs = stmt.executeQuery(Query);
	        if(!rs.next()){
	        	rs.close();
	        	stmt.close();
	        	connect.close();
	        	return "error";
	        }
	        isbn = rs.getString("ISBN");
	        authorID = rs.getString("AuthorID");
	        publisher = rs.getString("Publisher");
	        publishdate = rs.getDate("Publishdate");
	        price = rs.getDouble("Price");
	        Query = "select *from Author where AuthorID='"+authorID+"';";
	        rs = stmt.executeQuery(Query);
	        if(!rs.next()){
	        	rs.close();
	        	stmt.close();
	        	connect.close();
	        	return "error";
	        }
	        name = rs.getString("Name");
	        age = rs.getInt("Age");
	        country = rs.getString("Country");
	        rs.close();
	        stmt.close();
	        connect.close();
	        return "success";
			}
		 catch(Exception e){

		    	e.printStackTrace();
		    	return "error";
		    }
		
	}


}

package example.struts2;

import com.opensymphony.xwork2.Action;

import java.sql.*;

public class Update_book implements Action{
	private String isbn;
	private String authorID;
	private String publisher;
	private String publish_date;
	private double price;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn.trim();
	}
	public String getAuthorID() {
		return authorID;
	}
	public void setAuthorID(String authorID) {
		this.authorID = authorID.trim();
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher.trim();
	}
	public String getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date.trim();
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	        String Query = "select *from Book where ISBN='"+isbn+"';";
	        ResultSet rs = stmt.executeQuery(Query);
	        if(!rs.next()){
	        	rs.close();
	        	stmt.close();
	        	connect.close();
	        	return "input";
	        }
	        if(authorID.isEmpty()){
	        	rs.close();
	        	stmt.close();
	        	connect.close();
	        	return "input";
	        }
	        Query = "select *from Author where AuthorID='"+authorID+"';";
	        rs = stmt.executeQuery(Query);
	        boolean flag = false;
	        if(!rs.next()){
	        	String command_ = "insert into Author (AuthorID) values('"+authorID+"');";
	        	stmt.executeUpdate(command_);
	        	rs.close();
	        	flag = true;
	        }
	        String command = "update Book set AuthorID='"+authorID+"' where ISBN='"+isbn+"';";
	        stmt.executeUpdate(command);
	        if(!getPublisher().isEmpty()){
	        	command = "update Book set Publisher='"+publisher+"' where ISBN='"+isbn+"';";
	        	stmt.executeUpdate(command);
	        }
	        if(!getPublish_date().toString().isEmpty()){
	        	command = "update Book set Publishdate='"+publish_date+"' where ISBN='"+isbn+"';";
	        	System.out.println(command);
	        	stmt.executeUpdate(command);
	        }
	        if(price != 0){
	        	command = "update Book set Price='"+String.valueOf(price)+"' where ISBN='"+isbn+"';";
	        	stmt.executeUpdate(command);
	        }
	        stmt.close();
	        connect.close();
	        if(flag){
	        	return "null";
	        }
	        return "success";
	        
		}	
		catch(Exception e){
	    	e.printStackTrace();
	    	return "error";
		}

	}

	
}

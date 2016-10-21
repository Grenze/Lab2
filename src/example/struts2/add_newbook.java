package example.struts2;

import com.opensymphony.xwork2.Action;

import java.sql.*;

public class add_newbook implements Action{
	private String isbn;
	private String title;
	private String authorID;
	private String publisher;
	private String publish_date;
	private double price = 0;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title.trim();
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
	        if(authorID.isEmpty() || isbn.isEmpty() || title.isEmpty()){
	        	stmt.close();
	        	connect.close();
	        	return "input";	        	
	        }
	        String Query1 = "select *from Book where ISBN='"+isbn+"';";
	        
	        if(stmt.executeQuery(Query1).next()){
	        	stmt.close();
	        	connect.close();
	        	return "input";
	        }
	        Query1 = "select *from Author where AuthorID='"+authorID+"';";
	        ResultSet rs1 = stmt.executeQuery(Query1);
	        boolean flag = true;
	        if(!rs1.next()){
	        	Query1 = "insert into Author (AuthorID) values ('"+authorID+"');"; 
	        	stmt.executeUpdate(Query1);
	        	flag = false;
	        }
	        rs1.close();
	        String command = "insert into Book (ISBN, Title, AuthorID) values('"+isbn+"','"+title+"','"+authorID+"');";
	        int result = stmt.executeUpdate(command);
	        if(result<=0){
	        	stmt.close();
	        	connect.close();
	        	return "error";
	        }
	        if(!getPublisher().isEmpty()){
	        	command = "update Book set Publisher='"+publisher+"' where ISBN='"+isbn+"';";
	        	stmt.executeUpdate(command);
	        }
	        if(!getPublish_date().toString().isEmpty()){
	        	command = "update Book set Publishdate='"+publish_date+"' where ISBN='"+isbn+"';";
	        	stmt.executeUpdate(command);
	        }
	        if(price != 0){
	        	command = "update Book set Price='"+String.valueOf(price)+"' where ISBN='"+isbn+"';";
	        	stmt.executeUpdate(command);
	        }
	        stmt.close();
	        connect.close();
	        if(flag==false){
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

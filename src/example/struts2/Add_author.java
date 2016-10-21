package example.struts2;

import com.opensymphony.xwork2.Action;

import java.sql.*;

public class Add_author implements Action{
	private String author_ID;
	private String name;
	private int age=0;
	private String country;
	private String title;
	private String isbn;
	public String getAuthor_ID() {
		return author_ID.trim();
	}

	public void setAuthor_ID(String author_ID) {
		this.author_ID = author_ID;
	}

	public String getName() {
		return name.trim();
	}

	public void setName(String name) {
		this.name = name.trim();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country.trim();
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String tilte) {
		this.title = tilte;
	}
	
	public String getIsbn() {
		return isbn;
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

	        String command;
	        command = "select ISBN from Book where AuthorID='"+author_ID+"';";
	        ResultSet rs = stmt.executeQuery(command);
	        if(!rs.next()){
	        	rs.close();
	        	stmt.close();
	        	connect.close();
	        	return "error";
	        }
	        isbn = rs.getString("ISBN");
	        rs.close();
	        if(!getName().isEmpty()){
	        	command = "update Author set Name='"+name+"' where AuthorID='"+author_ID+"';";
	        	stmt.executeUpdate(command);
	        }
	        if(age!=0){
	        	command = "update Author set Age='"+age+"' where AuthorID='"+author_ID+"';";
	        	stmt.executeUpdate(command);
	        }
	        if(!getCountry().isEmpty()){
	        	command = "update Author set Country='"+country+"' where AuthorID='"+author_ID+"';";
	        	stmt.executeUpdate(command);
	        }
	        stmt.close();
	        connect.close();
	        if(title.isEmpty()){
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

package example.struts2;

import com.opensymphony.xwork2.Action;

import java.util.LinkedList;
import java.util.List;
import java.sql.*;
public class Author_Books implements Action {
	private String authorID;
	private String name;
	private List<String> books;
	public String getAuthorID() {
		return authorID;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.trim();
	}

	
	public List<String> getBooks() {
		return books;
	}
	
	
	public String execute(){
			books = new LinkedList<String>();

			if(getName().isEmpty()){
				return "input";
			}
		    try {
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
		        String Query = "select AuthorID from Author where Name='"+name+"';";        
		        ResultSet rs = stmt.executeQuery(Query);
		        if(!rs.next()){
		        	rs.close();
		        	stmt.close();
		        	connect.close();
		        	return "error";
		        }
		        authorID = rs.getString("AuthorID");
		        Query = "select Title from Book where AuthorID='"+authorID+"';";	        
		        rs = stmt.executeQuery(Query);
		    while(rs.next()){
		    	books.add(rs.getString("Title"));
		    }
		    rs.close();
		    stmt.close();
		    connect.close();
		    }
		    catch(Exception e){
		    	e.printStackTrace();
		    	return "error";
		    }

			return "success";
	}

	


	
}

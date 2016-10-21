package example.struts2;

import com.opensymphony.xwork2.Action;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class inputMessage implements Action{
	private List<List<String>> Author_List; 
	private List<List<String>> Book_List;
	
	public List<List<String>> getAuthor_List() {
		return Author_List;
	}

	public List<List<String>> getBook_List() {
		return Book_List;
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
	        String Query = "select *from Author;";
	        ResultSet rs1 = stmt.executeQuery(Query);
	        if(!rs1.next()){
	        	rs1.close();
	        	stmt.close();
	        	connect.close();
	        	return "error";
	        }
	        Author_List = new ArrayList<List<String>>();
	        List<String> li=new ArrayList<String>();
	        li.add("作者编号");
	        li.add("作者姓名 ");
	        li.add("作者年龄");
	        li.add("作者国籍");
	        Author_List.add(li);
	        
        	li=new ArrayList<String>();
        	li.add(rs1.getString("AuthorID"));
        	li.add(rs1.getString("Name"));
        	li.add(rs1.getString("Age"));
        	li.add(rs1.getString("Country"));
        	Author_List.add(li);	        
	        
	        
	        while(rs1.next()){
	        	li=new ArrayList<String>();
	        	li.add(rs1.getString("AuthorID"));
	        	li.add(rs1.getString("Name"));
	        	li.add(rs1.getString("Age"));
	        	li.add(rs1.getString("Country"));
	        	Author_List.add(li);
	        }
	        Query = "select *from Book;";
	        rs1 = stmt.executeQuery(Query);
	        if(!rs1.next()){
	        	rs1.close();
	        	stmt.close();
	        	connect.close();
	        	return "error";
	        }
	        Book_List = new ArrayList<List<String>>();
	        li=new ArrayList<String>();
	        li.add("国际标准书号");
	        li.add("书籍名称");
	        li.add("作者编号");
	        li.add("出版社");
	        li.add("发行日期");
	        li.add("图书价格");
	        Book_List.add(li);
	        
        	li=new ArrayList<String>();
        	li.add(rs1.getString("ISBN"));
        	li.add(rs1.getString("Title"));
        	li.add(rs1.getString("AuthorID"));
        	li.add(rs1.getString("Publisher"));
        	li.add(rs1.getString("Publishdate"));
        	li.add(rs1.getString("Price"));
        	Book_List.add(li);
        	
	        while(rs1.next()){
	        	li=new ArrayList<String>();
	        	li.add(rs1.getString("ISBN"));
	        	li.add(rs1.getString("Title"));
	        	li.add(rs1.getString("AuthorID"));
	        	li.add(rs1.getString("Publisher"));
	        	li.add(rs1.getString("Publishdate"));
	        	li.add(rs1.getString("Price"));
	        	Book_List.add(li);
	        }	       
	        rs1.close();
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
package example.struts2;

import com.opensymphony.xwork2.Action;

import java.sql.*;

public class deleteBook implements Action{
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title.trim();
	}
	
	public String execute(){
		try{
	        Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
	        //Class.forName("org.gjt.mm.mysql.Driver");
		}
	    catch (Exception e) {
		    e.printStackTrace();
		    return "error";
		 	}
		try{
	        Connection connect = DriverManager.getConnection(
	        		"jdbc:mysql://bwphndouiaqc.rds.sae.sina.com.cn:10126/bookdb?characterEncoding=utf8&useSSL=true","lingo_yyl","aiyixidielu");		    	
	        		//����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������
	        Statement stmt = connect.createStatement();	
	        String Query = "delete from Book where Title='"+title+"';";
	        int result = stmt.executeUpdate(Query);
	        stmt.close();
	        connect.close();
	        if(result>0){
	        	return "success";
	        }
	        else{
	        	return "error";
	        }
	        
		}
		catch(Exception e){
	    	e.printStackTrace();
	    	return "error";
		}
	}
}

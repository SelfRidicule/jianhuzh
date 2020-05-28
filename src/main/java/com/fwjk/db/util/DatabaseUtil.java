package com.fwjk.db.util;

import oracle.sql.BLOB;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {

	private Connection conn ;
	private List<Statement> list = new ArrayList<Statement>();
	private ArrayList params = null;
	
	public void getConnection(String url, String user, String password){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver") ;
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver") ;
			conn = DriverManager.getConnection(url, user, password) ;
		}catch (Exception e) {
			
		}
	}
	
	public void setParams(ArrayList params) {
		this.params = params;
	}

	public ResultSet getResult(String sql) {
		try {
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql) ;
			
			 list.add(stmt);
			 return rs;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void insResultByStmt(String sql) throws SQLException {
		 Statement stmt = conn.createStatement();
		 list.add(stmt);
		 stmt.execute(sql) ;						 
	}
	
	public void insResultByPStmt(String sql) throws SQLException {
		 PreparedStatement pstmt = conn.prepareStatement(sql);
		 if(params != null){
			 for(int i=0; i<params.size(); i++){
				 if(params.get(i) instanceof String){
					 pstmt.setString(i+1, (String)params.get(i)) ;
				 }else if(params.get(i) instanceof Date){
					 pstmt.setDate(i+1, (Date)params.get(i)) ;
				 }else if(params.get(i) instanceof InputStream){
					 pstmt.setBlob(i+1, (InputStream)params.get(i));
				 }else if(params.get(i) instanceof BLOB){
					 pstmt.setBlob(i+1, (BLOB)params.get(i));
				 }else if(params.get(i) instanceof byte[]){
					 pstmt.setBytes(i+1, (byte[])params.get(i));
				 }else{
					 pstmt.setString(i+1, (String)params.get(i)) ;
				 }
			 }
		 }
		 list.add(pstmt);
		 pstmt.execute();			 
	}
	
	public void updResultByPStmt(String sql) throws SQLException {
		 PreparedStatement pstmt = conn.prepareStatement(sql);
		 if(params != null){
			 for(int i=0; i<params.size(); i++){
				 if(params.get(i) instanceof String){
					 pstmt.setString(i+1, (String)params.get(i)) ;
				 }else if(params.get(i) instanceof Date){
					 pstmt.setDate(i+1, (Date)params.get(i)) ;
				 }else if(params.get(i) instanceof InputStream){
					 pstmt.setBlob(i+1, (InputStream)params.get(i));
				 }else if(params.get(i) instanceof BLOB){
					 pstmt.setBlob(i+1, (BLOB)params.get(i));
				 }else if(params.get(i) instanceof byte[]){
					 pstmt.setBytes(i+1, (byte[])params.get(i));
				 }else{
					 pstmt.setString(i+1, (String)params.get(i)) ;
				 }
			 }
		 }
		 list.add(pstmt);
		 pstmt.executeUpdate();	 
	}
	
	public void close() {
		for (Statement stmt : list) {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {	}
		}
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
		}
	}
}
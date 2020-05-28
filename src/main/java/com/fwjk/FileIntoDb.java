package com.fwjk;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class FileIntoDb {
	String url="";
	String username ="";
	String password ="";
	String bmc="";
	Connection con;
	 public Map getMap(){
	    	Map map= new HashMap();
	    	try {
	    		try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection(url,username,password);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String sql ="select a.column_name, DATA_TYPE,a.comments from user_col_comments a, user_tables b, user_tab_columns c"
							 +" where a.table_name = b.TABLE_NAME"
							 +" and a.table_name = c.TABLE_NAME"
							 +" and c.COLUMN_NAME = a.column_name"
							 +" and a.table_name = 'PASSENGER_OUT'";
				System.out.println(sql);
				Statement stmts = con.createStatement();
				ResultSet rs =  stmts.executeQuery(sql); 
				while(rs.next()){
					map.put(rs.getString("column_name"), rs.getString("DATA_TYPE"));
				}
					
			} catch (SQLException e) {
				e.printStackTrace();
			}  	
			return map;
	    	
	    }
	public void readZipFile(File thefile) throws SQLException{
		StringBuffer xmlList = new StringBuffer();
		StringBuffer directories = new StringBuffer();
		
		try{
			
			BufferedReader  br  = null;
			BufferedInputStream is = null;
			ZipFile zfile = new ZipFile(thefile);
			Enumeration emu = zfile.entries();
			ZipEntry entry;
			int i = 0;
			Object obj = null;
			int a=1;
			while(emu.hasMoreElements()){
				obj = emu.nextElement();
				entry = (ZipEntry)obj;
				br = new BufferedReader(new InputStreamReader(zfile.getInputStream(entry)));
			    InputSource  iscource = new InputSource(br);
				DocumentBuilder builder = null;
				Document doc = null;
				
				DocumentBuilderFactory  dom = DocumentBuilderFactory.newInstance();
				
				try {
					builder = dom.newDocumentBuilder();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   try {
					doc = builder.parse(iscource);
				} catch (SAXException e) {
					System.out.println("--thefile--"+thefile+"---"+obj);
					exceptionLog("--thefile--"+thefile+"---"+obj);
					exceptionFile(thefile.toString(),obj.toString(),br);
					e.printStackTrace();
				}		
				if(doc!=null){
					NodeList nodeList = doc.getElementsByTagName("RECORD");
					for(int j=0;j<nodeList.getLength();j++){
					StringBuffer sb= new StringBuffer("insert into PASSENGER_OUT (");
					 for(int n=0;n<nodeList.item(j).getChildNodes().getLength();n++){
						 
						 if("#text".equals(nodeList.item(j).getChildNodes().item(n).getNodeName())){
							 
						 }else{
							 if(n==nodeList.item(j).getChildNodes().getLength()-2){
								 
								 sb.append(nodeList.item(j).getChildNodes().item(n).getNodeName());
							 }else{
								
								 sb.append(nodeList.item(j).getChildNodes().item(n).getNodeName()+",");
							 }
							 
						 }
					
					  }
					 
					 sb.append(") values( ");
			          for(int n=0;n<nodeList.item(j).getChildNodes().getLength();n++){
			        	 
						if("#text".equals(nodeList.item(j).getChildNodes().item(n).getNodeName())){
							 
						}else{
							 if(n==nodeList.item(j).getChildNodes().getLength()-2){
								 sb.append(nodeList.item(j).getChildNodes().item(n).getTextContent().trim());
							 }
							 
							 
						}
					
						}
			          
			          sb.append(")");		          
			         
			          
			          
			          
				}
					
				}
				
			} 
			
      	    
      		br.close();
			zfile.close();   	    
		}catch(ZipException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
  	    //delete(thefile);

	}
	public void logText(String str){
		String dirName = "D:/LOG";
		String fileName = "logger.txt";
		File savePath = new File(dirName);
		if(!savePath.exists()){
			savePath.mkdir();
		}
		try {
			File file = new File(savePath+"/"+fileName);
			if(file!=null&&file.exists()){
				file.createNewFile();
			}
			
            FileWriter fw = new FileWriter(file,true);
            fw.write(str);
            fw.write("\r\n");
            fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(File fileName){
		if(fileName.exists() && fileName.isFile()){
		    fileName.delete();
		    System.out.println("ɾ����"+fileName);
		}
	}

	public void  downUrlXml(String fileUrl,String downPath){
		File savePath = new File(downPath);
		if(!savePath.exists()){
			savePath.mkdir();
		}
		String[] urlname = fileUrl.split("/");
		int len = urlname.length-1;
		String uname = urlname[len];
		try{
			File file = new File(savePath+"/"+uname);
			if(file!=null&&file.exists()){
				file.createNewFile();
			}
			OutputStream out = new FileOutputStream(file);
			URL url = new URL(fileUrl);
			HttpURLConnection connection=(HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream input = connection.getInputStream();
			byte[] buffer = new byte[4*1024];
			int byteRead =-1;
			while((byteRead=(input.read(buffer)))!=-1){
				out.write(buffer,0,byteRead);
			}
			out.flush();
			input.close();
			out.close();
			
			readZipFile(file);
		}catch(Exception e){
			System.out.println("��ȡʧ�ܣ���");
			e.printStackTrace();
		}
	}
	public void exceptionFile(String theFile,String fileName,BufferedReader br){
	    String dirName = "D:/ExceptionFile";
	    File savePath = new File(dirName);
		if(!savePath.exists()){
			savePath.mkdir();
		}
		try {
			File file = new File(savePath+"/"+theFile.substring(8)+"--"+fileName);
			if(file!=null&&file.exists()){
				file.createNewFile();
			}
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			String read=null;
			while((read=br.readLine())!=null){
				out.write(read+"\r\n");
			}
			out.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

    public void exceptionLog(String str){
	
		String dirName = "D:/ExceptionLog";
		String fileName = "logger.txt";
		File savePath = new File(dirName);
		if(!savePath.exists()){
			savePath.mkdir();
		}
		try {
			File file = new File(savePath+"/"+fileName);
			if(file!=null&&file.exists()){
				file.createNewFile();
			}
			
	        FileWriter fw = new FileWriter(file,true);
	        fw.write(str);
	        fw.write("\r\n");
	        fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public static  void main(String[] args)throws Exception {

		FileTest ft = new FileTest();
		File f = new File("D:/DATA/S32-09000151_31624398574964052.zip");
		ft.readZipFile(f);
		//ft.delete(f);
	}
}

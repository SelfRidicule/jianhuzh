package com.fwjk;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.io.StringReader;

/*
 * ���߽ӿڷ�����Ϣ������
 */
public class RBSPMessageParser {

	private String context = null;

	//private Map<String, XPathExpression> exprCache = java.util.concurrent.ConcurrentHashMap<K, V>();
	private RBSPMessageParser(String context) {
		this.context = context;
	}
	
	public static RBSPMessageParser create(String context){
		return new RBSPMessageParser(context);
	}

	private static XPathExpression createXPathExpr(String xpathExpr)
			throws XPathExpressionException {
		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xPath = xPathFactory.newXPath();
		
		XPathExpression expr = xPath.compile(xpathExpr);
		return expr;
	}
	
	private static Document createXmlDoc(String xmlText) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory docFactory = 
			DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		InputSource sm = new InputSource(new StringReader(xmlText));
		return docBuilder.parse(sm);
	}

	public String getMethodName(){
		try{
			XPathExpression expr = createXPathExpr("//Method/Items/Name()");
			return (String)expr.evaluate(createXmlDoc(this.context), XPathConstants.STRING);
		}catch(Exception e) {
			System.out.println("getMethodName Error:");
			e.printStackTrace();
		}
		return "";
	}
	
	/*
	 * ��ȡ����ֵΪString�Ľ��
	 */
	public String getMethodStringValue() {
		if (this.context == null) return "";
		
		try {
			XPathExpression expr = createXPathExpr("//Method/Items/Item/Value/Data/text()");
			return (String)expr.evaluate(createXmlDoc(this.context), XPathConstants.STRING);
			
		} catch (Exception e) {
			System.out.println("getMethodValue Error:");
			e.printStackTrace();
		}

		return "";
	}


}

class DownloadResponse{
	private long total=0L;
	private long current=0L;
	private String message ="Error";
	private String fileURL="";
	
	private final static String FLAG="<>";
		
	private DownloadResponse(){
	}
	
	public boolean empty(){
		return (total == 0L && current == 0L 
				&& "Error".equals(message) && "".equals(fileURL));
	}
	
	private void parse(String text){
		String[] infos =text.split(DownloadResponse.FLAG);
		if (infos.length == 5){
			this.total= Long.valueOf(infos[0]);
			this.current = Long.valueOf(infos[1]);
			this.message = infos[3];
			this.fileURL = infos[4];	
		}
	}
	
	public static DownloadResponse parseByText(String text){
		if (text == null) return DownloadResponse.getEmpty();
		text = text.trim();
		DownloadResponse response = new DownloadResponse();
		response.parse(text);
		return response;
	}
	
	public static DownloadResponse getEmpty(){
		return new DownloadResponse();
	}
	
	public long getTotal() {
		return total;
	}

	public long getCurrent() {
		return current;
	}

	public String getMessage() {
		return message;
	}

	public String getFileURL() {
		return fileURL;
	}
	
	@Override
	public String toString(){
		return "����������" + getTotal() + "\n" +
		"��ǰ������" + getCurrent() + "\n" +
		"������Ϣ��" + getMessage() + "\n" +
		"�ļ�λ�ã�" + getFileURL() + "\n" ;
	}

	public boolean isFinished() {
		return (getCurrent() == getTotal());
	}
}
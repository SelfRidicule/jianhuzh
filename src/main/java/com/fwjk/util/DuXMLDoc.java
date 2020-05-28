package com.fwjk.util;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class DuXMLDoc {
	public static List<List<String>> xmlElementsLast(byte[] xmlDoc) {
		if (xmlDoc != null) {
			// ����һ���µ��ַ���
			StringReader read = new StringReader(new String(xmlDoc));
			// �����µ�����ԴSAX ��������ʹ�� InputSource ������ȷ����ζ�ȡ XML ����
			InputSource source = new InputSource(read);
			// ����һ���µ�SAXBuilder
			SAXBuilder sb = new SAXBuilder();
			try {
				// ͨ������Դ����һ��Document
				Document doc = sb.build(source);
				// ȡ�ĸ�Ԫ��
				Element root = doc.getRootElement();
				// �õ���Ԫ��������Ԫ�صļ���
				List jiedian = root.getChildren();
				Element et = null;
				List<List<String>> list = new ArrayList<List<String>>();
				for (int i = 3; i < jiedian.size(); i++) {
				
					et = (Element) jiedian.get(i);// ѭ�����εõ���Ԫ��
					List<Element> ee=et.getChildren();
					for (Element ob : ee) {
						
				 
						for (Object ob1 : ob.getChildren()) {
							Element e=(Element)ob1;
							for(Object ll:e.getChildren())
							{
								Element l=(Element)ll;
								for(Object ll1:l.getChildren())
								{
									Element l1=(Element)ll1;
									List<String> listob = new ArrayList<String>();
									for(Object ll2:l1.getChildren())
									{
										Element l2=(Element)ll2;
						listob.add(l2.getValue());
									}
									list.add(listob);
								}
									}
						}
				
					
					}
				
				}
				return list;
			} catch (JDOMException e) {
				// TODO �Զ����� catch ��
				e.printStackTrace();
			} catch (IOException e) {
				// TODO �Զ����� catch ��
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void main(String[] args) {
		List<List<String>> aa =null;
//		String result = TestDataAll.Query("http://10.32.203.231:8080/node","C32-00000147", "S32-00000509", "320623197711067812", "����",
//				 "320600180000", "����ʡ��ͨ�й����ַ���֧��", "771106", "��ͨ���ۺϲ�ѯ",
//				"10.36.10.81", "A4:1F:72:53:DA:54", " GMSFHM='324117198208170816' ",
//				0,5);
//	
//
//	List<List<String>>  ccc= xmlElementsLast(result.getBytes());
//
//for(List<String> a:ccc)
//{
//	System.out.println();
//	
//		System.out.println(a.get(0));
//		System.out.println(a.get(7));
//		
//		
//	}
	
	}
}
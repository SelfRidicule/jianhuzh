package com.fwjk.util;

import net.sf.json.JSONObject;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class CommonUtil {
	public static List<List<String>> xmlElementsLast(String xmlDoc) {
		try {
			// ����һ���µ��ַ���
			StringReader read = new StringReader(xmlDoc);
			// �����µ�����ԴSAX ��������ʹ�� InputSource ������ȷ����ζ�ȡ XML ����
			InputSource source = new InputSource(read);
			// ����һ���µ�SAXBuilder
			SAXBuilder sb = new SAXBuilder();

			// ͨ������Դ����һ��Document
			Document doc;

			doc = sb.build(source);

			// ȡ�ĸ�Ԫ��
			Element root = doc.getRootElement();

			// �õ���Ԫ��������Ԫ�صļ���
			List jiedian = root.getChildren();
			Element et = null;
			List<List<String>> list = new ArrayList<List<String>>();
			for (int i = 0; i < jiedian.size(); i++) {
				List<String> listob = new ArrayList<String>();
				et = (Element) jiedian.get(i);// ѭ�����εõ���Ԫ��
				for (Object ob : et.getChildren()) {
					Element obet = (Element) ob;
					listob.add(obet.getValue());

				}
				list.add(listob);
			}
			return list;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] getByteArray(String pathfile) {

		try {
			File file = new File(pathfile);
			FileInputStream in;
			in = new FileInputStream(file);

			byte[] by = new byte[(int) file.length()];
			in.read(by, 0, (int) file.length());
			in.close();
			return by;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return XmlToString(pathfile);
		}
	}

	public static byte[] XmlToString(String xml) {
		if (xml != null)
			return xml.getBytes();
		return null;

	}

	public static void main(String[] args) {
		// ,{�ȶ�Ŀ����������:320�����켣(�ȶ�ǰ�ÿ�),�ȶԼ�¼��:0,���м�¼��:0,����״̬:false,�ȶԽ�����������:�ȶ���...},{�ȶ�Ŀ����������:���ٹ�·������Ϣ(�ȶ�ǰ�ÿ�),�ȶԼ�¼��:14,���м�¼��:0,����״̬:true,�ȶԽ�����������:�������,û�в��ص�������Ϣ!}]

		JSONObject builder = JSONObject
				.fromObject("{Result:{'tableName':'ȫ������������','columnsName':'HPHM,HPZL,CSYS','data':{'HPHM':'��A00860W','HPZL':'02','CSYS':'null'}}}");
		System.out.println(builder.get("Result"));
		System.out.println(JSONObject.fromObject(
				JSONObject.fromObject(builder.get("Result")).get("data")).get(
				"HPHM"));

	}
}

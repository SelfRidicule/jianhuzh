package com.zhongzhou.utils;

import com.zhongzhou.dto.ColumnDetail;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelfXmlUtil {


    /**
     * 初始化
     */
    public static List<Map> initDataList(String xml){

        if(xml == null || "".equals(xml)){
            return new ArrayList<Map>();
        }


        xml.replace("\\\"","\"");
        xml = xml.replace("\\n","");

        if(xml.indexOf("?xml") != -1){
            xml =  xml.substring(xml.indexOf(">") + 1);
        }

        return parseDataListXml(xml) ;
    }


    /**
     * 解析xml字符串
     */
    private static List<Map> parseDataListXml(String xml){


        List<Map> list = new ArrayList<>();

        try {

            //加载xml
            Document doc = DocumentHelper.parseText(xml);

            //获取根节点
            Element rootElement = doc.getRootElement();

            Element Value_Element = rootElement.element("Method").element("Items").element("Item").element("Value");

            List<Element>  row_list = Value_Element.elements("Row");

            if(row_list != null && row_list.size() >= 4){

                    //多个结果
                    for (int i = 3; i < row_list.size(); i++) {

                            int contentIndex = i;
                            Map<String , Object> map = getDataListMap( row_list  ,  contentIndex);

                            list.add(map);

                    }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }



        return list;
    }

    private  static Map<String , Object>  getDataListMap(List<Element>  row_list  , int contentIndex){

        Map<String , Object> map = new HashMap<>();

        //字段信息
        for (int j = 0; j < row_list.get(0).elements("Data").size(); j++) {

            int index  = j  ;

            //column
            Element ele_column = (Element) row_list.get(0).elements("Data").get(index);
            String column = ele_column.getText();

            //aliasName
            Element aliasName_column = (Element) row_list.get(1).elements("Data").get(index);
            String aliasName = aliasName_column.getText();

            //type
            Element type_column = (Element) row_list.get(2).elements("Data").get(index);
            String type = type_column.getText();

            //content
            Element content_column = (Element) row_list.get(contentIndex).elements("Data").get(index);
            String content = content_column.getText();


            ColumnDetail columnDetail = new ColumnDetail();
            columnDetail.setColumn(column);
            columnDetail.setAliasName(aliasName);
            columnDetail.setType(type);
            columnDetail.setContent(content);


            map.put(column , columnDetail);
        }



        return map;
    }


    private static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File("E:/xml.txt")));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        String xml = result.toString().replace("\\\"","\"");
        initDataList(xml);
    }

}

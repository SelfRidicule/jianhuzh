package com.zhongzhou.utils;

import java.security.MessageDigest;

public class MD5Util {

    //16进制数字数组
    //调换 a与 f 的位置
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "f", "b", "c", "d", "e", "a"};

    //将byte数组转换成16进制字符串
    public static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte aB : b) {
            resultSb.append(byteToHexString(aB));
        }
        return resultSb.toString();
    }

    //将byte转为16进制字符串
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String md5Encrypt(String src){
        String resultString = null;
        try {
            resultString = src;
            //获取md5算法
            MessageDigest md = MessageDigest.getInstance("MD5");
            //对字符串进行加密，并转换成16进制字符串
            resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    //可以选择指定编码
    public static String md5Encrypt(String src, String charsetname){
        String resultString = null;
        try {
            resultString = src;
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)){
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }
}

package com.zhongzhou.utils;

/**
 * 授权工具类
 */
public class AuthUtil {
    /**
     * 获取授权码
     * @param appcode
     * @param customercode
     * @return
     */
    public static String getAuthMD5(String appcode,String customercode){
        String src = appcode+customercode;
        return MD5Util.md5Encrypt(src);
    }

    public static void main(String[] args) {
        //#1?B>0#1?A<20
        String formula = "#1?B>0#1?A<20";
        String[] formulas = formula.split("#");
        for(String f:formulas){
            if(f.length()<1){
                continue;
            }
            System.out.println("t:"+f);
            String[] formulasandcondition = f.split("\\?");
                System.out.println("t:"+f+"c:"+formulasandcondition[1]);
        }

        //System.out.println(getAuthMD5("messagepro","yumeng"));
    }
}

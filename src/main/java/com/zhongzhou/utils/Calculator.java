package com.zhongzhou.utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Calculator {


    public static void main(String[] args) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
        String expression = "10 > (1+10/2)";
        //expression = expression.replaceAll("m","11");
        Long a = 408l;
        Long b = 408l;
        try {
            String result = String.valueOf(scriptEngine.eval(expression));
            System.out.println(a.longValue()==b.longValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

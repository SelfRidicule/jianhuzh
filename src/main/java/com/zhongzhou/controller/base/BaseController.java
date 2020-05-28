package com.zhongzhou.controller.base;

import org.springframework.stereotype.Controller;

import com.zhongzhou.entity.system.TSysUser;
import com.zhongzhou.utils.HttpKit;

public class BaseController {

    protected TSysUser getUser(){
        TSysUser user = (TSysUser) HttpKit.getRequest().getSession().getAttribute("user");
        return user;
    }

    public static void main(String[] args) {



        //|=按位运算
        //a |=b -----> a=a|b , 而 | 是将a和b转为二进制后的或运算。有一真为真，同假为假。




        //&=按位运算
        //a &=b -----> a=a&b , 而 & 是将a和b转为二进制后的&运算。有一假为假，同真为真。




        //^(亦或运算) ，针对二进制，相同的为0，不同的为1




        //<<(向左位移) 针对二进制，转换成二进制后向左移动N位，后面空位正数补0，负数补1 , 等于乘于2的n次方

        System.out.println(Integer.toBinaryString( 144));
        System.out.println(Integer.toBinaryString(144<<3));

        System.out.println(Integer.toBinaryString( -14));
        System.out.println(Integer.toBinaryString(-14<<3));

        System.out.println("=======================================");

        //>>(向右位移) 针对二进制，转换成二进制后向右移动N位，前面空位正数补0，负数补1 ， 等于除于2的n次方
        System.out.println(Integer.toBinaryString( 144));
        System.out.println(Integer.toBinaryString(144>>3));

        System.out.println(Integer.toBinaryString( -14));
        System.out.println(Integer.toBinaryString(-14>>3));



    }
    
}

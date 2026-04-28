package com.zzy.WrapperClass.Integer;

import javax.naming.InsufficientResourcesException;
import javax.swing.text.WrappedPlainView;

public class TestInteger {
    private static void test() {
        Integer wrapperInt = 100;

        //整数转成二进制字符串
        String binStr = Integer.toBinaryString(wrapperInt);
        //整数转成八进制字符串
        String octStr = Integer.toOctalString(wrapperInt);
        //整数转成十六进制字符串
        String hexString = Integer.toHexString(wrapperInt);
        //字符型整数转为int类型整数
        int integer = Integer.parseInt(wrapperInt.toString());
        System.out.println("输入整数" + wrapperInt);
        System.out.println("整数转成二进制字符串");
        System.out.println(binStr);
        System.out.println("整数转成八进制字符串");
        System.out.println(octStr);
        System.out.println(" 整数转成十六进制字符串");
        System.out.println(hexString);
        System.out.println("字符型整数转为int类型整数");
        System.out.println(integer);
    }

    public static void main(String[] args) {
        test();
    }
}

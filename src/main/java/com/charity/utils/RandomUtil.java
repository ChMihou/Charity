package com.charity.utils;

public class RandomUtil {
    //随机得到6位数
    public static int getRandNum() {
        return (int)((Math.random() * 9 + 1) * 100000);
    }
}

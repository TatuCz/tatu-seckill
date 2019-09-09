package com.tatu.seckill.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

public class MD5Util {

    private final static String saltChars = "qazwsxedcrfvtgbyhnujmikolp";

    public static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }

    public static String md5(String str, String salt) {
        return DigestUtils.md5Hex(str + salt);
    }

    public static String getRandomSalt() {
        return getRandomSalt(4);
    }

    public static String getRandomSalt(int length) {
        if (length <= 0) length = 1;
        StringBuilder result = new StringBuilder(length);
        Random random = new Random();
        for(int i=0; i<length; i++) {
            result.append(saltChars.charAt(random.nextInt(saltChars.length())));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String salt = getRandomSalt();
        System.out.println("salt:" + salt);
        System.out.println(md5("123456" + salt));
    }
}

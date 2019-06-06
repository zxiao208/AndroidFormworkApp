package com.zhaoxiao.androidformworkapp.utils.encryptutils;


import org.apache.commons.net.util.Base64;

/**
 * @author Administrator
 * @date 2019/2/18 10:09
 */
public class Base64Encoder {
    /**
     * base64字符串转byte[]
     *
     * @param base64Str
     * @return
     */
    public static byte[] decode(String base64Str) {
        return Base64.decodeBase64(base64Str);
    }

    /**
     * 二进制数据编码为BASE64字符串
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String encode(final byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }

    public static void main(String[] args) {
        byte [] b = Base64Encoder.decode("eyJzeWpDb2RlIjoiOTEwNSIsInN0b3JlTm8iOiIyMTAxMSJ9");
        String s = new String(b);
        System.out.print(s);
    }
}

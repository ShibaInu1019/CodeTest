package md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test {


    //信息摘要 单项加密方法
    public static String encrypt(String str, String type) throws NoSuchAlgorithmException {
        /*
         * MD5、SHA1、SHA-256、SHA-512
         * */
        MessageDigest md = MessageDigest.getInstance(type);

        /*
         * update方法负责加密
         * 字符串转字节数组：str.getBytes("编码格式")
         * */
        md.update(str.getBytes());
        /*
         *获取摘要结果，加密后的数组
         * */
        byte[] bs = md.digest();

        /*
         * 变为16进制，使用字符串进行拼接
         * */
        StringBuilder res = new StringBuilder();
        for (byte b : bs) {
            res.append(String.format("%02X", b));
        }
        return res.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

        //信息摘要
        /*
         * md5,sha1,sha-256,sha-512
         * */
        String str = "helloworld";
        MessageDigest md = MessageDigest.getInstance("MD5");

        /*
         * update方法负责加密
         * 字符串转字节数组：str.getBytes("编码格式")
         *
         * */
        md.update(str.getBytes());

        /*
        获取加密后的数组
        * */
        byte[] bs = md.digest();

        /*
         * 变为16进制
         * */
        String res = "";
        for (byte b : bs) {
            res += String.format("%02X", b);
        }


        System.out.println("MD5加密结果："+encrypt(str,"MD5"));
        System.out.println("SHA1加密结果："+encrypt(str,"SHA1"));
        System.out.println("SHA-256加密结果："+encrypt(str,"SHA-256"));
        System.out.println("SHA-512加密结果："+encrypt(str,"SHA-512"));
    }
}

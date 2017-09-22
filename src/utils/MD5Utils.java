package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Utils {
    public static String md5Password(String passwd) {

        try {
            MessageDigest digest = null;
            digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(passwd.getBytes());
            StringBuffer buffer = new StringBuffer();
            for (byte b : result) {
                //0xff是十六进制，十进制为255

                int nuber = b & 0xff;
                String str = Integer.toHexString(nuber);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }
            //返回加密后的值
            return buffer.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

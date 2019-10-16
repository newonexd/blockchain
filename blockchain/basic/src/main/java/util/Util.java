package util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: rxd
 * @date: 2019-09-22 15:06
 */
public class Util {
    private Util() {

    }

    public static String bytes_to_hex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xff & bytes[i]);
            if (hex.length() == 1)
                stringBuilder.append('0');
            stringBuilder.append(hex);
        }
        return stringBuilder.toString();
    }

    /**
     * HASH256算法
     *
     * @param str
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String SHA256(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        return bytes_to_hex(messageDigest.digest(str.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * 定时器
     */


    public static void firstBroad(String broadcast, Object obj) throws IOException {
        StringBuilder stringBuilder = new StringBuilder(broadcast.substring(0, broadcast.lastIndexOf(".") + 1));
        int basic = stringBuilder.length();
        for (int i = 2; i < 10; i++) {
            stringBuilder.append(i);
            if (!stringBuilder.toString().equals(broadcast))
                SendMsg.send_msg(stringBuilder.toString(), obj);
            stringBuilder.deleteCharAt(basic);
        }
    }
}

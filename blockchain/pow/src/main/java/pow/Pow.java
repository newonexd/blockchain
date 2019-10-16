package pow;

import util.Util;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 * @author: rxd
 * @date: 2019-09-22 14:50
 */
public class Pow {
    private static final Logger LOGGER = Logger.getLogger(Pow.class.getName());


    /**
     * 根据之前的难度值调节新的难度值
     */
    private static String generate_diffcult_value() {
        //获取前一个区块的难度值
        /**
         * 000 : 100ms  前导0个数
         * 0000: <200ms
         * 00000: >2000ms
         * 000000: >20s
         * 新难度值 = 前一区块难度值*(前n个区块产出消耗时间/n*要求出块时间)
         */
        //1.获取前一个区块难度值
        String old_diffcult_value = "0000";
        //2.获取第前n个区块时间戳
        //3.与当前时间相减 -> 得出前n个区块产出消耗时间
        //4.4.计算新难度值
        return old_diffcult_value;
    }

    /**
     * pow共识 计算
     *
     * @param str 用于计算nonce的原字符串
     * @return nonce 计算出的nonce
     */
    public static int pow(String str) throws NoSuchAlgorithmException {
        long start_time = System.currentTimeMillis();
        String new_diffcult_value = generate_diffcult_value();
        int nonce = 0;
        while (true) {
            String hash = Util.SHA256(str + nonce);
            if (hash.startsWith(new_diffcult_value)) {
                break;
            } else
                nonce++;
        }
        LOGGER.info("POW consume time is : " + (System.currentTimeMillis() - start_time) / 1000 + " s");
        return nonce;
    }

    /**
     * 区块验证
     *
     * @param str
     * @return
     */
    public static boolean verify_block(String str, String diffcult_value) throws NoSuchAlgorithmException {
        return Util.SHA256(str).startsWith(diffcult_value);
    }


}

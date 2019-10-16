package pow;


import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

/**
 * @author: rxd
 * @date: 2019-09-22 15:37
 */
public class PowTest {

    @Test
    public void test() throws NoSuchAlgorithmException {
        String str = "test_value";
        System.out.println(Pow.pow(str));
    }

    @Test
    public void test1() throws NoSuchAlgorithmException {
        System.out.println(Pow.verify_block("test_value"+Pow.pow("test_value"),"0000"));
    }
}

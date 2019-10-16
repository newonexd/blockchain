package common;

import java.util.HashSet;

/**
 * @author: rxd
 * @date: 2019-09-22 14:43
 */
public class Block {
    private static final int MAX_CAPACITY = 100;

    private HashSet<Transaction> hashSet = new HashSet<Transaction>(MAX_CAPACITY);

}

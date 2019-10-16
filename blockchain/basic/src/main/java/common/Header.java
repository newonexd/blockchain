package common;

import lombok.Data;

/**
 * @author: rxd
 * @date: 2019-09-22 14:44
 */
@Data
public class Header {
    private int block_number;
    private String pre_hash;
    private String merkle_root;
    private String time_stamp;
    private String diffcult_value;
    private String nonce;

    @Override
    public String toString() {
        return block_number + pre_hash + merkle_root + time_stamp + diffcult_value + nonce;
    }
}

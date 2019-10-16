package util;



import java.util.concurrent.Callable;

/**
 * @author rxd
 * @ClassName Task
 * Description TODO
 * @date 2019-09-27 10:10
 * @Version 1.0
 */
public final class Task implements Callable {

    @Override
    public Boolean call() throws Exception {
        Thread.sleep(Constant.LIMIT_TIME);
        return false;
    }
}

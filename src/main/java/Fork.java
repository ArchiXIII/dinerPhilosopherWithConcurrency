import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Черный on 11.10.2017.
 */
public class Fork {
    private Lock locker = new ReentrantLock();

    public boolean tryTakeFork(){
        return locker.tryLock();
    }

    public void putFork(){
        locker.unlock();
    }
}

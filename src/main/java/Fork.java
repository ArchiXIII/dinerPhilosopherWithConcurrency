import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Черный on 11.10.2017.
 */
public class Fork {
    private boolean taken = false;

    private Lock locker = new ReentrantLock();

    public boolean takeFork(){
        locker.lock();
        if(!taken){
            taken = true;
            return true;
        }
        locker.unlock();
        return false;
    }

    public void putFork(){
        taken = false;
        locker.unlock();
    }

    public boolean isTaken(){
        if(!taken){
            locker.lock();
        }
        return taken;
    }
}

/**
 * Created by Черный on 11.10.2017.
 */
public class Philosopher {
    private int numberPhilosopher;
    private Fork leftFork;
    private Fork rightFork;
    private boolean leftMy;
    private boolean rightMy;

    public Philosopher(Fork leftForks, Fork rightFork, int numberPhilosopher) {
        this.leftFork = leftForks;
        this.rightFork = rightFork;
        this.numberPhilosopher = numberPhilosopher;
    }

    public void act(){
        if (leftFork.tryTakeFork()) {
            leftMy = true;
        }
        if (rightFork.tryTakeFork()) {
            rightMy = true;
        }
        if(leftMy && rightMy) {
            eat();
        }
        putForks();
        think();
    }

    private void putForks(){
        if (leftMy) {
            leftFork.putFork();
            leftMy = false;
        }
        if (rightMy) {
            rightFork.putFork();
            rightMy = false;
        }
    }

    private void eat(){
        System.out.println("Philosopher "+ numberPhilosopher +" eating");
    }

    private void think(){
        System.out.println("Philosopher "+ numberPhilosopher +" thinking");
    }
}

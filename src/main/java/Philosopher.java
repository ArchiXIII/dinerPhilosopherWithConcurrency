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
        int attemptsToTake = 0;
        while (!leftFork.isTaken() || !rightFork.isTaken()){
            if(!leftFork.isTaken()){
                leftFork.takeFork();
                leftMy = true;
            }
            if (!rightFork.isTaken()) {
                rightFork.takeFork();
                rightMy = true;
            }
            attemptsToTake++;
            if(attemptsToTake > 3) {
                putForks();
            }
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
        }
        if (rightMy) {
            rightFork.putFork();
        }
    }

    private void eat(){
        System.out.println("Philosopher "+ numberPhilosopher +" eating");
    }

    private void think(){
        System.out.println("Philosopher "+ numberPhilosopher +" thinking");
    }
}

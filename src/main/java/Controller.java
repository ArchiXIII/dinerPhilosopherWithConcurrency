/**
 * Created by Черный on 11.10.2017.
 */
public class Controller {
    public static void main(String[] args) {
        final Fork[] forks = new Fork[5];
        for(int i=0; i<5; i++) {
            forks[i] = new Fork();
        }

        for (int i=0; i<5; i++) {
            final int numberPhilosopher = i;
            final int firstFork = i;
            final int secondFork;
            if (i < 4) {
                secondFork = i + 1;
            } else {
                secondFork = 0;
            }
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Philosopher philosopher = new Philosopher(forks[firstFork], forks[secondFork], numberPhilosopher);
                    while (true) {
                        try {
                            Thread.sleep((int) (Math.random() * 2000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        philosopher.act();
                    }
                }
            });
            thread.start();
        }
    }
}

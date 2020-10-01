import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static Object mon = new Object();
    static final int NUM = 5;
    static volatile char currentLetter = 'A';

    public static void main(String[] args) {

        new Thread(()-> {
            try {
                for (int i = 0; i < NUM; i++) {
                    synchronized (mon) {
                        while (currentLetter != 'A') {
                            mon.wait();
                        }
                        System.out.print("A");
                        currentLetter = 'B';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                for (int i = 0; i < NUM; i++) {
                    synchronized (mon) {
                        while (currentLetter != 'B') {
                            mon.wait();
                        }
                        System.out.print("B");
                        currentLetter = 'C';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                for (int i = 0; i < NUM; i++) {
                    synchronized (mon) {
                        while (currentLetter != 'C') {
                            mon.wait();
                        }
                        System.out.print("C\n");
                        currentLetter = 'A';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}

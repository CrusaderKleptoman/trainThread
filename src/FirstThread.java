import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class FirstThread implements Runnable{
    private double numberForBuffer;
    private ArrayList<Double> bufferForThread;

    public FirstThread(ArrayList<Double> bufferForThread) {
        this.bufferForThread = bufferForThread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            numberForBuffer = ThreadLocalRandom.current().nextDouble(-1, 1);
            synchronized (bufferForThread)
            {
                while (bufferForThread.size() >= 2)
                    try {
                        bufferForThread.wait();
                    } catch (InterruptedException e) {}

                bufferForThread.add(numberForBuffer);
                System.out.println("Thread 1, N" + (i+1) + " generated number = " + numberForBuffer);
                bufferForThread.notify();
            }
        }
        Thread.currentThread().interrupt();
    }
}

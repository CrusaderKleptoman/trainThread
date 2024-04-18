import java.util.concurrent.ThreadLocalRandom;

public class FirstThread implements Runnable{
    private double numberForBuffer;
    private Buffer buffer;

    public FirstThread(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            numberForBuffer = ThreadLocalRandom.current().nextDouble(-1, 1);
            synchronized (buffer)
            {
                while (buffer.getSize() >= buffer.getN())
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {}

                buffer.addElement(numberForBuffer);
                System.out.println("Thread 1, N" + (i+1) + " generated number = " + numberForBuffer);
                buffer.notify();
            }
        }
    }
}

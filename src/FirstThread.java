import java.util.concurrent.ThreadLocalRandom;

public class FirstThread implements Runnable{
    double numberForBuffer;
    Buffer buffer;
    int count = 1;

    public FirstThread(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(count<100) {
            synchronized (buffer)
            {
                numberForBuffer = ThreadLocalRandom.current().nextDouble(-1, 1);
                if (buffer.getSize() >= buffer.getN()) {
                    try {
                        System.out.println("Buffer is full, thread 1 wait");
                        buffer.wait();
                    } catch (InterruptedException e) {}
                }
                buffer.addElement(numberForBuffer);
                System.out.println("Thread 1, №" + count++ + ", generated number = " + numberForBuffer);
                buffer.notify();
            }
        }
    }
}

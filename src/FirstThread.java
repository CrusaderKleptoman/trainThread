import java.util.concurrent.ThreadLocalRandom;

public class FirstThread implements Runnable{
    double numberForBuffer;
    Buffer buffer;

    public FirstThread(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            numberForBuffer = ThreadLocalRandom.current().nextDouble(-1, 1);
            synchronized (buffer)
            {
                if (buffer.getSize() >= buffer.getN()) {
                    try {
                        System.out.println("Поток остановлен");
                        buffer.wait();
                    } catch (InterruptedException e) {}
                }
                buffer.addElement(numberForBuffer);
                buffer.notify();
            }
            System.out.println("Поток 1, сгенерированное число = " + numberForBuffer);
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){

            }
        }
    }
}

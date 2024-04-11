public class SecondThread implements Runnable{
    Buffer buffer;
    double numberFromBuffer;
    int count = 1;

    public SecondThread(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer)
            {
                if (buffer.getSize() <= 0) {
                    try {
                        System.out.println("Buffer is empty, thread 2 wait");
                        buffer.wait();
                    } catch (InterruptedException e) {}
                }
                numberFromBuffer = buffer.removeElement();
                System.out.println("Thread 2, №" + count++ + ", squared number = " + numberFromBuffer*numberFromBuffer);
                buffer.notify();
            }
        }
    }
}

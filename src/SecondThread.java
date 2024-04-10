public class SecondThread implements Runnable{
    Buffer buffer;
    double numberFromBuffer;

    public SecondThread(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            synchronized (buffer)
            {
                if (buffer.getSize() == 0) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {}
                }
                numberFromBuffer = buffer.removeElement();
                System.out.println("Поток 2, квадрат = " + numberFromBuffer*numberFromBuffer);
                buffer.notify();
            }
        }

    }
}

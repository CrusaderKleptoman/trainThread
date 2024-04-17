public class SecondThread implements Runnable{
    Buffer buffer;
    double numberFromBuffer;
    int count = 1;

    public SecondThread(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(true) {
            if (buffer.getSize() != 0) {
                numberFromBuffer = buffer.removeElement();
                System.out.println("Поток 2, №" + count++ + " квадрат = " + numberFromBuffer * numberFromBuffer);
            }
        }
    }
}

public class SecondThread implements Runnable{
    private Buffer buffer;
    private int count = 1;

    public SecondThread(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {

                while(buffer.getSize() == 0) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {}
                }
                
                System.out.println("Thread 2, N" + count++ + " square = " + Math.pow(buffer.removeElement(), 2) );
                buffer.notify();
            }
        }
    }
}

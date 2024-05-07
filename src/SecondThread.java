import java.util.ArrayList;

public class SecondThread implements Runnable{
    private ArrayList<Double> bufferForThread;

    public SecondThread(ArrayList<Double> bufferForThread) {
        this.bufferForThread = bufferForThread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            synchronized (bufferForThread) {
                while(bufferForThread.isEmpty()) {
                    try {
                        bufferForThread.wait();
                    } catch (InterruptedException e) {}
                }
                System.out.println("Thread 2, N" + (i+1) + " square = " + Math.pow(bufferForThread.get(0), 2) );
                bufferForThread.remove(0);
                bufferForThread.notify();
            }
        }
        Thread.currentThread().interrupt();
    }
}

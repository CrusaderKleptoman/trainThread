import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> bufferForThread = new ArrayList<>(2);
        FirstThread firstThread = new FirstThread(bufferForThread);
        Thread thread1 = new Thread(firstThread);
        thread1.start();

        SecondThread secondThread = new SecondThread(bufferForThread);
        Thread thread2 = new Thread(secondThread);
        thread2.start();
    }
}
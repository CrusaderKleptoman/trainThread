public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        FirstThread firstThread = new FirstThread(buffer);
        Thread thread1 = new Thread(firstThread);
        thread1.start();

        SecondThread secondThread = new SecondThread(buffer);
        Thread thread2 = new Thread(secondThread);
        thread2.start();
    }
}
public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        FirstThread firstThread = new FirstThread(buffer);
        SecondThread secondThread = new SecondThread(buffer);
        Thread thread1 = new Thread(firstThread);
        Thread thread2 = new Thread(secondThread);
        thread1.start();
        thread2.start();
    }
}
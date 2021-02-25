public class TestDrive {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        myTask.run();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new MyTask());
            thread.setName("T - " + i);
            //thread.start();
            thread.run();
        }

        Thread randomThread = new Thread(myTask);
        randomThread.start();
        System.out.println(Thread.activeCount());
    }
}
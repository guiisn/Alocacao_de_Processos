public class Node implements Runnable {
    private String value;
    private Thread process;
    private ProcessQueue queue;

    public Node(String value, ProcessQueue queue) {
        this.value = value;
        this.process = new Thread(this, value);
        this.queue = queue;
        this.start();
    }

    public void start() {
        this.process.start();
    }

    @Override
    public void run() {
        queue.moveToProcessQueue(this);

        System.out.println("[THREAD]: " + value + " [STATUS]: INICIADA");
        try {
            Thread.sleep(value.length() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[THREAD] " + value + " [STATUS]: FINALIZADA");

        queue.removeFromProcessQueue(this);
    }
}

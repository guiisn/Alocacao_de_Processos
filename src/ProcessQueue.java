import java.util.ArrayList;

public class ProcessQueue {
    private ArrayList<Node> array;
    final int tam;

    public ProcessQueue(Integer tam) {
        array = new ArrayList<Node>();
        this.tam = tam;
    }

    public void moveToProcessQueue(Node node) {
        if (array.size() >= tam) {
            synchronized (this) {
                try {
                    System.out.println("[THREAD]: " + Thread.currentThread().getName() + " [STATUS]: AGUARDANDO");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        array.add(node);
    }

    public void removeFromProcessQueue(Node node) {
        synchronized (this) {
            array.remove(node);
            notify();
            System.out.println("[THREAD]: " + Thread.currentThread().getName() + " [STATUS]: REMOVIDA");
        }

    }
}

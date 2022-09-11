package exempluCoada;

public class ConsumerRunnable implements Runnable{

    BlockingQueue<String> queue;

    public ConsumerRunnable(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    //Thread removing persons from the queue
    @Override
    public void run() {

        while (true) {
            try {
                queue.remove();
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}

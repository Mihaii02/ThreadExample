package exempluCoada;

import java.util.Random;

public class ProducerRunnable implements Runnable{

    BlockingQueue<String> coada;

    public ProducerRunnable(BlockingQueue<String> coada) {
        this.coada = coada;
    }

    //infinite loop
    //thread for adding persons to the queue
    @Override
    public void run() {
        Random random = new Random();
        while (true){
            try {
                coada.adding("Person " + random.nextInt(100));
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

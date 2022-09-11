package exempluCoada;

public class Main {

    public static void main(String[] args) {

        BlockingQueue<String> queue = new BlockingQueue<>(5);

        Runnable runnableProducer = new ProducerRunnable(queue);
        Runnable runnableConsumer = new ConsumerRunnable(queue);

        Thread producer = new Thread(runnableProducer, "Producer");
        Thread consumer1 = new Thread(runnableConsumer, "Consumer1");
        Thread consumer2 = new Thread(runnableConsumer, "Consumer2");

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}

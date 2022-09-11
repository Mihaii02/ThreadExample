package exempluCoada;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {

    private Queue<T> queue = new LinkedList<>();
    private int maxCapacity;

    public BlockingQueue(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    //Removing persons from the queue
    public synchronized T remove() throws InterruptedException {
        while (queue.isEmpty()){
            System.out.println(Thread.currentThread().getName() + " is waiting for a person to get in line");
            wait();
        }
        T element = queue.poll();
        System.out.println("Person " + element + " was processed by the cashier  " +Thread.currentThread().getName());
        notifyAll();

        return element;
    }

    //Adding persons to the queue
    public synchronized void adding(T element) throws InterruptedException {

        while (queue.size()== maxCapacity){
            System.out.println(Thread.currentThread().getName() + " is waiting for a person to be processed");
            wait();
        }
        queue.offer(element);
        System.out.println("Person " +element+ " was added to the queue by the cashier " + Thread.currentThread().getName());
        notify();
    }
}

/*
 8]	Write a multithreaded Java program to demonstrate the Producer-Consumer problem.
 */
import java.util.Scanner;
import java.util.LinkedList;

class Buffer{
    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacity;

    public Buffer(int capacity){
        this.capacity = capacity;
    }
    public synchronized void produce(int item) throws InterruptedException{
        while(buffer.size() == capacity){
            wait();
        }
        buffer.add(item);
        System.out.println("Produced: " + item);
        notify();
    }
    public synchronized int consume() throws InterruptedException{
        while(buffer.size() == 0){
            wait();
        }
        int item = buffer.removeFirst();
        System.out.println("Consumed: " + item);
        notify();
        return item;
    }
}

class Producer extends Thread{
    private Buffer buf;

    Producer(Buffer buf){
        this.buf = buf;
    }

    public void run(){
        for(int i=0; i<5; i++){
            try {
                buf.produce(i);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread{
    private Buffer buf;

    Consumer(Buffer buf){
        this.buf = buf;
    }

    public void run(){
        for(int i=0; i<5; i++){
            try {
                buf.consume();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
public class TW8 {
    public static void main(String[] args) throws Exception {
        Buffer buf = new Buffer(3);
        Producer producer = new Producer(buf);
        Consumer consumer = new Consumer(buf);

        producer.start();
        consumer.start();
    }
}

package com.example.java.jottings.ThreadlocalUse;

import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://www.cnblogs.com/WangHaiMing/p/8798709.html
 * <p>
 * remove 移除并返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
 * poll 移除并返问队列头部的元素 如果队列为空，则返回null
 * take 移除并返回队列头部的元素
 * add 增加一个元索 如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 * offer 添加一个元素并返回true 如果队列已满，则返回false
 * put 添加一个元素 如果队列满，则阻塞
 * element 返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
 * peek 返回队列头部的元素 如果队列为空，则返回null
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        //创建队列
        BlockingQueue<String> bq = new LinkedBlockingDeque(10);

        AbstractLifeCycle cycle = new AbstractLifeCycle();

//        创建生产者
        ProducerThread p2 = new ProducerThread(bq);

//        创建两个个消费者
        ConsumerThread c1 = new ConsumerThread(bq);
        ConsumerThread c2 = new ConsumerThread(bq);

        cycle.startup();
        Thread t1 = new Thread(c1);
        t1.start();
        Thread t2 = new Thread(c2);
        t2.start();
        Thread t3 = new Thread(p2);
        t3.start();
//        Thread.sleep(10 * 1000);
//        cycle.shutdown();
    }

}

interface LifeCycle {

    void startup();

    void shutdown();

    boolean isStarted();
}

class AbstractLifeCycle implements LifeCycle {

    private final AtomicBoolean isStarted = new AtomicBoolean(false);

    @Override
    public void startup() {
        if (isStarted.compareAndSet(false, true)) {
            return;
        }
        throw new RuntimeException("this component has started");
    }

    @Override
    public void shutdown() {
        while (!isStarted.compareAndSet(true, false)) {
        }
    }

    @Override
    public boolean isStarted() {
        return isStarted.get();
    }

}


/**
 * 消费者
 */
class ProducerThread implements Runnable {
    private        BlockingQueue deque;
    private static AtomicInteger atomicInteger = new AtomicInteger();
    private static AtomicBoolean flag          = new AtomicBoolean(true);

    public ProducerThread(BlockingQueue deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        System.err.println("生产者启动。。。。。");
        try {
            System.err.println("生产者正在生产消息。。。");
            while (flag.get()) {
                String count = String.valueOf(atomicInteger.incrementAndGet());
                if (Objects.equals("100", count)) {
                    while (!flag.compareAndSet(false, true)) {
                    }
                    while (!deque.offer("_exit")) {
                        continue;
                    }
                }
                //添加到队列数据
                boolean offer = deque.offer(count);
                if (offer) {
                    System.err.println("生产者添加队列" + count + "成功！");
                } else {
                    System.err.println("生产者添加队列" + count + "失败！");
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者线程结束。。。。");
        }
    }
}


/**
 * 生产者
 */
class ConsumerThread implements Runnable {

    private        BlockingQueue queue;
    private static AtomicBoolean flag = new AtomicBoolean(true);

    public ConsumerThread(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("消费者线程启动。。。。。。。");
        try {
            while (flag.get()) {
                //poll先进先出 pop先进后出
                //获取完毕后，队列会删除头元素
                String data = (String) queue.poll(2, TimeUnit.SECONDS);
                if (Objects.equals("_exit", data)) {
                    while (!flag.compareAndSet(false, true)) {
                        continue;
                    }
                    continue;
                }
                if (data != null) {
                    System.out.println("消费者获取data：" + data + "成功！");
                }
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("消费者线程结束。。。");
        }
    }
}
package com.lt.thread;

/**
 * @author Alan
 * @Description
 * @date 2024.02.21 20:58
 */
public class PrintNumbers {
    private volatile int number = 0;
    private final Object lock = new Object();

    public void printEven() {
        while (number <= 200) {
            if (number % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;
                lock.notify(); // 唤醒等待的线程
            } else {
                try {
                    lock.wait(); // 当前线程等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printOdd() {
        while (number <= 200) {
            if (number % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;
                lock.notify(); // 唤醒等待的线程
            } else {
                try {
                    lock.wait(); // 当前线程等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintNumbers printer = new PrintNumbers();

        Thread thread1 = new Thread(printer::printEven);
        Thread thread2 = new Thread(printer::printOdd);

        thread1.setName("EvenThread");
        thread2.setName("OddThread");

        thread1.start();
        thread2.start();
    }
}

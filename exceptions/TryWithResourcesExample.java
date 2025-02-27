package lesson2.exceptions;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TryWithResourcesExample {

    public static void main(String[] args) {
        BankTransaction tx = new BankTransaction();
        try (tx) {
            tx.hold(BigDecimal.TEN);
            // Здесь происходит бизнес логика, которая может завершиться исключением
            tx.complete();
        } catch (Exception e) {
            tx.cancel();
            e.printStackTrace();
        }
    }


    public static final class BankTransaction implements AutoCloseable {

        private BigDecimal amount;
        private Lock lock;

        public void hold(BigDecimal amount) {
            System.out.println(">> tx opened");
            this.amount = amount;
            this.lock = new ReentrantLock();
            lock.lock();
        }

        public void complete() {
            System.out.println("Withdraw amount " + amount);
        }

        public void cancel() {
            System.out.println(">> cancel");
            this.amount = null;
        }

        @Override
        public void close() {
            lock.unlock(); // Освобождает ресурс. Например, блокировку
            System.out.println(">> tx closed");
        }
    }
}

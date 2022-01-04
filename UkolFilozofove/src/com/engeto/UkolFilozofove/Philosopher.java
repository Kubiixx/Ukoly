package com.engeto.UkolFilozofove;

public class Philosopher implements  Runnable {

    int name;
    Fork leftFork;
    Fork rightFork;
    int eatenPortions = 0;
    int totalPortions = 1000;

    public Philosopher (int name, Fork rightFork, Fork leftFork) {
        this.name = name;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }

    public int getName() {
        return name;
    }

    public void sleep () throws InterruptedException {
        Thread.sleep(5);
    }

    @Override
    public void run () {
        while (eatenPortions < totalPortions) {
            eatenPortions++;
            try {
                sleep();
                synchronized (rightFork) {
                    sleep();
                    synchronized (leftFork) {
                        System.out.println("Filozof " +getName()+ " jí porci číslo: " +eatenPortions);
                        sleep();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Filosof " +getName()+ " skončil, Thread uzavřen.");
    }
}

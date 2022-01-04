package com.engeto.UkolFilozofove;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List <Fork> forksList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            forksList.add(new Fork());
        }

        int [] names =  {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List <Philosopher> philosophersList = new ArrayList<>();
        philosophersList.add(new Philosopher(names[philosophersList.size()], forksList.get(philosophersList.size()+1), forksList.get(philosophersList.size())));
        while (philosophersList.size() <10) {
            philosophersList.add(new Philosopher(names[philosophersList.size()], forksList.get(philosophersList.size()), forksList.get((philosophersList.size()+1)%10)));
        }

        for (int i = 0; i < philosophersList.size(); i++) {
            Thread thread = new Thread(philosophersList.get(i), "Thread number: " +i+1);
            thread.start();
        }


    }
}

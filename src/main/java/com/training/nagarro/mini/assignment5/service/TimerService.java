package com.training.nagarro.mini.assignment5.service;

import java.util.Timer;
import java.util.TimerTask;

public class TimerService {
    public void startTimer(int seconds, Runnable action) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                action.run();
                timer.cancel();
            }
        }, seconds * 1000);
    }
}

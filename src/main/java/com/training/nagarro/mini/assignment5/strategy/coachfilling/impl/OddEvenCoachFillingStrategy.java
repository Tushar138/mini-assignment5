package com.training.nagarro.mini.assignment5.strategy.coachfilling.impl;

import java.util.ArrayList;
import java.util.List;

import com.training.nagarro.mini.assignment5.model.Coach;
import com.training.nagarro.mini.assignment5.strategy.coachfilling.CoachFillingStrategy;

public class OddEvenCoachFillingStrategy implements CoachFillingStrategy {

    @Override
    public List<Coach> fillCoachSequence(List<Coach> coaches) {
        List<Coach> sortedCoaches = new ArrayList<>();

        for (int i = 0; i < coaches.size(); i++) {
            if (i % 2 == 0) {
                sortedCoaches.add(coaches.get(i));
            }
        }

        for (int i = 0; i < coaches.size(); i++) {
            if (i % 2 != 0) {
                sortedCoaches.add(coaches.get(i));
            }
        }

        return sortedCoaches;
    }
}

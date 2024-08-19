package com.training.nagarro.mini.assignment5.strategy.coachfilling;

import java.util.List;

import com.training.nagarro.mini.assignment5.model.Coach;

public interface CoachFillingStrategy {
    List<Coach> fillCoachSequence(List<Coach> coaches);
}

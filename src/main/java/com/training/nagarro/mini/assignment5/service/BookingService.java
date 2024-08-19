package com.training.nagarro.mini.assignment5.service;

import java.util.List;
import java.util.Optional;

import com.training.nagarro.mini.assignment5.model.BerthType;
import com.training.nagarro.mini.assignment5.model.Booking;
import com.training.nagarro.mini.assignment5.model.Coach;
import com.training.nagarro.mini.assignment5.model.Seat;
import com.training.nagarro.mini.assignment5.model.Train;
import com.training.nagarro.mini.assignment5.model.User;
import com.training.nagarro.mini.assignment5.strategy.coachfilling.CoachFillingStrategy;
import com.training.nagarro.mini.assignment5.strategy.coachfilling.impl.OddEvenCoachFillingStrategy;
import com.training.nagarro.mini.assignment5.strategy.price.impl.DynamicPricingStrategyImpl;

public class BookingService {
    private static BookingService instance;
    private static final double BASE_PRICE = 2000.0;

    private BookingService() {
    }

    public static BookingService getInstance() {
        if (instance == null) {
            instance = new BookingService();
        }
        return instance;
    }

    public Booking bookSeat(User user, Train train, BerthType preferredBerth) {
        List<Coach> coaches = train.getCoaches();
        fillCoachSequence(coaches);

        Optional<Seat> availableSeat = coaches.stream()
                .flatMap(coach -> coach.getAvailableSeats().stream())
                .filter(seat -> seat.getBerthType().equals(preferredBerth))
                .findFirst();

        if (availableSeat.isPresent()) {
            Seat seat = availableSeat.get();
            int filledPercentage = seat.getPrice() == BASE_PRICE ? 0 : seat.getPrice() > BASE_PRICE * 1.1 ? 20 : 30;
            seat.calculateDynamicPrice(filledPercentage, new DynamicPricingStrategyImpl());

            Booking booking = new Booking("BKG" + System.currentTimeMillis(), user, seat);
            booking.confirmBooking();
            return booking;
        } else {
            System.out.println("Preferred berth not available. Booking failed.");
            return null;
        }
    }

    private void fillCoachSequence(List<Coach> coaches) {
        CoachFillingStrategy fillingStrategy = new OddEvenCoachFillingStrategy();
        coaches = fillingStrategy.fillCoachSequence(coaches);
    }
}

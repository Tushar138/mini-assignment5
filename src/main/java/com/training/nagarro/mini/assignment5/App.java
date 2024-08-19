package com.training.nagarro.mini.assignment5;

import com.training.nagarro.mini.assignment5.model.Admin;
import com.training.nagarro.mini.assignment5.model.BerthType;
import com.training.nagarro.mini.assignment5.model.Booking;
import com.training.nagarro.mini.assignment5.model.Coach;
import com.training.nagarro.mini.assignment5.model.MealPreference;
import com.training.nagarro.mini.assignment5.model.Seat;
import com.training.nagarro.mini.assignment5.model.Train;
import com.training.nagarro.mini.assignment5.model.User;
import com.training.nagarro.mini.assignment5.service.BookingService;
import com.training.nagarro.mini.assignment5.service.TimerService;

public class App {

	public static void main(String[] args) {
		
		 Train train = new Train("Train-101");
	        Coach coach1 = new Coach("Coach-1");
	        Coach coach2 = new Coach("Coach-2");
	        Coach coach3 = new Coach("Coach-3");

	        train.addCoach(coach1);
	        train.addCoach(coach2);
	        train.addCoach(coach3);

	        coach1.addSeat(new Seat("Seat-1A", BerthType.LOWER, 2000.0));
	        coach1.addSeat(new Seat("Seat-1B", BerthType.UPPER, 2000.0));
	        coach2.addSeat(new Seat("Seat-2A", BerthType.MIDDLE, 2000.0));
	        coach2.addSeat(new Seat("Seat-2B", BerthType.UPPER, 2000.0));
	        coach3.addSeat(new Seat("Seat-3A", BerthType.LOWER, 2000.0));
	        coach3.addSeat(new Seat("Seat-3B", BerthType.MIDDLE, 2000.0));

	        User user1 = new User("User-1", "John Doe", BerthType.LOWER, MealPreference.VEG);

	        BookingService bookingService = BookingService.getInstance();
	        Booking booking = bookingService.bookSeat(user1, train, BerthType.LOWER);

	        if (booking != null) {
	        	new TimerService().startTimer(5, booking::showBookingDetails);
	        } else {
	            System.out.println("Booking failed.");
	        }

	        Admin admin = new Admin("Admin-1");
	        admin.viewCoachStatus(train);
	  	}

}

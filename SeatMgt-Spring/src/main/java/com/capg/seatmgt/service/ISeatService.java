package com.capg.seatmgt.service;

import com.capg.seatmgt.entities.Seat;

import java.util.Collection;
import java.util.List;





public interface ISeatService 
{
	
	List<Seat> fetchAllSeats();
	
    Seat saveSeat(Seat seat);
    
    Seat findById(int seatId);
    
    Seat bookSeat(int seatId);
    
    Seat blockSeat(int seatId); 
	
    Seat cancelSeat(int seatId);

}

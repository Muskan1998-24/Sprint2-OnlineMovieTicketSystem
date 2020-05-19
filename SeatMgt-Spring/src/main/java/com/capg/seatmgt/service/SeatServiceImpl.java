package com.capg.seatmgt.service;



import com.capg.seatmgt.dao.SeatDao;
import com.capg.seatmgt.entities.Seat;
import com.capg.seatmgt.entities.SeatStatus;
import com.capg.seatmgt.exceptions.IncorrectSeatIdException;

import com.capg.seatmgt.exceptions.SeatNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SeatServiceImpl implements ISeatService
{

    @Autowired
    private SeatDao seatDao;
   
  
    
    
    /*.....................................FETCH ALL SEATS................................*/
    
    @Override
    public List<Seat>fetchAllSeats()
    {
        List<Seat>seat=seatDao.findAll();
        return seat;
    }
    
    

    /*.....................................ADD SEAT................................*/
    
	
	@Override
    public Seat saveSeat(Seat seat){
		seat=seatDao.save(seat);
        return seat;
    }
	
	
	
	
	 /*.....................................FIND BY ID................................*/
	@Override
    public Seat findById(int seatId) 
	{
        Optional<Seat> optional = seatDao.findById(seatId);
        if (optional.isPresent()) {
            Seat seat = optional.get();
            return seat;
        }
        throw new SeatNotFoundException("seat not found for id=" + seatId);
           }
	  
	
	  /*.....................................BOOK SEAT................................*/
    
	 @Override
	 public Seat bookSeat(int seatId) 
	 {
		 Seat seat=findById(seatId);
	     seat.setSeatStatus(SeatStatus.BOOKED);
	     seatDao.save(seat);
	     return seat;
	  }
	

	
	  /*.....................................BLOCK SEAT................................*/
    
	 @Override
	 public Seat blockSeat(int seatId) 
	 {
		 Seat seat=findById(seatId);
	     seat.setSeatStatus(SeatStatus.BLOCKED);
	     seatDao.save(seat);
	     return seat;
	  }
	


	
	  /*.....................................CANCEL SEAT................................*/
    
	
	 @Override
	 public Seat cancelSeat(int seatId)
	 {
		  Seat seat = findById(seatId);
		  if(seat==null) throw new SeatNotFoundException("Seat Not Booked");
		  seat.setSeatStatus(SeatStatus.AVAILABLE);
		  seatDao.save(seat);
		  return seat;
	}
	
	
    
    

  
		
	
    
    

}

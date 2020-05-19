package com.capg.seatmgt.dto;

import com.capg.seatmgt.entities.SeatStatus;

public class CreateSeatRequestDto
{
	 private int seatId;
	 private double seatPrice;
	
	        
	 public int getSeatId() 
	    {
	    	return seatId;
	    }
	    
	 public void setSeatId(int seatId) 
	    {
	    	this.seatId=seatId;
	    } 
	 
	 
	 public double getSeatPrice() 
	    {
	    	return seatPrice;
	    }
	 
     public void setSeatPrice(double seatPrice) 
	    {
	    	this.seatPrice=seatPrice;
	    }



}

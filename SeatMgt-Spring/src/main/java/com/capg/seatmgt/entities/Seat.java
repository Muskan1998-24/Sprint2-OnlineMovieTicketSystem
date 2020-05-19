package com.capg.seatmgt.entities;

import javax.persistence.*;

import com.capg.seatmgt.entities.Seat;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "seats")

public class Seat
{
    @Id
    @GeneratedValue
	private int seatId;
    private double seatPrice;
    private SeatStatus seatStatus;
    
    
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
	
    
    public SeatStatus getSeatStatus() {
    	return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
    	this.seatStatus = seatStatus;
    }

    
    @Override
    public boolean equals(Object o) 
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return seatId == seat.seatId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatId);
    }
}

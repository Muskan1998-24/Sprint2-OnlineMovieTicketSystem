package com.capg.seatmgt.dao;

import java.util.List;

import com.capg.seatmgt.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SeatDao extends JpaRepository<Seat,Integer>
{
	
}

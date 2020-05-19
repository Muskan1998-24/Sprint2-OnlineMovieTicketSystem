package com.capg.seatmgt.controller;


import com.capg.seatmgt.dto.CreateSeatRequestDto;import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.capg.seatmgt.entities.Seat;
import com.capg.seatmgt.entities.SeatStatus;
import com.capg.seatmgt.exceptions.SeatNotFoundException;

import javax.validation.ConstraintViolationException;
import com.capg.seatmgt.service.ISeatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController
{
	 private static final Logger Log = LoggerFactory.getLogger(SeatController.class);
	
      @Autowired
      private ISeatService service;
      

	  @PostMapping("/add")
	  public ResponseEntity<Seat> addSeat(@RequestBody CreateSeatRequestDto dto) 
	      {
		    Seat seat = convert(dto);
		    service.saveSeat(seat);
	        ResponseEntity<Seat> response = new ResponseEntity<>(seat, HttpStatus.OK);
	        return response;
          }

	  public Seat convert(CreateSeatRequestDto dto)
	      {
	        Seat seat= new Seat();
	        seat.setSeatPrice(dto.getSeatPrice());
	        seat.setSeatStatus(SeatStatus.AVAILABLE);
	        return seat;
	      }

	   

       //fetch all seats
	  
       @GetMapping
       public ResponseEntity<List<Seat>> fetchAll() 
          {
            List<Seat> seats = service.fetchAllSeats();
            ResponseEntity<List<Seat>> response = new ResponseEntity<>(seats, HttpStatus.OK);
            return response;
          }

       //find seat by id
       
       @GetMapping("find/{id}")
	   public ResponseEntity<Seat> findById(@PathVariable("id") int seatId)
	      {
	        Seat seat = service.findById(seatId);
	        if(seat==null)
	          {
	             ResponseEntity<Seat> response= new ResponseEntity<>(HttpStatus.NOT_FOUND);
	             return response;
	          }
	        ResponseEntity<Seat> response = new ResponseEntity<>(seat, HttpStatus.OK);
	        return response;
	      }
       
       //block seat by id
       
       @PutMapping("/block/{id}")
       public ResponseEntity<Seat> blockSeat(@PathVariable("id") int seatId)
       {
           Seat seat = service.blockSeat(seatId);
           ResponseEntity<Seat> response = new ResponseEntity<Seat>(seat, HttpStatus.OK);
           return response;
       }

       //book seat by id
       
       @PutMapping("/book/{id}")
       public ResponseEntity<Seat> bookSeat(@PathVariable("id") int seatId) 
       {
           Seat seat = service.bookSeat(seatId);
           ResponseEntity<Seat> response = new ResponseEntity<Seat>(seat, HttpStatus.OK);
           return response;
       }

       
       //cancel seat by id
       
       @PutMapping("/cancel/{id}")
       public ResponseEntity<Seat> cancelSeat(@PathVariable("id") int seatId)
       {
           Seat seat = service.cancelSeat(seatId);
           ResponseEntity<Seat> response = new ResponseEntity<Seat>(seat, HttpStatus.OK);
           return response;
       }
       
       //SeatNotFoundException
       
       
       @ExceptionHandler(SeatNotFoundException.class)
       public ResponseEntity<String>handleEmployeeNotFound(SeatNotFoundException ex){
           Log.error("Seat not found exception",ex);
           String msg=ex.getMessage();
           ResponseEntity<String>response=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
           return response;
       }

       // ConstraintViolationException 
       
       
       @ExceptionHandler(ConstraintViolationException.class)
       public ResponseEntity<String> handleConstraintViolate(ConstraintViolationException ex) 
       {
           Log.error("constraint violation", ex);
           String msg = ex.getMessage();
           ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
           return response;
       }

       
       //Blanket Exception Handler
       
        
       @ExceptionHandler(Throwable.class)
       public ResponseEntity<String> handleAll(Throwable ex) 
       {
           Log.error("Something went wrong", ex);
           String msg = ex.getMessage();
           ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
           return response;
       }
   
    
}

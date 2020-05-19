import { Component, OnInit } from '@angular/core';
import { Seat } from '../model/seat';
import { SeatService } from '../service/seatservice';

@Component({
  selector: 'add-seat',
  templateUrl: './add-seat.component.html',
  styleUrls: ['./add-seat.component.css']
})
export class AddSeatComponent implements OnInit {

  service:SeatService;
  
  constructor(service:SeatService) {
    this.service=service;
   }

  ngOnInit(): void {
  }

   addedSeat:Seat=null;
     
  addSeat(form:any){
    let details=form.value;
    let seatId=details.seatId;
    let seatPrice=details.seatPrice;
    this.addedSeat=new Seat();
    this.addedSeat.seatId=seatId;
    this.addedSeat.seatPrice=seatPrice;
    
    
    let result=this.service.addSeat(this.addedSeat); 
    result.subscribe((seat:Seat)=>{
      this.addedSeat=seat;
    },
    err=>{
    console.log("err="+err);
    } );
    form.reset();
    
  }
 
}

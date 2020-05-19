import { Component, OnInit } from '@angular/core';
import { SeatService } from '../service/seatservice';
import { Seat } from '../model/seat';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-cancel-seat',
  templateUrl: './cancel-seat.component.html',
  styleUrls: ['./cancel-seat.component.css']
})
export class CancelSeatComponent implements OnInit {

  seats:Seat[]=[];

  service:SeatService;
  constructor(service:SeatService) 
  {
    this.service=service;
   }

  ngOnInit(): void {
  }

  cancelSeat(form:any);

  cancelSeat(seatId:number){
    let result:Observable<boolean>=this.service.cancelSeat(seatId);
    result.subscribe(seat=>{
        this.cancelLocalSeat(seatId);
    },err=>{
     console.log("err in deleting ="+err);
    })
      }

 
cancelLocalSeat(seatId:number){
  let foundIndex=-1;
  for(let i=0;i<this.seats.length;i++){
    let seat=this.seats[i];
    if(seat.seatId===seatId){
      foundIndex=i;
      break;
    }
  }
  if(foundIndex<0){
    return;
  }
  this.seats.splice(foundIndex,1);
}

  
  

}

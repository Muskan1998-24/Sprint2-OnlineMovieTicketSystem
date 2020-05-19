import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { Seat } from '../model/seat';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class SeatService{
  client:HttpClient ;
  constructor(client:HttpClient ){
  this.client=client;
  }

  baseSeatUrl="http://localhost:8086/seats";


 /**
  * fires post request to server with seat as body
  * 
  * @param seat 
  */
  addSeat(seat:Seat): Observable<Seat>{
  let url=this.baseSeatUrl+"/add";
  let result:Observable<Seat>= this.client.post<Seat>(url,seat);
  return result;
  }

 cancelSeat(seatId:number)
 {
  let url=this.baseSeatUrl+"/cancel/"+seatId;
  let result:Observable<boolean>=this.client.delete<boolean>(url);
  return result;
 }


  // deleteSeatById(id:number){
  //   let url='http://localhost:8086/seat/'+id;
  //   let result:Observable<Seat>=this.client.delete<Seat>(url);
  //   return result;
  // }

  
  // fetchAllSeats():Observable<Seat[]>
  // {
  //   let url=this.baseSeatUrl;
  //   let observable:Observable<Seat[]> =this.client.get<Seat[]>(url);
  //   return observable;
  // }
  // /**
  //  * fires get request to server to fetch seat for id mentioned in url
  //  * @param id of seat which has to be fetched
  //  */
  // findSeatById(id:number):Observable<Seat>{
  //   let url=this.baseSeatUrl+'/get/'+id;
  //   let observable:Observable<Seat> =this.client.get<Seat>(url);
  //   return observable;  
  // }
  
}
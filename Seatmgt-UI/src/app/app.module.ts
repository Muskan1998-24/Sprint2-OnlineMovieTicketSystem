import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddSeatComponent } from './add-seat/add-seat.component';
import { SeatService } from './service/seatservice';
import { CancelSeatComponent } from './cancel-seat/cancel-seat.component';




@NgModule({
  declarations: [
    AppComponent,
    AddSeatComponent,
    CancelSeatComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [SeatService],
  bootstrap: [AppComponent]
})
export class AppModule { }

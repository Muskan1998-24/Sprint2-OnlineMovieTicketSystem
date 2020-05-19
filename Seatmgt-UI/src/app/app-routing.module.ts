import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddSeatComponent } from './add-seat/add-seat.component';
import { CancelSeatComponent } from './cancel-seat/cancel-seat.component';

const routes: Routes = [

  {
    path:'add-seat',
    component:AddSeatComponent
    
  },
  {
    path:'cancel-seat',
    component:CancelSeatComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

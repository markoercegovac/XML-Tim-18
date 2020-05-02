import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserComponent} from './user/user.component';
import {RegisterCarComponent} from './register-car/register-car.component';
import {DefinePriceComponent} from "./define-price/define-price.component";


const routes: Routes = [
  {
    path: 'user',
    component: UserComponent,
  },
  {
    path: 'registerCar',
    component: RegisterCarComponent
  },
  {
    path: 'definePrice',
    component: DefinePriceComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

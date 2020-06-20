import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SignInComponent } from './sign-in/sign-in.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { AdvertsComponent } from './home/adverts/adverts.component';
import { FullAdvertComponent } from './home/full-advert/full-advert.component';
import { AdminCommentsComponent } from './admin/admin-comments/admin-comments.component';
import { AdminComponent } from './admin/admin.component';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { AddAdvertComponent } from './home/adverts/add-advert/add-advert.component';


import {RegisterCarComponent} from './register-car/register-car.component';
import {DefinePriceComponent} from './define-price/define-price.component';
import {ReservedCarComponent} from './reserved-car/reserved-car.component';
import {MyAdvertComponent} from './my-advert/my-advert.component';



const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/home/ads' },
  { path: 'admin', pathMatch: 'full', redirectTo: '/admin/home' },
  { path: 'home', component: HomeComponent, children: [
      { path: 'ads', component: AdvertsComponent },
      { path: 'ad/add', component: AddAdvertComponent },
      { path: 'ad/:id', component: FullAdvertComponent }
    ]},
  { path: 'sign-in', component: SignInComponent },
  { path: 'register', component: RegisterComponent },
  {
    path: 'admin', component: AdminComponent, children: [
      { path: 'home', component: AdminHomeComponent },
      { path: 'comment', component: AdminCommentsComponent }
    ]
  },
  {
    path: 'registerCar',
    component: RegisterCarComponent
  },
  {
    path: 'definePrice',
    component: DefinePriceComponent
  },
  {
    path: 'car/reserved/:id',
    component: ReservedCarComponent
  },
  {
    path: 'my/adverts',
    component: MyAdvertComponent
  },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

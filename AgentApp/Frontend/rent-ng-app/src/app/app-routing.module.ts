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
import {ChatComponent} from './chat/chat.component';
import {InboxComponent} from './inbox/inbox.component';
import {DriveReportCreateComponent} from './drive-report-create/drive-report-create.component';
import {DriveReportListComponent} from './drive-report-list/drive-report-list.component';
import {DriveReportUpdateComponent} from './drive-report-update/drive-report-update.component';
import {AllRegistrationRequestComponent} from "./all-registration-request/all-registration-request.component";
import {CarBrandComponent} from './car-brand/car-brand.component';
import {CarClassComponent} from './car-class/car-class.component';
import {CarModelComponent} from './car-model/car-model.component';
import {CarFuelTypeComponent} from './car-fuel-type/car-fuel-type.component';
import {CarTranssmisionTypeComponent} from './car-transsmision-type/car-transsmision-type.component';



const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/home/ads' },
  { path: 'admin', pathMatch: 'full', redirectTo: '/admin/home' },
  { path: 'home', component: HomeComponent, children: [
      { path: 'ads', component: AdvertsComponent },
      { path: 'ad/add', component: AddAdvertComponent },
      { path: 'ad/:id', component: FullAdvertComponent }
    ]},
  {path : 'admin/register/aprove', component: AllRegistrationRequestComponent},
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
    path: 'kreirajDR',
    component: DriveReportCreateComponent
  },
  {
    path: 'listaDR/:id',
    component: DriveReportListComponent
  },
  {
    path: 'updateDR/:id',
    component: DriveReportUpdateComponent
  },
  {
    path: 'car/reserved/:id',
    component: ReservedCarComponent
  },
  {
    path: 'my/adverts',
    component: MyAdvertComponent
  },
  { path: 'brand', component: CarBrandComponent},
  { path: 'class', component: CarClassComponent},
  { path: 'model', component: CarModelComponent},
  { path: 'fuel-type', component: CarFuelTypeComponent},
  { path: 'transmission', component: CarTranssmisionTypeComponent},

  {
    path: 'chat',
    component: ChatComponent
  },
  {
    path: 'inbox',
    component: InboxComponent
  },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

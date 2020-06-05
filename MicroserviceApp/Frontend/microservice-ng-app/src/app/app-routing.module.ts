import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegistrationComponent} from './registration/registration.component';
import {LoginComponent} from './login/login.component';
import {CreateAdvertComponent} from "./advert/create-advert/create-advert.component";
import {MyAdvertsComponent} from "./advert/my-adverts/my-adverts.component";
import {AllAdvertsComponent} from "./advert/all-adverts/all-adverts.component";
import {RegisterCarComponent} from "./advert/car/register-car/register-car.component";
import {MyCarsComponent} from "./advert/car/my-cars/my-cars.component";
import {DefinePriceComponent} from "./advert/price/define-price/define-price.component";
import {MyPriceListComponent} from "./advert/price/my-price-list/my-price-list.component";
import {CarBrandComponent} from "./car-brand/car-brand.component";
import {CarClassComponent} from "./car-class/car-class.component";
import {CarModelComponent} from "./car-model/car-model.component";
import {CarFuelTypeComponent} from "./car-fuel-type/car-fuel-type.component";
import {CarTranssmisionTypeComponent} from "./car-transsmision-type/car-transsmision-type.component";
import {NavigationAdminComponent} from "./navigation-admin/navigation-admin.component";
import {MatInputModule} from '@angular/material/input';

const routes: Routes = [
  {
    path: 'user-manager/register',
   component: RegistrationComponent
  },
  {
    path: 'user-manager/login',
    component: LoginComponent
  },
  {
    path: 'create/advert',
    component: CreateAdvertComponent
  },
  {
    path: 'my/adverts',
    component: MyAdvertsComponent
  },
  {
    path: 'all/adverts',
    component: AllAdvertsComponent
  },
  {
    path: 'register/car',
    component: RegisterCarComponent
  },
  {
    path: 'my/cars',
    component: MyCarsComponent
  },
  {
    path: 'define/price',
    component: DefinePriceComponent
  },
  {
    path: 'my/price/list',
    component: MyPriceListComponent
  },
  {
    path: 'advert-manager/car-brand',
    component : CarBrandComponent
  },
  {
    path: 'advert-manager/car-class',
    component: CarClassComponent
  },
  {
    path : 'advert-manager/car-model',
    component: CarModelComponent
  },
  {
    path : 'advert-manager/car-fuel-type',
    component : CarFuelTypeComponent
  },
  {
    path : 'advert-manager/car-transsmision-type',
    component: CarTranssmisionTypeComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

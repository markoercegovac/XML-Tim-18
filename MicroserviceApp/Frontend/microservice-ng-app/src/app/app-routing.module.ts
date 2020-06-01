import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegistrationComponent} from './registration/registration.component';
import {LoginComponent} from './login/login.component';
import { CartComponent } from './cart/cart.component';
import { BundleComponent } from './bundle/bundle.component';
import {CreateAdvertComponent} from "./advert/create-advert/create-advert.component";
import {MyAdvertsComponent} from "./advert/my-adverts/my-adverts.component";
import {AllAdvertsComponent} from "./advert/all-adverts/all-adverts.component";
import {RegisterCarComponent} from "./advert/car/register-car/register-car.component";
import {MyCarsComponent} from "./advert/car/my-cars/my-cars.component";
import {DefinePriceComponent} from "./advert/price/define-price/define-price.component";
import {MyPriceListComponent} from "./advert/price/my-price-list/my-price-list.component";
import { AdvertDetailViewComponent } from './advert-detail-view/advert-detail-view.component';


const routes: Routes = [
  { path: 'register', component: RegistrationComponent },
  { path: 'login', component: LoginComponent },
  { path: 'cart',component: CartComponent },
  { path: 'bundle', component: BundleComponent},
  { path: 'advert/:id', component: AdvertDetailViewComponent },
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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

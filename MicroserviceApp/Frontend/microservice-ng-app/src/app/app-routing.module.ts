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
import {SearchComponent} from './search/search.component';
import { CartComponent } from './cart/cart.component';
import { BundleComponent } from './bundle/bundle.component';
import { AdvertDetailViewComponent } from './advert-detail-view/advert-detail-view.component';
import { NotFoundComponent } from './not-found/not-found.component';

import {CaptureComponent} from "./advert/capture/capture/capture.component";

import { OwnerViewRequestsComponent } from './owner-view-requests/owner-view-requests.component';
import { MessagesComponent } from './messages/messages.component';

import {UsersBanListComponent} from "./users-ban-list/users-ban-list.component";
import {CreateCommentComponent} from "./home/full-advert/comments/create-comment/create-comment.component";
import {HomeComponent} from "./home/home.component";
import {AdvertsComponent} from "./home/adverts/adverts.component";
import {FullAdvertComponent} from "./home/full-advert/full-advert.component";
import {AdminCommentsAllowComponent} from "./admin-comments-allow/admin-comments-allow.component";
import { AdminGuard } from './guard/admin.guard';
import { AdminComponent } from './admin/admin.component';



const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/home' },

  { path: 'admin', component: AdminComponent, canActivate: [AdminGuard], children: [
    { path: 'brand', component: CarBrandComponent},
    { path: 'class', component: CarClassComponent},
    { path: 'model', component: CarModelComponent},
    { path: 'fuel-type', component: CarFuelTypeComponent},
    { path: 'transmission', component: CarTranssmisionTypeComponent},
    { path: 'comment', component: AdminCommentsAllowComponent},
    { path: 'ban', component: UsersBanListComponent}
  ] },

  { path: 'home', component: HomeComponent, children: [
    { path: '', pathMatch: 'full', redirectTo: '/home/advert/all'},
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegistrationComponent },
    
    { path: 'comment/create', component: CreateCommentComponent },
    { path: 'advert/all', component: AdvertsComponent }, //LISTA SVIH OGLASA
    { path: 'advert/:id', component: AdvertDetailViewComponent }, //DETALAN PRIKAZ SA KAROSELOM
    { path: 'cart', component: CartComponent },
    { path: 'bundle', component: BundleComponent},
    { path: 'message/:email', component: MessagesComponent },
    { path: 'owner/requests', component: OwnerViewRequestsComponent },
    { path: 'my/adverts', component: MyAdvertsComponent }, //OGLASI OD VLASNIKA
    { path: 'my/advert/:id', component: CaptureComponent }, //vlasnik daje termin zauzeca
    { path: 'my/cars', component: MyCarsComponent },
    { path: 'my/price/list', component: MyPriceListComponent },
    { path: 'create/advert', component: CreateAdvertComponent },
    { path: 'register/car', component: RegisterCarComponent },
    { path: 'define/price', component: DefinePriceComponent },
    { path: 'search', component: SearchComponent },

    //{ path: 'all/advert', component: AllAdvertsComponent}
    //{ path: 'ad/:id', component: FullAdvertComponent }, //DETALJAN PRIKAZ
  ]},
  { path: 'not-found', component: NotFoundComponent},
  { path: '**', redirectTo: '/not-found'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

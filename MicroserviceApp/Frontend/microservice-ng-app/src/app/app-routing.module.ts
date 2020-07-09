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
import { LoggedInGuard } from './guard/logged-in.guard';
import { UserGuard } from './guard/user.guard';
import { OwnerGuard } from './guard/owner.guard';
import { RequestsComponent } from './home/requests/requests.component';
import {AdminBanUsersComponent} from "./admin-ban-users/admin-ban-users.component";
import { RegisterAgentComponent } from './registration/register-agent/register-agent.component';
import { RegisterUserComponent } from './registration/register-user/register-user.component';
import { AdminRegisterRequestsComponent } from './admin-register-requests/admin-register-requests.component';



const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/home' },

  { path: 'admin', component: AdminComponent, canActivate: [AdminGuard], children: [
    { path: 'brand', component: CarBrandComponent},
    { path: 'class', component: CarClassComponent},
    { path: 'model', component: CarModelComponent},
    { path: 'fuel-type', component: CarFuelTypeComponent},
    { path: 'transmission', component: CarTranssmisionTypeComponent},
    { path: 'comment', component: AdminCommentsAllowComponent},
    { path: 'registration-requests', component: AdminRegisterRequestsComponent},
    { path: 'ban', component: UsersBanListComponent},
      {path: 'ban/user' , component: AdminBanUsersComponent}
  ] },

  { path: 'home', component: HomeComponent, children: [
    { path: 'advert/all', component: AdvertsComponent }, //LISTA SVIH OGLASA
    { path: 'advert/:id', component: AdvertDetailViewComponent }, //DETALAN PRIKAZ SA KAROSELOM
    { path: 'search', component: SearchComponent },
    { path: 'cart', component: CartComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegistrationComponent},
      {path: 'register/agent', component: RegisterAgentComponent},
      {path: 'register/user', component: RegisterUserComponent},
    
    { path: 'bundle', component: BundleComponent, canActivate: [UserGuard]},
    { path: 'requests', component: RequestsComponent, canActivate: [UserGuard] },
    { path: 'comment/create', component: CreateCommentComponent, canActivate: [LoggedInGuard] },
    { path: 'message/:email', component: MessagesComponent, canActivate: [LoggedInGuard] },
    { path: 'owner/requests', component: OwnerViewRequestsComponent, canActivate: [OwnerGuard] },
    { path: 'my/adverts', component: MyAdvertsComponent, canActivate: [OwnerGuard] }, //OGLASI OD VLASNIKA
    { path: 'my/advert/:id', component: CaptureComponent, canActivate: [OwnerGuard]}, //vlasnik daje termin zauzeca
    { path: 'my/cars', component: MyCarsComponent, canActivate: [OwnerGuard]},
    { path: 'my/price/list', component: MyPriceListComponent, canActivate: [OwnerGuard]},
    { path: 'create/advert', component: CreateAdvertComponent, canActivate: [OwnerGuard]},
    { path: 'register/car', component: RegisterCarComponent, canActivate: [OwnerGuard]},
    { path: 'define/price', component: DefinePriceComponent, canActivate: [OwnerGuard]}

  ]},
  { path: 'not-found', component: NotFoundComponent},
  { path: '**', redirectTo: '/not-found'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

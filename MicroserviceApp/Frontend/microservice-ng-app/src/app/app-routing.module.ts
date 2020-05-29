import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegistrationComponent} from './registration/registration.component';
import {LoginComponent} from './login/login.component';
import {CreateAdvertComponent} from "./create-advert/create-advert.component";
import {MyAdvertsComponent} from "./my-adverts/my-adverts.component";
import {AllAdvertsComponent} from "./all-adverts/all-adverts.component";


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
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

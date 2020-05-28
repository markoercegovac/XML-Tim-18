import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegistrationComponent} from './registration/registration.component';
import {LoginComponent} from './login/login.component';
import {CreateUserAdvertComponent} from './create-user-advert/create-user-advert.component';
import {MyAdvertsComponent} from './my-adverts/my-adverts.component';
import {HomeComponent} from './home/home.component';


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
    path: 'createAdvert',
    component: CreateUserAdvertComponent
  },
  {
    path: 'myAdverts',
    component: MyAdvertsComponent
  },
  {
    path: 'home',
    component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

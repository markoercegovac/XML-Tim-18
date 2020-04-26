import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignInComponent } from './sign-in/sign-in.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { AdvertsComponent } from './home/adverts/adverts.component';
import { FullAdvertComponent } from './home/full-advert/full-advert.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: '/home/ads'} ,
  {path: 'home', component: HomeComponent, children: [
    {path: 'ads', component: AdvertsComponent},
    {path: 'ad/:id', component: FullAdvertComponent}
  ]},
  {path: 'sign-in', component: SignInComponent},
  {path: 'register', component: RegisterComponent},
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

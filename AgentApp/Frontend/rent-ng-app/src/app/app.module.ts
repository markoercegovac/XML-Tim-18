import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { SignInComponent } from './sign-in/sign-in.component';
import { RegisterComponent } from './register/register.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { HomeComponent } from './home/home.component';
import { HomeHeaderComponent } from './home/home-header/home-header.component';
import { AdvertsComponent } from './home/adverts/adverts.component';
import { AdvertMiniComponent } from './home/adverts/advert-mini/advert-mini.component';
import { FullAdvertComponent } from './home/full-advert/full-advert.component';

@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    RegisterComponent,
    NotFoundComponent,
    HomeComponent,
    HomeHeaderComponent,
    AdvertsComponent,
    AdvertMiniComponent,
    FullAdvertComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

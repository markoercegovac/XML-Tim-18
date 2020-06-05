import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import { NavigationComponent } from './navigation/navigation.component';
import { LoginComponent } from './login/login.component';
import { AuthInterceptor } from './interceptor/auth.interceptor';
import { CreateAdvertComponent } from './advert/create-advert/create-advert.component';
import { MyAdvertsComponent } from './advert/my-adverts/my-adverts.component';
import { AllAdvertsComponent } from './advert/all-adverts/all-adverts.component';
import { RegisterCarComponent } from './advert/car/register-car/register-car.component';
import { DefinePriceComponent } from './advert/price/define-price/define-price.component';
import { MyPriceListComponent } from './advert/price/my-price-list/my-price-list.component';
import { MyCarsComponent } from './advert/car/my-cars/my-cars.component';
import { SearchComponent } from './search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    NavigationComponent,
    LoginComponent,
    CreateAdvertComponent,
    MyAdvertsComponent,
    AllAdvertsComponent,
    RegisterCarComponent,
    DefinePriceComponent,
    MyPriceListComponent,
    MyCarsComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }

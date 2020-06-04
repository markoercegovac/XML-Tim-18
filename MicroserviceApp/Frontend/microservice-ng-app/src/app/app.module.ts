import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {DragDropModule} from '@angular/cdk/drag-drop';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import { NavigationComponent } from './navigation/navigation.component';
import { LoginComponent } from './login/login.component';
import { CartComponent } from './cart/cart.component';
import { AuthInterceptor } from './interceptor/auth.interceptor';
import { CartItemComponent } from './cart/cart-item/cart-item.component';
import { BundleComponent } from './bundle/bundle.component';
import { BundleItemComponent } from './bundle/bundle-item/bundle-item.component';
import { AdItemComponent } from './bundle/bundle-item/ad-item/ad-item.component';
import { CreateAdvertComponent } from './advert/create-advert/create-advert.component';
import { MyAdvertsComponent } from './advert/my-adverts/my-adverts.component';
import { AllAdvertsComponent } from './advert/all-adverts/all-adverts.component';
import { RegisterCarComponent } from './advert/car/register-car/register-car.component';
import { DefinePriceComponent } from './advert/price/define-price/define-price.component';
import { MyPriceListComponent } from './advert/price/my-price-list/my-price-list.component';
import { MyCarsComponent } from './advert/car/my-cars/my-cars.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    NavigationComponent,
    LoginComponent,
    CartComponent,
    LoginComponent,
    CartItemComponent,
    BundleComponent,
    BundleItemComponent,
    AdItemComponent,
    CreateAdvertComponent,
    MyAdvertsComponent,
    AllAdvertsComponent,
    RegisterCarComponent,
    DefinePriceComponent,
    MyPriceListComponent,
    MyCarsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    DragDropModule,
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

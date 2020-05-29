import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';


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
    AdItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }

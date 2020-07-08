import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
// @ts-ignore
import {DragDropModule} from '@angular/cdk/drag-drop';
// @ts-ignore
import { CarouselModule, ModalModule, WavesModule } from 'angular-bootstrap-md';
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
import { CarBrandComponent } from './car-brand/car-brand.component';
import { CarClassComponent } from './car-class/car-class.component';
import { CarFuelTypeComponent } from './car-fuel-type/car-fuel-type.component';
import { CarModelComponent } from './car-model/car-model.component';
import { CarTranssmisionTypeComponent } from './car-transsmision-type/car-transsmision-type.component';
import { NavigationAdminComponent } from './navigation-admin/navigation-admin.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CreateCarBrandComponent } from './car-brand/create-car-brand/create-car-brand.component';
import {MatDialogModule} from "@angular/material/dialog";
import { CreateCarClassComponent } from './car-class/create-car-class/create-car-class.component';
import { CreateFuelTypeComponent } from './car-fuel-type/create-fuel-type/create-fuel-type.component';
import { CreateCarModelComponent } from './car-model/create-car-model/create-car-model.component';
import { CreateTranssmisionTypeComponent } from './car-transsmision-type/create-transsmision-type/create-transsmision-type.component';
import { UpdateCarBrandComponent } from './car-brand/update-car-brand/update-car-brand.component';
import { UpdateCarClassComponent } from './car-class/update-car-class/update-car-class.component';
import { UpdateFuelTypeComponent } from './car-fuel-type/update-fuel-type/update-fuel-type.component';
import { UpdateCarModelComponent } from './car-model/update-car-model/update-car-model.component';
import { UpdateCarTransmissionComponent } from './car-transsmision-type/update-car-transmission/update-car-transmission.component';
import { SearchComponent } from './search/search.component';
import { AdvertDetailViewComponent } from './advert-detail-view/advert-detail-view.component';
import { NotFoundComponent } from './not-found/not-found.component';

import { CaptureComponent } from './advert/capture/capture/capture.component';

import { OwnerViewRequestsComponent } from './owner-view-requests/owner-view-requests.component';
import { AdRequestItemComponent } from './owner-view-requests/ad-request-item/ad-request-item.component';
import { MessagesComponent } from './messages/messages.component';
import { MessageComponent } from './messages/message/message.component';
import { CreateMessageComponent } from './messages/create-message/create-message.component';
import { MessageDetailComponent } from './messages/message-detail/message-detail.component';

import { UsersBanListComponent } from './users-ban-list/users-ban-list.component';
import { CreateCommentComponent } from './home/full-advert/comments/create-comment/create-comment.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './home/footer/footer.component';
import { AdvertsComponent } from './home/adverts/adverts.component';
import { AdvertMiniComponent } from './home/adverts/advert-mini/advert-mini.component';
import { FullAdvertComponent } from './home/full-advert/full-advert.component';
import { CommentsComponent } from './home/full-advert/comments/comments.component';
import { HomeHeaderComponent } from './home/home-header/home-header.component';
import { CommentComponent } from './home/full-advert/comments/comment/comment.component';
import { AdminCommentsAllowComponent } from './admin-comments-allow/admin-comments-allow.component';
import { AdminComponent } from './admin/admin.component';
import { NavigationUserComponent } from './navigation-user/navigation-user.component';
import { NavigationOwnerComponent } from './navigation-owner/navigation-owner.component';
import { NavigationUnregistatedComponent } from './navigation-unregistated/navigation-unregistated.component';
import { RequestsComponent } from './home/requests/requests.component';
import { RequestsBundleComponent } from './home/requests/requests-bundle/requests-bundle.component';
import { RequestingAdItemComponent } from './home/requests/requests-bundle/requesting-ad-item/requesting-ad-item.component';
import { AddingToCartComponent } from './adding-to-cart/adding-to-cart.component';
import { BundleRequestComponent } from './owner-view-requests/bundle-request/bundle-request.component';
import { AdminBanUsersComponent } from './admin-ban-users/admin-ban-users.component';
import { RegisterAgentComponent } from './registration/register-agent/register-agent.component';
import { RegisterUserComponent } from './registration/register-user/register-user.component';
import { AdminRegisterRequestsComponent } from './admin-register-requests/admin-register-requests.component';
import { RegisterRequestsItemComponent } from './admin-register-requests/register-requests-item/register-requests-item.component';


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
    MyCarsComponent,
    CaptureComponent,
    CarBrandComponent,
    CarClassComponent,
    CarFuelTypeComponent,
    CarModelComponent,
    CarTranssmisionTypeComponent,
    NavigationAdminComponent,
    CreateCarBrandComponent,
    CreateCarClassComponent,
    CreateFuelTypeComponent,
    CreateCarModelComponent,
    CreateTranssmisionTypeComponent,
    UpdateCarBrandComponent,
    UpdateCarClassComponent,
    UpdateFuelTypeComponent,
    UpdateCarModelComponent,
    UpdateCarTransmissionComponent,
    SearchComponent,
    AdvertDetailViewComponent,
    NotFoundComponent,
    OwnerViewRequestsComponent,
    AdRequestItemComponent,
    MessagesComponent,
    MessageComponent,
    CreateMessageComponent,
    MessageDetailComponent,
    AdRequestItemComponent,
    UsersBanListComponent,
    CreateCommentComponent,
    HomeComponent,
    FooterComponent,
    AdvertsComponent,
    AdvertMiniComponent,
    FullAdvertComponent,
    CommentsComponent,
    HomeHeaderComponent,
    CommentComponent,
    AdminCommentsAllowComponent,
    AdminComponent,
    NavigationUserComponent,
    NavigationOwnerComponent,
    NavigationUnregistatedComponent,
    RequestsComponent,
    RequestsBundleComponent,
    RequestingAdItemComponent,
    AddingToCartComponent,
    BundleRequestComponent,
    AdminBanUsersComponent,
    RegisterAgentComponent,
    RegisterUserComponent,
    AdminRegisterRequestsComponent,
    RegisterRequestsItemComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule,
        BrowserAnimationsModule,
        MatPaginatorModule,
        MatSortModule,
        MatTableModule,
        MatIconModule,
        MatPaginatorModule,
        MatButtonModule,
        MatFormFieldModule,
        MatInputModule,
        MatDialogModule,
        DragDropModule,
        ReactiveFormsModule,
        CarouselModule, ModalModule, WavesModule
    ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }

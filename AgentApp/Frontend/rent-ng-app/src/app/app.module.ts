import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MDBBootstrapModule} from 'angular-bootstrap-md';
// @ts-ignore
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { SignInComponent } from './sign-in/sign-in.component';
import { RegisterComponent } from './register/register.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { HomeComponent } from './home/home.component';
import { HomeHeaderComponent } from './home/home-header/home-header.component';
import { AdvertsComponent } from './home/adverts/adverts.component';
import { AdvertMiniComponent } from './home/adverts/advert-mini/advert-mini.component';
import { FullAdvertComponent } from './home/full-advert/full-advert.component';
import { BasicSearchComponent } from './home/search/basic-search/basic-search.component';
import { AdvanceSearchComponent } from './home/search/advance-search/advance-search.component';
import { SearchComponent } from './home/search/search.component';
import { FooterComponent } from './home/footer/footer.component';
import { CommentComponent } from './home/full-advert/comments/comment/comment.component';
import { CommentsComponent } from './home/full-advert/comments/comments.component';
import { AddCommentComponent } from './home/full-advert/comments/add-comment/add-comment.component';

import { AdminComponent } from './admin/admin.component';
import { AdminHeaderComponent } from './admin/admin-header/admin-header.component';
import { AdminCommentsComponent } from './admin/admin-comments/admin-comments.component';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { AdminCommentComponent } from './admin/admin-comments/admin-comment/admin-comment.component';
import { AddAdvertComponent } from './home/adverts/add-advert/add-advert.component';

import { NavigationComponent } from './navigation/navigation.component';



import { RegisterCarComponent } from './register-car/register-car.component';
import { DefinePriceComponent } from './define-price/define-price.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ReservedCarComponent } from './reserved-car/reserved-car.component';
import { MyAdvertComponent } from './my-advert/my-advert.component';
import { ChatComponent } from './chat/chat.component';
import { ChatHeaderComponent } from './chat/chat-header/chat-header.component';
import { InboxComponent } from './inbox/inbox.component';
import { MesagesComponent } from './inbox/mesages/mesages.component';
import { DriveReportCreateComponent } from './drive-report-create/drive-report-create.component';
import { DriveReportListComponent } from './drive-report-list/drive-report-list.component';
import { DriveReportUpdateComponent } from './drive-report-update/drive-report-update.component';
import { AllRegistrationRequestComponent } from './all-registration-request/all-registration-request.component';
import { RegisterApprovedComponent } from './register-approved/register-approved.component';
import {AuthInterceptor} from './interceptor/AuthInterceptor';
import { ReservationDateComponent } from './home/full-advert/reservation-date/reservation-date.component';

import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDialogModule} from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavAdminComponent } from './navigation/nav-admin/nav-admin.component';
import { NavUserComponent } from './navigation/nav-user/nav-user.component';
import { NavOwnerComponent } from './navigation/nav-owner/nav-owner.component';
import { NavNoComponent } from './navigation/nav-no/nav-no.component';
import { StatisticsComponent } from './statistics/statistics.component';
import {ChartsModule} from 'ng2-charts';

import { CarBrandComponent } from './car-brand/car-brand.component';
import { CarClassComponent } from './car-class/car-class.component';
import { CarFuelTypeComponent } from './car-fuel-type/car-fuel-type.component';
import { CarModelComponent } from './car-model/car-model.component';
import { CarTranssmisionTypeComponent } from './car-transsmision-type/car-transsmision-type.component';
import { CreateCarBrandComponent } from './car-brand/create-car-brand/create-car-brand.component';
import { CreateCarClassComponent } from './car-class/create-car-class/create-car-class.component';
import { CreateFuelTypeComponent } from './car-fuel-type/create-fuel-type/create-fuel-type.component';
import { CreateCarModelComponent } from './car-model/create-car-model/create-car-model.component';
import { CreateTranssmisionTypeComponent } from './car-transsmision-type/create-transsmision-type/create-transsmision-type.component';
import { UpdateCarBrandComponent } from './car-brand/update-car-brand/update-car-brand.component';
import { UpdateCarClassComponent } from './car-class/update-car-class/update-car-class.component';
import { UpdateFuelTypeComponent } from './car-fuel-type/update-fuel-type/update-fuel-type.component';
import { UpdateCarModelComponent } from './car-model/update-car-model/update-car-model.component';
import { UpdateCarTransmissionComponent } from './car-transsmision-type/update-car-transmission/update-car-transmission.component';


import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule} from '@angular/material/sort';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';

@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    SearchComponent,
    RegisterComponent,
    NotFoundComponent,
    HomeComponent,
    HomeHeaderComponent,
    AdvertsComponent,
    AdvertMiniComponent,
    FullAdvertComponent,
    SearchComponent,
    BasicSearchComponent,
    AdvanceSearchComponent,
    FooterComponent,
    CommentComponent,
    CommentsComponent,
    AddCommentComponent,
    AdminComponent,
    AdminHeaderComponent,
    AdminCommentsComponent,
    AdminHomeComponent,
    AdminCommentComponent,
    AddAdvertComponent,
    NavigationComponent,
    RegisterCarComponent,
    DefinePriceComponent,
    DriveReportCreateComponent,
    DriveReportListComponent,
    DriveReportUpdateComponent,
    ReservedCarComponent,
    MyAdvertComponent,
    ChatComponent,
    ChatHeaderComponent,
    InboxComponent,
    MesagesComponent,
    AllRegistrationRequestComponent,
    RegisterApprovedComponent,
    ReservationDateComponent,
    NavAdminComponent,
    NavUserComponent,
    NavOwnerComponent,
    NavNoComponent,
    RegisterApprovedComponent,
    StatisticsComponent,

    AllRegistrationRequestComponent,
    CarBrandComponent,
    CarClassComponent,
    CarFuelTypeComponent,
    CarModelComponent,
    CarTranssmisionTypeComponent,
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

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    MDBBootstrapModule,
    ReactiveFormsModule,
    ChartsModule,
    MatFormFieldModule,
    MatDialogModule,
    MDBBootstrapModule,
    BrowserAnimationsModule,
    MDBBootstrapModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatPaginatorModule,
    MatSortModule,
    MatTableModule,
    MatIconModule,
    MatPaginatorModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }

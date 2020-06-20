import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MDBBootstrapModule} from 'angular-bootstrap-md';
// @ts-ignore
import { HttpClientModule } from '@angular/common/http';
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
import {FormsModule} from '@angular/forms';
import { ReservedCarComponent } from './reserved-car/reserved-car.component';
import { MyAdvertComponent } from './my-advert/my-advert.component';
import { ChatComponent } from './home/footer/chat/chat.component';
import { DriveReportCreateComponent } from './drive-report-create/drive-report-create.component';
import { DriveReportListComponent } from './drive-report-list/drive-report-list.component';
import { DriveReportUpdateComponent } from './drive-report-update/drive-report-update.component';


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
    ChatComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    MDBBootstrapModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

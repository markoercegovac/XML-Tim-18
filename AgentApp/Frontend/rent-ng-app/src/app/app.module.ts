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
import { BasicSearchComponent } from './home/search/basic-search/basic-search.component';
import { AdvanceSearchComponent } from './home/search/advance-search/advance-search.component';
import { SearchComponent } from './home/search/search.component';
import { FooterComponent } from './home/footer/footer.component';
import { CommentComponent } from './home/full-advert/comments/comment/comment.component';
import { CommentsComponent } from './home/full-advert/comments/comments.component';

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
    CommentsComponent
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

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import {HttpClientModule} from '@angular/common/http';
import { UserComponent } from './user/user.component';
import { TransmissionTypeComponent } from './transmission-type-create/transmission-type.component';
import { TransmissionTypeListComponent } from './transmission-type-list/transmission-type-list.component';
import {FormsModule} from '@angular/forms';

import { TransmissionTypeUpdateComponent } from './transmission-type-update/transmission-type-update.component';
import { FuelTypeCreateComponent } from './fuel-type-create/fuel-type-create.component';
import { FuelTypeListComponent } from './fuel-type-list/fuel-type-list.component';
import { FuelTypeUpdateComponent } from './fuel-type-update/fuel-type-update.component';
import { DriveReportCreateComponent } from './drive-report-create/drive-report-create.component';
import { DriveReportListComponent } from './drive-report-list/drive-report-list.component';
import { DriveReportUpdateComponent } from './drive-report-update/drive-report-update.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    UserComponent,
    TransmissionTypeComponent,
    TransmissionTypeListComponent,
    TransmissionTypeUpdateComponent,
    FuelTypeCreateComponent,
    FuelTypeListComponent,
    FuelTypeUpdateComponent,
    DriveReportCreateComponent,
    DriveReportListComponent,
    DriveReportUpdateComponent
  ],
    imports: [
        BrowserModule,
        HttpClientModule,
        AppRoutingModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

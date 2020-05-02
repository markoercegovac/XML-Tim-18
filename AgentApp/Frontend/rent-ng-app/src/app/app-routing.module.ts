import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserComponent} from './user/user.component';
import {TransmissionTypeComponent} from './transmission-type-create/transmission-type.component';
import {TransmissionTypeListComponent} from './transmission-type-list/transmission-type-list.component';
import {TransmissionTypeUpdateComponent} from './transmission-type-update/transmission-type-update.component';
import {FuelTypeCreateComponent} from './fuel-type-create/fuel-type-create.component';
import {FuelTypeListComponent} from './fuel-type-list/fuel-type-list.component';
import {FuelTypeUpdateComponent} from './fuel-type-update/fuel-type-update.component';
import {DriveReportCreateComponent} from './drive-report-create/drive-report-create.component';
import {DriveReportListComponent} from './drive-report-list/drive-report-list.component';
import {DriveReportUpdateComponent} from './drive-report-update/drive-report-update.component';


const routes: Routes = [
  {
    path: 'user',
    component: UserComponent,
  },
  {
    path: 'kreirajCTT',
    component: TransmissionTypeComponent
  },
  {
    path: 'listaCTT',
    component: TransmissionTypeListComponent
  },
  {
    path: 'updateCTT/:id',
    component: TransmissionTypeUpdateComponent
  },
  {
    path: 'kreirajFT',
    component: FuelTypeCreateComponent
  },
  {
    path: 'listaFT',
    component: FuelTypeListComponent
  },
  {
    path: 'updateFT/:id',
    component: FuelTypeUpdateComponent
  },
  {
    path: 'kreirajDR',
    component: DriveReportCreateComponent
  },
  {
    path: 'listaDR',
    component: DriveReportListComponent
  },
  {
    path: 'updateDR/:id',
    component: DriveReportUpdateComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

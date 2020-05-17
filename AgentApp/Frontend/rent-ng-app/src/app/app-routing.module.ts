import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserComponent} from './user/user.component';
import {CarBrandComponent} from './car-brand/car-brand.component';


const routes: Routes = [
  {
    path: 'user',
    component: UserComponent,
  },
  {
    path: 'carBrand',
    component: CarBrandComponent,
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

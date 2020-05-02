import { Component, OnInit } from '@angular/core';
import {CarFuelType} from '../model/car-fuel-type';
import {Router} from '@angular/router';
import {CarFuelTypeService} from '../servis/car-fuel-type.service';


@Component({
  selector: 'app-fuel-type-create',
  templateUrl: './fuel-type-create.component.html',
  styleUrls: ['./fuel-type-create.component.css']
})
export class FuelTypeCreateComponent implements OnInit {

  model: CarFuelType = new CarFuelType();
  constructor( private ftService: CarFuelTypeService , private router: Router) { }

  ngOnInit(): void {
  }

  createC(){
    this.ftService.createFt(this.model).subscribe(
      res => {
    //    location.reload();
      },
      error => {
        alert('Error');
      }
    );
    this.model = new CarFuelType();
    this.goToList();
  }

  goToList() {
    this.router.navigate(['/listaFT']);
  }
}

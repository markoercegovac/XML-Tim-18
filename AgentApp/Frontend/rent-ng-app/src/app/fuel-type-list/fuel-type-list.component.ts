import { Component, OnInit } from '@angular/core';
import {CarFuelType} from '../model/car-fuel-type';
import {Router} from '@angular/router';
import {CarFuelTypeService} from '../servis/car-fuel-type.service';

@Component({
  selector: 'app-fuel-type-list',
  templateUrl: './fuel-type-list.component.html',
  styleUrls: ['./fuel-type-list.component.css']
})
export class FuelTypeListComponent implements OnInit {
  title = 'Car Fuel Type';
  typeC: CarFuelType[];
  constructor(private ftService: CarFuelTypeService , private router: Router) { }

  ngOnInit(): void {
    this.ftService.readFt().subscribe(
      data => {
        this.typeC = data;
      },
      error => {
        console.log('Error occured', error);
      }
    );
  }

  updateC(ft: CarFuelType, id: number){
    this.router.navigate(['updateFT', id]);
  }

  deleteC(id: number, ft: CarFuelType){
    this.ftService.deleteFt(id, ft).subscribe(
      res => {
        //   location.reload();
       //   this.typeC.pop();
      },
      error => {
        alert('Error');
      }
    );
  }

}

import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CarService} from "../service/car-service";
import {CarModel} from "../model/carModel";
import {CarBrand} from "../model/carBrand";
import {CarClass} from "../model/carClass";
import {CarFuelType} from "../model/carFuelType";
import {CarTransmission} from "../model/carTransmission";
import {Car} from "../model/car";

@Component({
  selector: 'app-register-car',
  templateUrl: './register-car.component.html',
  styleUrls: ['./register-car.component.css']
})
export class RegisterCarComponent implements OnInit {

  allCarModel: CarModel[]


  constructor(private http:HttpClient,private carService:CarService) {}


  ngOnInit(): void {
    this.carService.getAllCarModels().subscribe(
      data=>{
        this.allCarModel=data;
      },
      error => {
        console.log('Error occurred', error);
      }
    );
  }

}

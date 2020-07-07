import { Component, OnInit } from '@angular/core';
import {CarModel} from "../../../model/carModel";
import {CarClass} from "../../../model/carClass";
import {CarFuelType} from "../../../model/carFuelType";
import {CarBrand} from "../../../model/carBrand";
import {CarTransmission} from "../../../model/carTransmission";
import {Car} from "../../../model/car";
import {CarService} from "../../../services/car.service";
import {HttpClient} from "@angular/common/http";
import {NgForm} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-car',
  templateUrl: './register-car.component.html',
  styleUrls: ['./register-car.component.css']
})
export class RegisterCarComponent implements OnInit {

  allCarModel: CarModel[];
  allCarClass: CarClass[];
  allCarFuelType: CarFuelType[];
  allCarBrand: CarBrand[];
  allCarTransmission: CarTransmission[];
  model: Car={
    id: 0,
    childrenSitNumber: 0,
    isInsurance: false,
    travelDistance: 0,
    carBrandId: 0,
    carClassId: 0,
    carFuelTypeId: 0,
    carModelId: 0,
    carTransmissionTypeId: 0,
    year: "",
    nameOfCar:"",
  };
  dates: string[] = [];

  constructor(private carService: CarService, private router: Router) { }

  ngOnInit(): void {

    let startDate = (new Date()).getUTCFullYear();
    for(let i=0; i<30; ++i) {
      this.dates[i] = (startDate - i).toString();
    }
    this.model.year = this.dates[0];

    this.carService.getAllCarBrands().subscribe(
      data=>{
        this.allCarBrand=data;
      },
      error => {
        console.log('Error occurred', error);
      }
    );

    this.carService.getAllCarClass().subscribe(
      data=>{
        this.allCarClass=data;
      },
      error => {
        console.log('Error occurred',error);
      }
    );

    this.carService.getAllCarTransmissionType().subscribe(
      data=>{
        this.allCarTransmission=data;
      },
      error => {
        console.log('Error occurred', error);
      }
    );

    this.carService.getAllFuelType().subscribe(
      data=>{
        this.allCarFuelType=data;
      },
      error => {
        console.log('Error occurred', error);
      }
    );

  }

  createCar() {
    this.carService.registerCar(this.model).subscribe(
      data => {
        this.router.navigate(["/home/create/advert"]);
      }
    );
  }

  changeBrand(){

    this.carService.getAllCarModels(this.model.carBrandId).subscribe(
      data=>{
        this.allCarModel=data;
        this.model.carModelId = this.allCarModel[0].id;
      },
      error => {
        console.log('Error occurred', error);
      }
    );
  }
}

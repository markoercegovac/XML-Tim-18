import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CarService} from "../service/car-service";
import {CarModel} from "../model/carModel";
import {CarBrand} from "../model/carBrand";
import {CarClass} from "../model/carClass";
import {CarFuelType} from "../model/carFuelType";
import {CarTransmission} from "../model/carTransmission";
import { FormControl, Validators, FormGroup } from '@angular/forms';
import {Car} from "../model/car";

@Component({
  selector: 'app-register-car',
  templateUrl: './register-car.component.html',
  styleUrls: ['./register-car.component.css']
})
export class RegisterCarComponent implements OnInit {

  createForm: FormGroup;
  allCarModel: CarModel[];
  allCarClass: CarClass[];
  allCarFuelType: CarFuelType[];
  allCarBrand: CarBrand[];
  allCarTransmission: CarTransmission[];
  model: Car;

  constructor(private http:HttpClient,private carService:CarService) {}


  ngOnInit(): void {

    this.createForm=new FormGroup({''})

    this.carService.getAllCarModels().subscribe(
      data=>{
        this.allCarModel=data;
      },
      error => {
        console.log('Error occurred', error);
      }
    );

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

    createCar():void{
    this.carService.registerCar(this.model).subscribe(

      res=>{
        location.reload();
        console.log(this.model);
        alert("Car created");
      },
      error => {
        console.log(this.model);
        alert("Error");
      }
    );
  }

}

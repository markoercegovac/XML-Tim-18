import { Component, OnInit } from '@angular/core';
import {CarService} from "../../../services/car.service";
import {Car} from "../../../model/car";
import {Price} from "../../../model/price";
import {PriceService} from "../../../services/price.service";

@Component({
  selector: 'app-my-cars',
  templateUrl: './my-cars.component.html',
  styleUrls: ['./my-cars.component.css']
})
export class MyCarsComponent implements OnInit {

  allMyCars:Car[];


  constructor(private carService:CarService) { }

  ngOnInit(): void {
    this.carService.getUserCarList().subscribe(
      data=>{
        this.allMyCars=data;
      }
    )


  }

}

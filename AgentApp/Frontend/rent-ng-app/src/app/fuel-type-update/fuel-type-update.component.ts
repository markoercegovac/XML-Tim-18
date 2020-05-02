import { Component, OnInit } from '@angular/core';
import {CarFuelType} from '../model/car-fuel-type';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {CarFuelTypeService} from '../servis/car-fuel-type.service';

@Component({
  selector: 'app-fuel-type-update',
  templateUrl: './fuel-type-update.component.html',
  styleUrls: ['./fuel-type-update.component.css']
})
export class FuelTypeUpdateComponent implements OnInit {

  id: number;

  model: CarFuelType;
  constructor(private route: ActivatedRoute, private router: Router, private ftService: CarFuelTypeService) { }

  ngOnInit(): void {
    this.model = new  CarFuelType();

    // this.id = this.route.snapshot.params.id;
    this.route.params.subscribe(
      (params: Params) => {
        this.id = +params.id;
      }
    );


    this.ftService.readFtById(this.id).subscribe(
      data => {
        this.model = data;
      },
      error => {
        console.log('Error occured', error);
      }
    );
  }

  updateC(){
    this.ftService.updateFt(this.model, this.id).subscribe(
      res => {
        //   location.reload();
      },
      error => {
        alert('Error');
      }
    );
    this.model = new CarFuelType();
    this.goToList();
  }

  goToList(){
    this.router.navigate([ '/listaFT' ]);
  }
}

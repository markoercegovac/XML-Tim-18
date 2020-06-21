import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {DriveReportService} from '../service/drive-report.service';
import {DriveReport} from '../model/drive-report';
import {CarMini} from '../model/car-mini';
import {CarService} from '../service/car-service';



@Component({
  selector: 'app-drive-report-create',
  templateUrl: './drive-report-create.component.html',
  styleUrls: ['./drive-report-create.component.css']
})
export class DriveReportCreateComponent implements OnInit {

  model: DriveReport = new DriveReport();
  allCars: CarMini[];
  constructor(private drService: DriveReportService , private router: Router, private carService: CarService) { }

  ngOnInit(): void {
    this.carService.getAllCars().subscribe(

      data => {
        this.allCars = data;
      },
      error => {
        console.log('Error occurred', error);
      }
    );

  }
  createC(){

    console.log( 'tekst', this.model.carId);
    this.drService.createDr(this.model).subscribe(
      res => {
        this.goToList();
      },
      error => {
        alert('Error');
        this.goToList();
      }
    );
    //this.model = new DriveReport();
 
  }

  goToList() {
    this.router.navigate(['/listaDR/' + this.model.carId]);
  }

  setValue(car: CarMini) {
      this.model.carId = car.id;
  }

}

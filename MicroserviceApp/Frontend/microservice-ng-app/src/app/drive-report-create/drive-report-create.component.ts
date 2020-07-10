import { Component, OnInit } from '@angular/core';
import {DriveReport} from '../model/DriveReport';
import {CarMini} from '../model/carMini';
import {DriveReportService} from '../services/drive-report.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-drive-report-create',
  templateUrl: './drive-report-create.component.html',
  styleUrls: ['./drive-report-create.component.css']
})
export class DriveReportCreateComponent implements OnInit {

  model: DriveReport = new DriveReport();
  allCars: CarMini[];

  constructor(private drService: DriveReportService , private router: Router) { }

  ngOnInit(): void {
    this.drService.getAllCars().subscribe(

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
  }

  goToList() {
    this.router.navigate(['/listaDR/' + this.model.carId]);
  }

}

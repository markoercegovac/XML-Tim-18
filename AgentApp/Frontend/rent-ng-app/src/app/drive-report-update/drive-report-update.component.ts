import { Component, OnInit } from '@angular/core';
import {DriveReport} from '../model/drive-report';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {DriveReportService} from '../servis/drive-report.service';

@Component({
  selector: 'app-drive-report-update',
  templateUrl: './drive-report-update.component.html',
  styleUrls: ['./drive-report-update.component.css']
})
export class DriveReportUpdateComponent implements OnInit {
  id: number;

  model: DriveReport;
  constructor(private route: ActivatedRoute, private router: Router, private drService: DriveReportService) { }

  ngOnInit(): void {
    this.model = new  DriveReport();

    // this.id = this.route.snapshot.params.id;
    this.route.params.subscribe(
      (params: Params) => {
        this.id = +params.id;
      }
    );


    this.drService.readDrById(this.id).subscribe(
      data => {
        this.model = data;
      },
      error => {
        console.log('Error occured', error);
      }
    );
  }
  updateC(){
    this.drService.updateDr(this.model, this.id).subscribe(
      res => {
        //   location.reload();
      },
      error => {
        alert('Error');
      }
    );
    this.model = new DriveReport();
    this.goToList();
  }

  goToList(){
    this.router.navigate([ '/listaDR' ]);
  }

}

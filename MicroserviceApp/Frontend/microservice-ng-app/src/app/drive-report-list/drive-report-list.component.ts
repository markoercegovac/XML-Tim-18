import { Component, OnInit } from '@angular/core';
import {DriveReport} from '../model/DriveReport';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {DriveReportService} from '../services/drive-report.service';

@Component({
  selector: 'app-drive-report-list',
  templateUrl: './drive-report-list.component.html',
  styleUrls: ['./drive-report-list.component.css']
})
export class DriveReportListComponent implements OnInit {

  title = 'Drive Report';
  typeC: DriveReport[];
  id: number;

  constructor(private route: ActivatedRoute, private drService: DriveReportService , private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        this.id = +params.id;
        console.log(this.id);

        this.drService.readDrById(this.id).subscribe(
          data => {
            this.typeC = data;
            console.log(this.typeC);
          },
          error => {
            console.log('Error occured', error);
          }
        );
      }
    );
  }

}

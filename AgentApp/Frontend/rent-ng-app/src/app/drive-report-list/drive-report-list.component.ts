import { Component, OnInit } from '@angular/core';
import {DriveReport} from '../model/drive-report';
import {Router} from '@angular/router';
import {DriveReportService} from '../servis/drive-report.service';

@Component({
  selector: 'app-drive-report-list',
  templateUrl: './drive-report-list.component.html',
  styleUrls: ['./drive-report-list.component.css']
})
export class DriveReportListComponent implements OnInit {
  title = 'Drive Report';
  typeC: DriveReport[];

  constructor(private drService: DriveReportService , private router: Router) { }

  ngOnInit(): void {
    this.drService.readDr().subscribe(
      data => {
        this.typeC = data;
      },
      error => {
        console.log('Error occured', error);
      }
    );
  }
  updateC(dr: DriveReport, id: number){
    this.router.navigate(['updateDR', id]);
  }

  deleteC(id: number, dr: DriveReport){
    this.drService.deleteDr(id, dr).subscribe(
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

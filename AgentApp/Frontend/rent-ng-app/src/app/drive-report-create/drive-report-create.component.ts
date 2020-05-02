import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {DriveReportService} from '../servis/drive-report.service';
import {DriveReport} from '../model/drive-report';


@Component({
  selector: 'app-drive-report-create',
  templateUrl: './drive-report-create.component.html',
  styleUrls: ['./drive-report-create.component.css']
})
export class DriveReportCreateComponent implements OnInit {

  model: DriveReport = new DriveReport();
  constructor(private drService: DriveReportService , private router: Router) { }

  ngOnInit(): void {
  }
  createC(){
    this.drService.createDr(this.model).subscribe(
      res => {
        //    location.reload();
      },
      error => {
        alert('Error');
      }
    );
    this.model = new DriveReport();
    this.goToList();
  }

  goToList() {
    this.router.navigate(['/listaDR']);
  }

}

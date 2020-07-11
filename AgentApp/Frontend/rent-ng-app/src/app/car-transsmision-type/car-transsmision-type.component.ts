import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {HttpClient} from '@angular/common/http';

import {CarTransmission} from '../model/carTransmission';
import {MatDialog} from '@angular/material/dialog';
import {CreateTranssmisionTypeComponent} from './create-transsmision-type/create-transsmision-type.component';
import {UpdateCarTransmissionComponent} from './update-car-transmission/update-car-transmission.component';
import {CarTransmissionTypeService} from '../service/car-transmission-type.service';


@Component({
  selector: 'app-car-transsmision-type',
  templateUrl: './car-transsmision-type.component.html',
  styleUrls: ['./car-transsmision-type.component.css']
})
export class CarTranssmisionTypeComponent implements OnInit {

    name: string;
    carTranss: CarTransmission = {
      id: null,
      transmissionType: '',
      isRemoved : false
  };
  listsOfCarTranssmisionTypes: CarTransmission [] = [];

  displayColumns: string [] = ['transmissionType', 'update', 'delete'] ;
  dataSource: MatTableDataSource<CarTransmission>;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


  constructor(private http: HttpClient, public dialog: MatDialog , public service: CarTransmissionTypeService) { }

  ngOnInit(): void {
    this.getAllCarTranssmisionType();
  }


  openDialogUpdate(carTrans: CarTransmission): void {
    const dialogRefUpdate = this.dialog.open(UpdateCarTransmissionComponent, {
      width: '250px',
      data: {transmissionType: carTrans.transmissionType , id: carTrans.id , isRemoved : carTrans.isRemoved}
    });

    dialogRefUpdate.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.getAllCarTranssmisionType();
    });
  }

  // za modalni dialog
  openDialog(): void {
    const dialogRef = this.dialog.open(CreateTranssmisionTypeComponent, {
      width: '250px',
      disableClose: true,
      data: {name: this.name}

    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.getAllCarTranssmisionType();
    });

  }
 delete(carTrans: CarTransmission): void {

    const urlDelete = 'http://localhost:9090/car-transsmision-type/' + carTrans.id;

    this.http.delete(urlDelete).subscribe(res => {
      this.getAllCarTranssmisionType();
      alert('Uspesno obrisan brend.');
      },
      error => {
        alert('error');
      }



    );

  }



  public getAllCarTranssmisionType() {
  this.service.getAllCarTranssmisionType().subscribe(

      res => {
        this.dataSource  = new MatTableDataSource<CarTransmission>(res);
        this.dataSource.paginator = this.paginator;
      },
      error => {
        alert('Something went wrong');
      }
    );
  }
}

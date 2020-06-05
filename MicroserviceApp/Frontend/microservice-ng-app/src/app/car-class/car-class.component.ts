import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {HttpClient} from '@angular/common/http';
import {CarClass} from '../model/CarClass';
import {CreateCarBrandComponent} from "../car-brand/create-car-brand/create-car-brand.component";
import {MatDialog} from "@angular/material/dialog";
import {CreateCarClassComponent} from "./create-car-class/create-car-class.component";
import {CarBrand} from "../model/CarBrand";
import {UpdateCarBrandComponent} from "../car-brand/update-car-brand/update-car-brand.component";
import {CarClassService} from "../service/car-class-service";

@Component({
  selector: 'app-car-class',
  templateUrl: './car-class.component.html',
  styleUrls: ['./car-class.component.css']
})
export class CarClassComponent implements OnInit {

  name: string;

  listsOfCarClass: CarClass [] = [];

  displayColumns: string [] = ['className', 'update', 'delete'] ;
  dataSource: MatTableDataSource<CarClass>;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


  constructor(private http: HttpClient, public dialog: MatDialog ,public service: CarClassService) { }

  ngOnInit(): void {
    this.getAllCarClass();
  }


  openDialogUpdate(carClass: CarClass): void {
    const dialogRefUpdate = this.dialog.open(UpdateCarBrandComponent, {
      width: '250px',
      data: {name: carClass.className , id: carClass.id , isRemoved : carClass.isRemoved}
    });

    dialogRefUpdate.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.getAllCarClass();
    });

  }


  //za modalni dialog
  openDialog(): void {
    const dialogRef = this.dialog.open(CreateCarClassComponent, {
      width: '250px',
      data: {name: this.name}
    });

    dialogRef.afterClosed().subscribe(result => {
      this.getAllCarClass();

    });
  }

  delete(carClass: CarClass): void {

    const urlDelete = 'http://localhost:9090/advert-manager/car-class/' + carClass.id;

    this.http.delete(urlDelete).subscribe(res=>{
        location.reload();
        alert('Uspesno obrisan brend.');
      },
      error => {
        alert('error');
      }



    );

  }
  public getAllCarClass() {

    this.service.getAllCarClass().subscribe(

      res => {
        this.dataSource  = new MatTableDataSource<CarClass>(res);
        this.dataSource.paginator = this.paginator;
      },
      error => {
        alert('Something went wrong');
      }
    );
  }

}

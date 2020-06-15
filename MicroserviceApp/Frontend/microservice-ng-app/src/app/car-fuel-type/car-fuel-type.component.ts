import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {HttpClient} from '@angular/common/http';
import {CarFuelType} from '../model/carFuelType';

import {MatDialog} from "@angular/material/dialog";
import {CreateFuelTypeComponent} from "./create-fuel-type/create-fuel-type.component";


import {UpdateFuelTypeComponent} from "./update-fuel-type/update-fuel-type.component";
import {CarFuelTypeService} from "../services/car-fuel-type";

@Component({
  selector: 'app-car-fuel-type',
  templateUrl: './car-fuel-type.component.html',
  styleUrls: ['./car-fuel-type.component.css']
})
export class CarFuelTypeComponent implements OnInit {

  name: string;

  listsOfCarBrands: CarFuelType [] = [];

  displayColumns: string [] = ['name', 'update', 'delete'] ;
  dataSource: MatTableDataSource<CarFuelTypeComponent>;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


  constructor(private http: HttpClient, public dialog: MatDialog , public service: CarFuelTypeService) { }

  ngOnInit(): void {

    this.getAllCarFuelType();
  }

  delete(carFuelType: CarFuelType): void {

    const urlDelete = 'http://localhost:9090/advert-manager/car-fuel-type/' + carFuelType.id;

    this.http.delete(urlDelete).subscribe(res=>{
        //location.reload();
        alert('Uspesno obrisan brend.');
      },
      error => {
        alert('error');
      }



    );

  }


  openDialogUpdate(carFuelType: CarFuelType): void {

    const dialogRefUpdate = this.dialog.open(UpdateFuelTypeComponent, {
      width: '250px',
      data: {fuelType: carFuelType.fuelType , id: carFuelType.id , isRemoved : carFuelType.isRemoved}
    });

    dialogRefUpdate.afterClosed().subscribe(result => {
      this.getAllCarFuelType();

    });
  }
  //za modalni dialog
  openDialog(): void {
    const dialogRef = this.dialog.open(CreateFuelTypeComponent, {
      width: '250px',
      data: {name: this.name}
    });

    dialogRef.afterClosed().subscribe(result => {
      this.getAllCarFuelType();

    });
  }

  public getAllCarFuelType() {
   this.service.getAllCarFuelType().subscribe(

      res => {
        this.dataSource  = new MatTableDataSource<CarFuelTypeComponent>(res);
        this.dataSource.paginator = this.paginator;
      },
      error => {
        alert('Something went wrong');
      }
    );
  }

}

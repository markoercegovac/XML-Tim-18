import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {HttpClient} from '@angular/common/http';


import {MAT_DIALOG_DATA, MatDialog, MatDialogModule, MatDialogRef} from '@angular/material/dialog';
import {CreateCarBrandComponent} from './create-car-brand/create-car-brand.component';
import {CarBrand} from '../model/carBrand';
import {UpdateCarBrandComponent} from "./update-car-brand/update-car-brand.component";
import {CarBrandService} from "../services/car-brand-service";






@Component({
  selector: 'app-car-brand',
  templateUrl: './car-brand.component.html',
  styleUrls: ['./car-brand.component.css']
})
export class CarBrandComponent implements OnInit {

  listsOfCarBrands: CarBrand [] = [];

  name: string = "";

  displayColumns: string [] = ['name', 'update', 'delete'] ;
  dataSource: MatTableDataSource<CarBrand>;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


  constructor(private http: HttpClient, public dialog: MatDialog , public service: CarBrandService) { 
    this.dataSource = new MatTableDataSource();
    this.dataSource.data = [];
  }

  ngOnInit(): void {
    this.getAllCarBrand();
  }

  delete(carBrand: CarBrand): void {

    const urlDelete = 'http://localhost:9090/advert-manager/car-brand/' + carBrand.id;

    this.http.delete(urlDelete).subscribe(res => {
      //location.reload();
      alert('Uspesno obrisan brend.');
      },
      error => {
        alert('error');
      }



    );

  }
   openDialog(): void {
     const dialogRef = this.dialog.open(CreateCarBrandComponent, {
       width: '250px',
       data: {name: this.name}
     });

     dialogRef.afterClosed().subscribe(result => {

       this.getAllCarBrand();

     });
   }


  openDialogUpdate(carBrand: CarBrand): void {
    const dialogRefUpdate = this.dialog.open(UpdateCarBrandComponent, {
      width: '250px',
      data: {name: carBrand.name , id: carBrand.id , isRemoved : carBrand.isRemoved}
    });

    dialogRefUpdate.afterClosed().subscribe(result => {
      console.log("bio sam ovdje!");

      this.getAllCarBrand()
    });
  }

  public getAllCarBrand() {
  this.service.getAllCarBrand().subscribe(

      res => {
        this.dataSource  = new MatTableDataSource<CarBrand>(res);
        this.dataSource.paginator = this.paginator;
      },
      error => {
        alert('Something went wrong');
      }
    );
  }
}


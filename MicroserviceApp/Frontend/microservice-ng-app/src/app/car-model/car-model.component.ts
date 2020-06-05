import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {HttpClient} from '@angular/common/http';
import {CarModel} from '../model/CarModel';
import {CreateCarBrandComponent} from "../car-brand/create-car-brand/create-car-brand.component";
import {MatDialog} from "@angular/material/dialog";
import {CreateCarModelComponent} from "./create-car-model/create-car-model.component";
import {CarClass} from "../model/CarClass";
import {CarBrand} from "../model/CarBrand";
import {UpdateCarBrandComponent} from "../car-brand/update-car-brand/update-car-brand.component";
import {UpdateCarModelComponent} from "./update-car-model/update-car-model.component";
import {CarModelService} from "../service/car-model-service";

@Component({
  selector: 'app-car-model',
  templateUrl: './car-model.component.html',
  styleUrls: ['./car-model.component.css']
})
export class CarModelComponent implements OnInit {

  name: string;

  listsOfCarModels: CarModel [] = [];

  displayColumns: string [] = ['modelName', 'update', 'delete'] ;
  dataSource: MatTableDataSource<CarModel>;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


  constructor(private http: HttpClient, public dialog: MatDialog, public service: CarModelService) { }

  ngOnInit(): void {

    this.getAllCarModel();
  }

  //za modalni dialog
  openDialog(): void {
    const dialogRef = this.dialog.open(CreateCarModelComponent, {
      width: '250px',
      data: {name: this.name}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.getAllCarModel();
    });
  }

  public getAllCarModel() {
    this.service.getAllCarModel().subscribe(

      res => {
        this.dataSource  = new MatTableDataSource<CarModel>(res);
        this.dataSource.paginator = this.paginator;
      },
      error => {
        alert('Something went wrong');
      }
    );
  }

  openDialogUpdate(carModel: CarModel): void {
    const dialogRefUpdate = this.dialog.open(UpdateCarModelComponent, {
      width: '250px',
      data: {modelName: carModel.modelName , id: carModel.id , isRemoved : carModel.isRemoved}
    });


    dialogRefUpdate.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.getAllCarModel();
    });


  }

  delete(carModel: CarModel): void {

    const urlDelete = 'http://localhost:9090/advert-manager/car-model/' + carModel.id;

    this.http.delete(urlDelete).subscribe(res=>{
        //location.reload();
        alert('Uspesno obrisan brend.');
      },
      error => {
        alert('error');
      }



    );

  }
}

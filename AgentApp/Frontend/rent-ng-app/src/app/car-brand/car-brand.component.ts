import { Component, OnInit , ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CarBrand} from '../modules/car-brand';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';


@Component({
  selector: 'app-car-brand',
  templateUrl: './car-brand.component.html',
  styleUrls: ['./car-brand.component.css']
})
export class CarBrandComponent implements OnInit {

  listsOfCarBrands: CarBrand [] = [];

  displayColumns: string [] = ['name', 'update', 'delete'] ;
  dataSource: MatTableDataSource<CarBrand>;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getAllCarBrand();

  }

  public getAllCarBrand() {
    let url = 'http://localhost:9090/carBrand/all';
    this.http.get<any>(url).subscribe(

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

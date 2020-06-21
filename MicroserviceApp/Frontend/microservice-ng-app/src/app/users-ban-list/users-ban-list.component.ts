import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {HttpClient} from '@angular/common/http';
import {ClientCopy} from '../model/ClientCopy';
import {CarBrand} from "../model/carBrand";

@Component({
  selector: 'app-users-ban-list',
  templateUrl: './users-ban-list.component.html',
  styleUrls: ['./users-ban-list.component.css']
})
export class UsersBanListComponent implements OnInit {


  displayColumns: string [] = ['name', 'surname', 'email', 'role', 'bann', 'delete'] ;
  dataSource: MatTableDataSource<ClientCopy>;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  constructor( public http: HttpClient) { }

  ngOnInit(): void {

    this.getAllUsers();
  }

  public getAllUsers() {
    const urlGet = 'http://localhost:9090/advert-manager/client-copy/all';

    this.http.get<any>(urlGet).subscribe(

      res  => {
        this.dataSource  = new MatTableDataSource<ClientCopy>(res);
        this.dataSource.paginator = this.paginator;
    },
    error => {
            alert('Something went wrong');
          }
      );
  }


  delete(copyClient: ClientCopy): void {

    const urlDelete = 'http://localhost:9090/advert-manager/client-copy/' + copyClient.id;

    this.http.delete(urlDelete).subscribe(res => {

        alert('Uspesno obrisan brend.');
      },
      error => {
        alert('error');
      }



    );

  }
}

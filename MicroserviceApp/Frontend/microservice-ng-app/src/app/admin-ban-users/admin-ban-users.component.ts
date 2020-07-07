import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';

import {MatPaginator} from '@angular/material/paginator';
import {UserBan} from '../model/UserBan';
import {HttpClient} from "@angular/common/http";
import {UserBanService} from "../services/user-ban-service";
import {ClientCopyService} from "../services/client-copy-service";
import {ClientCopy} from "../model/ClientCopy";


@Component({
  selector: 'app-admin-ban-users',
  templateUrl: './admin-ban-users.component.html',
  styleUrls: ['./admin-ban-users.component.css']
})
export class AdminBanUsersComponent implements OnInit {


  displayColumns: string [] = ['Email', 'Name', 'Surname', 'City' , 'Ban' , 'Unban' , 'Delete' , 'Admin', 'Forbid Reservation', 'Forbid Creation'] ;
  dataSource: MatTableDataSource<UserBan>;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  constructor(public http: HttpClient , private userBanService: UserBanService) { }

  ngOnInit(): void {
    this.getAll();
  }


  getAll() {
    this.userBanService.getAllUsers().subscribe(

      res => {
        this.dataSource  = new MatTableDataSource<UserBan>(res);
        this.dataSource.paginator = this.paginator;
      },
      error => {
        alert('Something went wrong');
      }
    );
  }


  public ban(ub: UserBan) {

  this.userBanService.ban(ub).subscribe(res => {
    alert('Succesfuly banned user'); }, err => { alert ('Something went wrong'); }
  );

  }
  public unban(ub: UserBan) {

    this.userBanService.unban(ub).subscribe(res => {
      alert('Succesfuly unbanned user'); }, err => { alert ('Something went wrong'); });
  }

  public delete( ub: UserBan) {

    this.userBanService.delete(ub).subscribe(res => {
      alert('Successfully deleted user'); }, err => { alert ('Something went wrong'); });
  }

  public admin(element: UserBan) {

    this.userBanService.changeAdmin(element).subscribe(
      res => { alert('Successfully added admin role.');
      },
      error => { alert('Something went wrong.');
      }
    );
  }



  public forbiddenReservation(element: UserBan) {

    this.userBanService.forbidReservation(element).subscribe(
      res=>{
        alert('Successfully forbid reservation.');
      },
      error => { alert('Something went wrong.');
      }
    );
  }

  public forbiddenCreation(element: UserBan){
    this.userBanService.forbidCreation(element).subscribe(
      res=>{
        alert('Successfully forbid creation.');
      },
      error => {alert('Something went wrong.');
      }
    )
  }
}

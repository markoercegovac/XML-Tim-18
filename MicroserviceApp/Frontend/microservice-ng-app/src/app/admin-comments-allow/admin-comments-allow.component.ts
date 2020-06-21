import {Component, OnInit, ViewChild} from '@angular/core';
import {CarClass} from '../model/carClass';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from '@angular/material/paginator';
import {Comment} from '../model/Comment';
import {HttpClient} from "@angular/common/http";
import {CommentService} from '../service/comment-service';
@Component({
  selector: 'app-admin-comments-allow',
  templateUrl: './admin-comments-allow.component.html',
  styleUrls: ['./admin-comments-allow.component.css']
})
export class AdminCommentsAllowComponent implements OnInit {

  displayColumns: string [] = ['Subject', 'Content', 'Sent from', 'Approved' , 'Rejected'] ;
  dataSource: MatTableDataSource<Comment>;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  constructor(private http: HttpClient , public service: CommentService) { }

  ngOnInit(): void {

    this.getAllNewCar();

  }


  getAllNewCar() {

    this.service.getAllNewRequest().subscribe(

      res => {
        this.dataSource  = new MatTableDataSource<Comment>(res);
        this.dataSource.paginator = this.paginator;
      },
      error => {
        alert('Something went wrong');
      }
    );
  }

  Approved(element: Comment) {

    this.service.approved(element).subscribe(res=>{

      alert("Uspesno prihvacen komentar.");
    },error => {

      alert("Greska");
    });

  }


  rejected(element: Comment) {

    this.service.rejected(element).subscribe(res=>{

      alert("Uspesno odbijen komentar.");
    },error => {

      alert("Greska");
    });

  }

}

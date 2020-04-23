import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  private URL: string;

  constructor(private http: HttpClient) {
    this.URL = 'http://localhost:9090/home';
  }


  ngOnInit(): void {
    this.http.get(this.URL).subscribe();
  }

}

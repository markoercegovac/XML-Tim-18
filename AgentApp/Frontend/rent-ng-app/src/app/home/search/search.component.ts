import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styles: [
  ]
})
export class SearchComponent implements OnInit {

  toggleAdvanceSearch:boolean;

  constructor() { }

  ngOnInit(): void {
    this.toggleAdvanceSearch = false;
  }

  onChangeSearch() {
    this.toggleAdvanceSearch = !this.toggleAdvanceSearch;
  }

}
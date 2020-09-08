import { Component, OnInit } from '@angular/core';
import {Search} from '../model/search';
import {Form, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {SearchService} from '../services/search.service';
import {CarBrandPomocna} from '../model/car-brand-pomocna';
import {CarModelPomocna} from '../model/car-model-pomocna';
import {CarFuelTypePomocna} from '../model/car-fuel-type-pomocna';
import {CarClassPomocna} from '../model/car-class-pomocna';
import {CarTransmissionPomocna} from '../model/car-transmission-pomocna';


@Component({
  selector: 'app-search-advanced',
  templateUrl: './search-advanced.component.html',
  styleUrls: ['./search-advanced.component.css']
})
export class SearchAdvancedComponent implements OnInit {



  oglasi2: Search [];
  allMarks: CarBrandPomocna[];
  allModels: CarModelPomocna[];
  allFuelType: CarFuelTypePomocna[];
  allTransmissionType: CarTransmissionPomocna[];
  allClasses: CarClassPomocna[];




  // @ts-ignore
  form2 = new FormGroup({
    city: new FormControl(),
    // tslint:disable-next-line:max-line-length
    startOfAdvert: new FormControl(this.getTwoDaysForwardDate(), Validators.compose([Validators.maxLength(10), this.dateValidationStart])),
    // tslint:disable-next-line:max-line-length
    endOfAdvert: new FormControl(this.getThreeDaysForwardDate(), Validators.compose([Validators.maxLength(10), this.dateValidationEnd])), // god-mes-dan
    carMark: new FormControl(),
    carModel: new FormControl(),
    carFuelType: new FormControl(),
    carTransmissionType: new FormControl(),
    carClass: new FormControl(),
    priceFrom: new FormControl(),
    priceTo: new  FormControl(),
    traveledKm: new FormControl(),
    plannedKm: new FormControl(),
    insurance: new FormControl(),
    numberOfSeats: new FormControl(),
    mark: new FormControl(),

  });


  constructor(private router: Router, private searchService: SearchService) {
  }

  ngOnInit(): void {


    this.searchService.getAllMarks().subscribe(

      data => {
        this.allMarks = data;
        console.log('Marke:', this.allMarks);
      },
      error => {
        console.log('Error occurred', error);
      }
    );

    this.searchService.getAllModels().subscribe(

      data => {
        this.allModels = data;
        console.log('Modeli: ', this.allModels);
      },
      error => {
        console.log('Error occurred', error);
      }
    );

    this.searchService.getAllFuelType().subscribe(

      data => {
        this.allFuelType = data;
        console.log('Fuel:', this.allFuelType);
      },
      error => {
        console.log('Error occurred', error);
      }
    );

    this.searchService.getAllTransmissionType().subscribe(

      data => {
        this.allTransmissionType = data;
        console.log('Trans:', this.allTransmissionType);
      },
      error => {
        console.log('Error occurred', error);
      }
    );

    this.searchService.getAllClasses().subscribe(

      data => {
        this.allClasses = data;
        console.log('Class:', this.allClasses);
      },
      error => {
        console.log('Error occurred', error);
      }
    );

  }


  onSubmit(pretrazi) {
    const nextDay = this.getTwoDaysForwardDate();
    console.log(pretrazi);
    if (pretrazi.startOfAdvert < pretrazi.endOfAdvert) {
      if (pretrazi.startOfAdvert < nextDay ){
        alert('Start date must be 48h in future!');
        return;
      }
      if (pretrazi.priceFrom <= 0 && pretrazi.priceFrom !== null){
        alert('PriceFrom must be positive!');
        return;
      }
      if (pretrazi.priceTo <= 0 && pretrazi.priceTo !== null){
        alert('PriceTo must be positive!');
        return;
      }
      if (pretrazi.traveledKm <= 0 && pretrazi.traveledKm !== null){
        alert('TraveledKm must be positive!');
        return;
      }
      if (pretrazi.plannedKm <= 0 && pretrazi.plannedKm !== null){
        alert('PlannedKm must be positive!');
        return;
      }
      if (pretrazi.numberOfSeats <= 0 && pretrazi.numberOfSeats !== null){
        alert('NumberOfSeats must be positive!');
        return;
      }
      if (pretrazi.mark <= 0 || pretrazi.mark >= 6  && pretrazi.mark !== null){
        alert('Marks must be from 1 to 5!');
        return;
      }

      // tslint:disable-next-line:max-line-length
      this.searchService.searchAdvancedAdverts(pretrazi.city, pretrazi.startOfAdvert, pretrazi.endOfAdvert, pretrazi.carMark, pretrazi.carModel, pretrazi.carFuelType, pretrazi.carTransmissionType, pretrazi.carClass, pretrazi.priceFrom, pretrazi.priceTo, pretrazi.traveledKm, pretrazi.plannedKm, pretrazi.insurance, pretrazi.numberOfSeats, pretrazi.mark)
        .subscribe(
          (response: Search[]) => {
            this.oglasi2 = response;
            console.log(this.oglasi2);
          }
        );
    } else {
      alert('Start date must be before end date !');
    }
  }

dateValidationStart(control) {
    const today = new Date();
    const startD = new Date(control.value);
    if ((+control.value.slice(0, -6)) < (+today.getFullYear())) {// ako je  godina uneta < manja od danasnje - ne moze
      console.log('godina nije dobra');
      return {startOfAdvert: false};
    }
    if ((+control.value.slice(0, -6)) === (+today.getFullYear())) {

      if (+control.value.slice(5, -3) < (+(today.getMonth() + 1))) {// da li je u istoj godini mesec uneti manji od danasnjeg - ne moze
        console.log('mesec nije dobar');
        return {startOfAdvert: false};
      }
      if (+control.value.slice(5, -3) === (+(today.getMonth() + 1))) {// ako je mesec isti proveri dan
        if (+control.value.slice(8, 10) < (+(today.getDate()))) {
          console.log('dan nije dobar');
          return {startOfAdvert: false};
        }
      }
    }
  }
  dateValidationEnd(control) {
    const today = new Date();
    today.setDate(today.getDate() + 1);
    if ((+control.value.slice(0, -6)) < (+today.getFullYear())) {// ako je  godina uneta < manja od danasnje - ne moze
      console.log('godina nije dobra');
      return {endOfAdvert: false};
    }
    if ((+control.value.slice(0, -6)) === (+today.getFullYear())) {

      if (+control.value.slice(5, -3) < (+(today.getMonth() + 1))) {// da li je u istoj godini mesec uneti manji od danasnjeg - ne moze
        console.log('mesec nije dobar');
        return {endOfAdvert: false};
      }
      if (+control.value.slice(5, -3) === (+(today.getMonth() + 1))) {// ako je mesec isti proveri dan
        if (+control.value.slice(8, 10) < (+(today.getDate()))) {
          console.log('dan nije dobar');
          return {endOfAdvert: false};
        }
      }
    }
  }

  // zakazuje najmanje 48h
  getTwoDaysForwardDate(): string {
    const today = new Date();
    today.setDate(today.getDate() + 2);

    const dd = today.getDate();
    const mm = today.getMonth() + 1; // January is 0!
    const yyyy = today.getFullYear();
    let pd = dd.toString();
    let pm = mm.toString();
    if ( dd < 10 ) {
      pd = '0' + dd;
    }
    if (mm < 10) {
      pm = '0' + mm ;
    }
    const todayStr = yyyy + '-' + pm + '-' + pd ;
    return todayStr;
  }


  // kraj mora biti 1 dan kasnije od akazivanja
  getThreeDaysForwardDate(): string {

    const today = new Date();
    today.setDate(today.getDate() + 3);

    const dd = today.getDate();
    const mm = today.getMonth() + 1; // January is 0!
    const yyyy = today.getFullYear();
    let pd = dd.toString();
    let pm = mm.toString();
    if ( dd < 10 ) {
      pd = '0' + dd;
    }
    if (mm < 10) {
      pm = '0' + mm ;
    }
    const todayStr = yyyy + '-' + pm + '-' + pd ;
    return todayStr;
  }

  sortirajCeneRastuce(){
    this.oglasi2.sort((a, b) => a.price - b.price);
  }

  sortirajCeneOpadajuce(){
    this.oglasi2.sort((a, b) => b.price - a.price);
  }

  sortirajOceneRastuce(){
    this.oglasi2.sort((a, b) => a.mark - b.mark);
  }

  sortirajOceneOpadajuce(){
    this.oglasi2.sort((a, b) => b.mark - a.mark);
  }

  sortirajKilometrazuRastuce(){
    this.oglasi2.sort((a, b) => a.traveledKm - b.traveledKm);
  }

  sortirajKilometrazuOpadajuce(){
    this.oglasi2.sort((a, b) => b.traveledKm - a.traveledKm);
  }

}

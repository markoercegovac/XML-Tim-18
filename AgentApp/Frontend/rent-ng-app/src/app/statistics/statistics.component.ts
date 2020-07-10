import { Component, OnInit } from '@angular/core';
import * as CanvasJS from './canvasjs.min';
import {Color, Label} from 'ng2-charts';
import {ChartDataSets, ChartOptions} from 'chart.js';
import {StatisticsService} from '../service/statistics.service';
import {Statistics} from '../model/statistics';
import {of} from 'rxjs';


@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

  lista: Statistics[];




  lineChartData: ChartDataSets[] = [
    { data: [850 , 50, 4.5], label: 'Car 1' },
  ];




  lineChartLabels: Label[] = ['Traveled KM', 'Comments', 'Mark'];

  lineChartOptions = {
    responsive: true,
  };

  lineChartColors: Color[] = [
    {
      borderColor: 'black',
      backgroundColor: 'rgba(255,255,0,0.28)',
    },
    {
      borderColor: 'black',
      backgroundColor: 'rgba(255,255,0,0.28)',
    },
    {
      borderColor: 'black',
      backgroundColor: 'rgba(255,255,0,0.28)',
    },
  ];

  lineChartLegend = true;
  lineChartPlugins = [];
  lineChartType = 'line';

  constructor(private statisticsService: StatisticsService) {}

  ngOnInit(): void {

    this.statisticsService.getStatistics().subscribe(
      data => {
        this.lista = data;
        console.log(this.lista);
        this.help();
      },
      error => {
        console.log('Error occured', error);
      }
    );

  }
  help(){
    let p;
    p = 0;
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.lista?.length; ++i){
      // tslint:disable-next-line:triple-equals
      if (this.lista[i].comment != 0){
        // tslint:disable-next-line:max-line-length
        this.lineChartData.push({ data: [this.lista[i].traveledKm, this.lista[i].comment, this.lista[i].mark] , label: this.lista[i].nameCar });
      }else{
        this.lineChartData.push({ data: [this.lista[i].traveledKm, 0, this.lista[i].mark] , label: this.lista[i].nameCar });
      }
      // tslint:disable-next-line:max-line-length

  }
}

}

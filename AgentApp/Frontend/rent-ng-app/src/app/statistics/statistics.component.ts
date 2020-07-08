import { Component, OnInit } from '@angular/core';
import * as CanvasJS from './canvasjs.min';
import {Color, Label} from 'ng2-charts';
import {ChartDataSets, ChartOptions} from 'chart.js';


@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

  lineChartData: ChartDataSets[] = [
    { data: [850, 72, 4.5], label: 'Car 1' },
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
  ];

  lineChartLegend = true;
  lineChartPlugins = [];
  lineChartType = 'line';

  constructor() {}

  ngOnInit(): void {
  }

}

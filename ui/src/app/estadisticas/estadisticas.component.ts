import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-estadisticas',
  templateUrl: './estadisticas.component.html',
  styleUrls: ['./estadisticas.component.css']
})
export class EstadisticasComponent implements OnInit {

  estadisticas: [{ }];



  constructor() { 
    this.estadisticas.push({
      titulo:'alohatitle',
      dato: 'otrodato'
    })
  }

  ngOnInit(): void {
  }

}

import { Component, OnInit } from '@angular/core';
import { ViajeService } from '../services/viaje.service';
import { Viaje } from '../model/viaje';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  showModal = false;
  viaje : Viaje;
  viajes : [];
  url = 'http://localhost:8080/viaje';
  constructor(private viajeService: ViajeService) { }

  ngOnInit(): void {
  }

  agregarViaje(x){
    this.viajeService.save(x);
  }
}

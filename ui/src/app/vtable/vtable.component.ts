import { Component, OnInit } from '@angular/core';
import { ViajeService } from '../services/viaje.service';
import { Viaje } from '../model/viaje';
import { SelectItem } from 'primeng';

@Component({
  selector: 'app-vtable',
  templateUrl: './vtable.component.html',
  styleUrls: ['./vtable.component.css']
})
export class VtableComponent implements OnInit {

  viajes: Viaje[];
  brands: SelectItem[];

  constructor(private viajeService: ViajeService) { }

  ngOnInit(): void {
    this.viajeService.findAll().subscribe(viajes => {
      this.viajes = viajes as Viaje[];
      this.getDatesFromFirstVuelo();
    });

    this.brands = [
      {label: 'Audi', value: 'Audi'},
      {label: 'BMW', value: 'BMW'},
      {label: 'Fiat', value: 'Fiat'},
      {label: 'Ford', value: 'Ford'},
      {label: 'Honda', value: 'Honda'},
      {label: 'Jaguar', value: 'Jaguar'},
      {label: 'Mercedes', value: 'Mercedes'},
      {label: 'Renault', value: 'Renault'},
      {label: 'VW', value: 'VW'},
      {label: 'Volvo', value: 'Volvo'}
    ];
  }

  getDatesFromFirstVuelo() {

  }

  // onRowEditInit(car: Car) {
  //   this.clonedCars[car.vin] = {...car};
  // }
  //
  // onRowEditSave(car: Car) {
  //   if (car.year > 0) {
  //     delete this.clonedCars[car.vin];
  //     this.messageService.add({severity:'success', summary: 'Success', detail:'Car is updated'});
  //   }
  //   else {
  //     this.messageService.add({severity:'error', summary: 'Error', detail:'Year is required'});
  //   }
  // }
  //
  // onRowEditCancel(car: Car, index: number) {
  //   this.cars2[index] = this.clonedCars[car.vin];
  //   delete this.clonedCars[car.vin];
  // }

}

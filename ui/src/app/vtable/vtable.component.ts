import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ViajeService } from '../services/viaje.service';
import { Viaje } from '../model/viaje';
import { SelectItem } from 'primeng';

@Component({
  selector: 'app-vtable',
  templateUrl: './vtable.component.html',
  styleUrls: ['./vtable.component.css']
})
export class VtableComponent implements OnInit {
  @Input() viaje : {};
  @Input() viajes: Viaje[];
  brands: SelectItem[];
  @Input() esViaje: boolean;
  @Input() esPlan: boolean;
  constructor(private viajeService: ViajeService) { }
  @Output() edicionViaje = new EventEmitter<object>();

  ngOnInit(): void {

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

  editarViaje(x){
    console.log("vTable",x)
    this.edicionViaje.emit(x);
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

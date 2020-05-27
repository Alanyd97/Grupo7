import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { ValueConverter } from '@angular/compiler/src/render3/view/template';
import { Viaje } from '../model/viaje';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {
  mostrarModal = false;
  viaje : Viaje;
  @Input() txtBoton : string;
  @Input() titulo : string;
  @Input() url : string;
  @Input() viajeAEditar : Viaje;
  @Output() editViaje = new EventEmitter<object>();
  @Output() datosViaje = new EventEmitter<object>();
  
  constructor() {
    this.viajeAEditar = new Viaje(0, new Date,new Date,[1], 'Nombre..', 'Turquia...', 'Descripcion..');
   }

  getDatos(nombre, destino, ida, vuelta, descripcion){
    this.viaje = new Viaje(1, ida.viewModel, vuelta.viewModel, [1], nombre.viewModel, destino.viewModel, descripcion.viewModel);
    this.mostrarModal = false;
    console.log(this.viaje);
    this.datosViaje.emit(this.viaje);
  }

  editarViaje(nombre, destino, ida, vuelta, descripcion){
    if (nombre){
      this.viajeAEditar.nombre = nombre;
    }
    if (destino){
      this.viajeAEditar.destino = destino;
    }
    if (ida){
      this.viajeAEditar.ida = ida;
    }
    if (vuelta){
      this.viajeAEditar.vuelta = vuelta;
    }
    if (descripcion){
      this.viajeAEditar.descripcion = descripcion;
    }
    this.viajeAEditar = new Viaje(1, ida.viewModel, vuelta.viewModel, [1], nombre.viewModel, destino.viewModel, descripcion.viewModel);
    this.editViaje.emit(this.viajeAEditar);
    


  }

  ngOnInit(): void {
  }

}

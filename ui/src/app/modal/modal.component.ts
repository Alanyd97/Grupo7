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
  @Output() editarViaje = new EventEmitter<object>();
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


  editar(){
    this.mostrarModal=true;
    console.log("modal: ", this.viajeAEditar);
  }
  ngOnInit(): void {
  }

}

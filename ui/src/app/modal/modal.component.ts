import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { ValueConverter } from '@angular/compiler/src/render3/view/template';
import { Viaje } from '../model/viaje';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {
  @Input() txtBoton : string;
  mostrarModal = false;
  @Input() url : string;
  constructor() { }
  viaje : Viaje;
  @Output() datosViaje = new EventEmitter<object>();

  getDatos(nombre, destino, ida, vuelta, descripcion){
    this.viaje = new Viaje(1, ida.viewModel, vuelta.viewModel, [1], nombre.viewModel, destino.viewModel, descripcion.viewModel);
    this.mostrarModal = false;
    console.log(this.viaje);
    this.datosViaje.emit(this.viaje);
  }

  ngOnInit(): void {
  }

}

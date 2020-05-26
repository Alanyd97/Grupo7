import { Component, OnInit, Input} from '@angular/core';
import { ValueConverter } from '@angular/compiler/src/render3/view/template';

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

  viaje = {
    'origen' : "",
    'destino' : "",
    'ida': "",
    'vuelta': ""
  }

  getDatos(origen, destino, ida, vuelta){
    this.mostrarModal = false;
    this.viaje.origen = origen.value;
    this.viaje.destino = destino.value;
    this.viaje.ida = ida.value;
    this.viaje.vuelta = vuelta.value;
    this.save(this.viaje);
  }

  save(n){
    

  }

  ngOnInit(): void {
  }

}

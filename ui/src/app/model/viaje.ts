export class Viaje {
  idViaje: Number;
  idUsuario: Number;
  ida: Date;
  vuelta: Date;
  vuelos: number[];

  constructor(idViaje: Number, idUsuario: Number, ida: Date, vuelta: Date, vuelos: number[]) {
    this.idViaje = idViaje;
    this.idUsuario = idUsuario;
    this.ida = ida;
    this.vuelta = vuelta;
    this.vuelos = vuelos;
  }
}

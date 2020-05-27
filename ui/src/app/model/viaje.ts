export class Viaje {
  idViaje: Number;
  usuarioId: Number;
  ida: Date;
  vuelta: Date;
  vuelosIds: number[];
  nombre: string;
  destino: string;
  descripcion: string;

  constructor(usuarioId: Number, ida: Date, vuelta: Date, vuelosIds: number[], nombre: string, destino: string, descripcion: string) {
    this.usuarioId = usuarioId;
    this.ida = ida;
    this.vuelta = vuelta;
    this.vuelosIds = vuelosIds;
    this.nombre = nombre;
    this.destino = destino;
    this.descripcion = descripcion;
  }
}

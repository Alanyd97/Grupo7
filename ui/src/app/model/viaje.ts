export class Viaje {
  idViaje: Number;
  usuarioId: Number;
  ida: Date;
  vuelta: Date;
  vuelosIds: number[];
  origen: string;
  destino: string;

  constructor( usuarioId: Number, ida: Date, vuelta: Date, vuelosIds: number[], origen: string, destino: string) {
    this.usuarioId = usuarioId;
    this.ida = ida;
    this.vuelta = vuelta;
    this.vuelosIds = vuelosIds;
    this.origen = origen;
    this.destino = destino;
  }
}

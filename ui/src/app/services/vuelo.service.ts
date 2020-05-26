import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VueloService {

  URL = 'http://localhost:8080/vuelo'

  constructor(private httpClient: HttpClient) { }

  findById(id:number) {
    return this.httpClient.get(this.URL + "/" + id);
  }
}

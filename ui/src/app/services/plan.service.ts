import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Plan } from '../model/plan';

@Injectable({
  providedIn: 'root'
})
export class PlanService {

  URL = 'http://localhost:8080/plan';

  constructor(private httpClient: HttpClient) { }

  findAll() {
    return this.httpClient.get(this.URL);
  }

  findById(id:number) {
    return this.httpClient.get(this.URL + "/" + id);
  }

  save(json: Plan) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.httpClient.post(this.URL, json, httpOptions);
  }

  update(json : Plan){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.httpClient.put(this.URL, json, httpOptions);
  }
}
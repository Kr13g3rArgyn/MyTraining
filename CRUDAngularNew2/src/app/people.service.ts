import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {People} from "./people";

@Injectable({
  providedIn: 'root'
})
export class PeopleService {
  private apiUrl = "http://localhost:8080/api";
  constructor(private httpClient: HttpClient) {
  }
  getEmployeeList(): Observable<People[]>{
    return this.httpClient.get<People[]>(`${this.apiUrl}`);
  }
  createPerson(person:People): Observable<Object>{
    return this.httpClient.post(`${this.apiUrl}/create`,person);
  }
  getEmployeeById(id: number): Observable<People>{
    return this.httpClient.get<People>(`${this.apiUrl}/${id}`);
  }

  updateEmployee(id: number, employee: People): Observable<Object>{
    return this.httpClient.put(`${this.apiUrl}/update/${id}`, employee);
  }

  deleteEmployee(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.apiUrl}/delete/${id}`);
  }
}
